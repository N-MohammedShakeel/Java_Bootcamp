# Objects Utility Class

## Overview
The `Objects` class (`java.util.Objects`) provides static utility methods for working with objects, particularly for null-safe operations and equality checks. Introduced in Java 7, it simplifies common tasks like null checking and comparison.

- **Purpose**: Provide null-safe and convenient operations on objects.
- **DSA Relevance**: Involves null handling and equality checks, used in data structures like hash tables and collections.

## Key Objects Methods
- **`equals(Object a, Object b)`**: Null-safe equality comparison.
  - Example: `Objects.equals(null, "test")` returns `false`.
- **`requireNonNull(T obj)`**: Throws `NullPointerException` if `obj` is null.
  - Example: `Objects.requireNonNull(str)` ensures `str` is not null.
- **`requireNonNull(T obj, String message)`**: Throws `NullPointerException` with a custom message.
  - Example: `Objects.requireNonNull(str, "String cannot be null")`.
- **`hashCode(Object o)`**: Returns the hash code of an object, or 0 if null.
  - Example: `Objects.hashCode(null)` returns `0`.
- **`toString(Object o)`**: Returns the string representation, or `"null"` if null.
  - Example: `Objects.toString(null)` returns `"null"`.

## Key Features
- **Null Safety**: Handles null values gracefully, reducing `NullPointerException` risks.
- **Utility**: Simplifies code for common operations like equality checks and validation.
- **Use Cases**: Input validation, hash table key generation, debugging.

## Best Practices
- Use `Objects.equals()` instead of `a.equals(b)` to avoid `NullPointerException`.
- Use `requireNonNull()` for early validation of method parameters.
- Combine `toString()` with default values for safe string conversion.
- Use `Objects.hash()` for generating hash codes for multiple fields.
- Document custom messages in `requireNonNull()` for better debugging.

## Common Pitfalls
- Not using `Objects.equals()` for null-prone objects, causing `NullPointerException`.
- Ignoring `requireNonNull()` for input validation, leading to null-related bugs.
- Using `hashCode()` directly on potentially null objects.
- Not leveraging `toString()` for safe string conversion.
- Overcomplicating null checks when `Objects` methods suffice.

## Practice Task
- **Task**: Create a method that compares two strings and validates inputs using `Objects` methods.
- **Solution Approach**:
  - Use `Objects.requireNonNull()` to validate inputs.
  - Use `Objects.equals()` for comparison.
  - Handle null cases and print results.