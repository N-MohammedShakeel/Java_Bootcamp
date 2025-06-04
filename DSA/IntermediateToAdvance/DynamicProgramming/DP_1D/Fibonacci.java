package Java_Bootcamp.DSA.IntermediateToAdvance.DynamicProgramming.DP_1D;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        // Initialize DP array for memoization with size 11 to handle n = 10
        // (0-based indexing for 0 to 10th Fibonacci numbers)
        int[] dp = new int[11];
        Arrays.fill(dp, -1); // Set all to -1 to indicate uncomputed states
        // Test fib2 (tabulation) for n = 10
        System.out.println("Fibonacci number at n=10 (tabulation): " + fib2(10, dp));
        
        // Reset DP array for testing fib1 (memoization)
        Arrays.fill(dp, -1);
        // Test fib1 (memoization) for n = 10
        System.out.println("Fibonacci number at n=10 (memoization): " + fib1(10, dp));
    }

    static int fib1(int n, int[] dp) {
        // Method: Top-Down Dynamic Programming with Memoization
        // Purpose: Compute nth Fibonacci number recursively, storing results to avoid recomputation
        // Input: n (non-negative integer), dp (memoization array)
        // Output: nth Fibonacci number (0, 1, 1, 2, 3, 5, 8, ...)

        // Input validation: Handle negative or invalid n
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        // Base cases: F(0) = 0, F(1) = 1
        if (n <= 1) {
            return n; // Return n directly as Fibonacci value
        }

        // Check memoization table: If dp[n] is computed (not -1), return it
        if (dp[n] != -1) {
            return dp[n]; // Avoid redundant recursive calls
        }

        // Recurrence: F(n) = F(n-1) + F(n-2)
        // Compute result, store in dp[n], and return
        return dp[n] = fib1(n - 1, dp) + fib1(n - 2, dp);
        // Workflow:
        // 1. Recursively compute F(n-1) and F(n-2).
        // 2. Store sum in dp[n] to memoize.
        // 3. Return result, reducing time complexity from O(2^n) to O(n).
    }

    static int fib2(int n, int[] dp) {
        // Method: Bottom-Up Dynamic Programming with Tabulation
        // Purpose: Compute nth Fibonacci number iteratively, building solutions from base cases
        // Input: n (non-negative integer), dp (tabulation array)
        // Output: nth Fibonacci number (0, 1, 1, 2, 3, 5, 8, ...)

        // Input validation: Handle n <= 0
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        // Base cases: Initialize F(0) = 0, F(1) = 1
        dp[0] = 0;
        if (n == 1) return dp[0]; // Return F(0) for n=1
        dp[1] = 1;
        if (n == 2) return dp[1]; // Return F(1) for n=2

        // Iterative computation: Fill dp array for i=2 to n
        for (int i = 2; i <= n; i++) {
            // Recurrence: F(i) = F(i-1) + F(i-2)
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return nth Fibonacci number
        return dp[n];
        // Workflow:
        // 1. Initialize base cases dp[0] and dp[1].
        // 2. Use loop to compute each F(i) using previous values.
        // 3. Store results in dp array, achieving O(n) time complexity.
        // 4. Return dp[n] for the nth Fibonacci number.
        // Note: Fixed original code to return dp[n] (not dp[n-1]) to get F(n).
    }
}