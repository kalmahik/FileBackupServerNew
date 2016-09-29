package ru.levelp;

public class Main {
    public static void main(String[] args) {
        new ServerEndpoint().startServer();
    }

    /*
    Дома
    1) Создать табличку в БД для BackupInfo
    2) Проверить работу с БД из сервера
    3) Написать класс BackupDatabase с методами:
        add(BackupInfo)
        get(int id)
        getAll()

        id - НЕ AutoIncrement
            НО PrimaryKey
     */
}
