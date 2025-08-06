package Java_Bootcamp.Advanced_Java;// Java Fundamentals: Regular Expressions (RE)
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Regular Expressions Overview
---------------------------
- Regular Expressions (RE) are patterns used to match, search, and manipulate strings based on specific rules.
- In Java, regex is supported via the java.util.regex package, primarily through Pattern and Matcher classes.
- Key Features:
  - Pattern matching for validation, searching, and replacing text.
  - Flexible syntax for defining complex string patterns.
  - Used in input validation, text parsing, and data extraction.
- Common Use Cases:
  - Validating formats (e.g., email, phone numbers).
  - Extracting data (e.g., numbers, words).
  - Replacing or splitting strings based on patterns.

Key Regex Constructs
--------------------
- Literals: Exact characters (e.g., "cat" matches "cat").
- Metacharacters: Special characters with specific meanings:
  - . : Any character (except newline).
  - ^ : Start of string.
  - $ : End of string.
  - * : Zero or more occurrences.
  - + : One or more occurrences.
  - ? : Zero or one occurrence.
  - \d : Any digit (0-9).
  - \w : Word character (a-z, A-Z, 0-9, _).
  - \s : Whitespace.
  - [] : Character class (e.g., [a-z] for lowercase letters).
  - | : Alternation (OR).
  - () : Grouping.
- Escaping: Use \ to escape metacharacters (e.g., \. for literal dot).
- Quantifiers: {n}, {n,}, {n,m} for exact, at least, or range of occurrences.
- Example: ^\d{3}-\d{2}-\d{4}$ matches "123-45-6789".

Java Regex Classes
------------------
- Pattern: Represents a compiled regex pattern.
  - Creation: Pattern.compile(regex)
  - Methods: matcher(), split()
- Matcher: Performs matching operations on a string.
  - Creation: pattern.matcher(input)
  - Methods: matches(), find(), group(), replaceAll()
- Notes:
  - Patterns are immutable and thread-safe; compile once for reuse.
  - Use Pattern.CASE_INSENSITIVE for case-insensitive matching.
  - Backslashes in Java strings require escaping (e.g., "\\d" for \d).
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class RegularExpressionsDemo {
    public static void main(String[] args) {
        // Example 1: Validating Email Address
        System.out.println("Example 1: Validating Email Address");
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        String[] emails = {
            "user@example.com",
            "invalid@.com",
            "user.name@domain.co.uk",
            "no@domain"
        };
        for (String email : emails) {
            Matcher matcher = emailPattern.matcher(email);
            System.out.println("Email: " + email + " -> Valid: " + matcher.matches());
        }

        // Example 2: Extracting Numbers from Text
        System.out.println("\nExample 2: Extracting Numbers from Text");
        String text = "Order #123 has 45 items, shipped on 2025-05-19.";
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(text);
        System.out.print("Numbers found: ");
        while (numberMatcher.find()) {
            System.out.print(numberMatcher.group() + " ");
        }
        System.out.println();

        // Example 3: Splitting String by Multiple Delimiters
        System.out.println("\nExample 3: Splitting String by Multiple Delimiters");
        String input = "apple,banana;cherry|date";
        String[] fruits = input.split("[,;\\|]");
        System.out.println("Fruits: " + Arrays.toString(fruits));

        // Example 4: Replacing Text with Pattern
        System.out.println("\nExample 4: Replacing Text with Pattern");
        String sentence = "The cat and the dog ran.";
        String replaced = sentence.replaceAll("\\b(cat|dog)\\b", "pet");
        System.out.println("Original: " + sentence);
        System.out.println("Replaced: " + replaced);

        // Example 5: Validating Phone Number
        System.out.println("\nExample 5: Validating Phone Number");
        String phoneRegex = "^\\(\\d{3}\\) \\d{3}-\\d{4}$"; // Matches (123) 456-7890
        Pattern phonePattern = Pattern.compile(phoneRegex);
        String[] phones = {
            "(123) 456-7890",
            "123-456-7890",
            "(123) 456-789"
        };
        for (String phone : phones) {
            Matcher matcher = phonePattern.matcher(phone);
            System.out.println("Phone: " + phone + " -> Valid: " + matcher.matches());
        }

        // Example 6: Case-Insensitive Matching
        System.out.println("\nExample 6: Case-Insensitive Matching");
        String caseText = "JAVA, Java, java";
        Pattern casePattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher caseMatcher = casePattern.matcher(caseText);
        int count = 0;
        while (caseMatcher.find()) {
            count++;
        }
        System.out.println("Occurrences of 'java' (case-insensitive): " + count);
    }
}