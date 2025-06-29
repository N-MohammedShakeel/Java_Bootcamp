package Java_Bootcamp.Collections.List_Interface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class LinkedListDemo {
    // LinkedList: Uses a doubly-linked list as the underlying data structure.
    // Key Features:
    // - Efficient for insertions/deletions (O(1) at known positions, but finding position is O(n)).
    // - Slow for random access (O(n) to traverse to the index).
    // - Non-synchronized, not thread-safe by default.
    // - Implements both List and Deque interfaces, supporting queue/deque operations.
    // - Use Case: Ideal for frequent insertions/deletions or when queue/deque functionality is needed (e.g., task scheduling).
    public static void demonstrate() {
        System.out.println("\n=== LinkedList Demonstration with All Datatypes ===");

        // 1. LinkedList with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte LinkedList
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127)
        // - Time Complexity: O(1) for add/remove at ends, O(n) for random access
        // - Use Case: Store compact numerical data
        List<Byte> byteList = new LinkedList<>();
        byteList.add((byte) 10);
        byteList.add((byte) 20);
        System.out.println("Byte List: " + byteList); // [10, 20]

        // Short LinkedList
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767)
        // - Time Complexity: Same as LinkedList
        // - Use Case: Store medium-sized numerical data
        List<Short> shortList = new LinkedList<>();
        shortList.add((short) 100);
        shortList.add((short) 200);
        System.out.println("Short List: " + shortList); // [100, 200]

        // Integer LinkedList
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers
        // - Time Complexity: Same as LinkedList
        // - Use Case: DSA problems like Reverse Linked List (LeetCode #206)
        List<Integer> intList = new LinkedList<>();
        intList.add(1000);
        intList.add(2000);
        System.out.println("Integer List: " + intList); // [1000, 2000]

        // Long LinkedList
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers
        // - Time Complexity: Same as LinkedList
        // - Use Case: Large numerical computations
        List<Long> longList = new LinkedList<>();
        longList.add(100000L);
        longList.add(200000L);
        System.out.println("Long List: " + longList); // [100000, 200000]

        // Float LinkedList
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision
        // - Time Complexity: Same as LinkedList
        // - Use Case: Scientific calculations
        List<Float> floatList = new LinkedList<>();
        floatList.add(10.5f);
        floatList.add(20.5f);
        System.out.println("Float List: " + floatList); // [10.5, 20.5]

        // Double LinkedList
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers
        // - Time Complexity: Same as LinkedList
        // - Use Case: Financial or scientific applications
        List<Double> doubleList = new LinkedList<>();
        doubleList.add(100.5);
        doubleList.add(200.5);
        System.out.println("Double List: " + doubleList); // [100.5, 200.5]

        // Character LinkedList
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters
        // - Time Complexity: Same as LinkedList
        // - Use Case: String processing (e.g., LeetCode #20)
        List<Character> charList = new LinkedList<>();
        charList.add('A');
        charList.add('B');
        System.out.println("Character List: " + charList); // [A, B]

        // Boolean LinkedList
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as LinkedList
        // - Use Case: Flag-based algorithms
        List<Boolean> boolList = new LinkedList<>();
        boolList.add(true);
        boolList.add(false);
        System.out.println("Boolean List: " + boolList); // [true, false]

        // 2. LinkedList with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String LinkedList
        // Purpose: Store text strings
        // Key Features:
        // - Commonly used for text processing
        // - Time Complexity: Same as LinkedList
        // - Use Case: Store words for queue-based processing
        List<String> stringList = new LinkedList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        System.out.println("String List: " + stringList); // [Apple, Banana]

        // Custom Object (Person) LinkedList
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires proper equals/hashCode for contains/remove
        // - Time Complexity: Same as LinkedList
        // - Use Case: Store structured data (e.g., employee records)
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 30));
        System.out.println("Person List: " + personList); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}]

        // Nested Collection LinkedList
        // Purpose: Store collections within a collection
        // Key Features:
        // - Supports complex structures like adjacency lists
        // - Time Complexity: Same as LinkedList
        // - Use Case: Graph algorithms (e.g., LeetCode #207)
        List<List<Integer>> nestedList = new LinkedList<>();
        nestedList.add(Arrays.asList(1, 2, 3));
        nestedList.add(Arrays.asList(4, 5, 6));
        System.out.println("Nested List: " + nestedList); // [[1, 2, 3], [4, 5, 6]]

        // 3. LinkedList Methods Demonstration
        System.out.println("\n3. LinkedList Methods Demonstration:");
        List<String> list = new LinkedList<>(Arrays.asList("Dog", "Cat", "Bird", "Dog"));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in LinkedList
        // Key Features:
        // - Provide core collection operations
        // - Non-synchronized, requires Collections.synchronizedList for thread safety
        // - Use Case: General-purpose collection operations
        System.out.println("Initial List: " + list); // [Dog, Cat, Bird, Dog]

        // add(E): Adds element to the end
        // Time Complexity: O(1)
        // Key Features: Adjusts tail pointer
        // Use Case: Append elements in DSA problems
        list.add("Fish");
        System.out.println("After add(Fish): " + list); // [Dog, Cat, Bird, Dog, Fish]

        // addAll(Collection): Adds all elements from another collection
        // Time Complexity: O(n)
        // Key Features: Appends at the end
        // Use Case: Merge lists in algorithms
        list.addAll(Arrays.asList("Mouse", "Wolf"));
        System.out.println("After addAll([Mouse, Wolf]): " + list); // [Dog, Cat, Bird, Dog, Fish, Mouse, Wolf]

        // contains(Object): Checks if element exists
        // Time Complexity: O(n)
        // Key Features: Uses equals method, requires traversal
        // Use Case: Membership testing (e.g., LeetCode #217)
        System.out.println("Contains Bird? " + list.contains("Bird")); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n)
        // Key Features: Uses equals for comparison
        // Use Case: Set operations
        System.out.println("Contains all [Dog, Cat]? " + list.containsAll(Arrays.asList("Dog", "Cat"))); // true

        // remove(Object): Removes first occurrence
        // Time Complexity: O(n)
        // Key Features: Adjusts node links
        // Use Case: Remove specific elements
        list.remove("Dog");
        System.out.println("After remove(Dog): " + list); // [Cat, Bird, Dog, Fish, Mouse, Wolf]

        // removeAll(Collection): Removes all elements in collection
        // Time Complexity: O(n)
        // Key Features: Removes all occurrences
        // Use Case: Set difference operations
        list.removeAll(Arrays.asList("Mouse", "Wolf"));
        System.out.println("After removeAll([Mouse, Wolf]): " + list); // [Cat, Bird, Dog, Fish]

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n)
        // Key Features: Removes non-matching elements
        // Use Case: Set intersection operations
        list.retainAll(Arrays.asList("Cat", "Fish"));
        System.out.println("After retainAll([Cat, Fish]): " + list); // [Cat, Fish]

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
        System.out.println("toArray: " + Arrays.toString(array)); // [Cat, Fish]

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n)
        // Key Features: Type-safe array conversion
        // Use Case: Interfacing with APIs requiring arrays
        String[] stringArray = list.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray)); // [Cat, Fish]

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
        // - Slower for LinkedList due to traversal (O(n))
        // - Use Case: Ordered collection operations
        list = new LinkedList<>(Arrays.asList("Dog", "Cat", "Bird", "Dog"));

        // add(int, E): Adds element at index
        // Time Complexity: O(n) due to traversal
        // Key Features: Adjusts node links
        // Use Case: Insert elements in ordered lists
        list.add(1, "Fish");
        System.out.println("After add(1, Fish): " + list); // [Dog, Fish, Cat, Bird, Dog]

        // get(int): Returns element at index
        // Time Complexity: O(n) due to traversal
        // Key Features: Slow compared to ArrayList
        // Use Case: Access specific positions
        System.out.println("Get index 2: " + list.get(2)); // Cat

        // set(int, E): Replaces element at index
        // Time Complexity: O(n) due to traversal
        // Key Features: Updates node value
        // Use Case: Update elements in place
        list.set(2, "Mouse");
        System.out.println("After set(2, Mouse): " + list); // [Dog, Fish, Mouse, Bird, Dog]

        // remove(int): Removes element at index
        // Time Complexity: O(n) due to traversal
        // Key Features: Adjusts node links
        // Use Case: Remove specific positions
        list.remove(3);
        System.out.println("After remove(3): " + list); // [Dog, Fish, Mouse, Dog]

        // indexOf(Object): Returns first index of element
        // Time Complexity: O(n)
        // Key Features: Uses equals for comparison
        // Use Case: Find element positions
        System.out.println("Index of Dog: " + list.indexOf("Dog")); // 0

        // lastIndexOf(Object): Returns last index of element
        // Time Complexity: O(n)
        // Key Features: Useful for duplicates
        // Use Case: Find last occurrence in lists
        System.out.println("Last index of Dog: " + list.lastIndexOf("Dog")); // 3

        // listIterator(int): Returns bidirectional iterator
        // Time Complexity: O(n) for index traversal
        // Key Features: Supports forward/backward traversal
        // Use Case: Complex list traversals
        ListIterator<String> listIterator = list.listIterator(1);
        System.out.println("ListIterator next: " + listIterator.next()); // Fish

        // subList(int, int): Returns view of list portion
        // Time Complexity: O(1)
        // Key Features: Modifications affect original list
        // Use Case: Process list subsets (e.g., sliding window)
        List<String> subList = list.subList(1, 3);
        System.out.println("Sublist [1, 3): " + subList); // [Fish, Mouse]

        // Deque Interface Methods (Specific)
        System.out.println("\nDeque Interface Methods (Specific):");
        // Purpose: Methods specific to Deque interface
        // Key Features:
        // - Support queue, stack, and deque operations
        // - Efficient at both ends (O(1))
        // - Use Case: Stack/queue operations (e.g., LeetCode #20)
        LinkedList<String> deque = new LinkedList<>(Arrays.asList("Dog", "Cat", "Bird"));

        // addFirst(E): Adds element to the front
        // Time Complexity: O(1)
        // Key Features: Adjusts head pointer
        // Use Case: Stack push or queue operations
        deque.addFirst("Wolf");
        System.out.println("After addFirst(Wolf): " + deque); // [Wolf, Dog, Cat, Bird]

        // addLast(E): Adds element to the end
        // Time Complexity: O(1)
        // Key Features: Equivalent to add(E)
        // Use Case: Queue operations
        deque.addLast("Fish");
        System.out.println("After addLast(Fish): " + deque); // [Wolf, Dog, Cat, Bird, Fish]

        // offerFirst(E): Offers element to the front
        // Time Complexity: O(1)
        // Key Features: Non-throwing version of addFirst
        // Use Case: Safe queue operations
        deque.offerFirst("Bear");
        System.out.println("After offerFirst(Bear): " + deque); // [Bear, Wolf, Dog, Cat, Bird, Fish]

        // offerLast(E): Offers element to the end
        // Time Complexity: O(1)
        // Key Features: Non-throwing version of addLast
        // Use Case: Safe queue operations
        deque.offerLast("Mouse");
        System.out.println("After offerLast(Mouse): " + deque); // [Bear, Wolf, Dog, Cat, Bird, Fish, Mouse]

        // removeFirst(): Removes and returns first element
        // Time Complexity: O(1)
        // Key Features: Throws exception if empty
        // Use Case: Stack pop or queue dequeue
        System.out.println("Remove first: " + deque.removeFirst()); // Bear

        // pollFirst(): Removes and returns first element or null
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe deque operations
        System.out.println("Poll first: " + deque.pollFirst()); // Wolf

        // getFirst(): Returns first element
        // Time Complexity: O(1)
        // Key Features: Throws exception if empty
        // Use Case: Inspect head of queue
        System.out.println("Get first: " + deque.getFirst()); // Dog

        // peekLast(): Returns last element without removing
        // Time Complexity: O(1)
        // Key Features: Returns null if empty
        // Use Case: Inspect tail without modification
        System.out.println("Peek last: " + deque.peekLast()); // Mouse

        // removeFirstOccurrence(Object): Removes first occurrence
        // Time Complexity: O(n)
        // Key Features: Uses equals for comparison
        // Use Case: Remove specific elements
        deque.removeFirstOccurrence("Dog");
        System.out.println("After removeFirstOccurrence(Dog): " + deque); // [Cat, Bird, Fish, Mouse]

        // push(E): Adds element to the front (stack operation)
        // Time Complexity: O(1)
        // Key Features: Equivalent to addFirst
        // Use Case: Stack operations (e.g., LeetCode #225)
        deque.push("Lion");
        System.out.println("After push(Lion): " + deque); // [Lion, Cat, Bird, Fish, Mouse]

        // pop(): Removes and returns first element (stack operation)
        // Time Complexity: O(1)
        // Key Features: Equivalent to removeFirst
        // Use Case: Stack pop operation
        System.out.println("Pop: " + deque.pop()); // Lion

        // descendingIterator(): Returns reverse iterator
        // Time Complexity: O(1)
        // Key Features: Traverses from tail to head
        // Use Case: Reverse list processing
        Iterator<String> descIterator = deque.descendingIterator();
        System.out.print("Descending iterator: ");
        while (descIterator.hasNext()) {
            System.out.print(descIterator.next() + " ");
        }
        System.out.println(); // Mouse Fish Bird Cat

        // LinkedList-Specific Methods
        System.out.println("\nLinkedList-Specific Methods:");
        // Purpose: Methods unique to LinkedList implementation
        // Key Features:
        // - Support memory management and modern Java features
        // - Use Case: Fine-tune LinkedList behavior
        list = new LinkedList<>(Arrays.asList("Dog", "Cat", "Bird"));

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies elements, not deep copy
        // Use Case: Create independent list copies
        List<String> clone = (List<String>) ((LinkedList<String>) list).clone();
        System.out.println("Clone: " + clone); // [Dog, Cat, Bird]

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style
        // Use Case: Simplified iteration
        list.forEach(item -> System.out.println("forEach: " + item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n)
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal (e.g., filter lists)
        list.removeIf(item -> item.startsWith("C"));
        System.out.println("After removeIf(startsWith C): " + list); // [Dog, Bird]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation
        // Key Features: Java 8+, supports functional operations
        // Use Case: Process lists with streams
        Stream<String> stream = list.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None"));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}