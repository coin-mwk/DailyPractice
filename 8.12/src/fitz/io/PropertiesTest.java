package fitz.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author Fitz
 * @create 2020-08-25-5:26 下午
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
        show03();
    }

    private static void show03() throws IOException {
        Properties pr = new Properties();
        pr.load(new FileReader("8.12/src/fitz/io/e.txt"));
        Set<String> set = pr.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+"="+pr.getProperty(s));

        }

    }

    private static void show02() throws IOException {
        FileWriter fw = new FileWriter("8.12/src/fitz/io/e.txt", true);
        Properties pr = new Properties();
        pr.setProperty("姓名","马文凯");
        pr.setProperty("年龄","23");
        pr.setProperty("性别","男");
        pr.store(fw, "save date");
        fw.close();
    }

    private static void show01() {
        Properties pr = new Properties();
        pr.setProperty("姓名","马文凯");
        pr.setProperty("年龄","23");
        pr.setProperty("性别","男");
        Set<String> str = pr.stringPropertyNames();
        for (String s : str) {
            System.out.println(s+":"+pr.getProperty(s));
        }
    }
}
