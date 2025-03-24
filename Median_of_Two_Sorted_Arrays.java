import java.util.Arrays;
public class Median_of_Two_Sorted_Arrays{
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int length1 = nums1.length;
        int length2 = nums2.length;
        int[] mergedArray = new int[length1 + length2];
        for (int i = 0; i < length1; i++) {
            mergedArray[i] = nums1[i];
        }   
       
        for (int i = 0; i < length2; i++) {
            mergedArray[length1 + i] = nums2[i];
        }
         
        Arrays.sort(mergedArray);
       
        int mid=mergedArray.length;
        double median;

        if(mid%2!=0){
            median = mergedArray[mid/2];
        }
        else{
            mid/=2;
            median = (mergedArray[mid-1] + mergedArray[mid]);
            median/=2;
        }
        return median;
    }
    public static void main(String[] args) {
        int []nums1 = {1,2};
        int []nums2 = {3,4};
        double median=findMedianSortedArrays(nums1,nums2);
        System.err.println("\noutput : "+ median);

        
    }
}