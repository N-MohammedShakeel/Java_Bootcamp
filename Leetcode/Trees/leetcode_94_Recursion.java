package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class leetcode_94_Recursion {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderHelper(root, list);
        return list;
    }
    public void inorderHelper(TreeNode root, List<Integer> list){
        if (root == null) return;
        inorderHelper(root.left, list);
        list.add(root.val);
        inorderHelper(root.right, list);
    }
}
