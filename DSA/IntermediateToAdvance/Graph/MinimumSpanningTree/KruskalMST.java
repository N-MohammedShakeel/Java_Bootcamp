package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.MinimumSpanningTree;

import java.util.*;

public class KruskalMST {
    private int[] parent;
    private int[] rank;

    // Union-Find: Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union-Find: Union by rank
    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public int kruskalMST(int V, int[][] edges) {
        // Algorithm:
        // 1. Sort edges by weight.
        // 2. Initialize Union-Find with parent and rank arrays.
        // 3. Process edges in increasing weight order:
        //    - If endpoints are in different components, add edge to MST and union components.
        // 4. Return total MST weight.

        // Workflow:
        // - Convert edges to List<int[]> and sort by weight.
        // - Initialize parent (each vertex is its own parent) and rank (0 for all).
        // - Iterate through sorted edges:
        //   - If find(u) != find(v), add edge weight to MST and union(u, v).
        // - Check if MST has V-1 edges (ensures connected graph).
        // - Return total weight (or indicate failure if disconnected).

        List<int[]> edgeList = new ArrayList<>();
        for (int[] edge : edges) {
            edgeList.add(edge);
        }
        // Sort edges by weight
        edgeList.sort((a, b) -> a[2] - b[2]);

        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;
        int edgesUsed = 0;

        // Process edges
        for (int[] edge : edgeList) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (find(u) != find(v)) {
                union(u, v);
                totalWeight += weight;
                edgesUsed++;
            }
        }

        // Check if MST is valid (V-1 edges for connected graph)
        if (edgesUsed != V - 1) {
            throw new IllegalStateException("Graph is disconnected");
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}};
        KruskalMST solution = new KruskalMST();
        try {
            int mstWeight = solution.kruskalMST(V, edges);
            System.out.println("Minimum Spanning Tree weight: " + mstWeight); // 19
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}