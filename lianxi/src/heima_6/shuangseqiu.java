package heima_6;

import java.util.Random;

public class shuangseqiu {

    public static int sb(){
        int times = 0;
        int[] arr1=new int[7];
        int[] arr2=new int[7];
        while (true){
            int end = mum(arr1,arr2);
            times++;
            if (end == 1){
                break;
            }
        }
        re(arr1);
        System.out.println();
        re(arr2);
        System.out.println();
        System.out.println(times);
        return times;
    }

    public static void main(String[] args) {
        int lo = 10;
        int all = 0;
        for (int i = 0; i < lo; i++) {
            all += sb();
        }
        System.out.println(all/lo);
    }
    public static int mum(int[] arr1 ,int[]arr2){

        change(arr1);
        change(arr2);
        int red = 0;
        int blue = 0;
        for (int i = 0; i < arr1.length-1; i++) {
            for (int j = 0; j < arr2.length-1; j++) {
                if(arr1[i] == arr2[j]){
                    red++;
                    break;
                }
            }
        }
        if (arr1[6]==arr2[6]){
            blue++;
        }
//        re(arr1);
//        System.out.println();
//        re(arr2);
//        System.out.println();
//        System.out.println(red);
//        System.out.println(blue);
        if (red == 6 && blue==1){
            return 1;
        }else {
            return 0;
        }
    }
    public static void change(int[] arr){
        Random r = new Random();
        for (int i = 0; i < arr.length-1; i++) {
            while (true){
                int data = r.nextInt(33)+1;
                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    if (arr[j] == data){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    arr[i]=data;
                    break;
                }
            }
        }
        arr[arr.length-1] = r.nextInt(16)+1;
    }
    public static void re(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }



}
