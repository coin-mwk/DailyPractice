package fitz.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Fitz
 * @create 2020-08-14-7:54 下午
 */
public class NewTest {
    public static void main(String[] args) {
        //测试类
        ArrayList<Student> stu = new ArrayList<>();
        stu.add(new Student(15, "马文凯"));
        stu.add(new Student(30, "马东旭"));
        stu.add(new Student(16, "马煜"));
        stu.add(new Student(21, "尤佳慧"));
        stu.add(new Student(15, "和风"));

        System.out.println(stu);
        Collections.sort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int ret = o1.getAge() - o2.getAge();
                if(ret == 0) {
                    ret = o1.getName().charAt(0) - o2. getName().charAt(0);
                }
                return ret;
            }
        });
        System.out.println(stu);
    }
}
