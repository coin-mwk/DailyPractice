package com.fitz.java;

import sun.security.jca.GetInstance;

import java.util.Random;

/**
 * @author Fitz
 * @create 2020-08-30-9:51 上午
 */
public class ReflectionsTest1 {
    public static void main(String[] args) throws Exception {
        show01();

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
        Object o = clazz.newInstance();
        return o;
    }
}
