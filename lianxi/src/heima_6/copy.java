package heima_6;

public class copy {
    public static void main(String[] args) {
        int[] arr1 = {11,22,33,44,55};
        int[] arr2 = new int [arr1.length];
        copy(arr1,arr2);
        said(arr1);
        System.out.println("_____________");
        said(arr2);

    }
    public static void said(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void copy (int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }
}
