package java_007;

import java.util.HashSet;
import java.util.Set;

public class text_2 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student(1,"中帅哥",50));
        set.add(new Student(2,"大帅哥",40));
        set.add(new Student(3,"小帅哥",10));
        for (Student student : set) {
            System.out.println(student.toString());
        }
        System.out.println(set.add(new Student(1,"中帅哥",30)));
    }
}
