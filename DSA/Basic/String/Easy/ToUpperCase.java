package Java_Bootcamp.DSA.Basic.String.Easy;

// ToUpperCase.java
// Converts string to uppercase using built-in method
// Time: O(n), Space: O(n)

public class ToUpperCase {
    public static void main(String[] args) {
        // Test case
        System.out.println("To Upper Case: " + toUpperCase("hello")); // HELLO
    }

    // Converts string to uppercase using built-in method
    // Time: O(n), Space: O(n)
    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }
}