package threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fitz
 * @create 2020-10-04-8:21 上午
 */
public class MyNumTestForCondition {


    public static int num = 0;

    Lock lock = new ReentrantLock();

    final Condition con1 = lock.newCondition();
    final Condition con0 = lock.newCondition();

    public synchronized void print0() {
        while (num == 0) {
            try {
                con0.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"打印："+num);

        //唤醒打印1的线程
        con1.signal();

    }

    public synchronized void print1() {
        while (num != 0) {
            try {
                con1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"打印："+num);

        con0.signal();
    }
}
