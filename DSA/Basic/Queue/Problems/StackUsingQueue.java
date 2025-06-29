package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 2: Implement Stack using Queue
// Statement: Implement a stack using a single queue.
// Sample Test Cases:
// Input: push(1), push(2), pop(), push(3), pop() -> Output: [null,null,2,null,3]
// Input: push(5), pop() -> Output: [null,5]
// TC: O(n) for push, O(1) for pop, SC: O(n)
class StackUsingQueue {
    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }
}
