package com.itheima.type;

public class typeDemo1 {
    public static void main(String[] args) {
        //自动类型转换
        byte a = 2;
        int b = a;
        System.out.println(a);
        System.out.println(b);
        double c = b;
        System.out.println(c);
        char d = '饶';
        System.out.println(d);
        int e = d;
        System.out.println(e);
        int i = 5;
        int p = i++;
        System.out.println(p);
        System.out.println(i);
    }
}
