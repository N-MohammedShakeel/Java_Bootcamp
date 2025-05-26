# Hashing in Depth: A Guide for DSA Preparation

## 1. What is Hashing?
Hashing is a technique that maps data (keys) to indices in a fixed-size data structure (typically an array) using a hash function. The goal is to enable O(1) average-case time complexity for operations like insertion, deletion, and lookup. Hashing is widely used in hash tables, sets, maps, and other data structures.

- **Key Idea**: A hash function transforms a key (e.g., string, integer) into an index in a hash table. If collisions occur (multiple keys mapping to the same index), they are resolved using techniques like chaining or open addressing.
- **Applications**: Dictionaries, databases, caching, password storage, and solving problems like finding duplicates or frequent elements.
- **Advantages**:
  - Fast lookups, insertions, and deletions (O(1) average case).
  - Compact storage for key-value pairs or sets.
  - Versatile for various data types (integers, strings, objects).

## 2. Core Components of Hashing
### 2.1 Hash Function
A hash function `h(key)` maps a key to an index in the hash table (range: 0 to m-1, where m is the table size).
- **Properties of a Good Hash Function**:
  - Deterministic: Same key always maps to the same index.
  - Uniform: Distributes keys evenly across the table to minimize collisions.
  - Efficient: Computes quickly.
  - Minimal collisions: Reduces the number of keys mapping to the same index.
- **Examples**:
  - Modulo: `h(key) = key % m` (for integers).
  - Polynomial Hashing: For strings, e.g., `h(s) = (s[0] + s[1]*p + s[2]*p^2 + ...) % m`, where p is a prime.
  - Universal Hashing: Uses a family of hash functions to reduce collision probability.

### 2.2 Hash Table
A hash table is an array where each index (bucket) stores key-value pairs or keys. Collisions are handled using:
- **Chaining**: Each bucket contains a linked list (or other data structure) of keys that hash to the same index.
- **Open Addressing**: All keys are stored in the array itself, using probing to find an empty slot.

### 2.3 Collision Resolution
Collisions occur when multiple keys map to the same index. Common resolution techniques:
- **Chaining**:
  - Store keys in a linked list at each index.
  - Pros: Simple, handles many collisions.
  - Cons: Extra memory for lists, cache-unfriendly.
- **Open Addressing**:
  - Linear Probing: Try next slot (`h(key) + i`) until an empty slot is found.
  - Quadratic Probing: Use quadratic increments (`h(key) + i^2`).
  - Double Hashing: Use a second hash function to compute the step size.
  - Pros: No extra memory for lists.
  - Cons: Clustering, harder to implement deletions.

## 3. When to Use Hashing
Use hashing when:
- You need fast lookups, insertions, or deletions (e.g., dictionaries, sets).
- The problem involves counting frequencies, checking duplicates, or mapping keys to values.
- Space is not a critical constraint, and average-case performance is prioritized.
- Common problems:
  - Two Sum (LeetCode #1)
  - Find duplicates in an array.
  - Implement a hash map or hash set.
  - String matching (e.g., Rabin-Karp algorithm).

## 4. Hashing in Java
Java provides built-in hash-based data structures in the `java.util` package:
- **HashMap**: Stores key-value pairs, uses chaining for collision resolution.
  - Example: `HashMap<Integer, String> map = new HashMap<>();`
  - Operations: `put(key, value)`, `get(key)`, `remove(key)`, `containsKey(key)`.
- **HashSet**: Stores unique keys, built on top of HashMap.
  - Example: `HashSet<Integer> set = new HashSet<>();`
  - Operations: `add(key)`, `remove(key)`, `contains(key)`.
- **Key Notes**:
  - Java’s `hashCode()` method (in `Object` class) is used to compute hash values.
  - Override `hashCode()` and `equals()` for custom objects to ensure correct behavior.
  - Default load factor: 0.75 (resize when 75% full).
  - Time Complexity: O(1) average case, O(n) worst case (many collisions).

## 5. Custom Hash Function Example
For integers:
```java
int hash(int key, int tableSize) {
    return key % tableSize; // Simple modulo
}
```
For strings:
```java
int hash(String s, int tableSize) {
    int hash = 0;
    int p = 31; // Prime number
    for (char c : s.toCharArray()) {
        hash = (hash * p + c) % tableSize;
    }
    return hash;
}
```

## 6. Implementing a Simple HashMap
Below is a basic hash map implementation with chaining:
```java
class MyHashMap {
    class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] table;
    private int size = 1000;

    public MyHashMap() {
        table = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node node = table[index];
        // If bucket is empty, create new node
        if (node == null) {
            table[index] = new Node(key, value);
            return;
        }
        // Traverse linked list to update or append
        while (node != null) {
            if (node.key == key) {
                node.value = value; // Update
                return;
            }
            if (node.next == null) break;
            node = node.next;
        }
        node.next = new Node(key, value); // Append
    }

    public int get(int key) {
        int index = hash(key);
        Node node = table[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1; // Not found
    }

    public void remove(int key) {
        int index = hash(key);
        Node node = table[index];
        if (node == null) return;
        if (node.key == key) {
            table[index] = node.next;
            return;
        }
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}
```

## 7. Collision Resolution in Depth
### 7.1 Chaining
- Each bucket is a linked list (or other structure like a tree in Java’s HashMap for high collisions).
- Time Complexity:
  - Average: O(1 + α), where α = n/m (load factor, n = number of keys, m = table size).
  - Worst: O(n) if all keys hash to the same bucket.
- Space Complexity: O(n + m) for lists and table.

### 7.2 Open Addressing
- Linear Probing:
  - Try `h(key) + i` until an empty slot is found.
  - Issue: Primary clustering (consecutive filled slots).
- Quadratic Probing:
  - Try `h(key) + i^2`.
  - Reduces clustering but can miss slots if table size is not chosen carefully.
- Double Hashing:
  - Use `h1(key) + i * h2(key)` for probing.
  - Minimizes clustering, better distribution.
- Time Complexity:
  - Average: O(1) for low load factor.
  - Worst: O(n) if table is nearly full.
- Space Complexity: O(m) for the table.

## 8. Advanced Hashing Techniques
- **Double Hashing**: Use two hash functions for better distribution in open addressing.
- **Cuckoo Hashing**: Use two hash tables and two hash functions, moving keys during insertion to resolve collisions.
- **Perfect Hashing**: Design a hash function with no collisions (used in static data).
- **Rolling Hash**: Used in string matching (e.g., Rabin-Karp algorithm) to compute hash values incrementally.

## 9. Applications of Hashing
- **Hash Tables**: Implement dictionaries, sets, or maps (e.g., HashMap, HashSet).
- **String Matching**: Rabin-Karp algorithm for pattern searching.
- **Frequency Counting**: Count occurrences of elements (e.g., find most frequent element).
- **Caching**: Store computed results for quick retrieval.
- **Cryptography**: Hash functions like MD5, SHA for password storage (not covered here).
- **Graph Algorithms**: Track visited nodes or edges efficiently.
- **Load Balancing**: Distribute requests across servers.

## 10. Common Hashing Problems
1. **Two Sum** (LeetCode #1): Use HashMap to find two numbers summing to a target.
2. **Group Anagrams** (LeetCode #49): Use hash of sorted strings as keys.
3. **Longest Consecutive Sequence** (LeetCode #128): Use HashSet to check consecutive numbers.
4. **Subarray Sum Equals K** (LeetCode #560): Use HashMap to store cumulative sums.
5. **Rabin-Karp String Matching** (GeeksforGeeks): Use rolling hash for pattern searching.

## 11. Time and Space Complexity
- **Time Complexity**:
  - Average: O(1) for insert, delete, lookup with a good hash function and low load factor.
  - Worst: O(n) if many collisions occur (e.g., poor hash function or high load factor).
- **Space Complexity**:
  - Chaining: O(n + m) for keys and table.
  - Open Addressing: O(m) for the table.
  - Additional space for temporary data (e.g., linked lists in chaining).

## 12. Common Pitfalls
- **Poor Hash Function**: Leads to many collisions, degrading performance to O(n).
- **Load Factor**: High load factor (n/m > 0.7) increases collisions; resize table when needed.
- **Custom Objects**: Always override `hashCode()` and `equals()` consistently for custom keys.
- **Edge Cases**: Handle negative keys, null keys, or empty inputs correctly.
- **Table Size**: Choose a prime number for table size to reduce collisions.

## 13. Java-Specific Tips
- **Custom Objects**:
  ```java
  class MyKey {
      int id;
      @Override
      public int hashCode() {
          return Objects.hash(id);
      }
      @Override
      public boolean equals(Object obj) {
          if (this == obj) return true;
          if (!(obj instanceof MyKey)) return false;
          MyKey other = (MyKey) obj;
          return id == other.id;
      }
  }
  ```
- **Load Factor and Resizing**: Java’s HashMap resizes when load factor exceeds 0.75, doubling the table size.
- **Iterating HashMap**:
  ```java
  HashMap<Integer, String> map = new HashMap<>();
  for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
  }
  ```
- **Avoiding Collisions**: Use prime numbers for modulo or custom polynomial hashing for strings.

## 14. Practice Strategy
1. Start with simple problems like Two Sum or implementing a basic hash map.
2. Move to string-based hashing (e.g., Group Anagrams, Rabin-Karp).
3. Practice collision resolution techniques (chaining, linear probing).
4. Solve at least 15-20 hashing problems on LeetCode or GeeksforGeeks.
5. Implement a hash map from scratch to understand internals.

## 15. Resources
- **Books**:
  - "Introduction to Algorithms" by Cormen (CLRS)
  - "Data Structures and Algorithms in Java" by Robert Lafore
- **Online Platforms**:
  - LeetCode (Hash Table tag)
  - GeeksforGeeks (Hashing section)
  - HackerRank (Data Structures > Hash Tables)
- **Tutorials**:
  - GeeksforGeeks Hashing Articles
  - LeetCode Discuss for problem-specific solutions
  - YouTube channels like Tushar Roy or BackToBackSWE

## 16. Conclusion
Hashing is a cornerstone of efficient algorithm design, enabling fast data access and manipulation. By understanding hash functions, collision resolution, and Java’s built-in tools like HashMap and HashSet, you can tackle a wide range of DSA problems. Practice implementing custom hash tables and solving hashing-based problems to build proficiency.

Happy coding!