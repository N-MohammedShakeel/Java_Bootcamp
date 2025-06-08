package Java_Bootcamp.DSA.Basic.String.Easy;

// CheckAnagram.java
// Checks if two strings are anagrams using character frequency
// Time: O(n), Space: O(1) (fixed alphabet size)

public class CheckAnagram {
    public static void main(String[] args) {
        // Test case
        System.out.println("Check Anagram: " + isAnagram("listen", "silent")); // true
    }

    // Checks if two strings are anagrams using character frequency
    // Time: O(n), Space: O(1) (fixed alphabet size)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}