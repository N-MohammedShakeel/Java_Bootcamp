package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.ShortestPathAlgorithm;

import java.util.*;

public class FloydWarshall {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int[][] floydWarshall(int V, int[][] edges) {
        // Algorithm:
        // 1. Initialize a distance matrix with edge weights (INF for no edge, 0 for diagonal).
        // 2. For each vertex k, update distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j]).
        // 3. Return the distance matrix containing shortest paths between all pairs.

        // Workflow:
        // - Create V x V matrix, initialize with INF.
        // - Set diagonal to 0 and fill edge weights.
        // - For each k (intermediate vertex):
        //   - For each i, j (source, destination):
        //     - Update distance[i][j] if going through k is shorter.
        // - Check for negative cycles (distance[i][i] < 0).
        // - Return distance matrix (INF for unreachable pairs).

        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Initialize with edge weights
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            dist[u][v] = weight;
        }

        // Update distances
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Check for negative cycles
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                throw new IllegalStateException("Graph contains negative cycle");
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1, 5}, {0, 3, 10}, {1, 2, 3}, {2, 3, 1}};
        FloydWarshall solution = new FloydWarshall();
        try {
            int[][] distances = solution.floydWarshall(V, edges);
            System.out.println("All-pairs shortest distances:");
            for (int[] row : distances) {
                System.out.println(Arrays.toString(row));
            }
            // Output: [[0, 5, 8, 9], [INF, 0, 3, 4], [INF, INF, 0, 1], [INF, INF, INF, 0]]
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}