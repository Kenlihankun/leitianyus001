package coldblock;

import java.util.ArrayList;

public class staticcodetext {
    static ArrayList<String> arr = new ArrayList<>();
    static {
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] code = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                arr.add(code[i]+colors[j]);
            }
        }
        arr.add("大王");
        arr.add("小王");
    }

    public static void main(String[] args) {
        System.out.println(arr);
    }
}
