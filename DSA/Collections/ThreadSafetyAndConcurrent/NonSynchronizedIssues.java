package Java_Bootcamp.DSA.Collections.ThreadSafetyAndConcurrent;

import java.util.ArrayList;
import java.util.List;

// Class to demonstrate issues with non-synchronized collections
class NonSynchronizedIssues {
    // Shows problems when multiple threads access a non-synchronized collection.

    public static void demonstrate() {
        System.out.println("=== Non-Synchronized Collection Issues ===");

        // Create a non-synchronized List
        List<String> list = new ArrayList<>();

        // Runnable to add elements from multiple threads
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(Thread.currentThread().getName() + "-" + i);
            }
        };

        // Create and start two threads
        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Output size (may be inconsistent due to race conditions)
        System.out.println("List size (expected 200): " + list.size());
        // Note: Running this may cause ConcurrentModificationException or inconsistent size
    }
}
