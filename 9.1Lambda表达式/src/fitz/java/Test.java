package fitz.java;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Fitz
 * @create 2020-09-01-7:27 下午
 */
public class Test {
    public static void main(String[] args) {
//        show01();
//        show02();
        show03();
    }

    private static void show03() {
        // 情况三： 类::实例方法
        //Lambda写法
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "def"));
        //方法引用写法
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abd"));
    }

    private static void show02() {
        // 情况二： 类::静态方法
        //Lambda写法
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 13));
        //方法引用写法
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 11));
    }

    private static void show01() {
        // 情况一： 对象::实例方法
        //Lambda写法
        Consumer<String> cons1 = (s)-> System.out.println(s);
        cons1.accept("类型一lambda写法");
        //方法引用写法
        PrintStream ps = System.out;
        Consumer<String> cons2 = ps :: println;
        cons2.accept("类型一方法引用写法");
    }
}
