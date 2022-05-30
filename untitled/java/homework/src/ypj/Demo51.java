package ypj;

public class Demo51 {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 97; i < 123; i++) {//遍历英文字母
            char b = (char) i;//强转
            System.out.print(b+" ");
            a+=b;//相加
        }
        System.out.println();//换行
        System.out.println(a);
    }
}
