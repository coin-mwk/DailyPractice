package com.fitz.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fitz
 * @create 2020-08-28-11:57 上午
 */
public class TCPTest2 {
    public static void main(String[] args) {
        server_test();
    }
    private static void server_test() {
        //这是服务器的方法
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            //以下写法可能会出现乱码
//            while ((len = is.read(bytes)) != -1) {
//                String str = new String(bytes, 0, len);
//                System.out.println(str);
//            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes,0,len);
            }
            System.out.println("接收到来自与IP地址为" + socket.getInetAddress().getHostAddress() + "的信息");
            System.out.println(bos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
