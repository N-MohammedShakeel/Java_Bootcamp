package Java_Bootcamp.DSA.Collections.UtilityMethodsInCollections;

import java.util.*;

// Class to demonstrate synchronized collections
class SynchronizedCollections {
    // Demonstrates Collections.synchronizedList() and Collections.synchronizedMap().

    public static void demonstrate() {
        System.out.println("\n=== Synchronized Collections Demonstration ===");

        // Create a List and Map
        List<String> list = new ArrayList<>(Arrays.asList("Dog", "Cat", "Bird"));
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 85);
        map.put("Bob", 92);

        // 1. Collections.synchronizedList()
        // - Returns a thread-safe List backed by the original List.
        // - Synchronization is required for iteration to avoid concurrent modification.
        // - Use Case: Thread-safe List operations in multi-threaded environments.
        List<String> synchronizedList = Collections.synchronizedList(list);
        System.out.println("Synchronized List: " + synchronizedList); // Output: [Dog, Cat, Bird]

        // Safe iteration requires synchronized block
        synchronized (synchronizedList) {
            System.out.println("Iterating synchronized List:");
            for (String item : synchronizedList) {
                System.out.println(item);
            }
        }

        // 2. Collections.synchronizedMap()
        // - Returns a thread-safe Map backed by the original Map.
        // - Synchronization is required for iteration.
        // - Use Case: Thread-safe key-value operations.
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);
        System.out.println("Synchronized Map: " + synchronizedMap); // Output: {Alice=85, Bob=92}

        // Safe iteration requires synchronized block
        synchronized (synchronizedMap) {
            System.out.println("Iterating synchronized Map:");
            for (Map.Entry<String, Integer> entry : synchronizedMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
