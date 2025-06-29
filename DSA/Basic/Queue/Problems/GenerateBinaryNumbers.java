package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 3: Generate Binary Numbers
// Statement: Generate binary numbers from 1 to N in order.
// Sample Test Cases:
// Input: n=3 -> Output: ["1","10","11"]
// Input: n=2 -> Output: ["1","10"]
// TC: O(n), SC: O(n)
class GenerateBinaryNumbers {
    public static String[] generateBinary(int n) {
        String[] result = new String[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(queue.poll());
            queue.offer(Integer.parseInt(result[i] + "0", 2));
            queue.offer(Integer.parseInt(result[i] + "1", 2));
        }
        return result;
    }
}
