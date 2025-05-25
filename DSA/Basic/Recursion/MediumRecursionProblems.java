package Java_Bootcamp.DSA.Basic.Recursion;

import java.util.*;

// Medium Recursion Problems for HackWithInfy Preparation
// These problems build on basic recursion, introducing backtracking, memoization, and tree-like recursion.
// Time and space complexities are provided for each problem.
// Ensure base cases are robust to avoid StackOverflowError in Java.

public class MediumRecursionProblems {
    public static void main(String[] args) {
        // Test cases for medium recursion problems
        System.out.println("1. Power Function (2^5): " + power(2, 5)); // 32
        System.out.println("2. Sum of Digits (123): " + sumOfDigits(123)); // 6
        System.out.println("3. Generate Parentheses (n=3): " + generateParenthesis(3)); // ["((()))","(()())","(())()","()(()","()()()"]
        System.out.println("4. Subsets ([1,2]): " + subsets(new int[]{1, 2})); // [[],[1],[2],[1,2]]
        System.out.println("5. Permutations ([1,2]): " + permute(new int[]{1, 2})); // [[1,2],[2,1]]
        System.out.println("6. Combination Sum ([2,3,6,7], 7): " + combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2,2,3],[7]]
        System.out.println("7. K-th Symbol in Grammar (n=2, k=2): " + kthGrammar(2, 2)); // 1
        System.out.println("8. Tower of Hanoi (n=2):");
        towerOfHanoi(2, 'A', 'C', 'B'); // A->B, A->C, B->C
        System.out.println("9. Binary Tree Paths: " + binaryTreePaths(createTree())); // [1->2->5,1->3]
        System.out.println("10. Fibonacci with Memoization (n=5): " + fibonacciMemo(5)); // 5
    }

    // 1. Power Function (x^n)
    // Approach: Divide-and-conquer; x^n = x^(n/2) * x^(n/2) * (x if n is odd).
    // Time Complexity: O(log n) - halves the problem size each recursion.
    // Space Complexity: O(log n) - call stack depth.
    // LeetCode: https://leetcode.com/problems/powx-n/
    public static double power(double x, int n) {
        if (n == 0) return 1.0; // Base case
        long N = n; // Handle large negative exponents
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double half = power(x, (int)(N / 2));
        return N % 2 == 0 ? half * half : half * half * x;
    }

    // 2. Sum of Digits
    // Approach: Recursively divide by 10 and add last digit.
    // Time Complexity: O(log n) - number of digits.
    // Space Complexity: O(log n) - call stack.
    public static int sumOfDigits(int n) {
        if (n == 0) return 0; // Base case
        return (n % 10) + sumOfDigits(n / 10); // Recursive case
    }

    // 3. Generate Parentheses
    // Approach: Backtrack with open/close counts to generate valid combinations.
    // Time Complexity: O(4^n / sqrt(n)) - Catalan number for valid parentheses.
    // Space Complexity: O(n) - call stack and result storage.
    // LeetCode: https://leetcode.com/problems/generate-parentheses/
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }
    private static void generateParenthesisHelper(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) generateParenthesisHelper(result, current + "(", open + 1, close, n);
        if (close < open) generateParenthesisHelper(result, current + ")", open, close + 1, n);
    }

    // 4. Subsets
    // Approach: Backtrack by including or excluding each element.
    // Time Complexity: O(2^n) - each element has two choices.
    // Space Complexity: O(n) - call stack.
    // LeetCode: https://leetcode.com/problems/subsets/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private static void subsetsHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            subsetsHelper(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    // 5. Permutations
    // Approach: Backtrack by swapping elements to generate all permutations.
    // Time Complexity: O(n!) - all possible permutations.
    // Space Complexity: O(n) - call stack and temporary list.
    // LeetCode: https://leetcode.com/problems/permutations/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }
    private static void permuteHelper(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteHelper(nums, start + 1, result);
            swap(nums, start, i);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 6. Combination Sum
    // Approach: Backtrack to find combinations summing to target.
    // Time Complexity: O(2^t) where t is target (exponential due to choices).
    // Space Complexity: O(t) - call stack and current list.
    // LeetCode: https://leetcode.com/problems/combination-sum/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    private static void combinationSumHelper(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                combinationSumHelper(candidates, i, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    // 7. K-th Symbol in Grammar
    // Approach: Recursively determine k-th symbol based on parent row.
    // Time Complexity: O(n) - recursion depth is n.
    // Space Complexity: O(n) - call stack.
    // LeetCode: https://leetcode.com/problems/k-th-symbol-in-grammar/
    public static int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) return 0; // Base case
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        boolean isOdd = k % 2 == 1;
        if (parent == 0) return isOdd ? 0 : 1;
        return isOdd ? 1 : 0;
    }

    // 8. Tower of Hanoi
    // Approach: Move n-1 disks to auxiliary, move nth to destination, then move n-1 to destination.
    // Time Complexity: O(2^n) - each disk doubles the moves.
    // Space Complexity: O(n) - call stack.
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 0) return; // Base case
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    // 9. Binary Tree Paths
    // Approach: DFS to collect all root-to-leaf paths.
    // Time Complexity: O(n) - visit each node once.
    // Space Complexity: O(h) - call stack, where h is tree height.
    // LeetCode: https://leetcode.com/problems/binary-tree-paths/
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePathsHelper(root, "", result);
        return result;
    }
    private static void binaryTreePathsHelper(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) binaryTreePathsHelper(root.left, path + "->", result);
        if (root.right != null) binaryTreePathsHelper(root.right, path + "->", result);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        return root;
    }

    // 10. Fibonacci with Memoization
    // Approach: Use memoization to cache Fibonacci results.
    // Time Complexity: O(n) - each n computed once.
    // Space Complexity: O(n) - memoization array and call stack.
    public static int fibonacciMemo(int n) {
        int[] memo = new int[n + 1];
        return fibonacciMemoHelper(n, memo);
    }
    private static int fibonacciMemoHelper(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }
}