package Java_Bootcamp.DSA.Collections.ThreadSafetyAndConcurrent;

// Thread-Safety and Concurrent Collections
// Objective: Learn about collections for multi-threaded environments.

// In multi-threaded applications, collections must handle concurrent access safely to avoid data corruption.
// Non-synchronized collections (e.g., ArrayList, HashMap) are not thread-safe and can cause issues like ConcurrentModificationException.
// Java provides synchronized and concurrent collections to address thread-safety.

// Overview of Topics:
// 1. Issues with Non-Synchronized Collections:
//    - Can lead to data corruption or exceptions in multi-threaded access.
// 2. Legacy Synchronized Collections:
//    - Vector: Synchronized List, thread-safe but with performance overhead.
//    - Hashtable: Synchronized Map, thread-safe but outdated.
// 3. Modern Concurrent Collections (java.util.concurrent):
//    - ConcurrentHashMap: High-concurrency Map with fine-grained locking.
//    - CopyOnWriteArrayList: Thread-safe List optimized for read-heavy scenarios.
//    - BlockingQueue: Thread-safe queue for producer-consumer patterns (e.g., ArrayBlockingQueue).
// 4. Difference Between Synchronized and Concurrent Collections:
//    - Synchronized: Coarse-grained locking (entire collection locked), lower concurrency.
//    - Concurrent: Fine-grained locking or lock-free mechanisms, higher concurrency.

// This code demonstrates these concepts with practical examples.

// Main class to run all thread-safety and concurrent collections demonstrations
public class ThreadSafeCollectionsDemo {
    public static void main(String[] args) {
        // Run non-synchronized collection issues demonstration
        NonSynchronizedIssues.demonstrate();
        
        // Run legacy synchronized collections demonstration
        LegacySynchronizedCollections.demonstrate();
        
        // Run modern concurrent collections demonstration
        ConcurrentCollections.demonstrate();
    }
}