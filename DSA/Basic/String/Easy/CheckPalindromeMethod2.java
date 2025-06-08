package Java_Bootcamp.DSA.Basic.String.Easy;

// CheckPalindromeMethod2.java
// Filters alphanumeric characters, then checks palindrome property
// Time: O(n), Space: O(n)

public class CheckPalindromeMethod2 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Is Palindrome (Method 2): " + checkPalindromeMethod2("A man, a plan, a canal: Panama")); // true
    }

    // Filters alphanumeric characters, then checks palindrome property
    // Time: O(n), Space: O(n)
    public static boolean checkPalindromeMethod2(String str) {
        StringBuilder message = new StringBuilder();
        for (char ch : str.toLowerCase().toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                message.append(ch);
            }
        }
        int i = 0;
        int j = message.length() - 1;
        while (i < j) {
            if (message.charAt(i) != message.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}