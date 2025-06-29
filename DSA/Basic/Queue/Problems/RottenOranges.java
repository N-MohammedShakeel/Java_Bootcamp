package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 8: Rotten Oranges
// Statement: Given a grid of oranges, find the minimum time to rot all fresh oranges.
// Sample Test Cases:
// Input: grid=[[2,1,1],[1,1,0],[0,1,1]] -> Output: 4
// Input: grid=[[0,2]] -> Output: 0
// TC: O(m*n), SC: O(m*n)
class RottenOranges {
    static class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new Cell(i, j));
                if (grid[i][j] == 1) fresh++;
            }
        }
        int time = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cell.x + dx[d], ny = cell.y + dy[d];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new Cell(nx, ny));
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
