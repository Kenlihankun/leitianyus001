package ypj.animal;

public class Cat {//猫类
    String name;
    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {//重写equals方法
        Dog a = (Dog) o;//强转o
        if (a.name==name){//判断双方name是否相同
            System.out.println("是同类");
            return true;
        }
        return false;
    }
}
