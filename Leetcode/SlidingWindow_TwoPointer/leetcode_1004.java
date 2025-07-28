package Java_Bootcamp.Leetcode.SlidingWindow_TwoPointer;

public class leetcode_1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int maxLen = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
