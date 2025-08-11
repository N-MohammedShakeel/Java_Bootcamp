# Formatter Class Usage

## Overview
The `Formatter` class (`java.util.Formatter`) provides advanced formatting capabilities for strings, files, or other outputs, using a syntax similar to `String.format()`. It is more flexible than `String.format()` for custom output destinations.

- **Purpose**: Format data to various outputs (e.g., strings, files) with fine-grained control.
- **DSA Relevance**: Involves string building and format processing, similar to string templating in DSA.

## Formatter Class
- **Key Methods**:
  - `format(String format, Object... args)`: Formats data to the output.
  - `toString()`: Returns the formatted string (if using `StringBuilder`).
  - `close()`: Closes the formatter and underlying output.
- **Constructors**:
  - `Formatter(StringBuilder sb)`: Outputs to a `StringBuilder`.
  - `Formatter(File file)`: Outputs to a file.
- **Example**:
  ```java
  Formatter formatter = new Formatter(new StringBuilder());
  formatter.format("Name: %s, Age: %d", "John", 25);
  String result = formatter.toString(); // Name: John, Age: 25
  ```

## Best Practices
- Use `Formatter` for complex formatting tasks or non-console output.
- Close `Formatter` instances when writing to files (`try-with-resources`).
- Validate arguments to avoid `IllegalFormatException`.
- Use `StringBuilder` with `Formatter` for in-memory string construction.
- Combine with locale for internationalization.

## Common Pitfalls
- Not closing `Formatter` when writing to files, causing resource leaks.
- Using incorrect format specifiers, leading to `IllegalFormatException`.
- Ignoring locale-specific formatting needs.
- Overusing `Formatter` for simple tasks better suited to `String.format()`.
- Not handling null arguments, causing `NullPointerException`.

## Practice Task
- **Task**: Use `Formatter` to create a formatted string with name, age, and price, writing to a `StringBuilder`.
- **Solution Approach**:
  - Create a `Formatter` with a `StringBuilder`.
  - Use `format()` with `%s`, `%d`, `%.2f` specifiers.
  - Handle exceptions and close the formatter.