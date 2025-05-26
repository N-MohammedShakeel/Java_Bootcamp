# Graphs in Depth: A Guide for DSA Preparation

## 1. What is a Graph?
A graph is a data structure consisting of vertices (nodes) and edges (connections between nodes), used to represent relationships or networks. Graphs are versatile and used in problems involving networks, paths, connectivity, and more.

- **Key Idea**: Model entities as vertices and their relationships as edges, enabling algorithms to solve problems like shortest paths, connectivity, or cycles.
- **Applications**: Social networks, maps, scheduling, network flow, dependency graphs, and more.
- **Types of Graphs**:
  - **Directed vs. Undirected**: Directed graphs (digraphs) have edges with direction (e.g., one-way roads); undirected graphs have bidirectional edges.
  - **Weighted vs. Unweighted**: Weighted graphs have edges with weights (e.g., distances); unweighted graphs have no weights (or weight = 1).
  - **Cyclic vs. Acyclic**: Cyclic graphs contain cycles; acyclic graphs (e.g., DAGs) do not.
  - **Connected vs. Disconnected**: Connected graphs have a path between any pair of vertices; disconnected graphs have isolated components.
  - **Sparse vs. Dense**: Sparse graphs have few edges; dense graphs have many edges.

## 2. Graph Terminology
- **Vertex (Node)**: An entity in the graph.
- **Edge**: A connection between two vertices.
- **Degree**: Number of edges incident to a vertex (in-degree/out-degree for directed graphs).
- **Path**: A sequence of vertices connected by edges.
- **Cycle**: A path that starts and ends at the same vertex.
- **Adjacency**: Two vertices are adjacent if connected by an edge.
- **Connected Component**: A subgraph where all vertices are reachable from each other.
- **Directed Acyclic Graph (DAG)**: A directed graph with no cycles.

## 3. Graph Representations
Graphs can be represented in memory in two primary ways:
### 3.1 Adjacency List
- **Description**: Each vertex stores a list of adjacent vertices (and weights for weighted graphs).
- **Pros**: Space-efficient for sparse graphs (O(V + E)), easy to iterate over neighbors.
- **Cons**: Slower to check if an edge exists (O(degree(v))).
- **Java Example**:
  ```java
  List<Integer>[] adj = new List[V]; // For unweighted graph
  for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
  adj[u].add(v); // Add edge u -> v
  ```

### 3.2 Adjacency Matrix
- **Description**: A V x V matrix where `matrix[u][v] = 1` (or weight) if edge u -> v exists, else 0.
- **Pros**: Fast edge lookup (O(1)), good for dense graphs.
- **Cons**: Uses O(V^2) space, inefficient for sparse graphs.
- **Java Example**:
  ```java
  int[][] matrix = new int[V][V];
  matrix[u][v] = 1; // Add edge u -> v (unweighted)
  matrix[u][v] = weight; // For weighted graph
  ```

## 4. Common Graph Algorithms
### 4.1 Traversal Algorithms
- **Depth-First Search (DFS)**:
  - Explores as far as possible along each branch before backtracking.
  - Uses: Finding connected components, detecting cycles, topological sort.
  - Time: O(V + E) with adjacency list.
  - Space: O(V) for recursion stack.
- **Breadth-First Search (BFS)**:
  - Explores level by level, visiting all neighbors before moving deeper.
  - Uses: Shortest path in unweighted graphs, connected components.
  - Time: O(V + E) with adjacency list.
  - Space: O(V) for queue.

### 4.2 Shortest Path Algorithms
- **Dijkstra’s Algorithm**:
  - Finds shortest paths from a source to all vertices in a weighted graph (non-negative weights).
  - Uses priority queue for greedily selecting the next vertex.
  - Time: O((V + E) log V) with a priority queue.
  - Space: O(V) for distances and queue.
- **Bellman-Ford Algorithm**:
  - Handles negative weights, detects negative cycles.
  - Time: O(V * E).
  - Space: O(V).
- **Floyd-Warshall Algorithm**:
  - Finds shortest paths between all pairs of vertices.
  - Time: O(V^3).
  - Space: O(V^2).

### 4.3 Topological Sort
- Orders vertices in a DAG such that if u -> v exists, u appears before v.
- Uses: Scheduling tasks with dependencies, course prerequisites.
- Time: O(V + E) using DFS or Kahn’s algorithm.
- Space: O(V).

### 4.4 Minimum Spanning Tree (MST)
- **Kruskal’s Algorithm**:
  - Uses Union-Find to build MST by selecting edges in increasing weight order.
  - Time: O(E log E).
  - Space: O(V + E).
- **Prim’s Algorithm**:
  - Builds MST by greedily adding the minimum-weight edge to the current tree.
  - Time: O((V + E) log V) with a priority queue.
  - Space: O(V).

### 4.5 Other Algorithms
- **Union-Find (Disjoint Set Union)**: Detects connected components or cycles.
- **Strongly Connected Components (SCC)**: Kosaraju’s or Tarjan’s algorithm for directed graphs.
- **Network Flow**: Ford-Fulkerson or Edmonds-Karp for max flow/min cut problems.
- **Bipartite Matching**: Hungarian algorithm or max flow for matching problems.

## 5. When to Use Graphs
Use graphs when:
- The problem involves relationships or networks (e.g., social networks, roads, dependencies).
- You need to find paths, cycles, or connectivity.
- The data can be modeled as vertices and edges.
- Common problems:
  - Shortest Path (LeetCode #743)
  - Course Schedule (LeetCode #207)
  - Minimum Spanning Tree (GeeksforGeeks)
  - Flood Fill (LeetCode #733)
  - Network Flow problems (Codeforces).

## 6. Graph Representation in Java
### 6.1 Adjacency List
```java
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
adj.get(u).add(v); // Add edge u -> v
```
For weighted graphs:
```java
List<List<int[]>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
adj.get(u).add(new int[]{v, weight}); // Add edge u -> v with weight
```

### 6.2 Adjacency Matrix
```java
int[][] matrix = new int[V][V];
// For unweighted: matrix[u][v] = 1;
// For weighted: matrix[u][v] = weight;
```

## 7. Time and Space Complexity
- **Adjacency List**:
  - Space: O(V + E)
  - Edge check: O(degree(v))
  - Neighbor iteration: O(degree(v))
- **Adjacency Matrix**:
  - Space: O(V^2)
  - Edge check: O(1)
  - Neighbor iteration: O(V)
- **Algorithms**:
  - DFS/BFS: O(V + E)
  - Dijkstra: O((V + E) log V)
  - Bellman-Ford: O(V * E)
  - Floyd-Warshall: O(V^3)
  - Kruskal/Prim: O(E log E) or O((V + E) log V)

## 8. Common Pitfalls
- **Graph Representation**: Choose adjacency list for sparse graphs, matrix for dense graphs.
- **Cycle Handling**: Ensure algorithms handle cycles correctly (e.g., use visited array in DFS).
- **Edge Cases**: Handle disconnected graphs, self-loops, multiple edges, or empty graphs.
- **Overflow**: Use `long` for distances in weighted graphs to avoid overflow.
- **Directed vs. Undirected**: Add edges correctly (bidirectional for undirected).

## 9. Java-Specific Tips
- Use `ArrayList<List<Integer>>` or `List<int[]>` for adjacency lists.
- Use `int[][]` for adjacency matrices, ensuring proper initialization.
- Use `boolean[]` or `Set<Integer>` for visited tracking in DFS/BFS.
- Use `PriorityQueue` for Dijkstra’s or Prim’s algorithms.
- Handle null/empty inputs and validate vertex indices.

## 10. Practice Problems
1. Course Schedule (LeetCode #207)
2. Network Delay Time (LeetCode #743)
3. Flood Fill (LeetCode #733)
4. Minimum Spanning Tree (GeeksforGeeks)
5. Shortest Path in Binary Matrix (LeetCode #1091)
6. Topological Sort (LeetCode #210)
7. Max Flow (Codeforces problems)

## 11. Resources
- **Books**:
  - "Introduction to Algorithms" by Cormen (CLRS)
  - "Competitive Programming" by Steven Halim
- **Online Platforms**:
  - LeetCode (Graph tag)
  - GeeksforGeeks (Graph section)
  - Codeforces (Graph problems)
- **Tutorials**:
  - GeeksforGeeks Graph Articles
  - LeetCode Discuss for problem-specific solutions
  - YouTube channels like Tushar Roy, William Fiset, or Abdul Bari

## 12. Conclusion
Graphs are a versatile data structure for modeling complex relationships. By mastering graph representations (adjacency list/matrix) and algorithms (DFS, BFS, Dijkstra, etc.), you can solve a wide range of DSA problems. Practice implementing graph algorithms and explore problems on platforms like LeetCode and Codeforces to build proficiency.

Happy coding!