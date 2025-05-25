package Java_Bootcamp.DSA.Intermediate.Trees;

// Trie Implementation
// A Trie (prefix tree) stores strings, with each node representing a character.
// Key Operations:
// - Insert: Add a word to the trie.
// - Search: Check if a word exists.
// - StartsWith: Check if any word starts with prefix.
// Applications: Autocomplete, spell checkers, IP routing.
// Java-Specific Notes:
// - Array-based children for simplicity (26 for lowercase letters).
// - Can extend to handle other characters (e.g., 256 for ASCII).
// HackWithInfy Relevance: Medium problems (e.g., prefix-based searches).
// LeetCode: https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {
    private TreeUtils.TrieNode root;

    public Trie() {
        root = new TreeUtils.TrieNode();
    }

    // Insert a word
    // Algorithm: Create nodes for each character; mark end.
    // TC: O(m) - m is word length.
    // SC: O(m) - nodes for unique prefix.
    public void insert(String word) {
        TreeUtils.TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TreeUtils.TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    // Search for a word
    // Algorithm: Traverse nodes for each character; check isEnd.
    // TC: O(m) - m is word length.
    // SC: O(1) - constant space.
    public boolean search(String word) {
        TreeUtils.TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    // Check if prefix exists
    // Algorithm: Traverse nodes for prefix.
    // TC: O(m) - m is prefix length.
    // SC: O(1).
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    private TreeUtils.TrieNode searchPrefix(String prefix) {
        TreeUtils.TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return null;
            current = current.children[index];
        }
        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root = TreeUtils.createTrie();
        System.out.println("Search 'cat': " + trie.search("cat")); // true
        System.out.println("Search 'cap': " + trie.search("cap")); // false
        System.out.println("Starts with 'ca': " + trie.startsWith("ca")); // true
    }
}