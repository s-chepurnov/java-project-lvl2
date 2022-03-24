package hexlet.code;

import hexlet.code.formatters.StylishFormatter;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, StylishFormatter.NAME);
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        format = (format == null || format.isEmpty()) ? StylishFormatter.NAME : format;

        //get data
        Map<String, Object> map1 = Parser.getData(filepath1);
        Map<String, Object> map2 = Parser.getData(filepath2);

        //gen diff
        Map<String, Status> map = DiffCreator.createDiff(map1, map2);

        //format result
        return Formatter.choose(map, format);
    }

}
