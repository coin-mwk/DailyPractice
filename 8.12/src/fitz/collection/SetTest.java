package fitz.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Fitz
 * @create 2020-08-13-10:13 上午
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<Integer> coll = new HashSet<>();
        coll.add(1);
        coll.add(3);
        coll.add(2);
        coll.add(1);
        Iterator<Integer> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer i : coll) {
            System.out.println(i);

        }
    }
}
