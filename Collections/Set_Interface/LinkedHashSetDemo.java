package Java_Bootcamp.Collections.Set_Interface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

class LinkedHashSetDemo {
    // LinkedHashSet: Extends HashSet, uses a hash table with a doubly-linked list to maintain insertion order.
    // Key Features:
    // - Maintains insertion order: Elements are returned in the order they were added.
    // - Uses hashing: Same performance as HashSet (O(1) for add, remove, contains).
    // - Allows one null element.
    // - Non-synchronized, not thread-safe by default.
    // - Slightly higher memory overhead than HashSet due to linked list.
    // - Use Case: Ideal when order of insertion matters (e.g., maintaining a log of unique events).
    public static void demonstrate() {
        System.out.println("=== LinkedHashSet Demonstration with All Datatypes ===");

        // 1. LinkedHashSet with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte LinkedHashSet
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127)
        // - Time Complexity: O(1) average for add/remove/contains
        // - Use Case: Store unique small numerical values with insertion order
        Set<Byte> byteSet = new LinkedHashSet<>();
        byteSet.add((byte) 10);
        byteSet.add((byte) 20);
        byteSet.add((byte) 10); // Duplicate, ignored
        System.out.println("Byte Set: " + byteSet); // [10, 20]

        // Short LinkedHashSet
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767)
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique medium-sized numerical data
        Set<Short> shortSet = new LinkedHashSet<>();
        shortSet.add((short) 100);
        shortSet.add((short) 200);
        System.out.println("Short Set: " + shortSet); // [100, 200]

        // Integer LinkedHashSet
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: DSA problems like Intersection of Two Arrays (LeetCode #349)
        Set<Integer> intSet = new LinkedHashSet<>();
        intSet.add(1000);
        intSet.add(2000);
        intSet.add(1000); // Duplicate, ignored
        System.out.println("Integer Set: " + intSet); // [1000, 2000]

        // Long LinkedHashSet
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique large numerical values
        Set<Long> longSet = new LinkedHashSet<>();
        longSet.add(100000L);
        longSet.add(200000L);
        System.out.println("Long Set: " + longSet); // [100000, 200000]

        // Float LinkedHashSet
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique floating-point values
        Set<Float> floatSet = new LinkedHashSet<>();
        floatSet.add(10.5f);
        floatSet.add(20.5f);
        System.out.println("Float Set: " + floatSet); // [10.5, 20.5]

        // Double LinkedHashSet
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Financial or scientific applications
        Set<Double> doubleSet = new LinkedHashSet<>();
        doubleSet.add(100.5);
        doubleSet.add(200.5);
        System.out.println("Double Set: " + doubleSet); // [100.5, 200.5]

        // Character LinkedHashSet
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique characters (e.g., LeetCode #3)
        Set<Character> charSet = new LinkedHashSet<>();
        charSet.add('A');
        charSet.add('B');
        charSet.add('A'); // Duplicate, ignored
        System.out.println("Character Set: " + charSet); // [A, B]

        // Boolean LinkedHashSet
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique boolean flags
        Set<Boolean> boolSet = new LinkedHashSet<>();
        boolSet.add(true);
        boolSet.add(false);
        System.out.println("Boolean Set: " + boolSet); // [true, false]

        // 2. LinkedHashSet with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String LinkedHashSet
        // Purpose: Store text strings
        // Key Features:
        // - Commonly used for text deduplication with order
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique words in order (e.g., event logs)
        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Apple"); // Duplicate, ignored
        System.out.println("String Set: " + stringSet); // [Apple, Banana]

        // Custom Object (Person) LinkedHashSet
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires proper equals/hashCode for uniqueness
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique structured data (e.g., user records)
        Set<Person> personSet = new LinkedHashSet<>();
        personSet.add(new Person("Alice", 25));
        personSet.add(new Person("Bob", 30));
        personSet.add(new Person("Alice", 40)); // Duplicate name, ignored
        System.out.println("Person Set: " + personSet); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}]

        // Nested Collection LinkedHashSet
        // Purpose: Store collections within a collection
        // Key Features:
        // - Supports complex structures with order
        // - Time Complexity: Same as LinkedHashSet
        // - Use Case: Store unique sets (e.g., graph node sets)
        Set<Set<Integer>> nestedSet = new LinkedHashSet<>();
        nestedSet.add(new HashSet<>(Arrays.asList(1, 2, 3)));
        nestedSet.add(new HashSet<>(Arrays.asList(4, 5, 6)));
        System.out.println("Nested Set: " + nestedSet); // [[1, 2, 3], [4, 5, 6]]

        // 3. LinkedHashSet Methods Demonstration
        System.out.println("\n3. LinkedHashSet Methods Demonstration:");
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("Dog", "Cat", "Bird", "Dog"));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in LinkedHashSet
        // Key Features:
        // - Provide core set operations with hashing and insertion order
        // - Non-synchronized, requires Collections.synchronizedSet for thread safety
        // - Use Case: General-purpose set operations with order
        System.out.println("Initial LinkedHashSet: " + linkedHashSet); // [Dog, Cat, Bird]

        // add(E): Adds element if not present
        // Time Complexity: O(1) average
        // Key Features: Ignores duplicates, maintains insertion order
        // Use Case: Ensure uniqueness with order in DSA problems
        linkedHashSet.add("Fish");
        linkedHashSet.add("Dog"); // Duplicate, ignored
        System.out.println("After add(Fish): " + linkedHashSet); // [Dog, Cat, Bird, Fish]

        // addAll(Collection): Adds all elements, ignoring duplicates
        // Time Complexity: O(n) average
        // Key Features: Merges collections, preserves order
        // Use Case: Set union operations (e.g., LeetCode #349)
        linkedHashSet.addAll(Arrays.asList("Mouse", "Cat"));
        System.out.println("After addAll([Mouse, Cat]): " + linkedHashSet); // [Dog, Cat, Bird, Fish, Mouse]

        // contains(Object): Checks if element exists
        // Time Complexity: O(1) average
        // Key Features: Uses hashCode/equals
        // Use Case: Membership testing (e.g., LeetCode #217)
        System.out.println("Contains Cat? " + linkedHashSet.contains("Cat")); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n) average
        // Key Features: Uses hashCode/equals for comparison
        // Use Case: Set inclusion checks
        System.out.println("Contains all [Dog, Cat]? " + linkedHashSet.containsAll(Arrays.asList("Dog", "Cat"))); // true

        // remove(Object): Removes element if present
        // Time Complexity: O(1) average
        // Key Features: Uses hashCode/equals, maintains order
        // Use Case: Remove specific elements
        linkedHashSet.remove("Bird");
        System.out.println("After remove(Bird): " + linkedHashSet); // [Dog, Cat, Fish, Mouse]

        // removeAll(Collection): Removes all elements in collection
        // Time Complexity: O(n) average
        // Key Features: Removes matching elements, preserves order
        // Use Case: Set difference operations
        linkedHashSet.removeAll(Arrays.asList("Fish", "Mouse"));
        System.out.println("After removeAll([Fish, Mouse]): " + linkedHashSet); // [Dog, Cat]

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n) average
        // Key Features: Removes non-matching elements, preserves order
        // Use Case: Set intersection operations (e.g., LeetCode #349)
        linkedHashSet.retainAll(Arrays.asList("Dog", "Wolf"));
        System.out.println("After retainAll([Dog, Wolf]): " + linkedHashSet); // [Dog]

        // isEmpty(): Checks if set is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("Is set empty? " + linkedHashSet.isEmpty()); // false

        // size(): Returns number of elements
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine set cardinality
        System.out.println("Size: " + linkedHashSet.size()); // 1

        // toArray(): Returns array of elements
        // Time Complexity: O(n)
        // Key Features: Copies elements in insertion order
        // Use Case: Convert to array for processing
        Object[] array = linkedHashSet.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [Dog]

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n)
        // Key Features: Type-safe array conversion in insertion order
        // Use Case: Interfacing with APIs requiring arrays
        String[] stringArray = linkedHashSet.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray)); // [Dog]

        // iterator(): Returns iterator for traversal
        // Time Complexity: O(1)
        // Key Features: Iterates in insertion order, supports safe removal
        // Use Case: Custom iteration logic
        Iterator<String> iterator = linkedHashSet.iterator();
        System.out.println("Iterator hasNext: " + iterator.hasNext()); // true

        // LinkedHashSet-Specific Methods
        System.out.println("\nLinkedHashSet-Specific Methods:");
        // Purpose: Methods inherited from HashSet, specialized for LinkedHashSet
        // Key Features:
        // - Support modern Java features and cloning with insertion order
        // - Use Case: Functional programming and ordered set duplication
        linkedHashSet = new LinkedHashSet<>(Arrays.asList("Dog", "Cat", "Bird"));

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies elements, preserves insertion order
        // Use Case: Create independent set copies
        Set<String> clone = (Set<String>) ((LinkedHashSet<String>) linkedHashSet).clone();
        System.out.println("Clone: " + clone); // [Dog, Cat, Bird]

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n) average
        // Key Features: Java 8+, functional style, insertion order
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        linkedHashSet.forEach(item -> System.out.println(item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n) average
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal (e.g., filter sets)
        linkedHashSet.removeIf(item -> item.startsWith("C"));
        System.out.println("After removeIf(startsWith C): " + linkedHashSet); // [Dog, Bird]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation
        // Key Features: Java 8+, supports functional operations in insertion order
        // Use Case: Process sets with streams
        Stream<String> stream = linkedHashSet.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None"));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}