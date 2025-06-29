# Java Collections and Map Implementations: In-Depth Internal Details

This document provides an exhaustive exploration of the internal implementation details for the primary implementation classes of the Java Collections Framework (`List`, `Set`, `Queue`, and `Map` interfaces), including `ArrayList`, `LinkedList`, `Vector`, `HashSet`, `LinkedHashSet`, `TreeSet`, `ArrayDeque`, `PriorityQueue`, `HashMap`, `Hashtable`, `LinkedHashMap`, `TreeMap`, and `ConcurrentHashMap`. For each class, I will detail the node structure, constructors, initial capacity, load factor, resizing mechanisms, internal data structure, data storage processes, and iterator implementations. Special emphasis is placed on tracing data structures to their foundational components (e.g., `HashSet` → `HashMap` → hash table → array of buckets) and explaining low-level operations like hashing, rehashing, collision resolution, array resizing, node allocation, or tree balancing, tailored to each class’s unique implementation. All details are based on the OpenJDK implementation (Java 17+ as of June 29, 2025, 7:37 PM IST).

---

## 1. Introduction
The Java Collections Framework, part of the `java.util` package, provides interfaces (`List`, `Set`, `Queue`, `Map`) and their implementations optimized for various use cases. This document dives into the low-level mechanics of each implementation, covering:

- **Node Structure**: Data structure for storing elements (e.g., array slots, linked list nodes, tree nodes).
- **Constructors**: Available constructors and their roles.
- **Initial Capacity**: Default or user-specified capacity for dynamic structures.
- **Load Factor**: Threshold for resizing (for hash-based structures).
- **Resizing Mechanism**: How the structure grows or balances (e.g., array resizing, node allocation, tree rebalancing).
- **Internal Data Structure**: Core data structure, its organization, and how data is stored.
- **Data Storage Process**: How elements are inserted, retrieved, and removed.
- **Iterator**: Implementation details, including fail-fast or weakly consistent behavior.
- **Use Cases**: Applications in DSA and real-world scenarios.

---

## 2. List Implementations

### 2.1 ArrayList
- **Internal Data Structure**: Dynamic array (`Object[] elementData`).
  - **Description**: Elements are stored in a contiguous array, enabling O(1) random access via indexing. The array is dynamically resized when the number of elements (`size`) exceeds the current capacity (`elementData.length`).
  - **Data Storage Process**:
    - **Add**: Appends to `elementData[size]`, increments `size`. If `size == elementData.length`, triggers resizing. For insertions at arbitrary indices, shifts elements right using `System.arraycopy` (O(n)).
    - **Get/Set**: Direct array access via `elementData[index]` (O(1)).
    - **Remove**: Shifts elements left using `System.arraycopy`, decrements `size` (O(n)).
- **Node Structure**: None (array-based).
  - Elements are stored directly in `Object[] elementData`. Each slot holds a reference to an element (or `null`).
- **Constructors**:
  - `ArrayList()`: Initializes with a lazy capacity of 0 (sets `elementData = EMPTY_ELEMENTDATA`, grows to 10 on first `add`).
  - `ArrayList(int initialCapacity)`: Allocates `elementData` with specified size.
  - `ArrayList(Collection<? extends E> c)`: Copies elements from a collection, sizing `elementData` to fit.
- **Initial Capacity**: Default is 0 (lazy-initialized to 10 on first `add`).
- **Load Factor**: Not applicable (array-based).
- **Resizing Mechanism**:
  - **Description**: When `size` reaches `elementData.length`, a new array is created with capacity `newCapacity = oldCapacity + (oldCapacity >> 1)` (1.5x growth). Elements are copied using `System.arraycopy` (O(n)).
  - **Process**: Calculates new capacity, allocates new array, copies elements, updates `elementData`. Shrinking is possible via `trimToSize()` (resizes to `size`).
  - **Time Complexity**: Amortized O(1) for `add` due to infrequent resizing; O(n) for actual resize operation.
- **Iterator**:
  - **Type**: Fail-fast (`Itr` and `ListItr` classes).
  - **Implementation**: Tracks an index (`cursor`) and `expectedModCount` (modification count). Checks `modCount` against `expectedModCount` to detect structural changes (e.g., `add`, `remove`). Throws `ConcurrentModificationException` if modified externally. `ListIterator` supports bidirectional traversal (`next`, `previous`) and modifications (`add`, `set`, `remove`).
  - **Time Complexity**: O(1) for `next`, `hasNext`, `remove`.
- **Key Features**:
  - O(1) for `get`, `set`, `add` (at end).
  - O(n) for `add`/`remove` at arbitrary positions due to shifting.
  - Not thread-safe; use `Collections.synchronizedList` for synchronization.
- **Use Case**: Fast random access for dynamic lists (e.g., LeetCode #26 Remove Duplicates from Sorted Array).

### 2.2 LinkedList
- **Internal Data Structure**: Doubly-linked list.
  - **Description**: Elements are stored in nodes linked bidirectionally, enabling O(1) insertions/deletions at known positions (head, tail, or via iterator). Traversal to arbitrary indices is O(n) due to sequential node access.
  - **Data Storage Process**:
    - **Add**: Creates a new `Node`, updates `prev` and `next` references. O(1) at head/tail, O(n) for arbitrary indices (traversal).
    - **Get/Set**: Traverses from `first` or `last` to the index (O(n)).
    - **Remove**: Updates `prev` and `next` references of adjacent nodes (O(1) if node known, O(n) for index-based).
- **Node Structure**:
  ```java
  private static class Node<E> {
      E item;           // Element stored
      Node<E> next;     // Reference to next node
      Node<E> prev;     // Reference to previous node
      Node(Node<E> prev, E element, Node<E> next) {
          this.item = element;
          this.next = next;
          this.prev = prev;
      }
  }
  ```
  - Maintains `first` and `last` pointers for head and tail.
- **Constructors**:
  - `LinkedList()`: Initializes an empty list (`first = null`, `last = null`).
  - `LinkedList(Collection<? extends E> c)`: Adds elements from a collection, creating nodes sequentially.
- **Initial Capacity**: Not applicable (node-based, grows dynamically).
- **Load Factor**: Not applicable.
- **Resizing Mechanism**:
  - **Description**: No fixed capacity; new `Node` objects are allocated as elements are added. Memory usage grows linearly with the number of elements.
  - **Process**: Each `add` creates a new `Node` and updates references (O(1)). No array resizing; memory is managed by the JVM’s garbage collector for removed nodes.
  - **Time Complexity**: O(1) for node allocation, O(n) for index-based operations due to traversal.
- **Iterator**:
  - **Type**: Fail-fast (`ListItr` class, implements `ListIterator`).
  - **Implementation**: Tracks the current `Node` and `expectedModCount`. Throws `ConcurrentModificationException` if `modCount` changes externally. Supports bidirectional traversal (`next`, `previous`) and modifications (`add`, `set`, `remove`).
  - **Time Complexity**: O(1) for `next`, `hasNext`, `previous`, `remove`.
- **Key Features**:
  - O(1) for `add`/`remove` at head/tail or known positions.
  - O(n) for `get`/`set`/`add`/`remove` at arbitrary indices.
  - Not thread-safe; implements `Deque` for queue/stack operations.
- **Use Case**: Frequent insertions/deletions at ends (e.g., LeetCode #206 Reverse Linked List).

### 2.3 Vector
- **Internal Data Structure**: Dynamic array (`Object[] elementData`).
  - **Description**: Similar to `ArrayList`, but all methods are synchronized for thread safety (legacy class, JDK 1.0). Elements are stored contiguously, enabling O(1) random access.
  - **Data Storage Process**:
    - **Add**: Appends to `elementData[size]`, increments `size`. Resizes if `size == elementData.length` (O(n) for copying).
    - **Get/Set**: Direct array access via `elementData[index]` (O(1), synchronized).
    - **Remove**: Shifts elements left using `System.arraycopy`, decrements `size` (O(n), synchronized).
- **Node Structure**: None (array-based).
  - Elements stored directly in `elementData`.
- **Constructors**:
  - `Vector()`: Initializes with default capacity (10).
  - `Vector(int initialCapacity)`: Specifies initial capacity.
  - `Vector(int initialCapacity, int capacityIncrement)`: Specifies capacity and increment for resizing.
  - `Vector(Collection<? extends E> c)`: Copies elements from a collection.
- **Initial Capacity**: Default is 10.
- **Load Factor**: Not applicable.
- **Resizing Mechanism**:
  - **Description**: When `size` reaches `elementData.length`, a new array is created with capacity `newCapacity = oldCapacity * 2` (default) or `oldCapacity + capacityIncrement` if specified.
  - **Process**: Allocates new array, copies elements using `System.arraycopy`, updates `elementData` (O(n)).
  - **Time Complexity**: Amortized O(1) for `add`, O(n) for actual resize.
- **Iterator**:
  - **Type**: Fail-fast (`Itr` and `ListItr` classes).
  - **Implementation**: Tracks index and `expectedModCount`, synchronized. Throws `ConcurrentModificationException` on structural changes. Supports bidirectional traversal and modifications. Also provides `Enumeration` via `elements()` for legacy compatibility.
  - **Time Complexity**: O(1) for `next`, `hasNext`, `remove`.
- **Key Features**:
  - O(1) for `get`, `set`, `add` (at end).
  - O(n) for `add`/`remove` at arbitrary positions.
  - Thread-safe but less efficient than modern alternatives like `CopyOnWriteArrayList`.
- **Use Case**: Legacy thread-safe lists (e.g., older GUI applications).

### 2.4 CopyOnWriteArrayList
- **Internal Data Structure**: Dynamic array (`Object[] array`, volatile).
  - **Description**: Uses a copy-on-write strategy: modifications create a new array copy, ensuring thread safety for read-heavy scenarios. Elements are stored contiguously.
  - **Data Storage Process**:
    - **Add**: Creates a new array, copies existing elements, adds the new element, updates the volatile `array` reference (O(n)).
    - **Get/Set**: Direct access to `array[index]` (O(1)).
    - **Remove**: Creates a new array, copies non-removed elements (O(n)).
- **Node Structure**: None (array-based).
- **Constructors**:
  - `CopyOnWriteArrayList()`: Initializes an empty array.
  - `CopyOnWriteArrayList(Collection<? extends E> c)`: Copies elements from a collection.
  - `CopyOnWriteArrayList(E[] toCopyIn)`: Copies elements from an array.
- **Initial Capacity**: Not explicitly defined (array sized to fit initial elements).
- **Load Factor**: Not applicable.
- **Resizing Mechanism**:
  - **Description**: Each modification creates a new array with capacity sufficient to hold the new size (typically doubles for `add` operations if needed).
  - **Process**: Allocates new array, copies elements using `System.arraycopy`, updates `array` reference under a lock. No explicit load factor; resizing is implicit per operation.
  - **Time Complexity**: O(n) per modification due to copying.
- **Iterator**:
  - **Type**: Snapshot-based (`COWIterator` class).
  - **Implementation**: Uses a snapshot of the array at creation time. Unaffected by subsequent modifications. Does not support `remove`, `add`, or `set` (throws `UnsupportedOperationException`).
  - **Time Complexity**: O(1) for `next`, `hasNext`.
- **Key Features**:
  - O(n) for modifications due to array copying.
  - O(1) for `get`.
  - Thread-safe, optimized for read-heavy scenarios.
- **Use Case**: Concurrent lists with frequent reads (e.g., event listeners).

---

## 3. Set Implementations

### 3.1 HashSet
- **Internal Data Structure**: Backed by a `HashMap<E, Object>`.
  - **Description**: Stores elements as keys in a `HashMap`, with a dummy `Object` (`PRESENT`) as the value. The `HashMap` uses a hash table, which is an array of buckets (`Node<K, V>[] table`), where each bucket is a linked list or red-black tree for collision resolution.
  - **Data Storage Process**:
    - **Add**: Computes the hash of the element, determines the bucket index, and adds a `Node` to the bucket (linked list or tree). If the element exists (`equals` check), no update occurs. Triggers resize if `size > capacity * loadFactor`.
    - **Contains**: Computes hash, checks the bucket for the element using `equals` (O(1) average, O(n) worst-case without treeification).
    - **Remove**: Locates the element in its bucket and removes the `Node` (O(1) average).
  - **Hashing**:
    - **Definition**: Converts an element’s `hashCode()` into a bucket index. `HashMap` uses:
      ```java
      static final int hash(Object key) {
          int h;
          return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
      }
      ```
      - The XOR (`h ^ (h >>> 16)`) spreads high-order bits to reduce collisions.
      - Null keys hash to 0.
      - Bucket index: `index = hash & (table.length - 1)` (ensures index within table bounds, as `table.length` is a power of 2).
    - **Collision Resolution**: Handled via linked lists (O(n) worst-case lookup) or red-black trees (O(log n) if bucket size exceeds `TREEIFY_THRESHOLD`, default 8). Trees revert to lists if size falls below `UNTREEIFY_THRESHOLD` (default 6).
  - **Rehashing**:
    - **Definition**: When `size` exceeds `capacity * loadFactor`, the table is resized (doubled), and all entries are rehashed.
    - **Process**: Creates a new `Node[]` array with `newCapacity = oldCapacity * 2`. Each entry is rehashed using the new table size (`newIndex = hash & (newTable.length - 1)`), redistributing nodes to new buckets. Linked lists may split, and trees may revert to lists or remain trees based on size.
    - **Time Complexity**: O(n) for rehashing (all entries reprocessed).
- **Node Structure** (from `HashMap`):
  ```java
  static class Node<K, V> implements Map.Entry<K, V> {
      final int hash;        // Hash code of key
      final K key;           // Key (the element in HashSet)
      V value;               // Dummy Object (PRESENT)
      Node<K, V> next;       // Next node in bucket
      Node(int hash, K key, V value, Node<K, V> next) {
          this.hash = hash;
          this.key = key;
          this.value = value;
          this.next = next;
      }
  }
  static class TreeNode<K, V> extends Node<K, V> {
      TreeNode<K, V> parent, left, right, prev; // Red-black tree links
      boolean red;                              // Color for red-black tree
      // Constructor and tree methods
  }
  ```
- **Constructors**:
  - `HashSet()`: Creates a `HashMap` with default capacity (16) and load factor (0.75).
  - `HashSet(int initialCapacity)`: Specifies initial capacity.
  - `HashSet(int initialCapacity, float loadFactor)`: Specifies capacity and load factor.
  - `HashSet(Collection<? extends E> c)`: Adds elements from a collection.
- **Initial Capacity**: Default is 16 (via `HashMap`).
- **Load Factor**: Default is 0.75 (via `HashMap`).
- **Resizing Mechanism**: Doubles (`newCapacity = oldCapacity * 2`, via `HashMap`).
- **Iterator**:
  - **Type**: Fail-fast (`HashMap.KeyIterator`).
  - **Implementation**: Traverses `HashMap`’s buckets and nodes, iterating over keys (elements). Tracks `expectedModCount`. Throws `ConcurrentModificationException` if `HashMap` is modified structurally. Supports `remove`.
  - **Time Complexity**: O(1) amortized per operation.
- **Key Features**:
  - O(1) average for `add`, `remove`, `contains`.
  - Unordered, allows one null element.
  - Not thread-safe; use `Collections.synchronizedSet`.
- **Use Case**: Fast membership testing (e.g., LeetCode #217 Contains Duplicate).

### 3.2 LinkedHashSet
- **Internal Data Structure**: Backed by a `LinkedHashMap<E, Object>`.
  - **Description**: Extends `HashSet` by using a `LinkedHashMap`, which combines a hash table (`Node<K, V>[] table`) with a doubly-linked list to maintain insertion order. Elements are keys with a dummy `Object` (`PRESENT`) as the value.
  - **Data Storage Process**: Same as `HashSet`, but each `Node` is also linked in a doubly-linked list (`before`, `after`) to preserve insertion order. Operations update both the hash table and the linked list.
  - **Hashing**: Identical to `HashMap` (uses `hash(key)` with XOR bit-spreading, null keys hash to 0).
  - **Rehashing**: Same as `HashMap`. During resize, the doubly-linked list is preserved, and nodes are redistributed to new buckets (O(n)). The linked list ensures iteration follows insertion order.
- **Node Structure** (from `LinkedHashMap`):
  ```java
  static class Entry<K, V> extends HashMap.Node<K, V> {
      Entry<K, V> before, after; // Doubly-linked list links
      Entry(int hash, K key, V value, Node<K, V> next) {
          super(hash, key, value, next);
      }
  }
  ```
- **Constructors**:
  - `LinkedHashSet()`: Creates a `LinkedHashMap` with default capacity (16) and load factor (0.75).
  - `LinkedHashSet(int initialCapacity)`: Specifies initial capacity.
  - `LinkedHashSet(int initialCapacity, float loadFactor)`: Specifies capacity and load factor.
  - `LinkedHashSet(Collection<? extends E> c)`: Adds elements from a collection.
- **Initial Capacity**: Default is 16 (via `LinkedHashMap`).
- **Load Factor**: Default is 0.75 (via `LinkedHashMap`).
- **Resizing Mechanism**: Doubles (`newCapacity = oldCapacity * 2`, via `LinkedHashMap`). Maintains the doubly-linked list during rehashing.
- **Iterator**:
  - **Type**: Fail-fast (`LinkedHashMap.LinkedKeyIterator`).
  - **Implementation**: Traverses the doubly-linked list in insertion order, iterating over keys. Tracks `expectedModCount`. Throws `ConcurrentModificationException` on structural modifications. Supports `remove`.
  - **Time Complexity**: O(1) per operation.
- **Key Features**:
  - O(1) average for `add`, `remove`, `contains`.
  - Maintains insertion order, allows one null element.
  - Not thread-safe.
- **Use Case**: Ordered unique elements (e.g., LeetCode #705 Design HashSet with order).

### 3.3 TreeSet
- **Internal Data Structure**: Backed by a `TreeMap<E, Object>`.
  - **Description**: Stores elements as keys in a `TreeMap` with a dummy `Object` (`PRESENT`) as the value. The `TreeMap` uses a red-black tree (self-balancing binary search tree) to maintain sorted order (natural or custom comparator).
  - **Data Storage Process**:
    - **Add**: Inserts a key into the red-black tree, balancing as needed (O(log n)). If the key exists (`compareTo` or comparator), no update occurs.
    - **Contains**: Searches the tree for the key (O(log n)).
    - **Remove**: Removes the key from the tree, rebalancing (O(log n)).
  - **Balancing Mechanism** (instead of hashing/rehashing):
    - **Description**: The red-black tree ensures O(log n) operations by maintaining balance. Each insertion/deletion triggers rotations and color flips to keep the tree balanced (height ~ 2 * log(n)).
    - **Process**: After insertion, the tree performs rotations and recoloring to satisfy red-black properties (e.g., no two red nodes adjacent, equal black nodes on all paths to leaves). Deletions involve replacing the node with its successor and rebalancing.
    - **Time Complexity**: O(log n) per operation.
- **Node Structure** (from `TreeMap`):
  ```java
  static final class Entry<K, V> implements Map.Entry<K, V> {
      K key;                 // Key (the element in TreeSet)
      V value;               // Dummy Object (PRESENT)
      Entry<K, V> left, right, parent; // Tree links
      boolean color;         // Red or black (for balancing)
      Entry(K key, V value, Entry<K, V> parent) {
          this.key = key;
          this.value = value;
          this.parent = parent;
      }
  }
  ```
- **Constructors**:
  - `TreeSet()`: Creates a `TreeMap` with natural ordering.
  - `TreeSet(Comparator<? super E> comparator)`: Uses a custom comparator.
  - `TreeSet(Collection<? extends E> c)`: Adds elements from a collection.
  - `TreeSet(SortedSet<E> s)`: Copies a sorted set, inheriting its comparator.
- **Initial Capacity**: Not applicable (tree-based, grows dynamically).
- **Load Factor**: Not applicable.
- **Resizing Mechanism**: Not applicable; new `Entry` nodes are allocated as needed (O(log n) for insertion and balancing).
- **Iterator**:
  - **Type**: Fail-fast (`TreeMap.KeyIterator`).
  - **Implementation**: Traverses the tree in-order (sorted order). Tracks `expectedModCount`. Throws `ConcurrentModificationException` on structural modifications. Supports `remove`.
  - **Time Complexity**: O(log n) per operation due to tree traversal.
- **Key Features**:
  - O(log n) for `add`, `remove`, `contains`.
  - Sorted order, no null elements unless comparator allows.
  - Not thread-safe; use `Collections.synchronizedSortedSet`.
- **Use Case**: Sorted unique elements (e.g., LeetCode #220 Contains Duplicate III).

### 3.4 CopyOnWriteArraySet
- **Internal Data Structure**: Backed by a `CopyOnWriteArrayList`.
  - **Description**: Stores elements in a `CopyOnWriteArrayList`, ensuring uniqueness. The underlying list uses a dynamic array (`Object[] array`, volatile) with copy-on-write for thread safety.
  - **Data Storage Process**:
    - **Add**: Checks if the element exists (O(n) linear search). If absent, creates a new array, copies elements, adds the new element, updates `array` (O(n)).
    - **Contains**: Linear search in `array` (O(n)).
    - **Remove**: Creates a new array, copies non-removed elements (O(n)).
- **Node Structure**: None (array-based via `CopyOnWriteArrayList`).
- **Constructors**:
  - `CopyOnWriteArraySet()`: Initializes an empty `CopyOnWriteArrayList`.
  - `CopyOnWriteArraySet(Collection<? extends E> c)`: Copies unique elements from a collection.
- **Initial Capacity**: Not explicitly defined (array sized to fit initial elements).
- **Load Factor**: Not applicable.
- **Resizing Mechanism**:
  - **Description**: Each modification creates a new array with capacity sufficient for the new size (typically doubles if needed).
  - **Process**: Allocates new array, copies elements using `System.arraycopy`, updates `array` under a lock (O(n)).
- **Iterator**:
  - **Type**: Snapshot-based (`CopyOnWriteArrayList.COWIterator`).
  - **Implementation**: Uses a snapshot of the underlying array. Unaffected by modifications. Does not support `remove`, `add`, or `set`.
  - **Time Complexity**: O(1) for `next`, `hasNext`.
- **Key Features**:
  - O(n) for `add`, `remove`, `contains` due to linear search and copying.
  - Thread-safe, optimized for read-heavy scenarios.
  - Allows null elements.
- **Use Case**: Concurrent sets with frequent reads (e.g., event listeners).

---

## 4. Queue Implementations

### 4.1 ArrayDeque
- **Internal Data Structure**: Circular array (`Object[] elements`).
  - **Description**: A doubly-ended queue using a circular array with `head` and `tail` indices. Supports O(1) operations at both ends by wrapping indices modulo array length.
  - **Data Storage Process**:
    - **Add**: Inserts at `elements[tail]` (tail) or `elements[head-1]` (head), updates indices (O(1)). Resizes if full.
    - **Get/Peek**: Accesses `elements[head]` or `elements[tail-1]` (O(1)).
    - **Remove**: Removes from `elements[head]` or `elements[tail-1]`, updates indices (O(1)).
- **Node Structure**: None (array-based).
- **Constructors**:
  - `ArrayDeque()`: Initializes with default capacity (16, minimum 8, power of 2).
  - `ArrayDeque(int numElements)`: Allocates capacity to hold at least `numElements` (next power of 2).
  - `ArrayDeque(Collection<? extends E> c)`: Copies elements from a collection.
- **Initial Capacity**: Default is 16 (minimum 8, rounded to next power of 2).
- **Load Factor**: Not applicable.
- **Resizing Mechanism**:
  - **Description**: When full, doubles the array size (`newCapacity = oldCapacity * 2`).
  - **Process**: Allocates new array, copies elements to align `head` and `tail` correctly (O(n)). Maintains circular property.
  - **Time Complexity**: Amortized O(1) for `add`, O(n) for resize.
- **Iterator**:
  - **Type**: Fail-fast (`DeqIterator` and `DescendingIterator`).
  - **Implementation**: Traverses the circular array using indices, supports forward and reverse traversal. Throws `ConcurrentModificationException` on structural changes. Supports `remove`.
  - **Time Complexity**: O(1) for `next`, `hasNext`, `remove`.
- **Key Features**:
  - O(1) for `add`, `remove`, `peek` at head/tail.
  - Not thread-safe; no null elements allowed.
- **Use Case**: Efficient deque operations (e.g., LeetCode #239 Sliding Window Maximum).

### 4.2 PriorityQueue
- **Internal Data Structure**: Binary min-heap (array-based, `Object[] queue`).
  - **Description**: Elements are stored in an array maintaining the heap property (parent <= children for min-heap). The smallest element is at `queue[0]`.
  - **Data Storage Process**:
    - **Add/Offer**: Inserts at the end, sifts up to restore heap property (O(log n)).
    - **Peek**: Returns `queue[0]` (O(1)).
    - **Remove/Poll**: Removes `queue[0]`, moves last element to root, sifts down (O(log n)).
  - **Balancing Mechanism** (instead of hashing/rehashing):
    - **Description**: Maintains heap property via sift-up (after insertion) and sift-down (after removal). Uses `compareTo` or a custom comparator.
    - **Process**: Sift-up compares the new element with its parent, swapping if out of order. Sift-down compares the root with its children, swapping with the smaller child. Continues until the heap property is restored.
    - **Time Complexity**: O(log n) per operation.
- **Node Structure**: None (array-based).
- **Constructors**:
  - `PriorityQueue()`: Initializes with default capacity (11).
  - `PriorityQueue(int initialCapacity)`: Specifies initial capacity.
  - `PriorityQueue(Comparator<? super E> comparator)`: Uses a custom comparator.
  - `PriorityQueue(int initialCapacity, Comparator<? super E> comparator)`: Specifies capacity and comparator.
  - `PriorityQueue(Collection<? extends E> c)`: Copies elements, heapifies (O(n)).
  - `PriorityQueue(PriorityQueue<? extends E> c)`: Copies another priority queue.
  - `PriorityQueue(SortedSet<? extends E> c)`: Copies a sorted set.
- **Initial Capacity**: Default is 11.
- **Load Factor**: Not applicable.
- **Resizing Mechanism**:
  - **Description**: When full, grows by `max(2 * oldCapacity, oldCapacity + 2)` if `oldCapacity < 64`, else `1.5 * oldCapacity`.
  - **Process**: Allocates new array, copies elements, updates `queue` (O(n)).
  - **Time Complexity**: Amortized O(1) for `offer`, O(n) for resize.
- **Iterator**:
  - **Type**: Fail-fast (`Itr` class).
  - **Implementation**: Traverses `queue` sequentially (not in heap order). Throws `ConcurrentModificationException` on structural changes. Supports `remove`.
  - **Time Complexity**: O(1) for `next`, `hasNext`.
- **Key Features**:
  - O(log n) for `offer`, `poll`, `remove`.
  - O(1) for `peek`.
  - Not thread-safe; no null elements.
- **Use Case**: Priority-based scheduling (e.g., LeetCode #23 Merge k Sorted Lists).

---

## 5. Map Implementations

### 5.1 HashMap
- **Internal Data Structure**: Hash table (`Node<K, V>[] table`).
  - **Description**: Uses an array of buckets, where each bucket is a linked list or red-black tree. Keys are hashed to determine bucket indices, with collisions resolved via lists or trees.
  - **Data Storage Process**:
    - **Put**: Computes hash of the key, determines bucket index, adds or updates a `Node` (O(1) average). Triggers resize if needed.
    - **Get**: Computes hash, searches bucket for the key using `equals` (O(1) average).
    - **Remove**: Locates and removes the `Node` from its bucket (O(1) average).
  - **Hashing**:
    - **Definition**: Uses `hash(key)` to compute bucket index:
      ```java
      static final int hash(Object key) {
          int h;
          return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
      }
      ```
      - XOR spreads bits for better distribution. Null keys hash to 0.
      - Bucket index: `index = hash & (table.length - 1)`.
    - **Collision Resolution**: Linked lists (O(n) worst-case) or red-black trees (O(log n) if bucket size > `TREEIFY_THRESHOLD`, 8). Trees revert to lists if size < `UNTREEIFY_THRESHOLD`, 6.
  - **Rehashing**:
    - **Description**: Resizes when `size > capacity * loadFactor`. Doubles table size (`newCapacity = oldCapacity * 2`).
    - **Process**: Creates new `Node[]`, rehashes all entries to new buckets. Linked lists may split, and trees may revert to lists or remain trees.
    - **Time Complexity**: O(n) for rehashing.
- **Node Structure**:
  ```java
  static class Node<K, V> implements Map.Entry<K, V> {
      final int hash;        // Hash code of key
      final K key;           // Key
      V value;               // Value
      Node<K, V> next;       // Next node in bucket
      Node(int hash, K key, V value, Node<K, V> next) {
          this.hash = hash;
          this.key = key;
          this.value = value;
          this.next = next;
      }
  }
  static class TreeNode<K, V> extends Node<K, V> {
      TreeNode<K, V> parent, left, right, prev; // Red-black tree links
      boolean red;                              // Color for red-black tree
      // Constructor and tree methods
  }
  ```
- **Constructors**:
  - `HashMap()`: Default capacity (16), load factor (0.75).
  - `HashMap(int initialCapacity)`: Specifies initial capacity.
  - `HashMap(int initialCapacity, float loadFactor)`: Specifies capacity and load factor.
  - `HashMap(Map<? extends K, ? extends V> m)`: Copies elements from another map.
- **Initial Capacity**: Default is 16 (power of 2).
- **Load Factor**: Default is 0.75.
- **Resizing Mechanism**: Doubles (`newCapacity = oldCapacity * 2`).
- **Iterator**:
  - **Type**: Fail-fast (`HashIterator` subclasses: `KeyIterator`, `ValueIterator`, `EntryIterator`).
  - **Implementation**: Traverses buckets and nodes. Throws `ConcurrentModificationException` on structural changes. Supports `remove`.
  - **Time Complexity**: O(1) amortized.
- **Key Features**:
  - O(1) average for `put`, `get`, `remove`.
  - Allows one null key, multiple null values.
  - Not thread-safe.
- **Use Case**: Fast key-value lookups (e.g., LeetCode #1 Two Sum).

### 5.2 Hashtable
- **Internal Data Structure**: Hash table (`Entry<K, V>[] table`).
  - **Description**: Legacy hash table (JDK 1.0) with an array of buckets (linked lists). All methods are synchronized for thread safety. No treeification (unlike `HashMap`).
  - **Data Storage Process**:
    - **Put**: Computes hash, determines bucket index, adds or updates an `Entry` (O(1) average, synchronized). No null keys/values.
    - **Get**: Searches bucket for the key (O(1) average, synchronized).
    - **Remove**: Removes the `Entry` from its bucket (O(1) average, synchronized).
  - **Hashing**:
    - **Definition**: Uses `key.hashCode()` directly (no bit-spreading like `HashMap`). Bucket index: `index = (hash & 0x7FFFFFFF) % table.length` (ensures non-negative index, modulo for non-power-of-2 size).
    - **Collision Resolution**: Linked lists only (O(n) worst-case).
  - **Rehashing**:
    - **Description**: Resizes when `size > capacity * loadFactor`. New capacity is `oldCapacity * 2 + 1` (odd size to reduce collisions).
    - **Process**: Creates new `Entry[]`, rehashes all entries using modulo arithmetic. Each entry is placed in a new bucket.
    - **Time Complexity**: O(n).
- **Node Structure**:
  ```java
  private static class Entry<K, V> implements Map.Entry<K, V> {
      final int hash;        // Hash code of key
      final K key;           // Key
      V value;               // Value
      Entry<K, V> next;      // Next entry in bucket
      protected Entry(int hash, K key, V value, Entry<K, V> next) {
          this.hash = hash;
          this.key = key;
          this.value = value;
          this.next = next;
      }
  }
  ```
- **Constructors**:
  - `Hashtable()`: Default capacity (11), load factor (0.75).
  - `Hashtable(int initialCapacity)`: Specifies initial capacity.
  - `Hashtable(int initialCapacity, float loadFactor)`: Specifies capacity and load factor.
  - `Hashtable(Map<? extends K, ? extends V> t)`: Copies elements from another map.
- **Initial Capacity**: Default is 11.
- **Load Factor**: Default is 0.75.
- **Resizing Mechanism**: Doubles plus one (`newCapacity = oldCapacity * 2 + 1`).
- **Iterator**:
  - **Type**: Fail-fast (`Enumerator` class, implements `Iterator` and `Enumeration`).
  - **Implementation**: Traverses buckets and entries, synchronized. Throws `ConcurrentModificationException`. Supports `remove`.
  - **Time Complexity**: O(1) amortized.
- **Key Features**:
  - O(1) average for `put`, `get`, `remove`.
  - No null keys/values.
  - Thread-safe (synchronized methods).
- **Use Case**: Legacy thread-safe maps (e.g., older server applications).

### 5.3 LinkedHashMap
- **Internal Data Structure**: Hash table with doubly-linked list (`Node<K, V>[] table`).
  - **Description**: Extends `HashMap`, adding a doubly-linked list to maintain insertion or access order. Buckets are linked lists or trees, with additional `before`/`after` links for order.
  - **Data Storage Process**: Same as `HashMap`, but updates the linked list for each operation to maintain order.
  - **Hashing**: Identical to `HashMap` (uses `hash(key)` with XOR bit-spreading).
  - **Rehashing**: Same as `HashMap` (doubles table size, redistributes nodes, preserves linked list).
- **Node Structure**:
  ```java
  static class Entry<K, V> extends HashMap.Node<K, V> {
      Entry<K, V> before, after; // Doubly-linked list links
      Entry(int hash, K key, V value, Node<K, V> next) {
          super(hash, key, value, next);
      }
  }
  ```
- **Constructors**:
  - `LinkedHashMap()`: Default capacity (16), load factor (0.75).
  - `LinkedHashMap(int initialCapacity)`: Specifies initial capacity.
  - `LinkedHashMap(int initialCapacity, float loadFactor)`: Specifies capacity and load factor.
  - `LinkedHashMap(Map<? extends K, ? extends V> m)`: Copies elements.
  - `LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)`: Specifies access-order mode (true for LRU).
- **Initial Capacity**: Default is 16.
- **Load Factor**: Default is 0.75.
- **Resizing Mechanism**: Doubles (`newCapacity = oldCapacity * 2`).
- **Iterator**:
  - **Type**: Fail-fast (`LinkedHashIterator` subclasses).
  - **Implementation**: Traverses the doubly-linked list in insertion or access order. Throws `ConcurrentModificationException`. Supports `remove`.
  - **Time Complexity**: O(1).
- **Key Features**:
  - O(1) average for `put`, `get`, `remove`.
  - Maintains insertion or access order, allows one null key, multiple null values.
  - Not thread-safe.
- **Use Case**: Ordered key-value mappings, LRU caches (e.g., LeetCode #146 LRU Cache).

### 5.4 TreeMap
- **Internal Data Structure**: Red-black tree.
  - **Description**: A self-balancing binary search tree maintaining sorted keys (natural or custom comparator).
  - **Data Storage Process**:
    - **Put**: Inserts a key-value pair into the tree, balancing as needed (O(log n)).
    - **Get**: Searches the tree for the key (O(log n)).
    - **Remove**: Removes the key-value pair, rebalancing (O(log n)).
  - **Balancing Mechanism**:
    - **Description**: Maintains red-black tree properties (no two red nodes adjacent, equal black nodes on paths to leaves, balanced height ~ 2 * log(n)).
    - **Process**: Insertions trigger rotations and recoloring to restore balance. Deletions replace the node with its successor and rebalance.
    - **Time Complexity**: O(log n).
- **Node Structure**:
  ```java
  static final class Entry<K, V> implements Map.Entry<K, V> {
      K key;                 // Key
      V value;               // Value
      Entry<K, V> left, right, parent; // Tree links
      boolean color;         // Red or black
      Entry(K key, V value, Entry<K, V> parent) {
          this.key = key;
          this.value = value;
          this.parent = parent;
      }
  }
  ```
- **Constructors**:
  - `TreeMap()`: Natural ordering.
  - `TreeMap(Comparator<? super K> comparator)`: Custom comparator.
  - `TreeMap(Map<? extends K, ? extends V> m)`: Copies elements.
  - `TreeMap(SortedMap<K, ? extends V> m)`: Copies sorted map.
- **Initial Capacity**: Not applicable (tree-based).
- **Load Factor**: Not applicable.
- **Resizing Mechanism**: Not applicable; nodes allocated dynamically (O(log n)).
- **Iterator**:
  - **Type**: Fail-fast (`EntryIterator`, `KeyIterator`, `ValueIterator`).
  - **Implementation**: Traverses tree in-order (sorted). Throws `ConcurrentModificationException`. Supports `remove`.
  - **Time Complexity**: O(log n).
- **Key Features**:
  - O(log n) for `put`, `get`, `remove`.
  - Sorted keys, no null keys, allows null values.
  - Not thread-safe.
- **Use Case**: Sorted key-value mappings (e.g., LeetCode #729 My Calendar I).

### 5.5 ConcurrentHashMap
- **Internal Data Structure**: Concurrent hash table (`Node<K, V>[] table`).
  - **Description**: A hash table with fine-grained locking and CAS (compare-and-swap) operations for thread safety. Buckets are linked lists or red-black trees.
  - **Data Storage Process**:
    - **Put**: Computes hash, locks the bucket, adds/updates a `Node` (O(1) average). Triggers resize if needed.
    - **Get**: Lock-free read, searches bucket (O(1) average).
    - **Remove**: Locks bucket, removes `Node` (O(1) average).
  - **Hashing**: Same as `HashMap` (uses `hash(key)` with XOR bit-spreading).
  - **Rehashing**:
    - **Description**: Resizes when `size > capacity * loadFactor`. Doubles table size.
    - **Process**: Uses a transfer mechanism where threads collaboratively resize the table, moving nodes to new buckets. Ensures thread safety via CAS and locks.
    - **Time Complexity**: O(n), but parallelized across threads.
- **Node Structure**:
  ```java
  static class Node<K, V> implements Map.Entry<K, V> {
      final int hash;        // Hash code
      final K key;           // Key
      volatile V val;        // Value (volatile for thread safety)
      volatile Node<K, V> next; // Next node
      Node(int hash, K key, V val, Node<K, V> next) {
          this.hash = hash;
          this.key = key;
          this.val = val;
          this.next = next;
      }
  }
  static final class TreeNode<K, V> extends Node<K, V> {
      TreeNode<K, V> parent, left, right, prev; // Red-black tree links
      boolean red;                              // Color
      // Constructor and tree methods
  }
  ```
- **Constructors**:
  - `ConcurrentHashMap()`: Default capacity (16), load factor (0.75).
  - `ConcurrentHashMap(int initialCapacity)`: Specifies initial capacity.
  - `ConcurrentHashMap(int initialCapacity, float loadFactor)`: Specifies capacity and load factor.
  - `ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)`: Specifies concurrency level (legacy).
  - `ConcurrentHashMap(Map<? extends K, ? extends V> m)`: Copies elements.
- **Initial Capacity**: Default is 16.
- **Load Factor**: Default is 0.75.
- **Resizing Mechanism**: Doubles (`newCapacity = oldCapacity * 2`).
- **Iterator**:
  - **Type**: Weakly consistent (`KeyIterator`, `ValueIterator`, `EntryIterator`).
  - **Implementation**: Traverses a snapshot or dynamically reflects updates. Does not throw `ConcurrentModificationException`. Supports `remove`.
  - **Time Complexity**: O(1) amortized.
- **Key Features**:
  - O(1) average for `put`, `get`, `remove`.
  - Thread-safe with fine-grained locking.
  - No null keys/values.
- **Use Case**: Concurrent key-value mappings (e.g., LeetCode #146 LRU Cache with thread safety).

---

## 6. Conclusion
Each implementation in the Java Collections Framework is tailored to specific use cases, leveraging distinct data structures (arrays, linked lists, trees, hash tables) and mechanisms (resizing, balancing, hashing/rehashing). Understanding these low-level details—node structures, storage processes, and resizing/balancing strategies—enables efficient use in DSA problems and real-world applications. For example, `HashSet` and `HashMap` optimize for fast lookups via hashing, `TreeSet` and `TreeMap` ensure sorted order via red-black trees, and `ArrayList` and `ArrayDeque` provide efficient array-based access. Thread-safe options like `ConcurrentHashMap` and `CopyOnWriteArrayList` cater to concurrent environments, while legacy classes like `Vector` and `Hashtable` remain relevant for older systems.