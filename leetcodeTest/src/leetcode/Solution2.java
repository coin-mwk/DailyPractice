package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fitz
 * @create 2020-10-04-10:39 上午
 */
public class Solution2 {

    Lock lock = new ReentrantLock();
    final Condition con1 = lock.newCondition();
    final Condition con2 = lock.newCondition();
    final Condition con3 = lock.newCondition();
    int flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (flag == 1) {
                con2.await();
                con3.await();
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                con2.signal();
                flag += 1;
            }
        }finally {
            lock.unlock();
        }



    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag == 2) {
                con1.await();
                con3.await();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                con3.signal();
                flag += 1;
            }
        }finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag == 2) {
                con1.await();
                con2.await();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                con1.signal();
                flag = 1;
            }
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        new Thread().start();
    }
}
