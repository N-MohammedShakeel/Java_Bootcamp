package Java_Bootcamp.DSA.Basic.String;

public class EasyStringProblems {
    public static void main(String[] args) {
        // Test cases for easy string problems
        System.out.println("1. Reverse String: " + reverseString("hello")); // olleh
        System.out.println("2. Is Palindrome: " + isPalindrome("radar")); // true
        System.out.println("3. Count Vowels: " + countVowels("apple")); // 2
        System.out.println("4. To Upper Case: " + toUpperCase("hello")); // HELLO
        System.out.println("5. To Lower Case: " + toLowerCase("HELLO")); // hello
        System.out.println("6. Check Anagram: " + isAnagram("listen", "silent")); // true
        System.out.println("7. First Non-Repeating Char: " + firstNonRepeatingChar("aabbc")); // c
        System.out.println("8. Remove Spaces: " + removeSpaces("  hello  world  ")); // helloworld
        System.out.println("9. Count Occurrences: " + countOccurrences("hello", 'l')); // 2
        System.out.println("10. Is Substring: " + isSubstring("hello world", "world")); // true
    }

    // 1. Reverse a String
    // Time: O(n), Space: O(n) for StringBuilder
    // LeetCode: https://leetcode.com/problems/reverse-string/
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    // 2. Check if String is Palindrome
    // Time: O(n), Space: O(1)
    // LeetCode: https://leetcode.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // 3. Count Vowels in a String
    // Time: O(n), Space: O(1)
    public static int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
        }
        return count;
    }

    // 4. Convert String to Upper Case
    // Time: O(n), Space: O(n)
    // LeetCode: https://leetcode.com/problems/to-lower-case/ (similar, but for upper case)
    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    // 5. Convert String to Lower Case
    // Time: O(n), Space: O(n)
    // LeetCode: https://leetcode.com/problems/to-lower-case/
    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    // 6. Check if Two Strings are Anagrams
    // Time: O(n), Space: O(1) (assuming fixed alphabet size)
    // LeetCode: https://leetcode.com/problems/valid-anagram/
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

    // 7. Find First Non-Repeating Character
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

    // 8. Remove All Spaces from String
    // Time: O(n), Space: O(n)
    public static String removeSpaces(String s) {
        return s.replaceAll("\\s", "");
    }

    // 9. Count Occurrences of a Character
    // Time: O(n), Space: O(1)
    public static int countOccurrences(String s, char target) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == target) count++;
        }
        return count;
    }

    // 10. Check if a String is a Substring
    // Time: O(n+m) where n,m are lengths of strings, Space: O(1)
    public static boolean isSubstring(String s, String sub) {
        return s.contains(sub);
    }
}