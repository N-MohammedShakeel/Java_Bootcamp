package Java_Bootcamp.DSA.Basic.String.Hard;

// DistinctSubsequences.java
// Counts number of distinct subsequences of t in s
// Time: O(m*n), Space: O(m*n)

public class DistinctSubsequences {
    public static void main(String[] args) {
        // Test case
        System.out.println("Distinct Subsequences: " + numDistinct("rabbbit", "rabbit")); // 3
    }

    // Counts number of distinct subsequences of t in s
    // Time: O(m*n), Space: O(m*n)
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