package cn.cian.socket;

/**
 * @author Cian
 * @version 1.0
 * @description: TODO
 */
import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 9999); // 连接到服务器

        // 保存接收到的文件
        File receivedFile = new File("D:\\a.exe");
        FileOutputStream fileOutputStream = new FileOutputStream(receivedFile);
        InputStream inputStream = clientSocket.getInputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
            System.out.println("接收完毕");
        }

        System.out.println("文件接收完成");
        fileOutputStream.close();
        inputStream.close();
        clientSocket.close();
    }
}

