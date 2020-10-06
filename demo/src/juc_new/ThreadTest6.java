package juc_new;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author Fitz
 * @create 2020-10-06-10:40 上午
 */
public class ThreadTest6 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("第"+Thread.currentThread().getName()+"位车主抢到了车位");
                    Thread.sleep(new Random().nextInt(5)*1000);
                    System.out.println("-------------第"+Thread.currentThread().getName()+"位车主已离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
