package heima_6;

public class sushu {
    public static void main(String[] args) {
        for (int i = 101; i < 200; i++) {
            boolean flag = true;
            for (int j = 2; j <i/2 ; j++) {
                if(i%j==0){
                    flag = false;
                }
            }
            if(flag){
                System.out.print(i+"\t");
            }
        }
    }

}
