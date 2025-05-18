package Java_Bootcamp.JavaBasics.StringHandling.problems;

public class ReverseString {
    public static void main(String[] args) {
        // Problem: Reverse a given string "Hello World"
        String input = "Hello World";
        System.out.println("Input: " + input);

        // Solution: Use StringBuilder to reverse the string
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}