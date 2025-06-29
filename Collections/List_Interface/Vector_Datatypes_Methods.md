# Vector in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **Vector** class in Java, part of the `java.util` package, is a dynamic array implementation of the `List` interface, similar to `ArrayList`, but synchronized for thread safety. Introduced in JDK 1.0, it is considered a legacy class but still relevant for specific use cases requiring thread-safe operations without external synchronization.

- **Purpose**: Provide a thread-safe, dynamic array for storing elements of any datatype, supporting list operations and legacy iteration methods.
- **Key Features**:
  - Synchronized methods, thread-safe by default (unlike `ArrayList`).
  - Dynamic array, grows by 100% (doubles capacity) when full.
  - Supports `Enumeration` (legacy iterator) alongside `Iterator` and `ListIterator`.
  - Less efficient than `ArrayList` due to synchronization overhead.
  - Use Case: Suitable for legacy code or multithreaded environments where simple thread safety is needed (e.g., shared data in concurrent applications).
- **Relevance**: Useful for understanding legacy Java code and for DSA problems requiring thread-safe lists, though `Collections.synchronizedList(ArrayList)` or `CopyOnWriteArrayList` are often preferred in modern applications.

## 2. Datatypes Supported
`Vector` is generic (`Vector<T>`) since Java 5 and can store any reference type. For primitive types, wrapper classes are used due to Java’s generics restrictions. Below are the supported datatypes:

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
  - `Custom Objects`: Stores user-defined classes (e.g., `Vector<Person>`).
  - `Other Collections`: Nested collections (e.g., `Vector<List<Integer>>`).
  - `Object`: Stores any type (non-generic, legacy approach).

## 3. Vector Methods
Below is a comprehensive list of `Vector` methods, categorized by their origin (`Collection`, `List`, or `Vector`-specific, including legacy methods) and marked as overridden or specific.

### 3.1 Methods from Collection Interface (Overridden in Vector)
- `boolean add(E e)`: Adds an element to the end (O(1) amortized, synchronized). *Overridden from Collection*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection to the end (O(n), synchronized). *Overridden from Collection*.
- `void clear()`: Removes all elements (O(1), synchronized). *Overridden from Collection*.
- `boolean contains(Object o)`: Checks if the list contains an element (O(n), synchronized). *Overridden from Collection*.
- `boolean containsAll(Collection<?> c)`: Checks if the list contains all elements of another collection (O(n), synchronized). *Overridden from Collection*.
- `boolean equals(Object o)`: Compares the list with another for equality (O(n), synchronized). *Overridden from Collection*.
- `int hashCode()`: Returns the hash code of the list (O(n), synchronized). *Overridden from Collection*.
- `boolean isEmpty()`: Checks if the list is empty (O(1), synchronized). *Overridden from Collection*.
- `Iterator<E> iterator()`: Returns an iterator for traversal (O(1), synchronized). *Overridden from Collection*.
- `boolean remove(Object o)`: Removes the first occurrence of an element (O(n), synchronized). *Overridden from Collection*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n), synchronized). *Overridden from Collection*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n), synchronized). *Overridden from Collection*.
- `int size()`: Returns the number of elements (O(1), synchronized). *Overridden from Collection*.
- `Object[] toArray()`: Returns an array of all elements (O(n), synchronized). *Overridden from Collection*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type (O(n), synchronized). *Overridden from Collection*.

### 3.2 Methods from List Interface (Specific to List)
- `void add(int index, E element)`: Adds an element at the specified index (O(n), synchronized). *List-specific*.
- `boolean addAll(int index, Collection<? extends E> c)`: Adds all elements at the specified index (O(n), synchronized). *List-specific*.
- `E get(int index)`: Returns the element at the specified index (O(1), synchronized). *List-specific*.
- `E set(int index, E element)`: Replaces the element at the specified index (O(1), synchronized). *List-specific*.
- `E remove(int index)`: Removes the element at the specified index (O(n), synchronized). *List-specific*.
- `int indexOf(Object o)`: Returns the index of the first occurrence of an element (O(n), synchronized). *List-specific*.
- `int lastIndexOf(Object o)`: Returns the index of the last occurrence of an element (O(n), synchronized). *List-specific*.
- `ListIterator<E> listIterator()`: Returns a bidirectional iterator (O(1), synchronized). *List-specific*.
- `ListIterator<E> listIterator(int index)`: Returns a bidirectional iterator starting at the specified index (O(1), synchronized). *List-specific*.
- `List<E> subList(int fromIndex, int toIndex)`: Returns a view of the list from `fromIndex` to `toIndex` (O(1), synchronized). *List-specific*.

### 3.3 Vector-Specific Methods (Including Legacy Methods)
- `void addElement(E obj)`: Adds an element to the end (O(1) amortized, synchronized, legacy). *Vector-specific*.
- `boolean removeElement(Object obj)`: Removes the first occurrence of an element (O(n), synchronized, legacy). *Vector-specific*.
- `void removeElementAt(int index)`: Removes the element at the specified index (O(n), synchronized, legacy). *Vector-specific*.
- `void insertElementAt(E obj, int index)`: Inserts an element at the specified index (O(n), synchronized, legacy). *Vector-specific*.
- `E elementAt(int index)`: Returns the element at the specified index (O(1), synchronized, legacy). *Vector-specific*.
- `Enumeration<E> elements()`: Returns an Enumeration of elements (O(1), synchronized, legacy). *Vector-specific*.
- `void setElementAt(E obj, int index)`: Replaces the element at the specified index (O(1), synchronized, legacy). *Vector-specific*.
- `int capacity()`: Returns the current capacity (O(1), synchronized). *Vector-specific*.
- `void ensureCapacity(int minCapacity)`: Ensures the capacity is at least the specified value (O(1) or O(n) if resizing, synchronized). *Vector-specific*.
- `void setSize(int newSize)`: Sets the size, truncating or padding with nulls (O(n), synchronized). *Vector-specific*.
- `void trimToSize()`: Trims the capacity to the current size (O(n), synchronized). *Vector-specific*.
- `Object clone()`: Returns a shallow copy of the Vector (O(n), synchronized). *Vector-specific*.
- `void copyInto(Object[] anArray)`: Copies elements into the specified array (O(n), synchronized, legacy). *Vector-specific*.
- `E firstElement()`: Returns the first element (O(1), synchronized, legacy). *Vector-specific*.
- `E lastElement()`: Returns the last element (O(1), synchronized, legacy). *Vector-specific*.
- `void forEach(Consumer<? super E> action)`: Performs an action for each element (Java 8+, O(n), synchronized). *Vector-specific*.
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n), synchronized). *Vector-specific*.
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing (Java 8+, O(1), synchronized). *Vector-specific*.
- `Stream<E> stream()`: Returns a sequential stream (Java 8+, O(1), synchronized). *Vector-specific*.
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1), synchronized). *Vector-specific*.

## 4. Example
See `VectorDemo.java` for a complete example demonstrating `Vector` with all datatypes and methods.

## 5. Use Cases in DSA
- **Thread-Safe Lists**: Use in multithreaded applications without external synchronization (e.g., shared task lists).
- **Legacy Code**: Maintain compatibility with pre-Java 2 code using `Enumeration` or non-generic `Vector`.
- **Array-Based Problems**: Similar to `ArrayList` for random access (e.g., LeetCode #1 Two Sum).
- **Dynamic Arrays**: Store elements with dynamic resizing (e.g., LeetCode #15 3Sum).
- **Synchronized Operations**: Safe for concurrent access in simple multithreaded scenarios.

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `Vector<String>`) for type safety.
- **Avoid for Modern Code**: Prefer `ArrayList` with `Collections.synchronizedList` for better performance.
- **Use for Thread Safety**: Leverage built-in synchronization for simple concurrent applications.
- **Handle Nulls**: `Vector` allows null elements; check when necessary.
- **Prefer List Interface**: Declare as `List` for flexibility (e.g., `List<String> list = new Vector<>()`).
- **Use Modern Methods**: Leverage `forEach`, `removeIf`, and streams for concise code (Java 8+).
- **Iterate Safely**: Use `Iterator`, `Enumeration`, or `removeIf` to avoid `ConcurrentModificationException`.
- **Optimize Capacity**: Use `ensureCapacity` for large vectors, `trimToSize` to minimize memory.

## 7. Common Pitfalls
- **Performance Overhead**:
  - Synchronization slows operations compared to `ArrayList` (O(1) vs. O(1) with lock overhead).
  - Fix: Use `ArrayList` with `Collections.synchronizedList` or `CopyOnWriteArrayList` for better performance.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `vector.remove` in a for-each loop).
  - Fix: Use `Iterator.remove`, `Enumeration`, or `removeIf`.
- **Index Out of Bounds**:
  - Accessing invalid indices (e.g., `vector.get(size())`).
  - Fix: Check `size()` before accessing.
- **Null Handling**:
  - Null elements causing issues with custom objects.
  - Fix: Override `equals` and handle nulls explicitly.
- **Legacy Methods**:
  - Using `addElement`, `elementAt`, etc., in modern code.
  - Fix: Use standard `List` methods (`add`, `get`) for clarity.

## 8. Special Cases
- **Custom Objects**:
  - Override `equals` and `hashCode` for correct behavior in `contains`, `remove`, etc.
  - Example: `Vector<Person>` with equality based on name.
- **Thread Safety**:
  - Built-in synchronization sufficient for simple concurrent access; use `ConcurrentHashMap` or `CopyOnWriteArrayList` for complex scenarios.
  - Example: Shared task queue in multithreaded applications.
- **Nested Collections**:
  - Store collections (e.g., `Vector<List<Integer>>`) for complex structures like adjacency lists.
- **Sublist Views**:
  - `subList` returns a view; modifications affect the original vector.
  - Example: `vector.subList(1, 3).clear()` removes elements from the original.
- **Legacy Enumeration**:
  - Use `elements()` for compatibility with pre-Java 2 code.
  - Example: Iterate over legacy `Vector` in old systems.
- **Capacity Management**:
  - Use `ensureCapacity` for large vectors, `trimToSize` to minimize memory.
  - Example: Optimize memory for fixed-size vectors.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #1 Two Sum, #15 3Sum).
  - GeeksforGeeks (Vector tutorials).
  - HackerRank (List-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics.
  - Java API Documentation: `java.util.Vector`, `java.util.List`.

## 10. Conclusion
`Vector` is a thread-safe, dynamic array implementation of the `List` interface, suitable for legacy code and simple multithreaded applications. While less efficient than `ArrayList` due to synchronization, it supports all datatypes via generics and provides a rich set of methods, including legacy `Enumeration`. By understanding its methods, adhering to best practices, and avoiding pitfalls, developers can effectively use `Vector` in specific scenarios while leveraging modern alternatives for better performance.