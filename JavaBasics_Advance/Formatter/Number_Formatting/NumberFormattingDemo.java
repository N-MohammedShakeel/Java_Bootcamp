package Java_Bootcamp.JavaBasics_Advance.Formatter.Number_Formatting; /**
 * NumberFormattingDemo.java
 * Demonstrates DecimalFormat for formatting numbers with commas and two decimal places.
 * Scenario: Format a list of numbers.
 * Features: Uses DecimalFormat, input validation, and custom patterns.
 * DSA Relevance: String manipulation, pattern processing.
 */
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormattingDemo {
    public static void main(String[] args) {
        System.out.println("=== Number Formatting Demo ===");
        double[] numbers = {1234.567, 0.1, 9999.9999, Double.NaN};

        // Configure DecimalFormat
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        df.setDecimalFormatSymbols(symbols);

        System.out.println("Formatted Numbers:");
        for (double num : numbers) {
            try {
                if (Double.isNaN(num) || Double.isInfinite(num)) {
                    System.out.println("Invalid number: " + num);
                    continue;
                }
                String formatted = df.format(num);
                System.out.println("Number: " + num + " -> Formatted: " + formatted);
            } catch (IllegalArgumentException e) {
                System.err.println("Error formatting " + num + ": " + e.getMessage());
            }
        }
    }
}