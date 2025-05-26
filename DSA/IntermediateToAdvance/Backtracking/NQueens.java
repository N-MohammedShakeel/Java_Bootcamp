package Java_Bootcamp.DSA.IntermediateToAdvance.Backtracking;

public class NQueens {
    public static void solveNQueens(int n) {
        int[] queens = new int[n]; // queens[i] = column of queen in row i
        // Start placing queens from row 0
        placeQueens(queens, 0, n);
    }

    // Algorithm:
    // 1. Represent the board as an array where queens[i] is the column position of the queen in row i.
    // 2. For each row, try placing a queen in each column.
    // 3. Check if the placement is safe (no conflicts in columns or diagonals).
    // 4. If safe, place the queen and recurse to the next row.
    // 5. If no valid placement is found, backtrack to the previous row and try a different column.
    // 6. Base case: When all queens are placed (row == n), print the solution.

    // Workflow:
    // - Start with row 0 and an empty board (queens array).
    // - For each column in the current row:
    //   - Check if placing a queen is safe (no conflicts with previous queens).
    //   - If safe, place the queen (set queens[row] = col), recurse to the next row.
    //   - If recursion returns (no solution found), try the next column.
    //   - If no column works, backtrack to the previous row.
    // - When row == n, a valid solution is found; print the board.

    private static void placeQueens(int[] queens, int row, int n) {
        // Base case: All queens placed
        if (row == n) {
            printBoard(queens);
            return;
        }

        // Try each column in the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                // Place queen
                queens[row] = col;
                // Recurse to the next row
                placeQueens(queens, row + 1, n);
                // No need to undo (queens[row] will be overwritten)
            }
        }
    }

    // Check if placing a queen at (row, col) is safe
    private static boolean isSafe(int[] queens, int row, int col) {
        // Check previous rows for conflicts
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];
            // Conflict in column or diagonal
            if (prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    // Print the board
    private static void printBoard(int[] queens) {
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                System.out.print(queens[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);
    }
}