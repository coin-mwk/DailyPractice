package juc_new;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Fitz
 * @create 2020-10-06-9:23 上午
 */
public class ThreadTest4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("------所有同学准备离开教室------");

        CountDownLatch countDownLatch = new CountDownLatch(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                int sleepTime = random.nextInt(10) * 1000;
                try {
                    Thread.sleep(sleepTime);
                    System.out.println(Thread.currentThread().getName()+"已经离开教室");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"同学小"+i).start();

        }
        countDownLatch.await();
        System.out.println("------所有同学已经离开教室------");
    }
}
