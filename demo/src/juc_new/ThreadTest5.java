package juc_new;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Fitz
 * @create 2020-10-06-10:07 上午
 */
public class ThreadTest5 {

    private static final int count = 7;

    public static void main(String[] args) {
        Random random = new Random();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            System.out.println("-----七科龙珠收集完成，可以召唤神龙了！-----");
        });

        for (int i = 1; i <= count; i++) {
            new Thread(()->{
                int sleenpTime = random.nextInt(10) * 1000;
                try {
                    Thread.sleep(sleenpTime);
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"第"+i+"个龙珠已收集").start();
        }


    }
}
