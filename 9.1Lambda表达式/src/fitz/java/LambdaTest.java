package fitz.java;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Fitz
 * @create 2020-09-01-10:38 上午
 */
public class LambdaTest {
    public static void main(String[] args) {
        //无参无返回值
//        show01();
        //有一个参数但无返回值
//        show02();
//        show03();
//        show04();
//        show05();
        show06();
    }

    private static void show06() {
        //当Lambda体只有一条语句时，return和大括号若有，都可以省略
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 13));
        //Lambda写法
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(15, 13));
    }


    private static void show05() {
        //Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 13));
        //Lambda写法
        Comparator<Integer> com2 = (o1,o2) -> {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            };

        System.out.println(com2.compare(15, 13));
    }

    private static void show04() {
        //Lambda表达式若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("类型4正常写法");
        //Lambda表达式写法
        Consumer<String> cons = s -> System.out.println(s);
        cons.accept("类型4Lambda写法");
    }

    private static void show03() {
        //数据类型可以省略，因为可由编译器推断得出
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("类型3正常写法");
        //Lambda表达式写法
        Consumer<String> cons = (s) -> System.out.println(s);
        cons.accept("类型3Lambda写法");
    }

    private static void show02() {
        //有一个参数但无返回值
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("类型2正常写法");
        //Lambda表达式写法
        Consumer<String> cons = (String s) -> System.out.println(s);
        cons.accept("类型2Lambda写法");
    }

    private static void show01() {
        ////无参无返回值正常的匿名函数写法
        new Runnable() {
            @Override
            public void run() {
                System.out.println("类型1正常写法");
            }
        }.run();
        //Lambda表达式写法
        Runnable a = ()->System.out.println("类型1Lambda写法");

        a.run();
    }
}
