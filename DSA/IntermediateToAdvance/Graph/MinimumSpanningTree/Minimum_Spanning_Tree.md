# Minimum Spanning Tree (MST)

## 1. Overview
A Minimum Spanning Tree (MST) is a subset of edges in a weighted, undirected graph that connects all vertices with minimum total edge weight and no cycles.

## 2. Kruskal’s Algorithm
### 2.1 Description
Kruskal’s algorithm builds an MST by selecting edges in increasing order of weight, ensuring no cycles using Union-Find.

- **Use Cases**:
  - Network design (e.g., minimum-cost wiring).
  - Clustering or grouping problems.
- **Algorithm**:
  1. Sort all edges by weight.
  2. Initialize a Union-Find data structure.
  3. Process edges in sorted order:
     - If endpoints are in different components, add edge to MST and union components.
- **Implementation**:
  - Use an array or list of edges.
  - Implement Union-Find with path compression and rank for efficiency.
- **Complexity**:
  - Time: O(E log E) for sorting.
  - Space: O(V + E) for Union-Find and edges.

### 2.2 Java Implementation Notes
- Use `List<int[]>` for edges (u, v, weight).
- Implement Union-Find with parent and rank arrays.
- Sort edges using `Collections.sort` or custom comparator.

## 3. Prim’s Algorithm
### 3.1 Description
Prim’s algorithm builds an MST by greedily adding the minimum-weight edge connecting the current tree to an unvisited vertex.

- **Use Cases**:
  - Same as Kruskal’s (network design, clustering).
  - Preferred for dense graphs or when edges are not explicitly sorted.
- **Algorithm**:
  1. Start with an arbitrary vertex, mark it visited.
  2. Use a priority queue to select the minimum-weight edge to an unvisited vertex.
  3. Add edge to MST, mark vertex visited, and add its edges to the queue.
- **Implementation**:
  - Use adjacency list for sparse graphs.
  - Use `PriorityQueue` for selecting minimum-weight edges.
- **Complexity**:
  - Time: O((V + E) log V) with a binary heap.
  - Space: O(V) for queue and visited array.

### 3.2 Java Implementation Notes
- Use `List<List<int[]>>` for weighted adjacency list.
- Use `PriorityQueue<int[]>` for (weight, vertex) pairs.
- Track visited vertices and total MST weight.

## 4. Common Pitfalls
- **Disconnected Graphs**: MST exists only for connected graphs.
- **Negative Weights**: Both algorithms handle negative weights correctly.
- **Edge Cases**: Handle single-vertex graphs or graphs with no edges.
- **Sorting in Kruskal’s**: Ensure stable sorting for consistent results.

## 5. Practice Problems
- Kruskal’s: GeeksforGeeks (Minimum Spanning Tree)
- Prim’s: LeetCode #1584 (Min Cost to Connect All Points)
- Codeforces: Problems tagged with "mst"

## 6. Resources
- "Introduction to Algorithms" by Cormen (CLRS)
- GeeksforGeeks: MST Articles
- LeetCode: Graph tag
- YouTube: Tushar Roy, William Fiset

## 7. Conclusion
Kruskal’s and Prim’s algorithms are efficient for finding MSTs in weighted graphs. Kruskal’s is edge-based and uses Union-Find, while Prim’s is vertex-based and uses a priority queue. Practice both to understand their trade-offs and applications.