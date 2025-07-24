package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_145_Iterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode curr = st1.pop();
            st2.push(curr);

            if (curr.left != null) st1.push(curr.left);
            if (curr.right != null) st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            res.add(st2.pop().val);
        }

        return res;
    }

}
