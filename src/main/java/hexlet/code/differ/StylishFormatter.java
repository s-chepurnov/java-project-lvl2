package hexlet.code.differ;

import java.util.Map;

public class StylishFormatter {

    public static final String NAME = "stylish";

    public static String format(Map<String, Status> map) {

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (Map.Entry<String, Status> entry : map.entrySet()) {
            String key = entry.getKey();

            String status = entry.getValue().getStatusName();
            Object v1 = entry.getValue().getOldValue();
            Object v2 = entry.getValue().getNewValue();

            if (status.equals(Status.DELETED)) {
                sb.append("  - " + key + ": " + v1);
            } else if (status.equals(Status.UNCHANGED)) {
                sb.append("    " + key + ": " + v1);
            } else if (status.equals(Status.CHANGED)) {
                sb.append("  - " + key + ": " + v1);
                sb.append("\n");
                sb.append("  + " + key + ": " + v2);
            } else if (status.equals(Status.ADDED)) {
                sb.append("  + " + key + ": " + v2);
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
