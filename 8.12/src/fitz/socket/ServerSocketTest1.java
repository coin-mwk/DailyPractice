package fitz.socket;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fitz
 * @create 2020-08-22-10:29 下午
 * 1、创建服务器ServerSocket对象，绑定端口号
 * 2、使用accept()方法获取请求的客户端对象socket
 *
 *
 */

//TCP通信的服务器端，要实现接收客户端的请求，读取客户端的数据并给客户端回写数据
public class ServerSocketTest1 {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对想并绑定端口号（不绑定端口号的话端口号会默认给出）
        ServerSocket serverSocket = new ServerSocket(9955);
        //调用accept()方法接收客户端的请求对象socket
        Socket socket = serverSocket.accept();
        //调用socket对象的方法getInputStream()获取网络字节输入流对象
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到了，谢谢！".getBytes());
        //释放资源
        socket.close();
        serverSocket.close();
    }
}
