package cn.cian.socket;

/**
 * @author Cian
 * @version 1.0
 * @description: TODO
 */
import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999); // 创建服务器套接字并指定端口

        System.out.println("等待客户端连接...");

        while(true){
            Socket clientSocket = serverSocket.accept(); // 等待客户端连接

            System.out.println("客户端已连接");

            // 读取文件
            File fileToSend = new File("D:\\demo.exe"); // 指定要传输的大文件的路径
            FileInputStream fileInputStream = new FileInputStream(fileToSend);
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                Thread.sleep(1);
            }
            System.out.println("文件传输完成");
            fileInputStream.close();
            outputStream.close();
            clientSocket.close();
        }
    }
}

