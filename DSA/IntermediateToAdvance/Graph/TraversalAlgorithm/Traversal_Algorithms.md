# Traversal Algorithms: Depth-First Search (DFS) and Breadth-First Search (BFS)

## 1. Overview
Traversal algorithms explore the vertices and edges of a graph systematically. The two primary methods are Depth-First Search (DFS) and Breadth-First Search (BFS), each suited for different problems based on their exploration strategy.

## 2. Depth-First Search (DFS)
### 2.1 Description
DFS explores as far as possible along a branch before backtracking. It uses a stack (implicit via recursion or explicit) to keep track of vertices to explore.

- **Use Cases**:
  - Finding connected components in an undirected graph.
  - Detecting cycles in directed or undirected graphs.
  - Topological sorting in Directed Acyclic Graphs (DAGs).
  - Pathfinding in mazes or puzzles.
- **Algorithm**:
  1. Start at a vertex, mark it as visited.
  2. Recursively explore each unvisited neighbor.
  3. Backtrack when no unvisited neighbors remain.
- **Implementation**:
  - Use recursion or an explicit stack.
  - Store graph as adjacency list for sparse graphs.
  - Maintain a visited array to avoid revisiting vertices.
- **Complexity**:
  - Time: O(V + E) with adjacency list (V = vertices, E = edges).
  - Space: O(V) for recursion stack and visited array.

### 2.2 Java Implementation Notes
- Use `ArrayList<List<Integer>>` for adjacency list.
- Use `boolean[]` for visited tracking.
- Handle disconnected graphs by running DFS on each unvisited vertex.

## 3. Breadth-First Search (BFS)
### 3.1 Description
BFS explores vertices level by level, visiting all neighbors of a vertex before moving to the next level. It uses a queue to manage exploration order.

- **Use Cases**:
  - Finding shortest paths in unweighted graphs.
  - Finding connected components.
  - Level-order traversal (e.g., social network degrees).
  - Bipartite graph detection.
- **Algorithm**:
  1. Start at a vertex, mark it as visited, and enqueue it.
  2. While queue is not empty:
     - Dequeue a vertex.
     - Process it and enqueue all unvisited neighbors, marking them visited.
- **Implementation**:
  - Use a `Queue` (e.g., `LinkedList` in Java).
  - Store graph as adjacency list.
  - Maintain a visited array or set.
- **Complexity**:
  - Time: O(V + E) with adjacency list.
  - Space: O(V) for queue and visited array.

### 3.2 Java Implementation Notes
- Use `LinkedList` as a queue for BFS.
- Ensure all vertices are processed for disconnected graphs.
- For shortest paths, maintain a distance array.

## 4. Common Pitfalls
- **Cycles**: Use visited array to avoid infinite loops.
- **Disconnected Graphs**: Iterate through all vertices to ensure full coverage.
- **Edge Cases**: Handle empty graphs, single-vertex graphs, or graphs with no edges.
- **Space Efficiency**: Use adjacency list for sparse graphs to reduce memory usage.

## 5. Practice Problems
- DFS: LeetCode #200 (Number of Islands), LeetCode #207 (Course Schedule)
- BFS: LeetCode #1091 (Shortest Path in Binary Matrix), LeetCode #733 (Flood Fill)
- GeeksforGeeks: Connected Components, Cycle Detection
- Codeforces: Problems tagged with "dfs and similar" or "bfs"

## 6. Resources
- "Introduction to Algorithms" by Cormen (CLRS)
- GeeksforGeeks: DFS and BFS Articles
- LeetCode: Graph tag
- YouTube: Tushar Roy, William Fiset

## 7. Conclusion
DFS and BFS are foundational graph traversal algorithms, each with unique strengths. DFS is ideal for deep exploration and problems like cycle detection, while BFS excels at finding shortest paths in unweighted graphs. Mastering both is essential for graph-based DSA problems.