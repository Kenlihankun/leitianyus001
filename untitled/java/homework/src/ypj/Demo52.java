package ypj;

public class Demo52 {
    public static void main(String[] args) {
        for (int i = 1; i < 100+1; i++) {//从1遍历到100
            if (search(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean search(int a){//定义寻找素数方法
        if (a!=1) {//先判断是否为1
            for (int i = 2; i < a+1; i++) {//从2到a遍历
                if (a%i==0){//是否可以整除
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
