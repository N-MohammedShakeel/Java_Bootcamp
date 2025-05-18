package Java_Bootcamp.JavaBasics.StringHandling.problems;

public class ReplaceWords {
    public static void main(String[] args) {
        // Problem: Replace all occurrences of "cat" with "dog" in "The cat and cat"
        String input = "The cat and cat";
        System.out.println("Input: " + input);

        // Solution: Use String.replace method
        String result = input.replace("cat", "dog");
        System.out.println("Result: " + result);
    }
}