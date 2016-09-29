package ru.levelp.dao;

import ru.levelp.entities.BackupInfo;

import java.util.List;

/**
 * Методы, которые должны быть в базе данных, для хранения информации о бэкапах
 */
public interface BackupInfoDao {

    void add(BackupInfo backupInfo);

    BackupInfo get(int id);

    List<BackupInfo> getAll();
}


