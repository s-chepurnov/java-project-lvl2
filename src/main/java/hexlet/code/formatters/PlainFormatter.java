package hexlet.code.formatters;

import hexlet.code.differ.Status;

import java.util.Map;

public class PlainFormatter {

    public static final String NAME = "plain";

    public static String format(Map<String, Status> map) {

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Status> entry : map.entrySet()) {
            String key = entry.getKey();

            String status = entry.getValue().getStatusName();
            Object v1 = entry.getValue().getOldValue();
            Object v2 = entry.getValue().getNewValue();

            String value1 = null;
            if (v1 != null && String.class.isInstance(v1)) {
                value1 = "'" + v1 + "'";
            } else if (v1 != null) {
                value1 = v1.toString();

                if (value1.contains("[") || value1.contains("{")) {
                    value1 = "[complex value]";
                }
            }

            String value2 = null;
            if (v2 != null && String.class.isInstance(v2)) {
                value2 = "'" + v2 + "'";
            } else if (v2 != null) {
                value2 = v2.toString();

                if (value2.contains("[") || value2.contains("{")) {
                    value2 = "[complex value]";
                }
            }

            switch (status) {
                case Status.DELETED:
                    sb.append("Property '" + key + "' was removed");
                    sb.append("\n");
                    break;
                case Status.UNCHANGED:
                    break;
                case Status.CHANGED:
                    sb.append("Property '" + key + "' was updated. From " + value1 + " to " + value2);
                    sb.append("\n");
                    break;
                case Status.ADDED:
                    sb.append("Property '" + key + "' was added with value: " + value2);
                    sb.append("\n");
                    break;
                default:
                    throw new RuntimeException("there is no such status");
            }
        }

        return sb.toString();
    }
}