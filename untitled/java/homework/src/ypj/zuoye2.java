package ypj;
//主类
public class zuoye2  {
    //主方法
    public static void main(String[] args) {
        //输入几行
       all(1000);//调用all方法
    }
    /*
    all方法 画图
     */
    public static void all(int n){
        //判断行数奇偶
        if (n%2==0){
            n = (n+1)/2-1;//计算上下部分行数
            int mum = n*2;//计算中间行数判断前提
            top(n);//调用
            center(mum);//调用
            down(n);//调用
        }else {
            n = (n+1)/2;//计算上下部分行数
            int mum = n*2-1;//计算中间行数判断前提
            top(n);//调用
            center(mum);//调用
            down(n);//调用
        }
    }
    /*
    top方法 画上半部分
     */
    public static void top(int n){
        //控制行数
        for (int i = 0; i < n; i++) {
            //控制空格数
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            //控制字符数
            for (int j = 0; j < i*2-1; j++) {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }
    /*
    center方法 画中间
     */
    public static void center(int n){
        //判断奇偶
        if (n%2==0){
            //中间打两行
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < n - 1; i++) {
                    //控制字符数
                    System.out.print("*");
                }
                //换行
                System.out.println();
            }
        }else {
            //中间打一行
            for (int i = 0; i < n; i++) {
                //控制字符数
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }
    //down方法 画下半部分
    public static void down(int n){
        //控制行数
        for (int i = n; i > 0; i--) {
            //控制空格数
            for (int j = i; j < n+1; j++) {
                System.out.print(" ");
            }
            //控制字符数
            for (int j = 0; j < i*2-3; j++) {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }
}
