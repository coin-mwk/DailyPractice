package fitz.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Fitz
 * @create 2020-08-22-10:14 下午
 *
 * 1、创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
 * 2、使用Socket中的方法getOutputStream()获取网络输出字节流OutputStreaam对象
 * 3、使用网络输出字节流OutputStream对象的方法write，给服务器发送数据
 * 4、使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
 * 5、使用网络输入字节流InputStream对象中的方法read，读取服务器回写的数据
 * 6、释放socket资源
 * 注意：
 *      1、客户端和服务器端进行交互，必须使用Socket中提供的网络流,不能使用自己创建的流对象
 *
 */


//TCP客户端
public class SocketTest1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9955);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好！";
        outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        socket.close();
    }
}
