package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_144_Iterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){

            TreeNode curr = st.pop();
            res.add(curr.val);

            if (curr.right != null)
                st.push(curr.right);


            if (curr.left != null)
                st.push(curr.left);
        }

        return res;
    }
}
