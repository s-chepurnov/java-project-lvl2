package hexlet.code.differ;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String fileContent1, String fileContent2, String fileExtension, String format)
            throws Exception {

        //get
        Map<String, Object> map1 = Parser.getData(fileContent1, fileExtension);
        Map<String, Object> map2 = Parser.getData(fileContent2, fileExtension);

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
        String formatted = "";
        if (format.equals(StylishFormatter.NAME)) {
            formatted = StylishFormatter.format(map);
        }

        return formatted;
    }

}
