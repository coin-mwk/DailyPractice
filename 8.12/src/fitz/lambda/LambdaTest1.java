package fitz.lambda;
import fitz.collection.*;
/**
 * @author Fitz
 * @create 2020-08-18-4:32 下午
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    System.out.println("i love u");
                }
            }
        }.start();

        new Thread(()->{
            System.out.println("44444");
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("44444555");
            }
        }).start();

  
    }
}
