package fitz.lambda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fitz
 * @create 2020-08-22-11:12 下午
 */
public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("ok!");
        ServerSocket serverSocket = new ServerSocket(9955);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(len);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到了，谢谢！".getBytes());
        //释放资源
        socket.close();
        serverSocket.close();

    }
}
