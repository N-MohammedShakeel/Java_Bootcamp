package Java_Bootcamp.JavaBasics_Advance.Formatter.Parsing_Formatted_Values; /**
 * ParsingFormattedValuesDemo.java
 * Demonstrates parsing currency and date strings into numbers and dates.
 * Scenario: Parse "$1,234.56" and "2025-08-11" into double and LocalDate.
 * Features: Uses NumberFormat, DateTimeFormatter, and error handling.
 * DSA Relevance: String parsing, error handling.
 */
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class ParsingFormattedValuesDemo {
    public static void main(String[] args) {
        System.out.println("=== Parsing Formatted Values Demo ===");
        String currencyStr = "$1,234.56";
        String dateStr = "2025-08-11";

        try {
            // Parse currency
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            Number parsedNumber = currencyFormat.parse(currencyStr);
            double value = parsedNumber.doubleValue();
            System.out.println("Parsed Currency: " + value); // 1234.56

            // Parse date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateStr, dtf);
            System.out.println("Parsed Date: " + date); // 2025-08-11
        } catch (ParseException | DateTimeParseException e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }
}