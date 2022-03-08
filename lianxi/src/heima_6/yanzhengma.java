package heima_6;

import java.util.Random;
import java.util.Scanner;

public class yanzhengma {
    public static void main(String[] args) {
        Scanner r =new Scanner(System.in);
        String code = arr(1);
        System.out.println(code);
    }
    public static String arr(int num){
        String code = "";
        Random r =new Random();
        for (int i = 0; i < num; i++) {
            int type = r.nextInt(3);
            switch (type){
                case 0:
                    char ch1 = (char) (r.nextInt(26)+65);
                    code += ch1;
                    break;
                case 1:
                    char ch2 = (char) (r.nextInt(25)+97);
                    code += ch2;
                    break;
                case 2:
                    code += r.nextInt(8);
                    break;
            }
        }
        return code;
    }
}
