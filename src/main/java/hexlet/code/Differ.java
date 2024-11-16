package hexlet.code;

import hexlet.code.formatters.StylishFormatter;
import hexlet.code.utils.Utils;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, StylishFormatter.NAME);
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> map1 = getData(filepath1);
        Map<String, Object> map2 = getData(filepath2);

        Map<String, Status> map = DiffCreator.createDiff(map1, map2);
        return Formatter.choose(map, format);
    }

    private static Map<String, Object> getData(String filepath) throws Exception {
        final String content = Utils.readFile(filepath);
        final String extension = Utils.getFileExtension(filepath);

        Map<String, Object> map = Parser.parse(content, extension);
        return map;
    }

}
