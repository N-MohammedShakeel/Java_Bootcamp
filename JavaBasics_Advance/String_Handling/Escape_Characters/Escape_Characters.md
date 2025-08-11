# Escape Characters

## Overview
Escape characters in Java are special sequences starting with a backslash (`\`) used to represent characters that cannot be easily typed or have special meanings in string literals. They are essential for formatting strings and handling special characters.

- **Purpose**: Include special characters in strings or character literals.
- **DSA Relevance**: Involves string parsing and character manipulation, similar to text processing in DSA.

## Java Escape Characters
- **`\n`**: Newline (ASCII 10, LF).
  - Use: Multi-line output (e.g., logs).
  - Example: `"Hello\nWorld"` → `Hello` (new line) `World`.
- **`\r`**: Carriage return (ASCII 13, CR).
  - Use: Overwrite line (rare, platform-dependent).
  - Example: `"Hello\rWorld"` → `World` (overwrites in some terminals).
- **`\t`**: Horizontal tab (ASCII 9, HT).
  - Use: Align text (e.g., tables).
  - Example: `"Name\tAge"` → `Name    Age`.
- **`\"`**: Double quote (ASCII 34).
  - Use: Include quotes in strings (e.g., JSON).
  - Example: `"He said, \"Hi\""` → `He said, "Hi"`.
- **`\'`**: Single quote (ASCII 39).
  - Use: Character literals (rare in strings).
  - Example: `char c = '\'';` → `'`.
- **`\\`**: Backslash (ASCII 92).
  - Use: File paths, regex.
  - Example: `"C:\\path"` → `C:\path`.
- **`\b`**: Backspace (ASCII 8, BS).
  - Use: Overwrite characters (rare, terminal-dependent).
  - Example: `"Hello\bWorld"` → `HellWorld` (in some terminals).
- **`\f`**: Form feed (ASCII 12, FF).
  - Use: Printer formatting (obsolete).
  - Example: `"Page1\fPage2"` → Varies by terminal.

## Best Practices
- Use `\n` for platform-independent newlines.
- Use `\\` for file paths or regex to avoid syntax errors.
- Test escape character behavior in the target environment (e.g., console, file).
- Combine escape characters for complex formatting (e.g., `\t` and `\n` for tables).
- Use raw strings in regex to simplify backslash handling.

## Common Pitfalls
- Forgetting to escape backslashes (e.g., `\d` instead of `\\d` in regex).
- Assuming consistent behavior of `\r` or `\b` across terminals.
- Using `\f` in modern applications, where it’s often unsupported.
- Not escaping quotes, causing syntax errors.
- Overusing escape characters for simple formatting tasks.

## Practice Task
- **Task**: Create a formatted string using multiple escape characters (e.g., `\n`, `\t`, `\\`, `\"`).
- **Solution Approach**:
  - Build a string with a table-like structure using `\t` and `\n`.
  - Include a file path with `\\` and a quoted string with `\"`.
  - Print the result to demonstrate formatting.