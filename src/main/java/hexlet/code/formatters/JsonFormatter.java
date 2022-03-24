package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;
import java.io.IOException;
import java.util.Map;

public class JsonFormatter {

    public static final String NAME = "json";

    public static String format(Map<String, Status> map) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String formatted = objectMapper.writeValueAsString(map);
        return formatted;
    }
}
