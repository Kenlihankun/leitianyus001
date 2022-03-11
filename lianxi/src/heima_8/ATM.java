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
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------欢迎进入首页----------------");
            System.out.println("请您输入您想做的操作：");
            System.out.println("1.登录账户");
            System.out.println("2.注册开户");
            System.out.print("您可以输入命令了：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //登录
                    login(accounts,sc);
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
     * 登录功能
     * @param accounts 账户对象
     */
    public static void login(ArrayList<Account> accounts,Scanner sc){
        while (true) {
            System.out.println("-----------------进入登录操作页面----------------");
            System.out.println("请您输入登录的卡号：");
            String InCardID = sc.next();
            //查询账户
            Account account = chargeAccounts(InCardID,accounts);
            if (account!=null){
                //输入密码
                while (true) {
                    System.out.println("请输入密码：");
                    String password = sc.next();
                    if (account.getPassword().equals(password)){
                        System.out.println("感谢您"+account.getUsername()+"登录成功！您的卡号是："+account.getCardid());
                        show(account,accounts,sc);
                        return;
                    }else {
                        System.out.println("输入密码有错！");
                    }
                }
            }else {
                System.out.println("很抱歉，不存在该卡号！");
            }
        }
    }
    //查询账户
    public static Account chargeAccounts(String ID,ArrayList<Account> accounts){
        //从集合中查询
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getCardid().equals(ID)){
                return account;
            }
        }
        return null;
    }

    /**
     * 用户操作界面
     * @param accounts 账户对象
     */
    public static void show(Account account,ArrayList<Account> accounts,Scanner sc){
        while (true) {
            System.out.println("----------------用户操作界面-------------------");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账户");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //查询账户
                    showAccount(account);
                    break;
                case 2:
                    //存款
                    depositMoney(account,sc);
                    break;
                case 3:
                    //取款
                    drawMoney(account,sc);
                    break;
                case 4:
                    //转账
                    break;
                case 5:
                    //修改密码
                    break;
                case 6:
                    //退出
                    System.out.println("欢迎下次光临！");
                    return;
                case 7:
                    //注销账户
                    break;
                default:
                    System.out.println("您的命令输入有误！");
            }
        }
    }

    //1.查询账户
    private static void showAccount(Account account) {
        System.out.println("-----------------当前账户详细-----------------");
        System.out.println("卡号"+account.getCardid());
        System.out.println("姓名"+account.getUsername());
        System.out.println("余额"+account.getMoney());
        System.out.println("当此限额"+account.getQuotamoney());
    }
    //2.存款
    private static void depositMoney(Account account,Scanner sc) {
        System.out.println("-----------------存钱操作-----------------");
        System.out.println("请您输入本次存款金额：");
        double Money = sc.nextDouble();
        account.setMoney(account.getMoney()+Money);
        System.out.println("存款完成！");
        showAccount(account);
    }
    //3.取款
    private static void drawMoney(Account account, Scanner sc) {
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
