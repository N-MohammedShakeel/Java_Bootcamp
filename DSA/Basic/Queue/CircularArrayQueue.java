package Java_Bootcamp.DSA.Basic.Queue;
// Queue Implementation: Circular Array-based Queue
class CircularArrayQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;

    public CircularArrayQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size < maxSize) {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            size++;
        } else {
            throw new IllegalStateException("Queue Overflow");
        }
    }

    public int dequeue() {
        if (size > 0) {
            int value = queueArray[front];
            front = (front + 1) % maxSize;
            size--;
            return value;
        } else {
            throw new IllegalStateException("Queue Underflow");
        }
    }

    public int front() {
        if (size > 0) {
            return queueArray[front];
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
// 1. Data Structure: Uses a fixed-size array (`queueArray`) with circular indexing to efficiently utilize space, avoiding wasted slots.
// 2. Key Components:
//    - `maxSize`: Defines the maximum capacity of the queue.
//    - `queueArray`: Stores elements as integers.
//    - `front`: Points to the index of the first element.
//    - `rear`: Points to the index of the last element.
//    - `size`: Tracks the number of elements to simplify `isEmpty` and overflow checks.
// 3. Operations:
//    - `enqueue`: Increments `rear` using modulo (`rear = (rear + 1) % maxSize`), adds the value at `queueArray[rear]`, and increments `size`. Checks for overflow (`size >= maxSize`). TC: O(1).
//    - `dequeue`: Returns the element at `queueArray[front]`, increments `front` using modulo, decrements `size`. Checks for underflow (`size <= 0`). TC: O(1).
//    - `front`: Returns the element at `queueArray[front]` without removing it. TC: O(1).
//    - `isEmpty`: Returns true if `size == 0`. TC: O(1).
//    - `size`: Returns `size`. TC: O(1).
// 4. Advantages:
//    - Constant-time operations due to direct array indexing and circular structure.
//    - Efficient space usage compared to linear array queue (no shifting required).
// 5. Limitations:
//    - Fixed capacity; cannot grow dynamically without resizing (not implemented here for simplicity).
//    - Wastes memory if the queue is underutilized.
// 6. Use Case: Suitable for scenarios with known maximum size and frequent FIFO operations (e.g., task scheduling, buffer management).
