package hexlet.code;

import hexlet.code.formatters.StylishFormatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String... values) throws Exception {


        String filepath1 = values[0];
        String filepath2 = values[1];
        String format = StylishFormatter.NAME;
        final int length = 3;
        if (values.length >= length) {
            format = values[2];
        }

        //get
        Map<String, Object> map1 = Parser.getData(filepath1);
        Map<String, Object> map2 = Parser.getData(filepath2);

        //sort
        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);
        if (set.isEmpty()) {
            return "{}";
        }

        //gen diff
        Map<String, Status> map = new LinkedHashMap<>();
        for (String key : set) {
            boolean key1Exists = map1.containsKey(key);
            boolean key2Exists = map2.containsKey(key);

            Object v1 = map1.get(key);
            Object v2 = map2.get(key);

            if (key1Exists && !key2Exists) {
                map.put(key, new Status(Status.DELETED, v1, null));
            } else if (key1Exists && key2Exists && v1 != null && v1.equals(v2)) {
                map.put(key, new Status(Status.UNCHANGED, v1, v2));
            } else if (key1Exists && key2Exists && (v1 == null || !v1.equals(v2))) {
                map.put(key, new Status(Status.CHANGED, v1, v2));
            } else if (!key1Exists && key2Exists) {
                map.put(key, new Status(Status.ADDED, v1, v2));
            }
        }

        //format
        return Formatter.choose(map, format);
    }

}
