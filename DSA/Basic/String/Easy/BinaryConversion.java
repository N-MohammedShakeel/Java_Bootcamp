package Java_Bootcamp.DSA.Basic.String.Easy;

// BinaryConversion.java
// Converts a decimal number to binary string
// Time: O(log n), Space: O(log n)

public class BinaryConversion {
    public static void main(String[] args) {
        // Test case
        System.out.println("Binary Conversion: " + binary(13)); // 1101
    }

    // Converts a decimal number to binary string
    // Time: O(log n), Space: O(log n)
    public static String binary(int num) {
        if (num <= 0) return "";
        String result = "";
        while (num > 0) {
            int rem = num % 2;
            result = rem + result;
            num /= 2;
        }
        return result;
    }
}