# LinkedHashMap in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **LinkedHashMap** class in Java, part of the `java.util` package, extends `HashMap` and implements the `Map` interface. It uses a hash table for fast key-value operations and a doubly-linked list to maintain insertion order (or access order, if configured). This ensures that iteration over entries reflects the order in which they were added or accessed.

- **Purpose**: Provide a key-value store with predictable iteration order, combining the performance of `HashMap` with order maintenance.
- **Key Features**:
  - Maintains insertion order: Entries are returned in the order they were added (default) or accessed (configurable).
  - Uses hashing: Average-case O(1) for `put`, `get`, and `remove` operations.
  - Allows one null key and multiple null values.
  - Non-synchronized, not thread-safe by default.
  - Slightly higher memory overhead than `HashMap` due to the doubly-linked list.
  - Use Case: Ideal when order of insertion or access matters (e.g., LRU cache implementation, LeetCode #146 LRU Cache).
- **Relevance**: Useful for DSA problems requiring ordered key-value mappings (e.g., LeetCode #146, #460 LFU Cache) and applications needing predictable iteration order.

## 2. Datatypes Supported
`LinkedHashMap` is generic (`LinkedHashMap<K, V>`) and can store any reference type for keys and values. Primitive types use wrapper classes due to Java’s generics restrictions. Below are the supported datatypes:

- **Keys**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects (e.g., `Person`), other collections (e.g., `LinkedHashMap<Queue<Integer>, V>`), `Object` (non-generic).
  - **Note**: One null key is allowed. Keys must have proper `hashCode` and `equals` methods for correct behavior.
- **Values**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects, other collections, `Object` (non-generic).
  - **Note**: Multiple null values are allowed.
- **Requirements**: Keys must be hashable (implement `hashCode` and `equals` correctly). Non-comparable keys/values are supported (no `Comparable` requirement).

## 3. LinkedHashMap Methods
`LinkedHashMap` inherits methods from `HashMap` and `Map`, with additional functionality for order maintenance. Below is a comprehensive list of methods, categorized by origin and marked as overridden or specific.

### 3.1 Methods from Map Interface (Inherited via HashMap)
- `void clear()`: Removes all key-value pairs (O(n)). *Inherited from HashMap*.
- `boolean containsKey(Object key)`: Checks if the map contains the specified key (O(1) average). *Inherited from HashMap*.
- `boolean containsValue(Object value)`: Checks if the map contains the specified value (O(n)). *Inherited from HashMap*.
- `Set<Map.Entry<K, V>> entrySet()`: Returns a set view of key-value entries, preserving insertion order (O(1)). *Inherited from HashMap*.
- `boolean equals(Object o)`: Compares the map with another for equality (O(n)). *Inherited from HashMap*.
- `V get(Object key)`: Returns the value for the specified key or null if absent (O(1) average). *Inherited from HashMap*.
- `int hashCode()`: Returns the hash code of the map (O(n)). *Inherited from HashMap*.
- `boolean isEmpty()`: Checks if the map is empty (O(1)). *Inherited from HashMap*.
- `Set<K> keySet()`: Returns a set view of keys, preserving insertion order (O(1)). *Inherited from HashMap*.
- `V put(K key, V value)`: Associates the value with the key, replacing old value if present (O(1) average). *Inherited from HashMap*.
- `void putAll(Map<? extends K, ? extends V> m)`: Copies all mappings from another map (O(n) average). *Inherited from HashMap*.
- `V remove(Object key)`: Removes the mapping for the key (O(1) average). *Inherited from HashMap*.
- `int size()`: Returns the number of key-value pairs (O(1)). *Inherited from HashMap*.
- `Collection<V> values()`: Returns a collection view of values, preserving insertion order (O(1)). *Inherited from HashMap*.

### 3.2 Methods from HashMap (Overridden or Inherited)
- `Object clone()`: Returns a shallow copy of the LinkedHashMap, preserving order (O(n)). *Inherited from HashMap*.
- `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value for the key (O(1) average, Java 8+). *Inherited from HashMap*.
- `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: Computes a value if the key is absent (O(1) average, Java 8+). *Inherited from HashMap*.
- `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value if the key exists (O(1) average, Java 8+). *Inherited from HashMap*.
- `V getOrDefault(Object key, V defaultValue)`: Returns the value for the key or a default value if absent (O(1) average, Java 8+). *Inherited from HashMap*.
- `void forEach(BiConsumer<? super K, ? super V> action)`: Performs an action for each key-value pair (O(n), Java 8+). *Inherited from HashMap*.
- `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`: Merges a value with an existing value for the key (O(1) average, Java 8+). *Inherited from HashMap*.
- `V putIfAbsent(K key, V value)`: Puts a value if the key is absent (O(1) average, Java 8+). *Inherited from HashMap*.
- `boolean remove(Object key, Object value)`: Removes the mapping if the key-value pair matches (O(1) average, Java 8+). *Inherited from HashMap*.
- `boolean replace(K key, V oldValue, V newValue)`: Replaces the value if the key-value pair matches (O(1) average, Java 8+). *Inherited from HashMap*.
- `V replace(K key, V value)`: Replaces the value for the key if present (O(1) average, Java 8+). *Inherited from HashMap*.
- `void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`: Replaces all values using a function (O(n), Java 8+). *Inherited from HashMap*.

### 3.3 LinkedHashMap-Specific Methods
- `protected boolean removeEldestEntry(Map.Entry<K, V> eldest)`: Called after `put` or `putAll` to determine if the eldest entry should be removed (O(1)). *Overridable for custom behavior (e.g., LRU cache)*.

## 4. Example
See `LinkedHashMapDemo.java` for a complete example demonstrating `LinkedHashMap` with all datatypes and methods, including insertion and access-order modes.

## 5. Use Cases in DSA
- **Ordered Key-Value Lookups**: Maintain insertion order for predictable iteration (e.g., LeetCode #146 LRU Cache).
- **LRU Cache Implementation**: Use access-order mode to implement least-recently-used caches (e.g., LeetCode #146).
- **Frequency Counting with Order**: Track occurrences while preserving insertion order (e.g., LeetCode #560 Subarray Sum Equals K).
- **Ordered Data Processing**: Process key-value pairs in insertion order (e.g., event logs).
- **Graph Algorithms**: Store adjacency lists with order preservation (e.g., LeetCode #207 Course Schedule).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `LinkedHashMap<String, Integer>`) for type safety.
- **Handle Nulls Carefully**: One null key and multiple null values are allowed, but check for null in `get`/`containsValue`.
- **Thread Safety**: Use `Collections.synchronizedMap` or `ConcurrentHashMap` for multithreading.
- **Optimize Capacity**: Specify initial capacity and load factor to reduce resizing (e.g., `new LinkedHashMap<>(100, 0.75f)`).
- **Use Modern Methods**: Leverage `compute`, `merge`, `getOrDefault`, etc., for concise code (Java 8+).
- **Iterate Safely**: Use `entrySet`, `keySet`, or `forEach` to avoid `ConcurrentModificationException`.
- **Ensure Key Hashing**: Implement consistent `hashCode` and `equals` for custom key objects.
- **Use Access-Order for Caches**: Configure `LinkedHashMap` with `accessOrder=true` for LRU cache implementations.

## 7. Common Pitfalls
- **Null Keys/Values**:
  - Misusing null keys/values in contexts expecting non-null.
  - Fix: Use `getOrDefault` or validate inputs.
- **Poor Key Design**:
  - Inconsistent `hashCode`/`equals` leads to lost mappings.
  - Fix: Ensure `hashCode` is consistent with `equals`.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `map.put` in a for-each loop).
  - Fix: Use `Iterator.remove` or `forEach`.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedMap` or `ConcurrentHashMap`.
- **Performance Misuse**:
  - Using `containsValue` (O(n)) for large maps.
  - Fix: Maintain a reverse map for value lookups.
- **High Collision Rate**:
  - Poor hash distribution increases lookup times (O(n) worst case).
  - Fix: Use high-quality `hashCode` implementations.
- **Ignoring Order**:
  - Assuming `HashMap` behavior without leveraging insertion/access order.
  - Fix: Use `LinkedHashMap` when order matters.

## 8. Special Cases
- **Custom Objects as Keys**:
  - Implement `hashCode` and `equals` correctly for uniqueness and retrieval.
  - Example: `LinkedHashMap<Person, String>` for ordered user profiles.
- **Thread Safety**:
  - Use `Collections.synchronizedMap` for basic thread safety or `ConcurrentHashMap` for better concurrency.
  - Example: Shared map in a multi-threaded server.
- **Nested Collections**:
  - Store collections as keys/values (e.g., `LinkedHashMap<String, List<Integer>>`).
  - Example: Group data by category with order preservation.
- **Access-Order Mode**:
  - Use `new LinkedHashMap(initialCapacity, loadFactor, true)` for access-order (LRU) behavior.
  - Example: Implement LRU cache (LeetCode #146).
- **Capacity Management**:
  - Specify initial capacity to minimize resizing.
  - Example: `new LinkedHashMap<>(100)` for large datasets.
- **Custom Eviction**:
  - Override `removeEldestEntry` for custom eviction policies (e.g., bounded cache).
  - Example: Fixed-size LRU cache.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #146 LRU Cache, #460 LFU Cache, #560 Subarray Sum Equals K).
  - GeeksforGeeks (LinkedHashMap tutorials).
  - HackerRank (Map-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Map.
  - Java API Documentation: `java.util.LinkedHashMap`, `java.util.Map`.

## 10. Conclusion
`LinkedHashMap` extends `HashMap` to provide a key-value store with predictable iteration order, using a hash table and doubly-linked list. Supporting a wide range of datatypes and offering fast operations with order maintenance, it’s ideal for DSA problems like LRU caches and applications requiring ordered mappings. By adhering to best practices and avoiding pitfalls, developers can leverage `LinkedHashMap` effectively for both algorithmic and real-world scenarios.