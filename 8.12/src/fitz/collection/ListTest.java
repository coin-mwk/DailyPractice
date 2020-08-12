package fitz.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Fitz
 * @create 2020-08-12-11:08 上午
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.add(2,"mawenkai");
        System.out.println(list);
        list.remove(list.size()-1);
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
