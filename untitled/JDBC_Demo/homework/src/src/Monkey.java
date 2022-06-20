public class Monkey {
    String feature;
    String name;

    public Monkey() {
        this.feature = "尾巴长";
        this.name = "长尾猴";
        System.out.println("我是无参构造器产生的猴子：");
    }

    public Monkey(String feature, String name) {
        this.feature = feature;
        this.name = name;
        System.out.println("我是有参构造器产生的猴子：");
    }

    @Override
    public String toString() {
        return "名称："+name+"\n"+"特征："+feature;
    }
}
