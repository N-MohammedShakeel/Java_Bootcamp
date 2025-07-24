package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_94_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

}
