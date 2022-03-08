package hexlet.code.differ;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String fileContent1, String fileContent2, String fileExtension) throws Exception {
        Map<String, Object> map1 = Parser.getData(fileContent1, fileExtension);
        Map<String, Object> map2 = Parser.getData(fileContent2, fileExtension);

        //sort and make unique
        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);
        if (set.isEmpty()) {
            return "{}";
        }

        //diff
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
            } else if (v1 == null && v2 != null) {
                //add
                sb.append("  + " + key + ": " + v2);
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
