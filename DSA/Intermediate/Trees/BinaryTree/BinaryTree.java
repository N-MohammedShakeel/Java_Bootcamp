package Java_Bootcamp.DSA.Intermediate.Trees.BinaryTree;

// Binary Tree and Binary Search Tree Implementation
// This file implements a Binary Tree and Binary Search Tree (BST) with key operations: insertion, search, deletion, traversals, and debugging.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, covering all binary tree concepts.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// Tree creation is embedded in main method, with no external dependencies.
// Key Features:
// - Binary Tree: Level-order insertion, basic search, deletion.
// - BST: Ordered insertion, efficient search, deletion with successor.
// - Traversals: Inorder, Preorder, Postorder, Level-Order, Morris (space-optimized).
// - Debugging: Methods to validate structure and print tree.
// Java-Specific Notes:
// - Uses recursive methods for simplicity; iterative alternatives included where relevant.
// - Null checks prevent NullPointerException.
// - Memory managed by JVM; ensure proper reference nullification in deletion.
// HackWithInfy Relevance:
// - Covers Easy problems (traversals, height), Medium (BST operations, LCA), and foundations for Hard (balancing).
// - LeetCode: #94 (Inorder), #102 (Level-Order), #98 (Validate BST), #450 (Delete Node).

import java.util.*;

public class BinaryTree {
    // Node class for Binary Tree and BST
    // Stores value and references to left/right children.
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Binary Tree: Insert (Level-Order)
    // Workflow: Add node at the first empty left or right child, level by level, to maintain balance.
    // Algorithm:
    // 1. Create a new node.
    // 2. If tree is empty, set as root.
    // 3. Use a queue to traverse level by level.
    // 4. Attach node to first empty left or right child.
    // Time Complexity: O(n) - may visit all n nodes.
    // Space Complexity: O(w) - queue holds max width w.
    public void insertBinary(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
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

    // BST: Insert
    // Workflow: Add node in correct position based on value (left < parent < right).
    // Algorithm:
    // 1. Start at root.
    // 2. If empty, create new node.
    // 3. Compare value: go left if smaller, right if larger.
    // 4. Recursively insert in appropriate subtree.
    // Time Complexity: O(h) - h is height (O(log n) balanced, O(n) skewed).
    // Space Complexity: O(h) - recursion stack.
    public void insertBST(int data) {
        root = insertBSTHelper(root, data);
    }
    private Node insertBSTHelper(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data) {
            node.left = insertBSTHelper(node.left, data);
        } else if (data > node.data) {
            node.right = insertBSTHelper(node.right, data);
        }
        return node;
    }

    // Search (Binary Tree and BST)
    // Binary Tree Workflow: Check every node recursively.
    // Algorithm:
    // 1. If node is null, return false.
    // 2. If node matches value, return true.
    // 3. Recursively check left and right subtrees.
    // Time Complexity: O(n) - may visit all nodes.
    // Space Complexity: O(h).
    public boolean searchBinary(int data) {
        return searchBinaryHelper(root, data);
    }
    private boolean searchBinaryHelper(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        return searchBinaryHelper(node.left, data) || searchBinaryHelper(node.right, data);
    }

    // BST Search
    // Workflow: Use BST property to navigate efficiently.
    // Algorithm:
    // 1. If node is null, return false.
    // 2. If node matches, return true.
    // 3. Go left if value is smaller, right if larger.
    // Time Complexity: O(h).
    // Space Complexity: O(h).
    public boolean searchBST(int data) {
        return searchBSTHelper(root, data);
    }
    private boolean searchBSTHelper(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        return data < node.data ? searchBSTHelper(node.left, data) : searchBSTHelper(node.right, data);
    }

    // Binary Tree: Delete
    // Workflow: Replace target with deepest node, then remove deepest.
    // Algorithm:
    // 1. Find target and deepest node using a queue.
    // 2. Replace target’s value with deepest’s value.
    // 3. Remove deepest node.
    // Time Complexity: O(n).
    // Space Complexity: O(w).
    public void deleteBinary(int data) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.data == data) root = null;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node target = null, deepest = null;
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
    private void deleteDeepest(Node deepest) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
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

    // BST: Delete
    // Workflow: Handle leaf, one child, or two children cases.
    // Algorithm:
    // 1. Find node to delete.
    // 2. If leaf, remove it.
    // 3. If one child, replace with child.
    // 4. If two children, replace with successor (smallest in right subtree), delete successor.
    // Time Complexity: O(h).
    // Space Complexity: O(h).
    public void deleteBST(int data) {
        root = deleteBSTHelper(root, data);
    }
    private Node deleteBSTHelper(Node node, int data) {
        if (node == null) return null;
        if (data < node.data) {
            node.left = deleteBSTHelper(node.left, data);
        } else if (data > node.data) {
            node.right = deleteBSTHelper(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.data = findMin(node.right).data;
            node.right = deleteBSTHelper(node.right, node.data);
        }
        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Traversals
    // Inorder (DFS: Left, Root, Right)
    // Workflow: Visit left subtree, root, right subtree; sorted for BST.
    // Algorithm: Recursively traverse left, print node, traverse right.
    // Time Complexity: O(n).
    // Space Complexity: O(h).
    public void inorder() {
        System.out.print("Inorder: ");
        inorderHelper(root);
        System.out.println();
    }
    private void inorderHelper(Node node) {
        if (node == null) return;
        inorderHelper(node.left);
        System.out.print(node.data + " ");
        inorderHelper(node.right);
    }

    // Preorder (DFS: Root, Left, Right)
    // Workflow: Visit root first, then subtrees; good for copying.
    // Algorithm: Print node, traverse left, traverse right.
    // Time Complexity: O(n).
    // Space Complexity: O(h).
    public void preorder() {
        System.out.print("Preorder: ");
        preorderHelper(root);
        System.out.println();
    }
    private void preorderHelper(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    // Postorder (DFS: Left, Right, Root)
    // Workflow: Visit subtrees, then root; useful for deletion.
    // Algorithm: Traverse left, traverse right, print node.
    // Time Complexity: O(n).
    // Space Complexity: O(h).
    public void postorder() {
        System.out.print("Postorder: ");
        postorderHelper(root);
        System.out.println();
    }
    private void postorderHelper(Node node) {
        if (node == null) return;
        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.data + " ");
    }

    // Level-Order (BFS)
    // Workflow: Visit nodes level by level using a queue.
    // Algorithm: Enqueue root, dequeue and print, enqueue children.
    // Time Complexity: O(n).
    // Space Complexity: O(w).
    public void levelOrder() {
        System.out.print("Level-Order: ");
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    // Morris Inorder (DFS, Space-Optimized)
    // Workflow: Thread nodes to predecessor for O(1) space.
    // Algorithm:
    // 1. If no left child, print node, go right.
    // 2. Else, find predecessor, thread to current, go left.
    // 3. When threaded, unthread, print, go right.
    // Time Complexity: O(n).
    // Space Complexity: O(1).
    public void morrisInorder() {
        System.out.print("Morris Inorder: ");
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    // Debugging: Validate BST
    // Workflow: Ensure left < parent < right for all nodes.
    // Algorithm: Check each node’s value within valid range.
    // Time Complexity: O(n).
    // Space Complexity: O(h).
    public boolean isValidBST() {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBSTHelper(Node node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isValidBSTHelper(node.left, min, node.data) &&
               isValidBSTHelper(node.right, node.data, max);
    }

    // Debugging: Print Tree Structure
    // Workflow: Display tree with indentation to show hierarchy.
    // Algorithm: Recursively print nodes with level-based indentation.
    // Time Complexity: O(n).
    // Space Complexity: O(h).
    public void printTree() {
        System.out.println("Tree Structure:");
        printTreeHelper(root, 0);
    }
    private void printTreeHelper(Node node, int level) {
        if (node == null) return;
        printTreeHelper(node.right, level + 1);
        for (int i = 0; i < level; i++) System.out.print("    ");
        System.out.println(node.data);
        printTreeHelper(node.left, level + 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Binary Tree
        System.out.println("Binary Tree Operations:");
        BinaryTree bt = new BinaryTree();
        // Create Binary Tree:       1
        //                         / \
        //                        2   3
        //                       / \ / \
        //                      4  5 6  7
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node(7);
        bt.levelOrder(); // 1 2 3 4 5 6 7
        bt.inorder(); // 4 2 5 1 6 3 7
        System.out.println("Search 5: " + bt.searchBinary(5)); // true
        bt.deleteBinary(2);
        bt.levelOrder(); // 1 7 3 4 5 6
        bt.printTree();
        System.out.println("Is Valid BST: " + bt.isValidBST()); // false

        // Test BST
        System.out.println("\nBST Operations:");
        BinaryTree bst = new BinaryTree();
        // Create BST:         50
        //                   /    \
        //                 30      70
        //                /  \    /  \
        //              20   40  60   80
        bst.insertBST(50);
        bst.insertBST(30);
        bst.insertBST(70);
        bst.insertBST(20);
        bst.insertBST(40);
        bst.insertBST(60);
        bst.insertBST(80);
        bst.inorder(); // 20 30 40 50 60 70 80
        bst.levelOrder(); // 50 30 70 20 40 60 80
        System.out.println("Search 60: " + bst.searchBST(60)); // true
        bst.deleteBST(30);
        bst.inorder(); // 20 40 50 60 70 80
        bst.morrisInorder(); // 20 40 50 60 70 80
        bst.printTree();
        System.out.println("Is Valid BST: " + bst.isValidBST()); // true
    }
}