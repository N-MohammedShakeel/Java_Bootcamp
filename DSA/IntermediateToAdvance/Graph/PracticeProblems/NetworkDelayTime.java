package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.PracticeProblems;

import java.util.*;

public class NetworkDelayTime {
    // LeetCode Link: https://leetcode.com/problems/network-delay-time/
    // Problem Description:
    // Given a network of n nodes and times (directed edges with weights), find the time
    // it takes for a signal to reach all nodes from node k. Return the maximum time or -1
    // if some nodes are unreachable.

    public int networkDelayTime(int[][] times, int n, int k) {
        // Algorithm:
        // 1. Model the network as a directed, weighted graph using adjacency list.
        // 2. Use Dijkstra’s algorithm to find shortest paths from source node k to all nodes.
        // 3. Return the maximum distance among all nodes, or -1 if any node is unreachable.
        // 4. Use priority queue to greedily select the next node with minimum distance.

        // Workflow:
        // - Create adjacency list for directed graph with weights.
        // - Initialize distance array with infinity, set source (k-1) distance to 0.
        // - Use priority queue to store (distance, node) pairs.
        // - Process nodes:
        //   - Pop node with minimum distance.
        //   - Update distances to neighbors if shorter path found.
        // - Find maximum distance, checking for unreachable nodes (distance = INF).
        // - Return max distance or -1 if any node is unreachable.

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list
        for (int[] time : times) {
            adj.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[k - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k - 1}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];
            if (d > dist[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        int maxTime = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE / 2) return -1;
            maxTime = Math.max(maxTime, d);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println("Network delay time: " + solution.networkDelayTime(times, n, k)); // Output: 2
    }
}