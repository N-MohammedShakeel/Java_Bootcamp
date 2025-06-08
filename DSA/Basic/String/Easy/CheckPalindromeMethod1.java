package Java_Bootcamp.DSA.Basic.String.Easy;

// CheckPalindromeMethod1.java
// Checks if string is palindrome by comparing characters from both ends, ignoring non-alphanumeric
// Time: O(n), Space: O(1)

public class CheckPalindromeMethod1 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Is Palindrome (Method 1): " + checkPalindromeMethod1("radar")); // true
    }

    // Checks if string is palindrome by comparing characters from both ends, ignoring non-alphanumeric
    // Time: O(n), Space: O(1)
    public static boolean checkPalindromeMethod1(String str) {
        str = str.toLowerCase().trim();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            boolean b1 = (ch1 >= 'a' && ch1 <= 'z') || (ch1 >= '0' && ch1 <= '9');
            boolean b2 = (ch2 >= 'a' && ch2 <= 'z') || (ch2 >= '0' && ch2 <= '9');
            if (b1 && b2 && ch1 != ch2) {
                return false;
            }
            if (!b1) i++;
            else if (!b2) j--;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}