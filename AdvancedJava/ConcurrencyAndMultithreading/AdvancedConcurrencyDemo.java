package Java_Bootcamp.AdvancedJava.ConcurrencyAndMultithreading;// Java Fundamentals: Advanced Concurrency (java.util.concurrent)
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Advanced Concurrency Overview
----------------------------
- The java.util.concurrent package provides high-level concurrency utilities for efficient, scalable multithreading.
- Key Features:
  - Executors: Manage thread pools to reuse threads and reduce overhead.
  - Thread-Safe Collections: ConcurrentHashMap, CopyOnWriteArrayList for safe shared data access.
  - Locks: ReentrantLock, ReadWriteLock for fine-grained synchronization.
  - Synchronizers: CountDownLatch, CyclicBarrier, Semaphore, etc., for thread coordination.
  - Atomic Variables: AtomicInteger, etc., for lock-free updates.
  - Fork/Join: Parallel processing framework for divide-and-conquer tasks.
  - Volatile Keyword: Ensures memory visibility and prevents instruction reordering.
- Use Cases:
  - High-performance servers, parallel data processing, real-time systems.
- Notes:
  - Prefer high-level utilities over manual thread management for reliability.
  - Use thread pools to limit resource usage.
  - Handle concurrency issues like deadlocks and race conditions carefully.
*/

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.*;

public class AdvancedConcurrencyDemo {
    public static void main(String[] args) {
        // Example 1: ExecutorService with Thread Pool
        System.out.println("Example 1: ExecutorService with Thread Pool");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Executor interrupted: " + e.getMessage());
        }

        // Example 2: Callable and Future
        System.out.println("\nExample 2: Callable and Future");
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor2.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });
        try {
            System.out.println("Future result: " + future.get(2, TimeUnit.SECONDS));
        } catch (Exception e) {
            System.err.println("Future error: " + e.getMessage());
        }
        executor2.shutdown();

        // Example 3: ConcurrentHashMap
        System.out.println("\nExample 3: ConcurrentHashMap");
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor3 = Executors.newFixedThreadPool(2);
        executor3.submit(() -> map.put("Key1", 1));
        executor3.submit(() -> map.computeIfPresent("Key1", (k, v) -> v + 1));
        executor3.shutdown();
        try {
            executor3.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("ConcurrentHashMap: " + map);
        } catch (InterruptedException e) {
            System.err.println("Map executor interrupted");
        }

        // Example 4: ReentrantLock
        System.out.println("\nExample 4: ReentrantLock");
        ReentrantLock lock = new ReentrantLock();
        Runnable lockedTask = () -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Locked task interrupted");
            } finally {
                lock.unlock();
            }
        };
        Thread t1 = new Thread(lockedTask, "LockThread1");
        Thread t2 = new Thread(lockedTask, "LockThread2");
        t1.start();
        t2.start();

        // Example 5: CountDownLatch
        System.out.println("\nExample 5: CountDownLatch");
        CountDownLatch latch = new CountDownLatch(2);
        Runnable latchTask = () -> {
            System.out.println(Thread.currentThread().getName() + " completed");
            latch.countDown();
        };
        ExecutorService executor4 = Executors.newFixedThreadPool(2);
        executor4.submit(latchTask);
        executor4.submit(latchTask);
        try {
            latch.await(2, TimeUnit.SECONDS);
            System.out.println("All tasks completed");
        } catch (InterruptedException e) {
            System.err.println("Latch interrupted");
        }
        executor4.shutdown();

        // Example 6: AtomicInteger
        System.out.println("\nExample 6: AtomicInteger");
        AtomicInteger atomicCount = new AtomicInteger(0);
        ExecutorService executor5 = Executors.newFixedThreadPool(2);
        executor5.submit(() -> atomicCount.incrementAndGet());
        executor5.submit(() -> atomicCount.incrementAndGet());
        executor5.shutdown();
        try {
            executor5.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("Atomic count: " + atomicCount.get());
        } catch (InterruptedException e) {
            System.err.println("Atomic executor interrupted");
        }

        // Example 7: Fork/Join Framework
        System.out.println("\nExample 7: Fork/Join Framework");
        ForkJoinPool pool = ForkJoinPool.commonPool();
        class SumTask extends RecursiveTask<Integer> {
            private final int[] numbers;
            private final int start, end;

            SumTask(int[] numbers, int start, int end) {
                this.numbers = numbers;
                this.start = start;
                this.end = end;
            }

            @Override
            protected Integer compute() {
                if (end - start <= 2) {
                    int sum = 0;
                    for (int i = start; i < end; i++) sum += numbers[i];
                    return sum;
                }
                int mid = (start + end) / 2;
                SumTask left = new SumTask(numbers, start, mid);
                SumTask right = new SumTask(numbers, mid, end);
                left.fork();
                return right.compute() + left.join();
            }
        }
        int[] numbers = {1, 2, 3, 4, 5};
        SumTask task = new SumTask(numbers, 0, numbers.length);
        int sum = pool.invoke(task);
        System.out.println("Fork/Join sum: " + sum);

        // Example 8: Volatile Keyword
        System.out.println("\nExample 8: Volatile Keyword");
        class VolatileExample {
            volatile boolean running = true;
        }
        VolatileExample example = new VolatileExample();
        Thread volatileThread = new Thread(() -> {
            while (example.running) {
                // Simulate work
            }
            System.out.println("VolatileThread stopped");
        }, "VolatileThread");
        volatileThread.start();
        try {
            Thread.sleep(100);
            example.running = false;
        } catch (InterruptedException e) {
            System.err.println("Volatile sleep interrupted");
        }
    }
}