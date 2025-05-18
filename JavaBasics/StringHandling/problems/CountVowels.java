package Java_Bootcamp.JavaBasics.StringHandling.problems;

public class CountVowels {
    public static void main(String[] args) {
        // Problem: Count the number of vowels in "Programming"
        String input = "Programming";
        System.out.println("Input: " + input);

        // Solution: Iterate through the string and check for vowels
        int count = 0;
        String lowerInput = input.toLowerCase();
        for (int i = 0; i < lowerInput.length(); i++) {
            char c = lowerInput.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println("Vowel count: " + count);
    }
}