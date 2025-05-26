package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.ShortestPathAlgorithm;

import java.util.*;

public class DijkstraShortestPath {
    private List<List<int[]>> adj;
    private static final int INF = Integer.MAX_VALUE / 2;

    public int[] dijkstra(int V, int[][] edges) {
        // Algorithm:
        // 1. Represent the graph using an adjacency list (vertex, weight pairs).
        // 2. Use a priority queue to greedily select the vertex with minimum distance.
        // 3. Maintain a distance array to store shortest distances from source (vertex 0).
        // 4. For each vertex:
        //    - Extract min-distance vertex from the priority queue.
        //    - Update distances to its neighbors if a shorter path is found.

        // Workflow:
        // - Initialize adjacency list and add edges (directed, weighted).
        // - Set source distance to 0, others to infinity.
        // - Add source to priority queue with distance 0.
        // - While queue is not empty:
        //   - Pop vertex with minimum distance.
        //   - For each neighbor, if distance can be reduced, update and add to queue.
        // - Return distance array (unreachable vertices have distance = INF).

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list (directed graph)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[0] = 0; // Source vertex

        // Priority queue: (distance, vertex)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0}); // {distance, vertex}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], v = curr[1];
            // Skip if better distance found
            if (d > dist[v]) continue;

            // Explore neighbors
            for (int[] neighbor : adj.get(v)) {
                int u = neighbor[0], weight = neighbor[1];
                // Relax edge if shorter path found
                if (dist[v] + weight < dist[u]) {
                    dist[u] = dist[v] + weight;
                    pq.offer(new int[]{dist[u], u});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1, 4}, {0, 2, 8}, {1, 2, 2}, {1, 3, 5}, {2, 3, 3}};
        DijkstraShortestPath solution = new DijkstraShortestPath();
        int[] distances = solution.dijkstra(V, edges);
        System.out.println("Shortest distances from vertex 0: " + Arrays.toString(distances)); // [0, 4, 6, 9]
    }
}