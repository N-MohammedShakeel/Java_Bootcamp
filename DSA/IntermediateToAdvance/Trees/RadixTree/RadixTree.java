package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.RadixTree;

// Radix Tree (Patricia Trie) Implementation
// This file implements a Radix Tree for efficient string storage and retrieval.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on string operations.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; testing is embedded in the main method.
// Key Features:
// - Insert: Add a string, compressing prefixes.
// - Search: Check if a string exists.
// - Delete: Remove a string, merging nodes.
// - Prefix Search: Find all strings with a given prefix.
// - Traversal: DFS to list all strings.
// Java-Specific Notes:
// - Uses HashMap for children to handle variable edges.
// - Null checks and empty string handling ensure robustness.
// - Memory managed by JVM; size depends on string lengths.
// HackWithInfy Relevance:
// - Critical for Hard string problems (e.g., LeetCode #208, #211).
// - Tests understanding of prefix compression and string algorithms.
// Structure:
// - Nodes store edge labels, end-of-word flags, and children.
// - Edges are strings (prefixes), merged for compression.

import java.util.*;

public class RadixTree {
    private static class Node {
        String edgeLabel; // Prefix on edge to this node
        boolean isEndOfWord; // Marks complete string
        Map<Character, Node> children; // Maps first char to child node

        Node(String label) {
            this.edgeLabel = label;
            this.isEndOfWord = false;
            this.children = new HashMap<>();
        }
    }

    private Node root;

    public RadixTree() {
        root = new Node("");
    }

    // Insert
    // Workflow: Add a string, splitting edges to maintain prefix compression.
    // Algorithm:
    // 1. Start at root with string s.
    // 2. Match edge labels; split if partial match.
    // 3. Add new node for remaining string.
    // 4. Mark end-of-word if complete.
    // Time Complexity: O(m) - string length m.
    // Space Complexity: O(m) - new nodes.
    public void insert(String word) {
        if (word == null) return;
        insertHelper(root, word);
    }
    private void insertHelper(Node node, String word) {
        if (word.isEmpty()) {
            node.isEndOfWord = true;
            return;
        }

        for (Node child : node.children.values()) {
            String label = child.edgeLabel;
            int commonLen = commonPrefixLength(word, label);
            if (commonLen > 0) {
                if (commonLen == label.length()) {
                    // Full label match, recurse with remaining word
                    insertHelper(child, word.substring(commonLen));
                } else {
                    // Partial match, split edge
                    Node splitNode = new Node(label.substring(commonLen));
                    splitNode.isEndOfWord = child.isEndOfWord;
                    splitNode.children = child.children;
                    child.edgeLabel = label.substring(0, commonLen);
                    child.isEndOfWord = false;
                    child.children = new HashMap<>();
                    child.children.put(splitNode.edgeLabel.charAt(0), splitNode);
                    if (commonLen < word.length()) {
                        Node newNode = new Node(word.substring(commonLen));
                        newNode.isEndOfWord = true;
                        child.children.put(word.charAt(commonLen), newNode);
                    } else {
                        child.isEndOfWord = true;
                    }
                }
                return;
            }
        }

        // No matching prefix, add new edge
        Node newNode = new Node(word);
        newNode.isEndOfWord = true;
        node.children.put(word.charAt(0), newNode);
    }

    // Common Prefix Length (Helper)
    // Workflow: Find length of shared prefix between two strings.
    // Time Complexity: O(min(m, n)) - string lengths m, n.
    private int commonPrefixLength(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return i;
        }
        return len;
    }

    // Search
    // Workflow: Check if a string exists in the tree.
    // Algorithm:
    // 1. Traverse edges matching string.
    // 2. Return true if end-of-word flag is set.
    // Time Complexity: O(m).
    // Space Complexity: O(1).
    public boolean search(String word) {
        if (word == null) return false;
        Node node = root;
        while (!word.isEmpty()) {
            Node next = node.children.get(word.charAt(0));
            if (next == null) return false;
            String label = next.edgeLabel;
            if (!word.startsWith(label)) return false;
            word = word.substring(label.length());
            node = next;
        }
        return node.isEndOfWord;
    }

    // Delete
    // Workflow: Remove a string, merging nodes to maintain compression.
    // Algorithm:
    // 1. Find string, clear end-of-word flag.
    // 2. If no children, remove node.
    // 3. Merge single-child nodes.
    // Time Complexity: O(m).
    // Space Complexity: O(1).
    public void delete(String word) {
        if (word == null) return;
        deleteHelper(root, word);
    }
    private boolean deleteHelper(Node node, String word) {
        if (word.isEmpty()) {
            if (!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            return node.children.isEmpty();
        }

        Node child = node.children.get(word.charAt(0));
        if (child == null) return false;
        String label = child.edgeLabel;
        if (!word.startsWith(label)) return false;

        boolean shouldDeleteChild = deleteHelper(child, word.substring(label.length()));
        if (shouldDeleteChild) {
            node.children.remove(word.charAt(0));
            if (node.children.size() == 1 && !node.isEndOfWord && node != root) {
                // Merge with single child
                Node onlyChild = node.children.values().iterator().next();
                node.edgeLabel += onlyChild.edgeLabel;
                node.isEndOfWord = onlyChild.isEndOfWord;
                node.children = onlyChild.children;
            }
        }
        return node.children.isEmpty() && !node.isEndOfWord;
    }

    // Prefix Search
    // Workflow: Find all strings starting with a prefix.
    // Algorithm:
    // 1. Find node for prefix.
    // 2. Collect all strings below via DFS.
    // Time Complexity: O(m + k) - prefix length m, k strings.
    // Space Complexity: O(k).
    public List<String> prefixSearch(String prefix) {
        List<String> results = new ArrayList<>();
        if (prefix == null) return results;
        Node node = root;
        StringBuilder current = new StringBuilder();

        // Find prefix node
        while (!prefix.isEmpty()) {
            Node next = node.children.get(prefix.charAt(0));
            if (next == null) return results;
            current.append(next.edgeLabel);
            if (!prefix.startsWith(next.edgeLabel)) return results;
            prefix = prefix.substring(next.edgeLabel.length());
            node = next;
        }

        // Collect all strings
        collectStrings(node, current.toString(), results);
        return results;
    }
    private void collectStrings(Node node, String prefix, List<String> results) {
        if (node.isEndOfWord) results.add(prefix);
        for (Node child : node.children.values()) {
            collectStrings(child, prefix + child.edgeLabel, results);
        }
    }

    // Traversal (DFS)
    // Workflow: List all strings using depth-first search.
    // Time Complexity: O(N) - total string length N.
    // Space Complexity: O(m) - recursion depth.
    public List<String> getAllStrings() {
        List<String> results = new ArrayList<>();
        collectStrings(root, "", results);
        return results;
    }

    // Debugging: Validate Structure
    // Workflow: Check if tree correctly stores inserted strings.
    // Time Complexity: O(N).
    public boolean isValidRadixTree(List<String> expected) {
        List<String> actual = getAllStrings();
        Collections.sort(actual);
        Collections.sort(expected);
        return actual.equals(expected);
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Radix Tree Operations:");
        RadixTree rt = new RadixTree();
        // Insert: cat, car, cart, dog
        String[] words = {"cat", "car", "cart", "dog"};
        for (String word : words) {
            rt.insert(word);
        }
        System.out.println("All strings: " + rt.getAllStrings()); // [cat, car, cart, dog]
        System.out.println("Search 'cat': " + rt.search("cat")); // true
        System.out.println("Search 'ca': " + rt.search("ca")); // false
        System.out.println("Prefix 'ca': " + rt.prefixSearch("ca")); // [cat, car, cart]
        System.out.println("Is Valid: " + rt.isValidRadixTree(Arrays.asList(words))); // true

        // Delete car
        rt.delete("car");
        System.out.println("After delete 'car':");
        System.out.println("All strings: " + rt.getAllStrings()); // [cat, cart, dog]
        System.out.println("Search 'car': " + rt.search("car")); // false
        System.out.println("Prefix 'ca': " + rt.prefixSearch("ca")); // [cat, cart]
        System.out.println("Is Valid: " + rt.isValidRadixTree(Arrays.asList("cat", "cart", "dog"))); // true

        // Test edge cases
        rt.insert(""); // Empty string
        rt.delete("xyz"); // Non-existent
        System.out.println("Search '': " + rt.search("")); // true
    }
}