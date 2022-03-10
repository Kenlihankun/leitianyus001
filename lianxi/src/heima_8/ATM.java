package heima_8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        //首页：登录 开户
       showmain(accounts);
    }

    public static void showmain(ArrayList<Account> accounts){
        System.out.println("---------------欢迎进入首页----------------");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入您想做的操作：");
            System.out.println("1.登录账户");
            System.out.println("2.注册开户");
            System.out.print("您可以输入命令了：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //登录

                    break;
                case 2:
                    //开户
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("您的命令不被支持");
            }
        }
    }

    /**
     * 开户功能
     * @param accounts 账户对象
     */
    public static void register(ArrayList<Account> accounts,Scanner sc){
        System.out.println("----------------用户开户功能-----------------");
        //键盘录入 姓名 密码 确认密码
        System.out.println("请您输入开户名称");
        String name = sc.next();
        String password;
        while (true) {
            System.out.println("请您输入开户密码");
            password = sc.next();
            System.out.println("请您输入确认密码");
            String okPassword = sc.next();
            //判断密码是否一致
            if (okPassword.equals(password)){
                break;
            }else {
                System.out.println("两次密码不一致");
            }
        }
        System.out.println("请您输入当此限额：");
        double quotaMoney = sc.nextDouble();
        //生成卡号
       String cardID = creatrCarID(accounts);
        //生成对象
        Account account =new Account();
        account.setCardid(cardID);
        account.setUsername(name);
        account.setPassword(password);
        account.setQuotamoney(quotaMoney);
        accounts.add(account);
        System.out.println("恭喜您开户成功，您的卡号是："+cardID);
    }
    //生成卡号且不重复 八位
    public static String creatrCarID(ArrayList accounts){
        String cardID="";
        do {
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                cardID +=r.nextInt(10);
            }
            //判断卡号是否重复
        } while (getAccounts(cardID,accounts));
        return cardID;
    }

    public static Boolean getAccounts(String ID,ArrayList<Account> accounts){
        //从集合中查询
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getCardid().equals(ID)){
                return true;
            }
        }
        return false;
    }
}
