package com.mingweisamuel.zyra.build;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RiotDtoGenerator {

    public static final Set<String> IGNORED_API_BLOCKS =
            new HashSet<>(Arrays.asList("Implementation Notes", "Rate Limit Notes"));

    public static final String PACKAGE = "com.mingweisamuel.zyra.dto";

    public static final File SOURCE_DESTINATION = new File("src/gen/java/");

    public static final Map<String, TypeName> FIELD_TYPES = new HashMap<>();
    static {
        FIELD_TYPES.put("ChampionSpell.effect", ParameterizedTypeName.get(ClassName.get(List.class),
                ParameterizedTypeName.get(List.class, Double.class)));
        FIELD_TYPES.put("ChampionSpell.range", ParameterizedTypeName.get(List.class, Integer.class));
        FIELD_TYPES.put("SummonerSpell.effect", ParameterizedTypeName.get(ClassName.get(List.class),
                ParameterizedTypeName.get(List.class, Double.class)));
        FIELD_TYPES.put("SummonerSpell.range", ParameterizedTypeName.get(List.class, Integer.class));
    }
    public static final Map<String, String> FIELD_DOCSTRINGS = new HashMap<>();
    static {
        FIELD_DOCSTRINGS.put("ChampionSpell.range", "Will be null instead of 'self'.");
        FIELD_DOCSTRINGS.put("SummonerSpell.range", "Will be null instead of 'self'.");

        FIELD_DOCSTRINGS.put("League.tier", "The value of this variable will never be " +
                "{@link com.mingweisamuel.zyra.enums.Tier#UNRANKED}.\n\n@see com.mingweisamuel.zyra.enums.Tier");
    }

    public static final Set<String> readDtos = new HashSet<>();

    public static void main(String... args) throws IOException, ClassNotFoundException {

        SOURCE_DESTINATION.delete();
        SOURCE_DESTINATION.mkdirs();

        Document doc = Jsoup.connect("https://developer.riotgames.com/api/methods").get();
        Element resourcesContainer = doc.getElementById("resources");
        Elements resources = resourcesContainer.getElementsByClass("resource");

        // size - 1 to ignore tournament-provider-v1
        for (int j = 0; j < resources.size() - 1; j++) {
            Element resource = resources.get(j);

            Element heading = resource.children().first().getElementsByTag("h2").first();
            String endpointName = heading.getElementsByTag("span").first().text();

            System.out.println(endpointName);

            Element endpointsList = resource.children().last();
            Elements endpoints = endpointsList.children();

            for (Element endpoint : endpoints) {

                Element apiBlock = endpoint.getElementsByClass("api_block").first();
                while(IGNORED_API_BLOCKS.contains(apiBlock.children().first().text()))
                    apiBlock = apiBlock.nextElementSibling();

                Elements dtoContainers = apiBlock.children();
                Element returnDto = dtoContainers.get(1);

                String returnDtoName = returnDto.getElementsByTag("b").first().nextSibling().outerHtml().substring(1);
                System.out.println("  " + returnDtoName);

                for (int i = dtoContainers.size() - 1; i >= 2; i--) {
                    Element dtoContainer = dtoContainers.get(i);

                    Element dto = dtoContainer.getElementsByTag("b").first();
                    String dtoName = dto.text();
                    String dtoNameNormalized = normalizeDtoName(dtoName);

                    if (readDtos.contains(dtoNameNormalized))
                        continue;

                    String dtoDescription = dto.parent().ownText();
                    System.out.println("    " + dtoNameNormalized + ' ' + dtoDescription);

                    TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(dtoNameNormalized);
                    typeSpecBuilder.addJavadoc(dtoNameNormalized +
                            (dtoDescription.isEmpty() ? "" : " " + dtoDescription) +
                            "\n\nThis class is automagically generated from " +
                            "the <a href=\"https://developer.riotgames.com/api/methods\">Riot API reference</a> " +
                            "using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.");
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
                            type = getTypeFromString(normalizeDtoName(fieldType));

                        FieldSpec.Builder fieldBuilder = FieldSpec.builder(type, fieldName, Modifier.PUBLIC);
                        if (FIELD_DOCSTRINGS.containsKey(key))
                            fieldDesc = (fieldDesc + "\n\n" + FIELD_DOCSTRINGS.get(key)).toLowerCase();
                        if (!fieldDesc.isEmpty())
                            fieldBuilder.addJavadoc(fieldDesc);
                        typeSpecBuilder.addField(fieldBuilder.build());
                    }

                    TypeSpec typeSpec = typeSpecBuilder.build();

                    JavaFile javaFile = JavaFile.builder(PACKAGE, typeSpec).build();
                    javaFile.writeTo(SOURCE_DESTINATION);

                    readDtos.add(dtoNameNormalized);
                }
            }
        }
    }

    public static String normalizeDtoName(String dtoName) {
        return dtoName.toLowerCase().endsWith("dto") ? dtoName.substring(0, dtoName.length() - 3) : dtoName;
    }

    public static TypeName getTypeFromString(String in) {
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
                    getTypeFromString(normalizeDtoName(in.substring(5, in.length() - 1))).box());
        if (in.startsWith("Set["))
            return ParameterizedTypeName.get(ClassName.get(List.class),
                    getTypeFromString(normalizeDtoName(in.substring(4, in.length() - 1))).box());
        if (in.startsWith("Map[")) {
            int comma = in.indexOf(',');
            return ParameterizedTypeName.get(ClassName.get(Map.class),
                    getTypeFromString(normalizeDtoName(in.substring(4, comma))).box(),
                    getTypeFromString(normalizeDtoName(in.substring(comma + 2, in.length() - 1))).box());
        }
        return ClassName.bestGuess(PACKAGE + '.' + in);
    }
}
