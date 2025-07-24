package Java_Bootcamp.Leetcode.Trees;

public class leetcode_104 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int level) {
        if (node == null) return level - 1;

        int left = dfs(node.left, level + 1);
        int right = dfs(node.right, level + 1);

        return Math.max(left, right);
    }
}
