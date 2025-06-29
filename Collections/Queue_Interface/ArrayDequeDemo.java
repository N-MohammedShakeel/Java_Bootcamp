package Java_Bootcamp.Collections.Queue_Interface;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.stream.Stream;

class ArrayDequeDemo {
    // ArrayDeque: Uses a resizable circular array as the underlying data structure.
    // Key Features:
    // - Double-ended queue: Efficient operations at both ends (O(1) for addFirst, addLast, pollFirst, pollLast).
    // - Faster than LinkedList for most operations due to array-based implementation.
    // - Allows duplicates but does not allow null elements (throws NullPointerException).
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity can be specified (default: 16); grows dynamically.
    // - Can be used as a queue (FIFO) or stack (LIFO).
    // - Use Case: Ideal for queue or stack operations (e.g., undo functionality, breadth-first search).
    public static void demonstrate() {
        System.out.println("=== ArrayDeque Demonstration with All Datatypes ===");

        // 1. ArrayDeque with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Byte ArrayDeque
        // Purpose: Store 8-bit integers using Byte wrapper
        // Key Features:
        // - Supports small integer values (-128 to 127)
        // - Time Complexity: O(1) for add/remove at ends
        // - Use Case: Store queue of small numerical values
        Deque<Byte> byteDeque = new ArrayDeque<>();
        byteDeque.addLast((byte) 10);
        byteDeque.addLast((byte) 20);
        byteDeque.addLast((byte) 10); // Duplicate allowed
        System.out.println("Byte Deque: " + byteDeque); // [10, 20, 10]

        // Short ArrayDeque
        // Purpose: Store 16-bit integers using Short wrapper
        // Key Features:
        // - Supports larger range than Byte (-32,768 to 32,767)
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of medium-sized numerical data
        Deque<Short> shortDeque = new ArrayDeque<>();
        shortDeque.addLast((short) 100);
        shortDeque.addLast((short) 200);
        System.out.println("Short Deque: " + shortDeque); // [100, 200]

        // Integer ArrayDeque
        // Purpose: Store 32-bit integers using Integer wrapper
        // Key Features:
        // - Commonly used for general-purpose integers
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: DSA problems like BFS (LeetCode #102)
        Deque<Integer> intDeque = new ArrayDeque<>();
        intDeque.addLast(1000);
        intDeque.addLast(2000);
        intDeque.addLast(1000); // Duplicate allowed
        System.out.println("Integer Deque: " + intDeque); // [1000, 2000, 1000]

        // Long ArrayDeque
        // Purpose: Store 64-bit integers using Long wrapper
        // Key Features:
        // - Supports very large integers
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of large numerical values
        Deque<Long> longDeque = new ArrayDeque<>();
        longDeque.addLast(100000L);
        longDeque.addLast(200000L);
        System.out.println("Long Deque: " + longDeque); // [100000, 200000]

        // Float ArrayDeque
        // Purpose: Store 32-bit floating-point numbers
        // Key Features:
        // - Supports decimal numbers with moderate precision
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of floating-point values
        Deque<Float> floatDeque = new ArrayDeque<>();
        floatDeque.addLast(10.5f);
        floatDeque.addLast(20.5f);
        System.out.println("Float Deque: " + floatDeque); // [10.5, 20.5]

        // Double ArrayDeque
        // Purpose: Store 64-bit floating-point numbers
        // Key Features:
        // - High precision for decimal numbers
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Financial or scientific queue operations
        Deque<Double> doubleDeque = new ArrayDeque<>();
        doubleDeque.addLast(100.5);
        doubleDeque.addLast(200.5);
        System.out.println("Double Deque: " + doubleDeque); // [100.5, 200.5]

        // Character ArrayDeque
        // Purpose: Store single characters
        // Key Features:
        // - Supports Unicode characters
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of characters (e.g., LeetCode #20)
        Deque<Character> charDeque = new ArrayDeque<>();
        charDeque.addLast('A');
        charDeque.addLast('B');
        charDeque.addLast('A'); // Duplicate allowed
        System.out.println("Character Deque: " + charDeque); // [A, B, A]

        // Boolean ArrayDeque
        // Purpose: Store true/false values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of boolean flags
        Deque<Boolean> boolDeque = new ArrayDeque<>();
        boolDeque.addLast(true);
        boolDeque.addLast(false);
        System.out.println("Boolean Deque: " + boolDeque); // [true, false]

        // 2. ArrayDeque with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // String ArrayDeque
        // Purpose: Store text strings
        // Key Features:
        // - Commonly used for queue/stack of text
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of words (e.g., event processing)
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.addLast("Apple");
        stringDeque.addLast("Banana");
        stringDeque.addLast("Apple"); // Duplicate allowed
        System.out.println("String Deque: " + stringDeque); // [Apple, Banana, Apple]

        // Custom Object (Person) ArrayDeque
        // Purpose: Store user-defined objects
        // Key Features:
        // - Requires proper equals/hashCode for contains/remove
        // - Time Complexity: Same as ArrayDeque for ends, O(n) for contains
        // - Use Case: Store queue of structured data (e.g., undo history)
        Deque<Person> personDeque = new ArrayDeque<>();
        personDeque.addLast(new Person("Alice", 25));
        personDeque.addLast(new Person("Bob", 30));
        personDeque.addLast(new Person("Alice", 40)); // Duplicate name, allowed
        System.out.println("Person Deque: " + personDeque); // [Person{name='Alice', age=25}, Person{name='Bob', age=30}, Person{name='Alice', age=40}]

        // Nested Collection ArrayDeque
        // Purpose: Store collections within a collection
        // Key Features:
        // - Supports complex queue structures
        // - Time Complexity: Same as ArrayDeque
        // - Use Case: Store queue of sets (e.g., graph node sets)
        Deque<Deque<Integer>> nestedDeque = new ArrayDeque<>();
        nestedDeque.addLast(new ArrayDeque<>(Arrays.asList(1, 2, 3)));
        nestedDeque.addLast(new ArrayDeque<>(Arrays.asList(4, 5, 6)));
        System.out.println("Nested Deque: " + nestedDeque); // [[1, 2, 3], [4, 5, 6]]

        // 3. ArrayDeque Methods Demonstration
        System.out.println("\n3. ArrayDeque Methods Demonstration:");
        Deque<String> arrayDeque = new ArrayDeque<>(Arrays.asList("First", "Middle", "Last", "First"));

        // Collection Interface Methods (Overridden)
        System.out.println("\nCollection Interface Methods (Overridden):");
        // Purpose: Methods inherited from Collection interface, overridden in ArrayDeque
        // Key Features:
        // - Provide core collection operations for deque
        // - Non-synchronized, requires Collections.synchronizedDeque for thread safety
        // - Use Case: General-purpose deque operations
        System.out.println("Initial ArrayDeque: " + arrayDeque); // [First, Middle, Last, First]

        // add(E): Adds element at the end
        // Time Complexity: O(1)
        // Key Features: Like addLast, allows duplicates
        // Use Case: Append to queue
        arrayDeque.add("NewLast");
        System.out.println("After add(NewLast): " + arrayDeque); // [First, Middle, Last, First, NewLast]

        // addAll(Collection): Adds all elements at the end
        // Time Complexity: O(n)
        // Key Features: Appends collection elements
        // Use Case: Merge collections into deque
        arrayDeque.addAll(Arrays.asList("Extra1", "Extra2"));
        System.out.println("After addAll([Extra1, Extra2]): " + arrayDeque); // [First, Middle, Last, First, NewLast, Extra1, Extra2]

        // contains(Object): Checks if element exists
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Membership testing
        System.out.println("Contains Middle? " + arrayDeque.contains("Middle")); // true

        // containsAll(Collection): Checks if all elements exist
        // Time Complexity: O(n*m)
        // Key Features: Linear search for each element
        // Use Case: Collection inclusion checks
        System.out.println("Contains all [First, Last]? " + arrayDeque.containsAll(Arrays.asList("First", "Last"))); // true

        // remove(Object): Removes first occurrence of element
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Remove specific elements
        arrayDeque.remove("First");
        System.out.println("After remove(First): " + arrayDeque); // [Middle, Last, First, NewLast, Extra1, Extra2]

        // removeAll(Collection): Removes all occurrences of elements in collection
        // Time Complexity: O(n*m)
        // Key Features: Linear search for removals
        // Use Case: Remove multiple elements
        arrayDeque.removeAll(Arrays.asList("Extra1", "Extra2"));
        System.out.println("After removeAll([Extra1, Extra2]): " + arrayDeque); // [Middle, Last, First, NewLast]

        // retainAll(Collection): Retains only specified elements
        // Time Complexity: O(n*m)
        // Key Features: Removes non-matching elements
        // Use Case: Filter deque
        arrayDeque.retainAll(Arrays.asList("Middle", "Last"));
        System.out.println("After retainAll([Middle, Last]): " + arrayDeque); // [Middle, Last]

        // isEmpty(): Checks if deque is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("Is deque empty? " + arrayDeque.isEmpty()); // false

        // size(): Returns number of elements
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine deque size
        System.out.println("Size: " + arrayDeque.size()); // 2

        // toArray(): Returns array of elements
        // Time Complexity: O(n)
        // Key Features: Copies elements in FIFO order
        // Use Case: Convert to array for processing
        Object[] array = arrayDeque.toArray();
        System.out.println("toArray: " + Arrays.toString(array)); // [Middle, Last]

        // toArray(T[]): Returns typed array
        // Time Complexity: O(n)
        // Key Features: Type-safe array conversion in FIFO order
        // Use Case: Interfacing with APIs requiring arrays
        String[] stringArray = arrayDeque.toArray(new String[0]);
        System.out.println("toArray(String[]): " + Arrays.toString(stringArray)); // [Middle, Last]

        // iterator(): Returns iterator for traversal
        // Time Complexity: O(1)
        // Key Features: Iterates in FIFO order, supports safe removal
        // Use Case: Custom iteration logic
        Iterator<String> iterator = arrayDeque.iterator();
        System.out.println("Iterator hasNext: " + iterator.hasNext()); // true

        // Queue Interface Methods (Overridden)
        System.out.println("\nQueue Interface Methods (Overridden):");
        // Purpose: Methods inherited from Queue interface, overridden in ArrayDeque
        // Key Features:
        // - Provide FIFO queue operations
        // - Use Case: Standard queue processing (e.g., LeetCode #102)
        arrayDeque = new ArrayDeque<>(Arrays.asList("First", "Middle", "Last"));

        // offer(E): Adds element at the end
        // Time Complexity: O(1)
        // Key Features: Like offerLast, non-throwing
        // Use Case: Safe append to queue
        arrayDeque.offer("NewLast");
        System.out.println("After offer(NewLast): " + arrayDeque); // [First, Middle, Last, NewLast]

        // peek(): Returns first element without removing
        // Time Complexity: O(1)
        // Key Features: Like peekFirst, non-throwing
        // Use Case: Inspect queue head
        System.out.println("peek: " + arrayDeque.peek()); // First

        // poll(): Removes and returns first element
        // Time Complexity: O(1)
        // Key Features: Like pollFirst, non-throwing
        // Use Case: Safe dequeuing
        System.out.println("poll: " + arrayDeque.poll()); // First
        System.out.println("After poll: " + arrayDeque); // [Middle, Last, NewLast]

        // element(): Returns first element or throws
        // Time Complexity: O(1)
        // Key Features: Like getFirst, throws if empty
        // Use Case: Strict queue access
        System.out.println("element: " + arrayDeque.element()); // Middle

        // remove(): Removes and returns first element or throws
        // Time Complexity: O(1)
        // Key Features: Like removeFirst, throws if empty
        // Use Case: Strict dequeuing
        arrayDeque.remove();
        System.out.println("After remove: " + arrayDeque); // [Last, NewLast]

        // Deque Interface Methods (Overridden)
        System.out.println("\nDeque Interface Methods (Overridden):");
        // Purpose: Methods inherited from Deque interface, overridden in ArrayDeque
        // Key Features:
        // - Provide double-ended operations
        // - Use Case: Queue and stack operations (e.g., LeetCode #20)
        arrayDeque = new ArrayDeque<>(Arrays.asList("Middle", "Last"));

        // addFirst(E): Adds element at the front
        // Time Complexity: O(1)
        // Key Features: Throws if capacity exceeded
        // Use Case: Prepend to deque
        arrayDeque.addFirst("NewFirst");
        System.out.println("After addFirst(NewFirst): " + arrayDeque); // [NewFirst, Middle, Last]

        // addLast(E): Adds element at the end
        // Time Complexity: O(1)
        // Key Features: Throws if capacity exceeded
        // Use Case: Append to deque
        arrayDeque.addLast("NewLast");
        System.out.println("After addLast(NewLast): " + arrayDeque); // [NewFirst, Middle, Last, NewLast]

        // offerFirst(E): Adds element at the front
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe prepend
        arrayDeque.offerFirst("Front");
        System.out.println("After offerFirst(Front): " + arrayDeque); // [Front, NewFirst, Middle, Last, NewLast]

        // offerLast(E): Adds element at the end
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe append
        arrayDeque.offerLast("Back");
        System.out.println("After offerLast(Back): " + arrayDeque); // [Front, NewFirst, Middle, Last, NewLast, Back]

        // removeFirst(): Removes and returns first element or throws
        // Time Complexity: O(1)
        // Key Features: Throws if empty
        // Use Case: Strict dequeuing from front
        System.out.println("removeFirst: " + arrayDeque.removeFirst()); // Front
        System.out.println("After removeFirst: " + arrayDeque); // [NewFirst, Middle, Last, NewLast, Back]

        // removeLast(): Removes and returns last element or throws
        // Time Complexity: O(1)
        // Key Features: Throws if empty
        // Use Case: Strict dequeuing from back
        System.out.println("removeLast: " + arrayDeque.removeLast()); // Back
        System.out.println("After removeLast: " + arrayDeque); // [NewFirst, Middle, Last, NewLast]

        // pollFirst(): Removes and returns first element or null
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe dequeuing from front
        System.out.println("pollFirst: " + arrayDeque.pollFirst()); // NewFirst
        System.out.println("After pollFirst: " + arrayDeque); // [Middle, Last, NewLast]

        // pollLast(): Removes and returns last element or null
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe dequeuing from back
        System.out.println("pollLast: " + arrayDeque.pollLast()); // NewLast
        System.out.println("After pollLast: " + arrayDeque); // [Middle, Last]

        // getFirst(): Returns first element or throws
        // Time Complexity: O(1)
        // Key Features: Throws if empty
        // Use Case: Strict access to front
        System.out.println("getFirst: " + arrayDeque.getFirst()); // Middle

        // getLast(): Returns last element or throws
        // Time Complexity: O(1)
        // Key Features: Throws if empty
        // Use Case: Strict access to back
        System.out.println("getLast: " + arrayDeque.getLast()); // Last

        // peekFirst(): Returns first element or null
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe inspection of front
        System.out.println("peekFirst: " + arrayDeque.peekFirst()); // Middle

        // peekLast(): Returns last element or null
        // Time Complexity: O(1)
        // Key Features: Non-throwing
        // Use Case: Safe inspection of back
        System.out.println("peekLast: " + arrayDeque.peekLast()); // Last

        // removeFirstOccurrence(Object): Removes first occurrence
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Remove specific element from front
        arrayDeque.removeFirstOccurrence("Last");
        System.out.println("After removeFirstOccurrence(Last): " + arrayDeque); // [Middle]

        // removeLastOccurrence(Object): Removes last occurrence
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Remove specific element from back
        arrayDeque.addLast("Middle");
        arrayDeque.removeLastOccurrence("Middle");
        System.out.println("After removeLastOccurrence(Middle): " + arrayDeque); // [Middle]

        // push(E): Adds element at the front
        // Time Complexity: O(1)
        // Key Features: Like addFirst, for stack operations
        // Use Case: LIFO stack push (e.g., LeetCode #20)
        arrayDeque.push("StackTop");
        System.out.println("After push(StackTop): " + arrayDeque); // [StackTop, Middle]

        // pop(): Removes and returns first element or throws
        // Time Complexity: O(1)
        // Key Features: Like removeFirst, for stack operations
        // Use Case: LIFO stack pop
        System.out.println("pop: " + arrayDeque.pop()); // StackTop
        System.out.println("After pop: " + arrayDeque); // [Middle]

        // descendingIterator(): Returns iterator in reverse order
        // Time Complexity: O(1)
        // Key Features: Reverse-order traversal
        // Use Case: Custom reverse iteration
        arrayDeque = new ArrayDeque<>(Arrays.asList("First", "Middle", "Last"));
        Iterator<String> descIterator = arrayDeque.descendingIterator();
        System.out.println("descendingIterator hasNext: " + descIterator.hasNext()); // true

        // ArrayDeque-Specific Methods
        System.out.println("\nArrayDeque-Specific Methods:");
        // Purpose: Methods unique to ArrayDeque implementation
        // Key Features:
        // - Support modern Java features and cloning
        // - Use Case: Functional programming and deque duplication
        arrayDeque = new ArrayDeque<>(Arrays.asList("First", "Middle", "Last"));

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies elements in same order
        // Use Case: Create independent deque copies
        Deque<String> clone = (Deque<String>) ((ArrayDeque<String>) arrayDeque).clone();
        System.out.println("Clone: " + clone); // [First, Middle, Last]

        // forEach(Consumer): Performs action for each element
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style, FIFO order
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        arrayDeque.forEach(item -> System.out.println(item));

        // removeIf(Predicate): Removes elements matching condition
        // Time Complexity: O(n)
        // Key Features: Java 8+, avoids ConcurrentModificationException
        // Use Case: Conditional removal
        arrayDeque.removeIf(item -> item.startsWith("M"));
        System.out.println("After removeIf(startsWith M): " + arrayDeque); // [First, Last]

        // stream(): Returns sequential stream
        // Time Complexity: O(1) for creation
        // Key Features: Java 8+, supports functional operations in FIFO order
        // Use Case: Process deque with streams
        Stream<String> stream = arrayDeque.stream();
        System.out.println("Stream first element: " + stream.findFirst().orElse("None"));
    }

    public static void main(String[] args) {
        demonstrate();
    }
}