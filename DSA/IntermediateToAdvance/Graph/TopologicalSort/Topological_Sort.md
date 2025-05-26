# Topological Sort

## 1. Overview
Topological sort orders the vertices of a Directed Acyclic Graph (DAG) such that if there is an edge u -> v, u appears before v in the ordering. It is used to resolve dependencies in a DAG.

## 2. Description
- **Use Cases**:
  - Scheduling tasks with dependencies (e.g., course prerequisites).
  - Build systems (e.g., compiling dependent modules).
  - Detecting cycles in directed graphs (no valid topological sort if cycle exists).
- **Algorithms**:
  - **DFS-Based**:
    1. Perform DFS, adding vertices to a stack after exploring all neighbors.
    2. Pop stack to get topological order.
  - **Kahn’s Algorithm**:
    1. Compute in-degree of each vertex.
    2. Start with vertices of in-degree 0, add to queue.
    3. Process queue, reducing in-degrees and adding new zero in-degree vertices.
- **Complexity**:
  - Time: O(V + E) for both DFS and Kahn’s.
  - Space: O(V) for stack/queue and visited array.

## 3. Java Implementation Notes
- Use adjacency list for sparse DAGs.
- For DFS, use recursion and a stack to store the order.
- For Kahn’s, use a queue and in-degree array.
- Check for cycles (no valid topological sort if graph has a cycle).

## 4. Common Pitfalls
- **Cycles**: Ensure the graph is a DAG (use cycle detection if needed).
- **Disconnected Graphs**: Process all vertices to handle disconnected components.
- **Edge Cases**: Handle empty graphs or graphs with no edges.

## 5. Practice Problems
- LeetCode #207 (Course Schedule)
- LeetCode #210 (Course Schedule II)
- GeeksforGeeks: Topological Sort
- Codeforces: Problems tagged with "topological sort"

## 6. Resources
- "Introduction to Algorithms" by Cormen (CLRS)
- GeeksforGeeks: Topological Sort Articles
- LeetCode: Graph tag
- YouTube: Tushar Roy, Abdul Bari

## 7. Conclusion
Topological sort is essential for scheduling and dependency resolution in DAGs. Both DFS-based and Kahn’s algorithms are efficient and widely used. Practice problems involving course prerequisites or task scheduling to master this technique.