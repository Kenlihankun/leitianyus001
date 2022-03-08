package heima_7;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopCarTest {
    public static void main(String[] args) {
        ArrayList<Goods> goods = new ArrayList<>();
        Scanner sc =new Scanner(System.in);
        while (true){
            System.out.println("添加商品：add");
            System.out.println("查看商品：query");
            System.out.println("修改数量：update");
            System.out.println("结算价格：pay");
            System.out.println("请您选择要操作的功能：");
            String command = sc.next();
            switch (command){
                case "add":
                    addgoods(goods);
                    break;
                case "query":
                    view(goods);
                    break;
                case "update":
                    change(goods);
                    break;
                case "pay":
                    money(goods);
                    break;
                default:
                    System.out.println("输入有错");
            }
        }
    }

    public static void addgoods(ArrayList<Goods> goods){
        Scanner sc =new Scanner(System.in);
        Goods goods1 = new Goods();
        System.out.println("请输入商品编号：");
        goods1.setId(sc.nextInt());
        System.out.println("请输入商品名称：");
        goods1.setName(sc.next());
        System.out.println("请输入商品价格：");
        goods1.setPrice(sc.nextDouble());
        System.out.println("请输入商品数量：");
        goods1.setBuyNumber(sc.nextInt());
        goods.add(goods1);
        view(goods);
    }

    public static void view(ArrayList<Goods> goods){
        System.out.println("商品编号\t商品名称\t商品价格\t商品的购买数量");
        for (int i = 0; i < goods.size(); i++) {
            Goods goods1 = goods.get(i);
            System.out.print(goods1.getId()+"\t"+goods1.getName()+"\t"+goods1.getPrice()+"\t"+ goods1.getBuyNumber());
            System.out.println();
        }
    }
    public static void change(ArrayList<Goods> goods){
        System.out.println("请输入你想更改的商品名称：");
        Scanner sc =new Scanner(System.in);
        String name = sc.next();
        for (int i = 0; i < goods.size(); i++) {
            Goods goods1 = goods.get(i);
            if (goods1.getName().equals(name)){
                System.out.println("请输入更改数量：");
                int mum = sc.nextInt();
                goods1.setBuyNumber(mum);
                break;
            }

        }
        System.out.println("无此商品");
        view(goods);
    }

    public static void money(ArrayList<Goods> goods){
        double mon = 0;
        for (int i = 0; i < goods.size(); i++) {
            Goods goods1 = goods.get(i);
            mon += (goods1.getPrice()*goods1.getBuyNumber());
        }
        System.out.println("价格一个是"+mon);
    }
}
