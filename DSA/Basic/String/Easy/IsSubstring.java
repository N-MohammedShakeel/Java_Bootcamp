package Java_Bootcamp.DSA.Basic.String.Easy;

// IsSubstring.java
// Checks if sub is a substring of s
// Time: O(n+m), Space: O(1)

public class IsSubstring {
    public static void main(String[] args) {
        // Test case
        System.out.println("Is Substring: " + isSubstring("hello world", "world")); // true
    }

    // Checks if sub is a substring of s
    // Time: O(n+m), Space: O(1)
    public static boolean isSubstring(String s, String sub) {
        return s.contains(sub);
    }
}