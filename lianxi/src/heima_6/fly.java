package heima_6;

import java.util.Scanner;

public class fly {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        System.out.print("机票原价");
        double price = r.nextDouble();
        System.out.print("月份：");
        int month = r.nextInt();
        System.out.println("仓位类型");
        String type = r.next();
        double rs = calc(price,month,type);
        System.out.println("当前机票价格："+rs);
    }

    public static double calc(double money,int month,String type){
        if(month>=5&&month<=10){
            switch (type){
                case "经济舱":
                    money *= 0.85;
                    break;
                case  "头等舱":
                    money *= 0.9;
                    break;
                default:
                    System.out.println("输入有错");
                    money = -1;
            }
        }else if(month==11||month==12||month>=1&&month<=4){
            switch (type){
                case "经济舱":
                    money *= 0.65;
                    break;
                case  "头等舱":
                    money *= 0.7;
                    break;
                default:
                    System.out.println("输入有错");
                    money = -1;
            }
        }else {
            System.out.println("输入有错");
            money = -1;
        }
        return money;
    }
}
