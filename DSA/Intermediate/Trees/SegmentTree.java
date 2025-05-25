package Java_Bootcamp.DSA.Intermediate.Trees;

// Segment Tree Implementation
// A Segment Tree is a binary tree for range queries (e.g., sum, min) and updates.
// Key Operations:
// - Build: Construct tree from array.
// - Query: Get sum in range.
// - Update: Modify a value.
// Applications: Range sum/min/max queries, computational geometry.
// Java-Specific Notes:
// - Array-based implementation for efficiency.
// - 4*n space for tree (conservative estimate).
// HackWithInfy Relevance: Hard problems (e.g., range queries).
// LeetCode: https://leetcode.com/problems/range-sum-query-mutable/

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    // Build segment tree
    // Algorithm: Recursively divide array and store sums.
    // TC: O(n) - visit each node once.
    // SC: O(n) - tree size.
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Query sum in range [left, right]
    // Algorithm: Recursively include relevant segments.
    // TC: O(log n).
    // SC: O(log n) - recursion stack.
    public int query(int left, int right) {
        return queryHelper(0, 0, n - 1, left, right);
    }
    private int queryHelper(int node, int start, int end, int left, int right) {
        if (right < start || left > end) return 0;
        if (left <= start && right >= end) return tree[node];
        int mid = start + (end - start) / 2;
        return queryHelper(2 * node + 1, start, mid, left, right) +
               queryHelper(2 * node + 2, mid + 1, end, left, right);
    }

    // Update value at index
    // Algorithm: Update leaf and propagate to ancestors.
    // TC: O(log n).
    // SC: O(log n) - recursion stack.
    public void update(int index, int value) {
        updateHelper(0, 0, n - 1, index, value);
    }
    private void updateHelper(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            updateHelper(2 * node + 1, start, mid, index, value);
        } else {
            updateHelper(2 * node + 2, mid + 1, end, index, value);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public static void main(String[] args) {
        int[] arr = TreeUtils.createArray();
        SegmentTree st = new SegmentTree(arr);
        System.out.println("Sum [1,3]: " + st.query(1, 3)); // 15
        st.update(2, 10);
        System.out.println("Sum [1,3] after update: " + st.query(1, 3)); // 20
    }
}