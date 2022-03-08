package scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请你输入年龄:");
        int age = sc.nextInt();
        System.out.println("您的年龄是：" + age);
        System.out.println("请输入您的名称:");
        String name = sc.next();
        System.out.println("欢迎：" + name);

    }
}
