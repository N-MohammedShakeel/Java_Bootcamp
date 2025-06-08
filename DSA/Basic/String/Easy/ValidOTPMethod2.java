package Java_Bootcamp.DSA.Basic.String.Easy;

// ValidOTPMethod2.java
// Checks if string is a valid OTP by verifying each character is a digit
// Time: O(n), Space: O(1)

public class ValidOTPMethod2 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Valid OTP (Method 2): " + validOTPMethod2("1234")); // true
    }

    // Checks if string is a valid OTP by verifying each character is a digit
    // Time: O(n), Space: O(1)
    public static boolean validOTPMethod2(String str) {
        for (char ch : str.toCharArray()) {
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }
}