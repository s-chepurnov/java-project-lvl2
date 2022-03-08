package hexlet.code.differ;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String fileContent, String fileExtension) throws Exception {
        return switch (fileExtension) {
            case "json" -> parseJson(fileContent);
            case "yml" -> parseYml(fileContent);
            default -> throw new Exception("No such format");
        };
    }

    public static Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String, Object> parseYml(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }

}
