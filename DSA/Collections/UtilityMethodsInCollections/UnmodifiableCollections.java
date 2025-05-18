package Java_Bootcamp.DSA.Collections.UtilityMethodsInCollections;

import java.util.*;

// Class to demonstrate unmodifiable collections
class UnmodifiableCollections {
    // Demonstrates Collections.unmodifiableList(), unmodifiableSet(), unmodifiableMap().

    public static void demonstrate() {
        System.out.println("\n=== Unmodifiable Collections Demonstration ===");

        // Create a List, Set, and Map
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        Set<String> set = new HashSet<>(Arrays.asList("Dog", "Cat", "Bird"));
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 85);
        map.put("Bob", 92);

        // 1. Collections.unmodifiableList()
        // - Returns a read-only view of a List; modifications throw UnsupportedOperationException.
        // - Use Case: Protecting a List from unintended changes (e.g., API return values).
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + unmodifiableList); // Output: [Apple, Banana, Orange]
        // unmodifiableList.add("Mango"); // Would throw UnsupportedOperationException
        System.out.println("Iterating unmodifiable List:");
        for (String item : unmodifiableList) {
            System.out.println(item);
        }

        // 2. Collections.unmodifiableSet()
        // - Returns a read-only view of a Set.
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
        System.out.println("Unmodifiable Set: " + unmodifiableSet); // Output: [Dog, Cat, Bird]
        // unmodifiableSet.add("Fish"); // Would throw UnsupportedOperationException
        System.out.println("Iterating unmodifiable Set:");
        for (String item : unmodifiableSet) {
            System.out.println(item);
        }

        // 3. Collections.unmodifiableMap()
        // - Returns a read-only view of a Map.
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println("Unmodifiable Map: " + unmodifiableMap); // Output: {Alice=85, Bob=92}
        // unmodifiableMap.put("Charlie", 88); // Would throw UnsupportedOperationException
        System.out.println("Iterating unmodifiable Map:");
        for (Map.Entry<String, Integer> entry : unmodifiableMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
