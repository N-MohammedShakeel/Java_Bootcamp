package Java_Bootcamp.DSA.Basic.String.Hard;

// MinimumWindowSubstring.java
// Finds the smallest substring containing all characters of t
// Time: O(n), Space: O(m) where m is charset size

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        // Test case
        System.out.println("Minimum Window Substring: " + minWindow("ADOBECODEBANC", "ABC")); // BANC
    }

    // Finds the smallest substring containing all characters of t
    // Time: O(n), Space: O(m) where m is charset size
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int count = t.length(), start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map[s.charAt(end)]-- > 0) count--;
            while (count == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}