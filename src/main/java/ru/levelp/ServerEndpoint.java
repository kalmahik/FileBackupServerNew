package ru.levelp;

import ru.levelp.dao.BackupInfoDatabase;
import ru.levelp.entities.BackupInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEndpoint {
    private static final int PORT = 8686;

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                try {

                    BackupInfo backupInfo = new BackupInfo();
                    backupInfo.setId(123456);
                    backupInfo.setName("My_archive");
                    backupInfo.setCreated("12.09.1993");
                    BackupInfoDatabase.getInstance().add(backupInfo);


                    Socket clientSocket = serverSocket.accept();
                    ClientHandler handler = new ClientHandler(clientSocket);
                    handler.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
