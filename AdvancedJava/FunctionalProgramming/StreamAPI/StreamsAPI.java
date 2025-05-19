package Java_Bootcamp.AdvancedJava.FunctionalProgramming.StreamAPI;// Java Fundamentals: Streams API
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Streams API Overview
-------------------
- Introduced in Java 8, the Streams API (java.util.stream) enables functional-style operations on collections or other data sources.
- Streams process sequences of elements in a declarative, pipeline-based manner, supporting operations like filtering, mapping, and reducing.
- Key Characteristics:
  - Lazy evaluation: Operations are not executed until a terminal operation is invoked.
  - Non-interfering: Streams do not modify the underlying data source.
  - Single-use: A stream can be consumed only once.
- Stream Pipeline: Source → Intermediate Operations → Terminal Operation
- Example: list.stream().filter(n -> n > 0).map(n -> n * 2).collect(Collectors.toList());

1. Creating and Manipulating Streams
-----------------------------------
- Creating Streams:
  - From collections: Collection.stream() (e.g., list.stream()).
  - From arrays: Arrays.stream(array).
  - From static methods: Stream.of(values), Stream.iterate(), Stream.generate().
  - From other sources: Files.lines(), Random.ints().
- Manipulating Streams:
  - Use intermediate operations to transform or filter data.
  - Use terminal operations to produce a result or side effect.
- Example: Stream.of(1, 2, 3).filter(n -> n % 2 == 0).forEach(System.out::println);
- Notes:
  - Streams can be sequential (default) or parallel for concurrent processing.
  - Ensure thread safety when modifying shared data in parallel streams.

2. Intermediate Operations
-------------------------
- Operations that transform a stream into another stream, executed lazily.
- Common Intermediate Operations:
  - filter(Predicate<T>): Retains elements matching the predicate.
    - Example: filter(n -> n > 0) keeps positive numbers.
  - map(Function<T, R>): Transforms each element to a new type.
    - Example: map(String::toUpperCase) converts strings to uppercase.
  - sorted(): Sorts elements (natural order or using Comparator).
    - Example: sorted() sorts numbers or strings.
  - Other operations: distinct(), limit(), skip(), flatMap().
- Notes:
  - Intermediate operations are not executed until a terminal operation is called.
  - Can be chained to form a pipeline: stream.filter(...).map(...).sorted().
  - Stateless (e.g., filter, map) vs. stateful (e.g., sorted, distinct) operations.

3. Terminal Operations
---------------------
- Operations that produce a result or side effect, triggering the stream pipeline execution.
- Common Terminal Operations:
  - collect(Collector): Collects elements into a collection (e.g., List, Set, Map).
    - Example: collect(Collectors.toList()) creates a List.
  - forEach(Consumer): Performs an action for each element.
    - Example: forEach(System.out::println) prints each element.
  - reduce(BinaryOperator): Combines elements into a single result.
    - Example: reduce(0, Integer::sum) computes the sum of elements.
  - Other operations: count(), min(), max(), anyMatch(), allMatch(), noneMatch().
- Notes:
  - A stream is closed after a terminal operation; it cannot be reused.
  - Some operations (e.g., collect, reduce) produce results; others (e.g., forEach) produce side effects.

4. Parallel Streams
------------------
- Streams that execute operations concurrently using multiple threads, leveraging multi-core processors.
- Creation:
  - Use Collection.parallelStream() or Stream.parallel().
  - Example: list.parallelStream().filter(...).collect(Collectors.toList());
- Use Cases:
  - Large datasets where operations (e.g., filter, map) can be parallelized.
  - CPU-intensive tasks like sorting or complex transformations.
- Notes:
  - Parallel streams use the ForkJoinPool (common pool by default).
  - Ensure operations are thread-safe and stateless to avoid race conditions.
  - Overhead of parallelization may outweigh benefits for small datasets.
  - Use with caution: Debugging and performance tuning are more complex.
*/

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {
    public static void main(String[] args) {
        // Sample data
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "apple");

        // Example 1: Creating Streams
        System.out.println("Example 1: Creating Streams");
        // From collection
        Stream<Integer> numberStream = numbers.stream();
        System.out.print("Numbers: ");
        numberStream.forEach(n -> System.out.print(n + " "));
        // From array
        System.out.print("\nArray Stream: ");
        Arrays.stream(new int[]{1, 2, 3}).forEach(n -> System.out.print(n + " "));
        // From Stream.of
        System.out.print("\nStream.of: ");
        Stream.of("a", "b", "c").forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Example 2: Intermediate Operations (filter, map, sorted)
        System.out.println("\nExample 2: Intermediate Operations");
        System.out.print("Even numbers, doubled, sorted: ");
        numbers.stream()
               .filter(n -> n % 2 == 0) // Keep even numbers
               .map(n -> n * 2) // Double each number
               .sorted() // Sort in ascending order
               .forEach(n -> System.out.print(n + " ")); // 4 16
        System.out.println();

        // Example 3: Terminal Operations (collect, forEach, reduce)
        System.out.println("\nExample 3: Terminal Operations");
        // collect: Gather unique words into a Set
        Set<String> uniqueWords = words.stream()
                                      .distinct()
                                      .collect(Collectors.toSet());
        System.out.println("Unique words: " + uniqueWords);
        // forEach: Print uppercase words
        System.out.print("Uppercase words: ");
        words.stream()
             .map(String::toUpperCase)
             .forEach(s -> System.out.print(s + " "));
        // reduce: Sum of numbers
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("\nSum of numbers: " + sum);

        // Example 4: Parallel Streams
        System.out.println("\nExample 4: Parallel Streams");
        System.out.print("Parallel processing (sorted numbers): ");
        numbers.parallelStream()
               .filter(n -> {
                   System.out.println("Filtering " + n + " on thread " + Thread.currentThread().getName());
                   return n > 3;
               })
               .sorted()
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Example 5: Combining Operations
        System.out.println("\nExample 5: Combining Operations");
        List<String> result = words.stream()
                                  .filter(s -> s.length() > 4) // Words longer than 4 chars
                                  .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)) // Capitalize first letter
                                  .sorted() // Sort alphabetically
                                  .collect(Collectors.toList());
        System.out.println("Capitalized words (length > 4): " + result);
    }
}