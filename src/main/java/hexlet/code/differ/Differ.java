package hexlet.code.differ;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String json1, String json2) throws Exception {
        Map<String, Object> map1 = getData(json1);
        Map<String, Object> map2 = getData(json2);

        //sort and make unique
        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);
        if (set.isEmpty()) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (String key : set) {
            Object v1 = map1.get(key);
            Object v2 = map2.get(key);

            if (v1 != null && v2 == null) {
                //- deleted
                sb.append("  - " + key + ": " + v1);
            } else if (v1 != null && v2 != null && v1.equals(v2)) {
                //no change
                sb.append("    " + key + ": " + v1);
            } else if (v1 != null && v2 != null && !v1.equals(v2)) {
                //- change
                sb.append("  - " + key + ": " + v1);
                sb.append("\n");
                sb.append("  + " + key + ": " + v2);
            } else if (v1 == null & v2 != null) {
                //add
                sb.append("  + " + key + ": " + v2);
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    public static Map<String, Object> getData(String content) throws Exception {
        return parse(content);
    }

    public static Map<String, Object> parse(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        return map;
    }
}
