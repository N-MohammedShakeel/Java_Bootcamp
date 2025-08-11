# String Formatting

## Overview
String formatting in Java allows creating formatted strings using `String.format()` and `System.out.printf()`. These methods use format specifiers to control the appearance of data, making output readable and consistent.

- **Purpose**: Produce formatted strings for display or logging.
- **DSA Relevance**: Involves string manipulation and template processing, similar to string interpolation in DSA.

## String.format()
- **Syntax**: `String.format(String format, Object... args)`
- **Common Specifiers**:
  - `%s`: String.
  - `%d`: Integer.
  - `%f`: Floating-point (e.g., `%.2f` for 2 decimal places).
  - `%n`: Platform-specific newline.
- **Example**:
  ```java
  String formatted = String.format("Name: %s, Age: %d", "John", 25);
  // Result: "Name: John, Age: 25"
  ```

## printf()
- **Syntax**: `System.out.printf(String format, Object... args)`
- **Purpose**: Prints formatted output directly to the console.
- **Example**:
  ```java
  System.out.printf("Price: %.2f%n", 19.99); // Price: 19.99
  ```

## Best Practices
- Use `%n` for newlines to ensure platform independence.
- Specify precision for floating-point values (e.g., `%.2f`).
- Use `String.format()` for reusable formatted strings; `printf()` for direct output.
- Validate arguments to avoid `IllegalFormatException`.
- Combine with `Locale` for locale-aware formatting (covered in Topic 7).

## Common Pitfalls
- Using incorrect specifiers (e.g., `%d` for a `String`), causing `IllegalFormatException`.
- Not using `%n` for newlines, leading to platform-specific issues.
- Overusing formatting for simple concatenation, reducing readability.
- Not handling null arguments, causing `NullPointerException`.
- Ignoring format specifier alignment/padding options for complex output.

## Practice Task
- **Task**: Format a string with a name, age, and price, using both `String.format()` and `printf()`.
- **Solution Approach**:
  - Use `String.format()` to create a string with `%s`, `%d`, and `%.2f`.
  - Use `printf()` to print the same data.
  - Handle null inputs gracefully.