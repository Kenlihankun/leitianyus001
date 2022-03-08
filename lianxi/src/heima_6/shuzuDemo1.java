package heima_6;

public class shuzuDemo1 {
    public static void main(String[] args) {
        int[] arr1 = {12,56,85};
        int[] arr2 = {12,56,85};
        System.out.println(shu(arr1,arr2));
    }
    public static boolean shu(int[] arr1,int[] arr2){
        if(arr1.length == arr2.length){
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i]!=arr2[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
