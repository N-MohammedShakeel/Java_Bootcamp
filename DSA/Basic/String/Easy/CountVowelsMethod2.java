package Java_Bootcamp.DSA.Basic.String.Easy;

import java.util.*;

// CountVowelsMethod2.java
// Uses ArrayLists to track vowels and consonants, then counts
// Time: O(n), Space: O(1) (fixed size lists)

public class CountVowelsMethod2 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Count Vowels (Method 2): " + countVowelsMethod2("apple")); // 2
    }

    // Uses ArrayLists to track vowels and consonants, then counts
    // Time: O(n), Space: O(1) (fixed size lists)
    public static int countVowelsMethod2(String str) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int vowel = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (vowels.contains(ch)) {
                vowel++;
            }
        }
        return vowel;
    }
}