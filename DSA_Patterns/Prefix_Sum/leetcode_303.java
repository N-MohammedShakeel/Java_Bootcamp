package Java_Bootcamp.DSA_Patterns.Prefix_Sum;

public class leetcode_303 {

    class NumArray {
        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return prefixSum[right];
            } else {
                return prefixSum[right] - prefixSum[left - 1];
            }
        }
    }

}
