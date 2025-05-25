package Java_Bootcamp.DSA.Basic.Math;

import java.util.*;

// Medium Math Problems for HackWithInfy Preparation
// These problems build on basic math operations, introducing optimization and number theory.
// Suitable for Medium difficulty in Round 1 or interviews.
// Time and space complexities are provided for each problem.

public class MediumMathProblems {
    public static void main(String[] args) {
        // Test cases for medium math problems
        System.out.println("1. LCM of 12 and 18: " + lcm(12, 18)); // 36
        System.out.println("2. Fast Power (2^10): " + fastPower(2, 10)); // 1024
        System.out.println("3. Factorial Trailing Zeros (5): " + trailingZeroes(5)); // 1
        System.out.println("4. Sum of Divisors (28): " + sumOfDivisors(28)); // 56
        System.out.println("5. Perfect Number (28): " + isPerfectNumber(28)); // true
        System.out.println("6. Power of Two (16): " + isPowerOfTwo(16)); // true
        System.out.println("7. Square Root (16): " + mySqrt(16)); // 4
        System.out.println("8. Sum of Array Elements ([1,2,3]): " + sumArray(new int[]{1, 2, 3})); // 6
    }

    // 1. LCM (Least Common Multiple)
    // Approach: Use GCD (Euclidean algorithm) to compute LCM via formula: LCM(a,b) = (a*b)/GCD(a,b)
    // Time Complexity: O(log(min(a,b))) - from GCD
    // Space Complexity: O(1) - constant space
    public static long lcm(int a, int b) {
        return ((long) a * b) / gcd(a, b);
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 2. Fast Power (x^n)
    // Approach: Use binary exponentiation to reduce multiplications
    // Time Complexity: O(log n) - halves exponent each step
    // Space Complexity: O(1) - constant space
    // LeetCode: https://leetcode.com/problems/powx-n/
    public static long fastPower(int x, int n) {
        long result = 1, base = x;
        while (n > 0) {
            if ((n & 1) == 1) result *= base;
            base *= base;
            n >>= 1;
        }
        return result;
    }

    // 3. Factorial Trailing Zeros
    // Approach: Count factors of 5 in n! (since 2s are always sufficient)
    // Time Complexity: O(log n) - iterate over powers of 5
    // Space Complexity: O(1) - constant space
    // LeetCode: https://leetcode.com/problems/factorial-trailing-zeroes/
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    // 4. Sum of Divisors
    // Approach: Sum all divisors using iteration up to sqrt(n)
    // Time Complexity: O(sqrt(n)) - check up to square root
    // Space Complexity: O(1) - constant space
    public static int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        return sum;
    }

    // 5. Check Perfect Number
    // Approach: Sum proper divisors (exclude n) and check if equal to n
    // Time Complexity: O(sqrt(n)) - from sumOfDivisors
    // Space Complexity: O(1) - constant space
    // LeetCode: https://leetcode.com/problems/perfect-number/
    public static boolean isPerfectNumber(int n) {
        if (n <= 1) return false;
        int sum = sumOfDivisors(n) - n; // Exclude n itself
        return sum == n;
    }

    // 6. Check if Power of Two
    // Approach: Use bitwise operation to check if n has only one set bit
    // Time Complexity: O(1) - single bitwise operation
    // Space Complexity: O(1) - constant space
    // LeetCode: https://leetcode.com/problems/power-of-two/
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    // 7. Integer Square Root
    // Approach: Binary search to find largest integer whose square <= x
    // Time Complexity: O(log x) - binary search
    // Space Complexity: O(1) - constant space
    // LeetCode: https://leetcode.com/problems/sqrtx/
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == x) return (int) mid;
            else if (square < x) left = mid + 1;
            else right = mid - 1;
        }
        return (int) right;
    }

    // 8. Sum of Array Elements
    // Approach: Iterate through array to sum elements
    // Time Complexity: O(n) - single pass through array
    // Space Complexity: O(1) - constant space
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }
}