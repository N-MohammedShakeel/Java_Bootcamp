package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.MinimumSpanningTree;

import java.util.*;

public class PrimMST {
    private List<List<int[]>> adj;
    private static final int INF = Integer.MAX_VALUE / 2;

    public int primMST(int V, int[][] edges) {
        // Algorithm:
        // 1. Represent the graph using an adjacency list (vertex, weight pairs).
        // 2. Start with an arbitrary vertex (0), mark it visited.
        // 3. Use a priority queue to select the minimum-weight edge to an unvisited vertex.
        // 4. Add edge to MST, mark vertex visited, and add its edges to the queue.
        // 5. Return total MST weight.

        // Workflow:
        // - Initialize adjacency list and add edges (undirected, weighted).
        // - Initialize visited array and priority queue for (weight, vertex) pairs.
        // - Start with vertex 0, add its edges to queue.
        // - While queue is not empty:
        //   - Pop minimum-weight edge.
        //   - If vertex is unvisited, add weight to MST, mark visited, add its edges.
        // - Check if all vertices are included (V-1 edges).
        // - Return total weight (or indicate failure if disconnected).

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list (undirected graph)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int totalWeight = 0;
        int edgesUsed = 0;

        // Start with vertex 0
        visited[0] = true;
        for (int[] neighbor : adj.get(0)) {
            pq.offer(new int[]{neighbor[1], neighbor[0]}); // {vertex, weight}
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int v = curr[0], weight = curr[1];
            if (visited[v]) continue;

            // Add edge to MST
            visited[v] = true;
            totalWeight += weight;
            edgesUsed++;

            // Add neighbors to queue
            for (int[] neighbor : adj.get(v)) {
                if (!visited[neighbor[0]]) {
                    pq.offer(new int[]{neighbor[0], neighbor[1]});
                }
            }
        }

        // Check if MST is valid
        if (edgesUsed != V - 1) {
            throw new IllegalStateException("Graph is disconnected");
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}};
        PrimMST solution = new PrimMST();
        try {
            int mstWeight = solution.primMST(V, edges);
            System.out.println("Minimum Spanning Tree weight: " + mstWeight); // 19
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}