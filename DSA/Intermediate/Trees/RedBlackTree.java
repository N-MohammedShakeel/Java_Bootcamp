package Java_Bootcamp.DSA.Intermediate.Trees;

// Red-Black Tree Implementation
// A Red-Black Tree is a self-balancing BST with nodes colored red or black to ensure balance.
// Properties:
// 1. Every node is red or black.
// 2. Root is black.
// 3. All leaves (null) are black.
// 4. Red nodes cannot have red children.
// 5. Every path from root to leaf has same number of black nodes.
// Key Operations:
// - Insert: Add node (red), then fix violations with rotations/recoloring.
// - Rotations: Similar to AVL but with color adjustments.
// Applications: Java’s TreeMap/TreeSet, memory allocators.
// Java-Specific Notes:
// - Complex balancing logic; careful with null checks.
// HackWithInfy Relevance: Hard problems (e.g., advanced tree balancing).

public class RedBlackTree {
    static class RBNode {
        int data;
        boolean isRed;
        RBNode left, right, parent;
        RBNode(int data) {
            this.data = data;
            this.isRed = true;
            this.left = this.right = this.parent = null;
        }
    }

    private RBNode root;
    private static final RBNode NIL = new RBNode(0); // Sentinel null node
    static {
        NIL.isRed = false;
    }

    public RedBlackTree() {
        root = NIL;
    }

    // Left rotation
    // TC: O(1).
    // SC: O(1).
    private void leftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    // Right rotation
    // TC: O(1).
    // SC: O(1).
    private void rightRotate(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null) root = x;
        else if (y == y.parent.right) y.parent.right = x;
        else y.parent.left = x;
        x.right = y;
        y.parent = x;
    }

    // Insert a node
    // Algorithm: Insert like BST, then fix red-black properties.
    // TC: O(log n) - balanced tree height.
    // SC: O(log n) - recursion stack.
    public void insert(int data) {
        RBNode node = new RBNode(data);
        node.left = node.right = NIL;
        RBNode y = null;
        RBNode x = root;
        while (x != NIL) {
            y = x;
            x = data < x.data ? x.left : x.right;
        }
        node.parent = y;
        if (y == null) root = node;
        else if (data < y.data) y.left = node;
        else y.right = node;
        fixInsert(node);
    }
    private void fixInsert(RBNode node) {
        while (node.parent != null && node.parent.isRed) {
            if (node.parent == node.parent.parent.left) {
                RBNode uncle = node.parent.parent.right;
                if (uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rightRotate(node.parent.parent);
                }
            } else {
                RBNode uncle = node.parent.parent.left;
                if (uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    leftRotate(node.parent.parent);
                }
            }
            if (node == root) break;
        }
        root.isRed = false;
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] values = {7, 3, 18, 10, 22, 8, 11};
        for (int val : values) rbt.insert(val);
        // Traversals tested in TreeTraversals.java
    }
}