package fitz.collection;

/**
 * @author Fitz
 * @create 2020-08-13-10:54 下午
 */
public class ArryTest {

    public static int add(int...arry) {
        int sum = 0;
        for (int i : arry) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        int count1 = add(10);
        int count2 = add(10,10,10);
        System.out.println(count1);
        System.out.println(count2);


    }
}
