package Java_Bootcamp.DSA.IntermediateToAdvance.Trees;

// Tree Traversals Implementation with BFS and DFS
// Traversals are methods to visit all nodes in a tree in a specific order.
// This file explicitly includes Breadth-First Search (BFS) and Depth-First Search (DFS) as they apply to binary trees.
// BFS and DFS Overview:
// - BFS (Breadth-First Search): Explores nodes level by level, equivalent to Level-Order Traversal.
//   - Algorithm: Uses a queue to process nodes in order of their distance from the root.
//   - Use Cases: Shortest path in unweighted trees, level-based processing (e.g., level averages).
//   - Time Complexity: O(n) - visits each node once.
//   - Space Complexity: O(w) - queue stores up to w nodes (max width of tree).
// - DFS (Depth-First Search): Explores as far as possible along each branch before backtracking.
//   - Variants in Trees: Inorder (Left, Root, Right), Preorder (Root, Left, Right), Postorder (Left, Right, Root).
//   - Algorithm: Uses recursion (implicit stack) or explicit stack to explore deeply.
//   - Use Cases: Tree reconstruction, expression evaluation, topological sorting.
//   - Time Complexity: O(n) - visits each node once.
//   - Space Complexity: O(h) - recursion stack or explicit stack, h is tree height.
// Tree-Specific Traversals:
// - Inorder: Sorted order for BST; DFS variant.
// - Preorder: Copy tree, prefix expressions; DFS variant.
// - Postorder: Delete tree, postfix expressions; DFS variant.
// - Level-Order: Breadth-first, level-by-level; equivalent to BFS.
// - Morris Traversal: Threaded inorder/preorder with O(1) space; DFS-based.
// Applications: Printing, searching, serializing trees, solving problems like max depth or diameter.
// Java-Specific Notes:
// - Recursive DFS uses JVM stack; iterative uses explicit stack/queue.
// - Morris traversal avoids recursion and extra space, ideal for memory-constrained scenarios.
// - Null checks are critical to avoid NullPointerException.
// - Uses TreeUtils for centralized tree creation to ensure consistent testing.
// HackWithInfy Relevance:
// - BFS (Level-Order) and DFS (Inorder/Preorder/Postorder) are common in Easy/Medium problems.
// - Examples: LeetCode #94 (Inorder Traversal), #102 (Level-Order Traversal), #104 (Max Depth).
// - Morris traversal may appear in Hard problems requiring space optimization.

import java.util.*;

public class TreeTraversals {
    // BFS (Breadth-First Search) - Equivalent to Level-Order Traversal
    // Algorithm: Use a queue to visit nodes level by level.
    // TC: O(n) - visits each node once.
    // SC: O(w) - queue stores up to max width w.
    public static void bfs(TreeUtils.BinaryNode root) {
        System.out.print("BFS (Level-Order): ");
        if (root == null) return;
        Queue<TreeUtils.BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeUtils.BinaryNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    // DFS (Depth-First Search) - Inorder (Recursive)
    // Algorithm: Visit left subtree, root, right subtree.
    // TC: O(n) - visits each node once.
    // SC: O(h) - recursion stack, h is height.
    public static void dfsInorderRecursive(TreeUtils.BinaryNode root) {
        System.out.print("DFS Inorder (Recursive): ");
        inorderRecursive(root);
        System.out.println();
    }
    private static void inorderRecursive(TreeUtils.BinaryNode root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.data + " ");
        inorderRecursive(root.right);
    }

    // DFS (Depth-First Search) - Inorder (Iterative)
    // Algorithm: Use a stack to mimic recursive inorder.
    // TC: O(n).
    // SC: O(h) - stack size.
    public static void dfsInorderIterative(TreeUtils.BinaryNode root) {
        System.out.print("DFS Inorder (Iterative): ");
        Stack<TreeUtils.BinaryNode> stack = new Stack<>();
        TreeUtils.BinaryNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    // DFS (Depth-First Search) - Preorder (Recursive)
    // Algorithm: Visit root, left subtree, right subtree.
    // TC: O(n).
    // SC: O(h).
    public static void dfsPreorderRecursive(TreeUtils.BinaryNode root) {
        System.out.print("DFS Preorder (Recursive): ");
        preorderRecursive(root);
        System.out.println();
    }
    private static void preorderRecursive(TreeUtils.BinaryNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    // DFS (Depth-First Search) - Preorder (Iterative)
    // Algorithm: Use a stack to mimic recursive preorder.
    // TC: O(n).
    // SC: O(h).
    public static void dfsPreorderIterative(TreeUtils.BinaryNode root) {
        System.out.print("DFS Preorder (Iterative): ");
        if (root == null) return;
        Stack<TreeUtils.BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeUtils.BinaryNode node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        System.out.println();
    }

    // DFS (Depth-First Search) - Postorder (Recursive)
    // Algorithm: Visit left subtree, right subtree, root.
    // TC: O(n).
    // SC: O(h).
    public static void dfsPostorderRecursive(TreeUtils.BinaryNode root) {
        System.out.print("DFS Postorder (Recursive): ");
        postorderRecursive(root);
        System.out.println();
    }
    private static void postorderRecursive(TreeUtils.BinaryNode root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // DFS (Depth-First Search) - Postorder (Iterative)
    // Algorithm: Use two stacks to collect nodes in postorder.
    // TC: O(n).
    // SC: O(h).
    public static void dfsPostorderIterative(TreeUtils.BinaryNode root) {
        System.out.print("DFS Postorder (Iterative): ");
        if (root == null) return;
        Stack<TreeUtils.BinaryNode> stack1 = new Stack<>();
        Stack<TreeUtils.BinaryNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeUtils.BinaryNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
        System.out.println();
    }

    // Morris Inorder Traversal (DFS-based, Space-Optimized)
    // Algorithm: Thread nodes to predecessor; no recursion/stack.
    // TC: O(n) - each edge traversed a constant number of times.
    // SC: O(1) - no extra space.
    public static void morrisInorder(TreeUtils.BinaryNode root) {
        System.out.print("Morris Inorder (DFS): ");
        TreeUtils.BinaryNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                TreeUtils.BinaryNode predecessor = current.left;
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

    // Morris Preorder Traversal (DFS-based, Space-Optimized)
    // Algorithm: Similar to Morris Inorder but prints before left traversal.
    // TC: O(n).
    // SC: O(1).
    public static void morrisPreorder(TreeUtils.BinaryNode root) {
        System.out.print("Morris Preorder (DFS): ");
        TreeUtils.BinaryNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                TreeUtils.BinaryNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    // Main method for testing traversals
    public static void main(String[] args) {
        // Test on Binary Tree
        System.out.println("Binary Tree Traversals:");
        TreeUtils.BinaryNode btRoot = TreeUtils.createBinaryTree();
        bfs(btRoot); // BFS (Level-Order): 1 2 3 4 5 6 7
        dfsInorderRecursive(btRoot); // DFS Inorder: 4 2 5 1 6 3 7
        dfsInorderIterative(btRoot);
        dfsPreorderRecursive(btRoot); // DFS Preorder: 1 2 4 5 3 6 7
        dfsPreorderIterative(btRoot);
        dfsPostorderRecursive(btRoot); // DFS Postorder: 4 5 2 6 7 3 1
        dfsPostorderIterative(btRoot);
        morrisInorder(btRoot); // Morris Inorder: 4 2 5 1 6 3 7
        morrisPreorder(btRoot); // Morris Preorder: 1 2 4 5 3 6 7

        // Test on BST
        System.out.println("\nBST Traversals:");
        TreeUtils.BinaryNode bstRoot = TreeUtils.createBST();
        bfs(bstRoot); // BFS (Level-Order): 50 30 70 20 40 60 80
        dfsInorderRecursive(bstRoot); // DFS Inorder: 20 30 40 50 60 70 80
        dfsInorderIterative(bstRoot);
        dfsPreorderRecursive(bstRoot); // DFS Preorder: 50 30 20 40 70 60 80
        dfsPreorderIterative(bstRoot);
        dfsPostorderRecursive(bstRoot); // DFS Postorder: 20 40 30 60 80 70 50
        dfsPostorderIterative(bstRoot);
        morrisInorder(bstRoot); // Morris Inorder: 20 30 40 50 60 70 80
        morrisPreorder(bstRoot); // Morris Preorder: 50 30 20 40 70 60 80
    }
}