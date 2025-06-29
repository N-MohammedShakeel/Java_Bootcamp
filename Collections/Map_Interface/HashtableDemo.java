package Java_Bootcamp.Collections.Map_Interface;

import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HashtableDemo {
    // Hashtable: Uses a hash table, similar to HashMap, but synchronized.
    // Key Features:
    // - Synchronized, thread-safe by default (methods are synchronized).
    // - Legacy class (introduced in JDK 1.0), less efficient than HashMap due to synchronization overhead.
    // - Does not allow null keys or null values (throws NullPointerException).
    // - Initial capacity and load factor can be specified (default: 11, 0.75).
    // - Use Case: Suitable for legacy code or when thread-safety is needed without using ConcurrentHashMap.
    public static void demonstrate() {
        System.out.println("=== Hashtable Demonstration with All Datatypes ===");

        // 1. Hashtable with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Integer Keys, String Values
        // Purpose: Store integer keys with string values
        // Key Features:
        // - Common key-value pair type, thread-safe
        // - Time Complexity: O(1) average for put/get/remove
        // - Use Case: Map IDs to names in legacy systems
        Map<Integer, String> intStringMap = new Hashtable<>();
        intStringMap.put(1, "One");
        intStringMap.put(2, "Two");
        intStringMap.put(1, "OneUpdated"); // Updates value
        // intStringMap.put(null, "NullKey"); // Would throw NullPointerException
        System.out.println("Integer-String Map: " + intStringMap); // {2=Two, 1=OneUpdated}

        // String Keys, Double Values
        // Purpose: Store string keys with double values
        // Key Features:
        // - Supports decimal values, thread-safe
        // - Time Complexity: Same as Hashtable
        // - Use Case: Map names to scores in multi-threaded context
        Map<String, Double> stringDoubleMap = new Hashtable<>();
        stringDoubleMap.put("Alice", 85.5);
        stringDoubleMap.put("Bob", 92.0);
        // stringDoubleMap.put("Charlie", null); // Would throw NullPointerException
        System.out.println("String-Double Map: " + stringDoubleMap); // {Bob=92.0, Alice=85.5}

        // Character Keys, Boolean Values
        // Purpose: Store character keys with boolean values
        // Key Features:
        // - Minimal memory footprint, thread-safe
        // - Time Complexity: Same as Hashtable
        // - Use Case: Map flags to status
        Map<Character, Boolean> charBoolMap = new Hashtable<>();
        charBoolMap.put('A', true);
        charBoolMap.put('B', false);
        System.out.println("Character-Boolean Map: " + charBoolMap); // {A=true, B=false}

        // 2. Hashtable with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // Person Keys, String Values
        // Purpose: Store custom objects as keys
        // Key Features:
        // - Requires proper hashCode/equals, thread-safe
        // - Time Complexity: Same as Hashtable
        // - Use Case: Map user objects to data in legacy systems
        Map<Person, String> personStringMap = new Hashtable<>();
        personStringMap.put(new Person("Alice", 25), "Developer");
        personStringMap.put(new Person("Bob", 30), "Manager");
        personStringMap.put(new Person("Alice", 40), "Analyst"); // Duplicate name, updates value
        System.out.println("Person-String Map: " + personStringMap); // {Person{name='Alice', age=25}=Analyst, Person{name='Bob', age=30}=Manager}

        // String Keys, List<Integer> Values
        // Purpose: Store nested collections as values
        // Key Features:
        // - Supports complex data structures, thread-safe
        // - Time Complexity: Same as Hashtable
        // - Use Case: Group data by key in multi-threaded context
        Map<String, List<Integer>> stringListMap = new Hashtable<>();
        stringListMap.put("Group1", Arrays.asList(1, 2, 3));
        stringListMap.put("Group2", Arrays.asList(4, 5, 6));
        System.out.println("String-List Map: " + stringListMap); // {Group2=[4, 5, 6], Group1=[1, 2, 3]}

        // 3. Hashtable Methods Demonstration
        System.out.println("\n3. Hashtable Methods Demonstration:");
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("Car", 100);
        hashtable.put("Bus", 200);
        hashtable.put("Train", 300);

        // Map Interface Methods (Overridden)
        System.out.println("\nMap Interface Methods (Overridden):");
        // Purpose: Methods inherited from Map interface, overridden in Hashtable
        // Key Features:
        // - Provide core key-value operations, synchronized
        // - Use Case: Thread-safe key-value mappings
        System.out.println("Initial Hashtable: " + hashtable); // {Car=100, Bus=200, Train=300}

        // put(K, V): Associates value with key
        // Time Complexity: O(1) average, synchronized
        // Key Features: Updates existing key, no nulls allowed
        // Use Case: Add or update mappings
        hashtable.put("Bike", 400);
        hashtable.put("Car", 150); // Updates value
        System.out.println("After put(Bike, 400): " + hashtable); // {Car=150, Bus=200, Train=300, Bike=400}

        // get(Object): Returns value for key
        // Time Complexity: O(1) average, synchronized
        // Key Features: Returns null if key absent
        // Use Case: Fast lookups in thread-safe context
        System.out.println("get(Bus): " + hashtable.get("Bus")); // 200

        // containsKey(Object): Checks if key exists
        // Time Complexity: O(1) average, synchronized
        // Key Features: Fast key lookup
        // Use Case: Key existence checks
        System.out.println("containsKey(Train): " + hashtable.containsKey("Train")); // true

        // containsValue(Object): Checks if value exists
        // Time Complexity: O(n), synchronized
        // Key Features: Linear search
        // Use Case: Value existence checks
        System.out.println("containsValue(300): " + hashtable.containsValue(300)); // true

        // remove(Object): Removes mapping for key
        // Time Complexity: O(1) average, synchronized
        // Key Features: Returns removed value or null
        // Use Case: Delete mappings
        System.out.println("remove(Train): " + hashtable.remove("Train")); // 300
        System.out.println("After remove(Train): " + hashtable); // {Car=150, Bus=200, Bike=400}

        // putAll(Map): Copies mappings from another map
        // Time Complexity: O(n) average, synchronized
        // Key Features: Merges maps, updates existing keys
        // Use Case: Combine maps
        Map<String, Integer> otherMap = new Hashtable<>();
        otherMap.put("Plane", 500);
        otherMap.put("Car", 160);
        hashtable.putAll(otherMap);
        System.out.println("After putAll: " + hashtable); // {Car=160, Bus=200, Bike=400, Plane=500}

        // clear(): Removes all mappings
        // Time Complexity: O(n), synchronized
        // Key Features: Empties the map
        // Use Case: Reset map
        hashtable.clear();
        System.out.println("After clear: " + hashtable); // {}

        // isEmpty(): Checks if map is empty
        // Time Complexity: O(1), synchronized
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("isEmpty: " + hashtable.isEmpty()); // true

        // Re-populate for further demos
        hashtable.put("Car", 100);
        hashtable.put("Bus", 200);
        hashtable.put("Train", 300);

        // size(): Returns number of mappings
        // Time Complexity: O(1), synchronized
        // Key Features: Fast access
        // Use Case: Determine map size
        System.out.println("size: " + hashtable.size()); // 3

        // keySet(): Returns set view of keys
        // Time Complexity: O(1), synchronized view
        // Key Features: View backed by map
        // Use Case: Iterate over keys
        Set<String> keys = hashtable.keySet();
        System.out.println("keySet: " + keys); // [Car, Bus, Train]

        // values(): Returns collection view of values
        // Time Complexity: O(1), synchronized view
        // Key Features: View backed by map
        // Use Case: Iterate over values
        Collection<Integer> values = hashtable.values();
        System.out.println("values: " + values); // [100, 200, 300]

        // entrySet(): Returns set view of entries
        // Time Complexity: O(1), synchronized view
        // Key Features: View backed by map
        // Use Case: Iterate over key-value pairs
        Set<Map.Entry<String, Integer>> entries = hashtable.entrySet();
        System.out.println("entrySet: " + entries); // [Car=100, Bus=200, Train=300]

        // Hashtable-Specific Methods
        System.out.println("\nHashtable-Specific Methods:");
        // Purpose: Methods unique to Hashtable implementation
        // Key Features:
        // - Support legacy and modern Java features, synchronized
        // - Use Case: Legacy integration and thread-safe operations
        hashtable = new Hashtable<>(Map.of("Car", 100, "Bus", 200, "Train", 300));

        // contains(Object): Legacy method, checks if value exists
        // Time Complexity: O(n), synchronized
        // Key Features: Equivalent to containsValue, deprecated
        // Use Case: Legacy code compatibility
        System.out.println("contains(200): " + hashtable.contains(200)); // true

        // keys(): Returns enumeration of keys
        // Time Complexity: O(1), synchronized
        // Key Features: Legacy method for key iteration
        // Use Case: Pre-Java 1.2 iteration
        Enumeration<String> keyEnum = hashtable.keys();
        System.out.println("keys enumeration hasMoreElements: " + keyEnum.hasMoreElements()); // true

        // elements(): Returns enumeration of values
        // Time Complexity: O(1), synchronized
        // Key Features: Legacy method for value iteration
        // Use Case: Pre-Java 1.2 iteration
        Enumeration<Integer> valueEnum = hashtable.elements();
        System.out.println("elements enumeration hasMoreElements: " + valueEnum.hasMoreElements()); // true

        // getOrDefault(Object, V): Returns value or default
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, handles missing keys
        // Use Case: Safe retrieval
        System.out.println("getOrDefault(Bike, 0): " + hashtable.getOrDefault("Bike", 0)); // 0

        // putIfAbsent(K, V): Puts value if key absent
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, avoids overwriting
        // Use Case: Conditional insertion
        hashtable.putIfAbsent("Car", 150);
        hashtable.putIfAbsent("Bike", 400);
        System.out.println("After putIfAbsent(Bike, 400): " + hashtable); // {Car=100, Bus=200, Train=300, Bike=400}

        // remove(Object, Object): Removes if key-value matches
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, conditional removal
        // Use Case: Precise deletion
        System.out.println("remove(Bus, 200): " + hashtable.remove("Bus", 200)); // true
        System.out.println("After remove(Bus, 200): " + hashtable); // {Car=100, Train=300, Bike=400}

        // replace(K, V): Replaces value for key
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, updates if key exists
        // Use Case: Update mappings
        System.out.println("replace(Car, 150): " + hashtable.replace("Car", 150)); // 100
        System.out.println("After replace(Car, 150): " + hashtable); // {Car=150, Train=300, Bike=400}

        // replace(K, V, V): Replaces if key-value matches
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, conditional update
        // Use Case: Precise updates
        System.out.println("replace(Train, 300, 350): " + hashtable.replace("Train", 300, 350)); // true
        System.out.println("After replace(Train, 300, 350): " + hashtable); // {Car=150, Train=350, Bike=400}

        // compute(K, BiFunction): Computes new value for key
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, flexible value computation
        // Use Case: Dynamic updates
        hashtable.compute("Bike", (k, v) -> v + 50);
        System.out.println("After compute(Bike, +50): " + hashtable); // {Car=150, Train=350, Bike=450}

        // computeIfAbsent(K, Function): Computes value if key absent
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, lazy initialization
        // Use Case: Default values
        hashtable.computeIfAbsent("Plane", k -> 500);
        System.out.println("After computeIfAbsent(Plane, 500): " + hashtable); // {Car=150, Train=350, Bike=450, Plane=500}

        // computeIfPresent(K, BiFunction): Computes new value if key exists
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, conditional update
        // Use Case: Update existing mappings
        hashtable.computeIfPresent("Car", (k, v) -> v + 10);
        System.out.println("After computeIfPresent(Car, +10): " + hashtable); // {Car=160, Train=350, Bike=450, Plane=500}

        // merge(K, V, BiFunction): Merges value with existing
        // Time Complexity: O(1) average, synchronized
        // Key Features: Java 8+, combines values
        // Use Case: Aggregate values
        hashtable.merge("Train", 10, Integer::sum);
        System.out.println("After merge(Train, 10, sum): " + hashtable); // {Car=160, Train=360, Bike=450, Plane=500}

        // forEach(BiConsumer): Performs action for each entry
        // Time Complexity: O(n), synchronized
        // Key Features: Java 8+, functional style
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        hashtable.forEach((k, v) -> System.out.println(k + ": " + v));

        // replaceAll(BiFunction): Replaces all values
        // Time Complexity: O(n), synchronized
        // Key Features: Java 8+, updates all values
        // Use Case: Batch updates
        hashtable.replaceAll((k, v) -> v + 1);
        System.out.println("After replaceAll(+1): " + hashtable); // {Car=161, Train=361, Bike=451, Plane=501}

        // clone(): Returns shallow copy
        // Time Complexity: O(n), synchronized
        // Key Features: Copies mappings
        // Use Case: Create independent map copies
        Map<String, Integer> clone = (Map<String, Integer>) ((Hashtable<String, Integer>) hashtable).clone();
        System.out.println("Clone: " + clone); // {Car=161, Train=361, Bike=451, Plane=501}
    }

    public static void main(String[] args) {
        demonstrate();
    }
}