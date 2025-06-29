package Java_Bootcamp.Collections.Set_Interface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

class HashSetDemo {
    // HashSet: Uses a hash table (based on HashMap) as the underlying data structure.
    // Key Features:
    // - Unordered: Elements are not stored in any specific order.
    // - Uses hashing: Fast average-case performance (O(1) for add, remove, contains).
    // - Allows one null element.
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity and load factor can be specified (default: 16, 0.75).
    // - Use Case: Ideal for scenarios requiring fast lookups and no duplicates (e.g., storing unique user IDs).
    public static void demonstrate() {
        System.out.println("=== HashSet Demonstration with All Datatypes ===");

        // 1. HashSet with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte HashSet
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127)
        // - Time Complexity: O(1) average for add/remove/contains
        // - Use Case: Store unique small numerical values
        Set<Byte> byteSet = new HashSet<>();
        byteSet.add((byte) 10);
        byteSet.add((byte) 20);
        byteSet.add((byte) 10); // Duplicate, ignored
        System.out.println("Byte Set: " + byteSet); // [10, 20] (order may vary)

        // Short HashSet
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767)
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique medium-sized numerical data
        Set<Short> shortSet = new HashSet<>();
        shortSet.add((short) 100);
        shortSet.add((short) 200);
        System.out.println("Short Set: " + shortSet); // [100, 200] (order may vary)

        // Integer HashSet
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers
        // - Time Complexity: Same as HashSet
        // - Use Case: DSA problems like Contains Duplicate (LeetCode #217)
        Set<Integer> intSet = new HashSet<>();
        intSet.add(1000);
        intSet.add(2000);
        intSet.add(1000); // Duplicate, ignored
        System.out.println("Integer Set: " + intSet); // [1000, 2000] (order may vary)

        // Long HashSet
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique large numerical values
        Set<Long> longSet = new HashSet<>();
        longSet.add(100000L);
        longSet.add(200000L);
        System.out.println("Long Set: " + longSet); // [100000, 200000] (order may vary)

        // Float HashSet
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique floating-point values
        Set<Float> floatSet = new HashSet<>();
        floatSet.add(10.5f);
        floatSet.add(20.5f);
        System.out.println("Float Set: " + floatSet); // [10.5, 20.5] (order may vary)

        // Double HashSet
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers
        // - Time Complexity: Same as HashSet
        // - Use Case: Financial or scientific applications
        Set<Double> doubleSet = new HashSet<>();
        doubleSet.add(100.5);
        doubleSet.add(200.5);
        System.out.println("Double Set: " + doubleSet); // [100.5, 200.5] (order may vary)

        // Character HashSet
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique characters (e.g., LeetCode #3)
        Set<Character> charSet = new HashSet<>();
        charSet.add('A');
        charSet.add('B');
        charSet.add('A'); // Duplicate, ignored
        System.out.println("Character Set: " + charSet); // [A, B] (order may vary)

        // Boolean HashSet
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique boolean flags
        Set<Boolean> boolSet = new HashSet<>();
        boolSet.add(true);
        boolSet.add(false);
        System.out.println("Boolean Set: " + boolSet); // [false, true] (order may vary)

        // 2. HashSet with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String HashSet
        // Purpose: Store text strings
        // Key Features:
        // - Commonly used for text deduplication
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique words (e.g., autocomplete systems)
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Apple"); // Duplicate, ignored
        System.out.println("String Set: " + stringSet); // [Apple, Banana] (order may vary)

        // Custom Object (Person) HashSet
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires proper equals/hashCode for uniqueness
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique structured data (e.g., user records)
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Alice", 25));
        personSet.add(new Person("Bob", 30));
        personSet.add(new Person("Alice", 40)); // Duplicate name, ignored
        System.out.println("Person Set: " + personSet); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}] (order may vary)

        // Nested Collection HashSet
        // Purpose: Store collections within a collection
        // Key Features:
        // - Supports complex structures
        // - Time Complexity: Same as HashSet
        // - Use Case: Store unique sets (e.g., graph node sets)
        Set<Set<Integer>> nestedSet = new HashSet<>();
        nestedSet.add(new HashSet<>(Arrays.asList(1, 2, 3)));
        nestedSet.add(new HashSet<>(Arrays.asList(4, 5, 6)));
        System.out.println("Nested Set: " + nestedSet); // [[1, 2, 3], [4, 5, 6]] (order may vary)

        // 3. HashSet Methods Demonstration
        System.out.println("\n3. HashSet Methods Demonstration:");
        Set<String> hashSet = new HashSet<>(Arrays.asList("Apple", "Banana", "Orange", "Apple"));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in HashSet
        // Key Features:
        // - Provide core set operations with hashing
        // - Non-synchronized, requires Collections.synchronizedSet for thread safety
        // - Use Case: General-purpose set operations
        System.out.println("Initial HashSet: " + hashSet); // [Apple, Banana, Orange] (order may vary)

        // add(E): Adds element if not present
        // Time Complexity: O(1) average
        // Key Features: Ignores duplicates, uses hashCode/equals
        // Use Case: Ensure uniqueness in DSA problems
        hashSet.add("Mango");
        hashSet.add("Apple"); // Duplicate, ignored
        System.out.println("After add(Mango): " + hashSet); // [Apple, Mango, Banana, Orange] (order may vary)

        // addAll(Collection): Adds all elements, ignoring duplicates
        // Time Complexity: O(n) average
        // Key Features: Merges collections
        // Use Case: Set union operations (e.g., LeetCode #349)
        hashSet.addAll(Arrays.asList("Grape", "Banana"));
        System.out.println("After addAll([Grape, Banana]): " + hashSet); // [Apple, Mango, Grape, Banana, Orange] (order may vary)

        // contains(Object): Checks if element exists
        // Time Complexity: O(1) average
        // Key Features: Uses hashCode/equals
        // Use Case: Membership testing (e.g., LeetCode #217)
        System.out.println("Contains Banana? " + hashSet.contains("Banana")); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n) average
        // Key Features: Uses hashCode/equals for comparison
        // Use Case: Set inclusion checks
        System.out.println("Contains all [Apple, Banana]? " + hashSet.containsAll(Arrays.asList("Apple", "Banana"))); // true

        // remove(Object): Removes element if present
        // Time Complexity: O(1) average
        // Key Features: Uses hashCode/equals
        // Use Case: Remove specific elements
        hashSet.remove("Orange");
        System.out.println("After remove(Orange): " + hashSet); // [Apple, Mango, Grape, Banana] (order may vary)

        // removeAll(Collection): Removes all elements in collection
        // Time Complexity: O(n) average
        // Key Features: Removes matching elements
        // Use Case: Set difference operations
        hashSet.removeAll(Arrays.asList("Grape", "Mango"));
        System.out.println("After removeAll([Grape, Mango]): " + hashSet); // [Apple, Banana] (order may vary)

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n) average
        // Key Features: Removes non-matching elements
        // Use Case: Set intersection operations (e.g., LeetCode #349)
        hashSet.retainAll(Arrays.asList("Apple", "Kiwi"));
        System.out.println("After retainAll([Apple, Kiwi]): " + hashSet); // [Apple] (order may vary)

        // isEmpty(): Checks if set is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("Is set empty? " + hashSet.isEmpty()); // false

        // size(): Returns number of elements
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine set cardinality
        System.out.println("Size: " + hashSet.size()); // 1

        // toArray(): Returns array of elements
        // Time Complexity: O(n)
        // Key Features: Copies elements to array
        // Use Case: Convert to array for processing
        Object[] array = hashSet.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [Apple] (order may vary)

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n)
        // Key Features: Type-safe array conversion
        // Use Case: Interfacing with APIs requiring arrays
        String[] stringArray = hashSet.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray)); // [Apple] (order may vary)

        // iterator(): Returns iterator for traversal
        // Time Complexity: O(1)
        // Key Features: Supports safe removal during iteration
        // Use Case: Custom iteration logic
        Iterator<String> iterator = hashSet.iterator();
        System.out.println("Iterator hasNext: " + iterator.hasNext()); // true

        // HashSet-Specific Methods
        System.out.println("\nHashSet-Specific Methods:");
        // Purpose: Methods unique to HashSet implementation
        // Key Features:
        // - Support modern Java features and cloning
        // - Use Case: Functional programming and set duplication
        hashSet = new HashSet<>(Arrays.asList("Apple", "Banana", "Orange"));

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies elements, not deep copy
        // Use Case: Create independent set copies
        Set<String> clone = (Set<String>) ((HashSet<String>) hashSet).clone();
        System.out.println("Clone: " + clone); // [Apple, Banana, Orange] (order may vary)

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n) average
        // Key Features: Java 8+, functional style
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        hashSet.forEach(item -> System.out.println(item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n) average
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal (e.g., filter sets)
        hashSet.removeIf(item -> item.startsWith("B"));
        System.out.println("After removeIf(startsWith B): " + hashSet); // [Apple, Orange] (order may vary)

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation
        // Key Features: Java 8+, supports functional operations
        // Use Case: Process sets with streams
        Stream<String> stream = hashSet.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None"));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}