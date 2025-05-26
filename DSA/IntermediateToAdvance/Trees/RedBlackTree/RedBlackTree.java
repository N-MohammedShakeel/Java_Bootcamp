package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.RedBlackTree;

// Red-Black Tree Implementation
// This file implements a Red-Black Tree, a self-balancing binary search tree (BST) with red/black node colors.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on balanced BST operations.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; testing is embedded in the main method.
// Key Features:
// - Search: Find a value using BST property.
// - Insert: Add node, balance with rotations/recoloring.
// - Delete: Remove node, fix double-black violations.
// - Traversals: Inorder, Level-Order for verification.
// - Debugging: Validate structure and properties.
// Java-Specific Notes:
// - Uses 1-based indexing for simplicity (tree[0] unused).
// - Null checks and sentinel nodes (NIL) prevent errors.
// - Memory managed by JVM; tree size is O(n).
// HackWithInfy Relevance:
// - Critical for Hard problems involving self-balancing BSTs (e.g., LeetCode #98, #450).
// - Tests understanding of balancing, rotations, and BST operations.
// Structure:
// - Each node has value, color, left/right/parent pointers.
// - NIL nodes (black, null-like) simplify edge cases.
// - Red-Black rules ensure O(log n) height.

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {
    private static class Node {
        int data;
        boolean isRed; // true for red, false for black
        Node left, right, parent;
        Node(int data, boolean isRed) {
            this.data = data;
            this.isRed = isRed;
            this.left = this.right = this.parent = NIL;
        }
    }

    private static final Node NIL = new Node(0, false); // Black sentinel node
    private Node root;

    public RedBlackTree() {
        root = NIL;
    }

    // Search
    // Workflow: Find a value using BST property.
    // Algorithm:
    // 1. Start at root.
    // 2. If node is NIL or value matches, return node.
    // 3. Go left if value is smaller, right if larger.
    // Time Complexity: O(log n) - balanced height.
    // Space Complexity: O(1) - iterative.
    public boolean search(int data) {
        Node current = root;
        while (current != NIL) {
            if (data == current.data) return true;
            current = data < current.data ? current.left : current.right;
        }
        return false;
    }

    // Insert
    // Workflow: Add node as in BST, then fix Red-Black violations.
    // Algorithm:
    // 1. Insert node as red using BST rules.
    // 2. Fix red-red violations with recoloring/rotations.
    // 3. Ensure root is black.
    // Time Complexity: O(log n) - insert plus O(1) fixes.
    // Space Complexity: O(log n) - recursion stack.
    public void insert(int data) {
        Node node = new Node(data, true); // New nodes are red
        Node parent = NIL;
        Node current = root;

        // BST insert
        while (current != NIL) {
            parent = current;
            if (data < current.data) current = current.left;
            else if (data > current.data) current = current.right;
            else return; // Duplicate, ignore
        }

        node.parent = parent;
        if (parent == NIL) {
            root = node;
        } else if (data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        fixInsert(node);
        root.isRed = false; // Root always black
    }

    // Fix Insert Violations
    // Workflow: Resolve red-red conflicts after insertion.
    // Algorithm:
    // - Case 1: Parent and uncle red → Recolor parent, uncle (black), grandparent (red).
    // - Case 2: Parent red, uncle black, node is outer child → Rotate grandparent, swap colors.
    // - Case 3: Parent red, uncle black, node is inner child → Rotate parent, then Case 2.
    // Time Complexity: O(1) - constant rotations/recoloring.
    private void fixInsert(Node node) {
        while (node.parent.isRed) {
            Node parent = node.parent;
            Node grandparent = parent.parent;
            boolean isLeft = parent == grandparent.left;
            Node uncle = isLeft ? grandparent.right : grandparent.left;

            if (uncle.isRed) { // Case 1: Uncle red
                parent.isRed = false;
                uncle.isRed = false;
                grandparent.isRed = true;
                node = grandparent;
            } else { // Uncle black
                if (isLeft) {
                    if (node == parent.right) { // Case 3: Inner child
                        node = parent;
                        rotateLeft(node);
                    }
                    // Case 2: Outer child
                    parent.isRed = false;
                    grandparent.isRed = true;
                    rotateRight(grandparent);
                } else {
                    if (node == parent.left) { // Case 3: Inner child
                        node = parent;
                        rotateRight(node);
                    }
                    // Case 2: Outer child
                    parent.isRed = false;
                    grandparent.isRed = true;
                    rotateLeft(grandparent);
                }
            }
            if (node == root) break;
        }
    }

    // Delete
    // Workflow: Remove node as in BST, then fix double-black violations.
    // Algorithm:
    // 1. Find node to delete.
    // 2. Handle BST deletion (leaf, one child, two children).
    // 3. Fix double-black if deleted node was black.
    // 4. Ensure root is black.
    // Time Complexity: O(log n) - delete plus O(1) fixes.
    // Space Complexity: O(log n) - recursion stack.
    public void delete(int data) {
        Node node = root;
        while (node != NIL && node.data != data) {
            node = data < node.data ? node.left : node.right;
        }
        if (node == NIL) return;

        Node y = node; // Node to delete
        boolean yOriginalColor = y.isRed;
        Node x; // Node replacing y
        Node xParent;

        if (node.left == NIL) {
            x = node.right;
            xParent = node.parent;
            transplant(node, node.right);
        } else if (node.right == NIL) {
            x = node.left;
            xParent = node.parent;
            transplant(node, node.left);
        } else {
            y = findMin(node.right); // Successor
            yOriginalColor = y.isRed;
            x = y.right;
            xParent = y;
            if (y.parent == node) {
                xParent = y;
            } else {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transplant(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.isRed = node.isRed;
        }

        if (!yOriginalColor) { // Fix if deleted node was black
            fixDelete(x, xParent);
        }
        root.isRed = false;
    }

    // Fix Delete Violations
    // Workflow: Resolve double-black issues after deletion.
    // Algorithm:
    // - Case 1: Double-black is root → Done.
    // - Case 2: Sibling red → Recolor, rotate, recurse.
    // - Case 3: Sibling black, children black → Recolor sibling, move double-black up.
    // - Case 4: Sibling black, one red child → Rotate, recolor to fix.
    // Time Complexity: O(1) - constant rotations/recoloring.
    private void fixDelete(Node x, Node xParent) {
        while (x != root && !x.isRed) {
            boolean isLeft = xParent.left == x;
            Node sibling = isLeft ? xParent.right : xParent.left;

            if (sibling.isRed) { // Case 2: Sibling red
                sibling.isRed = false;
                xParent.isRed = true;
                if (isLeft) rotateLeft(xParent);
                else rotateRight(xParent);
                sibling = isLeft ? xParent.right : xParent.left;
            }

            if (!sibling.left.isRed && !sibling.right.isRed) { // Case 3: Sibling black, children black
                sibling.isRed = true;
                x = xParent;
                xParent = x.parent;
            } else { // Case 4: Sibling black, one red child
                if (isLeft && sibling.right.isRed) {
                    sibling.right.isRed = false;
                    sibling.isRed = xParent.isRed;
                    xParent.isRed = false;
                    rotateLeft(xParent);
                } else if (!isLeft && sibling.left.isRed) {
                    sibling.left.isRed = false;
                    sibling.isRed = xParent.isRed;
                    xParent.isRed = false;
                    rotateRight(xParent);
                } else {
                    sibling.isRed = true;
                    xParent.isRed = false;
                    if (isLeft) {
                        sibling.left.isRed = false;
                        rotateRight(sibling);
                        rotateLeft(xParent);
                    } else {
                        sibling.right.isRed = false;
                        rotateLeft(sibling);
                        rotateRight(xParent);
                    }
                }
                x = root;
            }
        }
        x.isRed = false;
    }

    // Transplant (Helper for Delete)
    // Workflow: Replace node u with node v in the tree.
    // Time Complexity: O(1).
    private void transplant(Node u, Node v) {
        if (u.parent == NIL) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    // Find Minimum (Helper for Delete)
    // Workflow: Find smallest node in subtree.
    // Time Complexity: O(log n).
    private Node findMin(Node node) {
        while (node.left != NIL) node = node.left;
        return node;
    }

    // Left Rotation
    // Workflow: Rotate subtree to balance (right child becomes parent).
    // Time Complexity: O(1).
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == NIL) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Right Rotation
    // Workflow: Rotate subtree to balance (left child becomes parent).
    // Time Complexity: O(1).
    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == NIL) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Inorder Traversal
    // Workflow: Print nodes in sorted order (Left, Root, Right).
    // Time Complexity: O(n).
    // Space Complexity: O(log n).
    public void inorder() {
        System.out.print("Inorder: ");
        inorderHelper(root);
        System.out.println();
    }
    private void inorderHelper(Node node) {
        if (node == NIL) return;
        inorderHelper(node.left);
        System.out.print(node.data + (node.isRed ? "(R) " : "(B) "));
        inorderHelper(node.right);
    }

    // Level-Order Traversal
    // Workflow: Print nodes level by level using a queue.
    // Time Complexity: O(n).
    // Space Complexity: O(w) - width of tree.
    public void levelOrder() {
        System.out.print("Level-Order: ");
        if (root == NIL) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + (node.isRed ? "(R) " : "(B) "));
            if (node.left != NIL) queue.offer(node.left);
            if (node.right != NIL) queue.offer(node.right);
        }
        System.out.println();
    }

    // Debugging: Validate Red-Black Properties
    // Workflow: Check BST and Red-Black rules.
    // Time Complexity: O(n).
    public boolean isValidRedBlackTree() {
        if (root.isRed) return false; // Root must be black
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) &&
               checkRedBlackRules(root);
    }
    private boolean checkBST(Node node, int min, int max) {
        if (node == NIL) return true;
        if (node.data <= min || node.data >= max) return false;
        return checkBST(node.left, min, node.data) &&
               checkBST(node.right, node.data, max);
    }
    private boolean checkRedBlackRules(Node node) {
        if (node == NIL) return true;
        if (node.isRed && (node.left.isRed || node.right.isRed)) return false; // No red-red
        int leftBlackHeight = countBlackHeight(node.left);
        int rightBlackHeight = countBlackHeight(node.right);
        return leftBlackHeight == rightBlackHeight && leftBlackHeight != -1 &&
               checkRedBlackRules(node.left) && checkRedBlackRules(node.right);
    }
    private int countBlackHeight(Node node) {
        if (node == NIL) return 1;
        int leftHeight = countBlackHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = countBlackHeight(node.right);
        if (rightHeight == -1 || leftHeight != rightHeight) return -1;
        return leftHeight + (node.isRed ? 0 : 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Red-Black Tree Operations:");
        RedBlackTree rbt = new RedBlackTree();
        // Insert: 10, 5, 15, 3, 7, 20, 12
        int[] values = {10, 5, 15, 3, 7, 20, 12};
        for (int value : values) {
            rbt.insert(value);
        }
        rbt.inorder(); // 3(B) 5(R) 7(B) 10(B) 12(R) 15(B) 20(R)
        rbt.levelOrder(); // 10(B) 5(R) 15(B) 3(B) 7(B) 12(R) 20(R)
        System.out.println("Search 7: " + rbt.search(7)); // true
        System.out.println("Search 8: " + rbt.search(8)); // false
        System.out.println("Is Valid Red-Black Tree: " + rbt.isValidRedBlackTree()); // true

        // Delete 5
        rbt.delete(5);
        rbt.inorder(); // 3(B) 7(R) 10(B) 12(R) 15(B) 20(R)
        rbt.levelOrder(); // 10(B) 3(B) 15(B) 7(R) 12(R) 20(R)
        System.out.println("Is Valid Red-Black Tree: " + rbt.isValidRedBlackTree()); // true

        // Test edge cases
        RedBlackTree empty = new RedBlackTree();
        System.out.println("Empty tree valid: " + empty.isValidRedBlackTree()); // true
        empty.delete(1); // No error
    }
}