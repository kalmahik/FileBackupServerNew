package ru.levelp;

import ru.levelp.api.Methods;
import ru.levelp.api.RequestContainer;
import ru.levelp.dao.BackupInfoDatabase;
import ru.levelp.entities.BackupInfo;
import ru.levelp.utils.JsonUtil;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                String jsonRequest = reader.readLine();
                if (jsonRequest != null) {
                    RequestContainer request = JsonUtil.getInstance().jsonToRequest(jsonRequest);
                    onRequest(request);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onRequest(RequestContainer request) {
        String method = request.getMethod();
        if (method.equals(Methods.UPLOAD)) {
            receiveFile(request.getBackupName());
        } else if (method.equals(Methods.GET_HISTORY)) {
            //background thread...
        } else if (method.equals(Methods.GET_BACKUP)) {

        }
    }

    private void receiveFile(String backupName) {
        int backupId = (int) (Math.random() * Integer.MAX_VALUE);
        //Нужно проверить, занят ли этот id другим бэкапом в базе

        try {
            byte[] buffer = new byte[2048];
            int len = 0;
            InputStream input = socket.getInputStream();
            while ((len = input.read(buffer)) >= 0) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
