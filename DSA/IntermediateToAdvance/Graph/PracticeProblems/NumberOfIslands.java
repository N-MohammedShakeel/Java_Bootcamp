package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.PracticeProblems;

public class NumberOfIslands {
    // LeetCode Link: https://leetcode.com/problems/number-of-islands/
    // Problem Description:
    // Given an m x n 2D binary grid representing a map of '1's (land) and '0's (water),
    // return the number of islands. An island is surrounded by water and formed by
    // connecting adjacent lands horizontally or vertically.

    public int numIslands(char[][] grid) {
        // Algorithm:
        // 1. Model the grid as a graph where each '1' is a vertex, and adjacent '1's are connected.
        // 2. Use DFS to explore each unvisited '1' and mark its entire island as visited.
        // 3. Count the number of DFS calls to determine the number of islands.
        // 4. Check all grid cells to ensure all islands are found.

        // Workflow:
        // - Create a visited array to track explored cells.
        // - Iterate through each cell in the grid.
        // - If cell is '1' and unvisited, run DFS to mark all connected '1's and increment island count.
        // - In DFS:
        //   - Mark current cell as visited.
        //   - Explore four directions (up, down, left, right) if valid and unvisited '1'.
        // - Return total number of islands.

        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j, m, n);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        // Check boundaries and conditions
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        // Mark as visited
        visited[i][j] = true;

        // Explore four directions
        dfs(grid, visited, i + 1, j, m, n); // Down
        dfs(grid, visited, i - 1, j, m, n); // Up
        dfs(grid, visited, i, j + 1, m, n); // Right
        dfs(grid, visited, i, j - 1, m, n); // Left
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid)); // Output: 3
    }
}