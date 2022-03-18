package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.io.IOException;
import java.util.Map;

public class Formatter {

    public static String choose(Map<String, Status> map, String format) throws IOException {
        return switch (format) {
            case StylishFormatter.NAME -> StylishFormatter.format(map);
            case PlainFormatter.NAME -> PlainFormatter.format(map);
            case JsonFormatter.NAME -> JsonFormatter.format(map);
            default -> throw new RuntimeException("There is no such formatter");
        };

    }
}
