package Java_Bootcamp.Leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        permutation(result,current,used,nums);

        return result;
    }

    static void permutation(List<List<Integer>> result, List<Integer> current, boolean[] used, int[] nums){


        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0 ; i<nums.length ; i++){
            if(!used[i]){
                used[i] = true;
                current.add(nums[i]);
                permutation(result,current,used,nums);

                current.removeLast();
                used[i] = false;
            }
        }
    }
}
