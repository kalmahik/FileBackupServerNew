package ru.levelp.api;

//JsonRPC
public class RequestContainer {
    private int id;
    private String method;
    private long ts;
    private int backupId;
    private String backupName;

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public long getTs() {
        return ts;
    }

    public int getBackupId() {
        return backupId;
    }

    public String getBackupName() {
        return backupName;
    }
}
