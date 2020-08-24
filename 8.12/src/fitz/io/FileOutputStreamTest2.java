package fitz.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-24-10:31 上午
 */
public class FileOutputStreamTest2 {
    public static void main(String[] args) throws IOException {
//        show01();
        show02();

    }

    private static void show02() throws IOException {
        FileInputStream fis = new FileInputStream("8.12/src/fitz/io/d.txt");
        byte[] bytes = new byte[2];
        int len = 0; //记录每次读取的有效字节数
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(len);
            System.out.println(new String(bytes));
        }

        fis.close();


    }

    private static void show01() throws IOException {
        FileOutputStream fos = new FileOutputStream("8.12/src/fitz/io/d.txt", true);
        fos.write("今天学习Java了吗！\r".getBytes());
        fos.write("今天学习爬虫了吗！\r".getBytes());
        fos.close();
    }
}
