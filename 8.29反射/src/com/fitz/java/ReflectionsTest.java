package com.fitz.java;

/**
 * @author Fitz
 * @create 2020-08-29-9:16 上午
 */
public class ReflectionsTest {
    public static void main(String[] args) throws Exception {
//        Person p = new Person("马文凯",25);
//        p.age = 27;
//        System.out.println(p.age);

        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forname(String classPath)
        Class clazz3 = Class.forName("com.fitz.java.Person");
        System.out.println(clazz3);

        //方式四：使用类的加载器：ClassLoader


    }
}
