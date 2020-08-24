package fitz.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-24-10:31 上午
 */
public class FileOutputStreamTest2 {
    public static void main(String[] args) throws IOException {
        FileOutputStreamTest2 file = new FileOutputStreamTest2();
        file.show01();

    }

    private void show01() throws IOException {
        FileOutputStream fos = new FileOutputStream("8.12/src/fitz/io/d.txt", true);
        byte[] bytes = "今天学习Java了吗！".getBytes();
        byte[] bytes1 = "今天学习爬虫了吗！".getBytes();
        fos.write(bytes);
        fos.close();
    }
}
