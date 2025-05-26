package Java_Bootcamp.DSA.IntermediateToAdvance.Trees;

// N-ary Tree Implementation
// An N-ary Tree allows each node to have any number of children.
// Key Operations:
// - Insert: Add a child to a specific node.
// - Search: Find a value.
// Applications: File systems, organizational charts.
// Java-Specific Notes:
// - Uses List for children to support variable number.
// - Recursive search for simplicity.
// HackWithInfy Relevance: Medium problems (e.g., tree traversals).

public class NaryTree {
    private TreeUtils.NaryNode root;

    public NaryTree() {
        root = null;
    }

    // Insert a child to a parent node
    // Algorithm: Find parent, add child.
    // TC: O(n) - search parent.
    // SC: O(h) - recursion stack.
    public void insert(int parentData, int childData) {
        if (root == null) {
            root = new TreeUtils.NaryNode(childData);
            return;
        }
        TreeUtils.NaryNode parent = findNode(root, parentData);
        if (parent != null) {
            parent.children.add(new TreeUtils.NaryNode(childData));
        }
    }
    private TreeUtils.NaryNode findNode(TreeUtils.NaryNode node, int data) {
        if (node == null) return null;
        if (node.data == data) return node;
        for (TreeUtils.NaryNode child : node.children) {
            TreeUtils.NaryNode result = findNode(child, data);
            if (result != null) return result;
        }
        return null;
    }

    // Search for a value
    // TC: O(n) - visit all nodes.
    // SC: O(h) - recursion stack.
    public boolean search(int data) {
        return findNode(root, data) != null;
    }

    public static void main(String[] args) {
        NaryTree tree = new NaryTree();
        tree.root = TreeUtils.createNaryTree();
        System.out.println("Search 5: " + tree.search(5)); // true
        System.out.println("Search 8: " + tree.search(8)); // false
        // Traversals tested in TreeTraversals.java
    }
}