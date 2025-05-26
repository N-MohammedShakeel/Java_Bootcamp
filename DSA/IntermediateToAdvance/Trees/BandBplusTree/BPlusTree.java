package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.BandBplusTree;

// B+ Tree Implementation
// This file implements a B+ Tree for efficient key storage, with data in leaves and linked leaves.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on database operations.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; testing is embedded in the main method.
// Key Features:
// - Insert: Add key, split nodes if needed.
// - Search: Find key in leaves.
// - Delete: Remove key, merge nodes if underflow.
// - Range Query: Find keys in range using leaf links.
// - Traversal: Level-order and leaf traversal.
// Java-Specific Notes:
// - Uses order m=4 (max 3 keys per node).
// - Arrays for keys/children, linked leaves for range queries.
// - Memory managed by JVM; size is O(n/m).
// HackWithInfy Relevance:
// - Critical for Hard database problems (e.g., LeetCode #1845, #732).
// - Tests understanding of multi-way trees and range queries.
// Structure:
// - Nodes store keys, children (internal) or next leaf (leaves).
// - Leaves hold all keys, linked for sequential access.

import java.util.*;

public class BPlusTree {
    private static class Node {
        int[] keys; // Keys (up to m-1)
        Node[] children; // Children (up to m, internal nodes)
        Node next; // Next leaf (for leaves)
        int size; // Number of keys
        boolean isLeaf; // True for leaf nodes

        Node(boolean isLeaf, int order) {
            this.isLeaf = isLeaf;
            this.keys = new int[order - 1];
            this.children = isLeaf ? null : new Node[order];
            this.next = null;
            this.size = 0;
        }
    }

    private Node root;
    private final int order; // Maximum pointers
    private final int minKey; // Minimum keys (ceiling(order/2) - 1)

    public BPlusTree(int order) {
        this.order = order;
        this.minKey = (order + 1) / 2 - 1;
        this.root = new Node(true, order);
    }

    // Insert
    // Workflow: Add key to leaf, split if overflow.
    // Algorithm:
    // 1. Find leaf using binary search.
    // 2. Insert key, shift others.
    // 3. If overflow, split and propagate.
    // Time Complexity: O(log_m n).
    // Space Complexity: O(1).
    public void insert(int key) {
        if (root.size == order - 1) {
            Node newRoot = new Node(false, order);
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertHelper(root, key);
    }
    private void insertHelper(Node node, int key) {
        if (node.isLeaf) {
            int i = node.size - 1;
            while (i >= 0 && node.keys[i] > key) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.size++;
        } else {
            int i = node.size - 1;
            while (i >= 0 && node.keys[i] > key) i--;
            i++;
            if (node.children[i].size == order - 1) {
                splitChild(node, i);
                if (key > node.keys[i]) i++;
            }
            insertHelper(node.children[i], key);
        }
    }
    private void splitChild(Node parent, int index) {
        Node fullNode = parent.children[index];
        Node newNode = new Node(fullNode.isLeaf, order);
        int mid = fullNode.size / 2;

        // Move upper half to new node
        for (int i = 0; i < fullNode.size - mid - 1; i++) {
            newNode.keys[i] = fullNode.keys[mid + 1 + i];
            newNode.size++;
        }
        if (!fullNode.isLeaf) {
            for (int i = 0; i < fullNode.size - mid; i++) {
                newNode.children[i] = fullNode.children[mid + 1 + i];
            }
        } else {
            newNode.next = fullNode.next;
            fullNode.next = newNode;
        }
        fullNode.size = mid;

        // Shift parent’s keys/children
        for (int i = parent.size; i > index; i--) {
            parent.keys[i] = parent.keys[i - 1];
            parent.children[i + 1] = parent.children[i];
        }
        parent.keys[index] = fullNode.keys[mid];
        parent.children[index + 1] = newNode;
        parent.size++;
    }

    // Search
    // Workflow: Find key in leaf using binary search.
    // Algorithm:
    // 1. Traverse to leaf based on key comparisons.
    // 2. Binary search in leaf.
    // Time Complexity: O(log_m n).
    // Space Complexity: O(1).
    public boolean search(int key) {
        Node node = root;
        while (true) {
            int i = 0;
            while (i < node.size && key > node.keys[i]) i++;
            if (node.isLeaf) {
                return i < node.size && node.keys[i] == key;
            }
            node = node.children[i];
        }
    }

    // Delete
    // Workflow: Remove key from leaf, merge if underflow.
    // Algorithm:
    // 1. Find leaf, remove key.
    // 2. If underflow, borrow or merge.
    // 3. Propagate merges, adjust root.
    // Time Complexity: O(log_m n).
    // Space Complexity: O(1).
    public void delete(int key) {
        deleteHelper(root, key);
        if (!root.isLeaf && root.size == 0) {
            root = root.children[0];
        }
    }
    private void deleteHelper(Node node, int key) {
        int i = 0;
        while (i < node.size && key > node.keys[i]) i++;
        if (node.isLeaf) {
            if (i < node.size && node.keys[i] == key) {
                for (int j = i; j < node.size - 1; j++) {
                    node.keys[j] = node.keys[j + 1];
                }
                node.size--;
            }
            return;
        }
        if (i < node.size && node.keys[i] == key) {
            // Key in internal node (replace with predecessor)
            Node pred = findPredecessor(node.children[i]);
            node.keys[i] = pred.keys[pred.size - 1];
            deleteHelper(node.children[i], pred.keys[pred.size - 1]);
        } else {
            deleteHelper(node.children[i], key);
        }
        if (node.children[i].size < minKey) {
            fixUnderflow(node, i);
        }
    }
    private Node findPredecessor(Node node) {
        while (!node.isLeaf) node = node.children[node.size];
        return node;
    }
    private void fixUnderflow(Node parent, int index) {
        Node child = parent.children[index];
        Node leftSibling = index > 0 ? parent.children[index - 1] : null;
        Node rightSibling = index < parent.size ? parent.children[index + 1] : null;

        if (leftSibling != null && leftSibling.size > minKey) {
            // Borrow from left
            for (int j = child.size; j > 0; j--) {
                child.keys[j] = child.keys[j - 1];
            }
            if (!child.isLeaf) {
                for (int j = child.size + 1; j > 0; j--) {
                    child.children[j] = child.children[j - 1];
                }
            }
            child.keys[0] = parent.keys[index - 1];
            parent.keys[index - 1] = leftSibling.keys[leftSibling.size - 1];
            if (!child.isLeaf) {
                child.children[0] = leftSibling.children[leftSibling.size];
            }
            child.size++;
            leftSibling.size--;
        } else if (rightSibling != null && rightSibling.size > minKey) {
            // Borrow from right
            child.keys[child.size] = parent.keys[index];
            parent.keys[index] = rightSibling.keys[0];
            if (!child.isLeaf) {
                child.children[child.size + 1] = rightSibling.children[0];
            }
            for (int j = 0; j < rightSibling.size - 1; j++) {
                rightSibling.keys[j] = rightSibling.keys[j + 1];
            }
            if (!rightSibling.isLeaf) {
                for (int j = 0; j < rightSibling.size; j++) {
                    rightSibling.children[j] = rightSibling.children[j + 1];
                }
            }
            child.size++;
            rightSibling.size--;
        } else {
            // Merge
            if (leftSibling != null) {
                mergeNodes(parent, index - 1, leftSibling, child);
            } else {
                mergeNodes(parent, index, child, rightSibling);
            }
        }
    }
    private void mergeNodes(Node parent, int index, Node left, Node right) {
        left.keys[left.size] = parent.keys[index];
        for (int i = 0; i < right.size; i++) {
            left.keys[left.size + 1 + i] = right.keys[i];
        }
        if (!left.isLeaf) {
            for (int i = 0; i <= right.size; i++) {
                left.children[left.size + 1 + i] = right.children[i];
            }
        } else {
            left.next = right.next;
        }
        left.size += right.size + 1;
        for (int i = index; i < parent.size - 1; i++) {
            parent.keys[i] = parent.keys[i + 1];
            parent.children[i + 1] = parent.children[i + 2];
        }
        parent.size--;
    }

    // Range Query
    // Workflow: Find keys in [minKey, maxKey] using leaf links.
    // Algorithm:
    // 1. Find leaf with minKey.
    // 2. Follow links until maxKey.
    // Time Complexity: O(log_m n + r).
    // Space Complexity: O(r).
    public List<Integer> rangeQuery(int minKey, int maxKey) {
        List<Integer> results = new ArrayList<>();
        Node node = root;
        while (!node.isLeaf) {
            int i = 0;
            while (i < node.size && minKey > node.keys[i]) i++;
            node = node.children[i];
        }
        while (node != null) {
            for (int i = 0; i < node.size; i++) {
                if (node.keys[i] >= minKey && node.keys[i] <= maxKey) {
                    results.add(node.keys[i]);
                }
                if (node.keys[i] > maxKey) return results;
            }
            node = node.next;
        }
        return results;
    }

    // Level-Order Traversal
    // Workflow: Print nodes level by level.
    // Time Complexity: O(n).
    // Space Complexity: O(m).
    public void levelOrder() {
        System.out.print("Level-Order: ");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                System.out.print(Arrays.toString(Arrays.copyOf(node.keys, node.size)) + " ");
                if (!node.isLeaf) {
                    for (int j = 0; j <= node.size; j++) {
                        queue.offer(node.children[j]);
                    }
                }
            }
        }
        System.out.println();
    }

    // Leaf Traversal
    // Workflow: List all keys via leaf links.
    // Time Complexity: O(n).
    // Space Complexity: O(1).
    public void leafTraversal() {
        System.out.print("Leaf Traversal: ");
        Node node = root;
        while (!node.isLeaf) node = node.children[0];
        while (node != null) {
            for (int i = 0; i < node.size; i++) {
                System.out.print(node.keys[i] + " ");
            }
            node = node.next;
        }
        System.out.println();
    }

    // Debugging: Validate Structure
    // Workflow: Check key order, balance, and leaf links.
    // Time Complexity: O(n).
    public boolean isValidBPlusTree() {
        return validateHelper(root, 0) && checkLeafLinks();
    }
    private boolean validateHelper(Node node, int level) {
        if (node == null) return true;
        if (!node.isLeaf && node.size < minKey && node != root) return false;
        if (node.size > order - 1) return false;
        for (int i = 1; i < node.size; i++) {
            if (node.keys[i - 1] >= node.keys[i]) return false;
        }
        if (!node.isLeaf) {
            for (int i = 0; i <= node.size; i++) {
                if (!validateHelper(node.children[i], level + 1)) return false;
            }
        }
        return true;
    }
    private boolean checkLeafLinks() {
        Node node = root;
        while (!node.isLeaf) node = node.children[0];
        int lastKey = Integer.MIN_VALUE;
        while (node != null) {
            for (int i = 0; i < node.size; i++) {
                if (node.keys[i] <= lastKey) return false;
                lastKey = node.keys[i];
            }
            node = node.next;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("B+ Tree Operations:");
        BPlusTree bpt = new BPlusTree(4); // Order 4 (max 3 keys)
        // Insert: 1, 4, 7, 10, 17, 21, 31, 5
        int[] keys = {1, 4, 7, 10, 17, 21, 31, 5};
        for (int key : keys) {
            bpt.insert(key);
        }
        bpt.levelOrder(); // E.g., [10] [4,7,17] [1,4] [5,7] [10,17] [21,31]
        bpt.leafTraversal(); // 1 4 5 7 10 17 21 31
        System.out.println("Search 7: " + bpt.search(7)); // true
        System.out.println("Search 8: " + bpt.search(8)); // false
        System.out.println("Range [5,17]: " + bpt.rangeQuery(5, 17)); // [5, 7, 10, 17]
        System.out.println("Is Valid: " + bpt.isValidBPlusTree()); // true

        // Delete 7
        bpt.delete(7);
        bpt.leafTraversal(); // 1 4 5 10 17 21 31
        System.out.println("Search 7: " + bpt.search(7)); // false
        System.out.println("Range [5,17]: " + bpt.rangeQuery(5, 17)); // [5, 10, 17]
        System.out.println("Is Valid: " + bpt.isValidBPlusTree()); // true

        // Edge cases
        BPlusTree empty = new BPlusTree(4);
        System.out.println("Empty search 1: " + empty.search(1)); // false
        empty.delete(1); // No error
    }
}