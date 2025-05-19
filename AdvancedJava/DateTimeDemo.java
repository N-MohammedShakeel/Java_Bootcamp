package Java_Bootcamp.AdvancedJava;// Java Fundamentals: Date and Time (java.time API)
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Date and Time API Overview
-------------------------
- Introduced in Java 8 (JSR 310), the java.time package provides a modern, robust API for handling dates, times, and durations.
- Replaces older, flawed classes like java.util.Date and java.util.Calendar.
- Key Features:
  - Immutable and thread-safe classes.
  - Clear separation of date, time, and datetime concepts.
  - Support for time zones, durations, periods, and formatting.
  - Human-readable and ISO-8601 compliant by default.
- Main Classes:
  - LocalDate: Represents a date without time or time zone (e.g., 2025-05-19).
  - LocalTime: Represents a time without date or time zone (e.g., 20:39:45).
  - LocalDateTime: Combines date and time without time zone (e.g., 2025-05-19T20:39:45).
  - ZonedDateTime: Date and time with time zone (e.g., 2025-05-19T20:39:45+05:30[Asia/Kolkata]).
  - Instant: A point on the timeline in UTC (machine-readable, e.g., 2025-05-19T15:09:45Z).
  - Duration: Time-based amount (e.g., 2 hours).
  - Period: Date-based amount (e.g., 1 year, 2 months).
- Notes:
  - Use java.time over legacy Date/Calendar for new code.
  - Formatting and parsing handled by DateTimeFormatter.
  - Time zone support via ZoneId and ZoneOffset.

Common Operations
----------------
- Creation: Use now() for current date/time or of() for specific values.
- Manipulation: Methods like plusDays(), minusHours(), withYear() for adjustments.
- Comparison: isBefore(), isAfter(), equals() for temporal comparisons.
- Formatting/Parsing: DateTimeFormatter for custom patterns (e.g., "dd-MM-yyyy").
- Time Zones: ZonedDateTime for time zone-aware operations.
- Example:
  LocalDate date = LocalDate.now();
  LocalDateTime dateTime = LocalDateTime.of(2025, 5, 19, 20, 39);
  String formatted = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
*/

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {
    public static void main(String[] args) {
        // Example 1: Creating Date and Time Objects
        System.out.println("Example 1: Creating Date and Time Objects");
        LocalDate date = LocalDate.now(); // Current date
        LocalTime time = LocalTime.now(); // Current time
        LocalDateTime dateTime = LocalDateTime.now(); // Current date and time
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata")); // Current date-time with time zone
        Instant instant = Instant.now(); // Current instant in UTC
        System.out.println("LocalDate: " + date); // e.g., 2025-05-19
        System.out.println("LocalTime: " + time); // e.g., 20:39:45.123
        System.out.println("LocalDateTime: " + dateTime); // e.g., 2025-05-19T20:39:45.123
        System.out.println("ZonedDateTime: " + zonedDateTime); // e.g., 2025-05-19T20:39:45.123+05:30[Asia/Kolkata]
        System.out.println("Instant: " + instant); // e.g., 2025-05-19T15:09:45.123Z

        // Example 2: Specific Date and Time
        System.out.println("\nExample 2: Specific Date and Time");
        LocalDate specificDate = LocalDate.of(2025, 12, 31);
        LocalTime specificTime = LocalTime.of(23, 59, 59);
        LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime);
        System.out.println("Specific Date: " + specificDate); // 2025-12-31
        System.out.println("Specific Time: " + specificTime); // 23:59:59
        System.out.println("Specific DateTime: " + specificDateTime); // 2025-12-31T23:59:59

        // Example 3: Manipulating Dates and Times
        System.out.println("\nExample 3: Manipulating Dates and Times");
        LocalDate tomorrow = date.plusDays(1);
        LocalDateTime nextHour = dateTime.plus(1, ChronoUnit.HOURS);
        LocalDateTime changedYear = dateTime.withYear(2026);
        System.out.println("Tomorrow: " + tomorrow); // e.g., 2025-05-20
        System.out.println("Next Hour: " + nextHour); // e.g., 2025-05-19T21:39:45.123
        System.out.println("Changed Year: " + changedYear); // e.g., 2026-05-19T20:39:45.123

        // Example 4: Formatting and Parsing
        System.out.println("\nExample 4: Formatting and Parsing");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = date.format(dateFormatter);
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        System.out.println("Formatted Date: " + formattedDate); // e.g., 19-05-2025
        System.out.println("Formatted DateTime: " + formattedDateTime); // e.g., 19/05/2025 20:39:45
        LocalDate parsedDate = LocalDate.parse("31-12-2025", dateFormatter);
        System.out.println("Parsed Date: " + parsedDate); // 2025-12-31

        // Example 5: Time Zone Handling
        System.out.println("\nExample 5: Time Zone Handling");
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime sameInstantTokyo = nyTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("New York Time: " + nyTime); // e.g., 2025-05-19T11:39:45.123-04:00[America/New_York]
        System.out.println("Tokyo Time (same instant): " + sameInstantTokyo); // e.g., 2025-05-20T00:39:45.123+09:00[Asia/Tokyo]

        // Example 6: Durations and Periods
        System.out.println("\nExample 6: Durations and Periods");
        Duration duration = Duration.between(LocalTime.of(10, 0), LocalTime.of(12, 30));
        Period period = Period.between(LocalDate.of(2025, 1, 1), LocalDate.of(2026, 6, 15));
        System.out.println("Duration: " + duration); // e.g., PT2H30M (2 hours, 30 minutes)
        System.out.println("Period: " + period); // e.g., P1Y5M14D (1 year, 5 months, 14 days)
    }
}