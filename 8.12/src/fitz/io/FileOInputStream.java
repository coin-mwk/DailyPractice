package fitz.io;

import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Fitz
 * @create 2020-08-24-11:11 上午
 */
public class FileOInputStream {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
//        show03();
    }

    private static void show03() throws IOException {
        FileInputStream fis = new FileInputStream("8.12/src/fitz/io/c.txt");
        byte[] bytes = new byte[1024];
        int len = 0;//记录每次读取的有效字符个数
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(bytes);
        }
    }

    private static void show02() throws IOException {
        FileInputStream fis = new FileInputStream("8.12/src/fitz/io/c.txt");
        byte[] bytes = new byte[5];
        int read = fis.read(bytes);
        System.out.println(read);
//        System.out.println(new String(bytes));

    }

    private static void show01() throws IOException {
        FileInputStream fis = new FileInputStream("8.12/src/fitz/io/c.txt");
        int len = 0;//记录读取的字符数
        while ((len = fis.read())!= -1) {
            System.out.println((char)len);
        }
        fis.close();

    }
}
