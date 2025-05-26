package Java_Bootcamp.DSA.IntermediateToAdvance.Trees;

// Binary Search Tree (BST) Implementation
// A BST is a binary tree where left subtree < node < right subtree.
// Key Operations:
// - Insert: Place node in correct position based on value.
// - Search: Find a value efficiently.
// - Delete: Handle three cases (leaf, one child, two children).
// Applications: Efficient searching, sorting (inorder traversal), priority queues.
// Java-Specific Notes:
// - Recursive methods for simplicity; iterative possible for optimization.
// - Deletion requires careful handling of successor.
// HackWithInfy Relevance: Common in Medium problems (e.g., validate BST, LCA).
// LeetCode: https://leetcode.com/problems/validate-binary-search-tree/

public class BinarySearchTree {
    private TreeUtils.BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a node
    // Algorithm: Recursively find correct position based on value.
    // TC: O(h) - h is height (O(log n) balanced, O(n) skewed).
    // SC: O(h) - recursion stack.
    public void insert(int data) {
        root = insertHelper(root, data);
    }
    private TreeUtils.BinaryNode insertHelper(TreeUtils.BinaryNode node, int data) {
        if (node == null) return new TreeUtils.BinaryNode(data);
        if (data < node.data) {
            node.left = insertHelper(node.left, data);
        } else if (data > node.data) {
            node.right = insertHelper(node.right, data);
        }
        return node;
    }

    // Search for a value
    // Algorithm: Recursively compare with node value.
    // TC: O(h) - h is height.
    // SC: O(h) - recursion stack.
    public boolean search(int data) {
        return searchHelper(root, data);
    }
    private boolean searchHelper(TreeUtils.BinaryNode node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        return data < node.data ? searchHelper(node.left, data) : searchHelper(node.right, data);
    }

    // Delete a node
    // Algorithm: Handle leaf, one child, two children cases; use successor for two children.
    // TC: O(h) - h is height.
    // SC: O(h) - recursion stack.
    public void delete(int data) {
        root = deleteHelper(root, data);
    }
    private TreeUtils.BinaryNode deleteHelper(TreeUtils.BinaryNode node, int data) {
        if (node == null) return null;
        if (data < node.data) {
            node.left = deleteHelper(node.left, data);
        } else if (data > node.data) {
            node.right = deleteHelper(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.data = findMin(node.right).data;
            node.right = deleteHelper(node.right, node.data);
        }
        return node;
    }
    private TreeUtils.BinaryNode findMin(TreeUtils.BinaryNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = TreeUtils.createBST();
        System.out.println("Search 60: " + bst.search(60)); // true
        System.out.println("Search 90: " + bst.search(90)); // false
        System.out.println("Deleting 30:");
        bst.delete(30);
        // Traversals tested in TreeTraversals.java
    }
}