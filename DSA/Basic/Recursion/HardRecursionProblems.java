package Java_Bootcamp.DSA.Basic.Recursion;

import java.util.*;

// Hard Recursion Problems for HackWithInfy Preparation
// These problems involve complex backtracking, dynamic programming, and optimization.
// Time and space complexities are provided for each problem.
// Use memoization or pruning to optimize for large inputs.

public class HardRecursionProblems {
    public static void main(String[] args) {
        // Test cases for hard recursion problems
        System.out.println("1. N-Queens (n=4): " + solveNQueens(4)); // [[.Q..,...Q,Q...,..Q.],[..Q.,Q...,...Q,.Q..]]
        System.out.println("2. Sudoku Solver:");
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
        for (char[] row : board) System.out.println(Arrays.toString(row));
        
        System.out.println("3. Word Break II: " + wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))); // [cats and dog, cat sand dog]
        System.out.println("4. Regular Expression Matching: " + isMatch("aab", "c*a*b")); // true
        System.out.println("5. Palindrome Partitioning: " + partition("aab")); // [[a,a,b],[aa,b]]
        System.out.println("6. Unique Paths III: " + uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}})); // 2
        System.out.println("7. Expression Add Operators: " + addOperators("123", 6)); // [1+2+3,1*2*3]
        System.out.println("8. Letter Combinations of a Phone Number: " + letterCombinations("23")); // [ad,ae,af,bd,be,bf,cd,ce,cf]
        System.out.println("9. Word Search: " + exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")); // true
        System.out.println("10. Longest Increasing Path in a Matrix: " + longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}})); // 4
    }

    // 1. N-Queens
    // Approach: Backtrack by placing queens row by row, checking validity.
    // Time Complexity: O(n!) - try all possible placements.
    // Space Complexity: O(n^2) - board and recursion stack.
    // LeetCode: https://leetcode.com/problems/n-queens/
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solveNQueensHelper(board, 0, result);
        return result;
    }
    private static void solveNQueensHelper(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensHelper(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
            if (row - i - 1 >= 0 && col - i - 1 >= 0 && board[row - i - 1][col - i - 1] == 'Q') return false;
            if (row - i - 1 >= 0 && col + i + 1 < board.length && board[row - i - 1][col + i + 1] == 'Q') return false;
        }
        return true;
    }
    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) result.add(new String(row));
        return result;
    }

    // 2. Sudoku Solver
    // Approach: Backtrack by filling cells and checking validity.
    // Time Complexity: O(9^(n*n)) - worst case for 9x9 board.
    // Space Complexity: O(n^2) - recursion stack.
    // LeetCode: https://leetcode.com/problems/sudoku-solver/
    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    private static boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudokuHelper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    // 3. Word Break II
    // Approach: Backtrack with memoization to construct all possible sentences.
    // Time Complexity: O(2^n) - exponential without memoization; O(n^3) with memoization.
    // Space Complexity: O(n) - memoization and recursion stack.
    // LeetCode: https://leetcode.com/problems/word-break-ii/
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, 0, new HashSet<>(wordDict), memo);
    }
    private static List<String> wordBreakHelper(String s, int start, Set<String> wordDict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);
        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
            return result;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                List<String> nextWords = wordBreakHelper(s, end, wordDict, memo);
                for (String next : nextWords) {
                    result.add(word + (next.isEmpty() ? "" : " ") + next);
                }
            }
        }
        memo.put(start, result);
        return result;
    }

    // 4. Regular Expression Matching
    // Approach: Recursive DP to match string with pattern.
    // Time Complexity: O(m*n) - memoized, where m,n are string and pattern lengths.
    // Space Complexity: O(m*n) - memoization table.
    // LeetCode: https://leetcode.com/problems/regular-expression-matching/
    public static boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatchHelper(s, p, 0, 0, memo);
    }
    private static boolean isMatchHelper(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];
        if (j == p.length()) return i == s.length();
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            memo[i][j] = isMatchHelper(s, p, i, j + 2, memo) || (firstMatch && isMatchHelper(s, p, i + 1, j, memo));
        } else {
            memo[i][j] = firstMatch && isMatchHelper(s, p, i + 1, j + 1, memo);
        }
        return memo[i][j];
    }

    // 5. Palindrome Partitioning
    // Approach: Backtrack to find all partitions where each substring is a palindrome.
    // Time Complexity: O(2^n) - try all possible partitions.
    // Space Complexity: O(n) - recursion stack and temp list.
    // LeetCode: https://leetcode.com/problems/palindrome-partitioning/
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result);
        return result;
    }
    private static void partitionHelper(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                partitionHelper(s, end + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    // 6. Unique Paths III
    // Approach: Backtrack to explore all paths from start to end, avoiding obstacles.
    // Time Complexity: O(3^(m*n)) - each cell has up to 3 valid moves (excluding backtracking).
    // Space Complexity: O(m*n) - recursion stack and visited array.
    // LeetCode: https://leetcode.com/problems/unique-paths-iii/
    public static int uniquePathsIII(int[][] grid) {
        int empty = 1, startX = 0, startY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        return uniquePathsIIIHelper(grid, startX, startY, empty);
    }
    private static int uniquePathsIIIHelper(int[][] grid, int x, int y, int empty) {
        if (grid[x][y] == 2) return empty == 0 ? 1 : 0;
        int temp = grid[x][y];
        grid[x][y] = -1; // Mark visited
        int paths = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] != -1) {
                paths += uniquePathsIIIHelper(grid, newX, newY, empty - 1);
            }
        }
        grid[x][y] = temp; // Backtrack
        return paths;
    }

    // 7. Expression Add Operators
    // Approach: Backtrack to try all possible operator placements.
    // Time Complexity: O(4^n) - each digit can have 4 choices (no op, +, -, *).
    // Space Complexity: O(n) - recursion stack and string.
    // LeetCode: https://leetcode.com/problems/expression-add-operators/
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperatorsHelper(num, 0, 0, 0, "", target, result);
        return result;
    }
    private static void addOperatorsHelper(String num, int index, long value, long prev, String expr, int target, List<String> result) {
        if (index == num.length()) {
            if (value == target) result.add(expr);
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break; // Avoid leading zeros
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                addOperatorsHelper(num, i + 1, curr, curr, curr + "", target, result);
            } else {
                addOperatorsHelper(num, i + 1, value + curr, curr, expr + "+" + curr, target, result);
                addOperatorsHelper(num, i + 1, value - curr, -curr, expr + "-" + curr, target, result);
                addOperatorsHelper(num, i + 1, value - prev + prev * curr, prev * curr, expr + "*" + curr, target, result);
            }
        }
    }

    // 8. Letter Combinations of a Phone Number
    // Approach: Backtrack to generate all possible letter combinations.
    // Time Complexity: O(4^n) - each digit can map to up to 4 letters.
    // Space Complexity: O(n) - recursion stack.
    // LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        letterCombinationsHelper(digits, 0, "", mapping, result);
        return result;
    }
    private static void letterCombinationsHelper(String digits, int index, String current, String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            letterCombinationsHelper(digits, index + 1, current + c, mapping, result);
        }
    }

    // 9. Word Search
    // Approach: Backtrack to find word in grid using DFS.
    // Time Complexity: O(m*n*4^w) - explore 4 directions for each cell, w is word length.
    // Space Complexity: O(m*n) - recursion stack and visited array.
    // LeetCode: https://leetcode.com/problems/word-search/
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private static boolean existHelper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = existHelper(board, word, i + 1, j, index + 1) ||
                       existHelper(board, word, i - 1, j, index + 1) ||
                       existHelper(board, word, i, j + 1, index + 1) ||
                       existHelper(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return found;
    }

    // 10. Longest Increasing Path in a Matrix
    // Approach: DFS with memoization to find longest increasing path.
    // Time Complexity: O(m*n) - each cell visited once with memoization.
    // Space Complexity: O(m*n) - memoization table and recursion stack.
    // LeetCode: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, longestIncreasingPathHelper(matrix, i, j, memo));
            }
        }
        return maxLen;
    }
    private static int longestIncreasingPathHelper(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length && matrix[newI][newJ] > matrix[i][j]) {
                max = Math.max(max, 1 + longestIncreasingPathHelper(matrix, newI, newJ, memo));
            }
        }
        memo[i][j] = max;
        return max;
    }
}