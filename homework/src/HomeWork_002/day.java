package HomeWork_002;

import java.util.Scanner;

public class day {
    public static void main(String[] args) {
        System.out.println("请输入one到seven:");
        Scanner sc = new Scanner(System.in);
        String day = sc.next();
        switch (day){
            case "one":
                System.out.println("星期一");
                break;
            case "two":
                System.out.println("星期二");
                break;
            case "three":
                System.out.println("星期三");
                break;
            case "four":
                System.out.println("星期四");
                break;
            case "five":
                System.out.println("星期五");
                break;
            case "six":
                System.out.println("星期六");
                break;
            case "seven":
                System.out.println("星期日");
                break;
            default:
                System.out.println("您的输入不符合要求");
        }
    }
}
