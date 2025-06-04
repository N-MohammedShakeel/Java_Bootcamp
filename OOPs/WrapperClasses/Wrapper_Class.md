# Wrapper Classes in Java: A Comprehensive Guide

## 1. Introduction
Wrapper classes in Java provide object representations for the eight primitive types (`byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`). Defined in the `java.lang` package, they enable primitives to be used in contexts requiring objects, such as collections.

- **Purpose**: Bridge primitives and objects, supporting operations like autoboxing and unboxing.
- **Wrapper Classes**:
  - `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.

## 2. Key Concepts
- **Autoboxing**: Automatic conversion of primitive to wrapper (e.g., `int` to `Integer`).
- **Unboxing**: Automatic conversion of wrapper to primitive (e.g., `Integer` to `int`).
- **Methods**:
  - Conversion: `valueOf()`, `parseInt()`, `toString()`.
  - Value access: `intValue()`, `doubleValue()`, etc.
- **Immutability**: Wrapper objects are immutable (cannot change value after creation).
- **Caching**: `Integer` caches values from -128 to 127 for efficiency.

## 3. Use Cases in DSA
- **Collections**: Store primitives in `ArrayList<Integer>`, `HashMap<String, Double>`.
- **Generic Types**: Use wrappers in generic classes (e.g., `Stack<Integer>`).
- **Parsing**: Convert strings to numbers in algorithm inputs.

## 4. Best Practices
- Use autoboxing/unboxing for simplicity but avoid in performance-critical loops.
- Use `valueOf()` over constructors for caching (e.g., `Integer.valueOf(10)`).
- Compare wrapper objects with `equals()`, not `==`.
- Handle `null` in wrapper objects to avoid `NullPointerException`.

## 5. Common Pitfalls
- **NullPointerException**: Unboxing a `null` wrapper object.
- **Performance Overhead**: Autoboxing/unboxing in loops increases overhead.
- **Incorrect Comparison**: Using `==` for wrapper objects above cached range.

## 6. Example
See `WrapperClass.java` for a complete example demonstrating autoboxing, unboxing, and wrapper methods.

## 7. Resources
- **Books**: "Java 8 in Action" by Raoul-Gabriel Urma, "Effective Java" by Joshua Bloch.
- **Platforms**: LeetCode (e.g., #1 Two Sum), GeeksforGeeks (Wrapper Class tutorials).
- **Docs**: Oracle Java Tutorials: Wrapper Classes.

## 8. Conclusion
Wrapper classes enable seamless integration of primitives with Java’s object-oriented features, essential for collections and generic programming in DSA. Understanding autoboxing, unboxing, and caching optimizes code efficiency and correctness.