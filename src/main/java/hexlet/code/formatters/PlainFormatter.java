package hexlet.code.formatters;

import hexlet.code.Status;

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

            String value1 = getValueStr(v1);
            String value2 = getValueStr(v2);

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

    public static String getValueStr(Object val) {
        String value = null;
        if (val != null && String.class.isInstance(val)) {
            value = "'" + val + "'";
        } else if (val != null) {
            value = val.toString();

            if (value.contains("[") || value.contains("{")) {
                value = "[complex value]";
            }
        }

        return value;
    }
}
