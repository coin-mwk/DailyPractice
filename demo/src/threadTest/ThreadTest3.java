package threadTest;


/**
 * @author Fitz
 * @create 2020-09-30-9:02 上午
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        MyNumTest myNumTest = new MyNumTest();

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
