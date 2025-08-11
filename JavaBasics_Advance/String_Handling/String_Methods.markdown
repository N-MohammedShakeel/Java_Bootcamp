# String Methods

## Overview
The `String` class in Java (`java.lang.String`) represents an immutable sequence of characters and provides a rich set of methods for manipulation, inspection, and transformation. These methods are essential for tasks like parsing, formatting, and searching text in real-world applications.

- **Purpose**: Manipulate and analyze string data efficiently.
- **DSA Relevance**: Involves string manipulation (like array operations), searching (similar to linear search), and substring extraction (like slicing), aligning with core DSA concepts.

## Key String Methods
- **`length()`**: Returns the number of characters (e.g., `"Hello".length()` returns 5).
- **`substring(int beginIndex, int endIndex)`**: Extracts a substring (beginIndex inclusive, endIndex exclusive).
  - Example: `"Hello".substring(1, 4)` returns `"ell"`.
  - Throws `StringIndexOutOfBoundsException` for invalid indices.
- **`indexOf(String str)`**: Returns the index of the first occurrence of `str` (-1 if not found).
  - Example: `"Hello".indexOf("l")` returns 2.
- **`charAt(int index)`**: Returns the character at the specified index.
  - Example: `"Hello".charAt(0)` returns `'H'`.
- **`toUpperCase()` / `toLowerCase()`**: Converts the string to upper/lowercase.
  - Example: `"Hello".toUpperCase()` returns `"HELLO"`.
- **`trim()`**: Removes leading and trailing whitespace.
  - Example: `"  Hello  ".trim()` returns `"Hello"`.
- **`replace(CharSequence target, CharSequence replacement)`**: Replaces all occurrences of `target`.
  - Example: `"Hello".replace("l", "p")` returns `"Heppo"`.
- **`split(String regex)`**: Splits the string into an array based on a regex delimiter.
  - Example: `"a,b,c".split(",")` returns `["a", "b", "c"]`.
- **`equals(Object obj)`**: Compares string content for equality.
  - Example: `"Hello".equals("hello")` returns `false`.
- **`startsWith(String prefix)` / `endsWith(String suffix)`**: Checks if the string starts/ends with a substring.
  - Example: `"Hello".startsWith("He")` returns `true`.

## Immutability
- Strings are immutable; methods return new `String` objects without modifying the original.
- Example: `String s = "Hello"; s.toUpperCase();` does not change `s` (still `"Hello"`).
- Use the return value: `s = s.toUpperCase();` to update `s` to `"HELLO"`.

## Best Practices
- Validate indices for `substring()` and `charAt()` to avoid `StringIndexOutOfBoundsException`.
- Use `equals()` for content comparison, not `==` (which checks reference equality).
- Prefer `trim()` for cleaning user input before processing.
- Use regex carefully in `split()` to avoid unexpected results.
- Chain methods judiciously (e.g., `text.trim().toLowerCase()`) for readability.

## Common Pitfalls
- Using `==` instead of `equals()` for string comparison.
- Not handling `StringIndexOutOfBoundsException` for invalid indices.
- Overusing `split()` with complex regex, leading to performance issues.
- Ignoring case sensitivity in `indexOf()` or `equals()`.
- Not assigning method results back to a variable due to immutability.

## Practice Task
- **Task**: Write a program that processes a user input string to:
  - Remove leading/trailing whitespace.
  - Convert to lowercase.
  - Split into words on spaces.
  - Print each word with its length.
- **Solution Approach**:
  - Use `trim()`, `toLowerCase()`, and `split("\\s+")`.
  - Iterate over the resulting array and use `length()` for each word.
  - Handle empty or null input gracefully.