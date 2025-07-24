package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class leetcode_145_Recursion {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }
    public void postorderHelper(TreeNode root,List<Integer> list){
        if (root == null) return;
        postorderHelper(root.left, list);
        postorderHelper(root.right, list);
        list.add(root.val);
    }
}
