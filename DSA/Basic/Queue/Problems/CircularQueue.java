package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 5: Implement Circular Queue
// Statement: Implement a circular queue with enqueue, dequeue, isFull, isEmpty.
// Sample Test Cases:
// Input: enqueue(1), enqueue(2), dequeue(), enqueue(3), isFull() -> Output: [null,null,1,null,false]
// Input: enqueue(1), dequeue(), isEmpty() -> Output: [null,1,true]
// TC: O(1) for all operations, SC: O(n)
class CircularQueue {
    private Queue<Integer> queue;
    private int maxSize;

    public CircularQueue(int size) {
        queue = new LinkedList<>();
        maxSize = size;
    }

    public void enqueue(int value) {
        if (queue.size() < maxSize) {
            queue.offer(value);
        } else {
            throw new IllegalStateException("Queue Overflow");
        }
    }

    public int dequeue() {
        return queue.poll();
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
