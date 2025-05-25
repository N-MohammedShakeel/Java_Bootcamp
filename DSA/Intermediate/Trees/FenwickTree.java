package Java_Bootcamp.DSA.Intermediate.Trees;

// Fenwick Tree (Binary Indexed Tree) Implementation
// A Fenwick Tree is used for cumulative frequency queries and updates.
// Key Operations:
// - Update: Add value at index.
// - Query: Get prefix sum up to index.
// Applications: Cumulative sums, frequency tables.
// Java-Specific Notes:
// - Array-based; uses bitwise operations for efficiency.
// - Smaller memory footprint than Segment Tree.
// HackWithInfy Relevance: Hard problems (e.g., dynamic range sums).
// LeetCode: https://leetcode.com/problems/count-of-smaller-numbers-after-self/

public class FenwickTree {
    private int[] bit;
    private int n;

    public FenwickTree(int[] arr) {
        n = arr.length + 1;
        bit = new int[n];
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    // Update value at index
    // Algorithm: Update all affected prefix sums.
    // TC: O(log n).
    // SC: O(1).
    public void update(int index, int delta) {
        index++;
        while (index < n) {
            bit[index] += delta;
            index += index & -index;
        }
    }

    // Query prefix sum up to index
    // Algorithm: Sum relevant nodes using bitwise operations.
    // TC: O(log n).
    // SC: O(1).
    public int query(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = TreeUtils.createArray();
        FenwickTree ft = new FenwickTree(arr);
        System.out.println("Sum [0,3]: " + ft.query(3)); // 16
        ft.update(2, 5);
        System.out.println("Sum [0,3] after update: " + ft.query(3)); // 21
    }
}