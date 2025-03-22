import java.util.Arrays;
public class MergeArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2){
        int[] arr3=new int[arr1.length+arr2.length];

        int i=0,j=0;
        while (i< arr1.length){
            arr3[i]=arr1[i];
            i++;

        }
        while (j< arr2.length){
            arr3[i++]=arr2[j++];
        }
        Arrays.sort(arr3);
        return arr3;


    }

    public static void main(String[] args) {
        int[] arr1 ={1,2,3,4,5};
        int[] arr2 ={2,4,6,7,8,9};
        System.out.println("Merged array is : "+ Arrays.toString(mergeArrays(arr1, arr2)));
    }
}
