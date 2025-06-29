# LinkedList in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **LinkedList** class in Java, part of the `java.util` package, is a doubly-linked list implementation of both the `List` and `Deque` interfaces, which extend the `Collection` interface. It is ideal for scenarios requiring frequent insertions and deletions or queue/deque operations, but less efficient for random access compared to `ArrayList`.

- **Purpose**: Provide a flexible, doubly-linked list for storing elements of any datatype, supporting both list and queue/deque operations.
- **Key Features**:
  - Efficient insertions/deletions at known positions (O(1) if node is accessible, O(n) to find position).
  - Slow random access (O(n) due to traversal from head/tail).
  - Non-synchronized, not thread-safe by default.
  - Implements `List` and `Deque`, enabling list, queue, stack, and deque operations.
  - Use Case: Ideal for frequent modifications (e.g., task scheduling, LeetCode #206 Reverse Linked List) or queue/deque operations (e.g., LeetCode #20 Valid Parentheses).
- **Relevance**: Essential for DSA problems involving linked structures, queues, or stacks, and for applications requiring dynamic list manipulation.

## 2. Datatypes Supported
`LinkedList` is generic (`LinkedList<T>`) and can store any reference type. For primitive types, wrapper classes are used due to Java’s generics restrictions. Below are the supported datatypes:

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
  - `Custom Objects`: Stores user-defined classes (e.g., `LinkedList<Person>`).
  - `Other Collections`: Nested collections (e.g., `LinkedList<List<Integer>>`).
  - `Object`: Stores any type (non-generic, legacy approach).

## 3. LinkedList Methods
Below is a comprehensive list of `LinkedList` methods, categorized by their origin (`Collection`, `List`, `Deque`, or `LinkedList`-specific) and marked as overridden or specific.

### 3.1 Methods from Collection Interface (Overridden in LinkedList)
- `boolean add(E e)`: Adds an element to the end (O(1)). *Overridden from Collection*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection to the end (O(n)). *Overridden from Collection*.
- `void clear()`: Removes all elements (O(n)). *Overridden from Collection*.
- `boolean contains(Object o)`: Checks if the list contains an element (O(n)). *Overridden from Collection*.
- `boolean containsAll(Collection<?> c)`: Checks if the list contains all elements of another collection (O(n)). *Overridden from Collection*.
- `boolean equals(Object o)`: Compares the list with another for equality (O(n)). *Overridden from Collection*.
- `int hashCode()`: Returns the hash code of the list (O(n)). *Overridden from Collection*.
- `boolean isEmpty()`: Checks if the list is empty (O(1)). *Overridden from Collection*.
- `Iterator<E> iterator()`: Returns an iterator for traversal (O(1)). *Overridden from Collection*.
- `boolean remove(Object o)`: Removes the first occurrence of an element (O(n)). *Overridden from Collection*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n)). *Overridden from Collection*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n)). *Overridden from Collection*.
- `int size()`: Returns the number of elements (O(1)). *Overridden from Collection*.
- `Object[] toArray()`: Returns an array of all elements (O(n)). *Overridden from Collection*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type (O(n)). *Overridden from Collection*.

### 3.2 Methods from List Interface (Specific to List)
- `void add(int index, E element)`: Adds an element at the specified index (O(n)). *List-specific*.
- `boolean addAll(int index, Collection<? extends E> c)`: Adds all elements at the specified index (O(n)). *List-specific*.
- `E get(int index)`: Returns the element at the specified index (O(n)). *List-specific*.
- `E set(int index, E element)`: Replaces the element at the specified index (O(n)). *List-specific*.
- `E remove(int index)`: Removes the element at the specified index (O(n)). *List-specific*.
- `int indexOf(Object o)`: Returns the index of the first occurrence of an element (O(n)). *List-specific*.
- `int lastIndexOf(Object o)`: Returns the index of the last occurrence of an element (O(n)). *List-specific*.
- `ListIterator<E> listIterator()`: Returns a bidirectional iterator (O(1)). *List-specific*.
- `ListIterator<E> listIterator(int index)`: Returns a bidirectional iterator starting at the specified index (O(n)). *List-specific*.
- `List<E> subList(int fromIndex, int toIndex)`: Returns a view of the list from `fromIndex` to `toIndex` (O(1)). *List-specific*.

### 3.3 Methods from Deque Interface (Specific to Deque)
- `void addFirst(E e)`: Adds an element to the front (O(1)). *Deque-specific*.
- `void addLast(E e)`: Adds an element to the end (O(1), equivalent to `add(E)`). *Deque-specific*.
- `boolean offer(E e)`: Offers an element to the end (O(1)). *Deque-specific*.
- `boolean offerFirst(E e)`: Offers an element to the front (O(1)). *Deque-specific*.
- `boolean offerLast(E e)`: Offers an element to the end (O(1)). *Deque-specific*.
- `E removeFirst()`: Removes and returns the first element (O(1)). *Deque-specific*.
- `E removeLast()`: Removes and returns the last element (O(1)). *Deque-specific*.
- `E poll()`: Removes and returns the first element, or null if empty (O(1)). *Deque-specific*.
- `E pollFirst()`: Removes and returns the first element, or null if empty (O(1)). *Deque-specific*.
- `E pollLast()`: Removes and returns the last element, or null if empty (O(1)). *Deque-specific*.
- `E getFirst()`: Returns the first element (O(1)). *Deque-specific*.
- `E getLast()`: Returns the last element (O(1)). *Deque-specific*.
- `E peek()`: Returns the first element without removing, or null if empty (O(1)). *Deque-specific*.
- `E peekFirst()`: Returns the first element without removing, or null if empty (O(1)). *Deque-specific*.
- `E peekLast()`: Returns the last element without removing, or null if empty (O(1)). *Deque-specific*.
- `boolean removeFirstOccurrence(Object o)`: Removes the first occurrence of an element (O(n)). *Deque-specific*.
- `boolean removeLastOccurrence(Object o)`: Removes the last occurrence of an element (O(n)). *Deque-specific*.
- `void push(E e)`: Adds an element to the front (O(1), stack operation). *Deque-specific*.
- `E pop()`: Removes and returns the first element (O(1), stack operation). *Deque-specific*.
- `Iterator<E> descendingIterator()`: Returns an iterator over elements in reverse order (O(1)). *Deque-specific*.

### 3.4 Additional LinkedList-Specific Methods
- `Object clone()`: Returns a shallow copy of the LinkedList (O(n)).
- `void forEach(Consumer<? super E> action)`: Performs an action for each element (Java 8+, O(n)).
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n)).
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing (Java 8+, O(1)).
- `Stream<E> stream()`: Returns a sequential stream (Java 8+, O(1)).
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1)).

## 4. Example
See `LinkedListDemo.java` for a complete example demonstrating `LinkedList` with all datatypes and methods.

## 5. Use Cases in DSA
- **Linked List Problems**: Implement linked list algorithms (e.g., LeetCode #206 Reverse Linked List).
- **Queue/Deque Operations**: Use as a queue or stack (e.g., LeetCode #20 Valid Parentheses, #225 Implement Stack).
- **Sliding Window**: Store elements for dynamic windows (e.g., LeetCode #239 Sliding Window Maximum).
- **Graph Algorithms**: Represent adjacency lists (e.g., LeetCode #207 Course Schedule).
- **Dynamic Programming**: Store intermediate results with frequent modifications (e.g., LeetCode #300 Longest Increasing Subsequence).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `LinkedList<String>`) for type safety.
- **Choose LinkedList for Modifications**: Prefer over `ArrayList` for frequent insertions/deletions (O(1) vs. O(n)).
- **Prefer List/Deque Interface**: Declare as `List` or `Deque` for flexibility (e.g., `List<String> list = new LinkedList<>()`).
- **Avoid Random Access**: Use `ArrayList` for frequent `get`/`set` (O(1) vs. O(n)).
- **Handle Nulls**: `LinkedList` allows null elements; check when necessary.
- **Thread Safety**: Use `Collections.synchronizedList` or `CopyOnWriteArrayList` for multithreading.
- **Use Deque Methods**: Leverage `addFirst`, `pollLast`, etc., for queue/stack operations.
- **Iterate Safely**: Use `Iterator` or `removeIf` to avoid `ConcurrentModificationException`.

## 7. Common Pitfalls
- **Using for Random Access**:
  - Slow `get`/`set` (O(n)) compared to `ArrayList` (O(1)).
  - Fix: Use `ArrayList` for random access needs.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `list.remove` in a for-each loop).
  - Fix: Use `Iterator.remove` or `removeIf`.
- **Index Out of Bounds**:
  - Accessing invalid indices (e.g., `list.get(size())`).
  - Fix: Check `size()` before accessing.
- **Null Handling**:
  - Null elements causing issues with custom objects.
  - Fix: Override `equals` and handle nulls explicitly.
- **Overusing Deque Methods**:
  - Using `push`/`pop` for non-stack scenarios unnecessarily.
  - Fix: Use `ArrayDeque` for dedicated stack/queue operations.

## 8. Special Cases
- **Custom Objects**:
  - Override `equals` and `hashCode` for correct behavior in `contains`, `remove`, etc.
  - Example: `LinkedList<Person>` with equality based on name.
- **Deque Usage**:
  - Use `LinkedList` as a stack (`push`/`pop`) or queue (`offer`/`poll`).
  - Example: Implement a stack for LeetCode #20 Valid Parentheses.
- **Nested Collections**:
  - Store collections (e.g., `LinkedList<List<Integer>>`) for adjacency lists.
- **Sublist Views**:
  - `subList` returns a view; modifications affect the original list.
  - Example: `list.subList(1, 3).clear()` removes elements from the original.
- **Thread Safety**:
  - Use `Collections.synchronizedList` for basic thread safety.
  - Example: Synchronized `LinkedList` for concurrent task queues.
- **Reverse Iteration**:
  - Use `descendingIterator` for reverse traversal.
  - Example: Process elements in reverse order for specific algorithms.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #20 Valid Parentheses, #206 Reverse Linked List, #239 Sliding Window Maximum).
  - GeeksforGeeks (LinkedList tutorials).
  - HackerRank (List and Queue challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Deque.
  - Java API Documentation: `java.util.LinkedList`, `java.util.List`, `java.util.Deque`.

## 10. Conclusion
`LinkedList` is a versatile, doubly-linked list implementation of the `List` and `Deque` interfaces, ideal for frequent insertions/deletions and queue/stack operations. By supporting all datatypes via generics and providing a rich set of methods, it’s a key tool for DSA and real-world applications. Adhering to best practices and avoiding pitfalls ensures efficient and robust usage in algorithmic and dynamic scenarios.