package Java_Bootcamp.DSA.Basic.String.Hard;

// WildcardMatching.java
// Implements wildcard matching with support for '?' and '*'
// Time: O(m*n), Space: O(m*n)

public class WildcardMatching {
    public static void main(String[] args) {
        // Test case
        System.out.println("Wildcard Matching: " + isWildcardMatch("adceb", "*a*b")); // true
    }

    // Implements wildcard matching with support for '?' and '*'
    // Time: O(m*n), Space: O(m*n)
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
}