class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        if (s.length() == 0) {
            return 0;
        }
        

        int[] charIndex = new int[128];
        
    
        for (int i = 0; i < 128; i++) {
            charIndex[i] = -1;
        }
        
        int maxLength = 0;
        int left = 0;
        
  
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            if (charIndex[currentChar] >= left) {
                left = charIndex[currentChar] + 1;
            }
            

            charIndex[currentChar] = right;
            
   
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
        System.out.println(solution.lengthOfLongestSubstring(""));         // Output: 0
        System.out.println(solution.lengthOfLongestSubstring(" "));        // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("au"));       // Output: 2
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));     // Output: 3
    }
}