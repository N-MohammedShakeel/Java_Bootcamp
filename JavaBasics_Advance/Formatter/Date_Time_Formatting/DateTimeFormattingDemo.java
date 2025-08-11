package Java_Bootcamp.JavaBasics_Advance.Formatter.Date_Time_Formatting; /**
 * DateTimeFormattingDemo.java
 * Demonstrates DateTimeFormatter for formatting current date/time.
 * Scenario: Format LocalDateTime in yyyy-MM-dd HH:mm:ss.
 * Features: Uses DateTimeFormatter, error handling, and modern Java time API.
 * DSA Relevance: Pattern parsing, string manipulation.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class DateTimeFormattingDemo {
    public static void main(String[] args) {
        System.out.println("=== Date/Time Formatting Demo ===");
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formatted = dtf.format(now);
            System.out.println("Formatted Date/Time: " + formatted);

            // Example with predefined style
            DateTimeFormatter fullDtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            System.out.println("Medium Format: " + fullDtf.format(now));
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.err.println("Error formatting date/time: " + e.getMessage());
        }
    }
}