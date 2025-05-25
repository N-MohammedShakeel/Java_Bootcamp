package Java_Bootcamp.DSA.Basic.Math;

// Basic Math Problems for HackWithInfy Preparation
// These problems cover fundamental mathematical operations, suitable for Easy problems in Round 1.
// Each method includes time and space complexity.
// All problems use iterative approaches for simplicity, avoiding recursion for basic level.

public class BasicMathProblems {
    public static void main(String[] args) {
        // Test cases for basic math problems
        System.out.println("1. Count Digits of 12345: " + countDigits(12345)); // 5
        System.out.println("2. Reverse of 12345: " + reverseNumber(12345)); // 54321
        System.out.println("3. Is 121 Palindrome? " + isPalindrome(121)); // true
        System.out.println("4. GCD of 48 and 18: " + gcd(48, 18)); // 6
        System.out.println("5. Is 153 Armstrong? " + isArmstrong(153)); // true
        System.out.print("6. Divisors of 36: ");
        printDivisors(36); // 1 2 3 4 6 9 12 18 36
        System.out.println("\n7. Is 29 Prime? " + isPrime(29)); // true
        System.out.println("8. Is 42 Even? " + isEven(42)); // true
        System.out.println("9. Power (2^3): " + power(2, 3)); // 8
        System.out.println("10. Sum of Digits of 123: " + sumOfDigits(123)); // 6
    }

    // 1. Count Digits: Returns the number of digits in a number
    // Time Complexity: O(log n) - proportional to number of digits
    // Space Complexity: O(1) - constant space
    public static int countDigits(int n) {
        if (n == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(n))) + 1;
    }

    // 2. Reverse a Number: Reverses the digits of a number
    // Time Complexity: O(log n) - proportional to number of digits
    // Space Complexity: O(1) - constant space
    public static int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    // 3. Check Palindrome: Returns true if number is palindrome
    // Time Complexity: O(log n) - calls reverseNumber
    // Space Complexity: O(1) - constant space
    // LeetCode: https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    // 4. GCD or HCF: Returns Greatest Common Divisor using Euclidean algorithm
    // Time Complexity: O(log(min(a,b))) - Euclidean algorithm
    // Space Complexity: O(1) - constant space
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 5. Armstrong Number: Returns true if number equals sum of its digits raised to power of number of digits
    // Time Complexity: O(log n) - process each digit
    // Space Complexity: O(1) - constant space
    public static boolean isArmstrong(int n) {
        int digits = countDigits(n);
        int sum = 0, temp = n;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == n;
    }

    // 6. Print all Divisors: Prints all divisors of a number
    // Time Complexity: O(n) - check all numbers up to n
    // Space Complexity: O(1) - constant space
    public static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // 7. Check for Prime: Returns true if number is prime
    // Time Complexity: O(sqrt(n)) - check up to square root of n
    // Space Complexity: O(1) - constant space
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 8. Check if Number is Even or Odd
    // Time Complexity: O(1) - single bitwise operation
    // Space Complexity: O(1) - constant space
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    // 9. Calculate Power of a Number
    // Time Complexity: O(n) - iterative multiplication
    // Space Complexity: O(1) - constant space
    public static long power(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // 10. Sum of Digits
    // Time Complexity: O(log n) - process each digit
    // Space Complexity: O(1) - constant space
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}