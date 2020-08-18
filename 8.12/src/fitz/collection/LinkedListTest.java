package fitz.collection;
import java.util.*;

/**
 * @author Fitz
 * @create 2020-08-18-9:07 上午
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 != 0) {
                it.remove();
            }
        }
        System.out.println(list);
    }
}
