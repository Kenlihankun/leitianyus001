import java.util.ArrayList;
import java.util.List;

public class text {
    public static void main(String[] args) {
        List<Integer> shabi = new ArrayList<>();

        for (int i = 2; i < 1001; i++) {
            boolean zhangyihuanshabi = true;
            for (int j = 2; j < i-1; j++) {
                if (i%j==0){
                    zhangyihuanshabi=false;
                    break;
                }

            }
            if (zhangyihuanshabi==true){
                shabi.add(i);
            }
        }
        for (Integer integer : shabi) {
            System.out.println(integer);
        }
    }
}
