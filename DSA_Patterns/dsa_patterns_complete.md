# Complete 20 DSA Patterns for MAANG Placement Preparation

To excel in Data Structures and Algorithms (DSA) interviews at MAANG (Meta, Amazon, Apple, Netflix, Google) companies, mastering problem-solving patterns is critical. This document outlines 20 DSA patterns, covering nearly all problem types encountered in MAANG interviews. Each pattern includes its use case, key concepts, example problems (including specified LeetCode problems), and typical complexities, tailored for efficient preparation.

---

## Why Focus on DSA Patterns?
MAANG interviews emphasize problem-solving, time/space complexity optimization, and clean code. Recognizing patterns allows you to:
- Quickly identify the right approach.
- Apply reusable techniques across problems.
- Optimize for edge cases and scalability.

---

## 20 DSA Patterns for MAANG Interviews

### 1. Prefix Sum
- **When to Use**: Array problems requiring cumulative sums or differences to optimize range queries or subarray calculations.
- **Key Concepts**: Precompute prefix sums to enable O(1) range queries; useful for sum-based or difference-based problems.
- **Example Problems**:
  - Range Sum Query - Immutable (LeetCode #303)
  - Contiguous Array (LeetCode #525)
  - Subarray Sum Equals K (LeetCode #560)
- **Complexity**: O(n) preprocessing, O(1) per query, O(n) space.

### 2. Two Pointers
- **When to Use**: Problems with arrays, strings, or linked lists involving comparison or manipulation from two ends or within a window.
- **Key Concepts**: Opposite-end pointers, fast/slow pointers, or pointers for partitioning.
- **Example Problems**:
  - Two Sum II - Input Array Is Sorted (LeetCode #167)
  - 3Sum (LeetCode #15)
  - Container With Most Water (LeetCode #11)
- **Complexity**: O(n) time, O(1) or O(n) space.

### 3. Sliding Window
- **When to Use**: Subarray or substring problems to find a contiguous segment satisfying a condition.
- **Key Concepts**: Fixed or variable-size windows, maintaining properties like sum, max, or unique elements.
- **Example Problems**:
  - Maximum Average Subarray I (LeetCode #643)
  - Longest Substring Without Repeating Characters (LeetCode #3)
  - Minimum Window Substring (LeetCode #76)
- **Complexity**: O(n) time, O(k) space (k = window size or hash map size).

### 4. Fast and Slow Pointers
- **When to Use**: Linked list or array problems to detect cycles, find midpoints, or identify duplicates.
- **Key Concepts**: Two pointers moving at different speeds (e.g., Floyd’s cycle detection algorithm).
- **Example Problems**:
  - Linked List Cycle (LeetCode #141)
  - Happy Number (LeetCode #202)
  - Find the Duplicate Number (LeetCode #287)
- **Complexity**: O(n) time, O(1) space.

### 5. Linked List In-Place Reversal
- **When to Use**: Problems requiring reversal of linked list segments or entire lists without extra space.
- **Key Concepts**: Iterative or recursive pointer manipulation to reverse links.
- **Example Problems**:
  - Reverse Linked List (LeetCode #206)
  - Reverse Linked List II (LeetCode #92)
  - Swap Nodes in Pairs (LeetCode #24)
- **Complexity**: O(n) time, O(1) space (iterative) or O(n) space (recursive).

### 6. Monotonic Stack
- **When to Use**: Problems tracking next greater/smaller elements or maintaining monotonic properties.
- **Key Concepts**: Stack maintaining elements in increasing/decreasing order for efficient comparisons.
- **Example Problems**:
  - Next Greater Element I (LeetCode #496)
  - Daily Temperatures (LeetCode #739)
  - Largest Rectangle in Histogram (LeetCode #84)
- **Complexity**: O(n) time, O(n) space.

### 7. Top K Elements
- **When to Use**: Problems requiring the top k largest/smallest or most frequent elements.
- **Key Concepts**: Heap (priority queue) or quickselect for efficient selection.
- **Example Problems**:
  - Kth Largest Element in an Array (LeetCode #215)
  - Top K Frequent Elements (LeetCode #347)
  - Find K Pairs with Smallest Sums (LeetCode #373)
- **Complexity**: O(n log k) with heap, O(n) average with quickselect, O(k) space.

### 8. Overlapping Intervals
- **When to Use**: Problems involving merging, intersecting, or inserting intervals.
- **Key Concepts**: Sorting intervals by start time, then processing overlaps.
- **Example Problems**:
  - Merge Intervals (LeetCode #56)
  - Insert Interval (LeetCode #57)
  - Non-overlapping Intervals (LeetCode #435)
- **Complexity**: O(n log n) time due to sorting, O(n) or O(1) space.

### 9. Modified Binary Search
- **When to Use**: Variations of binary search on sorted or partially sorted arrays (e.g., rotated, nearly sorted, duplicates).
- **Key Concepts**: Adapt binary search for rotated arrays, duplicates, or finding peaks.
- **Example Problems**:
  - Search in Rotated Sorted Array (LeetCode #33)
  - Find Minimum in Rotated Sorted Array (LeetCode #153)
  - Search a 2D Matrix (LeetCode #240)
- **Complexity**: O(log n) time, O(1) space.

### 10. Binary Tree Traversal
- **When to Use**: Tree problems requiring specific traversal orders (preorder, inorder, postorder, level-order).
- **Key Concepts**: Use preorder for top-down, inorder for sorted order, postorder for bottom-up, level-order for BFS.
- **Example Problems**:
  - Binary Tree Paths (LeetCode #257)
  - Kth Smallest Element in a BST (LeetCode #230)
  - Binary Tree Maximum Path Sum (LeetCode #124)
  - Binary Tree Level Order Traversal (LeetCode #107)
- **Complexity**: O(n) time, O(h) space (h = tree height).

### 11. Depth-First Search (DFS)
- **When to Use**: Graph or tree problems requiring exhaustive path exploration.
- **Key Concepts**: Recursion or stack, visited set for graphs to avoid cycles.
- **Example Problems**:
  - Clone Graph (LeetCode #133)
  - Path Sum II (LeetCode #113)
  - Course Schedule II (LeetCode #210)
- **Complexity**: O(V + E) time (V = vertices, E = edges), O(V) space.

### 12. Breadth-First Search (BFS)
- **When to Use**: Graph or tree problems needing shortest path or level-order traversal.
- **Key Concepts**: Queue-based, level-by-level exploration.
- **Example Problems**:
  - Binary Tree Level Order Traversal (LeetCode #102)
  - Rotting Oranges (LeetCode #994)
  - Word Ladder (LeetCode #127)
- **Complexity**: O(V + E) time, O(V) space.

### 13. Matrix Traversal
- **When to Use**: Problems involving 2D matrix exploration (e.g., flood fill, island counting).
- **Key Concepts**: DFS, BFS, or iterative traversal with visited tracking.
- **Example Problems**:
  - Flood Fill (LeetCode #733)
  - Number of Islands (LeetCode #200)
  - Surrounded Regions (LeetCode #130)
- **Complexity**: O(m*n) time (m, n = matrix dimensions), O(m*n) space for DFS/BFS.

### 14. Backtracking
- **When to Use**: Problems exploring all possible solutions (e.g., permutations, combinations).
- **Key Concepts**: Recursive choice exploration, undoing choices.
- **Example Problems**:
  - Permutations (LeetCode #46)
  - Subsets (LeetCode #78)
  - N-Queens (LeetCode #51)
- **Complexity**: O(n!) time for combinatorial problems, O(n) space.

### 15. Dynamic Programming (DP)
- **When to Use**: Optimization or counting problems with overlapping subproblems (e.g., Fibonacci, LCS, LIS, subset sum).
- **Key Concepts**: Memoization or tabulation, state transitions.
- **Example Problems**:
  - Climbing Stairs (LeetCode #70)
  - Longest Increasing Subsequence (LeetCode #300)
  - Coin Change (LeetCode #322)
  - Partition Equal Subset Sum (LeetCode #416)
  - Longest Common Subsequence (LeetCode #1143)
  - Burst Balloons (LeetCode #312)
- **Complexity**: Varies (e.g., O(n^2) for 2D DP, O(n) space).

### 16. Greedy
- **When to Use**: Optimization problems where local optimal choices yield global optima.
- **Key Concepts**: Sorting, priority-based selection, proving greedy choice validity.
- **Example Problems**:
  - Jump Game (LeetCode #55)
  - Minimum Number of Arrows to Burst Balloons (LeetCode #452)
  - Task Scheduler (LeetCode #621)
- **Complexity**: O(n log n) time (if sorting), O(1) or O(n) space.

### 17. Divide and Conquer
- **When to Use**: Problems that can be split into smaller, independent subproblems.
- **Key Concepts**: Recursive division, merging results.
- **Example Problems**:
  - Merge Sort (GeeksforGeeks)
  - Closest Pair of Points (GeeksforGeeks)
  - Merge K Sorted Lists (LeetCode #23)
- **Complexity**: Varies (e.g., O(n log n) for merge sort), O(log n) or O(n) space.

### 18. Hashing
- **When to Use**: Problems needing fast lookups, frequency counting, or duplicate detection.
- **Key Concepts**: Hash maps/sets for O(1) access, handling collisions.
- **Example Problems**:
  - Two Sum (LeetCode #1)
  - Group Anagrams (LeetCode #49)
  - Subarray Sum Equals K (LeetCode #560)
- **Complexity**: O(n) time, O(n) space.

### 19. Bit Manipulation
- **When to Use**: Problems involving binary operations or low-level data manipulation.
- **Key Concepts**: Bitwise AND, OR, XOR, shifts.
- **Example Problems**:
  - Single Number (LeetCode #136)
  - Number of 1 Bits (LeetCode #191)
  - Reverse Bits (LeetCode #190)
- **Complexity**: O(1) or O(log n) time, O(1) space.

### 20. Segment Tree
- **When to Use**: Range query problems (e.g., sum, min, max) with frequent updates.
- **Key Concepts**: Tree-based structure for efficient range queries and updates.
- **Example Problems**:
  - Range Sum Query - Mutable (LeetCode #307)
  - Count of Smaller Numbers After Self (LeetCode #315)
  - The Skyline Problem (LeetCode #218)
- **Complexity**: O(n log n) build, O(log n) per query/update, O(n) space.

---

## Notes
- **Overlaps**: Some patterns are related (e.g., Fast and Slow Pointers with Two Pointers, or Heap in Top K Elements).
- **Combinations**: MAANG problems often combine patterns (e.g., Sliding Window + Hashing, DFS + Backtracking).
- **Practice Strategy**: Use LeetCode, HackerRank, or GeeksforGeeks, focusing on tagged problems. Start with core patterns (1-15) and progress to advanced ones (16-20).
- **Optimization**: Focus on time/space complexity analysis and writing clean, bug-free code.

This syllabus covers the 20 essential DSA patterns for MAANG interviews. Practice consistently, prioritize problem-solving over rote memorization, and ensure familiarity with edge cases and optimizations.