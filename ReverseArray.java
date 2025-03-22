import java.util.Arrays;

public class ReverseArray {
     public static int[] reverseArray(int[] arr){
int[] newarr=new int[arr.length];

         for (int i = arr.length-1,j=0; i >=0; i--) {
             newarr[j++]=arr[i];

         }

return newarr;
     }
    public static void main(String[] args) {
int arr[]={1,2,3,4,5,6};
        System.out.println(Arrays.toString(reverseArray(arr)));
    }
}
