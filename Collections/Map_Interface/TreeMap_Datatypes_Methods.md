# TreeMap in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **TreeMap** class in Java, part of the `java.util` package, implements the `NavigableMap` interface (extending `SortedMap` and `Map`) and uses a red-black tree (a self-balancing binary search tree) as its underlying data structure. It maintains keys in sorted order, either by their natural ordering or a custom `Comparator`.

- **Purpose**: Provide a sorted key-value store with logarithmic-time operations, ideal for applications requiring ordered keys.
- **Key Features**:
  - Sorted: Keys are stored in natural order (via `Comparable`) or by a custom `Comparator`.
  - O(log n) for `put`, `get`, and `remove` due to tree operations.
  - Does not allow null keys (throws `NullPointerException`), but allows null values.
  - Non-synchronized, not thread-safe by default.
  - Keys must implement `Comparable` or be provided with a `Comparator`.
  - Use Case: Ideal for maintaining a sorted map (e.g., dictionary sorted by keys, LeetCode #220 Contains Duplicate III).
- **Relevance**: Useful for DSA problems requiring sorted key-value mappings (e.g., LeetCode #220, #729 My Calendar I) and applications like sorted dictionaries or event scheduling.

## 2. Datatypes Supported
`TreeMap` is generic (`TreeMap<K, V>`) and can store any reference type for keys and values, with restrictions on keys. Primitive types use wrapper classes due to Java’s generics restrictions. Below are the supported datatypes:

- **Keys**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects (e.g., `Person`), other comparable types.
  - **Note**: Null keys are not allowed (throws `NullPointerException`). Keys must implement `Comparable` or be provided with a `Comparator`. Custom objects must define consistent `compareTo` or `Comparator` logic.
- **Values**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects, other collections (e.g., `List<Integer>`), `Object` (non-generic).
  - **Note**: Multiple null values are allowed. Values do not need to be comparable.
- **Requirements**: Keys must be comparable (via `Comparable` or `Comparator`). Values have no such restriction.

## 3. TreeMap Methods
`TreeMap` implements methods from `Map`, `SortedMap`, and `NavigableMap`, with optimizations for its red-black tree structure. Below is a comprehensive list of methods, categorized by origin and marked as inherited or specific.

### 3.1 Methods from Map Interface (Inherited)
- `void clear()`: Removes all key-value pairs (O(n)). *Inherited from Map*.
- `boolean containsKey(Object key)`: Checks if the map contains the specified key (O(log n)). *Inherited from Map*.
- `boolean containsValue(Object value)`: Checks if the map contains the specified value (O(n)). *Inherited from Map*.
- `Set<Map.Entry<K, V>> entrySet()`: Returns a set view of key-value entries, sorted by key (O(1)). *Inherited from Map*.
- `boolean equals(Object o)`: Compares the map with another for equality (O(n)). *Inherited from Map*.
- `V get(Object key)`: Returns the value for the specified key or null if absent (O(log n)). *Inherited from Map*.
- `int hashCode()`: Returns the hash code of the map (O(n)). *Inherited from Map*.
- `boolean isEmpty()`: Checks if the map is empty (O(1)). *Inherited from Map*.
- `Set<K> keySet()`: Returns a set view of keys, sorted by key (O(1)). *Inherited from Map*.
- `V put(K key, V value)`: Associates the value with the key, replacing old value if present (O(log n)). *Inherited from Map*.
- `void putAll(Map<? extends K, ? extends V> m)`: Copies all mappings from another map (O(n log n)). *Inherited from Map*.
- `V remove(Object key)`: Removes the mapping for the key (O(log n)). *Inherited from Map*.
- `int size()`: Returns the number of key-value pairs (O(1)). *Inherited from Map*.
- `Collection<V> values()`: Returns a collection view of values (O(1)). *Inherited from Map*.

### 3.2 Methods from SortedMap Interface (Inherited)
- `Comparator<? super K> comparator()`: Returns the comparator used to order keys, or null if natural ordering (O(1)). *Inherited from SortedMap*.
- `K firstKey()`: Returns the first (lowest) key (O(log n)). *Inherited from SortedMap*.
- `SortedMap<K, V> headMap(K toKey)`: Returns a view of the map with keys less than toKey (O(log n)). *Inherited from SortedMap*.
- `K lastKey()`: Returns the last (highest) key (O(log n)). *Inherited from SortedMap*.
- `SortedMap<K, V> subMap(K fromKey, K toKey)`: Returns a view of the map with keys from fromKey (inclusive) to toKey (exclusive) (O(log n)). *Inherited from SortedMap*.
- `SortedMap<K, V> tailMap(K fromKey)`: Returns a view of the map with keys greater than or equal to fromKey (O(log n)). *Inherited from SortedMap*.

### 3.3 Methods from NavigableMap Interface (Inherited)
- `Map.Entry<K, V> ceilingEntry(K key)`: Returns the entry with the least key greater than or equal to key (O(log n)). *Inherited from NavigableMap*.
- `K ceilingKey(K key)`: Returns the least key greater than or equal to key (O(log n)). *Inherited from NavigableMap*.
- `NavigableSet<K> descendingKeySet()`: Returns a reverse-order view of the keys (O(1)). *Inherited from NavigableMap*.
- `NavigableMap<K, V> descendingMap()`: Returns a reverse-order view of the map (O(1)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> firstEntry()`: Returns the first (lowest) key-value entry (O(log n)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> floorEntry(K key)`: Returns the entry with the greatest key less than or equal to key (O(log n)). *Inherited from NavigableMap*.
- `K floorKey(K key)`: Returns the greatest key less than or equal to key (O(log n)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> higherEntry(K key)`: Returns the entry with the least key strictly greater than key (O(log n)). *Inherited from NavigableMap*.
- `K higherKey(K key)`: Returns the least key strictly greater than key (O(log n)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> lastEntry()`: Returns the last (highest) key-value entry (O(log n)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> lowerEntry(K key)`: Returns the entry with the greatest key strictly less than key (O(log n)). *Inherited from NavigableMap*.
- `K lowerKey(K key)`: Returns the greatest key strictly less than key (O(log n)). *Inherited from NavigableMap*.
- `NavigableSet<K> navigableKeySet()`: Returns a navigable set view of the keys (O(1)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> pollFirstEntry()`: Removes and returns the first entry (O(log n)). *Inherited from NavigableMap*.
- `Map.Entry<K, V> pollLastEntry()`: Removes and returns the last entry (O(log n)). *Inherited from NavigableMap*.
- `NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)`: Returns a view of the map with keys in the specified range (O(log n)). *Inherited from NavigableMap*.
- `NavigableMap<K, V> headMap(K toKey, boolean inclusive)`: Returns a view of the map with keys less than (or equal to) toKey (O(log n)). *Inherited from NavigableMap*.
- `NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)`: Returns a view of the map with keys greater than (or equal to) fromKey (O(log n)). *Inherited from NavigableMap*.

### 3.4 Methods from AbstractMap (Overridden or Inherited)
- `V putIfAbsent(K key, V value)`: Puts a value if the key is absent (O(log n), Java 8+). *Inherited from AbstractMap*.
- `boolean remove(Object key, Object value)`: Removes the mapping if the key-value pair matches (O(log n), Java 8+). *Inherited from AbstractMap*.
- `boolean replace(K key, V oldValue, V newValue)`: Replaces the value if the key-value pair matches (O(log n), Java 8+). *Inherited from AbstractMap*.
- `V replace(K key, V value)`: Replaces the value for the key if present (O(log n), Java 8+). *Inherited from AbstractMap*.
- `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value for the key (O(log n), Java 8+). *Inherited from AbstractMap*.
- `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: Computes a value if the key is absent (O(log n), Java 8+). *Inherited from AbstractMap*.
- `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value if the key exists (O(log n), Java 8+). *Inherited from AbstractMap*.
- `V getOrDefault(Object key, V defaultValue)`: Returns the value for the key or a default value if absent (O(log n), Java 8+). *Inherited from AbstractMap*.
- `void forEach(BiConsumer<? super K, ? super V> action)`: Performs an action for each key-value pair (O(n), Java 8+). *Inherited from AbstractMap*.
- `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`: Merges a value with an existing value for the key (O(log n), Java 8+). *Inherited from AbstractMap*.
- `void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`: Replaces all values using a function (O(n), Java 8+). *Inherited from AbstractMap*.

### 3.5 TreeMap-Specific Methods
- `Object clone()`: Returns a shallow copy of the TreeMap, preserving sorted order (O(n)).

## 4. Example
See `TreeMapDemo.java` for a complete example demonstrating `TreeMap` with all datatypes, methods, and a custom `Comparator`.

## 5. Use Cases in DSA
- **Sorted Key-Value Lookups**: Maintain sorted keys for efficient range queries (e.g., LeetCode #220 Contains Duplicate III).
- **Interval Scheduling**: Manage intervals with sorted keys (e.g., LeetCode #729 My Calendar I).
- **Frequency Counting with Order**: Track occurrences with sorted keys (e.g., LeetCode #347 Top K Frequent Elements).
- **Range Queries**: Use `subMap`, `headMap`, or `tailMap` for range-based operations (e.g., LeetCode #732 My Calendar III).
- **Graph Algorithms**: Store weighted edges with sorted keys (e.g., LeetCode #207 Course Schedule).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `TreeMap<String, Integer>`) for type safety.
- **Ensure Key Comparability**: Keys must implement `Comparable` or use a `Comparator` to avoid `ClassCastException`.
- **Handle Nulls Carefully**: Avoid null keys; validate inputs to prevent `NullPointerException`.
- **Thread Safety**: Use `Collections.synchronizedMap` or `ConcurrentSkipListMap` for multithreading.
- **Use Navigable Methods**: Leverage `ceilingKey`, `floorKey`, `subMap`, etc., for efficient range queries.
- **Optimize for Reads**: Ideal for read-heavy applications requiring sorted order.
- **Use Modern Methods**: Leverage `compute`, `merge`, `getOrDefault`, etc., for concise code (Java 8+).
- **Iterate Safely**: Use `entrySet`, `keySet`, `forEach`, or `navigableKeySet` to avoid `ConcurrentModificationException`.

## 7. Common Pitfalls
- **Null Keys**:
  - Attempting to use null keys throws `NullPointerException`.
  - Fix: Validate keys or use `HashMap`/`LinkedHashMap` for null support.
- **Non-Comparable Keys**:
  - Using keys without `Comparable` or `Comparator` throws `ClassCastException`.
  - Fix: Ensure keys implement `Comparable` or provide a `Comparator`.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `map.put` in a for-each loop).
  - Fix: Use `Iterator.remove`, copy keys/values, or use `forEach`.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedMap` or `ConcurrentSkipListMap`.
- **Performance Misuse**:
  - Using `containsValue` (O(n)) for large maps.
  - Fix: Maintain a reverse map for value lookups.
- **Inefficient for Unordered Data**:
  - Using `TreeMap` when sorting is not needed increases overhead (O(log n) vs. O(1) for `HashMap`).
  - Fix: Use `HashMap` or `LinkedHashMap` for unordered or insertion-order needs.

## 8. Special Cases
- **Custom Objects as Keys**:
  - Implement `Comparable` or provide a `Comparator` for custom objects.
  - Example: `TreeMap<Person, String>` with a `Comparator` for sorting by name.
- **Thread Safety**:
  - Use `Collections.synchronizedMap` for basic thread safety or `ConcurrentSkipListMap` for concurrent sorted maps.
  - Example: Shared sorted map in a multi-threaded server.
- **Nested Collections**:
  - Store collections as values (e.g., `TreeMap<String, List<Integer>>`).
  - Example: Group data by sorted keys.
- **Range Queries**:
  - Use `subMap`, `headMap`, or `tailMap` for efficient range-based operations.
  - Example: Query events within a time range (LeetCode #732).
- **Custom Sorting**:
  - Use a `Comparator` for non-natural ordering (e.g., reverse order, custom criteria).
  - Example: Sort keys by length or custom field.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #220 Contains Duplicate III, #729 My Calendar I, #732 My Calendar III).
  - GeeksforGeeks (TreeMap tutorials).
  - HackerRank (Map-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Map.
  - Java API Documentation: `java.util.TreeMap`, `java.util.NavigableMap`, `java.util.SortedMap`.

## 10. Conclusion
`TreeMap` is a red-black tree-based implementation of the `NavigableMap` interface, offering sorted key-value storage with logarithmic-time operations. Supporting a wide range of datatypes (with comparable keys) and providing powerful navigation methods, it’s ideal for DSA problems involving sorted data and applications requiring ordered mappings. By adhering to best practices and avoiding pitfalls, developers can leverage `TreeMap` effectively for both algorithmic and real-world scenarios.