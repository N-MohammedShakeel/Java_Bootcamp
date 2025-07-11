package Java_Bootcamp.DSA_Patterns.Two_Pointer;

import java.util.Arrays;

public class leetcode1498 {

    class Solution {
        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);
            int mod = 1_000_000_007;
            int n = nums.length;

            int[] power = new int[n];
            power[0] = 1;
            for (int i = 1; i < n; i++) {
                power[i] = (power[i - 1] * 2) % mod;
            }

            int i = 0, j = n - 1, count = 0;

            while (i <= j) {
                if (nums[i] + nums[j] <= target) {
                    count = (count + power[j - i]) % mod;
                    i++;
                } else {
                    j--;
                }
            }

            return count;
        }
    }

}
