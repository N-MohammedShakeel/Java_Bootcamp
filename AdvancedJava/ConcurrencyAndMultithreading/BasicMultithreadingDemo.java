package Java_Bootcamp.AdvancedJava.ConcurrencyAndMultithreading;// Java Fundamentals: Basic Multithreading
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Basic Multithreading Overview
----------------------------
- Multithreading allows multiple threads to run concurrently in a program, improving performance and responsiveness.
- Key Concepts:
  - Thread: A lightweight unit of execution within a process.
  - Process vs. Thread: A process is an independent program; a thread is a subunit sharing the process's memory.
  - Thread Creation: Extend Thread, implement Runnable, or use Callable with Future.
  - Thread Lifecycle: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED.
  - Synchronization: Ensures thread-safe access to shared resources using synchronized keyword or locks.
  - Inter-Thread Communication: Uses wait(), notify(), notifyAll() for coordination.
- Use Cases:
  - Parallel task execution (e.g., downloading files while updating UI).
  - Improving CPU utilization in multi-core systems.
- Notes:
  - Threads share memory, so synchronization is critical to avoid data inconsistency.
  - Handle InterruptedException for interruptible operations (e.g., sleep).
*/

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class BasicMultithreadingDemo {
    // Example 1: Extending Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread running: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                System.out.println("MyThread interrupted");
            }
        }
    }

    // Example 2: Implementing Runnable
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable running: " + Thread.currentThread().getName());
            Thread.yield(); // Suggest yielding CPU
        }
    }

    // Example 3: Using Callable and Future
    static class MyCallable implements Callable<String> {
        @Override
        public String call() {
            System.out.println("MyCallable running: " + Thread.currentThread().getName());
            return "Result from Callable";
        }
    }

    // Example 4: Synchronization and Inter-Thread Communication
    static class Counter {
        private int count = 0;

        // Synchronized method
        public synchronized void increment() {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        }

        // Synchronized block for producer-consumer
        public void produce() throws InterruptedException {
            synchronized (this) {
                System.out.println("Producer producing...");
                count += 10;
                notify(); // Wake up waiting consumer
                Thread.sleep(1000); // Simulate work
            }
        }

        public void consume() throws InterruptedException {
            synchronized (this) {
                while (count == 0) {
                    System.out.println("Consumer waiting...");
                    wait(); // Wait for producer
                }
                System.out.println("Consumer consumed, count: " + count);
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        // Example 1: Extending Thread
        System.out.println("Example 1: Extending Thread");
        MyThread thread1 = new MyThread();
        thread1.setPriority(Thread.MAX_PRIORITY); // Set high priority
        thread1.start(); // Start thread (NEW -> RUNNABLE)

        // Example 2: Implementing Runnable
        System.out.println("\nExample 2: Implementing Runnable");
        Thread thread2 = new Thread(new MyRunnable(), "RunnableThread");
        thread2.start();

        // Example 3: Using Callable and Future
        System.out.println("\nExample 3: Callable and Future");
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread3 = new Thread(futureTask, "CallableThread");
        thread3.start();
        try {
            System.out.println("Callable result: " + futureTask.get());
        } catch (Exception e) {
            System.err.println("Error with Callable: " + e.getMessage());
        }

        // Example 4: Thread Methods (join, interrupt)
        System.out.println("\nExample 4: Thread Methods");
        Thread thread4 = new Thread(() -> {
            try {
                System.out.println("Thread4 sleeping...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread4 interrupted: " + Thread.currentThread().isInterrupted());
            }
        }, "Thread4");
        thread4.start();
        thread4.interrupt(); // Interrupt sleeping thread
        try {
            thread4.join(); // Wait for thread4 to finish
            System.out.println("Thread4 joined");
        } catch (InterruptedException e) {
            System.err.println("Join interrupted: " + e.getMessage());
        }

        // Example 5: Synchronization (Race Condition Prevention)
        System.out.println("\nExample 5: Synchronization");
        Counter counter = new Counter();
        Runnable incrementTask = counter::increment;
        Thread t1 = new Thread(incrementTask, "T1");
        Thread t2 = new Thread(incrementTask, "T2");
        t1.start();
        t2.start();

        // Example 6: Inter-Thread Communication (Producer-Consumer)
        System.out.println("\nExample 6: Producer-Consumer");
        Counter sharedCounter = new Counter();
        Thread producer = new Thread(() -> {
            try {
                sharedCounter.produce();
            } catch (InterruptedException e) {
                System.err.println("Producer interrupted");
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            try {
                sharedCounter.consume();
            } catch (InterruptedException e) {
                System.err.println("Consumer interrupted");
            }
        }, "Consumer");
        consumer.start(); // Start consumer first to wait
        producer.start();
    }
}