package threadTest;

/**
 * @author Fitz
 * @create 2020-09-30-8:59 上午
 */
public class MyNumTest {

    public static int num = 0;

    public void print0() {
        if (num == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"打印："+num);
        this.notifyAll();

    }

    public void print1() {
        if (num != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"打印："+num);
        num++;
        this.notifyAll();
    }
}
