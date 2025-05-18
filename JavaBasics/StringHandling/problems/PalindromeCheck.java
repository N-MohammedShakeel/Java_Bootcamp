package Java_Bootcamp.JavaBasics.StringHandling.problems;

public class PalindromeCheck {
    public static void main(String[] args) {
        // Problem: Check if "Radar" is a palindrome (case-insensitive)
        String input = "Radar";
        System.out.println("Input: " + input);

        // Solution: Compare the string with its reverse after normalizing
        String normalized = input.toLowerCase();
        StringBuilder sb = new StringBuilder(normalized);
        boolean isPalindrome = normalized.equals(sb.reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}