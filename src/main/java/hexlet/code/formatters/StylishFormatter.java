package hexlet.code.formatters;

import hexlet.code.differ.Status;

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

            switch (status) {
                case Status.DELETED -> sb.append("  - " + key + ": " + v1);
                case Status.ADDED -> sb.append("  + " + key + ": " + v2);
                case Status.UNCHANGED -> sb.append("    " + key + ": " + v1);
                case Status.CHANGED -> {
                    sb.append("  - " + key + ": " + v1);
                    sb.append("\n");
                    sb.append("  + " + key + ": " + v2);
                }
                default -> throw new RuntimeException("there is no such status");
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
