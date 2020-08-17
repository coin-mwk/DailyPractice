package fitz.collection;

/**
 * @author Fitz
 * @create 2020-08-17-11:37 上午
 */
public class Student {
    public int age;
    public String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
