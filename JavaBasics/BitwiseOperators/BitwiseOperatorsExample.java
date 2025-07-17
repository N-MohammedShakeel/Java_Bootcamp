package Java_Bootcamp.JavaBasics.BitwiseOperators;

/**
 * BitwiseOperatorsExample.java
 * Demonstrates all bitwise operators, complement calculation, and binary conversion in Java.
 * Scenario: Managing permissions and performing DSA-relevant bit manipulations (e.g., unique element, power of 2).
 * Features: Examples of AND, OR, XOR, NOT, shifts, complement, and binary conversion with DSA applications.
 */
public class BitwiseOperatorsExample {
    // Method to convert a number to binary (manual implementation)
    public static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder binary = new StringBuilder();
        int num = n;
        // Handle negative numbers
        if (n < 0) num = -num; // Work with absolute value for simplicity
        while (num != 0) {
            binary.append(num & 1); // Extract least significant bit
            num >>= 1; // Right shift
        }
        String result = binary.reverse().toString();
        return n < 0 ? "-" + result : result;
    }

    // Method to find complement of a number
    public static int findComplement(int n) {
        return ~n; // Bitwise NOT
    }

    // Method to check if a number is a power of 2 (DSA example)
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Method to find a single number in an array where others appear twice (DSA example)
    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR cancels duplicates
        }
        return result;
    }

    public static void main(String[] args) {
        // Initialize numbers for demonstration
        int a = 5; // 0101
        int b = 3; // 0011
        System.out.println("Numbers: a = " + a + " (" + toBinary(a) + "), b = " + b + " (" + toBinary(b) + ")");

        // 1. Bitwise AND (&)
        int andResult = a & b;
        System.out.println("AND (a & b): " + andResult + " (" + toBinary(andResult) + ")"); // 0101 & 0011 = 0001 (1)

        // 2. Bitwise OR (|)
        int orResult = a | b;
        System.out.println("OR (a | b): " + orResult + " (" + toBinary(orResult) + ")"); // 0101 | 0011 = 0111 (7)

        // 3. Bitwise XOR (^)
        int xorResult = a ^ b;
        System.out.println("XOR (a ^ b): " + xorResult + " (" + toBinary(xorResult) + ")"); // 0101 ^ 0011 = 0110 (6)

        // 4. Bitwise NOT (~)
        int notResult = ~a;
        System.out.println("NOT (~a): " + notResult + " (" + toBinary(notResult) + ")"); // ~0101 = 11111010 (-6)

        // 5. Left Shift (<<)
        int leftShiftResult = a << 2;
        System.out.println("Left Shift (a << 2): " + leftShiftResult + " (" + toBinary(leftShiftResult) + ")"); // 0101 << 2 = 010100 (20)

        // 6. Right Shift (>>)
        int rightShiftResult = a >> 1;
        System.out.println("Right Shift (a >> 1): " + rightShiftResult + " (" + toBinary(rightShiftResult) + ")"); // 0101 >> 1 = 0010 (2)

        // 7. Unsigned Right Shift (>>>)
        int unsignedRightShiftResult = a >>> 1;
        System.out.println("Unsigned Right Shift (a >>> 1): " + unsignedRightShiftResult + " (" + toBinary(unsignedRightShiftResult) + ")"); // 0101 >>> 1 = 0010 (2)

        // 8. Complement Example
        int complement = findComplement(a);
        System.out.println("Complement of " + a + ": " + complement + " (" + toBinary(complement) + ")");

        // 9. DSA Example: Check if a number is a power of 2
        int n = 16; // 10000
        System.out.println(n + " is power of 2? " + isPowerOfTwo(n)); // true

        // 10. DSA Example: Find single number in array
        int[] nums = {4, 1, 2, 1, 2};
        int single = findSingleNumber(nums);
        System.out.println("Single number in " + java.util.Arrays.toString(nums) + ": " + single + " (" + toBinary(single) + ")");
    }
}