package hexlet.code;

import hexlet.code.differ.Status;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.io.IOException;
import java.util.Map;

public class Formatter {

    public static String choose(Map<String, Status> map, String format) throws IOException {

        String formatted = "";
        if (format.equals(StylishFormatter.NAME)) {
            formatted = StylishFormatter.format(map);
        } else if (format.equals(PlainFormatter.NAME)) {
            formatted = PlainFormatter.format(map);
        } else if (format.equals(JsonFormatter.NAME)) {
            formatted = JsonFormatter.format(map);
        }

        return formatted;
    }
}
