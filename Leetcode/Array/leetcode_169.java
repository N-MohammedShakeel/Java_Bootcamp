package Java_Bootcamp.Leetcode.Array;

import java.util.Arrays;

public class leetcode_169 {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
