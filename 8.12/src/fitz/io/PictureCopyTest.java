package fitz.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-24-9:07 下午
 */
public class PictureCopyTest {
    public static void main(String[] args) throws IOException {
        //一个字节一个字节的读取
        long s_01 = System.currentTimeMillis();
        show01();
        long e_01 = System.currentTimeMillis();
        System.out.println("单个字符读取的复制时间为：" + (e_01 - s_01) + "毫秒");
        //用字节数组做缓冲区一次读取多个字节
        long s_02 = System.currentTimeMillis();
        show02();
        long e_02 = System.currentTimeMillis();
        System.out.println("多个字符读取的复制时间为：" + (e_02 - s_02) + "毫秒");
    }

    private static void show02() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/tonystark/Pictures/IMG_1300.jpeg");
        FileOutputStream fos = new FileOutputStream("8.12/src/fitz/io/new2.jpeg");
        byte[] bytes = new byte[1024];
        int len =0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }

    private static void show01() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/tonystark/Pictures/IMG_1300.jpeg");
        FileOutputStream fos = new FileOutputStream("8.12/src/fitz/io/new1.jpeg");
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fos.close();
        fis.close();
    }
}
