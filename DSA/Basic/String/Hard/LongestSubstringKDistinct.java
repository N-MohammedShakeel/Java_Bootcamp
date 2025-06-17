package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.*;

// LongestSubstringKDistinct.java
// Finds longest substring with at most k distinct characters
// Time: O(n), Space: O(k)

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        // Test case
        System.out.println("Longest Substring with At Most K Distinct Characters: " + lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
    }

    // Finds longest substring with at most k distinct characters
    // Time: O(n), Space: O(k)
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int end =  0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (map.size() > k) {
                char c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}