package d2;

public class Demo1 {
    public static void main(String[] args) {
        f(5);
        System.out.println(f(5));
        System.out.println(f1(10));
        f1(10);
        System.out.println(f1(9));
        int mum = 1534;
        for (int i = 0; i < 9; i++) {
            mum = (mum/2) -1;
        }
        System.out.println(mum);
    }
    public static int f(int n){
        if (n == 1){
            return 1;
        }else {
            return f(n-1)*n;
        }
    }
    public static int f1(int n){
        if (n == 1){
            return 1;
        }else {
            return (f1(n-1)+1)*2;
        }
    }
}
