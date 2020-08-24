package fitz.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-24-10:06 下午
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
//        show01();
        show02();
    }

    private static void show02() throws IOException {
        FileReader fr = new FileReader("8.12/src/fitz/io/d.txt");
        int len = 0;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }

    private static void show01() throws IOException {
        FileReader fr = new FileReader("8.12/src/fitz/io/d.txt");
        int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.print((char)len);
        }
        fr.close();
    }
}
