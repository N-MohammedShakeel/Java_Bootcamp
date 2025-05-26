package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.PracticeProblems;

import java.util.*;

public class ShortestPathBinaryMatrix {
    // LeetCode Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
    // Problem Description:
    // Given an n x n binary matrix grid, return the length of the shortest clear path
    // from top-left (0,0) to bottom-right (n-1,n-1). A clear path consists of cells with
    // value 0, moving 8-directionally. If no path exists, return -1.

    public int shortestPathBinaryMatrix(int[][] grid) {
        // Algorithm:
        // 1. Model the grid as an unweighted graph where each 0 is a vertex, and adjacent 0s are connected.
        // 2. Use BFS to find the shortest path from (0,0) to (n-1,n-1) in terms of cell count.
        // 3. Explore 8 directions (up, down, left, right, diagonals) for each cell.
        // 4. Track visited cells to avoid cycles and return path length or -1 if unreachable.

        // Workflow:
        // - Check if start or end cell is blocked (grid[0][0] or grid[n-1][n-1] is 1).
        // - Initialize a queue with (0,0) and distance 1.
        // - Use visited array to track explored cells.
        // - While queue is not empty:
        //   - Dequeue cell and distance.
        //   - If at (n-1,n-1), return distance.
        //   - Explore 8 directions, enqueue valid unvisited 0s with incremented distance.
        // - Return -1 if no path found.

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // {row, col, distance}
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], dist = curr[2];

            if (row == n - 1 && col == n - 1) return dist;

            // Explore 8 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix solution = new ShortestPathBinaryMatrix();
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println("Shortest path length: " + solution.shortestPathBinaryMatrix(grid)); // Output: 4
    }
}