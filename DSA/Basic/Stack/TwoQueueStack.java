package Java_Bootcamp.DSA.Basic.Stack;

import java.util.*;

// Stack Implementation: Stack using Two Queues
class TwoQueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public TwoQueueStack(int size) {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int value) {
        q2.offer(value);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (!q1.isEmpty()) {
            return q1.poll();
        } else {
            throw new IllegalStateException("Stack Underflow");
        }
    }

    public int peek() {
        if (!q1.isEmpty()) {
            return q1.peek();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }
}

// Approach:
// 1. Data Structure: Uses two `LinkedList` queues (`q1`, `q2`) to simulate stack behavior (LIFO). `q1` holds the stack elements, `q2` is a temporary queue.
// 2. Key Components:
//    - `q1`: Main queue storing elements in stack order (top element at front).
//    - `q2`: Temporary queue used during `push` to reorder elements.
// 3. Operations:
//    - `push`: Adds new element to `q2`, moves all elements from `q1` to `q2`, swaps `q1` and `q2`. Ensures new element is at the front of `q1`. TC: O(n).
//    - `pop`: Removes and returns the front element of `q1`. Checks for underflow. TC: O(1).
//    - `peek`: Returns the front element of `q1` without removing it. TC: O(1).
//    - `isEmpty`: Checks if `q1` is empty. TC: O(1).
//    - `size`: Returns `q1.size()`. TC: O(1).
// 4. Advantages:
//    - Leverages queue operations to implement a stack, useful for theoretical exercises.
//    - Dynamic size via `LinkedList` queues.
// 5. Limitations:
//    - `push` is costly (O(n)) due to element reordering.
//    - Requires two queues, increasing space complexity.
// 6. Use Case: Useful for understanding queue-to-stack conversion or when stack operations must be built on queue primitives (e.g., specific system constraints).