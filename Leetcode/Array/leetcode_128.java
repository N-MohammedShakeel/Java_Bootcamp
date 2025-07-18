package Java_Bootcamp.Leetcode.Array;

import java.util.Arrays;

public class leetcode_128 {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxStreak = 1;
        int currentStreak = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) continue;
            else if(nums[i] == nums[i-1] + 1) currentStreak++;
            else currentStreak = 1;

            maxStreak = Math.max(maxStreak, currentStreak);
        }

        return maxStreak;
    }
}
