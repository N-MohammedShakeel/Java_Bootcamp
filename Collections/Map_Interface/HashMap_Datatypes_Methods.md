# HashMap in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **HashMap** class in Java, part of the `java.util` package, implements the `Map` interface and uses a hash table as its underlying data structure. It stores key-value pairs, providing fast average-case performance for lookups, insertions, and deletions.

- **Purpose**: Provide a high-performance, unordered key-value store for fast data retrieval and updates.
- **Key Features**:
  - Unordered: Key-value pairs are not stored in any specific order.
  - Uses hashing: Average-case O(1) for `put`, `get`, and `remove` operations.
  - Allows one null key and multiple null values.
  - Non-synchronized, not thread-safe by default.
  - Initial capacity and load factor can be specified (default: 16, 0.75).
  - Use Case: Ideal for fast key-value lookups (e.g., caching user data, LeetCode #1 Two Sum).
- **Relevance**: Essential for DSA problems involving key-value mappings (e.g., LeetCode #146 LRU Cache, #560 Subarray Sum Equals K) and applications requiring efficient data retrieval.

## 2. Datatypes Supported
`HashMap` is generic (`HashMap<K, V>`) and can store any reference type for keys and values. Primitive types use wrapper classes due to Java’s generics restrictions. Below are the supported datatypes:

- **Keys**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects (e.g., `Person`), other collections (e.g., `HashMap<Queue<Integer>, V>`), `Object` (non-generic).
  - **Note**: One null key is allowed. Keys must have proper `hashCode` and `equals` methods for correct behavior.
- **Values**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects, other collections, `Object` (non-generic).
  - **Note**: Multiple null values are allowed.
- **Requirements**: Keys must be hashable (implement `hashCode` and `equals` correctly). Non-comparable keys/values are supported (no `Comparable` requirement).

## 3. HashMap Methods
`HashMap` implements methods from the `Map` interface, with optimizations for its hash table structure. Below is a comprehensive list of methods, categorized by origin and marked as overridden or specific.

### 3.1 Methods from Map Interface (Overridden in HashMap)
- `void clear()`: Removes all key-value pairs (O(n)). *Overridden from Map*.
- `boolean containsKey(Object key)`: Checks if the map contains the specified key (O(1) average). *Overridden from Map*.
- `boolean containsValue(Object value)`: Checks if the map contains the specified value (O(n)). *Overridden from Map*.
- `Set<Map.Entry<K, V>> entrySet()`: Returns a set view of key-value entries (O(1)). *Overridden from Map*.
- `boolean equals(Object o)`: Compares the map with another for equality (O(n)). *Overridden from Map*.
- `V get(Object key)`: Returns the value for the specified key or null if absent (O(1) average). *Overridden from Map*.
- `int hashCode()`: Returns the hash code of the map (O(n)). *Overridden from Map*.
- `boolean isEmpty()`: Checks if the map is empty (O(1)). *Overridden from Map*.
- `Set<K> keySet()`: Returns a set view of keys (O(1)). *Overridden from Map*.
- `V put(K key, V value)`: Associates the value with the key, replacing old value if present (O(1) average). *Overridden from Map*.
- `void putAll(Map<? extends K, ? extends V> m)`: Copies all mappings from another map (O(n) average). *Overridden from Map*.
- `V remove(Object key)`: Removes the mapping for the key (O(1) average). *Overridden from Map*.
- `int size()`: Returns the number of key-value pairs (O(1)). *Overridden from Map*.
- `Collection<V> values()`: Returns a collection view of values (O(1)). *Overridden from Map*.

### 3.2 HashMap-Specific Methods
- `Object clone()`: Returns a shallow copy of the HashMap (O(n)).
- `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value for the key (O(1) average, Java 8+).
- `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: Computes a value if the key is absent (O(1) average, Java 8+).
- `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value if the key exists (O(1) average, Java 8+).
- `V getOrDefault(Object key, V defaultValue)`: Returns the value for the key or a default value if absent (O(1) average, Java 8+).
- `void forEach(BiConsumer<? super K, ? super V> action)`: Performs an action for each key-value pair (O(n), Java 8+).
- `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`: Merges a value with an existing value for the key (O(1) average, Java 8+).
- `V putIfAbsent(K key, V value)`: Puts a value if the key is absent (O(1) average, Java 8+).
- `boolean remove(Object key, Object value)`: Removes the mapping if the key-value pair matches (O(1) average, Java 8+).
- `boolean replace(K key, V oldValue, V newValue)`: Replaces the value if the key-value pair matches (O(1) average, Java 8+).
- `V replace(K key, V value)`: Replaces the value for the key if present (O(1) average, Java 8+).
- `void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`: Replaces all values using a function (O(n), Java 8+).

## 4. Example
See `HashMapDemo.java` for a complete example demonstrating `HashMap` with all datatypes and methods.

## 5. Use Cases in DSA
- **Key-Value Lookups**: Fast lookups for mappings (e.g., LeetCode #1 Two Sum).
- **Caching**: Implement caches (e.g., LeetCode #146 LRU Cache).
- **Frequency Counting**: Count occurrences (e.g., LeetCode #560 Subarray Sum Equals K).
- **Graph Algorithms**: Store adjacency lists or weights (e.g., LeetCode #207 Course Schedule).
- **Memoization**: Store intermediate results in dynamic programming (e.g., LeetCode #377 Combination Sum IV).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `HashMap<String, Integer>`) for type safety.
- **Handle Nulls Carefully**: One null key and multiple null values are allowed, but check for null in `get`/`containsValue`.
- **Thread Safety**: Use `Collections.synchronizedMap` or `ConcurrentHashMap` for multithreading.
- **Optimize Capacity**: Specify initial capacity and load factor to reduce resizing (e.g., `new HashMap<>(100, 0.75f)`).
- **Use Modern Methods**: Leverage `compute`, `merge`, `getOrDefault`, etc., for concise code (Java 8+).
- **Iterate Safely**: Use `entrySet`, `keySet`, or `forEach` to avoid `ConcurrentModificationException`.
- **Ensure Key Hashing**: Implement consistent `hashCode` and `equals` for custom key objects.

## 7. Common Pitfalls
- **Null Keys/Values**:
  - Misusing null keys/values in contexts expecting non-null.
  - Fix: Validate inputs or use `getOrDefault`.
- **Poor Key Design**:
  - Inconsistent `hashCode`/`equals` leads to lost mappings.
  - Fix: Ensure `hashCode` is consistent with `equals`.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `map.put` in a for-each loop).
  - Fix: Use `Iterator.remove` or copy keys/values.
- **Thread Safety**:
  - Non-synchronized by default, unsafe for concurrent access.
  - Fix: Use `Collections.synchronizedMap` or `ConcurrentHashMap`.
- **Performance Misuse**:
  - Using `containsValue` (O(n)) for large maps.
  - Fix: Maintain a reverse map for value lookups.
- **High Collision Rate**:
  - Poor hash distribution increases lookup times (O(n) worst case).
  - Fix: Use high-quality `hashCode` implementations.

## 8. Special Cases
- **Custom Objects as Keys**:
  - Implement `hashCode` and `equals` correctly for uniqueness and retrieval.
  - Example: `HashMap<Person, String>` for user profiles.
- **Thread Safety**:
  - Use `Collections.synchronizedMap` for basic thread safety or `ConcurrentHashMap` for better concurrency.
  - Example: Shared map in a multithreaded server.
- **Nested Collections**:
  - Store collections as keys/values (e.g., `HashMap<String, List<Integer>>`).
  - Example: Group data by category.
- **Null Handling**:
  - Use `getOrDefault` or `putIfAbsent` to handle null keys/values safely.
  - Example: Default values for missing keys.
- **Capacity Management**:
  - Specify initial capacity to minimize resizing.
  - Example: `new HashMap<>(100)` for large datasets.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #1 Two Sum, #146 LRU Cache, #560 Subarray Sum Equals K).
  - GeeksforGeeks (HashMap tutorials).
  - HackerRank (Map-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Map.
  - Java API Documentation: `java.util.HashMap`, `java.util.Map`.

## 10. Conclusion
`HashMap` is a hash table-based implementation of the `Map` interface, offering fast average-case performance for key-value operations. Supporting a wide range of datatypes and providing modern Java methods, it’s ideal for DSA problems and applications requiring efficient lookups. By adhering to best practices and avoiding pitfalls, developers can leverage `HashMap` effectively for both algorithmic and real-world scenarios.