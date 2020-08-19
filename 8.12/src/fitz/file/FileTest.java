package fitz.file;

import java.io.File;

/**
 * @author Fitz
 * @create 2020-08-19-12:23 下午
 */
public class FileTest {
    public static void main(String[] args) {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        File file = new File("/Users/tonystark/desktop/DailyPractice");
        System.out.println(file);
    }
}
