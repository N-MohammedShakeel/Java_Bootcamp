package Java_Bootcamp.Collections.ThreadSafetyAndConcurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

// Class to demonstrate modern concurrent collections
class ConcurrentCollections {
    // Demonstrates ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue.

    public static void demonstrate() {
        System.out.println("\n=== Modern Concurrent Collections ===");

        // 1. ConcurrentHashMap
        // - Thread-safe Map with fine-grained locking for high concurrency.
        // - Allows concurrent reads and updates without locking the entire map.
        // - Use Case: High-concurrency key-value storage (e.g., shared cache).
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        Runnable mapTask = () -> {
            for (int i = 0; i < 100; i++) {
                concurrentMap.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        Thread t1 = new Thread(mapTask, "MapThread1");
        Thread t2 = new Thread(mapTask, "MapThread2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ConcurrentHashMap size: " + concurrentMap.size()); // Output: 200

        // 2. CopyOnWriteArrayList
        // - Thread-safe List that creates a new copy of the underlying array on each write.
        // - Optimized for read-heavy scenarios; writes are expensive.
        // - Use Case: Thread-safe list with frequent reads (e.g., event listeners).
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();

        Runnable listTask = () -> {
            for (int i = 0; i < 100; i++) {
                cowList.add(Thread.currentThread().getName() + "-" + i);
            }
        };

        Thread t3 = new Thread(listTask, "ListThread1");
        Thread t4 = new Thread(listTask, "ListThread2");
        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CopyOnWriteArrayList size: " + cowList.size()); // Output: 200

        // 3. BlockingQueue (using ArrayBlockingQueue)
        // - Thread-safe queue for producer-consumer patterns.
        // - Supports blocking operations (e.g., put() waits if full, take() waits if empty).
        // - Use Case: Coordinating producers and consumers (e.g., task queues).
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger(0);

        // Producer
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    int value = counter.incrementAndGet();
                    queue.put(value);
                    System.out.println(Thread.currentThread().getName() + " produced: " + value);
                    Thread.sleep(100); // Simulate work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Consumer
        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    int value = queue.take();
                    System.out.println(Thread.currentThread().getName() + " consumed: " + value);
                    Thread.sleep(200); // Simulate work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
