package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.*;

// Queue Problems using java.util.LinkedList as Queue

// Problem 1: Reverse First K Elements
// Statement: Reverse the first K elements of a queue.
// Sample Test Cases:
// Input: queue=[1,2,3,4,5], k=3 -> Output: [3,2,1,4,5]
// Input: queue=[1,2,3], k=2 -> Output: [2,1,3]
// TC: O(n), SC: O(k)
class ReverseKElements {
    public static void reverseK(Queue<Integer> queue, int k) {
        if (k > queue.size() || k < 0) return;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.poll());
        }
    }
}

