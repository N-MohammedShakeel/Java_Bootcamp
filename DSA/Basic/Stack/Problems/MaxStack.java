package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 9: Maximum Element in Stack
// Statement: Design a stack that supports push, pop, and getMax in O(1) time.
// Sample Test Cases:
// Input: push(3), push(5), getMax(), push(2), getMax(), pop(), getMax()
// Output: [null,null,5,null,5,null,3]
// TC: O(1) for all operations, SC: O(n)
class MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        int x = stack.pop();
        if (x == maxStack.peek()) {
            maxStack.pop();
        }
        return x;
    }

    public int getMax() {
        return maxStack.peek();
    }
}
