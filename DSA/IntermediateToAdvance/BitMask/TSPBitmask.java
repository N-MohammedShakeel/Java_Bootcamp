package Java_Bootcamp.DSA.IntermediateToAdvance.BitMask;

public class TSPBitmask {
    private static int n; // Number of cities
    private static int[][] graph; // Distance matrix
    private static int[][] dp; // Memoization table
    private static final int INF = Integer.MAX_VALUE / 2;

    public static int tsp(int[][] inputGraph) {
        n = inputGraph.length;
        graph = inputGraph;
        dp = new int[n][1 << n];
        // Initialize dp table with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }
        // Start from city 0 with only city 0 visited (mask = 1)
        return solve(0, 1);
    }

    // Algorithm:
    // 1. Use a bitmask to track visited cities (1 for visited, 0 for unvisited).
    // 2. Use dynamic programming with state (curr, mask), where:
    //    - curr: current city
    //    - mask: bitmask representing visited cities
    // 3. Base case: If all cities are visited (mask == (1 << n) - 1), return distance to start city.
    // 4. For each unvisited city, try visiting it, update the mask, and recurse.
    // 5. Memoize results to avoid recomputing for the same (curr, mask) state.

    // Workflow:
    // - Start at city 0 with mask = 1 (only city 0 visited).
    // - For each state (curr, mask):
    //   - If all cities visited, return distance from curr to city 0.
    //   - If memoized, return cached result.
    //   - For each unvisited city i (bit i is 0 in mask):
    //     - Calculate cost = distance[curr][i] + solve(i, mask | (1 << i)).
    //     - Update minimum cost.
    //   - Cache and return the result.
    // - Example: For 4 cities, mask = 5 (binary 0101) means cities 0 and 2 are visited.

    private static int solve(int curr, int mask) {
        // Base case: All cities visited, return to city 0
        if (mask == (1 << n) - 1) {
            return graph[curr][0] == 0 ? INF : graph[curr][0];
        }

        // Check memoized result
        if (dp[curr][mask] != -1) {
            return dp[curr][mask];
        }

        // Try each unvisited city
        int minCost = INF;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0 && graph[curr][i] != 0) { // City i unvisited
                int cost = graph[curr][i] + solve(i, mask | (1 << i));
                minCost = Math.min(minCost, cost);
            }
        }

        // Memoize and return
        return dp[curr][mask] = minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        int minCost = tsp(graph);
        System.out.println("Minimum TSP cost: " + minCost);
    }
}