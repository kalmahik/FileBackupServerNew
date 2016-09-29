package ru.levelp.api;

import ru.levelp.entities.BackupInfo;

import java.util.ArrayList;

public class ResponseContainer {
    private int id;
    private String method;
    private long ts;
    private int backupId;
    private ArrayList<BackupInfo> history;
}
