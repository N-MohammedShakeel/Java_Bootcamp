package Java_Bootcamp.DSA.Basic.String.Easy;

// FirstNonRepeatingChar.java
// Finds the first character that appears only once
// Time: O(n), Space: O(1) (fixed alphabet size)

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        // Test case
        System.out.println("First Non-Repeating Char: " + firstNonRepeatingChar("aabbc")); // c
    }

    // Finds the first character that appears only once
    // Time: O(n), Space: O(1) (fixed alphabet size)
    public static char firstNonRepeatingChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) return c;
        }
        return '#'; // No non-repeating char
    }
}