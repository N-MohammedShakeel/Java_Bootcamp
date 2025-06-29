# PriorityQueue in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **PriorityQueue** class in Java, part of the `java.util` package, implements the `Queue` interface (which extends `Collection`) and uses a binary heap (min-heap by default) as its underlying data structure. It orders elements based on their natural ordering or a custom `Comparator`, ensuring the smallest (or highest-priority) element is at the head.

- **Purpose**: Provide a priority-based queue where elements are processed in order of priority, ideal for scheduling and graph algorithms.
- **Key Features**:
  - Orders elements based on natural ordering (e.g., smallest first for numbers) or a custom `Comparator`.
  - O(log n) for `offer`, `poll`, and `remove` operations; O(1) for `peek`.
  - Allows duplicates but does not allow null elements (throws `NullPointerException`).
  - Non-synchronized, not thread-safe by default.
  - Initial capacity can be specified (default: 11); grows dynamically.
  - Use Case: Ideal for priority-based processing (e.g., task scheduling, Dijkstra’s algorithm, LeetCode #215 Kth Largest Element).
- **Relevance**: Essential for DSA problems requiring priority queues (e.g., LeetCode #23 Merge k Sorted Lists, #295 Find Median from Data Stream) and applications needing ordered processing.

## 2. Datatypes Supported
`PriorityQueue` is generic (`PriorityQueue<T>`) and can store any reference type that implements `Comparable` or is supported by a provided `Comparator`. Primitive types use wrapper classes due to generics restrictions. Below are the supported datatypes:

- **Primitive Types (via Wrapper Classes)**:
  - `Byte`: Stores 8-bit integers (Comparable).
  - `Short`: Stores 16-bit integers (Comparable).
  - `Integer`: Stores 32-bit integers (Comparable).
  - `Long`: Stores 64-bit integers (Comparable).
  - `Float`: Stores 32-bit floating-point numbers (Comparable).
  - `Double`: Stores 64-bit floating-point numbers (Comparable).
  - `Character`: Stores single characters (Comparable).
  - `Boolean`: Stores true/false values (Comparable).
- **Non-Primitive Types**:
  - `String`: Stores text (Comparable).
  - `Custom Objects`: Stores user-defined classes implementing `Comparable` or with a `Comparator` (e.g., `PriorityQueue<Person>`).
  - `Other Collections`: Nested collections (e.g., `PriorityQueue<Queue<Integer>>`) if elements are Comparable.
  - `Object`: Non-generic approach (legacy, requires casting and Comparable).
- **Note**: Elements must be mutually comparable (no `ClassCastException`) and cannot be null.

## 3. PriorityQueue Methods
`PriorityQueue` implements methods from `Collection` and `Queue`, with optimizations for its binary heap structure. Below is a comprehensive list of methods, categorized by origin and marked as overridden or specific.

### 3.1 Methods from Collection Interface (Overridden in PriorityQueue)
- `boolean add(E e)`: Adds an element to the heap (like `offer`) (O(log n)). *Overridden from Collection*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection (O(n log n)). *Overridden from Collection*.
- `void clear()`: Removes all elements (O(n)). *Overridden from Collection*.
- `boolean contains(Object o)`: Checks if the queue contains an element (O(n)). *Overridden from Collection*.
- `boolean containsAll(Collection<?> c)`: Checks if the queue contains all elements of another collection (O(n*m)). *Overridden from Collection*.
- `boolean equals(Object o)`: Compares the queue with another for equality (O(n)). *Overridden from Collection*.
- `int hashCode()`: Returns the hash code of the queue (O(n)). *Overridden from Collection*.
- `boolean isEmpty()`: Checks if the queue is empty (O(1)). *Overridden from Collection*.
- `Iterator<E> iterator()`: Returns an iterator (order not guaranteed) (O(1)). *Overridden from Collection*.
- `boolean remove(Object o)`: Removes the first occurrence of an element (O(n)). *Overridden from Collection*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n*m)). *Overridden from Collection*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n*m)). *Overridden from Collection*.
- `int size()`: Returns the number of elements (O(1)). *Overridden from Collection*.
- `Object[] toArray()`: Returns an array of all elements (order not guaranteed) (O(n)). *Overridden from Collection*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type (order not guaranteed) (O(n)). *Overridden from Collection*.

### 3.2 Methods from Queue Interface (Overridden in PriorityQueue)
- `boolean offer(E e)`: Adds an element to the heap (O(log n)). *Overridden from Queue*.
- `E peek()`: Returns the head element without removing it (O(1)). *Overridden from Queue*.
- `E poll()`: Removes and returns the head element or null if empty (O(log n)). *Overridden from Queue*.
- `E element()`: Returns the head element or throws `NoSuchElementException` if empty (O(1)). *Overridden from Queue*.
- `E remove()`: Removes and returns the head element or throws `NoSuchElementException` if empty (O(log n)). *Overridden from Queue*.

### 3.3 PriorityQueue-Specific Methods
- `Comparator<? super E> comparator()`: Returns the comparator used, or null for natural ordering (O(1)).
- `Object clone()`: Returns a shallow copy of the PriorityQueue (O(n)).
- `void forEach(Consumer<? super E> action)`: Performs an action for each element (order not guaranteed) (Java 8+, O(n)).
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n)).
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing (order not guaranteed) (Java 8+, O(1)).
- `Stream<E> stream()`: Returns a sequential stream (order not guaranteed) (Java 8+, O(1)).
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1), order not guaranteed).

## 4. Example
See `PriorityQueueDemo.java` for a complete example demonstrating `PriorityQueue` with all datatypes and methods.

## 5. Use Cases in DSA
- **Priority-Based Processing**: Process elements by priority (e.g., LeetCode #23 Merge k Sorted Lists).
- **Graph Algorithms**: Implement Dijkstra’s or Prim’s algorithm (e.g., LeetCode #743 Network Delay Time).
- **Kth Element Problems**: Find kth largest/smallest (e.g., LeetCode #215 Kth Largest Element).
- **Median Tracking**: Track median in a stream (e.g., LeetCode #295 Find Median from Data Stream).
- **Scheduling**: Manage tasks by priority (e.g., job scheduling).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `PriorityQueue<String>`) for type safety.
- **Ensure Comparability**: Ensure elements implement `Comparable` or provide a `Comparator`.
- **Avoid Nulls**: `PriorityQueue` does not allow null elements; use alternatives like `LinkedList` if nulls are needed.
- **Thread Safety**: Use `Collections.synchronizedCollection` or `ConcurrentLinkedDeque` for multithreading (no direct concurrent priority queue in Java).
- **Optimize Capacity**: Specify initial capacity to reduce resizing (e.g., `new PriorityQueue<>(100)`).
- **Use Modern Methods**: Leverage `forEach`, `removeIf`, and streams for concise code (Java 8+).
- **Iterate Safely**: Use `Iterator` or `removeIf` to avoid `ConcurrentModificationException`.
- **Select Appropriate Methods**: Use `offer`/`poll` for non-throwing operations, `add`/`remove` for throwing operations.

## 7. Common Pitfalls
- **Null Elements**:
  - Adding null throws `NullPointerException`.
  - Fix: Use `LinkedList` for null support.
- **Non-Comparable Elements**:
  - Elements without `Comparable` or a `Comparator` throw `ClassCastException`.
  - Fix: Implement `Comparable` or provide a `Comparator`.
- **Poor Comparator Design**:
  - Inconsistent `Comparator` leads to incorrect ordering or exceptions.
  - Fix: Ensure `Comparator` is consistent with `equals`.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `queue.remove` in a for-each loop).
  - Fix: Use `Iterator.remove` or `removeIf`.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedCollection` or alternative concurrent structures.
- **Performance Misuse**:
  - Using `contains` or `remove(Object)` (O(n)) for large queues.
  - Fix: Use `HashSet` for membership testing if needed.
- **Assuming Sorted Iteration**:
  - Iteration order is not guaranteed to be sorted (heap order).
  - Fix: Use `poll` to retrieve elements in sorted order.

## 8. Special Cases
- **Custom Objects**:
  - Implement `Comparable` or provide a `Comparator` for correct ordering.
  - Example: `PriorityQueue<Person>` with priority by age.
- **Thread Safety**:
  - Use `Collections.synchronizedCollection` for basic thread safety or consider `ConcurrentLinkedDeque` for queue operations.
  - Example: Shared priority queue in a multithreaded server.
- **Nested Collections**:
  - Store collections (e.g., `PriorityQueue<Queue<Integer>>`) if elements are Comparable.
- **Max-Heap**:
  - Use `Collections.reverseOrder()` for max-heap behavior.
  - Example: Find kth largest element.
- **Capacity Management**:
  - Specify initial capacity to minimize resizing.
  - Example: `new PriorityQueue<>(100)` for large datasets.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #23 Merge k Sorted Lists, #215 Kth Largest Element, #295 Find Median from Data Stream).
  - GeeksforGeeks (PriorityQueue tutorials).
  - HackerRank (Queue and heap challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Queue.
  - Java API Documentation: `java.util.PriorityQueue`, `java.util.Queue`.

## 10. Conclusion
`PriorityQueue` is a binary heap-based implementation of the `Queue` interface, ensuring elements are processed in priority order with efficient logarithmic operations. Supporting Comparable datatypes and offering a concise set of methods, it’s ideal for DSA problems and applications requiring priority-based processing. By adhering to best practices and avoiding pitfalls, developers can leverage `PriorityQueue` effectively for both algorithmic and real-world scenarios.