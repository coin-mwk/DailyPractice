package juc_new;


import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Fitz
 * @create 2020-10-06-8:50 上午
 *
 * 读写锁的测试资源类
 *
 */
public class Requirement_fun3 {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private String obj = "";
//
//    public Requirement_fun3() {
//    }
//
//    public Requirement_fun3(String obj) {
//        this.obj = obj;
//    }

    void  read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" \t"+obj);

        }finally {
            lock.readLock().unlock();
        }
    }

    void write(String obj) {
        this.obj = obj;
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" \t"+obj);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           lock.writeLock().unlock();
        }
    }

}
