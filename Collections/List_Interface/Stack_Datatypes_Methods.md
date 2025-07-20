# Stack in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **Stack** class in Java, part of the `java.util` package, is a legacy class that extends the `Vector` class and implements a Last-In-First-Out (LIFO) data structure. Introduced in JDK 1.0, it provides a thread-safe implementation of a stack, inheriting all methods from `Vector` while adding stack-specific operations like `push`, `pop`, and `peek`. Although considered a legacy class due to its synchronization overhead, it remains relevant for simple thread-safe stack operations and for understanding legacy Java code.

- **Purpose**: Provides a thread-safe LIFO data structure for storing elements of any datatype, suitable for scenarios requiring stack operations in multithreaded environments.
- **Key Features**:
  - Extends `Vector`, inheriting its dynamic array implementation and synchronization.
  - Thread-safe by default due to synchronized methods (unlike `ArrayDeque`, a modern alternative).
  - Grows by 100% (doubles capacity) when full, inherited from `Vector`.
  - Supports `Enumeration` (legacy iterator) alongside `Iterator` and `ListIterator`.
  - Less efficient than `ArrayDeque` due to synchronization overhead.
- **Use Case**: Suitable for legacy code, simple multithreaded applications, or DSA problems requiring LIFO behavior (e.g., expression evaluation, backtracking).
- **Relevance**: Essential for DSA problems involving stacks (e.g., parentheses matching, depth-first search) and for maintaining compatibility with older Java systems.

## 2. Datatypes Supported
`Stack` is generic (`Stack<T>`) since Java 5 and can store any reference type. For primitive types, wrapper classes are used due to Java’s generics restrictions. Below are the supported datatypes:

- **Primitive Types (via Wrapper Classes)**:
  - `Byte`: Stores 8-bit integers (-128 to 127).
  - `Short`: Stores 16-bit integers (-32,768 to 32,767).
  - `Integer`: Stores 32-bit integers.
  - `Long`: Stores 64-bit integers.
  - `Float`: Stores 32-bit floating-point numbers.
  - `Double`: Stores 64-bit floating-point numbers.
  - `Character`: Stores single characters.
  - `Boolean`: Stores true/false values.
- **Non-Primitive Types**:
  - `String`: Stores text.
  - `Custom Objects`: Stores user-defined classes (e.g., `Stack<Person>`).
  - `Other Collections`: Nested collections (e.g., `Stack<List<Integer>>`).
  - `Object`: Stores any type (non-generic, legacy approach).

## 3. Stack Methods
The `Stack` class inherits methods from `Vector`, which implements the `List` and `Collection` interfaces, and adds five stack-specific methods: `push`, `pop`, `peek`, `empty`, and `search`. Below is a comprehensive list of methods, categorized by their origin and marked as inherited, overridden, or stack-specific.

### 3.1 Methods from Collection Interface (Inherited via Vector)
- `boolean add(E e)`: Adds an element to the end (O(1) amortized, synchronized). *Inherited from Vector*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection to the end (O(n), synchronized). *Inherited from Vector*.
- `void clear()`: Removes all elements (O(1), synchronized). *Inherited from Vector*.
- `boolean contains(Object o)`: Checks if the stack contains an element (O(n), synchronized). *Inherited from Vector*.
- `boolean containsAll(Collection<?> c)`: Checks if the stack contains all elements of another collection (O(n), synchronized). *Inherited from Vector*.
- `boolean equals(Object o)`: Compares the stack with another for equality (O(n), synchronized). *Inherited from Vector*.
- `int hashCode()`: Returns the hash code of the stack (O(n), synchronized). *Inherited from Vector*.
- `boolean isEmpty()`: Checks if the stack is empty (O(1), synchronized). *Inherited from Vector*.
- `Iterator<E> iterator()`: Returns an iterator for traversal (O(1), synchronized). *Inherited from Vector*.
- `boolean remove(Object o)`: Removes the first occurrence of an element (O(n), synchronized). *Inherited from Vector*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n), synchronized). *Inherited from Vector*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n), synchronized). *Inherited from Vector*.
- `int size()`: Returns the number of elements (O(1), synchronized). *Inherited from Vector*.
- `Object[] toArray()`: Returns an array of all elements (O(n), synchronized). *Inherited from Vector*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type (O(n), synchronized). *Inherited from Vector*.

### 3.2 Methods from List Interface (Inherited via Vector)
- `void add(int index, E element)`: Adds an element at the specified index (O(n), synchronized). *Inherited from Vector*.
- `boolean addAll(int index, Collection<? extends E> c)`: Adds all elements at the specified index (O(n), synchronized). *Inherited from Vector*.
- `E get(int index)`: Returns the element at the specified index (O(1), synchronized). *Inherited from Vector*.
- `E set(int index, E element)`: Replaces the element at the specified index (O(1), synchronized). *Inherited from Vector*.
- `E remove(int index)`: Removes the element at the specified index (O(n), synchronized). *Inherited from Vector*.
- `int indexOf(Object o)`: Returns the index of the first occurrence of an element (O(n), synchronized). *Inherited from Vector*.
- `int lastIndexOf(Object o)`: Returns the index of the last occurrence of an element (O(n), synchronized). *Inherited from Vector*.
- `ListIterator<E> listIterator()`: Returns a bidirectional iterator (O(1), synchronized). *Inherited from Vector*.
- `ListIterator<E> listIterator(int index)`: Returns a bidirectional iterator starting at the specified index (O(1), synchronized). *Inherited from Vector*.
- `List<E> subList(int fromIndex, int toIndex)`: Returns a view of the stack from `fromIndex` to `toIndex` (O(1), synchronized). *Inherited from Vector*.

### 3.3 Vector-Specific Methods (Inherited)
- `void addElement(E obj)`: Adds an element to the end (O(1) amortized, synchronized, legacy). *Inherited from Vector*.
- `boolean removeElement(Object obj)`: Removes the first occurrence of an element (O(n), synchronized, legacy). *Inherited from Vector*.
- `void removeElementAt(int index)`: Removes the element at the specified index (O(n), synchronized, legacy). *Inherited from Vector*.
- `void insertElementAt(E obj, int index)`: Inserts an element at the specified index (O(n), synchronized, legacy). *Inherited from Vector*.
- `E elementAt(int index)`: Returns the element at the specified index (O(1), synchronized, legacy). *Inherited from Vector*.
- `Enumeration<E> elements()`: Returns an Enumeration of elements (O(1), synchronized, legacy). *Inherited from Vector*.
- `void setElementAt(E obj, int index)`: Replaces the element at the specified index (O(1), synchronized, legacy). *Inherited from Vector*.
- `int capacity()`: Returns the current capacity (O(1), synchronized). *Inherited from Vector*.
- `void ensureCapacity(int minCapacity)`: Ensures the capacity is at least the specified value (O(1) or O(n) if resizing, synchronized). *Inherited from Vector*.
- `void setSize(int newSize)`: Sets the size, truncating or padding with nulls (O(n), synchronized). *Inherited from Vector*.
- `void trimToSize()`: Trims the capacity to the current size (O(n), synchronized). *Inherited from Vector*.
- `Object clone()`: Returns a shallow copy of the Stack (O(n), synchronized). *Inherited from Vector*.
- `void copyInto(Object[] anArray)`: Copies elements into the specified array (O(n), synchronized, legacy). *Inherited from Vector*.
- `E firstElement()`: Returns the first element (O(1), synchronized, legacy). *Inherited from Vector*.
- `E lastElement()`: Returns the last element (O(1), synchronized, legacy). *Inherited from Vector*.
- `void forEach(Consumer<? super E> action)`: Performs an action for each element (Java 8+, O(n), synchronized). *Inherited from Vector*.
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n), synchronized). *Inherited from Vector*.
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing (Java 8+, O(1), synchronized). *Inherited from Vector*.
- `Stream<E> stream()`: Returns a sequential stream (Java 8+, O(1), synchronized). *Inherited from Vector*.
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1), synchronized). *Inherited from Vector*.

### 3.4 Stack-Specific Methods
- `E push(E item)`: Pushes an element onto the stack (adds to the end, O(1) amortized, synchronized). *Stack-specific*.
- `E pop()`: Removes and returns the top element (O(1), synchronized, throws `EmptyStackException` if empty). *Stack-specific*.
- `E peek()`: Returns the top element without removing it (O(1), synchronized, throws `EmptyStackException` if empty). *Stack-specific*.
- `boolean empty()`: Checks if the stack is empty (O(1), synchronized). *Stack-specific*.
- `int search(Object o)`: Returns the 1-based position of an element from the top (O(n), synchronized, returns -1 if not found). *Stack-specific*.

## 4. Use Cases in DSA
- **Parentheses Matching**: Validate balanced parentheses (e.g., LeetCode #20 Valid Parentheses).
- **Expression Evaluation**: Evaluate postfix or infix expressions using a stack (e.g., Reverse Polish Notation).
- **Backtracking Algorithms**: Store states for backtracking (e.g., maze solving, N-Queens).
- **Depth-First Search (DFS)**: Implement iterative DFS using a stack (e.g., LeetCode #200 Number of Islands).
- **Thread-Safe Stacks**: Use in multithreaded applications for shared LIFO data (e.g., task scheduling).
- **Undo Functionality**: Store operations for undo/redo in applications.
- **Legacy Code**: Maintain compatibility with pre-Java 2 code using `Stack` and `Enumeration`.

## 5. Best Practices
- **Use Generics**: Specify types (e.g., `Stack<String>`) for type safety.
- **Prefer ArrayDeque for Modern Code**: Use `ArrayDeque` for non-thread-safe stacks due to better performance.
- **Use for Thread Safety**: Leverage built-in synchronization for simple concurrent applications.
- **Avoid List Operations**: Use stack-specific methods (`push`, `pop`, `peek`) instead of `Vector` methods like `add(0, e)` for clarity.
- **Handle Exceptions**: Catch `EmptyStackException` for `pop` and `peek` operations.
- **Iterate Safely**: Use `Iterator`, `Enumeration`, or `removeIf` to avoid `ConcurrentModificationException`.
- **Optimize Capacity**: Use `ensureCapacity` for large stacks, `trimToSize` to minimize memory.
- **Use Modern Methods**: Leverage `forEach`, `removeIf`, and streams for concise code (Java 8+).

## 6. Common Pitfalls
- **Performance Overhead**:
  - Synchronization slows operations compared to `ArrayDeque` (O(1) with lock overhead).
  - **Fix**: Use `ArrayDeque` for single-threaded applications or `Collections.synchronizedList(new ArrayDeque<>())` for thread safety.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `stack.pop()` in a for-each loop).
  - **Fix**: Use `Iterator.remove`, `Enumeration`, or `removeIf`.
- **Empty Stack Access**:
  - Calling `pop` or `peek` on an empty stack throws `EmptyStackException`.
  - **Fix**: Check `empty()` before calling `pop` or `peek`.
- **Null Handling**:
  - `Stack` allows null elements, which may cause issues with custom objects.
  - **Fix**: Override `equals` and handle nulls explicitly.
- **Using Vector Methods**:
  - Using `Vector` methods (e.g., `add(0, e)`) instead of `push` can confuse stack semantics.
  - **Fix**: Stick to `push`, `pop`, `peek` for LIFO behavior.
- **Legacy Methods**:
  - Using `addElement`, `elementAt`, etc., in modern code.
  - **Fix**: Prefer standard `List` methods or stack-specific methods for clarity.

## 7. Special Cases
- **Custom Objects**:
  - Override `equals` and `hashCode` for correct behavior in `contains`, `remove`, and `search`.
  - **Example**: `Stack<Person>` with equality based on name.
- **Thread Safety**:
  - Built-in synchronization is sufficient for simple concurrent access; use `ConcurrentLinkedDeque` or `ConcurrentLinkedQueue` for complex scenarios.
  - **Example**: Shared task stack in multithreaded applications.
- **Nested Collections**:
  - Store collections (e.g., `Stack<List<Integer>>`) for complex structures like graph adjacency lists.
- **Sublist Views**:
  - `subList` returns a view; modifications affect the original stack (use with caution for LIFO semantics).
  - **Example**: `stack.subList(0, 2).clear()` removes elements from the stack.
- **Legacy Enumeration**:
  - Use `elements()` for compatibility with pre-Java 2 code.
  - **Example**: Iterate over legacy `Stack` in old systems.
- **Capacity Management**:
  - Use `ensureCapacity` for large stacks, `trimToSize` to minimize memory.
  - **Example**: Optimize memory for fixed-size stacks.

## 8. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #20 Valid Parentheses, #155 Min Stack).
  - GeeksforGeeks (Stack tutorials).
  - HackerRank (Stack-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics.
  - Java API Documentation: `java.util.Stack`, `java.util.Vector`, `java.util.List`.

## 9. Conclusion
The `Stack` class in Java is a thread-safe, LIFO data structure that extends `Vector`, inheriting its dynamic array implementation and synchronization. While it supports all datatypes via generics and provides a rich set of methods (including stack-specific `push`, `pop`, and `peek`), its synchronization overhead makes it less efficient than modern alternatives like `ArrayDeque`. It remains useful for legacy code, simple multithreaded applications, and DSA problems requiring LIFO behavior. By understanding its methods, adhering to best practices, and avoiding pitfalls, developers can effectively use `Stack` in appropriate scenarios while leveraging modern alternatives for better performance.