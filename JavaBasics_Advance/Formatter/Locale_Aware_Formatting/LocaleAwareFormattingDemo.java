package Java_Bootcamp.JavaBasics_Advance.Formatter.Locale_Aware_Formatting; /**
 * LocaleAwareFormattingDemo.java
 * Demonstrates locale-aware formatting for currency and dates.
 * Scenario: Format price and date for US and UK locales.
 * Features: Uses NumberFormat, DateTimeFormatter, and locale handling.
 * DSA Relevance: Localization, string transformation.
 */
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocaleAwareFormattingDemo {
    public static void main(String[] args) {
        System.out.println("=== Locale-Aware Formatting Demo ===");
        double price = 1234.56;
        LocalDate date = LocalDate.now();

        try {
            // US Locale
            NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
            DateTimeFormatter usDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US);
            System.out.println("US Currency: " + usCurrency.format(price)); // $1,234.56
            System.out.println("US Date: " + usDate.format(date)); // e.g., Aug 11, 2025

            // UK Locale
            NumberFormat ukCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
            DateTimeFormatter ukDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.UK);
            System.out.println("UK Currency: " + ukCurrency.format(price)); // £1,234.56
            System.out.println("UK Date: " + ukDate.format(date)); // e.g., 11 Aug 2025
        } catch (IllegalArgumentException e) {
            System.err.println("Error formatting: " + e.getMessage());
        }
    }
}