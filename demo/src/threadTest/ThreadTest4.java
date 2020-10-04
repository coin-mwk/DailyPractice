package threadTest;

/**
 * @author Fitz
 * @create 2020-10-04-8:25 上午
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        MyNumTestForCondition myNumTest = new MyNumTestForCondition();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myNumTest.print0();
            }
        },"打印0的线程1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myNumTest.print0();
            }
        },"打印0的线程2").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myNumTest.print1();
            }
        },"打印1的线程1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myNumTest.print1();
            }
        },"打印1的线程2").start();
    }
}
