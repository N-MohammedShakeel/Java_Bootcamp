package Java_Bootcamp.DSA.Intermediate.Trees;

// AVL Tree Implementation
// An AVL Tree is a self-balancing BST where the height difference (balance factor) between left and right subtrees is at most 1.
// Key Operations:
// - Insert: Add node and balance if needed (rotations).
// - Rotations: LL, RR, LR, RL to maintain balance.
// Applications: Databases, memory management where balanced trees are needed.
// Java-Specific Notes:
// - Balance factor = height(left) - height(right).
// - Recursive insertion with rotation logic.
// HackWithInfy Relevance: Medium/Hard problems (e.g., balanced tree operations).

public class AVLTree {
    static class AVLNode {
        int data, height;
        AVLNode left, right;
        AVLNode(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    // Get height of a node
    // TC: O(1) - constant access.
    // SC: O(1).
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Get balance factor
    // TC: O(1).
    // SC: O(1).
    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation
    // TC: O(1).
    // SC: O(1).
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // Left rotation
    // TC: O(1).
    // SC: O(1).
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // Insert a node
    // Algorithm: Insert like BST, then balance using rotations.
    // TC: O(log n) - balanced tree height.
    // SC: O(log n) - recursion stack.
    public void insert(int data) {
        root = insertHelper(root, data);
    }
    private AVLNode insertHelper(AVLNode node, int data) {
        if (node == null) return new AVLNode(data);
        if (data < node.data) {
            node.left = insertHelper(node.left, data);
        } else if (data > node.data) {
            node.right = insertHelper(node.right, data);
        } else {
            return node; // Duplicates not allowed
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);
        // LL Case
        if (balance > 1 && data < node.left.data) return rightRotate(node);
        // RR Case
        if (balance < -1 && data > node.right.data) return leftRotate(node);
        // LR Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        int[] values = {10, 20, 30, 40, 50, 25};
        for (int val : values) avl.insert(val);
        // Traversals tested in TreeTraversals.java
    }
}