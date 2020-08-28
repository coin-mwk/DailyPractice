package com.fitz.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Fitz
 * @create 2020-08-28-8:46 下午
 */
public class TCPCloentTest1 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
            os = socket.getOutputStream();
            is = socket.getInputStream();
            fis = new FileInputStream(new File("8.27网络编程/src/com/fitz/socket/new.jpeg"));
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes,0,len);
            }
            socket.shutdownOutput();
            int len1 = 0;
            byte[] bytes1 = new byte[1024];
            bos = new ByteArrayOutputStream();
            while ((len1 = is.read(bytes1)) != -1) {
                bos.write(bytes1,0,len1);
            }
            System.out.println("以下为服务器返回的信息");
            System.out.println(bos.toString());
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
            if (fis!=null) {
                try {
                    fis.close();
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
