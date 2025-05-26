package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.TraversalAlgorithm;

import java.util.*;

public class ShortestPathBFS {
    private List<List<Integer>> adj;

    public int[] shortestPath(int V, int[][] edges, int source) {
        // Algorithm:
        // 1. Represent the graph using an adjacency list (undirected, unweighted).
        // 2. Use BFS to compute shortest distances from source to all vertices.
        // 3. Maintain a distance array and a queue for BFS.
        // 4. Process vertices level by level, updating distances for unvisited neighbors.

        // Workflow:
        // - Create adjacency list and add edges (bidirectional for undirected graph).
        // - Initialize distance array with infinity, set source distance to 0.
        // - Use a queue to perform BFS:
        //   - Enqueue source vertex.
        //   - While queue is not empty, dequeue a vertex.
        //   - For each unvisited neighbor, set distance = parent distance + 1, enqueue.
        // - Return distance array (unreachable vertices have distance = infinity).

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list (undirected graph)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[source] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            // Explore neighbors
            for (int neighbor : adj.get(v)) {
                if (dist[neighbor] == Integer.MAX_VALUE / 2) { // Unvisited
                    dist[neighbor] = dist[v] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {3, 4}};
        int source = 0;
        ShortestPathBFS solution = new ShortestPathBFS();
        int[] distances = solution.shortestPath(V, edges, source);
        System.out.println("Shortest distances from vertex 0: " + Arrays.toString(distances));
        // Output: [0, 1, 2, 1, 2]
    }
}