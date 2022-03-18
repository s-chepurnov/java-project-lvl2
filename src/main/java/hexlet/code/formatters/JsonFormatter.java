package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.io.IOException;
import java.util.Map;

public class JsonFormatter {

    public static final String NAME = "json";

    public static String format(Map<String, Status> map) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Status> entry : map.entrySet()) {
            String key = entry.getKey();
            String status = entry.getValue().getStatusName();
            Object v1 = entry.getValue().getOldValue();
            Object v2 = entry.getValue().getNewValue();

            JsonModel jsonModel = new JsonModel(key, status, v1, v2);
            String str = objectMapper.writeValueAsString(jsonModel);
            sb.append(str);
        }

        return sb.toString();
    }
}
