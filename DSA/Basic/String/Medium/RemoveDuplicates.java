package Java_Bootcamp.DSA.Basic.String.Medium;

// RemoveDuplicates.java
// Removes adjacent duplicate characters
// Time: O(n), Space: O(n)

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Test case
        System.out.println("Remove Duplicates from Sorted String: " + removeDuplicates("abbaca")); // abca
    }

    // Removes adjacent duplicate characters
    // Time: O(n), Space: O(n)
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}