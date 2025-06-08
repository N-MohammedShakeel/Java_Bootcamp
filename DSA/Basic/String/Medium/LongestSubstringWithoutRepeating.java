package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// LongestSubstringWithoutRepeating.java
// Finds the length of the longest substring without repeating characters
// Time: O(n), Space: O(min(m,n)) where m is charset size

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        // Test case
        System.out.println("Longest Substring Without Repeating: " + lengthOfLongestSubstring("abcabcbb")); // 3
    }

    // Finds the length of the longest substring without repeating characters
    // Time: O(n), Space: O(min(m,n)) where m is charset size
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            } else {
                maxLen = Math.max(maxLen, i - start + 1);
            }
            map.put(c, i);
        }
        return maxLen;
    }
}