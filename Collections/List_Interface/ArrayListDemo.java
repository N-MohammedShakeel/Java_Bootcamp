package Java_Bootcamp.Collections.List_Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

class ArrayListDemo {
    // ArrayList: Uses a dynamic array as the underlying data structure.
    // Key Features:
    // - Fast random access (O(1) for get/set operations).
    // - Slow for insertions/deletions in the middle (O(n) due to array shifting).
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity can be specified; grows by 50% when full.
    // - Use Case: Ideal for frequent read operations and when random access is needed (e.g., storing a list of items for display).
    public static void demonstrate() {
        System.out.println("=== ArrayList Demonstration with All Datatypes ===");

        // 1. ArrayList with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte ArrayList
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127)
        // - Time Complexity: Same as ArrayList (O(1) get/set, O(n) insert/remove)
        // - Use Case: Store compact numerical data (e.g., pixel values)
        List<Byte> byteList = new ArrayList<>();
        byteList.add((byte) 10);
        byteList.add((byte) 20);
        System.out.println("Byte List: " + byteList); // [10, 20]

        // Short ArrayList
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767)
        // - Time Complexity: Same as ArrayList
        // - Use Case: Store medium-sized numerical data
        List<Short> shortList = new ArrayList<>();
        shortList.add((short) 100);
        shortList.add((short) 200);
        System.out.println("Short List: " + shortList); // [100, 200]

        // Integer ArrayList
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers
        // - Time Complexity: Same as ArrayList
        // - Use Case: DSA problems like Two Sum (LeetCode #1)
        List<Integer> intList = new ArrayList<>();
        intList.add(1000);
        intList.add(2000);
        System.out.println("Integer List: " + intList); // [1000, 2000]

        // Long ArrayList
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers
        // - Time Complexity: Same as ArrayList
        // - Use Case: Large numerical computations
        List<Long> longList = new ArrayList<>();
        longList.add(100000L);
        longList.add(200000L);
        System.out.println("Long List: " + longList); // [100000, 200000]

        // Float ArrayList
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision
        // - Time Complexity: Same as ArrayList
        // - Use Case: Scientific calculations
        List<Float> floatList = new ArrayList<>();
        floatList.add(10.5f);
        floatList.add(20.5f);
        System.out.println("Float List: " + floatList); // [10.5, 20.5]

        // Double ArrayList
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers
        // - Time Complexity: Same as ArrayList
        // - Use Case: Financial or scientific applications
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(100.5);
        doubleList.add(200.5);
        System.out.println("Double List: " + doubleList); // [100.5, 200.5]

        // Character ArrayList
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters
        // - Time Complexity: Same as ArrayList
        // - Use Case: String processing (e.g., LeetCode #3)
        List<Character> charList = new ArrayList<>();
        charList.add('A');
        charList.add('B');
        System.out.println("Character List: " + charList); // [A, B]

        // Boolean ArrayList
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as ArrayList
        // - Use Case: Flag-based algorithms
        List<Boolean> boolList = new ArrayList<>();
        boolList.add(true);
        boolList.add(false);
        System.out.println("Boolean List: " + boolList); // [true, false]

        // 2. ArrayList with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String ArrayList
        // Purpose: Store text strings
        // Key Features:
        // - Commonly used for text processing
        // - Time Complexity: Same as ArrayList
        // - Use Case: Store words for autocomplete (e.g., Trie-related problems)
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        System.out.println("String List: " + stringList); // [Apple, Banana]

        // Custom Object (Person) ArrayList
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires proper equals/hashCode for contains/remove
        // - Time Complexity: Same as ArrayList
        // - Use Case: Store structured data (e.g., employee records)
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 30));
        System.out.println("Person List: " + personList); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}]

        // Nested Collection ArrayList
        // Purpose: Store collections within a collection
        // Key Features:
        // - Supports complex structures like adjacency lists
        // - Time Complexity: Same as ArrayList
        // - Use Case: Graph algorithms (e.g., LeetCode #207)
        List<List<Integer>> nestedList = new ArrayList<>();
        nestedList.add(Arrays.asList(1, 2, 3));
        nestedList.add(Arrays.asList(4, 5, 6));
        System.out.println("Nested List: " + nestedList); // [[1, 2, 3], [4, 5, 6]]

        // 3. ArrayList Methods Demonstration (using String List)
        System.out.println("\n3. ArrayList Methods Demonstration:");
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Apple"));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in ArrayList
        // Key Features:
        // - Provide core collection operations
        // - Non-synchronized, requires Collections.synchronizedList for thread safety
        // - Use Case: General-purpose collection operations
        System.out.println("Initial List: " + list); // [Apple, Banana, Orange, Apple]

        // add(E): Adds element to the end
        // Time Complexity: O(1) amortized
        // Key Features: May trigger resize if capacity exceeded
        // Use Case: Append elements in DSA problems
        list.add("Mango");
        System.out.println("After add(Mango): " + list); // [Apple, Banana, Orange, Apple, Mango]

        // addAll(Collection): Adds all elements from another collection
        // Time Complexity: O(n)
        // Key Features: Appends at the end
        // Use Case: Merge lists in algorithms
        list.addAll(Arrays.asList("Grape", "Kiwi"));
        System.out.println("After addAll([Grape, Kiwi]): " + list); // [Apple, Banana, Orange, Apple, Mango, Grape, Kiwi]

        // contains(Object): Checks if element exists
        // Time Complexity: O(n)
        // Key Features: Uses equals method
        // Use Case: Membership testing (e.g., LeetCode #217)
        System.out.println("Contains Orange? " + list.contains("Orange")); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n)
        // Key Features: Uses equals for comparison
        // Use Case: Set operations
        System.out.println("Contains all [Apple, Banana]? " + list.containsAll(Arrays.asList("Apple", "Banana"))); // true

        // remove(Object): Removes first occurrence
        // Time Complexity: O(n)
        // Key Features: Shifts elements after removal
        // Use Case: Remove specific elements
        list.remove("Apple");
        System.out.println("After remove(Apple): " + list); // [Banana, Orange, Apple, Mango, Grape, Kiwi]

        // removeAll(Collection): Removes all elements in collection
        // Time Complexity: O(n)
        // Key Features: Removes all occurrences
        // Use Case: Set difference operations
        list.removeAll(Arrays.asList("Grape", "Kiwi"));
        System.out.println("After removeAll([Grape, Kiwi]): " + list); // [Banana, Orange, Apple, Mango]

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n)
        // Key Features: Removes non-matching elements
        // Use Case: Set intersection operations
        list.retainAll(Arrays.asList("Banana", "Mango"));
        System.out.println("After retainAll([Banana, Mango]): " + list); // [Banana, Mango]

        // isEmpty(): Checks if list is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("Is list empty? " + list.isEmpty()); // false

        // size(): Returns number of elements
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Loop bounds in algorithms
        System.out.println("Size: " + list.size()); // 2

        // toArray(): Returns array of elements
        // Time Complexity: O(n)
        // Key Features: Copies elements to array
        // Use Case: Convert to array for processing
        Object[] array = list.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [Banana, Mango]

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n)
        // Key Features: Type-safe array conversion
        // Use Case: Interfacing with APIs requiring arrays
        String[] stringArray = list.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray)); // [Banana, Mango]

        // iterator(): Returns iterator for traversal
        // Time Complexity: O(1)
        // Key Features: Supports safe removal during iteration
        // Use Case: Custom iteration logic
        Iterator<String> iterator = list.iterator();
        System.out.println("Iterator hasNext: " + iterator.hasNext()); // true

        // List Interface Methods (Specific)
        System.out.println("\nList Interface Methods (Specific):");
        // Purpose: Methods specific to List interface
        // Key Features:
        // - Support index-based operations
        // - Optimized for ArrayList’s array structure
        // - Use Case: Ordered collection operations
        list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Apple"));

        // add(int, E): Adds element at index
        // Time Complexity: O(n) due to shifting
        // Key Features: Shifts elements to the right
        // Use Case: Insert elements in sorted lists
        list.add(1, "Mango");
        System.out.println("After add(1, Mango): " + list); // [Apple, Mango, Banana, Orange, Apple]

        // get(int): Returns element at index
        // Time Complexity: O(1)
        // Key Features: Fast due to array access
        // Use Case: Random access in DSA (e.g., Two Sum)
        System.out.println("Get index 2: " + list.get(2)); // Banana

        // set(int, E): Replaces element at index
        // Time Complexity: O(1)
        // Key Features: Fast replacement
        // Use Case: Update elements in place
        list.set(2, "Grape");
        System.out.println("After set(2, Grape): " + list); // [Apple, Mango, Grape, Orange, Apple]

        // remove(int): Removes element at index
        // Time Complexity: O(n) due to shifting
        // Key Features: Shifts elements left
        // Use Case: Remove specific positions
        list.remove(3);
        System.out.println("After remove(3): " + list); // [Apple, Mango, Grape, Apple]

        // indexOf(Object): Returns first index of element
        // Time Complexity: O(n)
        // Key Features: Uses equals for comparison
        // Use Case: Find element positions
        System.out.println("Index of Apple: " + list.indexOf("Apple")); // 0

        // lastIndexOf(Object): Returns last index of element
        // Time Complexity: O(n)
        // Key Features: Useful for duplicates
        // Use Case: Find last occurrence in lists
        System.out.println("Last index of Apple: " + list.lastIndexOf("Apple")); // 3

        // listIterator(int): Returns bidirectional iterator
        // Time Complexity: O(1)
        // Key Features: Supports forward/backward traversal
        // Use Case: Complex list traversals
        ListIterator<String> listIterator = list.listIterator(1);
        System.out.println("ListIterator next: " + listIterator.next()); // Mango

        // subList(int, int): Returns view of list portion
        // Time Complexity: O(1)
        // Key Features: Modifications affect original list
        // Use Case: Process list subsets (e.g., sliding window)
        List<String> subList = list.subList(1, 3);
        System.out.println("Sublist [1, 3): " + subList); // [Mango, Grape]

        // ArrayList-Specific Methods
        System.out.println("\nArrayList-Specific Methods:");
        // Purpose: Methods unique to ArrayList implementation
        // Key Features:
        // - Optimize memory and performance
        // - Support modern Java features (Java 8+)
        // - Use Case: Fine-tune ArrayList behavior
        list = new ArrayList<>(10); // Pre-size with capacity
        list.addAll(Arrays.asList("Apple", "Banana", "Orange"));

        // ensureCapacity(int): Ensures minimum capacity
        // Time Complexity: O(1) or O(n) if resizing
        // Key Features: Reduces resizing overhead
        // Use Case: Optimize for large lists
        ((ArrayList<String>) list).ensureCapacity(20);
        System.out.println("After ensureCapacity(20) and addAll: " + list);

        // trimToSize(): Trims capacity to size
        // Time Complexity: O(n)
        // Key Features: Minimizes memory usage
        // Use Case: Optimize memory for fixed lists
        ((ArrayList<String>) list).trimToSize();
        System.out.println("After trimToSize: " + list);

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies elements, not deep copy
        // Use Case: Create independent list copies
        List<String> clone = (List<String>) ((ArrayList<String>) list).clone();
        System.out.println("Clone: " + clone);

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style
        // Use Case: Simplified iteration
        list.forEach(item -> System.out.println("forEach: " + item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n)
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal (e.g., filter lists)
        list.removeIf(item -> item.startsWith("B"));
        System.out.println("After removeIf(startsWith B): " + list); // [Apple, Orange]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation
        // Key Features: Java 8+, supports functional operations
        // Use Case: Process lists with streams (e.g., filtering, mapping)
        Stream<String> stream = list.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None"));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}