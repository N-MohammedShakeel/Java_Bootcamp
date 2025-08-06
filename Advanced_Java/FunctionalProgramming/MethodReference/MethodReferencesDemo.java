package Java_Bootcamp.Advanced_Java.FunctionalProgramming.MethodReference;// Java Fundamentals: Method References
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Method References Overview
-------------------------
- Introduced in Java 8, method references provide a shorthand for lambda expressions that invoke existing methods.
- Syntax: ClassName::methodName or instance::methodName
- Purpose: Improve code readability and reduce boilerplate by directly referring to methods.
- Key Types of Method References:
  1. Static method reference: ClassName::staticMethod
     - Example: Integer::parseInt (replaces s -> Integer.parseInt(s))
  2. Instance method reference (specific object): instance::instanceMethod
     - Example: System.out::println (replaces x -> System.out.println(x))
  3. Instance method reference (arbitrary object): ClassName::instanceMethod
     - Example: String::toUpperCase (replaces s -> s.toUpperCase())
  4. Constructor reference: ClassName::new
     - Example: String::new (replaces () -> new String())
- Use Cases:
  - Stream operations (map, filter, forEach).
  - Functional interfaces implementation.
  - Simplifying lambda expressions for common operations.
- Notes:
  - Method references are syntactic sugar for lambdas; the method signature must match the functional interface's SAM.
  - Can only be used when the lambda simply delegates to an existing method.
  - Improves code clarity but requires understanding of the target method's signature.
*/

import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;

public class MethodReferencesDemo {
    public static void main(String[] args) {
        // Sample data
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Example 1: Static Method Reference
        System.out.println("Example 1: Static Method Reference");
        Function<String, Integer> parseInt = Integer::parseInt;
        System.out.println("Parse '123': " + parseInt.apply("123")); // 123
        List<String> numberStrings = Arrays.asList("1", "2", "3");
        List<Integer> numbers = numberStrings.stream()
                                             .map(Integer::parseInt)
                                             .toList(); // .collect(Collectors.toList());
        System.out.println("Parsed numbers: " + numbers); // [1, 2, 3]

        // Example 2: Instance Method Reference (Specific Object)
        System.out.println("\nExample 2: Instance Method Reference (Specific Object)");
        Consumer<String> printer = System.out::println;
        printer.accept("Hello, World!"); // Hello, World!
        System.out.print("Printing words: ");
        words.forEach(System.out::println); // apple banana cherry

        // Example 3: Instance Method Reference (Arbitrary Object)
        System.out.println("\nExample 3: Instance Method Reference (Arbitrary Object)");
        Function<String, String> toUpper = String::toUpperCase;
        System.out.println("Uppercase 'java': " + toUpper.apply("java")); // JAVA
        List<String> upperWords = words.stream()
                                       .map(String::toUpperCase)
                                       .toList();
        System.out.println("Uppercase words: " + upperWords); // [APPLE, BANANA, CHERRY]

        // Example 4: Constructor Reference
        System.out.println("\nExample 4: Constructor Reference");
        Supplier<String> stringCreator = String::new;
        String newString = stringCreator.get();
        System.out.println("New string (empty): '" + newString + "'"); // ''
        List<String> copiedWords = words.stream()
                                        .map(String::new) // Method Ref  // .map(s -> new String(s)) // Lambda equivalent
                                        .toList();
        System.out.println("Copied words: " + copiedWords); // [apple, banana, cherry]

        // Example 5: Combining Method References in Streams
        System.out.println("\nExample 5: Combining Method References in Streams");
        List<String> sortedWords = words.stream()
                                        .filter(String::isEmpty) // No empty strings in this case
                                        .map(String::toUpperCase)
                                        .sorted(String::compareTo)
                                        .toList();
        System.out.println("Filtered, uppercased, sorted (empty filter): " + sortedWords); // []

        // Example 6: Custom Instance Method Reference
        System.out.println("\nExample 6: Custom Instance Method Reference");
        StringFormatter formatter = new StringFormatter();
        Function<String, String> addPrefix = formatter::addPrefix;
        System.out.println("Prefixed 'test': " + addPrefix.apply("test")); // PREFIX_test
    }
}

