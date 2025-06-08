package Java_Bootcamp.DSA.Basic.String.Medium;

// CheckBannedWords.java
// Checks if string contains any banned words
// Time: O(n), Space: O(1)

public class CheckBannedWords {
    public static void main(String[] args) {
        // Test case
        System.out.println("Check Banned Words: " + checkBannedWords("I hate this")); // true
    }

    // Checks if string contains any banned words
    // Time: O(n), Space: O(1)
    public static boolean checkBannedWords(String str) {
        String[] bannedWords = {"hate", "bad", "ugly"};
        str = str.toLowerCase();
        for (String bad : bannedWords) {
            if (str.contains(bad)) {
                return true;
            }
        }
        return false;
    }
}