package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.*;

// WordBreak.java
// Checks if string can be segmented into words from dictionary
// Time: O(n^2), Space: O(n)

public class WordBreak {
    public static void main(String[] args) {
        // Test case
        System.out.println("Word Break: " + wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
    }

    // Checks if string can be segmented into words from dictionary
    // Time: O(n^2), Space: O(n)
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}