package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 6: Sliding Window Maximum (LeetCode #239)
// Statement: Find the maximum element in each sliding window of size k in an array.
// Sample Test Cases:
// Input: nums=[1,3,-1,-3,5,3,6,7], k=3 -> Output: [3,3,5,5,6,7]
// Input: nums=[1], k=1 -> Output: [1]
// TC: O(n), SC: O(k)
class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Queue<Integer> queue = new LinkedList<>(); // Used as deque
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peek()] < nums[i]) {
                queue.poll();
            }
            queue.offer(i);
            if (i - queue.peek() >= k) {
                queue.poll();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }
}
