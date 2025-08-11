# StringBuilder vs. StringBuffer

## Overview
`StringBuilder` and `StringBuffer` provide mutable alternatives to the immutable `String` class, optimized for frequent modifications. They are essential for performance-critical applications where strings are built incrementally.

- **Purpose**: Efficiently handle dynamic string construction.
- **DSA Relevance**: Involves dynamic array resizing (similar to ArrayList), string manipulation, and thread safety considerations, aligning with DSA concepts.

## StringBuilder
- **Definition**: A mutable sequence of characters, non-thread-safe, introduced in Java 5.
- **Key Methods**:
  - `append(Object obj)`: Adds data to the end.
  - `insert(int offset, Object obj)`: Inserts data at a specified position.
  - `delete(int start, int end)`: Removes characters.
  - `replace(int start, int end, String str)`: Replaces a substring.
  - `reverse()`: Reverses the sequence.
  - `toString()`: Converts to a `String`.
- **Use Case**: Single-threaded applications (e.g., building JSON strings).
- **Example**:
  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World"); // Hello World
  ```

## StringBuffer
- **Definition**: A mutable sequence of characters, thread-safe via synchronized methods.
- **Key Methods**: Same as `StringBuilder`, but synchronized for thread safety.
- **Use Case**: Multi-threaded applications where multiple threads modify the same string.
- **Example**:
  ```java
  StringBuffer sbf = new StringBuffer("Java");
  sbf.append(" is fun"); // Java is fun
  ```

## Comparison
- **Thread Safety**:
  - `StringBuilder`: Not thread-safe, faster due to no synchronization.
  - `StringBuffer`: Thread-safe, slower due to synchronization overhead.
- **Performance**:
  - `StringBuilder` is preferred for single-threaded applications.
  - `StringBuffer` is used only when thread safety is required.
- **Capacity**:
  - Default capacity: 16 characters.
  - Expands dynamically (new capacity = old capacity * 2 + 2).
  - Specify initial capacity to optimize: `new StringBuilder(100)`.

## Best Practices
- Use `StringBuilder` for single-threaded applications to maximize performance.
- Use `StringBuffer` only in multi-threaded scenarios requiring synchronization.
- Specify initial capacity for large strings to reduce resizing.
- Chain methods for fluency (e.g., `sb.append("x").append("y")`).
- Convert to `String` with `toString()` only when needed.

## Common Pitfalls
- Using `StringBuffer` in single-threaded applications, reducing performance.
- Not setting initial capacity for large strings, causing frequent resizing.
- Using string concatenation instead of `StringBuilder` in loops.
- Accessing `StringBuilder` concurrently without synchronization, causing data corruption.
- Forgetting to call `toString()` when a `String` is required.

## Practice Task
- **Task**: Build a large string (e.g., 1000 numbers) using both `StringBuilder` and `StringBuffer`, comparing performance.
- **Solution Approach**:
  - Use `StringBuilder` and `StringBuffer` to append numbers in a loop.
  - Measure execution time for each.
  - Demonstrate key methods (`append`, `insert`, `reverse`).