package Java_Bootcamp.JavaBasics_Advance.String_Handling.Regular_Expression; /**
 * RegexDemo.java
 * Demonstrates Pattern and Matcher for email validation and digit extraction.
 * Scenario: Validate an email and extract digits from a string.
 * Features: Uses Pattern.compile(), Matcher.matches(), find(), and group().
 * DSA Relevance: Pattern matching, string parsing.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {
    public static void main(String[] args) {
        System.out.println("=== Regular Expressions Demo ===");
        String email = "user@example.com";
        String text = "Order 123, quantity 456, price 789.99";

        try {
            // Email validation
            String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
            Pattern emailPattern = Pattern.compile(emailRegex);
            Matcher emailMatcher = emailPattern.matcher(email);
            System.out.println("Email '" + email + "' is valid: " + emailMatcher.matches());

            // Extract digits
            Pattern digitPattern = Pattern.compile("\\d+");
            Matcher digitMatcher = digitPattern.matcher(text);
            System.out.println("Digits found:");
            while (digitMatcher.find()) {
                System.out.println("Found: " + digitMatcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Invalid regex pattern: " + e.getMessage());
        }
    }
}