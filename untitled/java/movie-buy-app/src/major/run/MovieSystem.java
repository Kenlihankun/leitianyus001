package major.run;

import major.bean.Business;
import major.bean.Customer;
import major.bean.Movie;
import major.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieSystem {

    public static final List<User> ALL_USERS = new ArrayList<>();
    public static final Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();
    //测试数据
    static {
        Customer c = new Customer();
        c.setLoginName("zyf888");
        c.setPassWord("123456");
        c.setUserName("黑马刘德华");
        c.setSex('男');
        c.setMoney(10000);
        c.setPhone("110110");
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassWord("123456");
        c1.setUserName("黑马关之琳");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone("111111");
        ALL_USERS.add(c1);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b , movies); // b = []

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassWord("123456");
        b2.setUserName("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b2 , movies3); // b2 = []
    }
    public static final Scanner SC = new Scanner(System.in);
    public static User users;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final Logger LOGGER = LoggerFactory.getLogger("MovieSystem.class");

    public static void main(String[] args) {
        //主页
        showMain();
    }
    //主页
    private static void showMain() {
        while (true) {
        System.out.println("===================电影主页=======================");
        System.out.println("1.登录");
        System.out.println("2.用户注册");
        System.out.println("3.商家注册");
            System.out.println("请输入操作：");
            String command = SC.nextLine();
            switch (command){
                case "1":login();break;
                case "2":break;
                case "3":break;
                default:
                    System.out.println("输入有误！");
            }
        }

    }
    //登录
    private static void login() {
        while (true) {
            System.out.println("请输入登录名称：");
            String loginName = SC.nextLine();
            System.out.println("请输入登录密码：");
            String loginPassWord = SC.nextLine();
            User u = getUserNameByLogin(loginName);
            if (u!=null){
                if (u.getPassWord().equals(loginPassWord)){
                    System.out.println("登陆成功");
                    users = u;
                    LOGGER.info(users.getLoginName()+"登录了系统");
                    if (users instanceof Customer){
                        //客户
                        showCustomer();
                    }else {
                        //商家
                        showBusiness();
                    }
                    return;
                }else {
                    System.out.println("登陆密码有错");
                }
            }else {
                System.out.println("登录名称有错");
            }
        }
    }
    //遍历用户
    public static User getUserNameByLogin(String name){
        for (User users : ALL_USERS) {
            if (users.getLoginName().equals(name)){
                return users;
            }
        }
        return null;
    }
    /*
    用户
     */
    private static void showCustomer() {
        while (true) {
            System.out.println("============黑马电影客户界面===================");
            System.out.println(users.getUserName() + (users.getSex()=='男'? "先生":"女士" + "欢迎您进入系统" +
                    "\t余额：" + users.getMoney()));
            System.out.println("请您选择要操作的功能：");
            System.out.println("1、展示全部影片信息功能:");
            System.out.println("2、根据电影名称查询电影信息:");
            System.out.println("3、评分功能:");
            System.out.println("4、购票功能:");
            System.out.println("5、退出系统:");
            System.out.println("请输入您要操作的命令：");
            String command = SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    showAllMovies();
                    break;
                case "2":
                    break;
                case "3":
                    // 评分功能
                    scoreMovie();
                    break;
                case "4":
                    // 购票功能
                    buyMovie();
                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }
    /*
    评分功能
     */
    private static void scoreMovie() {
        if (showBuyMovie()){
            while (true) {
                System.out.println("请问想评价哪部电影：");
                String customerMovieCodeName=SC.nextLine();
                Movie movie = searchMovie(customerMovieCodeName);
                if (movie!=null){
                    System.out.println("请输入评分：");
                    String customerWriteCode = SC.nextLine();
                    movie.setListCodeByCustomer(BigDecimal.valueOf(Double.valueOf(customerWriteCode)));
                    return;
                }else {
                    System.out.println("无该影片");
                    System.out.println("是否继续评价（y/n）");
                    String command = SC.nextLine();
                    switch (command){
                        case "y":break;
                        default:return;
                    }
                }
            }
        }
        return;
    }
    /*
    从用户购买信息中返回电影对象
     */
    private static Movie searchMovie(String MovieName){
        Customer customer = (Customer) users;
        Set<Movie> list = (Set<Movie>) ((Customer) users).getMovieBooleanMap().keySet();
        for (Movie movie : list) {
            if (movie.getName().equals(MovieName)){
                return movie;
            }
        }
        return null;
    }
    /*
    展示所有已购买信息
     */
    private static Boolean showBuyMovie() {
        Customer customer = (Customer) users;
        if (customer.getMovieBooleanMap()==null||customer.getMovieBooleanMap().size()==0){
            System.out.println("无购买信息");return false;
        }
        System.out.println("\t\t\t片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t放映时间\t\t我的评分");
        customer.getMovieBooleanMap().forEach((movie, Double) ->
                System.out.println("\t\t\t"+movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                        + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice() + "\t\t"
                        + sdf.format(movie.getStartTime())+"\t\t"+Double)
                );
        return true;



    }
    /*
    展示全部排片信息
     */
    private static void showAllMovies() {
        ALL_MOVIES.forEach((business, movies) -> {
            System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone()
                    + "\t\t地址:" + business.getAddress() );
            System.out.println("\t\t\t片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
                for (Movie movie : movies) {
                    System.out.println("\t\t\t"+movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                            + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice() + "\t\t" + movie.getNumber() + "\t\t"
                            + sdf.format(movie.getStartTime()));
                }
        });
    }
    /*
    购票功能
     */
    private static void buyMovie() {
        showAllMovies();
        System.out.println("======================购票系统=========================");
        while (true) {
            System.out.println("输入店铺名称");
            String shopName = SC.nextLine();
            Business business = getBusinessByName(shopName);
            if (business==null){
                System.out.println("无该店铺");
            }else {
                List<Movie> list = ALL_MOVIES.get(business);
                if (list.size()>0){
                    while (true) {
                        System.out.println("输入电影名称：");
                        String movieName = SC.nextLine();
                        Movie movie = geiMovieByShopName(movieName,list);
                        if (movie!=null){
                            while (true) {
                                System.out.println("输入票数：");
                                String mum = SC.nextLine();
                                int integer = Integer.valueOf(mum);
                                if (movie.getNumber()>=integer){
                                    double money = BigDecimal.valueOf(integer).multiply(BigDecimal.valueOf(movie.getPrice())).doubleValue();
                                    if (money>users.getMoney()){
                                        System.out.println("钱不够");
                                        System.out.println("是否继续购买（y/n）");
                                        String command = SC.nextLine();
                                        switch (command){
                                            case "y":break;
                                            default:return;
                                        }
                                    }else {
                                        System.out.println("成功购买！");
                                        users.setMoney(users.getMoney()-money);
                                        business.setMoney(business.getMoney()+money);
                                        movie.setNumber(movie.getNumber()-integer);
                                        Customer userCode = (Customer) users;
                                        userCode.setMovieBooleanMap(movie,null);
                                        return;
                                    }
                                }else {
                                    System.out.println("没那么多票");
                                    System.out.println("是否继续购买（y/n）");
                                    String command = SC.nextLine();
                                    switch (command){
                                        case "y":break;
                                        default:return;
                                    }
                                }
                            }
                        }else {
                            System.out.println("无此电影");
                        }
                    }
                }else {
                    System.out.println("无片");
                    System.out.println("是否继续购买（y/n）");
                    String command = SC.nextLine();
                    switch (command){
                        case "y":break;
                        default:return;
                    }
                }
            }
        }
    }
    /*
    遍历并返回电影对象
     */
    private static Movie geiMovieByShopName(String movieName, List<Movie> list){
        for (Movie movie : list) {
            if (movie.getName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }
    /*
    遍历并返回商家
     */
    private static Business getBusinessByName(String shopName){
        Set<Business> businesses = ALL_MOVIES.keySet();
        for (Business business : businesses) {
            if (business.getShopName().equals(shopName)){
                return business;
            }
        }
        return null;
    }






    /*
    商家主页
     */
    private static void showBusiness() {
        while (true) {
            System.out.println("============黑马电影商家界面===================");
            System.out.println(users.getUserName() + (users.getSex()=='男'? "先生":"女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");

            System.out.println("请输入您要操作的命令：");
            String command = SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    showBusinessInfos();
                    break;
                case "2":
                    // 上架电影信息
                    addMovie();
                    break;
                case "3":
                    // 下架电影信息
                    deleteMovie();
                    break;
                case "4":
                    // 修改电影信息
                    updateMovie();
                    break;
                case "5":
                    System.out.println(users.getUserName() +"请您下次再来啊~~~");
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }
    /*
    展示全部排片信息
     */
    private static void showBusinessInfos() {
        System.out.println("==========================================商家详情界面==========================================");
        Business business = (Business) users;
        System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone()
                + "\t\t地址:" + business.getAddress() + "\t\t余额：" + business.getMoney());
        List<Movie> list = ALL_MOVIES.get(business);
        System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
        if (list.size()>0) {
            for (Movie movie : list) {
                System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                        + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice() + "\t\t" + movie.getNumber() + "\t\t"
                        + sdf.format(movie.getStartTime()));

            }
        }else {
            System.out.println("当前无片");
        }
    }
    /*
    上架电影信息
     */
    private static void addMovie() {
        System.out.println("================上架电影====================");
        // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
        Business business = (Business) users;
        List<Movie> movies = ALL_MOVIES.get(business);
        System.out.println("请您输入新片名：");
        String name  = SC.nextLine();
        System.out.println("请您输入主演：");
        String actor  = SC.nextLine();
        System.out.println("请您输入时长：");
        String time  = SC.nextLine();
        System.out.println("请您输入票价：");
        String price  = SC.nextLine();
        System.out.println("请您输入票数：");
        String totalNumber  = SC.nextLine(); // 200\n

        while (true) {
            try {
                    System.out.println("请您输入影片放映时间：");
                    String stime  = SC.nextLine();
                   //  public Movie(String name, String actor, double time, double price, int number, Date startTime) {// 封装成电影对象 ，加入集合movices中去
                    Movie movie = new Movie(name, actor ,Double.valueOf(time) , Double.valueOf(price), Integer.valueOf(totalNumber) ,  sdf.parse(stime));
                    movies.add(movie);
                System.out.println("成功上架：<<"+movie.getName()+">>");
                return;
            } catch (ParseException e) {
                e.printStackTrace();
                LOGGER.error("时间解析出问题");
            }
        }




    }
    /*
    下架电影信息
     */
    private static void deleteMovie() {
            System.out.println("================下架电影====================");
            Business business = (Business) users;
            List<Movie> movies = ALL_MOVIES.get(business);
        while (true) {
            if (movies.size()>0){
                System.out.println("请您输入需要下架的电影名称：");
                String movieName = SC.nextLine();
                Movie movie = getMovieByName(movieName);
                if (movie!=null){
                    movies.remove(movie);
                    System.out.println("成功下架");
                    return;
                }else {
                    System.out.println("没有上架该影片");
                    System.out.println("是否继续下架（y/n）");
                    String command = SC.nextLine();
                    switch (command){
                        case "y":break;
                        default:return;
                    }
                }
            }else {
                System.out.println("当前无片");
                return;
            }
        }
    }
    /*
    修改电影信息
     */
    private static void updateMovie() {
            System.out.println("================修改电影====================");
            Business business = (Business) users;
            List<Movie> movies = ALL_MOVIES.get(business);
        while (true) {
            if (movies.size()>0){
                System.out.println("请您输入需要修改的电影名称：");
                String movieName = SC.nextLine();
                Movie movie = getMovieByName(movieName);
                if (movie!=null){
                    System.out.println("暂时无修改功能");
                    return;
                }else {
                    System.out.println("没有上架该影片");
                    System.out.println("是否继续修改（y/n）");
                    String command = SC.nextLine();
                    switch (command){
                        case "y":break;
                        default:return;
                    }
                }
            }else {
                System.out.println("当前无片");
                return;
            }
        }
    }
    /*
    遍历并返回电影对象
     */
    private static Movie getMovieByName(String movieName){
        Business business = (Business) users;
        List<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

}
