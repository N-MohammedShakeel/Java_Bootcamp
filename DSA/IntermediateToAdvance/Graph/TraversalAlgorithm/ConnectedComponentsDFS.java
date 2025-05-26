package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.TraversalAlgorithm;

import java.util.*;

public class ConnectedComponentsDFS {
    private List<List<Integer>> adj;
    private boolean[] visited;
    private int components;

    public int countComponents(int V, int[][] edges) {
        // Algorithm:
        // 1. Represent the graph using an adjacency list for undirected graph.
        // 2. Initialize a visited array to track explored vertices.
        // 3. For each unvisited vertex, run DFS to mark all vertices in its component.
        // 4. Count the number of DFS calls to determine the number of components.

        // Workflow:
        // - Create adjacency list and add edges (bidirectional for undirected graph).
        // - Iterate through all vertices (0 to V-1).
        // - If a vertex is unvisited, call DFS and increment component count.
        // - In DFS:
        //   - Mark current vertex as visited.
        //   - Recursively visit all unvisited neighbors.
        // - Return total number of components.

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list (undirected graph)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[V];
        components = 0;

        // Process each vertex
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v);
                components++;
            }
        }

        return components;
    }

    private void dfs(int v) {
        // Mark vertex as visited
        visited[v] = true;
        // Explore all neighbors
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        ConnectedComponentsDFS solution = new ConnectedComponentsDFS();
        System.out.println("Number of connected components: " + solution.countComponents(V, edges)); // 2
    }
}