// Given a string s, return the longest palindromic substring in s.
// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:
// Input: s = "cbbd"
// Output: "bb


class longest_palindromic_substring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        // Step 1: Preprocess the string
        char[] T = preprocess(s);
        int n = T.length;
        int[] P = new int[n];
        
        int center = 0, right = 0;
        int maxLen = 0, maxCenter = 0;
        
        // Main Manacher's algorithm
        for (int i = 1; i < n - 1; i++) {
            // Find mirror index
            int mirror = 2 * center - i;
            
            // If within right boundary, use mirrored value
            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }
            
            // Attempt to expand palindrome centered at i
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                P[i]++;
            }
            
            // If palindrome centered at i expands past right,
            // adjust center
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
            
            // Track max length
            if (P[i] > maxLen) {
                maxLen = P[i];
                maxCenter = i;
            }
        }
        
        // Extract the longest palindromic substring
        int start = (maxCenter - maxLen) / 2;
        int length = maxLen;
        return s.substring(start, start + length);
    }
    
    // Preprocess string to handle even and odd length palindromes uniformly
    private char[] preprocess(String s) {
        int n = s.length();
        char[] T = new char[n * 2 + 3];
        
        T[0] = '$';  // Start marker
        T[n * 2 + 2] = '@';  // End marker
        
        for (int i = 0; i < n; i++) {
            T[2 * i + 1] = '#';  // Separator
            T[2 * i + 2] = s.charAt(i);
        }
        T[n * 2 + 1] = '#';
        
        return T;
    }
}