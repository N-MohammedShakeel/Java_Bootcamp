package Java_Bootcamp.DSA.Basic.String;

import java.util.*;

public class HardStringProblems {
    public static void main(String[] args) {
        // Test cases for hard string problems
        System.out.println("1. Regular Expression Matching: " + isMatch("aab", "c*a*b")); // true
        System.out.println("2. Wildcard Matching: " + isWildcardMatch("adceb", "*a*b")); // true
        System.out.println("3. Longest Valid Parentheses: " + longestValidParentheses("(()))")); // 4
        System.out.println("4. Word Break: " + wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println("5. Minimum Window Substring: " + minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println("6. Edit Distance: " + minDistance("horse", "ros")); // 3
        System.out.println("7. Text Justification: " + fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)); // [This    is    an, example  of text, justification.  ]
        System.out.println("8. Longest Substring with At Most K Distinct Characters: " + lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
        System.out.println("9. KMP Pattern Search: " + kmpSearch("ABABDABACDABABCABAB", "ABABCABAB")); // 10
        System.out.println("10. Distinct Subsequences: " + numDistinct("rabbbit", "rabbit")); // 3
    }

    // 1. Regular Expression Matching
    // Time: O(m*n), Space: O(m*n) for DP
    // LeetCode: https://leetcode.com/problems/regular-expression-matching/
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    // 2. Wildcard Matching
    // Time: O(m*n), Space: O(m*n) for DP
    // LeetCode: https://leetcode.com/problems/wildcard-matching/
    public static boolean isWildcardMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    // 3. Longest Valid Parentheses
    // Time: O(n), Space: O(n) for stack
    // LeetCode: https://leetcode.com/problems/longest-valid-parentheses/
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    // 4. Word Break
    // Time: O(n^2), Space: O(n) for DP
    // LeetCode: https://leetcode.com/problems/word-break/
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

    // 5. Minimum Window Substring
    // Time: O(n), Space: O(m) where m is charset size
    // LeetCode: https://leetcode.com/problems/minimum-window-substring/
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

    // 6. Edit Distance
    // Time: O(m*n), Space: O(m*n)
    // LeetCode: https://leetcode.com/problems/edit-distance/
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    // 7. Text Justification
    // Time: O(n^2), Space: O(n)
    // LeetCode: https://leetcode.com/problems/text-justification/
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int count = words[i].length();
            int last = i + 1;
            while (last < words.length && count + words[last].length() + 1 <= maxWidth) {
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder line = new StringBuilder();
            if (last == words.length || last - i == 1) {
                // Left-justify last line or single word
                for (int j = i; j < last; j++) {
                    line.append(words[j]);
                    if (j < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                // Justify line
                int spaces = (maxWidth - count + (last - i - 1)) / (last - i - 1);
                int extra = (maxWidth - count + (last - i - 1)) % (last - i - 1);
                for (int j = i; j < last; j++) {
                    line.append(words[j]);
                    if (j < last - 1) {
                        for (int k = 0; k < spaces + (j - i < extra ? 1 : 0); k++) {
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            i = last;
        }
        return result;
    }

    // 8. Longest Substring with At Most K Distinct Characters
    // Time: O(n), Space: O(k)
    // LeetCode: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
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

    // 9. KMP Pattern Search
    // Time: O(n+m), Space: O(m) where n is text length, m is pattern length
    public static int kmpSearch(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return i - j;
            }
            if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }
    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }

    // 10. Distinct Subsequences
    // Time: O(m*n), Space: O(m*n)
    // LeetCode: https://leetcode.com/problems/distinct-subsequences/
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}