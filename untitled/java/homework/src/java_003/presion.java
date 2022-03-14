package java_003;

public class presion {
    private String name;
    private int age;
    private String grand;

    public presion() {
    }

    public presion(String name, int age, String grand) {
        if (age>0&&age<100){
            this.age = age;
        }else {
            System.out.println("年龄不正确");
        }
        this.name = name;
        if (grand.equals("大一")||grand.equals("大二")||grand.equals("大三")||grand.equals("大四")){
            this.grand=grand;
        }else {
            System.out.println("请输入大一到大四");
        }
    }

    public void student(){
        System.out.println("我是一名学生");
    }

    public void sex(String sex){
        System.out.println("我是一个"+sex+"孩。");
    }

    public void  myself(){
        System.out.println("我叫"+name+"，今年"+age+"岁了，读"+grand+"了。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>0&&age<100){
            this.age = age;
        }else {
            System.out.println("年龄不正确");
        }
    }

    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        if (grand.equals("大一")||grand.equals("大二")||grand.equals("大三")||grand.equals("大四")){
            this.grand=grand;
        }else {
            System.out.println("请输入大一到大四");
        }
    }
}
