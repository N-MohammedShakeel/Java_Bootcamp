package Java_Bootcamp.Leetcode.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {

    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0 ; i < (1 << n) ; i++){
            List<Integer> dummy = new ArrayList<>();
            for(int j=0 ; j < n ; j++){
                if ((i & (1 << j)) != 0) dummy.add(nums[j]);
            }
            list.add(dummy);
        }

        return list;
    }
}
