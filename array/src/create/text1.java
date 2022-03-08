package create;

import java.util.Random;

public class text1 {
    public static void main(String[] args) {
        int[] math = new int[5];
        Random r = new Random();
        for (int i = 0; i < math.length; i++) {
            math[i] = r.nextInt(20)+1;
        }
        for (int i = 0; i < math.length; i++) {
            System.out.println(math[i]);
        }
    }
}
