package fitz.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Fitz
 * @create 2020-08-24-9:35 上午
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("8.12/src/fitz/io/c.txt");
        //一次写入一个字节
        fos.write(97);
        //一次写入多个字节
        byte[] bytes = {97,98,99,100};
        fos.write(49);
        fos.write(49);
        fos.write(49);
        fos.write(bytes);
        fos.write(bytes,2,2);
        byte[] bytes1 = "今天你学习了吗！".getBytes();
        System.out.println(Arrays.toString(bytes1));
        fos.write(bytes1);
        fos.close();

    }
}
