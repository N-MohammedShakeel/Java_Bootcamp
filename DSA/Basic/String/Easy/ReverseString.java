package Java_Bootcamp.DSA.Basic.String.Easy;

// ReverseString.java
// Reverses the input string using StringBuilder for efficiency
// Time: O(n), Space: O(n)

public class ReverseString {
    public static void main(String[] args) {
        // Test case
        System.out.println("Reverse String: " + reverseString("hello")); // olleh
    }

    // Reverses the input string using StringBuilder for efficiency
    // Time: O(n), Space: O(n)
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}