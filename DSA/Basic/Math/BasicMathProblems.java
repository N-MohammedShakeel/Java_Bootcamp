package Java_Bootcamp.DSA.Basic.Math;

public class BasicMathProblems {
    public static void main(String[] args) {
        // Test cases for each problem
        System.out.println("Count Digits of 12345: " + countDigits(12345)); // Should print 5
        System.out.println("Reverse of 12345: " + reverseNumber(12345)); // Should print 54321
        System.out.println("Is 121 Palindrome? " + isPalindrome(121)); // Should print true
        System.out.println("GCD of 48 and 18: " + gcd(48, 18)); // Should print 6
        System.out.println("Is 153 Armstrong? " + isArmstrong(153)); // Should print true
        System.out.print("Divisors of 36: ");
        printDivisors(36); // Should print 1 2 3 4 6 9 12 18 36
        System.out.println("\nIs 29 Prime? " + isPrime(29)); // Should print true
    }

    // Count Digits: Returns the number of digits in a number
    public static int countDigits(int n) {
        if (n == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(n))) + 1;
    }

    // Reverse a Number: Reverses the digits of a number
    public static int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    // Check Palindrome: Returns true if number is palindrome
    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    // GCD or HCF: Returns Greatest Common Divisor using Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Armstrong Number: Returns true if number equals sum of its digits raised to power of number of digits
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

    // Print all Divisors: Prints all divisors of a number
    public static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Check for Prime: Returns true if number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}