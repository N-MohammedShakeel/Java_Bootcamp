# PriorityQueue Heap Implementation in Java

This document provides a detailed explanation of the internal implementation of Java's `PriorityQueue`, which uses a **binary heap** (min-heap by default) as its underlying data structure. It includes the core heap algorithms (`heapify-up` and `heapify-down`), a simplified implementation of `PriorityQueue`, and an example demonstrating these algorithms, particularly during `poll` operations. The content is designed for Data Structures and Algorithms (DSA) preparation, aligning with the characteristics and methods of `PriorityQueue` as outlined in the Java Collections Framework.

## 1. Overview of PriorityQueue
- **Purpose**: `PriorityQueue` is a queue implementation that orders elements based on their natural ordering (via `Comparable`) or a custom `Comparator`, ensuring the highest-priority (smallest for min-heap) element is at the head.
- **Internal Implementation**: Uses a **binary min-heap** stored in an array, where each node satisfies the heap property: the parent is less than or equal to its children.
- **Key Operations**:
  - `offer(E e)`: Inserts an element and performs `heapify-up` (O(log n)).
  - `poll()`: Removes and returns the head (root) and performs `heapify-down` (O(log n)).
  - `peek()`: Returns the head without removal (O(1)).
- **Datatypes Supported**: Any reference type implementing `Comparable` or supported by a `Comparator` (e.g., `Integer`, `String`, custom objects). Null elements are not allowed.
- **Relevance**: Essential for DSA problems like Dijkstra’s algorithm, Prim’s algorithm, and finding the kth largest element.

## 2. Binary Heap Structure
A **binary heap** is a complete binary tree satisfying the heap property:
- **Min-Heap**: Parent node value ≤ child node values.
- **Max-Heap**: Parent node value ≥ child node values (achievable in `PriorityQueue` using `Collections.reverseOrder()`).
- **Array Representation**:
  - Elements are stored in an array (`Object[] queue`).
  - For a node at index `i`:
    - Parent: `(i-1)/2`.
    - Left child: `2*i + 1`.
    - Right child: `2*i + 2`.
  - Complete binary tree ensures efficient storage and access (no wasted space).

## 3. Heap Algorithms
The core algorithms maintaining the heap property are **heapify-up** and **heapify-down**:

### 3.1 Heapify-Up
- **Purpose**: Used during `offer` (insertion) to restore the heap property by moving a newly added element up the tree if it is smaller than its parent (for min-heap).
- **Algorithm**:
  1. Add the new element at the end of the array (last leaf).
  2. Compare the element with its parent.
  3. If the element is smaller than its parent, swap them.
  4. Repeat until the element is not smaller than its parent or reaches the root.
- **Time Complexity**: O(log n) (height of the tree).
- **Pseudocode**:
  ```
  heapifyUp(index):
      while index > 0:
          parent = (index - 1) / 2
          if heap[index] < heap[parent]:
              swap(heap[index], heap[parent])
              index = parent
          else:
              break
  ```

### 3.2 Heapify-Down
- **Purpose**: Used during `poll` (removal of root) to restore the heap property by moving the root (replaced by the last leaf) down the tree to its correct position.
- **Algorithm**:
  1. Replace the root with the last element in the array.
  2. Compare the new root with its children.
  3. Swap with the smaller child if the root is larger.
  4. Repeat until the root is not larger than its children or reaches a leaf.
- **Time Complexity**: O(log n).
- **Pseudocode**:
  ```
  heapifyDown(index):
      while hasLeftChild(index):
          smallest = leftChild(index)
          if hasRightChild(index) and heap[rightChild(index)] < heap[smallest]:
              smallest = rightChild(index)
          if heap[index] > heap[smallest]:
              swap(heap[index], heap[smallest])
              index = smallest
          else:
              break
  ```

## 4. Simplified Internal Implementation
Below is a simplified `SimplePriorityQueue` implementation demonstrating a min-heap with `offer`, `poll`, `peek`, and the heapify algorithms. It supports generic types (`Comparable`) and mirrors `PriorityQueue`’s core functionality.

```java
public class SimplePriorityQueue<E extends Comparable<E>> {
    private Object[] queue;
    private int size;
    private final int initialCapacity;

    @SuppressWarnings("unchecked")
    public SimplePriorityQueue(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.queue = new Object[initialCapacity];
        this.size = 0;
    }

    public boolean offer(E element) {
        if (element == null) {
            throw new NullPointerException("Null elements not allowed");
        }
        if (size >= queue.length) {
            resize();
        }
        queue[size] = element;
        heapifyUp(size);
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0) {
            return null;
        }
        E result = (E) queue[0];
        queue[0] = queue[size - 1];
        queue[size - 1] = null;
        size--;
        if (size > 0) {
            heapifyDown(0);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return size == 0 ? null : (E) queue[0];
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            @SuppressWarnings("unchecked")
            E current = (E) queue[index];
            @SuppressWarnings("unchecked")
            E parentElement = (E) queue[parent];
            if (current.compareTo(parentElement) < 0) {
                queue[index] = parentElement;
                queue[parent] = current;
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (2 * index + 1 < size) {
            int smallest = 2 * index + 1; // Left child
            @SuppressWarnings("unchecked")
            E smallestElement = (E) queue[smallest];
            if (2 * index + 2 < size) { // Right child exists
                @SuppressWarnings("unchecked")
                E rightElement = (E) queue[2 * index + 2];
                if (rightElement.compareTo(smallestElement) < 0) {
                    smallest = 2 * index + 2;
                    smallestElement = rightElement;
                }
            }
            @SuppressWarnings("unchecked")
            E current = (E) queue[index];
            if (current.compareTo(smallestElement) > 0) {
                queue[index] = smallestElement;
                queue[smallest] = current;
                index = smallest;
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Object[] newQueue = new Object[queue.length * 2];
        System.arraycopy(queue, 0, newQueue, 0, size);
        queue = newQueue;
    }

    public int size() {
        return size;
    }
}
```

### Explanation of Implementation
- **Structure**: Uses an array (`queue`) to store elements, representing a binary min-heap.
- **Attributes**:
  - `queue`: Array of `Object` (cast to `E`) to store heap elements.
  - `size`: Number of elements in the heap.
  - `initialCapacity`: Initial array size (dynamic resizing doubles capacity).
- **Key Methods**:
  - `offer`: Adds an element at the end and calls `heapifyUp` to restore the heap property.
  - `poll`: Removes the root, replaces it with the last element, and calls `heapifyDown`.
  - `peek`: Returns the root without modification.
  - `heapifyUp`: Moves a new element up the tree to maintain min-heap property.
  - `heapifyDown`: Moves the root down to maintain min-heap property after `poll`.
  - `resize`: Doubles the array size when full.
- **Simplifications**:
  - No custom `Comparator` (uses natural ordering via `Comparable`).
  - Basic resizing (doubles capacity).
  - No iterator or additional methods like `remove(Object)` for simplicity.
  - Null checks to mimic `PriorityQueue`’s null restriction.

## 5. Example Demonstrating Heap Algorithms
Below is an example demonstrating `SimplePriorityQueue` with `offer`, `poll`, and the heapify algorithms, using `Integer` as the datatype.

```java
public class PriorityQueueExample {
    public static void main(String[] args) {
        SimplePriorityQueue<Integer> pq = new SimplePriorityQueue<>(4);

        // Insert elements (triggers heapify-up)
        System.out.println("Offering elements: 5, 2, 7, 1");
        pq.offer(5); // Heap: [5]
        pq.offer(2); // Heap: [2, 5] (heapify-up swaps 2 with 5)
        pq.offer(7); // Heap: [2, 5, 7]
        pq.offer(1); // Heap: [1, 2, 7, 5] (heapify-up moves 1 to root)

        System.out.println("Heap after inserts (peek): " + pq.peek()); // Output: 1

        // Remove elements (triggers heapify-down)
        System.out.println("Polling elements:");
        System.out.println("Poll: " + pq.poll()); // Removes 1, last element (5) to root
        // Heap: [5, 2, 7] -> heapify-down swaps 5 with 2 -> [2, 5, 7]
        System.out.println("Poll: " + pq.poll()); // Removes 2, last element (7) to root
        // Heap: [7, 5] -> heapify-down swaps 7 with 5 -> [5, 7]
        System.out.println("Poll: " + pq.poll()); // Removes 5, last element (7) to root
        // Heap: [7]
        System.out.println("Poll: " + pq.poll()); // Removes 7, heap empty
        // Heap: []
        System.out.println("Poll empty: " + pq.poll()); // Output: null
    }
}
```

### Output
```
Offering elements: 5, 2, 7, 1
Heap after inserts (peek): 1
Polling elements:
Poll: 1
Poll: 2
Poll: 5
Poll: 7
Poll empty: null
```

### Explanation of Example
- **Offer (Heapify-Up)**:
  - Inserting 5: Placed at index 0, no swaps.
  - Inserting 2: Placed at index 1, swaps with 5 (parent) to become root.
  - Inserting 7: Placed at index 2, no swaps (7 > 2).
  - Inserting 1: Placed at index 3, swaps with 2 (parent) to become root.
- **Poll (Heapify-Down)**:
  - Polling 1: Replace root with last element (5), heapify-down swaps 5 with 2.
  - Polling 2: Replace root with last element (7), heapify-down swaps 7 with 5.
  - Polling 5: Replace root with last element (7), no swaps.
  - Polling 7: Heap empty, returns null.
- **Heap Visualization** (after each `offer`):
  ```
  After offer(5):  [5]
  After offer(2):  [2, 5]
  After offer(7):  [2, 5, 7]
  After offer(1):  [1, 2, 7, 5]
  ```
  After `poll` operations, the heap restores the min-heap property each time.

## 6. Heap Algorithms in Context
- **Heapify-Up**:
  - Triggered by `offer` when a new element is added.
  - Ensures the smallest element bubbles up to the root.
  - Example: Inserting 1 into `[2, 5, 7]` moves 1 to the root via swaps.
- **Heapify-Down**:
  - Triggered by `poll` when the root is removed and replaced by the last element.
  - Ensures the smallest remaining element becomes the root.
  - Example: After polling 1, moving 5 to the root requires heapify-down to swap with 2.
- **Time Complexity**:
  - Both algorithms are O(log n) due to traversing the height of the binary heap.
  - The heap’s complete binary tree structure ensures height is log n.

## 7. Alignment with PriorityQueue Characteristics
- **Datatypes**: The implementation supports `Comparable` types (e.g., `Integer`, `String`, custom objects), mirroring `PriorityQueue`. Nulls are prohibited.
- **Methods**: Implements core `Queue` methods (`offer`, `poll`, `peek`, `size`) as per the provided guide, with heap-based optimizations.
- **Use Cases**: Suitable for DSA problems like:
  - Finding kth largest/smallest element (e.g., LeetCode #215).
  - Graph algorithms (e.g., Dijkstra’s, Prim’s).
  - Task scheduling with priorities.
- **Limitations**:
  - No `Comparator` support (uses natural ordering).
  - No iterator or additional methods like `remove(Object)` for simplicity.
  - Fixed resizing strategy (doubles capacity).

## 8. Best Practices and Pitfalls
- **Best Practices**:
  - Use generics for type safety (e.g., `PriorityQueue<Integer>`).
  - Specify initial capacity to reduce resizing (e.g., `new PriorityQueue<>(100)`).
  - Ensure elements are `Comparable` or provide a `Comparator`.
  - Use `offer`/`poll` for non-throwing operations.
- **Pitfalls**:
  - Adding null elements throws `NullPointerException`.
  - Non-comparable elements cause `ClassCastException`.
  - Iteration order is not sorted (use `poll` for sorted order).
  - Not thread-safe; use `Collections.synchronizedCollection` for concurrency.

## 9. Conclusion
The `PriorityQueue`’s internal implementation as a binary min-heap enables efficient priority-based processing with O(log n) insertion (`offer`) and removal (`poll`) operations. The `heapify-up` and `heapify-down` algorithms maintain the heap property, ensuring the smallest element is always at the root. This simplified implementation demonstrates these core concepts, making it suitable for understanding `PriorityQueue`’s behavior in DSA contexts.