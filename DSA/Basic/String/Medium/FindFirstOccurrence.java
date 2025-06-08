package Java_Bootcamp.DSA.Basic.String.Medium;

// FindFirstOccurrence.java
// Finds the first occurrence of a substring
// Time: O(n*m), Space: O(1)

public class FindFirstOccurrence {
    public static void main(String[] args) {
        // Test case
        System.out.println("Find First Occurrence: " + strStr("hello", "ll")); // 2
    }

    // Finds the first occurrence of a substring
    // Time: O(n*m), Space: O(1)
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}