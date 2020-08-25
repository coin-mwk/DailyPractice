package fitz.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-25-4:19 下午
 */
public class Test {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        try (FileWriter fw = new FileWriter("8.12/src/fitz/io/e.txt", true);) {
            fw.write("这是新加的字符串！\r");
            fw.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
