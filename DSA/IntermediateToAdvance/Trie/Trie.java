package Java_Bootcamp.DSA.IntermediateToAdvance.Trie;

public class Trie {
    // Inner class for Trie node
    private class TrieNode {
        // Array for child nodes (lowercase letters a-z)
        TrieNode[] children;
        // Flag to mark end of a word
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26]; // Alphabet size: 26 letters
            isEnd = false;
        }
    }

    // Root node of the Trie
    private final TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    // Time Complexity: O(L), where L is the length of the word
    public void insert(String word) {
        // Purpose: Add a word to the Trie by creating nodes for each character
        // Workflow:
        // 1. Start at root.
        // 2. For each character, compute index (c - 'a').
        // 3. Create child node if null.
        // 4. Move to child node.
        // 5. Mark last node as end of word.
        if (word == null || word.isEmpty()) {
            return; // Handle null or empty input
        }

        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            int index = c - 'a'; // Map 'a' to 0, 'b' to 1, etc.
            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    // Searches for a word in the Trie
    // Time Complexity: O(L), where L is the length of the word
    public boolean search(String word) {
        // Purpose: Check if a word exists in the Trie (exact match)
        // Workflow:
        // 1. Traverse nodes for each character.
        // 2. Return false if a node is null.
        // 3. Check isEnd flag at the last node.
        if (word == null || word.isEmpty()) {
            return false; // Handle null or empty input
        }

        TrieNode node = traversePrefix(word.toLowerCase());
        return node != null && node.isEnd;
    }

    // Checks if any word in the Trie starts with the given prefix
    // Time Complexity: O(L), where L is the length of the prefix
    public boolean startsWith(String prefix) {
        // Purpose: Check if any word has the given prefix
        // Workflow:
        // 1. Traverse nodes for each character.
        // 2. Return true if all characters are found (node != null).
        if (prefix == null || prefix.isEmpty()) {
            return false; // Handle null or empty input
        }

        TrieNode node = traversePrefix(prefix.toLowerCase());
        return node != null;
    }

    // Helper method to traverse the Trie for a prefix
    // Returns the node at the end of the prefix, or null if not found
    private TrieNode traversePrefix(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (index < 0 || index >= 26) {
                return null; // Invalid character
            }
            if (current.children[index] == null) {
                return null; // Prefix not found
            }
            current = current.children[index];
        }
        return current;
    }

    // Main method for testing
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Test Insert
        System.out.println("Inserting words: apple, app, banana");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Test Search
        System.out.println("\nTesting search:");
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'appl': " + trie.search("appl")); // false
        System.out.println("Search 'banana': " + trie.search("banana")); // true
        System.out.println("Search null: " + trie.search(null)); // false

        // Test StartsWith
        System.out.println("\nTesting startsWith:");
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // true
        System.out.println("Starts with 'ban': " + trie.startsWith("ban")); // true
        System.out.println("Starts with 'cat': " + trie.startsWith("cat")); // false
        System.out.println("Starts with empty: " + trie.startsWith("")); // false

        // Test Invalid Input
        System.out.println("\nTesting invalid input:");
        try {
            trie.insert("apple#");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage()); // Invalid character: #
        }
    }
}