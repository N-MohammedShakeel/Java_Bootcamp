package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class leetcode_102_Recursion {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
