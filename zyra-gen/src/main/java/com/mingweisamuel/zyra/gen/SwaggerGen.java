package com.mingweisamuel.zyra.gen;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.lang.model.element.Modifier;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SwaggerGen {

    /** URL to pull swagger json from. */
    public static final String URL = "http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json";

    /** Destination to write classes to. */
    private static final File SOURCE_DESTINATION = new File("src.main.gen.".replace(".", File.separator));
    /** Package to write classes into. */
    private static final String PACKAGE = "com.mingweisamuel.zyra";

    private static final ImmutableList<String> HTTP_METHODS = ImmutableList.<String>builder()
        .add("get").add("put").add("post").add("delete")
        .add("options").add("head").add("patch").add("trace").build();

    /** Human readable timestamp string. */
    public static final String TIMESTAMP = Calendar.getInstance().getTime().toString();

    public static void main(String... args) {
        if (SOURCE_DESTINATION.exists() && !delete(SOURCE_DESTINATION))
            throw new IllegalStateException("Failed to delete old files.");
        if (!SOURCE_DESTINATION.mkdirs())
            throw new IllegalStateException("Failed to recreate source folder");

        int attempts = 0;
        while (true) {
            try {
                java.net.URL url = new URL(URL);
                InputStreamReader reader = new InputStreamReader(url.openStream());
                JsonReader jsonReader = Json.createReader(reader);
                SwaggerGen.compile(new SwaggerGen(jsonReader.readObject()));
                break;
            }
            catch (FileNotFoundException e) {
                if (attempts++ >= 5) {
                    System.err.println("Failed after " + attempts + " tries.");
                    e.printStackTrace(System.err);
                    System.exit(1);
                    return;
                }
            }
            catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private final JsonObject swagger;
    public SwaggerGen(JsonObject swagger) {
        if (!swagger.getString("openapi").startsWith("3."))
            throw new IllegalStateException("Unknown swagger version " + swagger.getString("openapi") + ".");
        this.swagger = swagger;
    }

    public static void compile(SwaggerGen swaggerGen) throws InterruptedException {

        List<CompletableFuture<?>> finalFutures = new LinkedList<>();
        finalFutures.add(CompletableFuture.supplyAsync(new PackageInfo()));

        // MAP INDIVIDUAL PATHS TO METHODS.
        JsonObject paths = swaggerGen.swagger.getJsonObject("paths");
        ConcurrentMap<String, ConcurrentLinkedQueue<MethodSpec>> endpointPaths = new ConcurrentHashMap<>();
        CompletableFuture<ConcurrentMap<String, ConcurrentLinkedQueue<MethodSpec>>> endpointPathsFuture =
            CompletableFuture.allOf(paths.entrySet().stream()
                .map(pathEntry -> CompletableFuture.supplyAsync(() -> {
                    String pathKey = pathEntry.getKey();
                    JsonObject pathObj = pathEntry.getValue().asJsonObject();
                    String endpoint = pathObj.getString("x-endpoint");
                    List<MethodSpec> result = HTTP_METHODS.stream()
                        .filter(pathObj::containsKey)
                        .flatMap(method -> new Path(pathKey, method, pathObj.getJsonObject(method)).get().stream())
                        .collect(Collectors.toList());
                    endpointPaths.computeIfAbsent(endpoint, e -> new ConcurrentLinkedQueue<>())
                        .addAll(result);
                    return null;
                }))
                .toArray(CompletableFuture[]::new))
                .thenApply(v -> endpointPaths);

        // WRITE SCHEMAS.
        JsonObject schemas = swaggerGen.swagger.getJsonObject("components").getJsonObject("schemas");
        List<CompletableFuture<TypeSpec>> schemaFutures = schemas
            .entrySet().stream()
            .filter(schemaEntry -> !"Error".equals(schemaEntry.getKey()))
            .map(schemaEntry ->
                CompletableFuture.supplyAsync(new Schema(schemaEntry.getKey(), schemaEntry.getValue().asJsonObject())))
            .collect(Collectors.toList());
        finalFutures.addAll(schemaFutures);

        // MAKE ENDPOINTS.
        finalFutures.add(endpointPathsFuture.thenAccept(m -> m.entrySet().parallelStream()
            .forEach(endpointEntry -> new Endpoint(endpointEntry.getKey(), endpointEntry.getValue()).get())));

        // Write package-info.java for each endpoint (key).
        finalFutures.add(endpointPathsFuture.thenAccept(m -> m.keySet().parallelStream()
            .forEach(endpoint -> new EndpointPackageInfo(endpoint).get())));

        // Get errors.
        finalFutures.forEach(CompletableFuture::join);
    }

    private static class Endpoint implements Supplier<Void> {
        private final String name;
        private final Collection<MethodSpec> methods;
        public Endpoint(String name, Collection<MethodSpec> methods) {
            this.name = name;
            this.methods = methods;
        }

        @Override
        public Void get() {
            String normalizedName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, normalizeEndpointPackage(name));
            TypeSpec.Builder typeBuilder = TypeSpec.classBuilder(normalizedName + "Endpoints");
            typeBuilder.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
            typeBuilder.superclass(ClassName.bestGuess("com.mingweisamuel.zyra.Endpoints"));
            typeBuilder.addJavadoc(name + " endpoints.<br>");
            typeBuilder.addJavadoc("\nThis class is automatically generated and should not be modified directly.\n");
            AnnotationSpec.Builder suppressWarningsBuilder = AnnotationSpec.builder(SuppressWarnings.class);
            suppressWarningsBuilder.addMember("value", "{$S, $S, $S}",
                "unused", "SameParameterValue", "SpellCheckingInspection");
            typeBuilder.addAnnotation(suppressWarningsBuilder.build());

            MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();
            constructorBuilder.addParameter(
                ClassName.bestGuess("com.mingweisamuel.zyra.RiotApi"), "riotApi", Modifier.FINAL);
            constructorBuilder.addCode("super(riotApi);\n");
            typeBuilder.addMethod(constructorBuilder.build());

            methods.forEach(typeBuilder::addMethod);

            TypeSpec typeSpec = typeBuilder.build();
            JavaFile javaFile = JavaFile.builder(PACKAGE, typeSpec).build();
            try {
                javaFile.writeTo(SOURCE_DESTINATION);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    /**
     * Returns a List because we overload for optional parameters.
     */
    private static class Path implements Supplier<List<MethodSpec>> {

        private final String path;
        private final String method;
        private final JsonObject operationObj;

        private final StringBuilder docstringBuilder = new StringBuilder();
        private volatile String methodId;
        private volatile String pack;
        private volatile String name;
        private volatile TypeName returnType;
        private volatile boolean nonRateLimited = false;

        private final List<Param> pathParams = new LinkedList<>();
        private final List<Param> requiredParams = new LinkedList<>();
        private final List<Param> optionalParams = new LinkedList<>();

        Path(String path, String method, JsonObject operationObj) {
            this.path = path;
            this.method = method;
            this.operationObj = operationObj;
        }

        @Override
        public List<MethodSpec> get() {
            if (!"get".equals(method)) // TODO: Currently only "get" is supported.
                return Collections.emptyList();
            methodId = operationObj.getString("operationId");
            int dot = methodId.indexOf('.');
            this.pack = normalizeEndpointPackage(methodId.substring(0, dot));
            this.name = methodId.substring(dot + 1);

            // GET RETURN TYPE.
            try {
                returnType = getTypeName(
                    operationObj
                        .getJsonObject("responses").getJsonObject("200")
                        .getJsonObject("content").getJsonObject("application/json").getJsonObject("schema"))
                    .box();
            }
            catch (NullPointerException e) {
                return null;
            }
            // NON RATE LIMITED?
            this.nonRateLimited = operationObj.containsKey("x-app-rate-limit-excluded") &&
                operationObj.getBoolean("x-app-rate-limit-excluded");

            // PARAMETER LISTS.
            if (operationObj.containsKey("parameters")) {
                operationObj.getJsonArray("parameters").stream()
                    .map(JsonValue::asJsonObject)
                    .forEach(paramObj -> {
                        Param param = new Param(paramObj);
                        if ("path".equals(paramObj.getString("in")))
                            pathParams.add(param);
                        else if (paramObj.getBoolean("required"))
                            requiredParams.add(param);
                        else
                            optionalParams.add(param.boxed());
                    });
            }

            // SORT OPTIONAL PARAMETERS IF APPLICABLE.
            String endpointsNormalizedName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, this.pack);
            List<String> order = PARAM_OPT_ORDERS.get(endpointsNormalizedName + '.' + name);
            if (order == null)
                order = PARAM_OPT_ORDERS.get(endpointsNormalizedName + ".*");
            if (order != null) {
                final List<String> order2 = order;
                optionalParams.sort(Comparator.comparingInt(p -> order2.indexOf(p.name)));
                if (!optionalParams.isEmpty() && !order.contains(optionalParams.get(0).name))
                    throw new NoSuchElementException("Name missing: " + optionalParams.get(0).name);
            }

            // DOCSTRING.
            if (operationObj.containsKey("description"))
                docstringBuilder.append(operationObj.getString("description")).append("\n\n");
            String url = operationObj.getJsonObject("externalDocs").getString("url");
            docstringBuilder.append(String.format("<a href=\"%s\">%s</a><br>\n", url, "Link to Portal"));

            // MAKE A METHOD FOR EACH SUBLIST OF OPTIONAL PARAMETERS.
            return IntStream.rangeClosed(0, optionalParams.size())
                .mapToObj(end -> optionalParams.subList(0, end))
                .flatMap(optParams -> createMethodSpec(optionalParams.size(),
                    pathParams, requiredParams, optParams).stream())
                .collect(Collectors.toList());
        }

        private List<MethodSpec> createMethodSpec(int totalOptionalParams,
                List<Param> pathParams, List<Param> requiredParams, List<Param> optionalParams) {

            MethodSpec.Builder builderSync = MethodSpec.methodBuilder(name);
            builderSync.addModifiers(Modifier.PUBLIC);
            builderSync.returns(returnType);
            builderSync.addComment(
                "This method is automatically generated and should not be modified directly.");
            builderSync.addJavadoc(docstringBuilder.toString());

            MethodSpec.Builder builderAsync = MethodSpec.methodBuilder(name + "Async");
            builderAsync.addModifiers(Modifier.PUBLIC);
            builderAsync.returns(ParameterizedTypeName.get(
                ClassName.get(CompletableFuture.class), returnType));
            builderAsync.addComment(
                "This method is automatically generated and should not be modified directly.");
            builderAsync.addJavadoc(docstringBuilder.toString());

            StringBuilder code = new StringBuilder("(");

            // region param
            TypeName regionType = ClassName.bestGuess("com.mingweisamuel.zyra.enums.Region");
            builderSync.addParameter(ParameterSpec.builder(regionType, "region", Modifier.FINAL).build());
            builderSync.addJavadoc("@param region Region to execute against.\n");
            builderAsync.addParameter(ParameterSpec.builder(regionType, "region", Modifier.FINAL).build());
            builderAsync.addJavadoc("@param region Region to execute against.\n");
            code.append("region, ");

            for (int i = 0; i < 2; i++) {
                // TO PREVENT DUPLICATE CODE FOR REQUIRED & NOT REQUIRED.
                Iterable<Param> params;
                boolean required;
                if (0 == i) {
                    params = Iterables.concat(pathParams, requiredParams);
                    required = true;
                }
                else {
                    params = optionalParams;
                    required = false;
                }
                // LOOP OVER PARAMS.
                for (Param param : params) {

                    builderSync.addParameter(param.getParameterSpec());
                    builderSync.addJavadoc("@param $L ($L) $L\n",
                        param.name, required ? "required" : "optional", param.desc);
                    builderAsync.addParameter(param.getParameterSpec());
                    builderAsync.addJavadoc("@param $L ($L) $L\n",
                        param.name, required ? "required" : "optional", param.desc);
                    code.append(param.name).append(", ");
                }
            }
            for (int i = optionalParams.size(); i < totalOptionalParams; i++)
                code.append("null, ");
            code.setLength(code.length() - 2);
            code.append(");\n");

            if (optionalParams.size() == totalOptionalParams) {
                CodeBlock urlCode = getUrlCode();
                CodeBlock gsonTypeCode = getGsonTypeCode();
                // MAKE METHOD BODY.
                builderSync.addCode("$T url = $L;\n", String.class, urlCode);
                builderSync.addCode("$T type = $L;\n", Type.class, gsonTypeCode);
                builderAsync.addCode("$T url = $L;\n", String.class, urlCode);
                builderAsync.addCode("$T type = $L;\n", Type.class, gsonTypeCode);
                String optParamsStr = buildOptionalParams();
                if (optParamsStr.isEmpty()) {
                    builderSync.addCode("return riotApi.getBasic$L($S, url, region, type, $T.emptyList());\n",
                        nonRateLimited ? "NonRateLimited" : "", methodId, Collections.class);
                    builderAsync.addCode(
                        "return riotApi.getBasic$LAsync($S, url, region, type, $T.emptyList());\n",
                        nonRateLimited ? "NonRateLimited" : "", methodId, Collections.class);
                }
                else {
                    builderSync.addCode(
                        "return riotApi.getBasic$L($S, url, region, type, riotApi.makeParams($L));\n",
                        nonRateLimited ? "NonRateLimited" : "", methodId, optParamsStr);
                    builderAsync.addCode(
                        "return riotApi.getBasic$LAsync($S, url, region, type, riotApi.makeParams($L));\n",
                        nonRateLimited ? "NonRateLimited" : "", methodId, optParamsStr);
                }
            }
            else {
                builderSync.addCode("return this." + name + code.toString());
                builderAsync.addCode("return this." + name + "Async" + code.toString());
            }

            return ImmutableList.of(builderSync.build(), builderAsync.build());
        }

        // ONE-OFF HELPERS.
        private CodeBlock getGsonTypeCode() {
            if (returnType instanceof ParameterizedTypeName) {
                TypeSpec typeTokenType = TypeSpec.anonymousClassBuilder("").addSuperinterface(ParameterizedTypeName.get(
                    ClassName.bestGuess("com.google.gson.reflect.TypeToken"), returnType)).build();
                return CodeBlock.of("$L.getType()", typeTokenType);
            }
            return CodeBlock.of("$T.class", returnType);
        }
        private CodeBlock getUrlCode() {
            String pathNormalized = path
                .replaceFirst("\\{\\S+?}", "%1\\$s")
                .replaceFirst("\\{\\S+?}", "%2\\$s");

            if (path.equals(pathNormalized))
                return CodeBlock.of("$S", path);

            StringBuilder argsBuilder = new StringBuilder();
            for (Param param : pathParams) {
                argsBuilder.append(", ").append(param.name);
            }

            return CodeBlock.of("String.format($S$L)", pathNormalized, argsBuilder.toString());
        }
        private String buildOptionalParams() {
            StringBuilder paramsBuilder = new StringBuilder();
            if (!optionalParams.isEmpty()) {
                for (Param param : optionalParams)
                    paramsBuilder.append("\"").append(param.name)
                        .append("\", ").append(param.name).append(", ");
                paramsBuilder.setLength(paramsBuilder.length() - 2);
            }
            return paramsBuilder.toString();
        }
    }

    private static class Schema implements Supplier<TypeSpec> {
        private final String pack;
        private final String name;
        private final JsonObject schemaObj;
        Schema(String key, JsonObject schemaObj) {
            int dot = key.indexOf('.');
            this.pack = normalizeEndpointPackage(key.substring(0, dot));
            this.name = normalizeDtoName(key.substring(dot + 1));
            this.schemaObj = schemaObj;
        }

        @Override
        public TypeSpec get() {
            // Boilerplate.
            TypeSpec.Builder builder = TypeSpec.classBuilder(name);
            builder.addModifiers(Modifier.PUBLIC);
            builder.addSuperinterface(Serializable.class);
            builder.addJavadoc(name + ".<br><br>\n\n");

            if (schemaObj.containsKey("description"))
                builder.addJavadoc(schemaObj.getString("description") + ".<br><br>\n\n");
            builder.addJavadoc(String.format("This class was automatically generated from the " +
                "<a href=\"%s\">Riot API reference</a>.", URL));

            // Prep constructor, .equals(), and .hashCode().
            ClassName guavaObjectsName = ClassName.bestGuess("com.google.common.base.Objects");
            MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC);
            CodeBlock.Builder equalsCode = CodeBlock.builder()
                .addStatement("if (obj == this) return true")
                .addStatement("if (!(obj instanceof $L)) return false", name)
                .addStatement("final $1L other = ($1L) obj", name)
                .add("return true").indent().indent();
            CodeBlock.Builder hashCodeCode = CodeBlock.builder()
                .add("return $T.hashCode(0", guavaObjectsName).indent().indent();

            schemaObj.getJsonObject("properties").entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEachOrdered(prop -> {
                    String propName = prop.getKey();
                    JsonObject propObj = prop.getValue().asJsonObject();

                    TypeName propType;
                    String dtoCanonicalName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, pack)
                        + '.' + name + '.' + propName;
                    if (FIELD_TYPES.containsKey(dtoCanonicalName))
                        propType = FIELD_TYPES.get(dtoCanonicalName);
                    else
                        propType = getTypeName(propObj);
                    // make championIds ints.
                    if ("championId".equals(propName) && TypeName.LONG.equals(propType))
                        propType = TypeName.INT;

                    String propDesc = propObj.containsKey("description")
                        ? propObj.getString("description") : null;

                    FieldSpec.Builder fieldBuilder = FieldSpec.builder(propType, propName, Modifier.PUBLIC, Modifier.FINAL);

                    if (null != propDesc)
                        fieldBuilder.addJavadoc(propDesc);
                    builder.addField(fieldBuilder.build());

                    // update constructor
                    constructorBuilder.addParameter(propType, propName, Modifier.FINAL)
                        .addStatement("this.$1L = $1L", propName);

                    // update .equals() and .hashCode()
                    equalsCode.add("\n&& $1T.equal($2L, other.$2L)", guavaObjectsName, propName);
                    hashCodeCode.add(",\n$L", propName);
                });

            // add constructor
            builder.addMethod(constructorBuilder.build());

            // prep and add .equals() and .hashCode().
            equalsCode.add(";").unindent().unindent();
            hashCodeCode.add(");").unindent().unindent();

            builder.addMethod(MethodSpec.methodBuilder("equals")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.BOOLEAN)
                .addParameter(Object.class, "obj", Modifier.FINAL)
                .addAnnotation(Override.class)
                .addCode(equalsCode.build()).build());
            builder.addMethod(MethodSpec.methodBuilder("hashCode")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.INT)
                .addAnnotation(Override.class)
                .addCode(hashCodeCode.build()).build());

            // build dto, write to file
            TypeSpec spec = builder.build();
            JavaFile javaFile = JavaFile.builder(PACKAGE + '.' + pack, spec).build();
            try {
                javaFile.writeTo(SOURCE_DESTINATION);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return spec;
        }
    }

    private static class PackageInfo implements Supplier<Void> {
        @Override
        public Void get() {
            File packageDir = new File(SOURCE_DESTINATION, PACKAGE.replace(".", File.separator));
            //noinspection ResultOfMethodCallIgnored
            packageDir.mkdirs();
            try (PrintWriter packageInfo = new PrintWriter(new File(packageDir, "package-info.java"))) {
                packageInfo.print("/**\n" +
                    " * Contains core elements of the Zyra library, such as {@link com.mingweisamuel.zyra.RiotApi} and all of the endpoint\n" +
                    " * sets.<br><br>\n" +
                    " *\n" +
                    " * {@link com.mingweisamuel.zyra.util} Contains general utilities used internally.<br>\n" +
                    " * {@link com.mingweisamuel.zyra.enums} Contains general static classes and enums useful for interacting with the\n" +
                    " * Riot API.<br><br>\n" +
                    " *\n" +
                    " * The remaining sub-packages contain generated DTO classes returned by their respective endpoint set. For example,\n" +
                    " * methods in {@link com.mingweisamuel.zyra.MatchEndpoints} will return classes from the package\n" +
                    " * {@link com.mingweisamuel.zyra.match}.<br><br>\n" +
                    " *\n" +
                    " * The API was last automatically generated from the\n" +
                    " * <a href=\"http://www.mingweisamuel.com/riotapi-schema/tool/\">Unofficial Riot API OpenAPI Spec</a>\n" +
                    " * on ");
                packageInfo.print(TIMESTAMP);
                packageInfo.println(".\n" +
                    " */\n" +
                    "package com.mingweisamuel.zyra;");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    private static class EndpointPackageInfo implements Supplier<Void> {
        private final String endpoint;
        EndpointPackageInfo(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public Void get() {
            String endpointPackage = normalizeEndpointPackage(endpoint);
            File dtoDir = new File(
                new File(SOURCE_DESTINATION, PACKAGE.replace(".", File.separator)),
                endpointPackage);
            //noinspection ResultOfMethodCallIgnored
            dtoDir.mkdir();

            try (PrintWriter packageInfo = new PrintWriter(new File(dtoDir, "package-info.java"))) {
                packageInfo.println("/**");
                packageInfo.print(" * DTOs for ");
                packageInfo.print(endpoint);
                packageInfo.println(".<br>");
                packageInfo.println(" * These DTOs are automatically generated and should not be modified directly.");
                packageInfo.println(" */");
                packageInfo.print("package ");
                packageInfo.print(PACKAGE + '.' + endpointPackage);
                packageInfo.println(';');
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    private static class Param {
        final String name;
        final String desc;
        final TypeName type;
        Param(JsonObject param) {
            this(param.getString("name"),
                param.containsKey("description") ? param.getString("description") : null,
                getTypeName(param.getJsonObject("schema")));
        }
        Param(String name, String desc, TypeName type) {
            this.name = name;
            this.desc = desc;
            this.type = type;
        }
        ParameterSpec getParameterSpec() {
            return ParameterSpec.builder(type, name, Modifier.FINAL).build();
        }
        Param boxed() {
            return new Param(name, desc, type.box());
        }
    }

    /** Normalizes a endpointsNormalizedName of an endpoint (or dto ..?). */
    private static String normalizeEndpointPackage(String name) {
        name = name.toLowerCase().replaceFirst("-v\\d+(?:\\.\\d+)?", "");
        name = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, name);
        return name;
    }
    private static String normalizeDtoName(String name) {
        return name.toLowerCase().endsWith("dto") ? name.substring(0, name.length() - 3) : name;
    }

    private static TypeName getTypeName(JsonObject schema) {
        if (schema.containsKey("$ref")) {
            String ref = schema.getString("$ref");
            String key = ref.replaceAll("^#/components/schemas/", "");
            int dot = key.indexOf('.');
            String pack = normalizeEndpointPackage(key.substring(0, dot));
            String name = normalizeDtoName(key.substring(dot + 1));
            return ClassName.bestGuess(PACKAGE + '.' + pack + '.' + name);
        }
        if (schema.containsKey("anyOf")) {
            return getTypeName(schema.getJsonArray("anyOf").getJsonObject(0));
        }
        if (schema.containsKey("type")) {
            switch (schema.getString("type")) {
            case "boolean":
                return ClassName.BOOLEAN;
            case "integer":
                switch(schema.getString("format")) {
                case "int32":
                    return ClassName.INT;
                case "int64":
                    return ClassName.LONG;
                }
                break;
            case "number":
                if ("double".equals(schema.getString("format")))
                    return ClassName.DOUBLE;
                break;
            case "string":
                return ClassName.get(String.class);
            case "array":
                TypeName nested = getTypeName(schema.getJsonObject("items"));
                return ParameterizedTypeName.get(ClassName.get(List.class), nested.box());
            case "object":
                TypeName key = getTypeName(schema.getJsonObject("x-key"));
                TypeName value = getTypeName(schema.getJsonObject("additionalProperties"));
                return ParameterizedTypeName.get(ClassName.get(Map.class), key.box(), value.box());
            }
        }
        throw new IllegalStateException("Cannot guess type: " + schema);
    }

    private static boolean delete(File dir) {
        if (!dir.isDirectory())
            return dir.delete();
        boolean result = true;
        File[] files = dir.listFiles();
        if (files == null)
            return false;
        for (File file : files)
            result &= delete(file);
        return result & dir.delete();
    }

    /** Method param orders. */
    private static final Map<String, List<String>> PARAM_OPT_ORDERS = new HashMap<>();
    static {
        PARAM_OPT_ORDERS.put("Match.getMatchlist", Arrays.asList("queue", "beginTime", "endTime", "champion", "season",
            "beginIndex", "endIndex"));
        PARAM_OPT_ORDERS.put("LolStaticData.*", Arrays.asList("id", "tags", "dataById", "locale", "version"));
    }

    /** DTO field type overrides. */
    private static final Map<String, TypeName> FIELD_TYPES = new HashMap<>();
    static {
        FIELD_TYPES.put("LolStaticData.ChampionSpell.effect", ParameterizedTypeName.get(ClassName.get(List.class),
            ParameterizedTypeName.get(List.class, Double.class)));
        FIELD_TYPES.put("LolStaticData.ChampionSpell.range", ParameterizedTypeName.get(List.class, Integer.class));
        FIELD_TYPES.put("LolStaticData.SummonerSpell.effect", ParameterizedTypeName.get(ClassName.get(List.class),
            ParameterizedTypeName.get(List.class, Double.class)));
        FIELD_TYPES.put("LolStaticData.SummonerSpell.range", ParameterizedTypeName.get(List.class, Integer.class));
        // Map<String, Item> -> Map<Integer, Item>
        FIELD_TYPES.put("LolStaticData.ItemList.data",
            ParameterizedTypeName.get(ClassName.get(Map.class),TypeName.INT.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.Item")));
        // Map<String, Boolean> -> Map<Integer, Boolean>
        FIELD_TYPES.put("LolStaticData.Item.maps", ParameterizedTypeName.get(Map.class, Integer.class, Boolean.class));
        // Map<String, MapDetails> -> Map<Integer, MapDetails>
        FIELD_TYPES.put("LolStaticData.MapData.data",
            ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.LONG.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.MapDetails")));
        // Map<String, Mastery> -> Map<Integer, Mastery>
        FIELD_TYPES.put("LolStaticData.MasteryList.data",
            ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.INT.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.Mastery")));
        // Map<String, Rune> -> Map<Integer, Rune>
        FIELD_TYPES.put("LolStaticData.RuneList.data",
            ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.INT.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.Rune")));
        // Map<String, SummonerSpell> -> Map<Integer, SummonerSpell>
        FIELD_TYPES.put("LolStaticData.SummonerSpellList.data", ParameterizedTypeName.get(ClassName.get(Map.class),
            TypeName.INT.box(), ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.SummonerSpell")));
        // Map<String, ProfileIconDetails> -> Map<Long, ProfileIconDetails>
        FIELD_TYPES.put("LolStaticData.ProfileIconData.data", ParameterizedTypeName.get(ClassName.get(Map.class),
            TypeName.LONG.box(), ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.ProfileIconDetails")));
    }
}
