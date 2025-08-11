# Regular Expressions (Pattern & Matcher)

## Overview
Regular expressions (regex) in Java, provided by `java.util.regex.Pattern` and `Matcher`, enable pattern matching, searching, and manipulation of strings. They are powerful for tasks like validation, parsing, and text processing.

- **Purpose**: Match, search, and manipulate strings using patterns.
- **DSA Relevance**: Involves pattern matching (similar to string algorithms like KMP), parsing, and iteration, aligning with DSA concepts.

## Pattern & Matcher Classes
- **Pattern**:
  - Compiles a regex into a reusable object.
  - Method: `Pattern.compile(String regex)`.
  - Example: `Pattern p = Pattern.compile("\\d+");` (matches one or more digits).
- **Matcher**:
  - Applies a `Pattern` to a string for matching operations.
  - Methods:
    - `matches()`: Checks if the entire string matches the pattern.
    - `find()`: Finds the next match in the string.
    - `group()`: Returns the matched substring.
    - `replaceAll(String replacement)`: Replaces all matches.
    - `split(String input)`: Splits the string on matches.
- **Example**:
  ```java
  Pattern p = Pattern.compile("\\w+");
  Matcher m = p.matcher("Hello World");
  while (m.find()) {
      System.out.println(m.group()); // Hello, World
  }
  ```

## Common Patterns
- `\d`: Digit (`[0-9]`).
- `\w`: Word character (`[a-zA-Z_0-9]`).
- `[A-Z]`: Uppercase letters.
- `.`: Any character.
- `*`: Zero or more occurrences.
- `+`: One or more occurrences.
- `?`: Zero or one occurrence.
- Example: `\\d+` matches `"123"`, `[A-Z]+` matches `"ABC"`.

## Best Practices
- Compile `Pattern` once and reuse for performance.
- Use raw strings or escape backslashes (e.g., `\\d` in Java strings).
- Validate regex patterns to avoid `PatternSyntaxException`.
- Use `find()` for partial matches, `matches()` for full matches.
- Test regex with edge cases (e.g., empty strings, special characters).

## Common Pitfalls
- Incorrectly escaping backslashes (e.g., `\d` instead of `\\d`).
- Overusing regex for simple string operations, reducing performance.
- Not handling `PatternSyntaxException` for invalid patterns.
- Using `matches()` when `find()` is needed, causing incorrect results.
- Not resetting `Matcher` with `reset()` for reuse.

## Practice Task
- **Task**: Validate an email address and extract all digits from a string using regex.
- **Solution Approach**:
  - Use `Pattern` and `Matcher` to validate an email with a regex (e.g., `[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}`).
  - Extract digits with `\\d+` and `find()`.