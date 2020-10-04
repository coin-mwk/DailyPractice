package threadTest;

/**
 * @author Fitz
 * @create 2020-09-30-8:59 上午
 */
public class MyNumTest {

    public static int num = 0;

    public synchronized void print0() {
        while (num == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"打印："+num);

        //唤醒打印1的线程
        this.notifyAll();

    }

    public synchronized void print1() {
        while (num != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"打印："+num);

        this.notifyAll();
    }
}
