# TreeSet in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **TreeSet** class in Java, part of the `java.util` package, implements the `Set` interface (via `SortedSet` and `NavigableSet`) and uses a red-black tree (a self-balancing binary search tree) as its underlying data structure. It ensures elements are stored in sorted order, either by natural ordering or a custom `Comparator`.

- **Purpose**: Provide a sorted, unique collection with logarithmic-time operations, ideal for maintaining ordered sets.
- **Key Features**:
  - Sorted: Elements are stored in natural order (via `Comparable`) or by a custom `Comparator`.
  - O(log n) for `add`, `remove`, and `contains` due to tree operations.
  - Does not allow null elements (throws `NullPointerException`).
  - Non-synchronized, not thread-safe by default.
  - Elements must implement `Comparable` or be provided with a `Comparator`.
  - Use Case: Ideal for maintaining sorted sets (e.g., leaderboards, LeetCode #220 Contains Duplicate III).
- **Relevance**: Essential for DSA problems requiring sorted unique elements (e.g., LeetCode #215 Kth Largest Element) and applications needing ordered iteration.

## 2. Datatypes Supported
`TreeSet` is generic (`TreeSet<T>`) and can store any reference type that implements `Comparable` or is supported by a provided `Comparator`. Primitive types use wrapper classes due to generics restrictions. Below are the supported datatypes:

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
  - `Custom Objects`: Stores user-defined classes implementing `Comparable` or with a `Comparator` (e.g., `TreeSet<Person>`).
  - `Other Collections`: Nested collections (e.g., `TreeSet<TreeSet<Integer>>`) if elements are Comparable.
  - `Object`: Non-generic approach (legacy, requires casting and Comparable).
- **Note**: Elements must be mutually comparable (no `ClassCastException`) and cannot be null.

## 3. TreeSet Methods
`TreeSet` inherits methods from `Set`, `SortedSet`, and `NavigableSet`, with implementations optimized for a red-black tree. Below is a comprehensive list of methods, categorized by origin and marked as overridden or specific.

### 3.1 Methods from Collection Interface (Overridden in TreeSet)
- `boolean add(E e)`: Adds an element if not present (O(log n)). *Overridden from Collection*.
- `boolean addAll(Collection<? extends E> c)`: Adds all elements from another collection, ignoring duplicates (O(n log n)). *Overridden from Collection*.
- `void clear()`: Removes all elements (O(n)). *Overridden from Collection*.
- `boolean contains(Object o)`: Checks if the set contains an element (O(log n)). *Overridden from Collection*.
- `boolean containsAll(Collection<?> c)`: Checks if the set contains all elements of another collection (O(n log n)). *Overridden from Collection*.
- `boolean equals(Object o)`: Compares the set with another for equality (O(n)). *Overridden from Collection*.
- `int hashCode()`: Returns the hash code of the set (O(n)). *Overridden from Collection*.
- `boolean isEmpty()`: Checks if the set is empty (O(1)). *Overridden from Collection*.
- `Iterator<E> iterator()`: Returns an iterator in ascending order (O(1)). *Overridden from Collection*.
- `boolean remove(Object o)`: Removes an element if present (O(log n)). *Overridden from Collection*.
- `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection (O(n log n)). *Overridden from Collection*.
- `boolean retainAll(Collection<?> c)`: Retains only elements in the specified collection (O(n log n)). *Overridden from Collection*.
- `int size()`: Returns the number of elements (O(1)). *Overridden from Collection*.
- `Object[] toArray()`: Returns an array of all elements in sorted order (O(n)). *Overridden from Collection*.
- `<T> T[] toArray(T[] a)`: Returns an array of the specified type in sorted order (O(n)). *Overridden from Collection*.

### 3.2 Methods from Set Interface (Specific to Set)
- None: The `Set` interface does not add new methods beyond `Collection`, but enforces uniqueness and defines `equals`/`hashCode` behavior.

### 3.3 Methods from SortedSet Interface (Specific to SortedSet)
- `Comparator<? super E> comparator()`: Returns the comparator used, or null for natural ordering (O(1)).
- `E first()`: Returns the first (lowest) element (O(log n)).
- `E last()`: Returns the last (highest) element (O(log n)).
- `SortedSet<E> subSet(E fromElement, E toElement)`: Returns a view of elements from `fromElement` (inclusive) to `toElement` (exclusive) (O(log n)).
- `SortedSet<E> headSet(E toElement)`: Returns a view of elements less than `toElement` (O(log n)).
- `SortedSet<E> tailSet(E fromElement)`: Returns a view of elements greater than or equal to `fromElement` (O(log n)).

### 3.4 Methods from NavigableSet Interface (Specific to NavigableSet)
- `E lower(E e)`: Returns the greatest element less than `e` (O(log n)).
- `E floor(E e)`: Returns the greatest element less than or equal to `e` (O(log n)).
- `E ceiling(E e)`: Returns the least element greater than or equal to `e` (O(log n)).
- `E higher(E e)`: Returns the least element greater than `e` (O(log n)).
- `E pollFirst()`: Removes and returns the first element (O(log n)).
- `E pollLast()`: Removes and returns the last element (O(log n)).
- `NavigableSet<E> descendingSet()`: Returns a reverse-order view of the set (O(1)).
- `Iterator<E> descendingIterator()`: Returns an iterator in descending order (O(1)).
- `NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`: Returns a view with customizable inclusivity (O(log n)).
- `NavigableSet<E> headSet(E toElement, boolean inclusive)`: Returns a view of elements less than (or equal to) `toElement` (O(log n)).
- `NavigableSet<E> tailSet(E fromElement, boolean inclusive)`: Returns a view of elements greater than (or equal to) `fromElement` (O(log n)).

### 3.5 TreeSet-Specific Methods
- `Object clone()`: Returns a shallow copy of the TreeSet (O(n)).
- `void forEach(Consumer<? super E> action)`: Performs an action for each element in sorted order (Java 8+, O(n)).
- `boolean removeIf(Predicate<? super E> filter)`: Removes elements matching the predicate (Java 8+, O(n)).
- `Spliterator<E> spliterator()`: Returns a spliterator for parallel processing in sorted order (Java 8+, O(1)).
- `Stream<E> stream()`: Returns a sequential stream in sorted order (Java 8+, O(1)).
- `Stream<E> parallelStream()`: Returns a parallel stream (Java 8+, O(1), order not guaranteed).

## 4. Example
See `TreeSetDemo.java` for a complete example demonstrating `TreeSet` with all datatypes and methods.

## 5. Use Cases in DSA
- **Sorted Uniqueness**: Maintain unique elements in sorted order (e.g., LeetCode #215 Kth Largest Element).
- **Range Queries**: Use `subSet`, `headSet`, `tailSet` for range-based problems (e.g., LeetCode #220 Contains Duplicate III).
- **Set Operations**: Perform union, intersection, or difference with sorted output (e.g., LeetCode #349 Intersection of Two Arrays).
- **Priority-Based Processing**: Use `first`, `last`, `pollFirst`, `pollLast` for priority queues (e.g., LeetCode #23 Merge k Sorted Lists).
- **Navigational Queries**: Use `lower`, `floor`, `ceiling`, `higher` for nearest-element problems (e.g., LeetCode #220).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `TreeSet<String>`) for type safety.
- **Ensure Comparability**: Ensure elements implement `Comparable` or provide a `Comparator`.
- **Avoid Nulls**: `TreeSet` does not allow null elements; use `HashSet` or `LinkedHashSet` if nulls are needed.
- **Thread Safety**: Use `Collections.synchronizedSet` or `ConcurrentSkipListSet` for multithreading.
- **Optimize Capacity**: Specify initial capacity to reduce rebalancing (e.g., `new TreeSet<>(comparator)`).
- **Use Modern Methods**: Leverage `forEach`, `removeIf`, and streams for concise code (Java 8+).
- **Iterate Safely**: Use `Iterator` or `removeIf` to avoid `ConcurrentModificationException`.
- **Use Navigable Methods**: Leverage `NavigableSet` methods for efficient range and boundary operations.

## 7. Common Pitfalls
- **Null Elements**:
  - Adding null throws `NullPointerException`.
  - Fix: Use `HashSet` or `LinkedHashSet` for null support.
- **Non-Comparable Elements**:
  - Elements without `Comparable` or a `Comparator` throw `ClassCastException`.
  - Fix: Implement `Comparable` or provide a `Comparator`.
- **Poor Comparator Design**:
  - Inconsistent `Comparator` leads to incorrect ordering or exceptions.
  - Fix: Ensure `Comparator` is consistent with `equals`.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `set.remove` in a for-each loop).
  - Fix: Use `Iterator.remove` or `removeIf`.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedSet` or `ConcurrentSkipListSet`.
- **Performance Misuse**:
  - Using `TreeSet` when sorting is not needed, leading to O(log n) vs. O(1) for `HashSet`.
  - Fix: Use `HashSet` or `LinkedHashSet` for unsorted sets.

## 8. Special Cases
- **Custom Objects**:
  - Implement `Comparable` or provide a `Comparator` for correct ordering and uniqueness.
  - Example: `TreeSet<Person>` with ordering by name.
- **Thread Safety**:
  - Use `Collections.synchronizedSet` for basic thread safety or `ConcurrentSkipListSet` for concurrent sorted sets.
  - Example: Shared sorted set in a multithreaded server.
- **Nested Collections**:
  - Store collections (e.g., `TreeSet<TreeSet<Integer>>`) if elements are Comparable.
- **Range Views**:
  - `subSet`, `headSet`, `tailSet` return views; modifications affect the original set.
  - Example: `set.subSet(10, 20).clear()` removes elements from the original.
- **Navigational Operations**:
  - Use `lower`, `floor`, `ceiling`, `higher` for efficient boundary queries.
  - Example: Find the closest value in a sorted set.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #215 Kth Largest Element, #220 Contains Duplicate III, #349 Intersection of Two Arrays).
  - GeeksforGeeks (TreeSet tutorials).
  - HackerRank (Set-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Set, SortedSet, NavigableSet.
  - Java API Documentation: `java.util.TreeSet`, `java.util.SortedSet`, `java.util.NavigableSet`.

## 10. Conclusion
`TreeSet` is a red-black tree-based implementation of the `Set` interface, ensuring sorted, unique elements with logarithmic-time operations. Supporting Comparable datatypes and offering rich navigational methods, it’s ideal for DSA problems and applications requiring sorted sets. By adhering to best practices and avoiding pitfalls, developers can leverage `TreeSet` effectively for both algorithmic and real-world scenarios.