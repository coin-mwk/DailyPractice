package juc_new;

/**
 * @author Fitz
 * @create 2020-10-05-5:13 下午
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Requriment_fun1 requriment_fun1 = new Requriment_fun1();


        new Thread(()->{
            //切菜的进程
            for (int i = 0; i < 5; i++) {
            requriment_fun1.q_ve();
            }
        },"切菜线程").start();



        new Thread(()->{
            //炒菜的进程
            for (int i = 0; i < 5; i++) {
                requriment_fun1.c_ve();
            }
        },"炒菜线程").start();



        new Thread(()->{
            //端菜的进程
            for (int i = 0; i < 5; i++) {
                requriment_fun1.d_ve();
                System.out.println("第"+(i+1)+"道菜完成了");
            }
        },"端菜线程").start();

    }
}
