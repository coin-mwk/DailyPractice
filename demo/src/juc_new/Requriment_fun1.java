package juc_new;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fitz
 * @create 2020-10-05-5:02 下午
 * 1、切菜师傅、炒菜师傅、端菜师傅
 * 2、完成是个菜的供应
 */
public class Requriment_fun1 {

    Lock lock = new ReentrantLock();
    int flag = 1;

    final Condition con1 = lock.newCondition();
    final Condition con2 = lock.newCondition();
    final Condition con3 = lock.newCondition();

    public void q_ve() {
        while (flag != 1) {
            try {
                con1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在切菜");
        flag += 1 ;
        con2.signal();
    }

    public void c_ve() {
        while (flag !=2 ) {
            try {
                con2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在炒菜");
        flag += 1;
        con3.signal();
    }

    public void d_ve() {
        while (flag != 3) {
            try {
                con3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在端菜");
        flag = 1;
        con1.signal();
    }
}
