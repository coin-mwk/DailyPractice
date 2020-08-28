package com.fitz.socket;

import sun.applet.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fitz
 * @create 2020-08-28-11:02 上午
 */
public class TCPTest1 {
    public static void main(String[] args) throws IOException {
        client_test();
    }

    private static void client_test() {
        //这是客户端方法
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            os = socket.getOutputStream();
            os.write("你好！这是马文凯！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null) {
                try {
                    os.close();
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
        }
    }
}
