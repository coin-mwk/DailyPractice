package juc_new;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fitz
 * @create 2020-10-05-6:00 下午
 * 完成以下形式的输出
 *  12A34B56C.......5152Z
 *
 *  思路:可以 写两个方法，一个用来输出数字，且每次输出两个数字，一个用来输出字母
 */
public class Requirement_fun2 {

    static int num = 1;
    static int alphabetNum = 97;

    Lock lock = new ReentrantLock();

    Condition con1 = lock.newCondition();
    Condition con2 = lock.newCondition();

    static int flag = 1;

    void printNum() {
        //用来打印数字
        lock.lock();
        try {
            while (flag != 1) {
                con1.await();
            }
            System.out.print(num);
            num+=1;
            System.out.print(num);
            num+=1;
            flag = 2;
            con2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    void printAlphabet() {
        //用来打印字母
        lock.lock();
        try {
            while (flag != 2) {
                con2.await();
            }
            System.out.print(Character.toUpperCase(((char)alphabetNum)));
            alphabetNum += 1;
            flag = 1;
            con1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
