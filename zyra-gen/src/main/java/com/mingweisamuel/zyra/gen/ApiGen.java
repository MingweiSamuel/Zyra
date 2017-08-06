package com.mingweisamuel.zyra.gen;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.javapoet.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.lang.model.element.Modifier;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Generates the API code from the online API reference HTML.
 */
public class ApiGen {

    public static final String timestamp = Calendar.getInstance().getTime().toString();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String... args) throws IOException {

        if (!delete(SOURCE_DESTINATION))
            throw new IllegalStateException("Failed to delete old files.");
        if (!SOURCE_DESTINATION.mkdirs())
            throw new IllegalStateException("Failed to recreate source folder");


        Document doc = Jsoup.connect("https://developer.riotgames.com/api-methods").get();
        Elements apiOptionElements = doc.getElementsByClass("api_option");
        //apiOptionElements.stream().map(Element::ownText).forEach(System.out::println);

        for (Element apiOptionElement : apiOptionElements) {

            HashMap<String, String> json;

            int attempts = 0;
            while (true) {
                URL url = new URL("https://developer.riotgames.com/api-details/" + apiOptionElement.ownText());
                try {
                    InputStreamReader reader = new InputStreamReader(url.openStream());
                    json = new Gson().fromJson(reader, new TypeToken<HashMap<String, String>>() {}.getType());
                    break;
                }
                catch (FileNotFoundException e) {
                    if (attempts++ >= 5)
                        throw new RuntimeException("Failed after " + attempts + " tries.", e);
                }
            }

            String rawName = apiOptionElement.ownText();
            String normalizedName = normalizeEndpointName(rawName);
            if (IGNORED_ENDPOINTSS.contains(normalizedName) || !rawName.endsWith("v3"))
                continue;

            ApiGen gen = new ApiGen(json.get("html"), rawName, normalizedName);
            gen.compile();
        }

        try {
            File packageDir = new File(SOURCE_DESTINATION, PACKAGE.replace(".", File.separator));

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
                    " * The API was last automatically generated from the <a href=\"https://developer.riotgames.com/api-methods/\">Riot API reference</a>\n" +
                    " * on ");
                packageInfo.print(timestamp);
                packageInfo.println(".\n" +
                    " */\n" +
                    "package com.mingweisamuel.zyra;");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final String html;
    private final String url;
    private final String endpointsRawName;
    private final String endpointsNormalizedName;
    private final String dtoPackage;

    private final Set<String> processedDtos = new HashSet<>();

    /**
     * Represents an ENDPOINT*S*
     * @param html
     * @param endpointsRawName
     * @param endpointsNormalizedName
     */
    public ApiGen(String html, String endpointsRawName, String endpointsNormalizedName) {
        this.html = html;
        this.url = "https://developer.riotgames.com/api-methods/#" + endpointsRawName;
        this.endpointsRawName = endpointsRawName;
        this.endpointsNormalizedName = endpointsNormalizedName;
        this.dtoPackage = PACKAGE + '.' + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, endpointsNormalizedName);
    }

    public void compile() {
        Document apiDoc = Jsoup.parse(html);
        TypeSpec.Builder typeBuilder = TypeSpec.classBuilder(endpointsNormalizedName + "Endpoints");
        typeBuilder.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        typeBuilder.superclass(ClassName.bestGuess("com.mingweisamuel.zyra.Endpoints"));
        typeBuilder.addJavadoc(endpointsRawName + " endpoints.<br>");
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

        System.out.printf("%s (%s)%n", endpointsRawName, endpointsNormalizedName);

        Elements endpoints = apiDoc.getElementsByClass("operation");
        List<EndpointGen> endpointGens = endpoints.stream().map(EndpointGen::new)
            .filter(eg -> !IGNORED_ENDPOINTS.contains(endpointsNormalizedName + '.' + eg.methodName))
            .collect(Collectors.toList());
        endpointGens.stream().map(EndpointGen::compile).flatMap(List::stream).forEach(typeBuilder::addMethod);

        TypeSpec typeSpec = typeBuilder.build();
        JavaFile javaFile = JavaFile.builder(PACKAGE, typeSpec).build();
        try {
            javaFile.writeTo(SOURCE_DESTINATION);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            File dtoDir = new File(new File(SOURCE_DESTINATION, PACKAGE.replace(".", File.separator)),
                CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, endpointsNormalizedName));

            try (PrintWriter packageInfo = new PrintWriter(new File(dtoDir, "package-info.java"))) {
                packageInfo.println("/**");
                packageInfo.print(" * DTOs for ");
                packageInfo.print(this.endpointsRawName);
                packageInfo.println(".<br>");
                packageInfo.println(" * These DTOs are automatically generated and should not be modified directly.");
                packageInfo.println(" */");
                packageInfo.print("package ");
                packageInfo.print(this.dtoPackage);
                packageInfo.println(';');
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private class EndpointGen {

        private final Element endpoint;
        private final String methodName;
        private final String methodId;
        private final String requestUrl;
        private final String url;
        private final String description;
        private final boolean nonRateLimited;

        private TypeName returnType = null;
        private final StringBuilder docstringBuilder = new StringBuilder();

        private final List<EndpointParameter> endpointParametersPath = new LinkedList<>();
        private final List<EndpointParameter> endpointParametersReq = new LinkedList<>();
        private final List<EndpointParameter> endpointParametersOpt = new LinkedList<>();

        public EndpointGen(Element endpoint) {
            this.endpoint = endpoint;
            this.methodName = endpoint.id().substring(1);
            this.methodId = endpoint.child(1).id();
            this.requestUrl = endpoint.child(0).child(1).child(0).ownText();
            this.nonRateLimited = NON_RATE_LIMITED_ENDPOINTSS.contains(endpointsNormalizedName);

            Element header = endpoint.child(0).child(2).child(0).child(0);
            this.url = "https://developer.riotgames.com/api-methods/" +
                header.attr("href");
            this.description = header.ownText();
            if (!description.isEmpty())
                docstringBuilder.append(description).append("\n\n");
            docstringBuilder.append(String.format("<a href=\"%s\">%s</a><br>\n", url, "Link to Portal"));
        }

        public List<MethodSpec> compile() {
            System.out.printf("    %s: %s (%s)%n", methodName, description, url);

            Elements apiBlocks = endpoint.getElementsByClass("api_block");
            apiBlocks.forEach(this::processApiBlock);

            //
            List<String> order = PARAM_OPT_ORDERS.get(endpointsNormalizedName + '.' + methodName);
            if (order == null)
                order = PARAM_OPT_ORDERS.get(endpointsNormalizedName + ".*");
            if (order != null) {
                final List<String> order2 = order;
                endpointParametersOpt.sort(Comparator.comparingInt(a -> order2.indexOf(a.spec.name)));
                if (!endpointParametersOpt.isEmpty() && !order.contains(endpointParametersOpt.get(0).spec.name))
                    throw new NoSuchElementException("Name missing: " + endpointParametersOpt.get(0).spec.name);
            }

            //
            LinkedList<MethodSpec> methodSpecs = new LinkedList<>();

            for (int optArgs = endpointParametersOpt.size(); optArgs >= 0; optArgs--) {

                MethodSpec.Builder methodBuilderSync = MethodSpec.methodBuilder(methodName);
                methodBuilderSync.addModifiers(Modifier.PUBLIC);
                methodBuilderSync.returns(returnType);
                methodBuilderSync.addComment(
                    "This method is automatically generated and should not be modified directly.");
                methodBuilderSync.addJavadoc(docstringBuilder.toString());

                MethodSpec.Builder methodBuilderAsync = MethodSpec.methodBuilder(methodName + "Async");
                methodBuilderAsync.addModifiers(Modifier.PUBLIC);
                methodBuilderAsync.returns(ParameterizedTypeName.get(
                    ClassName.get(CompletableFuture.class), returnType));
                methodBuilderAsync.addComment(
                    "This method is automatically generated and should not be modified directly.");
                methodBuilderAsync.addJavadoc(docstringBuilder.toString());

                StringBuilder code = new StringBuilder("(");

                // region param
                TypeName regionType = ClassName.bestGuess("com.mingweisamuel.zyra.enums.Region");
                methodBuilderSync.addParameter(ParameterSpec.builder(regionType, "region", Modifier.FINAL).build());
                methodBuilderSync.addJavadoc("@param region Region to execute against.\n");
                methodBuilderAsync.addParameter(ParameterSpec.builder(regionType, "region", Modifier.FINAL).build());
                methodBuilderAsync.addJavadoc("@param region Region to execute against.\n");
                code.append("region, ");

                for (EndpointParameter requiredParam :
                    Iterables.concat(endpointParametersPath, endpointParametersReq)) {

                    methodBuilderSync.addParameter(requiredParam.spec);
                    methodBuilderSync.addJavadoc("@param $L (required) $L\n",
                        requiredParam.spec.name, requiredParam.desc);
                    methodBuilderAsync.addParameter(requiredParam.spec);
                    methodBuilderAsync.addJavadoc("@param $L (required) $L\n",
                        requiredParam.spec.name, requiredParam.desc);
                    code.append(requiredParam.spec.name).append(", ");
                }

                for (EndpointParameter optionalParam : endpointParametersOpt.subList(0, optArgs)) {

                    methodBuilderSync.addParameter(optionalParam.spec);
                    methodBuilderSync.addJavadoc("@param $L (optional) $L\n",
                        optionalParam.spec.name, optionalParam.desc);
                    methodBuilderAsync.addParameter(optionalParam.spec);
                    methodBuilderAsync.addJavadoc("@param $L (optional) $L\n",
                        optionalParam.spec.name, optionalParam.desc);
                    code.append(optionalParam.spec.name).append(", ");
                }

                for (int i = optArgs; i < endpointParametersOpt.size(); i++)
                    code.append("null, ");
                code.setLength(code.length() - 2);
                code.append(");\n");

                if (optArgs == endpointParametersOpt.size()) {
                    methodBuilderSync.addCode("$T url = $L;\n", String.class, this.getUrlCode());
                    methodBuilderSync.addCode("$T type = $L;\n", Type.class, this.getGsonTypeCode());
                    methodBuilderAsync.addCode("$T url = $L;\n", String.class, this.getUrlCode());
                    methodBuilderAsync.addCode("$T type = $L;\n", Type.class, this.getGsonTypeCode());
                    String optParamsStr = buildOptionalParams();
                    if (optParamsStr.isEmpty()) {
                        methodBuilderSync.addCode("return riotApi.getBasic$L($S, url, region, type, $T.emptyList());\n",
                            nonRateLimited ? "NonRateLimited" : "", methodId, Collections.class);
                        methodBuilderAsync.addCode(
                            "return riotApi.getBasic$LAsync($S, url, region, type, $T.emptyList());\n",
                            nonRateLimited ? "NonRateLimited" : "", methodId, Collections.class);
                    }
                    else {
                        methodBuilderSync.addCode(
                            "return riotApi.getBasic$L($S, url, region, type, riotApi.makeParams($L));\n",
                            nonRateLimited ? "NonRateLimited" : "", methodId, optParamsStr);
                        methodBuilderAsync.addCode(
                            "return riotApi.getBasic$LAsync($S, url, region, type, riotApi.makeParams($L));\n",
                            nonRateLimited ? "NonRateLimited" : "", methodId, optParamsStr);
                    }
                }
                else {
                    methodBuilderSync.addCode("return this." + methodName + code.toString());
                    methodBuilderAsync.addCode("return this." + methodName + "Async" + code.toString());
                }

                methodSpecs.add(methodBuilderSync.build());
                methodSpecs.add(methodBuilderAsync.build());
            }

            return methodSpecs;
        }

        private void processApiBlock(Element apiBlock) {
            Element titleH4 = apiBlock.getElementsByTag("h4").first();
            switch (titleH4.ownText().trim().toLowerCase()) {
            case "response classes":
                processEndpointDtos(apiBlock);
                break;
            case "implementation notes":
                docstringBuilder.append("Implementation Notes:<br>\n").append(apiBlock.child(1).text()).append('\n');
                break;
            case "response errors":
                //TODO
                break;
            case "path parameters":
                processParameters(apiBlock, true);
                break;
            case "query parameters":
                processParameters(apiBlock, false);
                break;
            case "rate limit notes":
            default:
                // nop
            }
        }

        private void processEndpointDtos(Element apiBlock) {

            System.out.println("        DTOs:");

            Elements dtos = apiBlock.children();
            // first element is H4 header
            // second is return value
            String returnTypeStr = dtos.get(1).text().trim();
            returnTypeStr = returnTypeStr.replaceFirst("^Return value: ", "");
            this.returnType = getTypeFromString(returnTypeStr, dtoPackage).box();
            // rest are DTOs
            for (int i = 2; i < dtos.size(); i++) {
                if ("div".equals(dtos.get(i).tagName())) {
                    createDto(dtos.get(i));
                }
            }
        }

        /**
         * Add methods corresponding to this endpoint.
         *
         * @param apiBlock H4 Path Parameters
         */
        private void processParameters(Element apiBlock, boolean arePathParams) {
            if (returnType == null)
                throw new IllegalStateException("return type not found before path parameters");

            System.out.println("        Params:");

            Element paramTableBody = apiBlock.getElementsByTag("tbody").first();
            Elements paramTrs = paramTableBody.getElementsByTag("tr");
            for (Element paramTr : paramTrs) {
                String paramName = paramTr.child(0).ownText();
                String paramRequiredStr = paramTr.child(0).getElementsByClass("required").first().ownText();
                boolean paramRequired = "required".equals(paramRequiredStr);
                if (!paramRequired && arePathParams) { // error in docs
                    paramRequired = true;
                }
                TypeName paramType;
                String paramTypeKey = endpointsNormalizedName + '.' + methodName + ':' + paramName;
                if (PARAM_IGNORED.contains(paramTypeKey)) {
                    System.out.printf("            IGNORED: %s%n", paramName);
                    continue;
                }
                if (PARAM_TYPES.containsKey(paramTypeKey)) {
                    paramType = PARAM_TYPES.get(paramTypeKey);
                }
                else {
                    String paramTypeStr = paramTr.child(2).text();
                    paramType = getTypeFromString(paramTypeStr);
                    if ("true".equals(paramTr.child(1).child(0).attr("multiple"))) {
                        //TODO
                        //paramType = ParameterizedTypeName.get(ClassName.get(Collection.class), paramType);
                    }
                }
                if (!paramRequired) // optional parameters nullable
                    paramType = paramType.box();
                String paramDesc = paramTr.child(3).text();

                System.out.printf("            %s %s (%s) - %s%n", paramType.toString(), paramName,
                    paramRequired ? "required" : "optional", paramDesc);

                ParameterSpec.Builder paramBuilder = ParameterSpec.builder(paramType, paramName, Modifier.FINAL);
                ParameterSpec paramSpec = paramBuilder.build();
                EndpointParameter endpointParameter = new EndpointParameter(paramSpec, paramDesc);

                // add to lists
                if (arePathParams)
                    endpointParametersPath.add(endpointParameter);
                else if (paramRequired)
                    endpointParametersReq.add(endpointParameter);
                else
                    endpointParametersOpt.add(endpointParameter);
            }
        }

        /**
         * Creates a dto from an Element.
         *
         * @param dto Element, nested under .api_block, with header h4 "response classes".
         * @return
         */
        private boolean createDto(Element dto) {
            String dtoName = normalizeDtoName(dto.child(0).ownText());
            String dtoDesc = dto.ownText().replaceFirst("^\\s*-\\s+", "");

            if (processedDtos.contains(dtoName))
                return false;
            processedDtos.add(dtoName);

            System.out.printf("            %s - %s%n", dtoName, dtoDesc);

            TypeSpec.Builder dtoBuilder = TypeSpec.classBuilder(dtoName);
            dtoBuilder.addModifiers(Modifier.PUBLIC);
            dtoBuilder.addSuperinterface(Serializable.class);
            dtoBuilder.addJavadoc(dtoName + ".<br><br>\n\n");

            if (!dtoDesc.isEmpty())
                dtoBuilder.addJavadoc(dtoDesc + ".<br><br>\n\n");
            dtoBuilder.addJavadoc(String.format("This class was automatically generated from the " +
                "<a href=\"%s\">Riot API reference</a>.", url));

            // prep constructor, .equals(), and .hashCode()
            ClassName guavaObjectsName = ClassName.bestGuess("com.google.common.base.Objects");
            MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC);
            CodeBlock.Builder equalsCode = CodeBlock.builder()
                .addStatement("if (obj == this) return true")
                .addStatement("if (!(obj instanceof $L)) return false", dtoName)
                .addStatement("final $1L other = ($1L) obj", dtoName)
                .add("return true").indent().indent();
            CodeBlock.Builder hashCodeCode = CodeBlock.builder()
                .add("return $T.hashCode(0", guavaObjectsName).indent().indent();

            // add DTO fields
            Element fieldTableBody = dto.getElementsByTag("tbody").first();
            Elements fieldTrs = fieldTableBody.getElementsByTag("tr");

            for (Element fieldTr : fieldTrs) {
                String fieldName = fieldTr.child(0).text().trim();
                String fieldTypeStr = fieldTr.child(1).text().trim();
                String fieldDesc = fieldTr.child(2).text().trim();

                TypeName fieldType;
                String dtoCanonicalName = endpointsNormalizedName + '.' + dtoName + '.' + fieldName;
                if (FIELD_TYPES.containsKey(dtoCanonicalName))
                    fieldType = FIELD_TYPES.get(dtoCanonicalName);
                else
                    fieldType = getTypeFromString(fieldTypeStr, dtoPackage);
                // make championIds longs
                if ("championId".equals(fieldName) && TypeName.LONG.equals(fieldType))
                    fieldType = TypeName.INT;

                FieldSpec.Builder fieldBuilder = FieldSpec.builder(fieldType, fieldName,
                    Modifier.PUBLIC, Modifier.FINAL);
                if (!fieldDesc.isEmpty())
                    fieldBuilder.addJavadoc(fieldDesc);
                dtoBuilder.addField(fieldBuilder.build());

                // update constructor
                constructorBuilder.addParameter(fieldType, fieldName, Modifier.FINAL)
                    .addStatement("this.$1L = $1L", fieldName);

                // update .equals() and .hashCode()
                equalsCode.add("\n&& $1T.equal($2L, other.$2L)", guavaObjectsName, fieldName);
                hashCodeCode.add(",\n$L", fieldName);
            }

            // add constructor
            dtoBuilder.addMethod(constructorBuilder.build());

            // prep and add .equals() and .hashCode().
            equalsCode.add(";").unindent().unindent();
            hashCodeCode.add(");").unindent().unindent();

            dtoBuilder.addMethod(MethodSpec.methodBuilder("equals")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.BOOLEAN)
                .addParameter(Object.class, "obj", Modifier.FINAL)
                .addAnnotation(Override.class)
                .addCode(equalsCode.build()).build());
            dtoBuilder.addMethod(MethodSpec.methodBuilder("hashCode")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.INT)
                .addAnnotation(Override.class)
                .addCode(hashCodeCode.build()).build());

            // build dto, write to file
            TypeSpec dtoSpec = dtoBuilder.build();
            JavaFile javaFile = JavaFile.builder(dtoPackage, dtoSpec).build();
            try {
                javaFile.writeTo(SOURCE_DESTINATION);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }

        public CodeBlock getGsonTypeCode() {
            if (returnType instanceof ParameterizedTypeName) {

                TypeSpec typeTokenType = TypeSpec.anonymousClassBuilder("").addSuperinterface(ParameterizedTypeName.get(
                    ClassName.bestGuess("com.google.gson.reflect.TypeToken"), returnType)).build();

                return CodeBlock.of("$L.getType()", typeTokenType);
            }
            return CodeBlock.of("$T.class", returnType);
        }

        public CodeBlock getUrlCode() {
            String requestUrlNormalized = requestUrl
                .replaceFirst("\\{\\S+?}", "%1\\$s")
                .replaceFirst("\\{\\S+?}", "%2\\$s");

            if (requestUrl.equals(requestUrlNormalized))
                return CodeBlock.of("$S", requestUrl);

            StringBuilder argsBuilder = new StringBuilder();
            for (EndpointParameter param : endpointParametersPath) {
                argsBuilder.append(", ").append(param.spec.name);
            }

            return CodeBlock.of("String.format($S$L)", requestUrlNormalized, argsBuilder.toString());
        }

        private String buildOptionalParams() {
            StringBuilder paramsBuilder = new StringBuilder();
            if (!endpointParametersOpt.isEmpty()) {
                for (EndpointParameter param : endpointParametersOpt)
                    paramsBuilder.append("\"").append(param.spec.name)
                        .append("\", ").append(param.spec.name).append(", ");
                paramsBuilder.setLength(paramsBuilder.length() - 2);
            }
            return paramsBuilder.toString();
        }
    }

    // PARAMETER CLASS //

    private static class EndpointParameter {
        public final ParameterSpec spec;
        public final String desc;
        public EndpointParameter(ParameterSpec spec, String desc) {
            this.spec = spec;
            this.desc = desc;
        }
    }

    // HELPER STATIC DATA AND METHODS //

    private static final File SOURCE_DESTINATION = new File("src.main.gen.".replace(".", File.separator));

    private static final String PACKAGE = "com.mingweisamuel.zyra";

    private static String normalizeDtoName(String name) {
        return name.toLowerCase().endsWith("dto") ? name.substring(0, name.length() - 3) : name;
    }

    /** Normalizes a endpointsNormalizedName of an endpoint (or dto ..?). */
    private static String normalizeEndpointName(String name) {
        name = name.toLowerCase().replaceFirst("-v\\d+(?:\\.\\d+)?", "");
        name = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, name);
        return name;
    }

    /** Ignore tournament endpoint*s* (for now). */
    private static final HashSet<String> IGNORED_ENDPOINTSS =
        new HashSet<>(Arrays.asList("Tournament", "TournamentStub"));

    /** Ignore tournament-related match endpoints. */
    private static final HashSet<String> IGNORED_ENDPOINTS =
        new HashSet<>(Arrays.asList("Match.getMatchIdsByTournamentCode", "Match.getMatchByTournamentCode"));

    private static final HashSet<String> NON_RATE_LIMITED_ENDPOINTSS =
        new HashSet<>(Arrays.asList("LolStatus", "StaticData")); //TODO

    /** Ignored parameters (temp for v3 transition). */
    private static final Set<String> PARAM_IGNORED = new HashSet<>(Arrays.asList(
        "LolStaticData.getChampionList:champListData",
        "LolStaticData.getChampionById:champData",
        "LolStaticData.getItemList:itemListData",
        "LolStaticData.getItemById:itemData",
        "LolStaticData.getMasteryList:masteryListData",
        "LolStaticData.getMasteryById:masteryData",
        "LolStaticData.getRuneList:runeListData",
        "LolStaticData.getRuneById:runeData",
        "LolStaticData.getSummonerSpellList:spellListData",
        "LolStaticData.getSummonerSpellById:spellData"
    ));

    /** Method param type overrides. */
    private static final Map<String, TypeName> PARAM_TYPES = new HashMap<>();
    static {
        PARAM_TYPES.put("Masteries.getMasteryPagesBySummonerId:summonerId", TypeName.LONG);
        PARAM_TYPES.put("Runes.getRunePagesBySummonerId:summonerId", TypeName.LONG);

        PARAM_TYPES.put("Summoner.getByAccountId:accountId", TypeName.LONG);
        PARAM_TYPES.put("Summoner.getBySummonerId:summonerId", TypeName.LONG);
    }

    /** Method param orders. */
    private static final Map<String, List<String>> PARAM_OPT_ORDERS = new HashMap<>();
    static {
        PARAM_OPT_ORDERS.put("Match.getMatchlist", Arrays.asList("queue", "beginTime", "endTime", "champion", "season",
            "beginIndex", "endIndex"));
        PARAM_OPT_ORDERS.put("LolStaticData.*", Arrays.asList("id", "tags", "dataById", "locale", "version"));
        //TODO others
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

    /**
     * Gets a TypeName from a existing class.
     * @param in
     * @return
     */
    private static TypeName getTypeFromString(String in) {
        return getTypeFromString(in, "");
    }

    /**
     * Gets a TypeName from a string value and default package (for new DTOs).
     * @param in
     * @param defaultPackage
     * @return
     */
    @SuppressWarnings("Duplicates") //TODO
    private static TypeName getTypeFromString(String in, String defaultPackage) {
        switch(in) {
        case "boolean":
            return TypeName.BOOLEAN;
        case "int":
            return TypeName.INT;
        case "long":
            return TypeName.LONG;
        case "double":
            return TypeName.DOUBLE;
        case "string":
            return TypeName.get(String.class);
        }
        if (in.startsWith("List["))
            return ParameterizedTypeName.get(ClassName.get(List.class),
                getTypeFromString(normalizeDtoName(in.substring(5, in.length() - 1)), defaultPackage).box());
        if (in.startsWith("Set["))
            return ParameterizedTypeName.get(ClassName.get(List.class),
                getTypeFromString(normalizeDtoName(in.substring(4, in.length() - 1)), defaultPackage).box());
        if (in.startsWith("Map[")) {
            int comma = in.indexOf(',');
            return ParameterizedTypeName.get(ClassName.get(Map.class),
                getTypeFromString(normalizeDtoName(in.substring(4, comma)), defaultPackage).box(),
                getTypeFromString(normalizeDtoName(in.substring(comma + 2, in.length() - 1)),
                    defaultPackage).box());
        }
        return ClassName.bestGuess(defaultPackage + '.' + normalizeDtoName(in));
    }

    private static boolean delete(File dir) {
        if (!dir.isDirectory())
            return dir.delete();
        boolean result = true;
        for (File file : dir.listFiles())
            result &= delete(file);
        return result & dir.delete();
    }
}
