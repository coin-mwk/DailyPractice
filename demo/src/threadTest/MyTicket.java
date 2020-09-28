package threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fitz
 * @create 2020-09-26-10:32 下午
 */
public class MyTicket {

    Lock lock = new ReentrantLock();
    public static int count = 10;

    public static void setCount(int count) {
        MyTicket.count = count;
    }

    public static int getCount() {
        return count;
    }

    public synchronized void sale() {
        lock.lock();
        try {
            count --;
            System.out.println(Thread.currentThread().getName()+"票已购买，剩余票数："+count);
        }finally {
            lock.unlock();
        }

    }
}
