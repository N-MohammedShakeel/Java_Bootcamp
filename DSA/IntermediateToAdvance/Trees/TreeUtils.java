
// Utility class for creating various types of trees for testing
// Purpose: Centralizes tree creation to avoid code duplication across different tree implementations.
// Provides methods to create Binary Tree, BST, AVL, Red-Black Tree, Trie, N-ary Tree, Segment Tree, and Fenwick Tree.
// Each method returns a pre-populated tree structure for demonstration and testing.
// Used by tree type implementations and traversal implementations for consistent test cases.
// Java-Specific Notes:
// - Uses static methods for easy access without instantiation.
// - Node classes are defined within respective tree implementation files.
// - Ensures trees are non-empty for meaningful test cases.
// - Handles edge cases (e.g., null checks) where applicable.

package Java_Bootcamp.DSA.IntermediateToAdvance.Trees;

import java.util.*;

public class TreeUtils {
    // Binary Tree Node (used for Binary Tree, BST, AVL, Red-Black)
    public static class BinaryNode {
        int data;
        BinaryNode left, right;
        BinaryNode(int data) { this.data = data; }
    }

    // N-ary Tree Node
    public static class NaryNode {
        int data;
        List<NaryNode> children;
        NaryNode(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // Trie Node
    public static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    // Create a sample Binary Tree
    // Structure:       1
    //                /   \
    //               2     3
    //              / \   / \
    //             4   5 6   7
    // Time Complexity: O(1) - fixed structure creation.
    // Space Complexity: O(1) - fixed number of nodes.
    public static BinaryNode createBinaryTree() {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(4);
        root.left.right = new BinaryNode(5);
        root.right.left = new BinaryNode(6);
        root.right.right = new BinaryNode(7);
        return root;
    }

    // Create a sample Binary Search Tree (BST)
    // Structure:       50
    //                /    \
    //              30      70
    //             /  \    /  \
    //            20  40  60   80
    // Time Complexity: O(1) - fixed structure creation.
    // Space Complexity: O(1) - fixed number of nodes.
    public static BinaryNode createBST() {
        BinaryNode root = new BinaryNode(50);
        root.left = new BinaryNode(30);
        root.right = new BinaryNode(70);
        root.left.left = new BinaryNode(20);
        root.left.right = new BinaryNode(40);
        root.right.left = new BinaryNode(60);
        root.right.right = new BinaryNode(80);
        return root;
    }

    // Create a sample N-ary Tree
    // Structure:      1
    //               / | \
    //              2  3  4
    //             /|     |
    //            5 6     7
    // Time Complexity: O(1) - fixed structure creation.
    // Space Complexity: O(1) - fixed number of nodes.
    public static NaryNode createNaryTree() {
        NaryNode root = new NaryNode(1);
        NaryNode node2 = new NaryNode(2);
        NaryNode node3 = new NaryNode(3);
        NaryNode node4 = new NaryNode(4);
        NaryNode node5 = new NaryNode(5);
        NaryNode node6 = new NaryNode(6);
        NaryNode node7 = new NaryNode(7);
        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);
        node2.children.add(node5);
        node2.children.add(node6);
        node4.children.add(node7);
        return root;
    }

    // Create a sample Trie with words: "cat", "car", "cart"
    // Structure:       (root)
    //                 / 
    //                c
    //               / \
    //              a   a
    //             /     \
    //            t       r
    //                     \
    //                      t
    // Time Complexity: O(L) - L is total length of words.
    // Space Complexity: O(L) - nodes for unique prefixes.
    public static TrieNode createTrie() {
        TrieNode root = new TrieNode();
        String[] words = {"cat", "car", "cart"};
        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEnd = true;
        }
        return root;
    }

    // Create a sample array for Segment Tree and Fenwick Tree
    // Array: [1, 3, 5, 7, 9, 11]
    // Time Complexity: O(1) - fixed array.
    // Space Complexity: O(1) - fixed size.
    public static int[] createArray() {
        return new int[]{1, 3, 5, 7, 9, 11};
    }
}