package Java_Bootcamp.Collections.Iteration;

import java.util.*;

// Class to demonstrate iteration over a List
class ListIterationDemo {
    // Demonstrates iteration methods on a List (using ArrayList).
    // List maintains order and allows duplicates.

    public static void demonstrate() {
        System.out.println("=== List Iteration Demonstration ===");

        // Create a List
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));
        System.out.println("List: " + list);

        // 1. Iterator
        // - Provides a way to traverse any Collection; supports remove() during iteration.
        // - Use Case: When you need to remove elements while iterating.
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
            // Example: Remove "Banana" during iteration
            if ("Banana".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println("List after removing Banana: " + list); // Output: [Apple, Orange, Mango]

        // Restore list for further demonstrations
        list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));

        // 2. ListIterator
        // - Specialized for List; supports bidirectional traversal and add/set operations.
        // - Use Case: When you need to traverse backward or modify elements at specific positions.
        System.out.println("\nUsing ListIterator (forward and backward):");
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("Forward:");
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            System.out.println(item);
            // Example: Replace "Orange" with "Grape"
            if ("Orange".equals(item)) {
                listIterator.set("Grape");
            }
        }
        System.out.println("List after replacing Orange with Grape: " + list); // Output: [Apple, Banana, Grape, Mango]
        System.out.println("Backward:");
        while (listIterator.hasPrevious()) {
            String item = listIterator.previous();
            System.out.println(item);
        }

        // Restore list
        list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));

        // 3. Enhanced for loop (for-each)
        // - Simple and readable; best for read-only sequential access.
        // - Use Case: When you only need to read elements without modification.
        System.out.println("\nUsing Enhanced for loop:");
        for (String item : list) {
            System.out.println(item);
        }

        // 4. forEach() with lambda expression
        // - Functional-style iteration; concise for simple operations.
        // - Use Case: When you want to perform an action on each element in a functional style.
        System.out.println("\nUsing forEach with lambda:");
        list.forEach(item -> System.out.println(item));

        // 5. Stream API
        // - Functional-style iteration with operations like filter, map, and collect.
        // - Use Case: When you need to process elements with complex operations (e.g., filtering, transforming).
        System.out.println("\nUsing Stream API:");
        list.stream()
                .filter(item -> item.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println); // Output: APPLE
    }
}
