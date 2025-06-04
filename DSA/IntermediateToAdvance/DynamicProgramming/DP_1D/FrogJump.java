package Java_Bootcamp.DSA.IntermediateToAdvance.DynamicProgramming.DP_1D;

import java.util.Arrays;

public class FrogJump {
    // Problem Description:
    // Given N stairs and a frog at the 0th stair, the frog wants to reach the (N-1)th stair.
    // The frog can jump either 1 or 2 steps at a time. An array height[N] represents the height
    // of each stair. Energy consumed for a jump from stair i to stair j is abs(height[i] - height[j]).
    // Return the minimum energy required to jump from stair 0 to stair N-1.
    // Constraints: 1 <= N <= 10^5, 0 <= height[i] <= 10^9

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int[] height = {10, 20, 30, 10}; // Test case: N=4, heights=[10,20,30,10]
        int n = height.length;
        // Test memoization approach
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("Min energy (memoization): " + solution.frogJumpMemo(n - 1, height, dp));
        // Test tabulation approach
        System.out.println("Min energy (tabulation): " + solution.frogJumpTab(n, height));
        // Test space-optimized approach
        System.out.println("Min energy (space-optimized): " + solution.frogJumpTabO1(n, height));
    }

    // Method 1: Top-Down Dynamic Programming with Memoization
    int frogJumpMemo(int i, int[] height, int[] dp) {
        // Purpose: Compute minimum energy to reach stair i from stair 0 using memoization
        // Input: i (current stair index), height (array of stair heights), dp (memoization array)
        // Output: Minimum energy to reach stair i

        // Input validation: Ensure valid index
        if (i < 0 || i >= height.length) {
            throw new IllegalArgumentException("Invalid stair index");
        }

        // Base case: At stair 0, no energy consumed (starting point)
        if (i == 0) {
            return 0;
        }

        // Check memoization table: If dp[i] is computed (not -1), return it
        if (dp[i] != -1) {
            return dp[i]; // Avoid redundant recursive calls
        }

        // Recurrence:
        // Min energy to reach i = min(
        //   energy to reach i-1 + abs(height[i] - height[i-1]),
        //   energy to reach i-2 + abs(height[i] - height[i-2]) if i >= 2
        // )
        int oneStep = frogJumpMemo(i - 1, height, dp) + Math.abs(height[i] - height[i - 1]);
        int twoStep = Integer.MAX_VALUE / 2; // Use large value to avoid overflow
        if (i >= 2) {
            twoStep = frogJumpMemo(i - 2, height, dp) + Math.abs(height[i] - height[i - 2]);
        }

        // Store minimum energy in dp[i]
        return dp[i] = Math.min(oneStep, twoStep);
        // Workflow:
        // 1. Recursively compute min energy for i-1 and i-2 (if applicable).
        // 2. Add energy cost based on height difference for each jump.
        // 3. Store minimum in dp[i], reducing time complexity from O(2^n) to O(n).
        // Note: DP state is dp[i] = min energy to reach stair i from 0.
    }

    // Method 2: Bottom-Up Dynamic Programming with Tabulation
    int frogJumpTab(int n, int[] height) {
        // Purpose: Compute minimum energy to reach stair N-1 from stair 0 using tabulation
        // Input: n (number of stairs), height (array of stair heights)
        // Output: Minimum energy to reach stair N-1

        // Input validation: Ensure valid input
        if (n <= 0 || height.length != n) {
            throw new IllegalArgumentException("Invalid input: n must be positive and match height array length");
        }

        // Handle base case: 1 stair requires no jumps
        if (n == 1) {
            return 0;
        }

        // Initialize DP array: dp[i] = min energy to reach stair i
        int[] dp = new int[n];
        
        // Base case: dp[0] = 0 (no energy to stay at stair 0)
        dp[0] = 0;

        // Iterative computation: Fill dp array for i=1 to n-1
        for (int i = 1; i < n; i++) {
            // Energy from i-1: dp[i-1] + abs(height[i] - height[i-1])
            int oneStep = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            // Energy from i-2 (if i >= 2): dp[i-2] + abs(height[i] - height[i-2])
            int twoStep = Integer.MAX_VALUE / 2;
            if (i >= 2) {
                twoStep = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            // Store minimum energy
            dp[i] = Math.min(oneStep, twoStep);
        }

        // Return min energy to reach stair n-1
        return dp[n - 1];
        // Workflow:
        // 1. Initialize dp[0] = 0 as base case.
        // 2. For each stair i, compute min energy using dp[i-1] and dp[i-2] (if applicable).
        // 3. Add height difference costs and store minimum in dp[i].
        // 4. Return dp[n-1], achieving O(n) time complexity.
    }

    // Method 3: Bottom-Up Dynamic Programming with Space Optimization
    int frogJumpTabO1(int n, int[] height) {
        // Purpose: Compute minimum energy to reach stair N-1 from stair 0 using O(1) space
        // Input: n (number of stairs), height (array of stair heights)
        // Output: Minimum energy to reach stair N-1

        // Input validation: Ensure valid input
        if (n <= 0 || height.length != n) {
            throw new IllegalArgumentException("Invalid input: n must be positive and match height array length");
        }

        // Handle base case: 1 stair requires no jumps
        if (n == 1) {
            return 0;
        }

        // Initialize variables for previous two stairs
        int prev2 = 0; // Min energy to reach stair i-2 (initially stair 0)
        int prev1 = Math.abs(height[1] - height[0]); // Min energy to reach stair 1

        // Iterative computation: Compute min energy for stairs 2 to n-1
        for (int i = 2; i < n; i++) {
            // Energy to reach i:
            // - From i-1: prev1 + abs(height[i] - height[i-1])
            // - From i-2: prev2 + abs(height[i] - height[i-2])
            int oneStep = prev1 + Math.abs(height[i] - height[i - 1]);
            int twoStep = prev2 + Math.abs(height[i] - height[i - 2]);
            // Update variables: Shift prev1 to prev2, min of oneStep/twoStep to prev1
            prev2 = prev1;
            prev1 = Math.min(oneStep, twoStep);
        }

        // Return min energy to reach stair n-1
        return prev1;
        // Workflow:
        // 1. Initialize prev2 (stair 0) and prev1 (stair 1) based on height difference.
        // 2. For each stair i from 2 to n-1, compute min energy using prev1 and prev2.
        // 3. Update prev2 and prev1 to store only the last two values needed.
        // 4. Return prev1, achieving O(n) time and O(1) space complexity.
        // Space Optimization:
        // - Instead of storing dp[0..n-1] (O(n) space), use prev1 and prev2.
        // - Only energies for i-1 and i-2 are needed for each i.
        // - This reduces space to O(1) while maintaining the same logic.
    }
}