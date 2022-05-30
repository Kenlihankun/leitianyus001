package ypj;

import java.util.Arrays;
import java.util.Comparator;

public class Demo532 {
    public static void main(String[] args) {
        Integer[] a = {71,89,67,53,78,64,92,56,74,85};//建立数组
        Arrays.sort(a,(Integer b , Integer c)-> {return c-b;});//使用lambda方式简化Arrays的sort方法，对a数组进行排序
        System.out.println(Arrays.toString(a));
    }
}
