package ypj;

import ypj.animal.Cat;
import ypj.animal.Dog;

public class Demo55 {
    public static void main(String[] args) {

        Cat a = new Cat("dwd");//建立猫
        Dog b = new Dog("dwd");//建立狗
        System.out.println(a.equals(b));//比较a和b
    }
}
