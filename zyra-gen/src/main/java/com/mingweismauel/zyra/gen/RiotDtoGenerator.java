package com.mingweismauel.zyra.gen;

import com.google.common.base.CaseFormat;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is perhaps the most disgusting piece of code ever created.
 */
class RiotDtoGenerator {

    private static final Set<String> IGNORED_API_BLOCKS =
            new HashSet<>(Arrays.asList("Implementation Notes", "Rate Limit Notes"));

    private static final String PACKAGE = "com.mingweisamuel.zyra";

    private static final File SOURCE_DESTINATION = new File("src/main/gen/");

    private static final String DOCSTRING_GENERATED = "This class is automagically generated from " +
            "the <a href=\"https://developer.riotgames.com/api/methods\">Riot API reference</a>.";

    /** DTO field type overrides. */
    private static final Map<String, TypeName> FIELD_TYPES = new HashMap<>();
    static {
        FIELD_TYPES.put("ChampionSpell.effect", ParameterizedTypeName.get(ClassName.get(List.class),
                ParameterizedTypeName.get(List.class, Double.class)));
        FIELD_TYPES.put("ChampionSpell.range", ParameterizedTypeName.get(List.class, Integer.class));
        FIELD_TYPES.put("SummonerSpell.effect", ParameterizedTypeName.get(ClassName.get(List.class),
                ParameterizedTypeName.get(List.class, Double.class)));
        FIELD_TYPES.put("SummonerSpell.range", ParameterizedTypeName.get(List.class, Integer.class));
        FIELD_TYPES.put("ItemList.data", ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.INT.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.Item")));
        FIELD_TYPES.put("Item.maps", ParameterizedTypeName.get(Map.class, Integer.class, Boolean.class));
        FIELD_TYPES.put("MapData.data", ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.LONG.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.MapDetails")));
        FIELD_TYPES.put("MasteryList.data", ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.INT.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.Mastery")));
        FIELD_TYPES.put("RuneList.data", ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.INT.box(),
                ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.Rune")));
        FIELD_TYPES.put("SummonerSpellList.data", ParameterizedTypeName.get(ClassName.get(Map.class),
                TypeName.INT.box(), ClassName.bestGuess("com.mingweisamuel.zyra.lolStaticData.SummonerSpell")));
    }
    private static final Map<String, String> FIELD_DOCSTRINGS = new HashMap<>();
    static {
        FIELD_DOCSTRINGS.put("ChampionSpell.range", "Will be null instead of 'self'.");
        FIELD_DOCSTRINGS.put("SummonerSpell.range", "Will be null instead of 'self'.");

        FIELD_DOCSTRINGS.put("League.tier", "The value of this variable will never be " +
                "{@link com.mingweisamuel.zyra.enums.Tier#UNRANKED}.\n\n@see com.mingweisamuel.zyra.enums.Tier");
    }

    private static final Set<String> readDtos = new HashSet<>();

    public static void main(String... args) throws IOException, ClassNotFoundException {

        SOURCE_DESTINATION.mkdirs();

        Document doc = Jsoup.connect("https://developer.riotgames.com/api/methods").get();
        Element resourcesContainer = doc.getElementById("resources");
        Elements resources = resourcesContainer.getElementsByClass("resource");

        // size - 1 to ignore tournament-provider-v1
        for (int j = 0; j < resources.size() - 1; j++) {
            Element resource = resources.get(j);

            Element heading = resource.child(0).getElementsByTag("h2").first();
            if (!heading.getElementsByTag("span").get(1).text().contains("NA")) // ignore first two summoner-v1.4
                continue;

            String endpointTitle = heading.getElementsByTag("span").first().text();
            String endpointTitleNormalized = normalizeEndpointName(endpointTitle);
            String endpointPackage = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, endpointTitleNormalized);

            System.out.println(endpointTitle + ": " + endpointTitleNormalized);

            TypeSpec.Builder endpointsTypeBuilder = TypeSpec
                    .classBuilder(endpointTitleNormalized + "Endpoints")
                    .addModifiers(Modifier.PUBLIC)
                    .addJavadoc(DOCSTRING_GENERATED + "\n\n@version " + endpointTitle)
                    .addField(ClassName.bestGuess("com.mingweisamuel.zyra.RiotApi"), "riotApi",
                            Modifier.PRIVATE, Modifier.FINAL);
            MethodSpec.Builder endpointsTypeConstructorBuilder = MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(ClassName.bestGuess("com.mingweisamuel.zyra.RiotApi"), "riotApi", Modifier.FINAL)
                    .addCode("this.riotApi = riotApi;");
            endpointsTypeBuilder.addMethod(endpointsTypeConstructorBuilder.build());

            Element endpointsList = resource.children().last();
            Elements endpoints = endpointsList.children();

            for (Element endpoint : endpoints) {

                String endpointNotes = "";

                Element apiBlock = endpoint.getElementsByClass("api_block").first();
                while(IGNORED_API_BLOCKS.contains(apiBlock.child(0).text())) {
                    if ("Implementation Notes".equals(apiBlock.child(0).text()))
                        endpointNotes = apiBlock.child(1).text();
                    apiBlock = apiBlock.nextElementSibling();
                }

                Elements dtoContainers = apiBlock.children();

                if (!parseEndpointMethod(endpointsTypeBuilder, endpoint, dtoContainers, endpointTitleNormalized,
                        endpointNotes, endpointPackage))
                    continue;

                for (int i = dtoContainers.size() - 1; i >= 2; i--) {
                    Element dtoContainer = dtoContainers.get(i);
                    // lol static data has optional primitives on the return type, so box those
                    parseDto(dtoContainer, endpointTitle, endpointPackage);
                            //, i == 2 && endpointTitle.startsWith("lol-static-data-"));
                }
            }

            // status api enpoints class is done manually
            if (endpointTitle.startsWith("lol-status"))
                continue;

            TypeSpec endpointsType = endpointsTypeBuilder.build();
            JavaFile javaFile = JavaFile.builder(PACKAGE, endpointsType).build();
            javaFile.writeTo(SOURCE_DESTINATION);
        }
    }

    private static boolean parseEndpointMethod(TypeSpec.Builder endpointsTypeBuilder, Element endpoint,
            Elements dtoContainers, String endpointTitleNormalized, String endpointNotes, String endpointPackage) {

        String endpointPath = endpoint.getElementsByClass("path").first().child(0).text();
        if (endpointPath.contains("tournament")) {
            System.out.println("  IGNORED: " + endpointPath);
            return false;
        }
        String endpointDesc = endpoint.getElementsByClass("options").first().child(0).child(0).text();
        Element returnDto = dtoContainers.get(1);
        String returnDtoName = returnDto.getElementsByTag("b").first().nextSibling().outerHtml().substring(1);

        // determine method name
        String endpointName = determineEndpointName(endpointPath, endpointTitleNormalized);
        String endpointNameConsts = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, endpointName);

        boolean hasRegion = endpointPath.contains("{region}") || endpointPath.contains("{shard}");
        boolean hasPlatformId = endpointPath.contains("{platformId}") || endpointPath.contains("{location}");
        String endpointPathNormalized = endpointPath;
        if (hasRegion)
            endpointPathNormalized = endpointPathNormalized.replace("{region}", "%1$s").replace("{shard}", "%1$s");
        if (hasPlatformId)
            endpointPathNormalized = endpointPathNormalized.replace("{platformId}", "%1$s")
                    .replace("{location}", "%1$s");

        System.out.println("  " + endpointName + ": " + endpointPath + ": " + endpointDesc);
        System.out.println("  - returns " + returnDtoName);

        TypeName returnType = getTypeFromString(returnDtoName, PACKAGE + '.' + endpointPackage).box();
        // special cases for Map<Long, ?> for summoners, leagues by summoner
        if (endpointDesc.contains("mapped by summoner ID for a given list of summoner IDs")) {
            ParameterizedTypeName stringMap = (ParameterizedTypeName) returnType;
            TypeName valueType = stringMap.typeArguments.get(1);
            returnType = ParameterizedTypeName.get(ClassName.get(Map.class), TypeName.LONG.box(), valueType);
        }

        String typeField = endpointNameConsts + "__TYPE";
        if (returnType instanceof ParameterizedTypeName) {

            FieldSpec.Builder fieldBuilder = FieldSpec.builder(Type.class, typeField,
                    Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL);

            TypeSpec typeTokenType = TypeSpec.anonymousClassBuilder("").addSuperinterface(ParameterizedTypeName.get(
                    ClassName.bestGuess("com.google.gson.reflect.TypeToken"), returnType)).build();

            fieldBuilder.initializer("$L.getType()", typeTokenType);
            endpointsTypeBuilder.addField(fieldBuilder.build());
        }
        else
            endpointsTypeBuilder.addField(FieldSpec.builder(Type.class, typeField,
                        Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                        .initializer("$T.class", returnType).build());

        Element parametersContainer = dtoContainers.first().parent().nextElementSibling().nextElementSibling()
                .getElementsByClass("api_block").first();


        List<ParameterSpec> requiredParameters = new LinkedList<>();
        List<ParameterSpec> requiredQueryParameters = new LinkedList<>();
        List<ParameterSpec> optionalQueryParameters = new LinkedList<>();

        // null if not grouped.
        String groupField = null;
        // for not grouped.
        StringBuilder formatExtension = new StringBuilder();
        // @param
        List<String> javadocParams = new LinkedList<>();

        if (!parametersContainer.children().isEmpty()) {
            Element parameterWalker = parametersContainer.child(0);

            do {
                if ("Path Parameters".equals(parameterWalker.text())) {

                    Element pathParametersTable = parameterWalker.nextElementSibling().getElementsByTag("tbody").first();
                    Elements pathParameterRows = pathParametersTable.getElementsByTag("tr");

                    for (int i = 0; i < pathParameterRows.size(); i++) {
                        Element pathParameterRow = pathParameterRows.get(i);

                        String pathParameterName = pathParameterRow.child(0).ownText();
                        if ("shard".equals(pathParameterName)) continue;
                        String pathParameterType = pathParameterRow.child(2).child(0).text();
                        String pathParameterDesc = pathParameterRow.child(3).text();

                        TypeName type = getTypeFromString(pathParameterType);
                        if (type.isPrimitive()) {
                            // use int for championId
                            if ("championId".equals(pathParameterName) && TypeName.LONG.equals(type))
                                type = TypeName.INT;
                            formatExtension.append(", ").append(pathParameterName);
                            requiredParameters.add(ParameterSpec.builder(type, pathParameterName, Modifier.FINAL).build());
                            javadocParams.add(
                                    "@param " + pathParameterName + " Riot API description: " +
                                            processEndpointDesc(pathParameterDesc));
                            continue;
                        }
                        // type is string
                        Pattern pattern = Pattern.compile("Comma-separated list of summoner (IDs|names).*\\. " +
                                        "Maximum allowed at once is (\\d+)\\.");
                        Matcher matcher = pattern.matcher(pathParameterDesc);

                        if (matcher.find()) {
                            groupField = endpointNameConsts + "__GROUP";
                            endpointsTypeBuilder.addField(FieldSpec.builder(TypeName.INT, groupField,
                                    Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                                    .initializer("$L", Integer.parseInt(matcher.group(2))).build());
                            TypeName listType = "IDs".equals(matcher.group(1))
                                    ? TypeName.LONG.box() : TypeName.get(String.class);
                            requiredParameters.add(ParameterSpec.builder(
                                    ParameterizedTypeName.get(ClassName.get(Collection.class), listType),
                                    "input", Modifier.FINAL).build());
                            javadocParams.add(
                                    "@param input Riot API description: " +
                                            processEndpointDesc(pathParameterDesc));
                            continue;
                        }
                        throw new IllegalStateException();
                    }
                } else if ("Query Parameters".equals(parameterWalker.text())) {

                    Element queryParametersTable = parameterWalker.nextElementSibling().getElementsByTag("tbody").first();
                    Elements queryParameterRows = queryParametersTable.getElementsByTag("tr");

                    for (int i = 0; i < queryParameterRows.size(); i++) {
                        Element queryParameterRow = queryParameterRows.get(i);

                        String queryParameterName = queryParameterRow.child(0).ownText();
                        String queryParameterType = queryParameterRow.child(2).child(0).text();
                        String queryParameterDesc = queryParameterRow.child(3).text();
                        boolean required = "required".equals(queryParameterRow.child(0).child(0).text());

                        javadocParams.add(
                                "@param " + queryParameterName + " Riot API description: " +
                                        processEndpointDesc(queryParameterDesc));

                        TypeName type = getTypeFromString(queryParameterType);
                        if (type.isPrimitive()) {
                            // use int for championId
                            if ("championId".equals(queryParameterName) && TypeName.LONG.equals(type))
                                type = TypeName.INT;
                            (required ? requiredQueryParameters : optionalQueryParameters).add(ParameterSpec.builder(
                                    type.box(), queryParameterName, Modifier.FINAL).build());
                            continue;
                        }
                        // type is string (or long for champion ids)
                        if (queryParameterDesc.startsWith("Comma-separated list of ") ||
                                queryParameterDesc.startsWith("Tags to return additional data.")) {
                            TypeName listType;
                            if (queryParameterName.endsWith("Ids"))
                                listType = TypeName.LONG.box();
                            else
                                listType = TypeName.get(String.class);
                            (required ? requiredQueryParameters : optionalQueryParameters).add(ParameterSpec.builder(
                                    ParameterizedTypeName.get(ClassName.get(Collection.class), listType),
                                    queryParameterName, Modifier.FINAL).build());
                            continue;
                        }
                        (required ? requiredQueryParameters : optionalQueryParameters).add(ParameterSpec.builder(
                                String.class, queryParameterName, Modifier.FINAL).build());
                    }
                    break;
                }
            } while(parameterWalker.nextElementSibling() != null &&
                    (parameterWalker = parameterWalker.nextElementSibling().nextElementSibling()) != null);
        }

        if (groupField != null) {
            endpointPathNormalized = endpointPathNormalized.replaceFirst("\\{\\S+?}", "@");

            addMapMethods(endpointsTypeBuilder, endpointName, returnType, endpointNameConsts, endpointPathNormalized,
                    groupField, typeField, requiredParameters, requiredQueryParameters, optionalQueryParameters,
                    hasPlatformId, javadocParams, endpointNotes);
        }
        else {
            endpointPathNormalized = endpointPathNormalized
                    .replaceFirst("\\{\\S+?}", "%2\\$s")
                    .replaceFirst("\\{\\S+?}", "%3\\$s");

            addBasicMethods(endpointsTypeBuilder, endpointName, returnType, endpointNameConsts, endpointPathNormalized,
                    groupField, typeField, requiredParameters, requiredQueryParameters, optionalQueryParameters,
                    hasPlatformId, javadocParams, endpointNotes, formatExtension,
                    "LolStaticData".equals(endpointTitleNormalized));
        }

        return true;
    }

    private static void addBasicMethods(TypeSpec.Builder builder, String endpointName, TypeName returnType,
            String endpointNameConsts, String endpointPathNormalized, String groupField, String typeField,
            List<ParameterSpec> required, List<ParameterSpec> requiredQuery, List<ParameterSpec> optionalQuery,
            boolean hasPlatformId, List<String> javadocParams, String endpointNotes, StringBuilder formatExtension,
            boolean nonRateLimited) {

        String urlField = endpointNameConsts + "__URL";

        builder.addField(FieldSpec.builder(String.class, urlField,
                Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S", endpointPathNormalized).build());

        for (int i = optionalQuery.size(); i >= 0; i--) {

            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(endpointName)
                    .addModifiers(Modifier.PUBLIC)
                    .addException(ExecutionException.class)
                    .addParameter(ClassName.bestGuess("com.mingweisamuel.zyra.enums.Region"), "region", Modifier.FINAL)
                    .returns(returnType.box());

            MethodSpec.Builder methodAsyncBuilder = MethodSpec.methodBuilder(endpointName + "Async")
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(ClassName.bestGuess("com.mingweisamuel.zyra.enums.Region"), "region", Modifier.FINAL)
                    .returns(ParameterizedTypeName.get(ClassName.get(CompletableFuture.class), returnType.box()));

            StringBuilder params = new StringBuilder();

            for (ParameterSpec requiredParam : required) {
                methodBuilder.addParameter(requiredParam);
                methodAsyncBuilder.addParameter(requiredParam);
                params.append(requiredParam.name).append(", ");
            }
            for (ParameterSpec requiredParam : requiredQuery) {
                methodBuilder.addParameter(requiredParam);
                methodAsyncBuilder.addParameter(requiredParam);
                params.append(requiredParam.name).append(", ");
            }
            Iterator<ParameterSpec> iter = optionalQuery.iterator();
            for (int j = 0; j < i; j++) {
                ParameterSpec optionalParam = iter.next();
                methodBuilder.addParameter(optionalParam);
                methodAsyncBuilder.addParameter(optionalParam);
                params.append(optionalParam.name).append(", ");
            }

            StringBuilder javadoc = new StringBuilder(endpointNotes).append('\n');
            Iterator<String> paramIter = javadocParams.iterator();
            for (int j = 0; j < required.size(); j++)
                javadoc.append('\n').append(paramIter.next());
            for (int j = 0; j < i; j++)
                javadoc.append('\n').append(paramIter.next());


            methodBuilder.addJavadoc(javadoc.toString().trim());
            methodAsyncBuilder.addJavadoc(javadoc.toString().trim());

            if (i == optionalQuery.size()) {
                methodBuilder.addCode("return riotApi.getBasic$L(String.format($L, region$L$L), region, $L$L);",
                        nonRateLimited ? "NonRateLimited" : "",
                        urlField, hasPlatformId ? ".platform" : "",
                        formatExtension.toString(), typeField, buildOptionalParams(requiredQuery, optionalQuery));
                methodAsyncBuilder.addCode(
                        "return riotApi.getBasic$LAsync(String.format($L, region$L$L), region, $L$L);",
                        nonRateLimited ? "NonRateLimited" : "",
                        urlField, hasPlatformId ? ".platform" : "",
                        formatExtension.toString(), typeField, buildOptionalParams(requiredQuery, optionalQuery));
            }
            else {
                methodBuilder.addCode("return $L(region, $Lnull);", endpointName, params.toString());
                methodAsyncBuilder.addCode("return $LAsync(region, $Lnull);", endpointName, params.toString());
            }

            builder.addMethod(methodBuilder.build());
            builder.addMethod(methodAsyncBuilder.build());
        }
    }

    private static void addMapMethods(TypeSpec.Builder builder, String endpointName, TypeName returnType,
            String endpointNameConsts, String endpointPathNormalized, String groupField, String typeField,
            List<ParameterSpec> required, List<ParameterSpec> requiredQuery, List<ParameterSpec> optionalQuery,
            boolean hasPlatformId, List<String> javadocParams, String endpointNotes) {

        String urlField = endpointNameConsts + "__URL";

        builder.addField(FieldSpec.builder(String.class, urlField,
                Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S", endpointPathNormalized).build());

        for (int i = optionalQuery.size(); i >= 0; i--) {

            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(endpointName)
                    .addModifiers(Modifier.PUBLIC)
                    .addException(ExecutionException.class)
                    .addParameter(ClassName.bestGuess("com.mingweisamuel.zyra.enums.Region"), "region", Modifier.FINAL)
                    .returns(returnType.box());

            MethodSpec.Builder methodAsyncBuilder = MethodSpec.methodBuilder(endpointName + "Async")
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(ClassName.bestGuess("com.mingweisamuel.zyra.enums.Region"), "region", Modifier.FINAL)
                    .returns(ParameterizedTypeName.get(ClassName.get(CompletableFuture.class), returnType.box()));

            StringBuilder params = new StringBuilder();

            for (ParameterSpec requiredParam : required) {
                methodBuilder.addParameter(requiredParam);
                methodAsyncBuilder.addParameter(requiredParam);
                params.append(requiredParam.name).append(", ");
            }
            for (ParameterSpec requiredParam : requiredQuery) {
                methodBuilder.addParameter(requiredParam);
                methodAsyncBuilder.addParameter(requiredParam);
                params.append(requiredParam.name).append(", ");
            }
            Iterator<ParameterSpec> iter = optionalQuery.iterator();
            for (int j = 0; j < i; j++) {
                ParameterSpec optionalParam = iter.next();
                methodBuilder.addParameter(optionalParam);
                methodAsyncBuilder.addParameter(optionalParam);
                params.append(optionalParam.name).append(", ");
            }

            StringBuilder javadoc = new StringBuilder(endpointNotes).append('\n');
            Iterator<String> paramIter = javadocParams.iterator();
            for (int j = 0; j < required.size(); j++)
                javadoc.append('\n').append(paramIter.next());
            for (int j = 0; j < i; j++)
                javadoc.append('\n').append(paramIter.next());

            methodBuilder.addJavadoc(javadoc.toString().trim());
            methodAsyncBuilder.addJavadoc(javadoc.toString().trim());

            if (i == optionalQuery.size()) {
                methodBuilder.addCode(
                        "return riotApi.getMap(String.format($L, region$L), region, input, $L, $L$L);",
                        urlField, hasPlatformId ? ".platform" : "",
                        groupField, typeField, buildOptionalParams(requiredQuery, optionalQuery));
                methodAsyncBuilder.addCode(
                        "return riotApi.getMapAsync(String.format($L, region$L), region, input, $L, $L$L);",
                        urlField, hasPlatformId ? ".platform" : "",
                        groupField, typeField, buildOptionalParams(requiredQuery, optionalQuery));
            }
            else {
                methodBuilder.addCode("return $L($Lnull);", endpointName, params.toString());
                methodAsyncBuilder.addCode("return $LAsync($Lnull);", endpointName, params.toString());
            }

            builder.addMethod(methodBuilder.build());
            builder.addMethod(methodAsyncBuilder.build());
        }
    }

    private static String processEndpointDesc(String desc) {
        return desc.replaceFirst("^Comma-separated ", "").replaceAll(" Maximum allowed at once is \\d+.", "");
    }

    private static String buildOptionalParams(List<ParameterSpec> required, List<ParameterSpec> optional) {
        StringBuilder paramsBuilder = new StringBuilder();
        if (!required.isEmpty() || !optional.isEmpty()) {
            paramsBuilder.append(",\n    riotApi.makeParams(");
            for (ParameterSpec param : required)
                paramsBuilder.append("\"").append(param.name)
                        .append("\", ").append(param.name).append(", ");
            for (ParameterSpec param : optional)
                paramsBuilder.append("\"").append(param.name)
                        .append("\", ").append(param.name).append(", ");
            paramsBuilder.setLength(paramsBuilder.length() - 2);
            paramsBuilder.append(")");
        }
        return paramsBuilder.toString();
    }

    private static String determineEndpointName(String endpointPath, String endpointTitleNormalized) {

        // special cases
        if ("CurrentGame".equals(endpointTitleNormalized) || "FeaturedGames".equals(endpointTitleNormalized)
                || "Matchlist".equals(endpointTitleNormalized))
            return "get";
        // getBySummonerIds -> get
        if ("League".equals(endpointTitleNormalized) && endpointPath.endsWith("{summonerIds}"))
            return "get";
        if ("LolStatus".equals(endpointTitleNormalized))
            endpointTitleNormalized = "shard"; //return endpointPath.endsWith("}") ? "getShard" : "getShards";
        if ("Championmastery".equals(endpointTitleNormalized))
            endpointTitleNormalized = "champion";

        StringBuilder endpointName = new StringBuilder("get");
        int lastSlash = endpointPath.lastIndexOf('/');
        if (endpointPath.endsWith("}")) {
            int lastSlash2 = endpointPath.lastIndexOf('/', lastSlash - 1);
            String subPath = endpointPath.substring(lastSlash2 + 1, lastSlash);
            //System.out.println("----- " + subPath);
            if (!subPath.startsWith(endpointTitleNormalized.toLowerCase()))
                endpointName.append('-').append(subPath);
        }
        else {
            String tail = endpointPath.substring(lastSlash + 1);
            if (tail.startsWith(endpointTitleNormalized.toLowerCase()))
                endpointName.append('-').append("all");
            else {
                StringBuilder end = new StringBuilder(tail);
                if (!"recent".equals(tail) && !"score".equals(tail) && !"realm".equals(tail) &&
                        !"stats".equalsIgnoreCase(endpointTitleNormalized)) {
                    char lastChar = end.charAt(end.length() - 1);
                    if ('s' != lastChar) {
                        if ('y' == lastChar) {
                            end.setLength(end.length() - 1);
                            end.append("ies");
                        } else
                            end.append('s');
                    }
                }
                endpointName.append('-').append(end);
            }
        }
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,
                endpointName.toString().replace("topchampions", "top-champions"));
    }

    private static void parseDto(Element dtoContainer, String endpointName, String endpointPackage/*, boolean boxed*/)
            throws IOException {

        Element dto = dtoContainer.getElementsByTag("b").first();
        String dtoName = dto.text();
        String dtoNameNormalized = normalizeDtoName(dtoName);

        if (readDtos.contains(endpointPackage + '.' + dtoNameNormalized))
            return;

//        if (boxed)
//            System.out.println("BOXED " + dtoName);

        String dtoDescription = dto.parent().ownText();
        System.out.println("      " + dtoNameNormalized + ' ' + dtoDescription);

        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(dtoNameNormalized);
        typeSpecBuilder.addJavadoc(dtoNameNormalized +
                (dtoDescription.isEmpty() ? "" : " " + dtoDescription) +
                "\n\n" + DOCSTRING_GENERATED +
                "\n\n@version " + endpointName);
        typeSpecBuilder.addModifiers(Modifier.PUBLIC);

        Element fieldInfoTable = dtoContainer.getElementsByTag("table").first();
        Elements fieldInfoRows = fieldInfoTable.getElementsByTag("tr");

        for (int k = 1; k < fieldInfoRows.size(); k++) {
            Element fieldInfoRow = fieldInfoRows.get(k);

            String fieldName = fieldInfoRow.child(0).text();
            String fieldType = fieldInfoRow.child(1).text();
            String fieldDesc = fieldInfoRow.child(2).text();

            TypeName type;
            String key = dtoNameNormalized + '.' + fieldName;

            if (FIELD_TYPES.containsKey(key))
                type = FIELD_TYPES.get(key);
            else
                type = getTypeFromString(normalizeDtoName(fieldType), PACKAGE + '.' + endpointPackage);
            if ("championId".equals(fieldName) && TypeName.LONG.equals(type))
                type = TypeName.INT;
//            if (boxed)
//                type = type.box();

            FieldSpec.Builder fieldBuilder = FieldSpec.builder(type, fieldName, Modifier.PUBLIC);
            if (FIELD_DOCSTRINGS.containsKey(key))
                fieldDesc = (fieldDesc + "\n\n" + FIELD_DOCSTRINGS.get(key)).trim();
            if (!fieldDesc.isEmpty())
                fieldBuilder.addJavadoc(fieldDesc);
            typeSpecBuilder.addField(fieldBuilder.build());
        }

        TypeSpec typeSpec = typeSpecBuilder.build();
        JavaFile javaFile = JavaFile.builder(PACKAGE + '.' + endpointPackage, typeSpec).build();
        javaFile.writeTo(SOURCE_DESTINATION);
        readDtos.add(endpointPackage + '.' + dtoNameNormalized);
    }

    private static String normalizeEndpointName(String endpoint) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, endpoint)
                .replaceAll("V(\\d+)\\.(\\d+)", "")
                .replace("Championmastery", "ChampionMastery");
    }

    private static String normalizeDtoName(String dtoName) {
        return dtoName.toLowerCase().endsWith("dto") ? dtoName.substring(0, dtoName.length() - 3) : dtoName;
    }

    private static TypeName getTypeFromString(String in) {
        return getTypeFromString(in, "");
    }

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
}
