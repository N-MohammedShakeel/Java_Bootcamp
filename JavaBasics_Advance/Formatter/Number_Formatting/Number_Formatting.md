# Number Formatting

## Overview
Number formatting in Java uses `DecimalFormat` and `NumberFormat` classes to format numeric values (integers, decimals) for display, supporting patterns, rounding, and locale-specific formatting.

- **Purpose**: Format numbers for readability (e.g., adding commas, controlling decimals).
- **DSA Relevance**: Involves string manipulation and pattern processing, similar to parsing algorithms in DSA.

## DecimalFormat
- **Class**: `java.text.DecimalFormat`
- **Purpose**: Formats numbers using custom patterns.
- **Patterns**:
  - `0`: Digit, required (shows 0 if absent).
  - `#`: Digit, optional (suppresses leading/trailing zeros).
  - `,`: Group separator (e.g., thousands).
  - `.`: Decimal point.
- **Example**:
  ```java
  DecimalFormat df = new DecimalFormat("#,##0.00");
  String formatted = df.format(1234.567); // 1,234.57
  ```

## NumberFormat
- **Class**: `java.text.NumberFormat`
- **Purpose**: Provides locale-sensitive formatting for numbers, currency, and percentages.
- **Methods**:
  - `getNumberInstance(Locale locale)`: General number formatting.
  - `getCurrencyInstance(Locale locale)`: Currency formatting.
  - `getPercentInstance(Locale locale)`: Percentage formatting.
- **Example**:
  ```java
  NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
  String formatted = nf.format(1234.567); // 1,234.567
  ```

## Best Practices
- Use `DecimalFormat` for custom patterns (e.g., fixed decimal places).
- Use `NumberFormat` for locale-aware formatting.
- Set rounding mode if specific behavior is needed (e.g., `df.setRoundingMode(RoundingMode.HALF_UP)`).
- Validate input numbers to avoid `IllegalArgumentException`.
- Reuse `DecimalFormat`/`NumberFormat` instances for performance.

## Common Pitfalls
- Using incorrect patterns in `DecimalFormat`, causing parsing errors.
- Not specifying locale, leading to inconsistent formatting.
- Ignoring rounding behavior, causing unexpected output.
- Creating new formatters for each operation, reducing performance.
- Not handling `null` or invalid inputs.

## Practice Task
- **Task**: Format a list of numbers with commas and two decimal places using `DecimalFormat`.
- **Solution Approach**:
  - Create a `DecimalFormat` with pattern `#,##0.00`.
  - Format an array of doubles.
  - Handle invalid inputs (e.g., NaN, null).