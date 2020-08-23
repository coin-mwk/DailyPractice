package fitz.file;

import java.io.File;

/**
 * @author Fitz
 * @create 2020-08-19-12:23 下午
 */
class Test {
    public void show01() {
        File file = new File("/Users/tonystark/desktop/DailyPractice");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.length());
        File file2 = new File("a.txt");
        System.out.println(file2);
        System.out.println(file2.getAbsoluteFile());
    }
}
public class FileTest {
    public static void main(String[] args) {
//        System.out.println(File.separator);
//        System.out.println(File.pathSeparator);
//      路径名真实存在时
//        File file = new File("/Users/tonystark/desktop/DailyPractice");
//        System.out.println(file);

//        File file2 = new File("/Users/tonystark", "desktop");
//        System.out.println(file2);
        Test test = new Test();
        test.show01();


    }
}
