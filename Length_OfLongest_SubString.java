// import java.util.Scanner;

// public class Length_OfLongest_SubString {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         System.out.print("Enter Your Sequence: ");
//         String s = input.nextLine();

//         String longString = "";
//         String tempString = "";

//         for (int i = 0; i < s.length(); i++) {
//             char temp = s.charAt(i);
//             if (tempString.contains(String.valueOf(temp))) {
//                 if (longString.length() < tempString.length()) {
//                     longString = tempString;
//                     tempString = "";
//                 } else {
//                     tempString = "";
//                 }
//             }
//             tempString += temp;
//         }

//         System.out.println("Longest Set Characters are: " + (longString.length() > 0 ? longString : tempString));
//         System.out.println("Length: " + longString.length());
//         input.close();
//     }
// }


public class Length_OfLongest_SubString {

    public static int lengthOfLongestSubstring(String s) {
        // Array to store the last index of each character
        int[] lastIndex = new int[256]; // Assuming ASCII characters
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1; // Initialize all elements to -1
        }

        int maxLength = 0; // To store the maximum length of substring without duplicates
        int start = 0; // Start index of the current window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character has been seen before and is within the current window
            if (lastIndex[currentChar] >= start) {
                // Move the start of the window to the right of the previous occurrence of the current character
                start = lastIndex[currentChar] + 1;
            }

            // Update the last index of the current character
            lastIndex[currentChar] = end;

            // Calculate the length of the current window and update maxLength if necessary
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + lengthOfLongestSubstring(s3)); // Output: 3
    }
}