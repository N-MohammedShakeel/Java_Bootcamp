package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.FenwickTree;

// Fenwick Tree (Binary Indexed Tree) Implementation for Prefix Sum Queries
// This file implements a Fenwick Tree to efficiently handle prefix sum queries and updates on an array.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on cumulative sums.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; input array and testing are embedded in the main method.
// Key Features:
// - Build: Constructs tree from an array, storing cumulative sums.
// - Query: Computes prefix sum from index 1 to i.
// - Update: Adds a value to an index and updates affected nodes.
// Use Case: Efficiently answer prefix sum queries (e.g., sum from 1 to i) and update values.
// Java-Specific Notes:
// - Uses 1-based indexing for simplicity (tree[0] unused).
// - Bit operations (i & -i) for navigation.
// - Memory managed by JVM; tree size is n+1 for n elements.
// HackWithInfy Relevance:
// - Common in Hard problems involving prefix sums or range queries (e.g., LeetCode #307, #315).
// - Tests understanding of bit manipulation and efficient data structures.
// Structure:
// - Tree array tree[i] stores sum of a range ending at i.
// - Ranges are determined by least significant bit (i & -i).

public class FenwickTree {
    private int[] tree; // Array to store Fenwick Tree
    private int n;      // Size of input array

    // Constructor
    // Initializes Fenwick Tree with input array.
    // Workflow: Build tree by updating each index with array values.
    // Algorithm:
    // 1. Initialize tree array of size n+1 (1-based indexing).
    // 2. For each index i, update tree with arr[i-1].
    // Time Complexity: O(n log n) - each element may update log n nodes.
    // Space Complexity: O(n) - tree array size is n+1.
    public FenwickTree(int[] input) {
        n = input.length;
        tree = new int[n + 1]; // 1-based indexing
        for (int i = 0; i < n; i++) {
            update(i + 1, input[i]);
        }
    }

    // Query Prefix Sum
    // Workflow: Compute sum of elements from index 1 to i.
    // Algorithm:
    // 1. Start at index i.
    // 2. Add tree[i] to result.
    // 3. Move to previous index: i -= (i & -i).
    // 4. Repeat until i = 0.
    // Time Complexity: O(log n) - traverses log n nodes.
    // Space Complexity: O(1) - constant extra space.
    public int query(int index) {
        if (index < 1 || index > n) {
            throw new IllegalArgumentException("Invalid query index");
        }
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= (index & -index); // Remove least significant bit
        }
        return sum;
    }

    // Update Array Element
    // Workflow: Add value to index i and update affected nodes.
    // Algorithm:
    // 1. Start at index i.
    // 2. Add value to tree[i].
    // 3. Move to next index: i += (i & -i).
    // 4. Repeat until i > n.
    // Time Complexity: O(log n) - updates log n nodes.
    // Space Complexity: O(1) - constant extra space.
    public void update(int index, int value) {
        if (index < 1 || index > n) {
            throw new IllegalArgumentException("Invalid update index");
        }
        while (index <= n) {
            tree[index] += value;
            index += (index & -index); // Add least significant bit
        }
    }

    // Range Sum Query (Optional)
    // Workflow: Compute sum from index left to right.
    // Algorithm: Return query(right) - query(left-1).
    // Time Complexity: O(log n) - two prefix queries.
    // Space Complexity: O(1).
    public int rangeSum(int left, int right) {
        if (left < 1 || right > n || left > right) {
            throw new IllegalArgumentException("Invalid range");
        }
        return query(right) - (left > 1 ? query(left - 1) : 0);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Fenwick Tree
        System.out.println("Fenwick Tree Operations:");
        // Input array: [1, 3, 5, 7, 9, 11]
        int[] input = {1, 3, 5, 7, 9, 11};
        FenwickTree ft = new FenwickTree(input);

        // Test prefix sum queries
        System.out.println("Prefix sum to index 3: " + ft.query(3)); // 1+3+5 = 9
        System.out.println("Prefix sum to index 6: " + ft.query(6)); // 1+3+5+7+9+11 = 36

        // Test range sum queries
        System.out.println("Range sum [1, 3]: " + ft.rangeSum(1, 3)); // 1+3+5 = 9
        System.out.println("Range sum [2, 4]: " + ft.rangeSum(2, 4)); // 3+5+7 = 15

        // Test update
        ft.update(2, 2); // Add 2 to index 2 (arr[1] = 3 -> 5)
        System.out.println("After update index 2 by +2:");
        System.out.println("Prefix sum to index 3: " + ft.query(3)); // 1+5+5 = 11
        System.out.println("Range sum [1, 3]: " + ft.rangeSum(1, 3)); // 1+5+5 = 11
        System.out.println("Range sum [2, 4]: " + ft.rangeSum(2, 4)); // 5+5+7 = 17

        // Test edge cases
        try {
            ft.query(7); // Invalid index
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            ft.rangeSum(2, 7); // Invalid range
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}