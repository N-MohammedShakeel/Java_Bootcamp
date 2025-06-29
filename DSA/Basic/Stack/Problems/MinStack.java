package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 7: Min Stack (LeetCode #155)
// Statement: Design a stack that supports push, pop, top, and getMin in O(1) time.
// Sample Test Cases:
// Input: push(3), push(5), getMin(), push(2), getMin(), pop(), getMin()
// Output: [null,null,3,null,2,null,3]
// TC: O(1) for all operations, SC: O(n)
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
        return x;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
