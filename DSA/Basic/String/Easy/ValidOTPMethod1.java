package Java_Bootcamp.DSA.Basic.String.Easy;

// ValidOTPMethod1.java
// Checks if string is a valid OTP (digits only) using regex
// Time: O(n), Space: O(1)

public class ValidOTPMethod1 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Valid OTP (Method 1): " + validOTPMethod1("1234")); // true
    }

    // Checks if string is a valid OTP (digits only) using regex
    // Time: O(n), Space: O(1)
    public static boolean validOTPMethod1(String str) {
        String regex = "\\d+";
        return str.matches(regex);
    }
}