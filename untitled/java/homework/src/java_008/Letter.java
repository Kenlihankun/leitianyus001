package java_008;

import java.util.Random;

public class Letter implements Runnable {
    char[] chars = new char[26];

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public Letter() {
        Random random = new Random();
        for (int i = 0; i < 26; i++) {
            this.chars[i]= (char) (i+97);
        }
    }

    @Override
    public void run() {
        for (char a : chars) {
            System.out.println(a);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
