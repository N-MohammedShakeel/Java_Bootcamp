package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.Queue;
import java.util.Stack;

// Problem 9: Reverse a Queue
// Statement: Reverse all elements of a queue.
// Sample Test Cases:
// Input: [1,2,3,4,5] -> Output: [5,4,3,2,1]
// Input: [1] -> Output: [1]
// TC: O(n), SC: O(n)
class ReverseQueue {
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }
}
