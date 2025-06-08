package Java_Bootcamp.DSA.Basic.String.Hard;

// CheckBalancedAsterisksHashes.java
// Checks if asterisks and hashes are balanced, suggests additions if not
// Time: O(n), Space: O(1)

public class CheckBalancedAsterisksHashes {
    public static void main(String[] args) {
        // Test case
        System.out.println("Check Balanced Asterisks and Hashes: ");
        checkBalanced("*#*"); // Balanced
    }

    // Checks if asterisks and hashes are balanced, suggests additions if not
    // Time: O(n), Space: O(1)
    public static void checkBalanced(String str) {
        int asterisk = 0, hash = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '*') asterisk++;
            else if (ch == '#') hash++;
        }
        if (asterisk == hash) {
            System.out.println("Balanced");
        } else if (asterisk > hash) {
            System.out.println((asterisk - hash) + " # should be added");
        } else {
            System.out.println((hash - asterisk) + " * should be added");
        }
    }
}