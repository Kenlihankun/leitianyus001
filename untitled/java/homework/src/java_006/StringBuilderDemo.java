package java_006;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("欢迎来到");
        s.append("DGUT");
        s.delete(0,4);
        s.insert(0,"你好！");
        s.replace(2,3,",");
        System.out.println(s);
    }
}
