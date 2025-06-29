package Java_Bootcamp.DSA.Basic.Queue;

import java.util.*;

// Queue Implementation: Queue using Two Stacks
class TwoStackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public TwoStackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int value) {
        s1.push(value);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            throw new IllegalStateException("Queue Underflow");
        }
    }

    public int front() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int size() {
        return s1.size() + s2.size();
    }
}

// Approach:
// 1. Data Structure: Uses two `Stack` instances (`s1`, `s2`) to simulate queue behavior (FIFO). `s1` handles enqueues, `s2` handles dequeues/front.
// 2. Key Components:
//    - `s1`: Stack for enqueue operations, storing new elements in LIFO order.
//    - `s2`: Stack for dequeue and front operations, storing elements in FIFO order after transfer from `s1`.
// 3. Operations:
//    - `enqueue`: Pushes the value onto `s1`. TC: O(1).
//    - `dequeue`: If `s2` is empty, transfers all elements from `s1` to `s2` (reversing order), then pops from `s2`. Checks for underflow. TC: O(n) amortized.
//    - `front`: Similar to `dequeue`, but peeks at `s2` instead of popping. TC: O(n) amortized.
//    - `isEmpty`: Returns true if both `s1` and `s2` are empty. TC: O(1).
//    - `size`: Returns sum of sizes of `s1` and `s2`. TC: O(1).
// 4. Advantages:
//    - Leverages stack operations to implement a queue, useful for theoretical exercises.
//    - Dynamic size via `Stack` (backed by dynamic arrays in Java).
// 5. Limitations:
//    - `dequeue` and `front` are costly (O(n)) when `s2` is empty due to element transfer.
//    - Requires two stacks, increasing space complexity.
// 6. Use Case: Useful for understanding stack-to-queue conversion or when queue operations must be built on stack primitives (e.g., specific system constraints).