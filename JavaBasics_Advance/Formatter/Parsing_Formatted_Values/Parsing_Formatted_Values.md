# Parsing Formatted Values

## Overview
Parsing formatted values involves converting strings back into numbers or date/time objects using classes like `NumberFormat`, `DecimalFormat`, and `DateTimeFormatter`. This is critical for processing user input or data from external sources.

- **Purpose**: Convert formatted strings into usable data types.
- **DSA Relevance**: Involves string parsing and error handling, similar to lexical analysis in DSA.

## Parsing Numbers
- **NumberFormat**:
  - Method: `parse(String source)` returns a `Number` (e.g., `Double`, `Long`).
  - Example: `NumberFormat.getNumberInstance().parse("1,234.56")` returns `1234.56`.
- **DecimalFormat**:
  - Method: `parse(String source)` returns a `Number`.
  - Example: `new DecimalFormat("#,##0.00").parse("1,234.56")` returns `1234.56`.
- **Exception**: `ParseException` for invalid input.

## Parsing Dates
- **DateTimeFormatter**:
  - Method: `parse(CharSequence text)` with `LocalDate.parse()` or `LocalDateTime.parse()`.
  - Example: `LocalDate.parse("2025-08-11", DateTimeFormatter.ISO_LOCAL_DATE)` returns a `LocalDate`.
- **Exception**: `DateTimeParseException` for invalid formats.

## Best Practices
- Use locale-specific formatters for parsing user input (e.g., `NumberFormat.getNumberInstance(Locale.US)`).
- Validate input strings before parsing to avoid exceptions.
- Handle `ParseException` and `DateTimeParseException` gracefully.
- Use strict patterns in `DecimalFormat` to enforce expected formats.
- Test parsing with edge cases (e.g., invalid formats, empty strings).

## Common Pitfalls
- Not specifying locale, causing parsing failures for locale-specific formats.
- Ignoring `ParseException`, leading to unhandled errors.
- Using incorrect patterns, causing incorrect parsing.
- Not validating input strings, resulting in runtime exceptions.
- Assuming all inputs are valid without checking.

## Practice Task
- **Task**: Parse a currency string and a date string into a `double` and `LocalDate`.
- **Solution Approach**:
  - Use `NumberFormat.getCurrencyInstance()` to parse a currency string.
  - Use `DateTimeFormatter` to parse a date string.
  - Handle parsing exceptions.