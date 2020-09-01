package com.fitz.java;


import java.io.*;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Random;

/**
 * @author Fitz
 * @create 2020-08-30-9:51 上午
 */
public class ReflectionsTest1 {
    public static void main(String[] args) throws Exception {
//        show01();
//        show02();
//            show03();
            show04();

    }

    private static void show04() throws IOException {
        Properties pr = new Properties();
        ClassLoader classLoader = ReflectionsTest1.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("info.properties");
        pr.load(is);
        System.out.println(pr.getProperty("name"));
        System.out.println(pr.getProperty("age"));
    }

    private static void show03() {
        Properties pr = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File("8.29反射/src/info.properties"));
            pr.load(fis);
            System.out.println(pr.getProperty("name"));
            System.out.println(pr.getProperty("age"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void show02() throws Exception {
        //如何操作运行时类的属性
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        //1、获取属性值
        Field name = clazz.getDeclaredField("name");
        //2、设置为可访问
        name.setAccessible(true);
        //3、修改并访问
        name.set(p,"马文凯");
        System.out.println(name.get(p));


    }

    private static void show01() throws Exception {
        Class<Person> clazz = Person.class;
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.net.Socket";
                break;
            case 2:
                classPath = "com.fitz.java.Person";
                break;
        }
        Object instance = getInstance(classPath);
        System.out.println(instance);
    }
    public static Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
//        System.out.println(clazz.getPackage());
        Object o = clazz.newInstance();
        return o;
    }
}
