# Locale-Aware Formatting

## Overview
Locale-aware formatting uses `NumberFormat`, `DateTimeFormatter`, and other classes to format numbers, currencies, percentages, and dates according to a specific locale, ensuring culturally appropriate output.

- **Purpose**: Format data for internationalization (e.g., currency symbols, date formats).
- **DSA Relevance**: Involves localization logic and string processing, similar to data transformation in DSA.

## NumberFormat for Locale
- **Methods**:
  - `getNumberInstance(Locale locale)`: General number formatting.
  - `getCurrencyInstance(Locale locale)`: Currency formatting.
  - `getPercentInstance(Locale locale)`: Percentage formatting.
- **Example**:
  ```java
  NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
  String formatted = nf.format(1234.56); // $1,234.56
  ```

## DateTimeFormatter for Locale
- **Methods**:
  - `ofLocalizedDate(FormatStyle style)`: Locale-specific date formatting.
  - `ofLocalizedDateTime(FormatStyle style)`: Date and time formatting.
- **Styles**: `FULL`, `LONG`, `MEDIUM`, `SHORT`.
- **Example**:
  ```java
  DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.UK);
  String formatted = dtf.format(LocalDate.now()); // e.g., "Monday, 11 August 2025"
  ```

## Best Practices
- Specify the target locale explicitly (e.g., `Locale.US`, `Locale.UK`).
- Use `NumberFormat.getCurrencyInstance()` for currency formatting.
- Combine `DateTimeFormatter` with `FormatStyle` for readable date formats.
- Test formatting with multiple locales to ensure correctness.
- Cache formatter instances for performance in repeated operations.

## Common Pitfalls
- Using default locale, causing inconsistent output across systems.
- Not handling locale-specific symbols (e.g., € vs. $).
- Ignoring `IllegalArgumentException` for invalid locales.
- Overcomplicating formats when `FormatStyle` provides standard options.
- Not validating input data before formatting.

## Practice Task
- **Task**: Format a price and date for both US and UK locales using `NumberFormat` and `DateTimeFormatter`.
- **Solution Approach**:
  - Use `NumberFormat.getCurrencyInstance()` for US and UK currency.
  - Use `DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)` for dates.
  - Handle exceptions and invalid inputs.