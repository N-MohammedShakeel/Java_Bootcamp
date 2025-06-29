package Java_Bootcamp.DSA.Basic.Stack;

// Stack Implementation: Linked List-based Stack
class LinkedListStack {
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public LinkedListStack() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top != null) {
            int value = top.data;
            top = top.next;
            return value;
        } else {
            throw new IllegalStateException("Stack Underflow");
        }
    }

    public int peek() {
        if (top != null) {
            return top.data;
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Approach:
// 1. Data Structure: Uses a singly-linked list where each node contains an integer (`data`) and a reference to the next node (`next`).
// 2. Key Components:
//    - `Node`: Inner class with `data` (int) and `next` (pointer to next node).
//    - `top`: Points to the head of the linked list (topmost element).
// 3. Operations:
//    - `push`: Creates a new `Node` with the value, sets its `next` to current `top`, updates `top` to new node. TC: O(1).
//    - `pop`: Returns `top.data`, updates `top` to `top.next`. Checks for underflow (top == null). TC: O(1).
//    - `peek`: Returns `top.data` without modifying the stack. TC: O(1).
//    - `isEmpty`: Returns true if `top == null`. TC: O(1).
//    - `size`: Traverses the list to count nodes. TC: O(n).
// 4. Advantages:
//    - Dynamic size; grows/shrinks as needed without fixed capacity.
//    - Memory-efficient for sparse usage (only allocates nodes as needed).
// 5. Limitations:
//    - `size` operation is O(n) due to traversal (can be optimized with a size counter).
//    - Extra memory overhead for node references.
// 6. Use Case: Ideal for stacks with unpredictable size or frequent insertions/deletions at the top (e.g., expression parsing).