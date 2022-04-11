package java_006;

import java.util.Locale;

public class StringDemo {
    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = s.substring(2,5);
        String s2 = s1.toUpperCase();
        String s3 = s2.replace("DE","MM");
        System.out.println(s3);
    }
}
