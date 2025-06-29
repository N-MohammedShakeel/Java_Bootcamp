# HashSet in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **HashSet** class in Java, part of the `java.util` package, is a hash table-based implementation of the `Set` interface, which extends the `Collection` interface. It uses a `HashMap` internally to store elements, ensuring no duplicates and providing fast average-case performance for lookups, additions, and removals.

- **Purpose**: Provide an unordered collection that prevents duplicates, optimized for fast operations using hashing.
- **Key Features**:
  - Unordered: Elements have no specific order.
  - Uses hashing: Average-case O(1) for `add`, `remove`, and `contains` (O(n) worst-case due to collisions).
  - Allows one null element.
  - Non-synchronized, not thread-safe by default.
  - Initial capacity (default 16) and load factor (default 0.75) can be specified.
  - Use Case: Ideal for scenarios requiring fast lookups and no duplicates (e.g., storing unique user IDs, LeetCode #217 Contains Duplicate).
- **Relevance**: Essential for DSA problems involving uniqueness (e.g., LeetCode #1 Two Sum, #136 Single Number) and for applications needing efficient membership testing.

## 2. Datatypes Supported
`HashSet` is generic (`HashSet<T>`) and can store any reference type. For primitive types, wrapper classes are used due to Java’s generics restrictions. Below are the supported datatypes:

- **Primitive Types (via Wrapper Classes)**:
  - `Byte`: Stores 8-bit integers.
  - `Short`: Stores 16-bit integers.
  - `Integer`: Stores 32-bit integers.
  - `Long`: Stores 64-bit integers.
  - `Float`: Stores 32-bit floating-point numbers.
  - `Double`: Stores 64-bit floating-point numbers.
  - `Character`: Stores single characters.
  - `Boolean`: Stores true/false values.
- **Non-Primitive Types**:
  - `String`: Stores text.
  - `Custom Objects`: Stores user-defined classes (e.g., `HashSet<Person>`).
  - `Other Collections`: Nested collections (e.g., `HashSet<Set<Integer>>`).
  - `Object`: Stores any type (non-generic, legacy approach).

## 3. HashSet Methods
Below is a comprehensive list of `HashSet` methods, categorized by their origin (`Collection` or `Set` interface) and marked as overridden or specific. Note that `HashSet` relies on `HashMap` internally, so most operations delegate to `HashMap` methods.

### 3.1 Methods from Collection Interface (Overridden in HashSet)
- `boolean add(E e)`: Adds an element if not already present (O(1) average, synchronized if wrapped). *Overridden from Collection*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection, ignoring duplicates (O(n) average). *Overridden from Collection*.
- `void clear()`: Removes all elements (O(1) for clearing, O(n) for memory cleanup). *Overridden from Collection*.
- `boolean contains(Object o)`: Checks if the set contains an element (O(1) average). *Overridden from Collection*.
- `boolean containsAll(Collection<?> c)`: Checks if the set contains all elements of another collection (O(n) average). *Overridden from Collection*.
- `boolean equals(Object o)`: Compares the set with another for equality (O(n) average). *Overridden from Collection*.
- `int hashCode()`: Returns the hash code of the set (O(n) average). *Overridden from Collection*.
- `boolean isEmpty()`: Checks if the set is empty (O(1)). *Overridden from Collection*.
- `Iterator<E> iterator()`: Returns an iterator for traversal (O(1)). *Overridden from Collection*.
- `boolean remove(Object o)`: Removes an element if present (O(1) average). *Overridden from Collection*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n) average). *Overridden from Collection*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n) average). *Overridden from Collection*.
- `int size()`: Returns the number of elements (O(1)). *Overridden from Collection*.
- `Object[] toArray()`: Returns an array of all elements (O(n)). *Overridden from Collection*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type (O(n)). *Overridden from Collection*.

### 3.2 Methods from Set Interface (Specific to Set)
- None: The `Set` interface does not add new methods beyond `Collection`, but enforces uniqueness and defines `equals`/`hashCode` behavior.

### 3.3 HashSet-Specific Methods
- `Object clone()`: Returns a shallow copy of the HashSet (O(n)).
- `void forEach(Consumer<? super E> action)`: Performs an action for each element (Java 8+, O(n) average).
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n) average).
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing (Java 8+, O(1)).
- `Stream<E> stream()`: Returns a sequential stream (Java 8+, O(1)).
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1)).

## 4. Example
See `HashSetDemo.java` for a complete example demonstrating `HashSet` with all datatypes and methods.

## 5. Use Cases in DSA
- **Uniqueness Checking**: Detect duplicates (e.g., LeetCode #217 Contains Duplicate, #136 Single Number).
- **Set Operations**: Perform union, intersection, or difference (e.g., LeetCode #349 Intersection of Two Arrays).
- **Hash-Based Problems**: Use for fast lookups (e.g., LeetCode #1 Two Sum).
- **Graph Algorithms**: Track visited nodes (e.g., LeetCode #207 Course Schedule).
- **Data Deduplication**: Remove duplicates from datasets (e.g., unique user IDs).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `HashSet<String>`) for type safety.
- **Ensure Proper Hashing**: Override `equals` and `hashCode` for custom objects to avoid duplicate entries.
- **Prefer HashSet for Uniqueness**: Use over `ArrayList` or `LinkedList` when duplicates must be avoided.
- **Thread Safety**: Use `Collections.synchronizedSet` or `ConcurrentHashMap.newKeySet()` for multithreading.
- **Optimize Capacity**: Specify initial capacity to reduce rehashing (e.g., `new HashSet<>(100)`).
- **Use Modern Methods**: Leverage `forEach`, `removeIf`, and streams for concise code (Java 8+).
- **Iterate Safely**: Use `Iterator` or `removeIf` to avoid `ConcurrentModificationException`.
- **Handle Nulls**: `HashSet` allows one null; check explicitly if needed.

## 7. Common Pitfalls
- **Assuming Order**:
  - `HashSet` is unordered; iteration order may vary.
  - Fix: Use `LinkedHashSet` for insertion-order preservation.
- **Poor Hashing**:
  - Inefficient `hashCode` in custom objects leads to O(n) performance.
  - Fix: Implement efficient `hashCode` and `equals` (e.g., use IDE-generated methods).
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `set.remove` in a for-each loop).
  - Fix: Use `Iterator.remove` or `removeIf`.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedSet` or `ConcurrentHashMap.newKeySet()`.
- **Null Handling**:
  - Null elements causing issues with custom objects.
  - Fix: Handle nulls explicitly in `equals` and `hashCode`.

## 8. Special Cases
- **Custom Objects**:
  - Override `equals` and `hashCode` for correct behavior in `contains`, `remove`, etc.
  - Example: `HashSet<Person>` with equality based on name.
- **Thread Safety**:
  - Use `Collections.synchronizedSet` for basic thread safety or `ConcurrentHashMap.newKeySet()` for better concurrency.
  - Example: Shared set in a multithreaded server.
- **Nested Collections**:
  - Store collections (e.g., `HashSet<Set<Integer>>`) for complex structures.
- **Null Element**:
  - Only one null allowed; subsequent nulls are ignored.
  - Example: `set.add(null)` succeeds once.
- **Capacity and Load Factor**:
  - Adjust initial capacity and load factor to balance performance and memory.
  - Example: `new HashSet<>(100, 0.9f)` for high load factor.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #1 Two Sum, #217 Contains Duplicate, #349 Intersection of Two Arrays).
  - GeeksforGeeks (HashSet tutorials).
  - HackerRank (Set-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Set.
  - Java API Documentation: `java.util.HashSet`, `java.util.Set`.

## 10. Conclusion
`HashSet` is a hash table-based implementation of the `Set` interface, optimized for fast lookups and ensuring no duplicates. Supporting all datatypes via generics and providing efficient methods, it’s a cornerstone for DSA problems requiring uniqueness and membership testing. By adhering to best practices and avoiding pitfalls, developers can leverage `HashSet` effectively in both algorithmic and real-world applications.