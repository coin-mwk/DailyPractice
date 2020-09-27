package threadTest;

/**
 * @author Fitz
 * @create 2020-09-26-10:32 下午
 */
public class MyTicket {

    public static int count = 10;

    public static void setCount(int count) {
        MyTicket.count = count;
    }

    public static int getCount() {
        return count;
    }

    public void sale() {
        count --;
        System.out.println("票已购买，剩余票数："+count);
    }
}
