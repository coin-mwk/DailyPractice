package juc_new;

/**
 * @author Fitz
 * @create 2020-10-05-6:05 下午
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        Requirement_fun2 requirement_fun2 = new Requirement_fun2();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                requirement_fun2.printNum();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                requirement_fun2.printAlphabet();
            }
        }).start();
    }
}
