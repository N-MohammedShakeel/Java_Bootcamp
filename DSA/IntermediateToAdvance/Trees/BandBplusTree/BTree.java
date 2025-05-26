package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.BandBplusTree;

// B Tree Implementation
// This file implements a B Tree for efficient key storage, with data in all nodes.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on disk-based operations.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; testing is embedded in the main method.
// Key Features:
// - Insert: Add key, split nodes if needed.
// - Search: Find key in any node.
// - Delete: Remove key, merge nodes if underflow.
// - Traversal: Level-order to show structure.
// Java-Specific Notes:
// - Uses order m=4 (max 3 keys per node).
// - Arrays for keys/children, no leaf links (unlike B+ Tree).
// - Memory managed by JVM; size is O(n/m).
// HackWithInfy Relevance:
// - Critical for Hard indexing problems (e.g., LeetCode #1845).
// - Tests understanding of multi-way trees.
// Structure:
// - Nodes store keys and children, data in all nodes.

import java.util.*;

public class BTree {
    private static class Node {
        int[] keys; // Keys (up to m-1)
        Node[] children; // Children (up to m)
        int size; // Number of keys
        boolean isLeaf; // True for leaf nodes

        Node(boolean isLeaf, int order) {
            this.isLeaf = isLeaf;
            this.keys = new int[order - 1];
            this.children = new Node[order];
            this.size = 0;
        }
    }

    private Node root;
    private final int order; // Maximum pointers
    private final int minKey; // Minimum keys (ceiling(order/2) - 1)

    public BTree(int order) {
        this.order = order;
        this.minKey = (order + 1) / 2 - 1;
        this.root = new Node(true, order);
    }

    // Insert
    // Workflow: Add key to appropriate node, split if overflow.
    // Algorithm:
    // 1. Find node for insertion.
    // 2. Insert key, shift others.
    // 3. If overflow, split and promote median.
    // Time Complexity: O(log_m n).
    // Space Complexity: O(1).
    public void insert(int key) {
        if (root.size == order - 1) {
            Node newRoot = new Node(false, order);
            newRoot.children[0] = root;
            root = newRoot;
            splitChild(newRoot, 0);
        }
        insertHelper(root, key);
    }
    private void insertHelper(Node node, int key) {
        int i = node.size - 1;
        if (node.isLeaf) {
            while (i >= 0 && node.keys[i] > key) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.size++;
        } else {
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
    // Workflow: Find key in any node using binary search.
    // Algorithm:
    // 1. Check current node’s keys.
    // 2. Recurse to child if not found.
    // Time Complexity: O(log_m n).
    // Space Complexity: O(1).
    public boolean search(int key) {
        return searchHelper(root, key);
    }
    private boolean searchHelper(Node node, int key) {
        int i = 0;
        while (i < node.size && key > node.keys[i]) i++;
        if (i < node.size && key == node.keys[i]) return true;
        if (node.isLeaf) return false;
        return searchHelper(node.children[i], key);
    }

    // Delete
    // Workflow: Remove key, merge if underflow.
    // Algorithm:
    // 1. Find key’s node.
    // 2. Remove key, rebalance if needed.
    // 3. Adjust root if underflow.
    // Time Complexity: O(log_m n).
    // Space Complexity: O(1).
    public void delete(int key) {
        deleteHelper(root, key);
        if (root.size == 0 && !root.isLeaf) {
            root = root.children[0];
        }
    }
    private void deleteHelper(Node node, int key) {
        int i = 0;
        while (i < node.size && key > node.keys[i]) i++;
        if (i < node.size && key == node.keys[i]) {
            if (node.isLeaf) {
                for (int j = i; j < node.size - 1; j++) {
                    node.keys[j] = node.keys[j + 1];
                }
                node.size--;
            } else {
                Node pred = node.children[i];
                while (!pred.isLeaf) pred = pred.children[pred.size];
                node.keys[i] = pred.keys[pred.size - 1];
                deleteHelper(node.children[i], pred.keys[pred.size - 1]);
            }
        } else if (!node.isLeaf) {
            deleteHelper(node.children[i], key);
        }
        if (!node.isLeaf && i < node.children.length && node.children[i] != null && node.children[i].size < minKey) {
            fixUnderflow(node, i);
        }
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
            child.keys[0] = parent.keys[index - 1];
            parent.keys[index - 1] = leftSibling.keys[leftSibling.size - 1];
            if (!child.isLeaf) {
                for (int j = child.size + 1; j > 0; j--) {
                    child.children[j] = child.children[j - 1];
                }
                child.children[0] = leftSibling.children[leftSibling.size];
            }
            child.size++;
            leftSibling.size--;
        } else if (rightSibling != null && rightSibling.size > minKey) {
            // Borrow from right
            child.keys[child.size] = parent.keys[index];
            parent.keys[index] = rightSibling.keys[0];
            for (int j = 0; j < rightSibling.size - 1; j++) {
                rightSibling.keys[j] = rightSibling.keys[j + 1];
            }
            if (!child.isLeaf) {
                child.children[child.size + 1] = rightSibling.children[0];
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
        }
        left.size += right.size + 1;
        for (int i = index; i < parent.size - 1; i++) {
            parent.keys[i] = parent.keys[i + 1];
            parent.children[i + 1] = parent.children[i + 2];
        }
        parent.size--;
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
                        if (node.children[j] != null) queue.offer(node.children[j]);
                    }
                }
            }
        }
        System.out.println();
    }

    // Debugging: Validate Structure
    // Workflow: Check key order and balance.
    // Time Complexity: O(n).
    public boolean isValidBTree() {
        return validateHelper(root, 0);
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

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("B Tree Operations:");
        BTree bt = new BTree(4); // Order 4 (max 3 keys)
        // Insert: 1, 4, 7, 10, 17, 21, 31, 5
        int[] keys = {1, 4, 7, 10, 17, 21, 31, 5};
        for (int key : keys) {
            bt.insert(key);
        }
        bt.levelOrder(); // E.g., [7,17] [1,4,5] [10] [21,31]
        System.out.println("Search 7: " + bt.search(7)); // true
        System.out.println("Search 8: " + bt.search(8)); // false
        System.out.println("Is Valid: " + bt.isValidBTree()); // true

        // Delete 7
        bt.delete(7);
        bt.levelOrder(); // Adjusted structure
        System.out.println("Search 7: " + bt.search(7)); // false
        System.out.println("Is Valid: " + bt.isValidBTree()); // true

        // Edge cases
        BTree empty = new BTree(4);
        System.out.println("Empty search 1: " + empty.search(1)); // false
        empty.delete(1); // No error
    }
}