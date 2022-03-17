package hexlet.code.formatters;

public final class JsonModel {

    private String key;
    private String status;
    private Object oldValue;
    private Object newValue;

    public JsonModel(String keyName, String statusName, Object v1, Object v2) {
        this.key = keyName;
        this.status = statusName;
        this.oldValue = v1;
        this.newValue = v2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String keyName) {
        this.key = keyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statusName) {
        this.status = statusName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object v) {
        this.oldValue = v;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object v) {
        this.newValue = v;
    }
}
