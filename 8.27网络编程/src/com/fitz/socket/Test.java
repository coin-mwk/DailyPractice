package com.fitz.socket;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Fitz
 * @create 2020-08-27-10:25 上午
 */
public class Test {
    public static void main(String[] args) {
        InetAddress inet = null;
        try {
            inet = InetAddress.getByName("www.vip.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inet);
    }
}
