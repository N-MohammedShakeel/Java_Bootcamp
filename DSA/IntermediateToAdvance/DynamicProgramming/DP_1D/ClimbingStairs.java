package Java_Bootcamp.DSA.IntermediateToAdvance.DynamicProgramming.DP_1D;

import java.util.Arrays;

public class ClimbingStairs {
    // LeetCode Link: https://leetcode.com/problems/climbing-stairs/
    // Problem Description:
    // You are climbing a staircase with n steps. Each time, you can take 1 or 2 steps.
    // Return the number of distinct ways to climb to the top (n steps).
    // Constraints: 1 <= n <= 45

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 5; // Test case: n = 5 steps
        // Test memoization approach
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Ways to climb " + n + " steps (memoization): " + solution.climbStairsMemo(n, dp));
        // Test tabulation approach
        System.out.println("Ways to climb " + n + " steps (tabulation): " + solution.climbStairsTab(n));
        // Test space-optimized tabulation approach
        System.out.println("Ways to climb " + n + " steps (space-optimized): " + solution.climbStairsTabO1(n));
    }

    // Method 1: Top-Down Dynamic Programming with Memoization
    int climbStairsMemo(int n, int[] dp) {
        // Purpose: Compute number of ways to climb n steps using memoization
        // Input: n (number of steps), dp (memoization array to store results)
        // Output: Number of distinct ways to reach nth step

        // Input validation: Ensure n is non-negative
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        // Base cases:
        // n = 0: 1 way (do nothing, already at top)
        // n = 1: 1 way (take 1 step)
        if (n <= 1) {
            return 1;
        }

        // Check memoization table: If dp[n] is computed (not -1), return it
        if (dp[n] != -1) {
            return dp[n]; // Avoid redundant recursive calls
        }

        // Recurrence: Number of ways to reach n = ways to reach (n-1) + ways to reach (n-2)
        // Because you can take 1 step from (n-1) or 2 steps from (n-2)
        return dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        // Workflow:
        // 1. Recursively compute ways for n-1 and n-2 steps.
        // 2. Store sum in dp[n] to memoize result.
        // 3. Return dp[n], reducing time complexity from O(2^n) to O(n).
        // Note: Similar to Fibonacci, as each step depends on the previous two.
    }

    // Method 2: Bottom-Up Dynamic Programming with Tabulation
    int climbStairsTab(int n) {
        // Purpose: Compute number of ways to climb n steps iteratively using tabulation
        // Input: n (number of steps)
        // Output: Number of distinct ways to reach nth step

        // Input validation: Ensure n is non-negative
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        // Handle base cases directly
        if (n <= 1) {
            return 1; // n=0 or n=1 has 1 way
        }

        // Initialize DP array to store number of ways for each step
        int[] dp = new int[n + 1];
        
        // Base cases: Set dp[0] and dp[1]
        dp[0] = 1; // 0 steps: 1 way (no movement)
        dp[1] = 1; // 1 step: 1 way (take 1 step)

        // Iterative computation: Fill dp array for i=2 to n
        for (int i = 2; i <= n; i++) {
            // Recurrence: dp[i] = dp[i-1] + dp[i-2]
            // Ways to reach step i = ways from i-1 (take 1 step) + ways from i-2 (take 2 steps)
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return number of ways to reach nth step
        return dp[n];
        // Workflow:
        // 1. Initialize dp[0] and dp[1] as base cases.
        // 2. Use loop to compute dp[i] for each i from 2 to n.
        // 3. Each dp[i] uses previously computed values, achieving O(n) time complexity.
        // 4. Return dp[n] for the final answer.
    }

    // Method 3: Bottom-Up Dynamic Programming with Space Optimization
    int climbStairsTabO1(int n) {
        // Purpose: Compute number of ways to climb n steps iteratively using O(1) space
        // Input: n (number of steps)
        // Output: Number of distinct ways to reach nth step

        // Input validation: Ensure n is non-negative
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        // Handle base cases directly
        if (n <= 1) {
            return 1; // n=0 or n=1 has 1 way
        }

        // Initialize variables for previous two steps
        int prev2 = 1; // Ways to reach step i-2 (initially step 0)
        int prev1 = 1; // Ways to reach step i-1 (initially step 1)

        // Iterative computation: Compute ways for steps 2 to n
        for (int i = 2; i <= n; i++) {
            // Recurrence: Current ways = ways from i-1 + ways from i-2
            int curr = prev1 + prev2;
            // Update variables: Shift prev1 to prev2, curr to prev1
            prev2 = prev1;
            prev1 = curr;
        }

        // Return number of ways to reach nth step
        return prev1;
        // Workflow:
        // 1. Initialize prev2 and prev1 as base cases (steps 0 and 1).
        // 2. For each step i from 2 to n, compute current ways using prev1 + prev2.
        // 3. Update prev2 and prev1 to store only the last two values needed.
        // 4. Return prev1, achieving O(n) time and O(1) space complexity.
        // Space Optimization:
        // - Instead of storing entire dp array (O(n) space), use two variables.
        // - Only prev1 (i-1) and prev2 (i-2) are needed for each iteration.
        // - This reduces space complexity to O(1) while maintaining same logic.
    }
}