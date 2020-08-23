package fitz.file;

import java.io.File;
import java.io.IOException;

/**
 * @author Fitz
 * @create 2020-08-23-8:44 下午
 */
class Test2 {

    public void show02() {
        File file1 = new File("/Users/tonystark/desktop/DailyPractice");
        System.out.println(file1.exists());
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
    }

    public void show03() throws IOException {
        File file2 = new File("/Users/tonystark/desktop/DailyPractice/8.12/src/1.txt");
        boolean b1 = file2.createNewFile();
        System.out.println(b1);
        if (b1 == false) {
//            boolean b2 = file2.delete("/Users/tonystark/desktop/DailyPractice/8.12/src/1.txt");
        }
    }

    public void show04() {
        File file = new File("/Users/tonystark/desktop/DailyPractice/8.12/src/aaa");
        boolean mk = file.mkdirs();
        System.out.println(mk);
        System.out.println(file.delete());
    }
}
public class FileTest2 {
    public static void main(String[] args) throws IOException {
        Test2 test2 = new Test2();

//        test2.show02();
//        test2.show03();
        test2.show04();
    }

}
