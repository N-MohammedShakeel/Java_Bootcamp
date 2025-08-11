# Date & Time API

## Overview
The Java Date and Time API, introduced in Java 8 under the `java.time` package, provides a modern, thread-safe, and flexible way to handle dates, times, time zones, and durations. It replaces the legacy `java.util.Date` and `java.text.SimpleDateFormat`, offering immutable classes and a clear, functional approach to time-related operations.

- **Purpose**: Manage dates, times, time zones, and durations in a robust and intuitive manner.
- **DSA Relevance**: Involves temporal data manipulation, interval calculations, and time-based sorting, which are relevant to scheduling algorithms, event handling, and time-based data structures in DSA.

## 1. LocalDate, LocalTime, LocalDateTime

### Description
These classes represent dates and times without time zones, suitable for local contexts (e.g., birthdays, meeting times).

- **`LocalDate`**: Represents a date (year, month, day) without time or time zone.
  - Example: `2025-08-11` (August 11, 2025).
  - Key Methods:
    - `of(int year, int month, int dayOfMonth)`: Creates a `LocalDate`.
    - `now()`: Returns the current date.
    - `getYear()`, `getMonth()`, `getDayOfMonth()`: Extracts components.
- **`LocalTime`**: Represents a time (hour, minute, second, nanosecond) without a date or time zone.
  - Example: `10:53:45`.
  - Key Methods:
    - `of(int hour, int minute)`: Creates a `LocalTime`.
    - `now()`: Returns the current time.
    - `getHour()`, `getMinute()`: Extracts components.
- **`LocalDateTime`**: Combines date and time without a time zone.
  - Example: `2025-08-11T10:53:45`.
  - Key Methods:
    - `of(LocalDate, LocalTime)`: Creates a `LocalDateTime`.
    - `now()`: Returns the current date and time.
    - `toLocalDate()`, `toLocalTime()`: Extracts date or time.

### Key Features
- **Immutability**: All classes are immutable; methods return new instances.
- **Thread-Safe**: Safe for use in multi-threaded applications.
- **Use Cases**: Storing birthdates, scheduling local events, logging timestamps.

### Best Practices
- Use `LocalDate` for date-only data, `LocalTime` for time-only, and `LocalDateTime` for combined date-time.
- Prefer `of()` or `now()` for creation over parsing strings.
- Validate inputs to avoid `DateTimeException` (e.g., invalid dates like February 30).
- Use `LocalDateTime` when both date and time are needed instead of separate objects.

### Common Pitfalls
- Assuming time zone information in `LocalDateTime` (use `ZonedDateTime` for time zones).
- Not handling `DateTimeException` for invalid inputs.
- Using legacy `java.util.Date` instead of modern `java.time` classes.
- Ignoring immutability, expecting methods to modify the original object.

## 2. Formatting & Parsing Dates (DateTimeFormatter)

### Description
The `DateTimeFormatter` class (`java.time.format.DateTimeFormatter`) formats and parses date/time objects into strings, supporting custom patterns and locale-specific formats.

- **Key Methods**:
  - `ofPattern(String pattern)`: Creates a formatter with a custom pattern (e.g., `"yyyy-MM-dd HH:mm:ss"`).
  - `format(TemporalAccessor temporal)`: Formats a date/time object to a string.
  - `parse(CharSequence text)`: Parses a string to a date/time object (used with `LocalDate.parse()`, etc.).
  - `ofLocalizedDateTime(FormatStyle style)`: Creates a locale-specific formatter.
- **Common Patterns**:
  - `yyyy`: 4-digit year (e.g., 2025).
  - `MM`: 2-digit month (e.g., 08).
  - `dd`: 2-digit day (e.g., 11).
  - `HH`: 24-hour format (e.g., 10).
  - `mm`: Minutes (e.g., 53).
  - `ss`: Seconds (e.g., 45).
- **Example**:
  ```java
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  LocalDateTime ldt = LocalDateTime.now();
  String formatted = dtf.format(ldt); // e.g., "2025-08-11 10:53"
  LocalDateTime parsed = LocalDateTime.parse("2025-08-11 10:53", dtf);
  ```

### Best Practices
- Use explicit patterns (e.g., `yyyy-MM-dd`) for consistent formatting.
- Reuse `DateTimeFormatter` instances for performance.
- Handle `DateTimeParseException` for invalid input strings.
- Use `ofLocalizedDateTime()` for locale-aware formatting (e.g., `FormatStyle.MEDIUM`).
- Validate input strings before parsing.

### Common Pitfalls
- Using incorrect patterns, causing `IllegalArgumentException`.
- Not handling `DateTimeParseException` for invalid formats.
- Using `SimpleDateFormat` (legacy, not thread-safe) instead of `DateTimeFormatter`.
- Assuming default locale for formatting, leading to inconsistent output.
- Not reusing formatters, reducing performance.

## 3. Working with Time Zones (ZonedDateTime, ZoneId)

### Description
`ZonedDateTime` and `ZoneId` handle dates and times with time zone information, essential for applications spanning multiple regions.

- **`ZoneId`**: Represents a time zone (e.g., `America/New_York`, `Asia/Kolkata`).
  - Key Methods:
    - `of(String zoneId)`: Creates a `ZoneId` (e.g., `ZoneId.of("Asia/Kolkata")`).
    - `systemDefault()`: Returns the system’s default time zone.
    - `getAvailableZoneIds()`: Lists all valid time zones.
- **`ZonedDateTime`**: Represents a date-time with a time zone.
  - Key Methods:
    - `of(LocalDateTime, ZoneId)`: Creates a `ZonedDateTime`.
    - `now()`: Returns the current date-time in the system time zone.
    - `withZoneSameInstant(ZoneId)`: Converts to another time zone, preserving the instant.
- **Example**:
  ```java
  ZoneId zone = ZoneId.of("Asia/Kolkata");
  ZonedDateTime zdt = ZonedDateTime.now(zone);
  String formatted = zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z"));
  // e.g., "2025-08-11 10:53 IST"
  ```

### Best Practices
- Use `ZoneId.of()` with explicit time zone IDs for clarity.
- Prefer `ZonedDateTime` over `LocalDateTime` for applications requiring time zone awareness.
- Use `withZoneSameInstant()` for time zone conversions.
- Validate time zone IDs to avoid `ZoneRulesException`.
- Use `ZoneId.systemDefault()` only when appropriate (e.g., user-specific settings).

### Common Pitfalls
- Using invalid time zone IDs, causing `ZoneRulesException`.
- Confusing `LocalDateTime` with `ZonedDateTime` for time zone operations.
- Not handling daylight saving time (DST) transitions correctly.
- Assuming system default time zone is consistent across servers.
- Overcomplicating time zone conversions without `withZoneSameInstant()`.

## 4. Adding/Subtracting Time (plusDays, minusHours)

### Description
The Date and Time API provides methods like `plusDays()`, `minusHours()`, etc., to perform temporal arithmetic on `LocalDate`, `LocalTime`, `LocalDateTime`, and `ZonedDateTime`.

- **Key Methods** (available on `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`):
  - `plusDays(long days)`: Adds days.
  - `minusHours(long hours)`: Subtracts hours.
  - `plus/minus(TemporalAmount amount)`: Adds/subtracts a `Period` or `Duration`.
- **Example**:
  ```java
  LocalDate date = LocalDate.of(2025, 8, 11);
  LocalDate nextWeek = date.plusDays(7); // 2025-08-18
  LocalDateTime ldt = LocalDateTime.of(2025, 8, 11, 10, 53);
  LocalDateTime earlier = ldt.minusHours(2); // 2025-08-11T08:53
  ```

### Best Practices
- Use specific methods (e.g., `plusDays()`) for clarity over general `plus()`.
- Validate inputs to avoid `DateTimeException` (e.g., overflow for large values).
- Use `Period` for date-based arithmetic and `Duration` for time-based arithmetic.
- Chain operations for readability (e.g., `date.plusDays(1).plusMonths(1)`).
- Consider DST when adjusting `ZonedDateTime`.

### Common Pitfalls
- Using `plus()` with incorrect `TemporalAmount`, causing `DateTimeException`.
- Ignoring DST effects in `ZonedDateTime` arithmetic.
- Not handling overflow for large time adjustments.
- Mixing date and time arithmetic without proper context.
- Assuming methods modify the original object (they return new instances).

## 5. Calculating Duration (Duration, Period)

### Description
`Duration` and `Period` calculate time spans between two temporal objects or represent time intervals.

- **`Period`**: Represents a date-based amount (years, months, days).
  - Key Methods:
    - `between(LocalDate start, LocalDate end)`: Calculates the period between dates.
    - `of(int years, int months, int days)`: Creates a `Period`.
    - `getYears()`, `getMonths()`, `getDays()`: Extracts components.
  - Example: `Period.between(LocalDate.of(2025, 8, 11), LocalDate.of(2026, 8, 11))` returns `Period.ofYears(1)`.
- **`Duration`**: Represents a time-based amount (seconds, nanoseconds).
  - Key Methods:
    - `between(Temporal start, Temporal end)`: Calculates duration between times.
    - `ofHours(long hours)`: Creates a `Duration`.
    - `toHours()`, `toMinutes()`: Converts to units.
  - Example: `Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(2))` returns `PT2H`.

### Best Practices
- Use `Period` for date-based intervals (e.g., years, months).
- Use `Duration` for time-based intervals (e.g., hours, seconds).
- Validate inputs to avoid negative durations or invalid periods.
- Use `toDays()`, `toHours()`, etc., for human-readable output.
- Combine with formatting for user-friendly display.

### Common Pitfalls
- Using `Duration` for date-based intervals or vice versa.
- Not handling negative durations/periods when order matters.
- Ignoring nanosecond precision in `Duration` for high-precision applications.
- Not validating inputs, leading to `DateTimeException`.
- Assuming `Period` accounts for time components (it’s date-only).

## Best Practices (Overall)
- Prefer `java.time` classes over legacy `java.util.Date` and `java.text.SimpleDateFormat`.
- Use specific classes (`LocalDate`, `ZonedDateTime`) based on requirements.
- Reuse `DateTimeFormatter` instances for performance.
- Handle exceptions (`DateTimeException`, `DateTimeParseException`, `ZoneRulesException`) gracefully.
- Validate inputs for arithmetic and parsing operations.
- Use explicit time zones and patterns for consistency across systems.

## Common Pitfalls (Overall)
- Mixing legacy and modern APIs, leading to complexity.
- Not handling exceptions for invalid inputs or formats.
- Assuming system default time zone or locale, causing inconsistent behavior.
- Ignoring immutability, expecting methods to modify objects.
- Overcomplicating simple operations with unnecessary conversions.

## Practice Task
- **Task**: Write a program that:
  1. Creates a `LocalDateTime` for the current date and time in `Asia/Kolkata`.
  2. Formats it as `yyyy-MM-dd HH:mm:ss z`.
  3. Converts it to `America/New_York` time zone and formats it.
  4. Adds 5 days and subtracts 3 hours.
  5. Calculates the duration between the original and modified times.
  6. Calculates the period between the original and modified dates.
- **Solution Approach**:
  - Use `LocalDateTime.now(ZoneId)` and `ZonedDateTime` for time zone handling.
  - Use `DateTimeFormatter` for formatting.
  - Use `plusDays()` and `minusHours()` for arithmetic.
  - Use `Period.between()` and `Duration.between()` for calculations.
  - Handle all exceptions.