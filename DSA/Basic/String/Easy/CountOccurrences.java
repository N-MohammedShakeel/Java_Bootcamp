package Java_Bootcamp.DSA.Basic.String.Easy;

// CountOccurrences.java
// Counts occurrences of a specific character
// Time: O(n), Space: O(1)

public class CountOccurrences {
    public static void main(String[] args) {
        // Test case
        System.out.println("Count Occurrences: " + countOccurrences("hello", 'l')); // 2
    }

    // Counts occurrences of a specific character
    // Time: O(n), Space: O(1)
    public static int countOccurrences(String s, char target) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == target) count++;
        }
        return count;
    }
}