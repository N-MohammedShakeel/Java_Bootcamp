package Java_Bootcamp.Collections.Iteration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Class to demonstrate iteration over a Set
class SetIterationDemo {
    // Demonstrates iteration methods on a Set (using HashSet).
    // Set does not allow duplicates and is typically unordered.

    public static void demonstrate() {
        System.out.println("\n=== Set Iteration Demonstration ===");

        // Create a Set
        Set<String> set = new HashSet<>(Arrays.asList("Dog", "Cat", "Bird", "Dog"));
        System.out.println("Set: " + set); // Output: [Dog, Cat, Bird] (order may vary)

        // 1. Iterator
        // - Same as List; supports remove() during iteration.
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
            // Example: Remove "Cat" during iteration
            if ("Cat".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println("Set after removing Cat: " + set); // Output: [Dog, Bird] (order may vary)

        // Restore set
        set = new HashSet<>(Arrays.asList("Dog", "Cat", "Bird"));

        // 2. Enhanced for loop (for-each)
        // - Simple for read-only access; no ListIterator for Set.
        System.out.println("\nUsing Enhanced for loop:");
        for (String item : set) {
            System.out.println(item);
        }

        // 3. forEach() with lambda expression
        // - Functional-style iteration for Set.
        System.out.println("\nUsing forEach with lambda:");
        set.forEach(item -> System.out.println(item));

        // 4. Stream API
        // - Powerful for filtering and transforming Set elements.
        System.out.println("\nUsing Stream API:");
        set.stream()
                .filter(item -> item.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println); // Output: BIRD
    }
}
