package Java_Bootcamp.DSA.Basic.String.Hard;

// EditDistance.java
// Computes minimum operations to transform one string to another
// Time: O(m*n), Space: O(m*n)

public class EditDistance {
    public static void main(String[] args) {
        // Test case
        System.out.println("Edit Distance: " + minDistance("horse", "ros")); // 3
    }

    // Computes minimum operations to transform one string to another
    // Time: O(m*n), Space: O(m*n)
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
}