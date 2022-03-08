package create;

public class text2 {
    public static void main(String[] args) {
        int[] arr = {51,546,58,41,23};
        for (int i = 1; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
