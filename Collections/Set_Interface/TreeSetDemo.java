package Java_Bootcamp.Collections.Set_Interface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.stream.Stream;

class TreeSetDemo {
    // TreeSet: Uses a red-black tree (balanced binary search tree) as the underlying data structure.
    // Key Features:
    // - Sorted: Elements are stored in natural order or by a custom Comparator.
    // - O(log n) for add, remove, contains due to tree operations.
    // - Does not allow null elements (throws NullPointerException).
    // - Non-synchronized, not thread-safe by default.
    // - Elements must implement Comparable or be provided with a Comparator.
    // - Use Case: Ideal for maintaining a sorted set of elements (e.g., a leaderboard of scores).
    public static void demonstrate() {
        System.out.println("=== TreeSet Demonstration with All Datatypes ===");

        // 1. TreeSet with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte TreeSet
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127), sorted
        // - Time Complexity: O(log n) for add/remove/contains
        // - Use Case: Store unique sorted small numerical values
        Set<Byte> byteSet = new TreeSet<>();
        byteSet.add((byte) 10);
        byteSet.add((byte) 20);
        byteSet.add((byte) 10); // Duplicate, ignored
        System.out.println("Byte Set: " + byteSet); // [10, 20]

        // Short TreeSet
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767), sorted
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store unique sorted medium-sized numerical data
        Set<Short> shortSet = new TreeSet<>();
        shortSet.add((short) 100);
        shortSet.add((short) 200);
        System.out.println("Short Set: " + shortSet); // [100, 200]

        // Integer TreeSet
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers, sorted
        // - Time Complexity: Same as TreeSet
        // - Use Case: DSA problems like Kth Largest Element (LeetCode #215)
        Set<Integer> intSet = new TreeSet<>();
        intSet.add(1000);
        intSet.add(2000);
        intSet.add(1000); // Duplicate, ignored
        System.out.println("Integer Set: " + intSet); // [1000, 2000]

        // Long TreeSet
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers, sorted
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store unique sorted large numerical values
        Set<Long> longSet = new TreeSet<>();
        longSet.add(100000L);
        longSet.add(200000L);
        System.out.println("Long Set: " + longSet); // [100000, 200000]

        // Float TreeSet
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision, sorted
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store unique sorted floating-point values
        Set<Float> floatSet = new TreeSet<>();
        floatSet.add(10.5f);
        floatSet.add(20.5f);
        System.out.println("Float Set: " + floatSet); // [10.5, 20.5]

        // Double TreeSet
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers, sorted
        // - Time Complexity: Same as TreeSet
        // - Use Case: Financial or scientific applications
        Set<Double> doubleSet = new TreeSet<>();
        doubleSet.add(100.5);
        doubleSet.add(200.5);
        System.out.println("Double Set: " + doubleSet); // [100.5, 200.5]

        // Character TreeSet
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters, sorted
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store unique sorted characters
        Set<Character> charSet = new TreeSet<>();
        charSet.add('A');
        charSet.add('B');
        charSet.add('A'); // Duplicate, ignored
        System.out.println("Character Set: " + charSet); // [A, B]

        // Boolean TreeSet
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint, sorted (false < true)
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store unique sorted boolean flags
        Set<Boolean> boolSet = new TreeSet<>();
        boolSet.add(true);
        boolSet.add(false);
        System.out.println("Boolean Set: " + boolSet); // [false, true]

        // 2. TreeSet with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String TreeSet
        // Purpose: Store text strings
        // Key Features:
        // - Sorted lexicographically, unique
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store sorted unique words (e.g., dictionary)
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Apple"); // Duplicate, ignored
        System.out.println("String Set: " + stringSet); // [Apple, Banana]

        // Custom Object (Person) TreeSet
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires Comparable or Comparator for sorting
        // - Time Complexity: Same as TreeSet
        // - Use Case: Store sorted unique structured data (e.g., leaderboard)
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person("Alice", 25));
        personSet.add(new Person("Bob", 30));
        personSet.add(new Person("Alice", 40)); // Duplicate name, ignored
        System.out.println("Person Set: " + personSet); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}]

        // TreeSet with Custom Comparator
        // Purpose: Store elements with custom ordering
        // Key Features:
        // - Uses Comparator instead of Comparable
        // - Time Complexity: Same as TreeSet
        // - Use Case: Custom sorting (e.g., sort Person by age)
        Set<Person> personSetByAge = new TreeSet<>(Comparator.comparingInt(p -> p.getAge()));
        personSetByAge.add(new Person("Alice", 25));
        personSetByAge.add(new Person("Bob", 30));
        personSetByAge.add(new Person("Charlie", 25)); // Duplicate age, not ignored (uses Comparator)
        System.out.println("Person Set (by age): " + personSetByAge); // [Person{name='Alice', age=25}, Person{name='Charlie', age=25}, Person{name='Bob', age=30}]

        // 3. TreeSet Methods Demonstration
        System.out.println("\n3. TreeSet Methods Demonstration:");
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(30, 10, 20, 10));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in TreeSet
        // Key Features:
        // - Provide core set operations with sorted order
        // - Non-synchronized, requires Collections.synchronizedSet for thread safety
        // - Use Case: General-purpose sorted set operations
        System.out.println("Initial TreeSet: " + treeSet); // [10, 20, 30]

        // add(E): Adds element if not present
        // Time Complexity: O(log n)
        // Key Features: Maintains sorted order, ignores duplicates
        // Use Case: Ensure sorted uniqueness in DSA problems
        treeSet.add(40);
        treeSet.add(10); // Duplicate, ignored
        System.out.println("After add(40): " + treeSet); // [10, 20, 30, 40]

        // addAll(Collection): Adds all elements, ignoring duplicates
        // Time Complexity: O(n log n)
        // Key Features: Merges collections, maintains sorted order
        // Use Case: Set union operations (e.g., LeetCode #349)
        treeSet.addAll(Arrays.asList(50, 20));
        System.out.println("After addAll([50, 20]): " + treeSet); // [10, 20, 30, 40, 50]

        // contains(Object): Checks if element exists
        // Time Complexity: O(log n)
        // Key Features: Uses compareTo/Comparator
        // Use Case: Membership testing (e.g., LeetCode #220)
        System.out.println("Contains 20? " + treeSet.contains(20)); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n log n)
        // Key Features: Uses compareTo/Comparator for comparison
        // Use Case: Set inclusion checks
        System.out.println("Contains all [10, 20]? " + treeSet.containsAll(Arrays.asList(10, 20))); // true

        // remove(Object): Removes element if present
        // Time Complexity: O(log n)
        // Key Features: Maintains sorted order
        // Use Case: Remove specific elements
        treeSet.remove(30);
        System.out.println("After remove(30): " + treeSet); // [10, 20, 40, 50]

        // removeAll(Collection): Removes all elements in collection
        // Time Complexity: O(n log n)
        // Key Features: Removes matching elements, preserves order
        // Use Case: Set difference operations
        treeSet.removeAll(Arrays.asList(40, 50));
        System.out.println("After removeAll([40, 50]): " + treeSet); // [10, 20]

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n log n)
        // Key Features: Removes non-matching elements, preserves order
        // Use Case: Set intersection operations (e.g., LeetCode #349)
        treeSet.retainAll(Arrays.asList(10, 15));
        System.out.println("After retainAll([10, 15]): " + treeSet); // [10]

        // isEmpty(): Checks if set is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("Is set empty? " + treeSet.isEmpty()); // false

        // size(): Returns number of elements
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine set cardinality
        System.out.println("Size: " + treeSet.size()); // 1

        // toArray(): Returns array of elements
        // Time Complexity: O(n)
        // Key Features: Copies elements in sorted order
        // Use Case: Convert to array for processing
        Object[] array = treeSet.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [10]

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n)
        // Key Features: Type-safe array conversion in sorted order
        // Use Case: Interfacing with APIs requiring arrays
        Integer[] intArray = treeSet.toArray(new Integer[0]);
        System.out.println("toArray(Integer[]): " + Arrays.toString(intArray)); // [10]

        // iterator(): Returns iterator for traversal
        // Time Complexity: O(1)
        // Key Features: Iterates in ascending order, supports safe removal
        // Use Case: Custom iteration logic
        Iterator<Integer> iterator = treeSet.iterator();
        System.out.println("Iterator hasNext: " + iterator.hasNext()); // true

        // SortedSet Interface Methods
        System.out.println("\nSortedSet Interface Methods:");
        // Purpose: Methods from SortedSet interface
        // Key Features:
        // - Provide sorted set operations
        // - Use Case: Range queries and boundary access
        treeSet = new TreeSet<>(Arrays.asList(30, 10, 20));

        // comparator(): Returns the comparator used
        // Time Complexity: O(1)
        // Key Features: Returns null for natural ordering
        // Use Case: Check sorting mechanism
        System.out.println("Comparator: " + ((TreeSet<Integer>) treeSet).comparator()); // null

        // first(): Returns the first element
        // Time Complexity: O(log n)
        // Key Features: Accesses lowest element
        // Use Case: Get minimum value (e.g., LeetCode #215)
        System.out.println("First element: " + ((TreeSet<Integer>) treeSet).first()); // 10

        // last(): Returns the last element
        // Time Complexity: O(log n)
        // Key Features: Accesses highest element
        // Use Case: Get maximum value
        System.out.println("Last element: " + ((TreeSet<Integer>) treeSet).last()); // 30

        // subSet(E, E): Returns view of elements in range
        // Time Complexity: O(log n)
        // Key Features: Inclusive start, exclusive end
        // Use Case: Range queries (e.g., LeetCode #220)
        SortedSet<Integer> subSet = ((TreeSet<Integer>) treeSet).subSet(10, 30);
        System.out.println("subSet(10, 30): " + subSet); // [10, 20]

        // headSet(E): Returns view of elements less than toElement
        // Time Complexity: O(log n)
        // Key Features: Exclusive end
        // Use Case: Prefix queries
        SortedSet<Integer> headSet = ((TreeSet<Integer>) treeSet).headSet(20);
        System.out.println("headSet(20): " + headSet); // [10]

        // tailSet(E): Returns view of elements greater than or equal to fromElement
        // Time Complexity: O(log n)
        // Key Features: Inclusive start
        // Use Case: Suffix queries
        SortedSet<Integer> tailSet = ((TreeSet<Integer>) treeSet).tailSet(20);
        System.out.println("tailSet(20): " + tailSet); // [20, 30]

        // NavigableSet Interface Methods
        System.out.println("\nNavigableSet Interface Methods:");
        // Purpose: Methods from NavigableSet interface
        // Key Features:
        // - Provide navigational operations for sorted sets
        // - Use Case: Nearest-element queries
        treeSet = new TreeSet<>(Arrays.asList(10, 20, 30));

        // lower(E): Returns greatest element less than e
        // Time Complexity: O(log n)
        // Key Features: Strict comparison
        // Use Case: Find predecessor
        System.out.println("lower(25): " + ((TreeSet<Integer>) treeSet).lower(25)); // 20

        // floor(E): Returns greatest element less than or equal to e
        // Time Complexity: O(log n)
        // Key Features: Inclusive comparison
        // Use Case: Find closest lower value
        System.out.println("floor(20): " + ((TreeSet<Integer>) treeSet).floor(20)); // 20

        // ceiling(E): Returns least element greater than or equal to e
        // Time Complexity: O(log n)
        // Key Features: Inclusive comparison
        // Use Case: Find closest higher value
        System.out.println("ceiling(25): " + ((TreeSet<Integer>) treeSet).ceiling(25)); // 30

        // higher(E): Returns least element greater than e
        // Time Complexity: O(log n)
        // Key Features: Strict comparison
        // Use Case: Find successor
        System.out.println("higher(20): " + ((TreeSet<Integer>) treeSet).higher(20)); // 30

        // pollFirst(): Removes and returns first element
        // Time Complexity: O(log n)
        // Key Features: Modifies set
        // Use Case: Priority queue operations
        System.out.println("pollFirst: " + ((TreeSet<Integer>) treeSet).pollFirst()); // 10
        System.out.println("After pollFirst: " + treeSet); // [20, 30]

        // pollLast(): Removes and returns last element
        // Time Complexity: O(log n)
        // Key Features: Modifies set
        // Use Case: Priority queue operations
        System.out.println("pollLast: " + ((TreeSet<Integer>) treeSet).pollLast()); // 30
        System.out.println("After pollLast: " + treeSet); // [20]

        // descendingSet(): Returns reverse-order view
        // Time Complexity: O(1)
        // Key Features: Non-destructive view
        // Use Case: Reverse-order iteration
        NavigableSet<Integer> descSet = ((TreeSet<Integer>) treeSet).descendingSet();
        System.out.println("descendingSet: " + descSet); // [20]

        // descendingIterator(): Returns iterator in descending order
        // Time Complexity: O(1)
        // Key Features: Reverse-order traversal
        // Use Case: Custom reverse iteration
        Iterator<Integer> descIterator = ((TreeSet<Integer>) treeSet).descendingIterator();
        System.out.println("descendingIterator hasNext: " + descIterator.hasNext()); // true

        // TreeSet-Specific Methods
        System.out.println("\nTreeSet-Specific Methods:");
        // Purpose: Methods inherited from HashSet, specialized for TreeSet
        // Key Features:
        // - Support modern Java features and cloning with sorted order
        // - Use Case: Functional programming and sorted set duplication
        treeSet = new TreeSet<>(Arrays.asList(10, 20, 30));

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies elements, preserves sorted order
        // Use Case: Create independent set copies
        Set<Integer> clone = (Set<Integer>) ((TreeSet<Integer>) treeSet).clone();
        System.out.println("Clone: " + clone); // [10, 20, 30]

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style, sorted order
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        treeSet.forEach(item -> System.out.println(item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n)
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal (e.g., filter sets)
        treeSet.removeIf(item -> item > 20);
        System.out.println("After removeIf(>20): " + treeSet); // [10, 20]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation
        // Key Features: Java 8+, supports functional operations in sorted order
        // Use Case: Process sets with streams
        Stream<Integer> stream = treeSet.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse(-1));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}