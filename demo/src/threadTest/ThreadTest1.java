package threadTest;

/**
 * @author Fitz
 * @create 2020-09-27-5:24 下午
 */
public class ThreadTest1 {

    public static void main(String[] args) {

        MyTicket myTicket = new MyTicket();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myTicket.sale();
                }
            }).start();
        }

    }


}
