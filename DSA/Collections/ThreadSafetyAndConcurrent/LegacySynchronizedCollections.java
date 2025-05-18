package Java_Bootcamp.DSA.Collections.ThreadSafetyAndConcurrent;

import java.util.Hashtable;
import java.util.Vector;

// Class to demonstrate legacy synchronized collections
class LegacySynchronizedCollections {
    // Demonstrates Vector and Hashtable in a multi-threaded environment.

    public static void demonstrate() {
        System.out.println("\n=== Legacy Synchronized Collections ===");

        // Vector: Synchronized List
        Vector<String> vector = new Vector<>();

        // Runnable to add elements
        Runnable vectorTask = () -> {
            for (int i = 0; i < 100; i++) {
                vector.add(Thread.currentThread().getName() + "-" + i);
            }
        };

        // Create and start threads
        Thread t1 = new Thread(vectorTask, "VectorThread1");
        Thread t2 = new Thread(vectorTask, "VectorThread2");
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Vector size: " + vector.size()); // Output: 200 (consistent due to synchronization)

        // Hashtable: Synchronized Map
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // Runnable to add key-value pairs
        Runnable hashtableTask = () -> {
            for (int i = 0; i < 100; i++) {
                hashtable.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        // Create and start threads
        Thread t3 = new Thread(hashtableTask, "HashtableThread1");
        Thread t4 = new Thread(hashtableTask, "HashtableThread2");
        t3.start();
        t4.start();

        // Wait for threads to finish
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hashtable size: " + hashtable.size()); // Output: 200 (consistent)
    }
}
