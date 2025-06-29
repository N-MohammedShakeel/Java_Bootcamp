# ArrayDeque in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **ArrayDeque** class in Java, part of the `java.util` package, implements the `Deque` interface (which extends `Queue` and `Collection`) and uses a resizable circular array as its underlying data structure. It provides efficient double-ended queue operations, functioning as both a queue (FIFO) and a stack (LIFO).

- **Purpose**: Provide a versatile, high-performance double-ended queue for operations at both ends, ideal for queue and stack-based applications.
- **Key Features**:
  - Double-ended queue: O(1) for `addFirst`, `addLast`, `pollFirst`, `pollLast`.
  - Faster than `LinkedList` for most operations due to array-based implementation.
  - Allows duplicates but does not allow null elements (throws `NullPointerException`).
  - Non-synchronized, not thread-safe by default.
  - Initial capacity can be specified (default: 16); grows dynamically.
  - Can be used as a queue (FIFO) or stack (LIFO).
  - Use Case: Ideal for queue or stack operations (e.g., undo functionality, breadth-first search, LeetCode #20 Valid Parentheses).
- **Relevance**: Essential for DSA problems involving queues or stacks (e.g., LeetCode #225 Implement Stack using Queues, #239 Sliding Window Maximum) and applications requiring efficient insertions/removals at both ends.

## 2. Datatypes Supported
`ArrayDeque` is generic (`ArrayDeque<T>`) and can store any reference type. For primitive types, wrapper classes are used due to Java’s generics restrictions. Below are the supported datatypes:

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
  - `Custom Objects`: Stores user-defined classes (e.g., `ArrayDeque<Person>`).
  - `Other Collections`: Nested collections (e.g., `ArrayDeque<Deque<Integer>>`).
  - `Object`: Stores any type (non-generic, legacy approach).
- **Note**: Null elements are not allowed (throws `NullPointerException`).

## 3. ArrayDeque Methods
`ArrayDeque` implements methods from `Collection`, `Queue`, and `Deque`, with optimizations for its circular array structure. Below is a comprehensive list of methods, categorized by origin and marked as overridden or specific.

### 3.1 Methods from Collection Interface (Overridden in ArrayDeque)
- `boolean add(E e)`: Adds an element at the end (like `addLast`) (O(1)). *Overridden from Collection*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection at the end (O(n)). *Overridden from Collection*.
- `void clear()`: Removes all elements (O(n)). *Overridden from Collection*.
- `boolean contains(Object o)`: Checks if the deque contains an element (O(n)). *Overridden from Collection*.
- `boolean containsAll(Collection<?> c)`: Checks if the deque contains all elements of another collection (O(n*m)). *Overridden from Collection*.
- `boolean equals(Object o)`: Compares the deque with another for equality (O(n)). *Overridden from Collection*.
- `int hashCode()`: Returns the hash code of the deque (O(n)). *Overridden from Collection*.
- `boolean isEmpty()`: Checks if the deque is empty (O(1)). *Overridden from Collection*.
- `Iterator<E> iterator()`: Returns an iterator in FIFO order (O(1)). *Overridden from Collection*.
- `boolean remove(Object o)`: Removes the first occurrence of an element (O(n)). *Overridden from Collection*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n*m)). *Overridden from Collection*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n*m)). *Overridden from Collection*.
- `int size()`: Returns the number of elements (O(1)). *Overridden from Collection*.
- `Object[] toArray()`: Returns an array of all elements in FIFO order (O(n)). *Overridden from Collection*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type in FIFO order (O(n)). *Overridden from Collection*.

### 3.2 Methods from Queue Interface (Overridden in ArrayDeque)
- `boolean offer(E e)`: Adds an element at the end (like `offerLast`) (O(1)). *Overridden from Queue*.
- `E peek()`: Returns the first element without removing it (like `peekFirst`) (O(1)). *Overridden from Queue*.
- `E poll()`: Removes and returns the first element (like `pollFirst`) (O(1)). *Overridden from Queue*.
- `E element()`: Returns the first element or throws `NoSuchElementException` if empty (like `getFirst`) (O(1)). *Overridden from Queue*.
- `E remove()`: Removes and returns the first element or throws `NoSuchElementException` if empty (like `removeFirst`) (O(1)). *Overridden from Queue*.

### 3.3 Methods from Deque Interface (Overridden in ArrayDeque)
- `void addFirst(E e)`: Adds an element at the front (O(1)). *Overridden from Deque*.
- `void addLast(E e)`: Adds an element at the end (O(1)). *Overridden from Deque*.
- `boolean offerFirst(E e)`: Adds an element at the front (O(1)). *Overridden from Deque*.
- `boolean offerLast(E e)`: Adds an element at the end (O(1)). *Overridden from Deque*.
- `E removeFirst()`: Removes and returns the first element or throws `NoSuchElementException` (O(1)). *Overridden from Deque*.
- `E removeLast()`: Removes and returns the last element or throws `NoSuchElementException` (O(1)). *Overridden from Deque*.
- `E pollFirst()`: Removes and returns the first element or null if empty (O(1)). *Overridden from Deque*.
- `E pollLast()`: Removes and returns the last element or null if empty (O(1)). *Overridden from Deque*.
- `E getFirst()`: Returns the first element or throws `NoSuchElementException` (O(1)). *Overridden from Deque*.
- `E getLast()`: Returns the last element or throws `NoSuchElementException` (O(1)). *Overridden from Deque*.
- `E peekFirst()`: Returns the first element or null if empty (O(1)). *Overridden from Deque*.
- `E peekLast()`: Returns the last element or null if empty (O(1)). *Overridden from Deque*.
- `boolean removeFirstOccurrence(Object o)`: Removes the first occurrence of an element (O(n)). *Overridden from Deque*.
- `boolean removeLastOccurrence(Object o)`: Removes the last occurrence of an element (O(n)). *Overridden from Deque*.
- `void push(E e)`: Adds an element at the front (like `addFirst`) (O(1)). *Overridden from Deque*.
- `E pop()`: Removes and returns the first element or throws `NoSuchElementException` (like `removeFirst`) (O(1)). *Overridden from Deque*.
- `Iterator<E> descendingIterator()`: Returns an iterator in reverse order (O(1)). *Overridden from Deque*.

### 3.4 ArrayDeque-Specific Methods
- `Object clone()`: Returns a shallow copy of the ArrayDeque (O(n)).
- `void forEach(Consumer<? super E> action)`: Performs an action for each element in FIFO order (Java 8+, O(n)).
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n)).
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing in FIFO order (Java 8+, O(1)).
- `Stream<E> stream()`: Returns a sequential stream in FIFO order (Java 8+, O(1)).
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1), order not guaranteed).

## 4. Example
See `ArrayDequeDemo.java` for a complete example demonstrating `ArrayDeque` with all datatypes and methods.

## 5. Use Cases in DSA
- **Queue Operations**: Implement FIFO queues for BFS (e.g., LeetCode #102 Binary Tree Level Order Traversal).
- **Stack Operations**: Implement LIFO stacks (e.g., LeetCode #20 Valid Parentheses).
- **Sliding Window**: Use for sliding window problems (e.g., LeetCode #239 Sliding Window Maximum).
- **Double-Ended Operations**: Track elements at both ends (e.g., LeetCode #146 LRU Cache).
- **Undo Functionality**: Store actions for undo/redo in applications.

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `ArrayDeque<String>`) for type safety.
- **Avoid Nulls**: `ArrayDeque` does not allow null elements; use alternatives like `LinkedList` if nulls are needed.
- **Choose ArrayDeque over LinkedList**: Prefer for most queue/stack operations due to better performance.
- **Thread Safety**: Use `Collections.synchronizedDeque` or `ConcurrentLinkedDeque` for multithreading.
- **Optimize Capacity**: Specify initial capacity to reduce resizing (e.g., `new ArrayDeque<>(100)`).
- **Use Modern Methods**: Leverage `forEach`, `removeIf`, and streams for concise code (Java 8+).
- **Iterate Safely**: Use `Iterator` or `removeIf` to avoid `ConcurrentModificationException`.
- **Select Appropriate Methods**: Use `offer`/`poll` for non-throwing operations, `add`/`remove` for throwing operations.

## 7. Common Pitfalls
- **Null Elements**:
  - Adding null throws `NullPointerException`.
  - Fix: Use `LinkedList` for null support.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `deque.remove` in a for-each loop).
  - Fix: Use `Iterator.remove` or `removeIf`.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedDeque` or `ConcurrentLinkedDeque`.
- **Performance Misuse**:
  - Using `contains` or `remove(Object)` (O(n)) for large deques.
  - Fix: Use `HashSet` for membership testing if needed.
- **Capacity Overflows**:
  - Excessive resizing for large deques.
  - Fix: Set initial capacity appropriately.

## 8. Special Cases
- **Custom Objects**:
  - Store user-defined classes with proper `equals` and `hashCode` for operations like `contains`.
  - Example: `ArrayDeque<Person>` for undo history.
- **Thread Safety**:
  - Use `Collections.synchronizedDeque` for basic thread safety or `ConcurrentLinkedDeque` for better concurrency.
  - Example: Shared deque in a multithreaded server.
- **Nested Collections**:
  - Store collections (e.g., `ArrayDeque<Deque<Integer>>`) for complex structures.
- **Stack vs. Queue**:
  - Use `push`/`pop` for LIFO, `offer`/`poll` for FIFO.
  - Example: `push` for stack-based parsing, `offer` for BFS.
- **Capacity Management**:
  - Specify initial capacity to minimize resizing.
  - Example: `new ArrayDeque<>(100)` for large datasets.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #20 Valid Parentheses, #102 Binary Tree Level Order Traversal, #239 Sliding Window Maximum).
  - GeeksforGeeks (ArrayDeque tutorials).
  - HackerRank (Queue and stack challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Queue, Deque.
  - Java API Documentation: `java.util.ArrayDeque`, `java.util.Deque`, `java.util.Queue`.

## 10. Conclusion
`ArrayDeque` is a high-performance, array-based implementation of the `Deque` interface, offering efficient double-ended operations for queue and stack use cases. Supporting all non-null datatypes via generics and providing a rich set of methods, it’s ideal for DSA problems and applications requiring fast insertions/removals at both ends. By adhering to best practices and avoiding pitfalls, developers can leverage `ArrayDeque` effectively for both algorithmic and real-world scenarios.