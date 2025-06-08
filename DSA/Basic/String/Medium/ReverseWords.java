package Java_Bootcamp.DSA.Basic.String.Medium;

// ReverseWords.java
// Reverses the order of words in a string
// Time: O(n), Space: O(n)

public class ReverseWords {
    public static void main(String[] args) {
        // Test case
        System.out.println("Reverse Words in a String: " + reverseWords("  hello world  ")); // world hello
    }

    // Reverses the order of words in a string
    // Time: O(n), Space: O(n)
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }
}