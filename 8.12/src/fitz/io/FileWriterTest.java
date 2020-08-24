package fitz.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-24-10:18 下午
 */
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        show01();
    }

    private static void show01() throws IOException {
        FileWriter fw = new FileWriter("8.12/src/fitz/io/e.txt");
        fw.write("ddd");
        fw.flush();
        fw.close();
    }
}
