# Date/Time Formatting

## Overview
The `DateTimeFormatter` class in Java (`java.time.format`) formats and parses date/time objects (`LocalDate`, `LocalDateTime`, etc.) introduced in Java 8. It provides flexible and locale-aware formatting for modern date/time APIs.

- **Purpose**: Format and display date/time values in a user-friendly manner.
- **DSA Relevance**: Involves pattern parsing and string manipulation, similar to string processing in DSA.

## DateTimeFormatter
- **Class**: `java.time.format.DateTimeFormatter`
- **Key Methods**:
  - `ofPattern(String pattern)`: Creates a formatter with a custom pattern.
  - `format(TemporalAccessor temporal)`: Formats a date/time object.
  - `parse(CharSequence text)`: Parses a string into a date/time object.
- **Common Patterns**:
  - `yyyy`: 4-digit year.
  - `MM`: 2-digit month.
  - `dd`: 2-digit day.
  - `HH`: 24-hour format.
  - `mm`: Minutes.
  - `ss`: Seconds.
- **Example**:
  ```java
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  LocalDateTime now = LocalDateTime.now();
  String formatted = dtf.format(now); // e.g., "2025-08-11 10:30"
  ```

## Best Practices
- Use `DateTimeFormatter` instead of legacy `SimpleDateFormat` for thread safety.
- Specify explicit patterns for consistency (e.g., `yyyy-MM-dd`).
- Use locale-specific formatters for internationalization (e.g., `DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)`).
- Handle `DateTimeParseException` for invalid inputs.
- Reuse `DateTimeFormatter` instances for performance.

## Common Pitfalls
- Using `SimpleDateFormat` in multi-threaded applications, causing thread-safety issues.
- Incorrect pattern syntax, leading to `IllegalArgumentException`.
- Not handling `DateTimeParseException` during parsing.
- Assuming default locale for formatting, causing inconsistent output.
- Not validating input strings before parsing.

## Practice Task
- **Task**: Format the current date and time in `yyyy-MM-dd HH:mm:ss` format using `DateTimeFormatter`.
- **Solution Approach**:
  - Create a `DateTimeFormatter` with the specified pattern.
  - Format `LocalDateTime.now()`.
  - Handle exceptions for invalid patterns.