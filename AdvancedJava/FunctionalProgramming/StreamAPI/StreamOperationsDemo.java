package Java_Bootcamp.AdvancedJava.FunctionalProgramming.StreamAPI;

import java.util.*;
import java.util.stream.*;

public class StreamOperationsDemo {
    public static void main(String[] args) {
        // Sample data
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 2);
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "date");

        // 1. Stream Creation
        System.out.println("=== Stream Creation Examples ===");

        // 1.1 stream() - Sequential stream from a collection
        System.out.println("1.1 stream() - Sequential stream from numbers");
        Stream<Integer> seqStream = numbers.stream();
        seqStream.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 1.2 parallelStream() - Parallel stream from a collection
        System.out.println("1.2 parallelStream() - Parallel stream from numbers");
        Stream<Integer> parStream = numbers.parallelStream();
        parStream.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 1.3 Stream.of(...) - Stream from values
        System.out.println("1.3 Stream.of() - Stream from values");
        Stream<String> valueStream = Stream.of("cat", "dog", "bird");
        valueStream.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 1.4 Arrays.stream(array) - Stream from an array
        System.out.println("1.4 Arrays.stream() - Stream from array");
        Integer[] numArray = {4, 7, 2};
        Stream<Integer> arrayStream = Arrays.stream(numArray);
        arrayStream.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2. Intermediate Operations
        System.out.println("\n=== Intermediate Operations Examples ===");
        
        // 2.1 filter(Predicate) - Select elements > 5
        System.out.println("2.1 filter() - Numbers > 5");
        numbers.stream()
            .filter(n -> n > 5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2.2 map(Function) - Convert strings to uppercase
        System.out.println("2.2 map() - Words to uppercase");
        words.stream()
            .map(String::toUpperCase)
            .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 2.3 flatMap(Function) - Flatten nested lists
        System.out.println("2.3 flatMap() - Flatten nested lists");
        List<List<String>> nestedWords = Arrays.asList(
            Arrays.asList("apple", "banana"),
            Arrays.asList("cherry", "date")
        );
        nestedWords.stream()
            .flatMap(List::stream)
            .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 2.4 distinct() - Remove duplicates
        System.out.println("2.4 distinct() - Unique words");
        words.stream()
            .distinct()
            .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 2.5 sorted() - Sort numbers in natural order
        System.out.println("2.5 sorted() - Numbers in natural order");
        numbers.stream()
            .sorted()
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2.6 sorted(Comparator) - Sort words in reverse order
        System.out.println("2.6 sorted(Comparator) - Words in reverse order");
        words.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 2.7 limit(n) - Limit to first 3 numbers
        System.out.println("2.7 limit() - First 3 numbers");
        numbers.stream()
            .limit(3)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2.8 skip(n) - Skip first 2 numbers
        System.out.println("2.8 skip() - Skip first 2 numbers");
        numbers.stream()
            .skip(2)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2.9 peek(Consumer) - Debug numbers > 3
        System.out.println("2.9 peek() - Debug numbers > 3");
        numbers.stream()
            .filter(n -> n > 3)
            .peek(n -> System.out.println("Processing: " + n))
            .forEach(n -> System.out.println("Result: " + n));
        System.out.println();

        // 3. Terminal Operations
        System.out.println("\n=== Terminal Operations Examples ===");
        
        // 3.1 collect(Collector) - Collect numbers > 5 into a list
        System.out.println("3.1 collect() - Numbers > 5 into list");
        List<Integer> filteredNumbers = numbers.stream()
            .filter(n -> n > 5)
            .collect(Collectors.toList());
        System.out.println(filteredNumbers);
        System.out.println();

        // 3.2 forEach(Consumer) - Print each word
        System.out.println("3.2 forEach() - Print each word");
        words.stream()
            .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 3.3 toArray() - Convert numbers to array
        System.out.println("3.3 toArray() - Numbers to array");
        Object[] numArrayResult = numbers.stream().toArray();
        System.out.println(Arrays.toString(numArrayResult));
        System.out.println();

        // 3.4 reduce(BinaryOperator) - Sum of numbers
        System.out.println("3.4 reduce() - Sum of numbers");
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        System.out.println();

        // 3.5 count() - Count numbers
        System.out.println("3.5 count() - Count numbers");
        long count = numbers.stream().count();
        System.out.println("Count: " + count);
        System.out.println();

        // 3.6 min(Comparator) - Smallest number
        System.out.println("3.6 min() - Smallest number");
        Optional<Integer> min = numbers.stream()
            .min(Comparator.naturalOrder());
        min.ifPresent(n -> System.out.println("Min: " + n));
        System.out.println();

        // 3.7 max(Comparator) - Largest number
        System.out.println("3.7 max() - Largest number");
        Optional<Integer> max = numbers.stream()
            .max(Comparator.naturalOrder());
        max.ifPresent(n -> System.out.println("Max: " + n));
        System.out.println();

        // 3.8 anyMatch(Predicate) - Check if any number > 10
        System.out.println("3.8 anyMatch() - Any number > 10");
        boolean anyMatch = numbers.stream()
            .anyMatch(n -> n > 10);
        System.out.println("Any number > 10: " + anyMatch);
        System.out.println();

        // 3.9 allMatch(Predicate) - Check if all numbers > 0
        System.out.println("3.9 allMatch() - All numbers > 0");
        boolean allMatch = numbers.stream()
            .allMatch(n -> n > 0);
        System.out.println("All numbers > 0: " + allMatch);
        System.out.println();

        // 3.10 noneMatch(Predicate) - Check if no number < 0
        System.out.println("3.10 noneMatch() - No number < 0");
        boolean noneMatch = numbers.stream()
            .noneMatch(n -> n < 0);
        System.out.println("No number < 0: " + noneMatch);
        System.out.println();

        // 3.11 findFirst() - First number
        System.out.println("3.11 findFirst() - First number");
        Optional<Integer> first = numbers.stream()
            .findFirst();
        first.ifPresent(n -> System.out.println("First: " + n));
        System.out.println();

        // 3.12 findAny() - Any number (parallel stream)
        System.out.println("3.12 findAny() - Any number in parallel stream");
        Optional<Integer> any = numbers.parallelStream()
            .findAny();
        any.ifPresent(n -> System.out.println("Any: " + n));
    }
}