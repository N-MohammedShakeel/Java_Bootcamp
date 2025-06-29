# Hashtable in Java: Comprehensive Guide with Datatypes and Methods

## 1. Introduction
The **Hashtable** class in Java, part of the `java.util` package, implements the `Map` interface and uses a hash table as its underlying data structure. It is a legacy class (introduced in JDK 1.0) and is synchronized, making it thread-safe by default but less efficient than `HashMap` or `ConcurrentHashMap` due to synchronization overhead.

- **Purpose**: Provide a thread-safe, unordered key-value store for legacy applications or scenarios requiring basic thread safety.
- **Key Features**:
  - Synchronized: Thread-safe by default (all methods are synchronized).
  - Does not allow null keys or null values (throws `NullPointerException`).
  - Legacy class, less efficient than `HashMap` due to synchronization overhead.
  - Initial capacity and load factor can be specified (default: 11, 0.75).
  - Use Case: Suitable for legacy code or when thread-safety is needed without using `ConcurrentHashMap` (e.g., multi-threaded legacy systems).
- **Relevance**: Used in legacy systems or DSA problems requiring thread-safe key-value mappings (e.g., LeetCode #146 LRU Cache with thread safety). Modern applications prefer `ConcurrentHashMap` for better performance.

## 2. Datatypes Supported
`Hashtable` is generic (`Hashtable<K, V>`) and can store any reference type for keys and values, provided they are non-null. Primitive types use wrapper classes due to Java’s generics restrictions. Below are the supported datatypes:

- **Keys**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects (e.g., `Person`), other collections (e.g., `Hashtable<Queue<Integer>, V>`), `Object` (non-generic, legacy).
  - **Note**: Null keys are not allowed (throws `NullPointerException`). Keys must have proper `hashCode` and `equals` methods.
- **Values**:
  - **Primitive Types (via Wrapper Classes)**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
  - **Non-Primitive Types**: `String`, custom objects, other collections, `Object` (non-generic, legacy).
  - **Note**: Null values are not allowed (throws `NullPointerException`).
- **Requirements**: Keys must be hashable (implement `hashCode` and `equals` correctly). Non-comparable keys/values are supported (no `Comparable` requirement).

## 3. Hashtable Methods
`Hashtable` implements methods from the `Map` interface, with additional legacy methods and synchronization. Below is a comprehensive list of methods, categorized by origin and marked as overridden or specific.

### 3.1 Methods from Map Interface (Overridden in Hashtable)
- `void clear()`: Removes all key-value pairs (O(n), synchronized). *Overridden from Map*.
- `boolean containsKey(Object key)`: Checks if the map contains the specified key (O(1) average, synchronized). *Overridden from Map*.
- `boolean containsValue(Object value)`: Checks if the map contains the specified value (O(n), synchronized). *Overridden from Map*.
- `Set<Map.Entry<K, V>> entrySet()`: Returns a set view of key-value entries (O(1), synchronized view). *Overridden from Map*.
- `boolean equals(Object o)`: Compares the map with another for equality (O(n), synchronized). *Overridden from Map*.
- `V get(Object key)`: Returns the value for the specified key or null if absent (O(1) average, synchronized). *Overridden from Map*.
- `int hashCode()`: Returns the hash code of the map (O(n), synchronized). *Overridden from Map*.
- `boolean isEmpty()`: Checks if the map is empty (O(1), synchronized). *Overridden from Map*.
- `Set<K> keySet()`: Returns a set view of keys (O(1), synchronized view). *Overridden from Map*.
- `V put(K key, V value)`: Associates the value with the key, replacing old value if present (O(1) average, synchronized). *Overridden from Map*.
- `void putAll(Map<? extends K, ? extends V> m)`: Copies all mappings from another map (O(n) average, synchronized). *Overridden from Map*.
- `V remove(Object key)`: Removes the mapping for the key (O(1) average, synchronized). *Overridden from Map*.
- `int size()`: Returns the number of key-value pairs (O(1), synchronized). *Overridden from Map*.
- `Collection<V> values()`: Returns a collection view of values (O(1), synchronized view). *Overridden from Map*.

### 3.2 Hashtable-Specific Methods
- `Object clone()`: Returns a shallow copy of the Hashtable (O(n), synchronized).
- `boolean contains(Object value)`: Legacy method, equivalent to `containsValue` (O(n), synchronized). *Deprecated in favor of containsValue*.
- `Enumeration<K> keys()`: Returns an enumeration of keys (O(1), synchronized, legacy).
- `Enumeration<V> elements()`: Returns an enumeration of values (O(1), synchronized, legacy).
- `void forEach(BiConsumer<? super K, ? super V> action)`: Performs an action for each key-value pair (O(n), synchronized, Java 8+).
- `V getOrDefault(Object key, V defaultValue)`: Returns the value for the key or a default value if absent (O(1) average, synchronized, Java 8+).
- `V putIfAbsent(K key, V value)`: Puts a value if the key is absent (O(1) average, synchronized, Java 8+).
- `boolean remove(Object key, Object value)`: Removes the mapping if the key-value pair matches (O(1) average, synchronized, Java 8+).
- `boolean replace(K key, V oldValue, V newValue)`: Replaces the value if the key-value pair matches (O(1) average, synchronized, Java 8+).
- `V replace(K key, V value)`: Replaces the value for the key if present (O(1) average, synchronized, Java 8+).
- `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value for the key (O(1) average, synchronized, Java 8+).
- `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: Computes a value if the key is absent (O(1) average, synchronized, Java 8+).
- `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new value if the key exists (O(1) average, synchronized, Java 8+).
- `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`: Merges a value with an existing value for the key (O(1) average, synchronized, Java 8+).
- `void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`: Replaces all values using a function (O(n), synchronized, Java 8+).

## 4. Example
See `HashtableDemo.java` for a complete example demonstrating `Hashtable` with all datatypes and methods.

## 5. Use Cases in DSA
- **Thread-Safe Key-Value Lookups**: Safe key-value storage in legacy multi-threaded applications.
- **Caching**: Implement thread-safe caches (e.g., LeetCode #146 LRU Cache with synchronization).
- **Frequency Counting**: Count occurrences in multi-threaded environments (e.g., LeetCode #560 Subarray Sum Equals K).
- **Legacy Code**: Maintain compatibility with older Java systems using `Hashtable`.
- **Graph Algorithms**: Store adjacency lists or weights in thread-safe contexts (e.g., LeetCode #207 Course Schedule).

## 6. Best Practices
- **Use Generics**: Specify types (e.g., `Hashtable<String, Integer>`) for type safety (Java 5+).
- **Avoid Nulls**: Do not use null keys or values to prevent `NullPointerException`.
- **Prefer ConcurrentHashMap**: Use `ConcurrentHashMap` for modern thread-safe applications due to better performance.
- **Optimize Capacity**: Specify initial capacity and load factor to reduce resizing (e.g., `new Hashtable<>(100, 0.75f)`).
- **Use Modern Methods**: Leverage `compute`, `merge`, `getOrDefault`, etc., for concise code (Java 8+).
- **Iterate Safely**: Use `entrySet`, `keySet`, `forEach`, or `Enumeration` to avoid `ConcurrentModificationException`.
- **Ensure Key Hashing**: Implement consistent `hashCode` and `equals` for custom key objects.

## 7. Common Pitfalls
- **Null Keys/Values**:
  - Attempting to use null keys/values throws `NullPointerException`.
  - Fix: Validate inputs or use `HashMap` for null support.
- **Poor Key Design**:
  - Inconsistent `hashCode`/`equals` leads to lost mappings.
  - Fix: Ensure `hashCode` is consistent with `equals`.
- **Concurrent Modification**:
  - Modifying during iteration (e.g., `map.put` in a for-each loop).
  - Fix: Use `Iterator.remove`, copy keys/values, or use `forEach`.
- **Performance Overhead**:
  - Synchronization on all methods reduces performance in single-threaded or low-contention scenarios.
  - Fix: Use `HashMap` or `ConcurrentHashMap` for better performance.
- **High Collision Rate**:
  - Poor hash distribution increases lookup times (O(n) worst case).
  - Fix: Use high-quality `hashCode` implementations.
- **Legacy Methods**:
  - Using `contains`, `keys`, or `elements` instead of modern equivalents.
  - Fix: Prefer `containsValue`, `keySet`, and `values` for clarity.

## 8. Special Cases
- **Custom Objects as Keys**:
  - Implement `hashCode` and `equals` correctly for uniqueness and retrieval.
  - Example: `Hashtable<Person, String>` for user profiles in legacy systems.
- **Thread Safety**:
  - Synchronization ensures thread safety but may cause contention in high-concurrency scenarios.
  - Example: Shared map in a multi-threaded server (consider `ConcurrentHashMap` for better scalability).
- **Nested Collections**:
  - Store collections as keys/values (e.g., `Hashtable<String, List<Integer>>`).
  - Example: Group data by category in a thread-safe manner.
- **Legacy Integration**:
  - Use `Enumeration` for compatibility with pre-Java 1.2 code.
  - Example: Interfacing with older APIs.
- **Capacity Management**:
  - Specify initial capacity to minimize resizing.
  - Example: `new Hashtable<>(100)` for large datasets.

## 9. Resources
- **Books**:
  - "Effective Java" by Joshua Bloch (Items 11–13, 18–20).
  - "Java Generics and Collections" by Maurice Naftalin and Philip Wadler.
  - "Java: The Complete Reference" by Herbert Schildt.
- **Platforms**:
  - LeetCode (e.g., #146 LRU Cache, #560 Subarray Sum Equals K, #207 Course Schedule).
  - GeeksforGeeks (Hashtable tutorials).
  - HackerRank (Map-based challenges).
- **Docs**:
  - Oracle Java Tutorials: Collections, Generics, Map.
  - Java API Documentation: `java.util.Hashtable`, `java.util.Map`.

## 10. Conclusion
`Hashtable` is a legacy, hash table-based implementation of the `Map` interface, offering thread-safe key-value storage with synchronization on all methods. While suitable for legacy systems or basic thread-safe requirements, it is less efficient than `HashMap` or `ConcurrentHashMap`. Supporting non-null datatypes and providing both legacy and modern methods, it remains relevant for specific use cases. By adhering to best practices and avoiding pitfalls, developers can use `Hashtable` effectively in legacy or thread-safe scenarios.