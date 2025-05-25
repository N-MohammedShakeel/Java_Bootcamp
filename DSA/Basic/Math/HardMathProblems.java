package Java_Bootcamp.DSA.Basic.Math;

import java.util.*;

// Hard Mathematical Problems for HackWithInfy Preparation
// These problems involve advanced number theory, combinatorics, and modular arithmetic.
// Time and space complexities are provided for each problem.

public class HardMathProblems {
    public static void main(String[] args) {
        // Test cases for hard math problems
        System.out.println("1. Nth Catalan Number (n=3): " + catalanNumber(3)); // 5
        System.out.println("2. Integer Break (10): " + integerBreak(10)); // 36
        System.out.println("3. Count Primes (10): " + countPrimes(10)); // 4
        System.out.println("4. Super Pow (2^1337 mod 1337): " + superPow(2, new int[]{1, 0})); // 1024
        System.out.println("5. Perfect Squares (12): " + numSquares(12)); // 3
        System.out.println("6. Ugly Number II (10): " + nthUglyNumber(10)); // 12
    }

    // 1. Nth Catalan Number
    // Approach: Use recursive formula with memoization: C(n) = sum(C(i)*C(n-1-i)).
    // Time Complexity: O(n^2) - with memoization.
    // Space Complexity: O(n) - memoization array.
    public static long catalanNumber(int n) {
        long[] memo = new long[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                memo[i] += memo[j] * memo[i - 1 - j];
            }
        }
        return memo[n];
    }

    // 2. Integer Break
    // Approach: Break n into integers to maximize product, using DP.
    // Time Complexity: O(n^2) - nested loop for DP.
    // Space Complexity: O(n) - DP array.
    // LeetCode: https://leetcode.com/problems/integer-break/
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    // 3. Count Primes
    // Approach: Use Sieve of Eratosthenes to count primes up to n.
    // Time Complexity: O(n log log n) - Sieve algorithm.
    // Space Complexity: O(n) - boolean array for sieve.
    // LeetCode: https://leetcode.com/problems/count-primes/
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    // 4. Super Pow
    // Approach: Compute (a^b) % k using modular exponentiation.
    // Time Complexity: O(log b) - binary exponentiation.
    // Space Complexity: O(1) - constant space.
    // LeetCode: https://leetcode.com/problems/super-pow/
    public static int superPow(int a, int[] b) {
        int mod = 1337;
        a %= mod;
        int result = 1;
        for (int digit : b) {
            result = (powMod(result, 10, mod) * powMod(a, digit, mod)) % mod;
        }
        return result;
    }
    private static int powMod(int x, int n, int mod) {
        int result = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) result = (result * x) % mod;
            x = (x * x) % mod;
            n >>= 1;
        }
        return result;
    }

    // 5. Perfect Squares
    // Approach: Find minimum number of perfect squares summing to n, using DP.
    // Time Complexity: O(n*sqrt(n)) - DP with sqrt(n) checks.
    // Space Complexity: O(n) - DP array.
    // LeetCode: https://leetcode.com/problems/perfect-squares/
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    // 6. Ugly Number II
    // Approach: Find nth ugly number (product of 2,3,5) using DP.
    // Time Complexity: O(n) - linear DP.
    // Space Complexity: O(n) - DP array.
    // LeetCode: https://leetcode.com/problems/ugly-number-ii/
    public static long nthUglyNumber(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            long next = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            dp[i] = next;
            if (next == dp[p2] * 2) p2++;
            if (next == dp[p3] * 3) p3++;
            if (next == dp[p5] * 5) p5++;
        }
        return dp[n - 1];
    }
}