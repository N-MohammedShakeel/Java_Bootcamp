package Java_Bootcamp.Collections.List_Interface; /**
 * StackDemo.java
 * Demonstrates the Java Stack class with various datatypes and methods.
 * Scenario: Managing a stack for DSA applications (e.g., expression evaluation, thread-safe tasks).
 * Features: Examples of primitive and non-primitive datatypes, inherited Vector methods, and stack-specific methods.
 */
import java.util.*;
import java.util.stream.Stream;

public class StackDemo {
    public static void demonstrate() {
        System.out.println("\n=== Stack Demonstration with All Datatypes ===");

        // 1. Stack with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Integer Stack
        // Purpose: Store 32-bit integers for DSA problems (e.g., expression evaluation)
        // Key Features: LIFO behavior, thread-safe
        // Use Case: Postfix expression evaluation
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1000);
        intStack.push(2000);
        System.out.println("Integer Stack: " + intStack); // [1000, 2000]

        // Double Stack
        // Purpose: Store 64-bit floating-point numbers
        // Key Features: High precision, LIFO
        // Use Case: Scientific calculations with stack
        Stack<Double> doubleStack = new Stack<>();
        doubleStack.push(100.5);
        doubleStack.push(200.5);
        System.out.println("Double Stack: " + doubleStack); // [100.5, 200.5]

        // Character Stack
        // Purpose: Store single characters
        // Key Features: Supports Unicode, LIFO
        // Use Case: Parentheses matching (LeetCode #20)
        Stack<Character> charStack = new Stack<>();
        charStack.push('A');
        charStack.push('B');
        System.out.println("Character Stack: " + charStack); // [A, B]

        // Boolean Stack
        // Purpose: Store true/false values
        // Key Features: Minimal memory, LIFO
        // Use Case: Flag-based algorithms
        Stack<Boolean> boolStack = new Stack<>();
        boolStack.push(true);
        boolStack.push(false);
        System.out.println("Boolean Stack: " + boolStack); // [true, false]

        // 2. Stack with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String Stack
        // Purpose: Store text strings
        // Key Features: LIFO, thread-safe
        // Use Case: Undo functionality for text
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Apple");
        stringStack.push("Banana");
        System.out.println("String Stack: " + stringStack); // [Apple, Banana]

        // Custom Object (Person) Stack
        // Purpose: Store user-defined objects
        // Key Features: Requires proper equals/hashCode for search
        // Use Case: Store task objects in thread-safe context
        Stack<Person> personStack = new Stack<>();
        personStack.push(new Person("Alice", 25));
        personStack.push(new Person("Bob", 30));
        System.out.println("Person Stack: " + personStack); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}]

        // Nested Collection Stack
        // Purpose: Store collections within a stack
        // Key Features: Supports complex structures
        // Use Case: Graph algorithms (e.g., DFS with adjacency lists)
        Stack<List<Integer>> nestedStack = new Stack<>();
        nestedStack.push(Arrays.asList(1, 2, 3));
        nestedStack.push(Arrays.asList(4, 5, 6));
        System.out.println("Nested Stack: " + nestedStack); // [[1, 2, 3], [4, 5, 6]]

        // 3. Stack Methods Demonstration
        System.out.println("\n3. Stack Methods Demonstration:");
        Stack<String> stack = new Stack<>();
        stack.push("Car");
        stack.push("Bus");
        stack.push("Train");
        System.out.println("Initial Stack: " + stack); // [Car, Bus, Train]

        // Stack-Specific Methods
        System.out.println("\nStack-Specific Methods:");
        // push(E): Pushes element onto the stack
        // Time Complexity: O(1) amortized, synchronized
        // Use Case: Add elements in LIFO order
        stack.push("Bike");
        System.out.println("After push(Bike): " + stack); // [Car, Bus, Train, Bike]

        // pop(): Removes and returns top element
        // Time Complexity: O(1), synchronized
        // Use Case: Retrieve and remove latest element
        try {
            String popped = stack.pop();
            System.out.println("Popped: " + popped + ", Stack: " + stack); // Popped: Bike, Stack: [Car, Bus, Train]
        } catch (EmptyStackException e) {
            System.err.println("Error popping: Stack is empty");
        }

        // peek(): Returns top element without removing
        // Time Complexity: O(1), synchronized
        // Use Case: Inspect latest element
        try {
            String peeked = stack.peek();
            System.out.println("Peeked: " + peeked + ", Stack: " + stack); // Peeked: Train, Stack: [Car, Bus, Train]
        } catch (EmptyStackException e) {
            System.err.println("Error peeking: Stack is empty");
        }

        // empty(): Checks if stack is empty
        // Time Complexity: O(1), synchronized
        // Use Case: Pre-condition check for pop/peek
        System.out.println("Is stack empty? " + stack.empty()); // false

        // search(Object): Returns 1-based position from top
        // Time Complexity: O(n), synchronized
        // Use Case: Find element position in stack
        System.out.println("Position of Bus: " + stack.search("Bus")); // 2
        System.out.println("Position of Truck: " + stack.search("Truck")); // -1

        // Inherited Collection Interface Methods
        System.out.println("\nCollection Interface Methods (Inherited via Vector):");
        // contains(Object): Checks if element exists
        // Time Complexity: O(n), synchronized
        // Use Case: Membership testing
        System.out.println("Contains Train? " + stack.contains("Train")); // true

        // remove(Object): Removes first occurrence
        // Time Complexity: O(n), synchronized
        // Use Case: Remove specific elements
        stack.remove("Car");
        System.out.println("After remove(Car): " + stack); // [Bus, Train]

        // size(): Returns number of elements
        // Time Complexity: O(1), synchronized
        // Use Case: Loop bounds
        System.out.println("Size: " + stack.size()); // 2

        // toArray(): Returns array of elements
        // Time Complexity: O(n), synchronized
        // Use Case: Convert to array for processing
        Object[] array = stack.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [Bus, Train]

        // Inherited List Interface Methods
        System.out.println("\nList Interface Methods (Inherited via Vector):");
        // get(int): Returns element at index
        // Time Complexity: O(1), synchronized
        // Use Case: Random access (avoid for stack semantics)
        System.out.println("Get index 0: " + stack.get(0)); // Bus

        // add(int, E): Adds element at index
        // Time Complexity: O(n), synchronized
        // Use Case: Insert elements (avoid for stack semantics)
        stack.add(0, "Van");
        System.out.println("After add(0, Van): " + stack); // [Van, Bus, Train]

        // Inherited Vector-Specific Methods
        System.out.println("\nVector-Specific Methods (Inherited):");
        // addElement(E): Adds element to the end (legacy)
        // Time Complexity: O(1) amortized, synchronized
        // Use Case: Legacy code compatibility
        stack.addElement("Truck");
        System.out.println("After addElement(Truck): " + stack); // [Van, Bus, Train, Truck]

        // elements(): Returns Enumeration of elements
        // Time Complexity: O(1), synchronized
        // Use Case: Legacy iteration
        Enumeration<String> enumeration = stack.elements();
        System.out.println("Enumerating Stack:");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        // capacity(): Returns current capacity
        // Time Complexity: O(1), synchronized
        // Use Case: Memory management
        System.out.println("Capacity: " + stack.capacity()); // 10 (default)

        // Modern Methods (Java 8+)
        System.out.println("\nModern Methods (Java 8+):");
        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n), synchronized
        // Use Case: Simplified iteration
        stack.forEach(item -> System.out.println("forEach: " + item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n), synchronized
        // Use Case: Conditional removal
        stack.removeIf(item -> item.startsWith("T"));
        System.out.println("After removeIf(startsWith T): " + stack); // [Van, Bus]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation, synchronized
        // Use Case: Functional processing
        Stream<String> stream = stack.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None")); // Van
    }

    public static void main(String[] args) {
        demonstrate();
    }
}