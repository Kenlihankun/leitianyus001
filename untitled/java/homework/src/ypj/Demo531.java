package ypj;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo531 {
    public static void main(String[] args) {
        int[] a = {71,89,67,53,78,64,92,56,74,85};//建立数组
        int b = a.length-1;//数组长度
        for (int i = 0; i < b; i++) {//遍历数组
            for (int j = i+1; j < b+1; j++) {//遍历数组位置i之后的数
                if (a[i]>a[j]){//判断大小
                    int c = a[j];
                    a[j]=a[i];
                    a[i] = c;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
