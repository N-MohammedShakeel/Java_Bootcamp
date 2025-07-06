package Java_Bootcamp.DSA.Basic.Queue;

// Queue Implementation: Linked List-based Queue
class LinkedListQueue {
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (front != null) {
            int value = front.data;
            front = front.next;
            if (front == null) rear = null;
            size--;
            return value;
        } else {
            throw new IllegalStateException("Queue Underflow");
        }
    }

    public int front() {
        if (front != null) {
            return front.data;
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

// Approach:
// 1. Data Structure: Uses a singly-linked list with nodes containing an integer (`data`) and a reference to the next node (`next`).
// 2. Key Components:
//    - `Node`: Inner class with `data` (int) and `next` (pointer to next node).
//    - `front`: Points to the head of the list (first element).
//    - `rear`: Points to the tail of the list (last element).
//    - `size`: Tracks the number of elements for efficient size queries.
// 3. Operations:
//    - `enqueue`: Creates a new `Node`, adds it at the end (updates `rear.next` and `rear`), or sets both `front` and `rear` if empty. Increments `size`. TC: O(1).
//    - `dequeue`: Returns `front.data`, updates `front` to `front.next`, sets `rear` to null if queue becomes empty, decrements `size`. Checks for underflow (`front == null`). TC: O(1).
//    - `front`: Returns `front.data` without removing it. TC: O(1).
//    - `isEmpty`: Returns true if `size == 0`. TC: O(1).
//    - `size`: Returns `size`. TC: O(1).
// 4. Advantages:
//    - Dynamic size; grows/shrinks as needed without fixed capacity.
//    - Memory-efficient for sparse usage (only allocates nodes as needed).
// 5. Limitations:
//    - Extra memory overhead for node references.
//    - Slightly slower than array-based due to pointer manipulation.
// 6. Use Case: Ideal for queues with unpredictable size or frequent insertions/deletions (e.g., job scheduling, breadth-first search).