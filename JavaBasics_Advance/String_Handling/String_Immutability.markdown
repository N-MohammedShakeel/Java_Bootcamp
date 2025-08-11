# String Immutability

## Overview
In Java, `String` objects are immutable, meaning their content cannot be modified after creation. This design choice enhances thread safety, security, and memory efficiency but has implications for performance in certain scenarios.

- **Purpose**: Ensure predictable and safe string behavior in applications.
- **DSA Relevance**: Involves understanding object allocation (heap vs. String pool), reference management, and memory efficiency, aligning with DSA memory management concepts.

## Why Strings Are Immutable
- **Thread Safety**: Immutable objects are inherently thread-safe, as no thread can modify a `String` used by another.
- **Security**: Prevents unintended changes to critical data (e.g., file paths, database queries).
- **Memory Efficiency**: String literals are stored in the String pool, allowing reuse of identical strings.
- **Hash Code Stability**: Immutability ensures consistent `hashCode()` values, making `String` suitable for keys in `HashMap` or `HashSet`.

## Implications
- **Operations Create New Strings**: Methods like `concat()`, `replace()`, or `substring()` return new `String` objects.
  - Example: `String s = "Hello"; s = s.concat(" World");` creates a new `String` and reassigns `s`.
- **Performance Overhead**: Repeated modifications (e.g., concatenation in a loop) create multiple `String` objects, increasing memory usage and garbage collection.
- **String Pool**: Literals (e.g., `"Hello"`) are interned in the String pool; `new String("Hello")` creates a heap object.

## String Pool
- **Definition**: A special memory area in the Java heap where string literals are stored.
- **Example**:
  ```java
  String s1 = "Hello"; // Stored in String pool
  String s2 = "Hello"; // Reuses same object from pool
  String s3 = new String("Hello"); // New object on heap
  System.out.println(s1 == s2); // true (same pool object)
  System.out.println(s1 == s3); // false (different objects)
  ```
- **Interning**: Use `s3.intern()` to move `s3` to the String pool, enabling reuse.

## Best Practices
- Use string literals for constants to leverage the String pool.
- Avoid `new String("literal")` unless explicitly needed (e.g., to create a distinct object).
- Use `StringBuilder` or `StringBuffer` for frequent modifications to avoid performance issues.
- Compare strings with `equals()`, not `==`, unless checking for reference equality (e.g., pool usage).
- Be aware of memory implications in loops with string concatenation.

## Common Pitfalls
- Using concatenation in loops (e.g., `s += "x";`), leading to quadratic performance.
- Assuming `==` checks content equality instead of reference equality.
- Creating unnecessary `String` objects with `new String()`.
- Not understanding String pool behavior, leading to unexpected `==` results.
- Ignoring immutability when expecting methods to modify the original string.

## Practice Task
- **Task**: Demonstrate String immutability by comparing string literals and heap objects, and show the performance impact of concatenation vs. `StringBuilder`.
- **Solution Approach**:
  - Create strings using literals and `new String()`.
  - Compare using `==` and `equals()`.
  - Concatenate strings in a loop and measure time vs. `StringBuilder`.