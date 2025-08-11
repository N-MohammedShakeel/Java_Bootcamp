package Java_Bootcamp.JavaBasics_Advance.Date_Time_API; /**
 * DateTimeAPIDemo.java
 * Demonstrates the Java Date and Time API (java.time).
 * Scenario: Process dates, times, time zones, arithmetic, and durations.
 * Features: Uses LocalDateTime, ZonedDateTime, DateTimeFormatter, Period, Duration, and error handling.
 * DSA Relevance: Temporal data manipulation, interval calculations.
 */
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class DateTimeAPIDemo {
    public static void main(String[] args) {
        System.out.println("=== Date & Time API Demo ===");
        
        try {
            // 1. LocalDate, LocalTime, LocalDateTime
            System.out.println("=== LocalDate, LocalTime, LocalDateTime ===");
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            LocalDateTime ldt = LocalDateTime.now();
            System.out.println("LocalDate: " + date); // e.g., 2025-08-11
            System.out.println("LocalTime: " + time); // e.g., 10:53:45.123
            System.out.println("LocalDateTime: " + ldt); // e.g., 2025-08-11T10:53:45.123

            // 2. Formatting & Parsing Dates
            System.out.println("\n=== Formatting & Parsing ===");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedLdt = ldt.format(dtf);
            System.out.println("Formatted LocalDateTime: " + formattedLdt);
            LocalDateTime parsedLdt = LocalDateTime.parse(formattedLdt, dtf);
            System.out.println("Parsed LocalDateTime: " + parsedLdt);

            // 3. Working with Time Zones
            System.out.println("\n=== Time Zones ===");
            ZoneId kolkataZone = ZoneId.of("Asia/Kolkata");
            ZonedDateTime kolkataZdt = ZonedDateTime.of(ldt, kolkataZone);
            DateTimeFormatter zdtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
            System.out.println("Kolkata Time: " + kolkataZdt.format(zdtFormatter));
            ZonedDateTime nyZdt = kolkataZdt.withZoneSameInstant(ZoneId.of("America/New_York"));
            System.out.println("New York Time: " + nyZdt.format(zdtFormatter));

            // 4. Adding/Subtracting Time
            System.out.println("\n=== Adding/Subtracting Time ===");
            LocalDateTime modifiedLdt = ldt.plusDays(5).minusHours(3);
            System.out.println("Original: " + ldt.format(dtf));
            System.out.println("After +5 days, -3 hours: " + modifiedLdt.format(dtf));

            // 5. Calculating Duration and Period
            System.out.println("\n=== Duration and Period ===");
            Duration duration = Duration.between(ldt, modifiedLdt);
            System.out.println("Duration: " + duration.toHours() + " hours");
            Period period = Period.between(ldt.toLocalDate(), modifiedLdt.toLocalDate());
            System.out.println("Period: " + period.getDays() + " days");

            // Practice Task
            System.out.println("\n=== Practice Task ===");
            ZonedDateTime taskZdt = ZonedDateTime.now(kolkataZone);
            System.out.println("Current Kolkata Time: " + taskZdt.format(zdtFormatter));
            ZonedDateTime taskNyZdt = taskZdt.withZoneSameInstant(ZoneId.of("America/New_York"));
            System.out.println("Current New York Time: " + taskNyZdt.format(zdtFormatter));
            ZonedDateTime modifiedTaskZdt = taskZdt.plusDays(5).minusHours(3);
            System.out.println("Modified Kolkata Time (+5 days, -3 hours): " + modifiedTaskZdt.format(zdtFormatter));
            Duration taskDuration = Duration.between(taskZdt, modifiedTaskZdt);
            System.out.println("Duration between times: " + taskDuration.toHours() + " hours");
            Period taskPeriod = Period.between(taskZdt.toLocalDate(), modifiedTaskZdt.toLocalDate());
            System.out.println("Period between dates: " + taskPeriod.getDays() + " days");

        } catch (DateTimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}