package threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Fitz
 * @create 2020-09-29-4:44 下午
 * 组合式异步编程
 *
 *
 */
public class ThreadTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //一个线程用来计算加工成本
        FutureTask<Double> futureTask1 = new FutureTask<Double>(new MyThread("加工"));
        new Thread(futureTask1).start();
        System.out.println("加工成本为："+futureTask1.get());
        //一个线程用来计算核算成本
        FutureTask<Double> futureTask2 = new FutureTask<Double>(new MyThread("核算"));
        new Thread(futureTask2).start();
        System.out.println("核算成本为："+futureTask2.get());

        //结果用来给总线程做最后的处理
        System.out.println("总成本为："+(futureTask1.get() +futureTask2.get()));
    }
}
