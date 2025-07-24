package Java_Bootcamp.Leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class leetcode_144_Recursion {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderHelper(root, list);
        return list;
    }

    public void preorderHelper(TreeNode root,List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        preorderHelper(root.left, list);
        preorderHelper(root.right, list);
    }
}
