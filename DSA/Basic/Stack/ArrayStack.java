package Java_Bootcamp.DSA.Basic.Stack;

// Stack Implementation: Array-based Stack
class ArrayStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public ArrayStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            throw new IllegalStateException("Stack Overflow");
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            throw new IllegalStateException("Stack Underflow");
        }
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

// Approach:
// 1. Data Structure: Uses a fixed-size array (`stackArray`) to store elements contiguously, providing O(1) access.
// 2. Key Components:
//    - `maxSize`: Defines the maximum capacity of the stack.
//    - `stackArray`: Stores elements as integers.
//    - `top`: Points to the index of the topmost element; initialized to -1 (empty stack).
// 3. Operations:
//    - `push`: Increments `top` and adds the value at `stackArray[top]`. Checks for overflow (top >= maxSize - 1). TC: O(1).
//    - `pop`: Returns and removes the element at `stackArray[top]`, decrements `top`. Checks for underflow (top < 0). TC: O(1).
//    - `peek`: Returns the element at `stackArray[top]` without removing it. TC: O(1).
//    - `isEmpty`: Returns true if `top == -1`. TC: O(1).
//    - `size`: Returns `top + 1`. TC: O(1).
// 4. Advantages:
//    - Constant-time operations due to direct array indexing.
//    - Memory-efficient for fixed-size stacks.
// 5. Limitations:
//    - Fixed capacity; cannot grow dynamically without resizing (not implemented here for simplicity).
//    - Wastes memory if the stack is underutilized.
// 6. Use Case: Suitable for scenarios with known maximum size and frequent push/pop operations (e.g., function call stack in recursion).