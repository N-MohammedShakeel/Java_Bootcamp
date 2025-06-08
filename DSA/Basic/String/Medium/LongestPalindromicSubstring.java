package Java_Bootcamp.DSA.Basic.String.Medium;

// LongestPalindromicSubstring.java
// Finds the longest substring that is a palindrome
// Time: O(n^2), Space: O(1)

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // Test case
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring("babad")); // bab or aba
    }

    // Finds the longest substring that is a palindrome
    // Time: O(n^2), Space: O(1)
    public static String longestPalindromicSubstring(String s) {
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // odd length
            int len2 = expandAroundCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}