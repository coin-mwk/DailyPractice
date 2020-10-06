package juc_new;

/**
 * @author Fitz
 * @create 2020-10-06-8:57 上午
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Requirement_fun3 requirement_fun3 = new Requirement_fun3();

        new Thread(()->{
            requirement_fun3.write("同学们，下课啦！");
        },"王老师").start();

        new Thread(()->{
            requirement_fun3.write("同学们，没有下课！继续上课！");
        },"李老师").start();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                requirement_fun3.read();
            },"同学"+i).start();
        }



    }
}
