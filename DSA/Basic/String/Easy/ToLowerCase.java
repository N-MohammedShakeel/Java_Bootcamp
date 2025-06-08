package Java_Bootcamp.DSA.Basic.String.Easy;

// ToLowerCase.java
// Converts string to lowercase using built-in method
// Time: O(n), Space: O(n)

public class ToLowerCase {
    public static void main(String[] args) {
        // Test case
        System.out.println("To Lower Case: " + toLowerCase("HELLO")); // hello
    }

    // Converts string to lowercase using built-in method
    // Time: O(n), Space: O(n)
    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }
}