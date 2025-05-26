package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.SegmentTree;

// Segment Tree Implementation for Range Sum Queries
// This file implements a Segment Tree to efficiently handle range sum queries and updates on an array.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on range queries.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; input array and testing are embedded in the main method.
// Key Features:
// - Build: Constructs tree from an array, storing sums in nodes.
// - Query: Computes sum of elements in a given range [left, right].
// - Update: Updates an array element and propagates change to tree.
// Use Case: Efficiently answer range sum queries (e.g., sum of elements from index i to j) and update values.
// Java-Specific Notes:
// - Uses array-based tree representation for simplicity.
// - Null checks and bounds validation ensure robustness.
// - Memory managed by JVM; tree size is ~4n for n elements.
// HackWithInfy Relevance:
// - Common in Hard problems involving range queries (e.g., LeetCode #307).
// - Tests understanding of tree structures, recursion, and optimization.
// Structure:
// - Leaf nodes store array elements.
// - Internal nodes store sum of their children’s ranges.
// - Tree is stored in an array: for node at index i, left child at 2*i+1, right child at 2*i+2.

public class SegmentTree {
    private int[] tree; // Array to store segment tree nodes
    private int[] arr;  // Input array
    private int n;      // Size of input array

    // Constructor
    // Initializes segment tree with input array.
    public SegmentTree(int[] input) {
        arr = input;
        n = input.length;
        // Tree size is ~4n to accommodate all nodes (2n leaves, ~2n internal)
        tree = new int[4 * n];
        if (n > 0) {
            build(0, 0, n - 1);
        }
    }

    // Build Segment Tree
    // Workflow: Construct tree by recursively dividing array into ranges and storing sums.
    // Algorithm:
    // 1. For node i covering range [start, end]:
    //    - If start == end, store arr[start] in tree[i].
    //    - Else, divide range into left [start, mid] and right [mid+1, end].
    //    - Recursively build left child (2*i+1) and right child (2*i+2).
    //    - Set tree[i] = sum of left and right children.
    // Time Complexity: O(n) - each node is computed once.
    // Space Complexity: O(n) - tree array size is ~4n.
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node + 1, start, mid);     // Left child
        build(2 * node + 2, mid + 1, end);   // Right child
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Query Range Sum
    // Workflow: Compute sum of elements in array range [left, right].
    // Algorithm:
    // 1. For node i covering [start, end]:
    //    - If [start, end] is fully within [left, right], return tree[i].
    //    - If [start, end] is outside [left, right], return 0.
    //    - Else, recursively query left and right children and sum results.
    // Time Complexity: O(log n) - traverses height of tree.
    // Space Complexity: O(log n) - recursion stack.
    public int query(int left, int right) {
        if (left < 0 || right >= n || left > right) {
            throw new IllegalArgumentException("Invalid query range");
        }
        return queryHelper(0, 0, n - 1, left, right);
    }
    private int queryHelper(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 0; // Outside range
        if (left <= start && right >= end) return tree[node]; // Fully contained
        int mid = start + (end - start) / 2;
        int leftSum = queryHelper(2 * node + 1, start, mid, left, right);
        int rightSum = queryHelper(2 * node + 2, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    // Update Array Element
    // Workflow: Update arr[index] to value and propagate to tree.
    // Algorithm:
    // 1. For node i covering [start, end]:
    //    - If start == end, update tree[i] = value.
    //    - Else, determine if index is in left or right child.
    //    - Recursively update appropriate child.
    //    - Set tree[i] = sum of updated children.
    // Time Complexity: O(log n) - traverses height of tree.
    // Space Complexity: O(log n) - recursion stack.
    public void update(int index, int value) {
        if (index < 0 || index >= n) {
            throw new IllegalArgumentException("Invalid index");
        }
        int diff = value - arr[index];
        arr[index] = value;
        updateHelper(0, 0, n - 1, index, diff);
    }
    private void updateHelper(int node, int start, int end, int index, int diff) {
        if (index < start || index > end) return;
        tree[node] += diff;
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateHelper(2 * node + 1, start, mid, index, diff);
            updateHelper(2 * node + 2, mid + 1, end, index, diff);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Segment Tree
        System.out.println("Segment Tree Operations:");
        // Input array: [1, 3, 5, 7, 9, 11]
        int[] input = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(input);

        // Test queries
        System.out.println("Sum of range [1, 3]: " + st.query(1, 3)); // 3+5+7 = 15
        System.out.println("Sum of range [2, 5]: " + st.query(2, 5)); // 5+7+9+11 = 32

        // Test update
        st.update(2, 10); // Change arr[2] from 5 to 10
        System.out.println("After update arr[2] = 10:");
        System.out.println("Sum of range [1, 3]: " + st.query(1, 3)); // 3+10+7 = 20
        System.out.println("Sum of range [2, 5]: " + st.query(2, 5)); // 10+7+9+11 = 37

        // Test edge cases
        try {
            st.query(0, 6); // Invalid range
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            st.update(6, 5); // Invalid index
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}