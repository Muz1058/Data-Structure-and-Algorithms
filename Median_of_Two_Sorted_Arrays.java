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



// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         // Ensure nums1 is the smaller array for binary search efficiency
//         if (nums1.length > nums2.length) {
//             return findMedianSortedArrays(nums2, nums1);
//         }
        
//         int x = nums1.length;
//         int y = nums2.length;
        
//         int low = 0;
//         int high = x;
        
//         while (low <= high) {
//             // Partition points
//             int partitionX = (low + high) / 2;
//             int partitionY = (x + y + 1) / 2 - partitionX;
            
//             // Edge case values
//             int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
//             int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            
//             int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
//             int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            
//             // Check if we have found the correct partition
//             if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
//                 // If total length is odd
//                 if ((x + y) % 2 == 1) {
//                     return (double)Math.max(maxLeftX, maxLeftY);
//                 }
//                 // If total length is even
//                 return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
//             }
            
//             // Adjust the partition
//             if (maxLeftX > minRightY) {
//                 // Move towards left in X
//                 high = partitionX - 1;
//             } else {
//                 // Move towards right in X
//                 low = partitionX + 1;
//             }
//         }
        
//         // If input arrays were not sorted
//         throw new IllegalArgumentException("Input arrays are not sorted.");
//     }
    
//     // Test cases
//     public static void main(String[] args) {
//         Solution solution = new Solution();
        
//         // Test Case 1
//         int[] nums1 = {1, 3};
//         int[] nums2 = {2};
//         System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0
        
//         // Test Case 2
//         int[] nums3 = {1, 2};
//         int[] nums4 = {3, 4};
//         System.out.println(solution.findMedianSortedArrays(nums3, nums4)); // Expected: 2.5
        
//         // Additional Test Cases
//         int[] nums5 = {1, 3, 5};
//         int[] nums6 = {2, 4, 6};
//         System.out.println(solution.findMedianSortedArrays(nums5, nums6)); // Expected: 3.5
        
//         int[] nums7 = {};
//         int[] nums8 = {1};
//         System.out.println(solution.findMedianSortedArrays(nums7, nums8)); // Expected: 1.0
//     }
// }