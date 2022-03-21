package java_004;

public class text {

    public static void main(String[] args) {
        Fruits f1 = new Fruits("香蕉","香甜");
        Fruits f2 = new Fruits("香蕉","香甜");
        f1.eat();
        System.out.println("f1与f2比较结果："+f1.equals(f2));
        System.out.println("-----------------------------");
        Waxberry w1 = new Waxberry("圆形","酸甜适中","紫红色");
        w1.face();
        w1.eat();
        System.out.println(w1.toString());
        System.out.println("-------------------------------");
        Banana b1 = new Banana("短而稍圆","果肉香甜","仙人蕉");
        b1.advantage();
        b1.advantage("黄色");

    }

}
