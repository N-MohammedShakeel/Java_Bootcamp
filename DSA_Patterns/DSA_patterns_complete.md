# Complete DSA Patterns for MAANG Placement Preparation

To excel in Data Structures and Algorithms (DSA) interviews at MAANG (Meta, Amazon, Apple, Netflix, Google) companies, mastering problem-solving patterns is essential. Below are 20 DSA patterns that cover nearly all problem types encountered in MAANG interviews, helping you recognize and solve problems efficiently.

---

## Why Focus on DSA Patterns?
MAANG interviews prioritize problem-solving, time/space complexity optimization, and clean code. Recognizing patterns enables you to:
- Quickly identify the right approach.
- Apply reusable techniques across problems.
- Optimize for edge cases and scalability.

---

## 20 DSA Patterns for MAANG Interviews

### 1. Two Pointers
- When to Use: Problems with arrays, strings, or linked lists requiring comparison or manipulation from two ends.
- Key Concepts: Fast/slow pointers, opposite-end pointers, sliding window.
- Example Problems:
  - Container With Most Water (LeetCode #11)
  - 3Sum (LeetCode #15)
  - Remove Duplicates from Sorted Array (LeetCode #26)
  - Valid Palindrome (LeetCode #125)
- Complexity: O(n) time, O(1) or O(n) space.

### 2. Sliding Window
- When to Use: Subarray/substring problems to find a contiguous segment satisfying a condition.
- Key Concepts: Fixed/variable-size windows, tracking window properties (sum, max, min).
- Example Problems:
  - Longest Substring Without Repeating Characters (LeetCode #3)
  - Minimum Window Substring (LeetCode #76)
  - Maximum Sum Subarray of Size K (GeeksforGeeks)
  - Longest Substring with K Distinct Characters
- Complexity: O(n) time, O(k) space (k = window size or hash map size).

### 3. Binary Search
- When to Use: Sorted arrays, matrices, or searching optimal values in monotonic spaces.
- Key Concepts: Divide-and-conquer, halving search space, edge cases.
- Example Problems:
  - Search in Rotated Sorted Array (LeetCode #33)
  - Find First and Last Position of Element in Sorted Array (LeetCode #34)
  - Median of Two Sorted Arrays (LeetCode #4)
  - Find Minimum in Rotated Sorted Array (LeetCode #153)
- Complexity: O(log n) time, O(1) space (iterative).

### 4. Fast and Slow Pointers
- When to Use: Linked list or array problems to detect cycles or find midpoints.
- Key Concepts: Two pointers moving at different speeds (e.g., Floyd’s cycle detection).
- Example Problems:
  - Linked List Cycle (LeetCode #141)
  - Find the Duplicate Number (LeetCode #287)
  - Middle of the Linked List (LeetCode #876)
- Complexity: O(n) time, O(1) space.

### 5. Depth-First Search (DFS)
- When to Use: Graph or tree problems requiring exhaustive exploration of paths.
- Key Concepts: Recursion, backtracking, visited set for graphs.
- Example Problems:
  - Number of Islands (LeetCode #200)
  - Word Search (LeetCode #79)
  - Course Schedule (LeetCode #207)
- Complexity: O(V + E) time (V = vertices, E = edges), O(V) space.

### 6. Breadth-First Search (BFS)
- When to Use: Graph or tree problems needing shortest path or level-order traversal.
- Key Concepts: Queue-based exploration, level-by-level processing.
- Example Problems:
  - Binary Tree Level Order Traversal (LeetCode #102)
  - Word Ladder (LeetCode #127)
  - Shortest Path in Binary Matrix (LeetCode #1091)
- Complexity: O(V + E) time, O(V) space.

### 7. Backtracking
- When to Use: Problems requiring exploration of all possible solutions (e.g., permutations, combinations).
- Key Concepts: Recursive choice exploration, undoing choices.
- Example Problems:
  - Permutations (LeetCode #46)
  - Combination Sum (LeetCode #39)
  - N-Queens (LeetCode #51)
- Complexity: O(n!) time for combinatorial problems, O(n) space.

### 8. Dynamic Programming (DP)
- When to Use: Optimization or counting problems with overlapping subproblems.
- Key Concepts: Memoization, tabulation, state transitions.
- Example Problems:
  - Longest Common Subsequence (LeetCode #1143)
  - Knapsack Problem (GeeksforGeeks)
  - House Robber (LeetCode #198)
- Complexity: Varies (e.g., O(n^2) for 2D DP, O(n) space).

### 9. Greedy
- When to Use: Optimization problems where local optimal choices lead to global optima.
- Key Concepts: Sorting, priority-based selection.
- Example Problems:
  - Jump Game (LeetCode #55)
  - Minimum Number of Arrows to Burst Balloons (LeetCode #452)
  - Task Scheduler (LeetCode #621)
- Complexity: O(n log n) time (if sorting), O(1) or O(n) space.

### 10. Divide and Conquer
- When to Use: Problems that can be broken into smaller, independent subproblems.
- Key Concepts: Recursive division, merging results.
- Example Problems:
  - Merge Sort (GeeksforGeeks)
  - Closest Pair of Points (GeeksforGeeks)
  - Merge K Sorted Lists (LeetCode #23)
- Complexity: Varies (e.g., O(n log n) for merge sort), O(log n) or O(n) space.

### 11. Hashing
- When to Use: Problems requiring fast lookups, frequency counting, or duplicate detection.
- Key Concepts: Hash maps/sets for O(1) access, collision handling.
- Example Problems:
  - Two Sum (LeetCode #1)
  - Group Anagrams (LeetCode #49)
  - Subarray Sum Equals K (LeetCode #560)
- Complexity: O(n) time, O(n) space.

### 12. Graph Algorithms
- When to Use: Problems involving complex relationships (e.g., shortest paths, connectivity).
- Key Concepts: Adjacency lists, Dijkstra’s, Kruskal’s, Union-Find.
- Example Problems:
  - Course Schedule II (LeetCode #210)
  - Minimum Spanning Tree (GeeksforGeeks)
  - Network Delay Time (LeetCode #743)
- Complexity: Varies (e.g., O(E log V) for Dijkstra’s), O(V) or O(E) space.

### 13. Bit Manipulation
- When to Use: Problems involving binary operations or low-level data manipulation.
- Key Concepts: Bitwise AND, OR, XOR, shifts.
- Example Problems:
  - Single Number (LeetCode #136)
  - Number of 1 Bits (LeetCode #191)
  - Reverse Bits (LeetCode #190)
- Complexity: O(1) or O(log n) time, O(1) space.

### 14. Prefix Sum
- When to Use: Array problems needing cumulative sums or differences for optimized queries.
- Key Concepts: Precompute prefix sums for range-based queries.
- Example Problems:
  - Subarray Sum Equals K (LeetCode #560)
  - Range Sum Query - Immutable (LeetCode #303)
  - Continuous Subarray Sum (LeetCode #523)
- Complexity: O(n) preprocessing, O(1) per query, O(n) space.

### 15. Monotonic Stack/Queue
- When to Use: Problems tracking next greater/smaller elements or maintaining monotonic properties.
- Key Concepts: Stack/queue maintaining increasing/decreasing order.
- Example Problems:
  - Next Greater Element I (LeetCode #496)
  - Largest Rectangle in Histogram (LeetCode #84)
  - Trapping Rain Water (LeetCode #42)
- Complexity: O(n) time, O(n) space.

### 16. Trie (Prefix Tree)
- When to Use: String problems involving prefix matching, autocomplete, or dictionary searches.
- Key Concepts: Tree-like structure with nodes representing characters.
- Example Problems:
  - Implement Trie (LeetCode #208)
  - Word Search II (LeetCode #212)
  - Longest Word in Dictionary (LeetCode #720)
- Complexity: O(m) time for operations (m = word length), O(N) space (N = total characters).

### 17. Heap/Priority Queue
- When to Use: Problems needing frequent min/max access or sorted subset maintenance.
- Key Concepts: Min-heap/max-heap for top-k or scheduling.
- Example Problems:
  - Kth Largest Element in an Array (LeetCode #215)
  - Merge K Sorted Lists (LeetCode #23)
  - Top K Frequent Elements (LeetCode #347)
- Complexity: O(log n) for insertions/deletions, O(k log n) for k elements.

### 18. Sweep Line
- When to Use: Interval, event, or geometric problems (e.g., scheduling, overlapping intervals).
- Key Concepts: Process events in sorted order, often with heap/set.
- Example Problems:
  - Meeting Rooms II (LeetCode #253)
  - Merge Intervals (LeetCode #56)
  - Employee Free Time (LeetCode #759)
- Complexity: O(n log n) time due to sorting, O(n) space.

### 19. Segment Tree
- When to Use: Range query problems (e.g., sum, min, max) with frequent updates.
- Key Concepts: Tree-based structure for efficient range queries and updates.
- Example Problems:
  - Range Sum Query - Mutable (LeetCode #307)
  - Count of Smaller Numbers After Self (LeetCode #315)
  - The Skyline Problem (LeetCode #218)
- Complexity: O(n log n) build, O(log n) per query/update, O(n) space.

### 20. Binary Indexed Tree (BIT)/Fenwick Tree
- When to Use: Problems requiring efficient prefix sum updates and queries.
- Key Concepts: Tree-like bit manipulation for cumulative sums.
- Example Problems:
  - Count of Range Sum (LeetCode #327)
  - Reverse Pairs (LeetCode #493)
  - Range Sum Query - Mutable (LeetCode #307)
- Complexity: O(n log n) build, O(log n) per query/update, O(n) space.

---

## Notes
- Some patterns overlap (e.g., Fast and Slow Pointers with Two Pointers, or Heap in Graph Algorithms).
- MAANG interviews often combine patterns (e.g., Sliding Window + Hashing).
- Practice on LeetCode, HackerRank, or GeeksforGeeks, focusing on tagged problems.
- Prioritize core patterns (1-13) for most interviews, and use additional patterns (14-20) for advanced preparation.

This syllabus covers the 20 essential DSA patterns for MAANG interviews. Practice consistently, analyze time/space complexities, and focus on clean, optimized code.