package Java_Bootcamp.DSA.Basic.String.Hard;

// RegularExpressionMatching.java
// Implements regex matching with support for '.' and '*'
// Time: O(m*n), Space: O(m*n)

public class RegularExpressionMatching {
    public static void main(String[] args) {
        // Test case
        System.out.println("Regular Expression Matching: " + isMatch("aab", "c*a*b")); // true
    }

    // Implements regex matching with support for '.' and '*'
    // Time: O(m*n), Space: O(m*n)
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
}