package Java_Bootcamp.DSA.IntermediateToAdvance.Backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        // Start solving from the first cell
        solve(board);
    }

    // Algorithm:
    // 1. Iterate through each cell in the 9x9 board.
    // 2. For each empty cell ('.'), try digits 1-9.
    // 3. Check if placing a digit is valid (no conflicts in row, column, or 3x3 sub-box).
    // 4. If valid, place the digit and recurse to the next cell.
    // 5. If recursion fails, backtrack by resetting the cell to '.' and try the next digit.
    // 6. Base case: If all cells are filled (or no empty cells remain), return true.

    // Workflow:
    // - Scan the board row by row, column by column.
    // - For each empty cell (board[row][col] == '.'):
    //   - Try digits '1' to '9'.
    //   - Validate the digit (check row, column, and 3x3 sub-box for conflicts).
    //   - If valid, place the digit, recurse to the next cell.
    //   - If recursion fails, reset the cell to '.' (backtrack) and try the next digit.
    //   - If no digit works, return false to backtrack to the previous cell.
    // - If the entire board is processed without empty cells, a solution is found.

    private static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try digits 1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            // Place the digit
                            board[row][col] = c;
                            // Recurse to the next cell
                            if (solve(board)) {
                                return true;
                            }
                            // Backtrack: Undo the choice
                            board[row][col] = '.';
                        }
                    }
                    // No valid digit found, backtrack
                    return false;
                }
            }
        }
        // All cells filled
        return true;
    }

    // Check if placing digit c at board[row][col] is valid
    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) return false;
            // Check column
            if (board[i][col] == c) return false;
            // Check 3x3 sub-box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        // Print the solved board
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}