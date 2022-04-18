package java_007;

import java.util.ArrayList;
import java.util.List;

public class text_1 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"中帅哥",2000.0));
        list.add(new Employee(2,"大帅哥",5000.0));
        list.add(new Employee(3,"小帅哥",1000.0));
        System.out.println("员工姓名\t\t\t员工薪资");
        for (Employee employee : list) {
            System.out.print(employee.getName()+"\t\t\t");
            System.out.println(employee.getSalary());
        }
    }
}
