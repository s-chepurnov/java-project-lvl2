package hexlet.code.differ;

public final class Status {

    public static final String DELETED = "deleted";
    public static final String ADDED = "added";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private String statusName;
    private Object oldValue;
    private Object newValue;

    Status(String key, Object val1, Object val2) {
        statusName = key;
        oldValue = val1;
        newValue = val2;
    }

    public String getStatusName() {
        return statusName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
