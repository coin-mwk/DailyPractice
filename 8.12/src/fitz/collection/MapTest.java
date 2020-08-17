package fitz.collection;

import java.util.*;

/**
 * @author Fitz
 * @create 2020-08-17-6:24 下午
 */
public class MapTest {
    public static void main(String[] args) {
//        Map<String,Integer> map = new HashMap<>();
//        map.put("马文凯",170);
//        map.put("马东旭",180);
//        map.put("马煜",171);
//        map.put("尤佳慧",167);
//        Set<Map.Entry<String, Integer>> set = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> it = set.iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, Integer> entry = it.next();
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }


//        Set<String> set = map.keySet();
////        for (String s : set) {
////            System.out.println(s+":"+map.get(s));
////        }
//        Iterator it = set.iterator();
//        while(it.hasNext()) {
//            System.out.println(map.get(it.next()));
//        }


//        //使用自定义类型的key值,重写了hashCode()方法和equals()方法
//        HashMap<Person, String> map1 = new HashMap<>();
//        map1.put(new Person(12,"马文凯"),"宁夏");
//        map1.put(new Person(20,"马东旭"),"上海");
//        map1.put(new Person(13,"尤佳慧"),"天津");
//        map1.put(new Person(19,"马雨煜"),"内蒙");
//        map1.put(new Person(12,"马文凯"),"美国");
//        Set<Person> p1 = map1.keySet();
//        for (Person person : p1) {
//            System.out.println(person+map1.get(person));
//        }


        //使用自定义类型的key值,没有重写了hashCode()方法和equals()方法

        HashMap<Student, String> map1 = new HashMap<>();
        map1.put(new Student(12,"马文凯"),"宁夏");
        map1.put(new Student(20,"马东旭"),"上海");
        map1.put(new Student(13,"尤佳慧"),"天津");
        map1.put(new Student(19,"马雨煜"),"内蒙");
        map1.put(new Student(12,"马文凯"),"美国");
        Set<Map.Entry<Student, String>> entry = map1.entrySet();
        Iterator<Map.Entry<Student, String>> it = entry.iterator();
        while (it.hasNext()) {
            Map.Entry<Student, String> temp = it.next();
            System.out.println(temp.getKey() + temp.getValue());
        }


    }
}
