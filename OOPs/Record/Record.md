# Records in Java: A Comprehensive Guide

## 1. Introduction
A **record** is a special class in Java, introduced in Java 14 (finalized in Java 16), designed for immutable data carriers. Records simplify the creation of classes that primarily hold data, reducing boilerplate code.

- **Purpose**: Provide a concise syntax for data-centric classes.
- **Package**: Defined in `java.lang` implicitly.

## 2. Key Concepts
- **Declaration**: `record RecordName(Type field1, Type field2) { }`
- **Features**:
  - Automatically generates constructor, getters, `equals()`, `hashCode()`, and `toString()`.
  - Fields are `private final`, ensuring immutability.
  - Can include methods, static fields, or custom constructors.
- **Immutability**: Records are inherently immutable (no setters).

## 3. Example
```java
record Person(String name, int age) {
    // Custom method
    public String greeting() {
        return "Hello, " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alice", 25);
        System.out.println(p); // Output: Person[name=Alice, age=25]
        System.out.println(p.greeting()); // Output: Hello, Alice
    }
}
```

## 4. Use Cases in DSA
- **Data Transfer Objects**: Use records for nodes or edges in graphs.
- **Immutable Keys**: Store records in `HashMap` or `HashSet`.
- **Algorithm Inputs**: Represent immutable configurations or results.

## 5. Best Practices
- Use records for simple, immutable data classes.
- Keep records focused on data (avoid complex logic).
- Use custom constructors for validation.
- Combine with sealed interfaces for type hierarchies.

## 6. Common Pitfalls
- Using records for mutable data (not designed for setters).
- Overcomplicating records with excessive methods.
- Ignoring serialization implications (records are `Serializable`).

## 7. Resources
- **Books**: "Modern Java in Action" by Raoul-Gabriel Urma, "Effective Java" (3rd Ed.).
- **Platforms**: LeetCode (e.g., #146 LRU Cache), GeeksforGeeks (Record tutorials).
- **Docs**: Oracle Java Tutorials: Records.

## 8. Conclusion
Records streamline the creation of immutable data classes in Java, reducing boilerplate and enhancing clarity. They are ideal for DSA applications requiring robust, immutable data representations.