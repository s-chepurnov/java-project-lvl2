package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    public static final String NAME = "plain";

    public static String format(Map<String, Status> map) {

        StringBuilder sb = new StringBuilder();
        int size = map.size();

        for (Map.Entry<String, Status> entry : map.entrySet()) {
            String key = entry.getKey();

            String status = entry.getValue().getStatusName();
            Object v1 = entry.getValue().getOldValue();
            Object v2 = entry.getValue().getNewValue();

            String value1 = stringify(v1);
            String value2 = stringify(v2);

            size--;
            switch (status) {
                case Status.DELETED -> {
                    sb.append("Property '" + key + "' was removed");
                    if (size > 0) {
                        sb.append("\n");
                    }
                }
                case Status.CHANGED -> {
                    sb.append("Property '" + key + "' was updated. From " + value1 + " to " + value2);
                    if (size > 0) {
                        sb.append("\n");
                    }
                }
                case Status.ADDED -> {
                    sb.append("Property '" + key + "' was added with value: " + value2);
                    if (size > 0) {
                        sb.append("\n");
                    }
                }
                case Status.UNCHANGED -> {

                }
                default -> throw new RuntimeException("there is no such status: " + status);
            }

        }

        return sb.toString();
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        return value.toString();
    }

}
