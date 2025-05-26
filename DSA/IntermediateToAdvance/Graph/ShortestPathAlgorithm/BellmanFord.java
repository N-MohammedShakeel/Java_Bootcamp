package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.ShortestPathAlgorithm;

import java.util.*;

public class BellmanFord {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int[] bellmanFord(int V, int[][] edges, int source) {
        // Algorithm:
        // 1. Store edges explicitly as [u, v, weight].
        // 2. Initialize distances with infinity, source distance = 0.
        // 3. Relax all edges V-1 times to find shortest paths.
        // 4. Check for negative cycles by attempting one more relaxation.
        // 5. Return distances (or indicate negative cycle if needed).

        // Workflow:
        // - Initialize distance array with INF, set source distance to 0.
        // - For V-1 iterations:
        //   - Iterate over all edges and relax (update distance if shorter path found).
        // - Check for negative cycle by attempting one more relaxation.
        // - If any distance can be reduced, a negative cycle exists.
        // - Return distance array (unreachable vertices have distance = INF).

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], weight = edge[2];
                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                throw new IllegalStateException("Graph contains negative cycle");
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}};
        int source = 0;
        BellmanFord solution = new BellmanFord();
        try {
            int[] distances = solution.bellmanFord(V, edges, source);
            System.out.println("Shortest distances from vertex 0: " + Arrays.toString(distances));
            // Output: [0, -1, 2, -2, 1]
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}