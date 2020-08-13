package fitz.collection;

import java.util.HashSet;

/**
 * @author Fitz
 * @create 2020-08-13-11:30 上午
 */
public class HashSetTest {

    public static void main(String[] args) {
        Person p1 = new Person(13, "马文凯");
        Person p2 = new Person(13, "马文凯");
        Person p3 = new Person(14, "马文凯");
        Person p4 = new Person(13, "马文");
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p4.hashCode());
    }
}
