package HomeWork_002;

public class max {
    public static void main(String[] args) {
        int[] arr1 = {10,21,32,2,6,18,23};
        int max = ma(arr1);
        System.out.println(max);
    }
    public static int ma(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
