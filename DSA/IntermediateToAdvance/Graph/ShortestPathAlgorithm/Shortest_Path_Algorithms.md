# Shortest Path Algorithms: Dijkstra’s, Bellman-Ford, Floyd-Warshall

## 1. Overview
Shortest path algorithms find the minimum-cost path between vertices in a graph. They vary based on graph properties (e.g., weighted, negative weights, single-source vs. all-pairs).

## 2. Dijkstra’s Algorithm
### 2.1 Description
Dijkstra’s algorithm finds the shortest paths from a single source to all vertices in a weighted graph with non-negative weights. It uses a greedy approach with a priority queue.

- **Use Cases**:
  - Navigation systems (e.g., GPS shortest routes).
  - Network routing protocols.
  - Weighted graph problems (e.g., LeetCode #743).
- **Algorithm**:
  1. Initialize distances with infinity, source distance = 0.
  2. Use a priority queue to select the vertex with minimum distance.
  3. For each neighbor, relax the edge (update distance if shorter path found).
- **Implementation**:
  - Use adjacency list for sparse graphs.
  - Use `PriorityQueue` for selecting minimum distance.
  - Track distances and visited vertices.
- **Complexity**:
  - Time: O((V + E) log V) with a binary heap.
  - Space: O(V) for distances and queue.

### 2.2 Java Implementation Notes
- Use `List<List<int[]>>` for weighted adjacency list.
- Use `PriorityQueue<int[]>` for (distance, vertex) pairs.
- Avoid revisiting vertices with better distances.

## 3. Bellman-Ford Algorithm
### 3.1 Description
Bellman-Ford finds shortest paths from a single source, handling negative weights and detecting negative cycles.

- **Use Cases**:
  - Graphs with negative weights.
  - Detecting negative cycles (e.g., arbitrage in finance).
- **Algorithm**:
  1. Initialize distances with infinity, source distance = 0.
  2. Relax all edges V-1 times.
  3. Check for negative cycles by attempting one more relaxation.
- **Implementation**:
  - Store edges explicitly or use adjacency list.
  - Track distances and iterate over all edges.
- **Complexity**:
  - Time: O(V * E).
  - Space: O(V) for distances.

### 3.2 Java Implementation Notes
- Use array or list to store edges.
- Handle negative weights carefully.
- Return indicator for negative cycles.

## 4. Floyd-Warshall Algorithm
### 4.1 Description
Floyd-Warshall finds shortest paths between all pairs of vertices in a weighted graph, handling negative weights (no negative cycles).

- **Use Cases**:
  - All-pairs shortest paths (e.g., distance matrix in maps).
  - Transitive closure (reachability).
- **Algorithm**:
  1. Initialize a distance matrix with edge weights (infinity for no edge).
  2. For each vertex k, update distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j]).
- **Implementation**:
  - Use adjacency matrix for simplicity.
  - Handle negative weights and detect negative cycles.
- **Complexity**:
  - Time: O(V^3).
  - Space: O(V^2) for distance matrix.

### 4.2 Java Implementation Notes
- Use `int[][]` for distance matrix.
- Initialize diagonal to 0, non-edges to infinity.
- Update matrix in-place or use a copy for clarity.

## 5. Common Pitfalls
- **Negative Weights**: Dijkstra’s fails with negative weights; use Bellman-Ford.
- **Negative Cycles**: Bellman-Ford and Floyd-Warshall can detect them.
- **Sparse vs. Dense Graphs**: Use adjacency list for Dijkstra’s/Bellman-Ford, matrix for Floyd-Warshall.
- **Overflow**: Use `long` for distances in large graphs.

## 6. Practice Problems
- Dijkstra’s: LeetCode #743 (Network Delay Time)
- Bellman-Ford: GeeksforGeeks (Shortest Path with Negative Weights)
- Floyd-Warshall: LeetCode #1334 (Find the City)
- Codeforces: Problems tagged with "shortest paths"

## 7. Resources
- "Introduction to Algorithms" by Cormen (CLRS)
- GeeksforGeeks: Shortest Path Articles
- LeetCode: Graph tag
- YouTube: Abdul Bari, William Fiset

## 8. Conclusion
Shortest path algorithms are essential for pathfinding in weighted graphs. Dijkstra’s is efficient for non-negative weights, Bellman-Ford handles negative weights, and Floyd-Warshall solves all-pairs problems. Practice these algorithms to tackle a wide range of graph problems.