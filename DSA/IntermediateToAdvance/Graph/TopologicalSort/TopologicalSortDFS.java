package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.TopologicalSort;

import java.util.*;

public class TopologicalSortDFS {
    private List<List<Integer>> adj;
    private boolean[] visited;
    private Stack<Integer> stack;

    public int[] topologicalSort(int V, int[][] edges) {
        // Algorithm:
        // 1. Represent the graph using an adjacency list (directed graph).
        // 2. Use DFS to explore each vertex, adding it to a stack after exploring all neighbors.
        // 3. Pop the stack to get the topological order.
        // 4. Handle disconnected components by processing all vertices.

        // Workflow:
        // - Initialize adjacency list and visited array.
        // - Add edges to adjacency list (directed graph).
        // - For each unvisited vertex, run DFS:
        //   - Mark vertex as visited.
        //   - Recursively visit all unvisited neighbors.
        //   - Add vertex to stack after exploration.
        // - Pop stack to construct topological order.
        // - Return array of vertices in topological order.

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list (directed graph)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        visited = new boolean[V];
        stack = new Stack<>();

        // Process all vertices
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }

        // Convert stack to array
        int[] result = new int[V];
        for (int i = 0; i < V; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private void dfs(int v) {
        // Mark vertex as visited
        visited[v] = true;
        // Explore neighbors
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        // Add vertex to stack after exploring all neighbors
        stack.push(v);
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        TopologicalSortDFS solution = new TopologicalSortDFS();
        int[] order = solution.topologicalSort(V, edges);
        System.out.println("Topological order: " + Arrays.toString(order));
        // Output: [5, 4, 2, 3, 1, 0]
    }
}