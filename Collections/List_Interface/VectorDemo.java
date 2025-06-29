package Java_Bootcamp.Collections.List_Interface;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.stream.Stream;

class VectorDemo {
    // Vector: Uses a dynamic array, similar to ArrayList, but synchronized.
    // Key Features:
    // - Synchronized, thread-safe by default (methods are synchronized).
    // - Legacy class (introduced in JDK 1.0), less efficient than ArrayList due to synchronization overhead.
    // - Grows by 100% when full (doubles capacity).
    // - Supports Enumeration (legacy iterator) in addition to Iterator.
    // - Use Case: Suitable for legacy code or when thread-safety is needed without using Collections.synchronizedList (e.g., multi-threaded environments).
    public static void demonstrate() {
        System.out.println("\n=== Vector Demonstration with All Datatypes ===");

        // 1. Vector with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte Vector
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127)
        // - Time Complexity: O(1) for get/set, O(n) for insert/remove (plus synchronization overhead)
        // - Use Case: Store compact numerical data in thread-safe context
        List<Byte> byteVector = new Vector<>();
        byteVector.add((byte) 10);
        byteVector.add((byte) 20);
        System.out.println("Byte Vector: " + byteVector); // [10, 20]

        // Short Vector
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767)
        // - Time Complexity: Same as Vector
        // - Use Case: Store medium-sized numerical data
        List<Short> shortVector = new Vector<>();
        shortVector.add((short) 100);
        shortVector.add((short) 200);
        System.out.println("Short Vector: " + shortVector); // [100, 200]

        // Integer Vector
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers
        // - Time Complexity: Same as Vector
        // - Use Case: DSA problems like Two Sum (LeetCode #1)
        List<Integer> intVector = new Vector<>();
        intVector.add(1000);
        intVector.add(2000);
        System.out.println("Integer Vector: " + intVector); // [1000, 2000]

        // Long Vector
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers
        // - Time Complexity: Same as Vector
        // - Use Case: Large numerical computations
        List<Long> longVector = new Vector<>();
        longVector.add(100000L);
        longVector.add(200000L);
        System.out.println("Long Vector: " + longVector); // [100000, 200000]

        // Float Vector
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision
        // - Time Complexity: Same as Vector
        // - Use Case: Scientific calculations
        List<Float> floatVector = new Vector<>();
        floatVector.add(10.5f);
        floatVector.add(20.5f);
        System.out.println("Float Vector: " + floatVector); // [10.5, 20.5]

        // Double Vector
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers
        // - Time Complexity: Same as Vector
        // - Use Case: Financial or scientific applications
        List<Double> doubleVector = new Vector<>();
        doubleVector.add(100.5);
        doubleVector.add(200.5);
        System.out.println("Double Vector: " + doubleVector); // [100.5, 200.5]

        // Character Vector
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters
        // - Time Complexity: Same as Vector
        // - Use Case: String processing
        List<Character> charVector = new Vector<>();
        charVector.add('A');
        charVector.add('B');
        System.out.println("Character Vector: " + charVector); // [A, B]

        // Boolean Vector
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as Vector
        // - Use Case: Flag-based algorithms
        List<Boolean> boolVector = new Vector<>();
        boolVector.add(true);
        boolVector.add(false);
        System.out.println("Boolean Vector: " + boolVector); // [true, false]

        // 2. Vector with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String Vector
        // Purpose: Store text strings
        // Key Features:
        // - Commonly used for text processing
        // - Time Complexity: Same as Vector
        // - Use Case: Store words in thread-safe applications
        List<String> stringVector = new Vector<>();
        stringVector.add("Apple");
        stringVector.add("Banana");
        System.out.println("String Vector: " + stringVector); // [Apple, Banana]

        // Custom Object (Person) Vector
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires proper equals/hashCode for contains/remove
        // - Time Complexity: Same as Vector
        // - Use Case: Store structured data (e.g., employee records)
        List<Person> personVector = new Vector<>();
        personVector.add(new Person("Alice", 25));
        personVector.add(new Person("Bob", 30));
        System.out.println("Person Vector: " + personVector); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}]

        // Nested Collection Vector
        // Purpose: Store collections within a collection
        // Key Features:
        // - Supports complex structures like adjacency lists
        // - Time Complexity: Same as Vector
        // - Use Case: Graph algorithms (e.g., LeetCode #207)
        List<List<Integer>> nestedVector = new Vector<>();
        nestedVector.add(Arrays.asList(1, 2, 3));
        nestedVector.add(Arrays.asList(4, 5, 6));
        System.out.println("Nested Vector: " + nestedVector); // [[1, 2, 3], [4, 5, 6]]

        // 3. Vector Methods Demonstration
        System.out.println("\n3. Vector Methods Demonstration:");
        List<String> vector = new Vector<>(Arrays.asList("Car", "Bus", "Train", "Car"));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in Vector
        // Key Features:
        // - Synchronized, thread-safe operations
        // - Similar to ArrayList but with lock overhead
        // - Use Case: General-purpose collection operations in multithreaded contexts
        System.out.println("Initial Vector: " + vector); // [Car, Bus, Train, Car]

        // add(E): Adds element to the end
        // Time Complexity: O(1) amortized, synchronized
        // Key Features: May trigger resize, thread-safe
        // Use Case: Append elements in DSA problems
        vector.add("Bike");
        System.out.println("After add(Bike): " + vector); // [Car, Bus, Train, Car, Bike]

        // addAll(Collection): Adds all elements from another collection
        // Time Complexity: O(n), synchronized
        // Key Features: Appends at the end
        // Use Case: Merge lists in algorithms
        vector.addAll(Arrays.asList("Truck", "Van"));
        System.out.println("After addAll([Truck, Van]): " + vector); // [Car, Bus, Train, Car, Bike, Truck, Van]

        // contains(Object): Checks if element exists
        // Time Complexity: O(n), synchronized
        // Key Features: Uses equals method
        // Use Case: Membership testing (e.g., LeetCode #217)
        System.out.println("Contains Train? " + vector.contains("Train")); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n), synchronized
        // Key Features: Uses equals for comparison
        // Use Case: Set operations
        System.out.println("Contains all [Car, Bus]? " + vector.containsAll(Arrays.asList("Car", "Bus"))); // true

        // remove(Object): Removes first occurrence
        // Time Complexity: O(n), synchronized
        // Key Features: Shifts elements after removal
        // Use Case: Remove specific elements
        vector.remove("Car");
        System.out.println("After remove(Car): " + vector); // [Bus, Train, Car, Bike, Truck, Van]

        // removeAll(Collection): Removes all elements in collection
        // Time Complexity: O(n), synchronized
        // Key Features: Removes all occurrences
        // Use Case: Set difference operations
        vector.removeAll(Arrays.asList("Truck", "Van"));
        System.out.println("After removeAll([Truck, Van]): " + vector); // [Bus, Train, Car, Bike]

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n), synchronized
        // Key Features: Removes non-matching elements
        // Use Case: Set intersection operations
        vector.retainAll(Arrays.asList("Bus", "Bike"));
        System.out.println("After retainAll([Bus, Bike]): " + vector); // [Bus, Bike]

        // isEmpty(): Checks if vector is empty
        // Time Complexity: O(1), synchronized
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("Is vector empty? " + vector.isEmpty()); // false

        // size(): Returns number of elements
        // Time Complexity: O(1), synchronized
        // Key Features: Fast access
        // Use Case: Loop bounds in algorithms
        System.out.println("Size: " + vector.size()); // 2

        // toArray(): Returns array of elements
        // Time Complexity: O(n), synchronized
        // Key Features: Copies elements to array
        // Use Case: Convert to array for processing
        Object[] array = vector.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [Bus, Bike]

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n), synchronized
        // Key Features: Type-safe array conversion
        // Use Case: Interfacing with APIs requiring arrays
        String[] stringArray = vector.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray)); // [Bus, Bike]

        // iterator(): Returns iterator for traversal
        // Time Complexity: O(1), synchronized
        // Key Features: Supports safe removal during iteration
        // Use Case: Custom iteration logic
        Iterator<String> iterator = vector.iterator();
        System.out.println("Iterator hasNext: " + iterator.hasNext()); // true

        // List Interface Methods (Specific)
        System.out.println("\nList Interface Methods (Specific):");
        // Purpose: Methods specific to List interface
        // Key Features:
        // - Support index-based operations
        // - Optimized for Vector’s array structure
        // - Use Case: Ordered collection operations
        vector = new Vector<>(Arrays.asList("Car", "Bus", "Train", "Car"));

        // add(int, E): Adds element at index
        // Time Complexity: O(n), synchronized
        // Key Features: Shifts elements to the right
        // Use Case: Insert elements in sorted lists
        vector.add(1, "Bike");
        System.out.println("After add(1, Bike): " + vector); // [Car, Bike, Bus, Train, Car]

        // get(int): Returns element at index
        // Time Complexity: O(1), synchronized
        // Key Features: Fast due to array access
        // Use Case: Random access in DSA (e.g., Two Sum)
        System.out.println("Get index 2: " + vector.get(2)); // Bus

        // set(int, E): Replaces element at index
        // Time Complexity: O(1), synchronized
        // Key Features: Fast replacement
        // Use Case: Update elements in place
        vector.set(2, "Truck");
        System.out.println("After set(2, Truck): " + vector); // [Car, Bike, Truck, Train, Car]

        // remove(int): Removes element at index
        // Time Complexity: O(n), synchronized
        // Key Features: Shifts elements left
        // Use Case: Remove specific positions
        vector.remove(3);
        System.out.println("After remove(3): " + vector); // [Car, Bike, Truck, Car]

        // indexOf(Object): Returns first index of element
        // Time Complexity: O(n), synchronized
        // Key Features: Uses equals for comparison
        // Use Case: Find element positions
        System.out.println("Index of Car: " + vector.indexOf("Car")); // 0

        // lastIndexOf(Object): Returns last index of element
        // Time Complexity: O(n), synchronized
        // Key Features: Useful for duplicates
        // Use Case: Find last occurrence in lists
        System.out.println("Last index of Car: " + vector.lastIndexOf("Car")); // 3

        // listIterator(int): Returns bidirectional iterator
        // Time Complexity: O(1), synchronized
        // Key Features: Supports forward/backward traversal
        // Use Case: Complex list traversals
        ListIterator<String> listIterator = vector.listIterator(1);
        System.out.println("ListIterator next: " + listIterator.next()); // Bike

        // subList(int, int): Returns view of vector portion
        // Time Complexity: O(1), synchronized
        // Key Features: Modifications affect original vector
        // Use Case: Process vector subsets (e.g., sliding window)
        List<String> subList = vector.subList(1, 3);
        System.out.println("Sublist [1, 3): " + subList); // [Bike, Truck]

        // Vector-Specific Methods (Including Legacy)
        System.out.println("\nVector-Specific Methods (Including Legacy):");
        // Purpose: Methods unique to Vector, including legacy methods
        // Key Features:
        // - Support thread safety and legacy iteration
        // - Some methods redundant with List methods
        // - Use Case: Legacy code and simple concurrent applications
        Vector<String> vec = new Vector<>(Arrays.asList("Car", "Bus", "Train"));

        // addElement(E): Adds element to the end
        // Time Complexity: O(1) amortized, synchronized
        // Key Features: Legacy equivalent of add(E)
        // Use Case: Legacy code compatibility
        vec.addElement("Bike");
        System.out.println("After addElement(Bike): " + vec); // [Car, Bus, Train, Bike]

        // insertElementAt(E, int): Inserts element at index
        // Time Complexity: O(n), synchronized
        // Key Features: Legacy equivalent of add(int, E)
        // Use Case: Legacy code insertions
        vec.insertElementAt("Van", 1);
        System.out.println("After insertElementAt(Van, 1): " + vec); // [Car, Van, Bus, Train, Bike]

        // elementAt(int): Returns element at index
        // Time Complexity: O(1), synchronized
        // Key Features: Legacy equivalent of get(int)
        // Use Case: Legacy code access
        System.out.println("Element at 2: " + vec.elementAt(2)); // Bus

        // setElementAt(E, int): Replaces element at index
        // Time Complexity: O(1), synchronized
        // Key Features: Legacy equivalent of set(int, E)
        // Use Case: Legacy code updates
        vec.setElementAt("Truck", 2);
        System.out.println("After setElementAt(Truck, 2): " + vec); // [Car, Van, Truck, Train, Bike]

        // removeElement(Object): Removes first occurrence
        // Time Complexity: O(n), synchronized
        // Key Features: Legacy equivalent of remove(Object)
        // Use Case: Legacy code removals
        vec.removeElement("Train");
        System.out.println("After removeElement(Train): " + vec); // [Car, Van, Truck, Bike]

        // removeElementAt(int): Removes element at index
        // Time Complexity: O(n), synchronized
        // Key Features: Legacy equivalent of remove(int)
        // Use Case: Legacy code index-based removals
        vec.removeElementAt(3);
        System.out.println("After removeElementAt(3): " + vec); // [Car, Van, Truck]

        // elements(): Returns Enumeration of elements
        // Time Complexity: O(1), synchronized
        // Key Features: Legacy iterator for pre-Java 2 code
        // Use Case: Compatibility with legacy systems
        Enumeration<String> enumeration = vec.elements();
        System.out.println("Enumerating Vector:");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        // capacity(): Returns current capacity
        // Time Complexity: O(1), synchronized
        // Key Features: Shows allocated array size
        // Use Case: Memory management
        System.out.println("Capacity: " + vec.capacity()); // 10 (default)

        // ensureCapacity(int): Ensures minimum capacity
        // Time Complexity: O(1) or O(n) if resizing, synchronized
        // Key Features: Reduces resizing overhead
        // Use Case: Optimize for large vectors
        vec.ensureCapacity(20);
        System.out.println("After ensureCapacity(20): " + vec); // [Car, Van, Truck]

        // trimToSize(): Trims capacity to size
        // Time Complexity: O(n), synchronized
        // Key Features: Minimizes memory usage
        // Use Case: Optimize memory for fixed vectors
        vec.trimToSize();
        System.out.println("After trimToSize: " + vec); // [Car, Van, Truck]

        // clone(): Returns shallow copy
        // Time Complexity: O(n), synchronized
        // Key Features: Copies elements, not deep copy
        // Use Case: Create independent vector copies
        Vector<String> clone = (Vector<String>) vec.clone();
        System.out.println("Clone: " + clone); // [Car, Van, Truck]

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n), synchronized
        // Key Features: Java 8+, functional style
        // Use Case: Simplified iteration
        vec.forEach(item -> System.out.println("forEach: " + item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n), synchronized
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal
        vec.removeIf(item -> item.startsWith("V"));
        System.out.println("After removeIf(startsWith V): " + vec); // [Car, Truck]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation, synchronized
        // Key Features: Java 8+, supports functional operations
        // Use Case: Process vectors with streams
        Stream<String> stream = vec.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None"));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}