package fitz.collection;

import java.util.Collection;
import java.util.*;

/**
 * @author Fitz
 * @create 2020-08-12-9:31 上午
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> str = new ArrayList<>();
        str.add("mawenkai");
        str.add("马文凯");
        str.add("李炫一");
        str.add("尤佳慧");
        Iterator<String> it = str.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
//        for (String temp : str){
//            System.out.println(temp);
//        }

    }
}
