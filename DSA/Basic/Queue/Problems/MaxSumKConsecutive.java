package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 10: Maximum Sum of K Consecutive Elements
// Statement: Find the maximum sum of k consecutive elements in a queue.
// Sample Test Cases:
// Input: queue=[1,2,3,4,5], k=3 -> Output: 12
// Input: queue=[1,2,3], k=2 -> Output: 5
// TC: O(n), SC: O(1)
class MaxSumKConsecutive {
    public static int maxSum(Queue<Integer> queue, int k) {
        if (k > queue.size()) return -1;
        int maxSum = 0, currSum = 0;
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int val = queue.poll();
            currSum += val;
            temp.offer(val);
        }
        maxSum = currSum;
        while (!queue.isEmpty()) {
            currSum -= temp.poll();
            int val = queue.poll();
            currSum += val;
            temp.offer(val);
            maxSum = Math.max(maxSum, currSum);
        }
        while (!temp.isEmpty()) {
            queue.offer(temp.poll());
        }
        return maxSum;
    }
}
