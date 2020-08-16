package fitz.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Fitz
 * @create 2020-08-16-4:47 下午
 *
 * Colllections工具实现类的几个常用方法
 *
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        Collections.addAll(str, "a","b","c","d");
        System.out.println(str);
        Collections.shuffle(str);
        System.out.println(str);
        //sort()方法
        Collections.sort(str);
        System.out.println(str);
        ArrayList<Person> person = new ArrayList<>();
        person.add(new Person(18, "张三"));
        person.add(new Person(22, "李四"));
        person.add(new Person(20, "王五"));
        System.out.println(person);
        Collections.sort(person);
        System.out.println(person);

    }
}
