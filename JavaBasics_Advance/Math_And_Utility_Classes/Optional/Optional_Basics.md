# Optional Basics (Null Safety)

## Overview
The `Optional` class (`java.util.Optional`), introduced in Java 8, provides a container for values that may or may not be present, reducing the risk of `NullPointerException` and improving code clarity.

- **Purpose**: Handle null values safely and express absence of a value explicitly.
- **DSA Relevance**: Involves null handling, used in data structures like trees and graphs where values may be absent.

## Key Optional Methods
- **`of(T value)`**: Creates an `Optional` with a non-null value.
  - Example: `Optional.of("Hello")`.
  - Throws `NullPointerException` if `value` is null.
- **`ofNullable(T value)`**: Creates an `Optional` that may be empty if `value` is null.
  - Example: `Optional.ofNullable(null)` returns an empty `Optional`.
- **`empty()`**: Returns an empty `Optional`.
  - Example: `Optional.empty()`.
- **`isPresent()`**: Returns `true` if a value is present.
  - Example: `Optional.of("Hello").isPresent()` returns `true`.
- **`orElse(T other)`**: Returns the value if present, else `other`.
  - Example: `Optional.ofNullable(null).orElse("Default")` returns `"Default"`.
- **`ifPresent(Consumer<T> consumer)`**: Executes an action if a value is present.
  - Example: `Optional.of("Hello").ifPresent(System.out::println)`.

## Key Features
- **Null Safety**: Encourages explicit handling of absent values.
- **Functional Style**: Supports methods like `map()`, `filter()`, and `orElseGet()` for functional programming.
- **Use Cases**: Method return types, optional fields in data structures, API responses.

## Best Practices
- Use `Optional` for return types to indicate possible absence of a value.
- Prefer `ofNullable()` over `of()` unless the value is guaranteed non-null.
- Use `orElse()` or `orElseGet()` for default values instead of `get()`.
- Avoid overusing `Optional` for fields or parameters; use primarily for return types.
- Chain `Optional` methods (e.g., `map()`, `filter()`) for concise code.

## Common Pitfalls
- Using `get()` without `isPresent()`, risking `NoSuchElementException`.
- Wrapping already non-null values in `Optional.of()`, adding unnecessary overhead.
- Using `Optional` as a field or parameter, complicating code.
- Not leveraging functional methods like `map()` or `orElseGet()`.
- Treating `Optional` as a replacement for all null checks.

## Practice Task
- **Task**: Create a method that processes a potentially null string, returning its uppercase version or a default value using `Optional`.
- **Solution Approach**:
  - Use `Optional.ofNullable()` to wrap the input string.
  - Use `map()` to transform to uppercase.
  - Use `orElse()` to provide a default value.