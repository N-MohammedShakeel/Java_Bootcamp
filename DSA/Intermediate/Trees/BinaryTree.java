package Java_Bootcamp.DSA.Intermediate.Trees;

// Binary Tree Implementation
// A Binary Tree is a tree where each node has at most two children (left and right).
// Not necessarily ordered (unlike BST).
// Key Operations:
// - Insert: Add a node (level-order for balanced insertion).
// - Search: Find a value.
// - Delete: Remove a node, replacing with deepest node.
// Applications: Expression trees, hierarchical data representation.
// Java-Specific Notes:
// - Uses recursive methods for simplicity; iterative alternatives possible.
// - Memory managed by JVM; nullify references during deletion.
// - StackOverflowError possible for deep trees; ensure proper base cases.
// HackWithInfy Relevance: Common in Easy/Medium problems (e.g., traversals, height).

import java.util.*;

public class BinaryTree {
    // Node class (defined in TreeUtils)
    private TreeUtils.BinaryNode root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Insert a node (level-order)
    // Algorithm: Use queue to find first empty left/right child.
    // TC: O(n) - traverse up to n nodes.
    // SC: O(w) - queue stores max width w.
    public void insert(int data) {
        TreeUtils.BinaryNode newNode = new TreeUtils.BinaryNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<TreeUtils.BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeUtils.BinaryNode current = queue.poll();
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.offer(current.left);
            }
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.offer(current.right);
            }
        }
    }

    // Search for a value
    // Algorithm: Recursively check left and right subtrees.
    // TC: O(n) - may visit all nodes.
    // SC: O(h) - recursion stack, h is height.
    public boolean search(int data) {
        return searchHelper(root, data);
    }
    private boolean searchHelper(TreeUtils.BinaryNode node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        return searchHelper(node.left, data) || searchHelper(node.right, data);
    }

    // Delete a node
    // Algorithm: Replace target with deepest node, then remove deepest.
    // TC: O(n) - find target and deepest node.
    // SC: O(w) - queue for level-order.
    public void delete(int data) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.data == data) root = null;
            return;
        }
        Queue<TreeUtils.BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeUtils.BinaryNode target = null, deepest = null;
        while (!queue.isEmpty()) {
            deepest = queue.poll();
            if (deepest.data == data) target = deepest;
            if (deepest.left != null) queue.offer(deepest.left);
            if (deepest.right != null) queue.offer(deepest.right);
        }
        if (target == null) return;
        target.data = deepest.data;
        deleteDeepest(deepest);
    }
    private void deleteDeepest(TreeUtils.BinaryNode deepest) {
        Queue<TreeUtils.BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeUtils.BinaryNode current = queue.poll();
            if (current.left == deepest) {
                current.left = null;
                return;
            }
            if (current.right == deepest) {
                current.right = null;
                return;
            }
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = TreeUtils.createBinaryTree();
        System.out.println("Search 5: " + tree.search(5)); // true
        System.out.println("Search 8: " + tree.search(8)); // false
        System.out.println("Deleting 2:");
        tree.delete(2);
        // Traversals tested in TreeTraversals.java
    }
}