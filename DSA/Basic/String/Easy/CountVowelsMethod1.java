package Java_Bootcamp.DSA.Basic.String.Easy;

// CountVowelsMethod1.java
// Counts vowels by checking each character
// Time: O(n), Space: O(1)

public class CountVowelsMethod1 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Count Vowels (Method 1): " + countVowelsMethod1("apple")); // 2
    }

    // Counts vowels by checking each character
    // Time: O(n), Space: O(1)
    public static int countVowelsMethod1(String str) {
        int vowel = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            }
        }
        return vowel;
    }
}