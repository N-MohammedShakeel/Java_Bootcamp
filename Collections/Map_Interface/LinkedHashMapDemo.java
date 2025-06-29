package Java_Bootcamp.Collections.Map_Interface;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LinkedHashMapDemo {
    // LinkedHashMap: Extends HashMap, uses a hash table with a doubly-linked list to maintain insertion order.
    // Key Features:
    // - Maintains insertion order: Entries are returned in the order they were added.
    // - Uses hashing: Same performance as HashMap (O(1) for put, get, remove).
    // - Allows one null key and multiple null values.
    // - Non-synchronized, not thread-safe by default.
    // - Slightly higher memory overhead than HashMap due to linked list.
    // - Use Case: Ideal when order of insertion matters (e.g., LRU cache, LeetCode #146).
    public static void demonstrate() {
        System.out.println("=== LinkedHashMap Demonstration with All Datatypes ===");

        // 1. LinkedHashMap with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Integer Keys, String Values
        // Purpose: Store integer keys with string values
        // Key Features:
        // - Common key-value pair type, maintains insertion order
        // - Time Complexity: O(1) average for put/get/remove
        // - Use Case: Map IDs to names with order preservation
        Map<Integer, String> intStringMap = new LinkedHashMap<>();
        intStringMap.put(1, "One");
        intStringMap.put(2, "Two");
        intStringMap.put(1, "OneUpdated"); // Updates value
        intStringMap.put(null, "NullKey"); // Null key allowed
        System.out.println("Integer-String Map: " + intStringMap); // {1=OneUpdated, 2=Two, null=NullKey}

        // String Keys, Double Values
        // Purpose: Store string keys with double values
        // Key Features:
        // - Supports decimal values, maintains insertion order
        // - Time Complexity: Same as LinkedHashMap
        // - Use Case: Map names to scores with order
        Map<String, Double> stringDoubleMap = new LinkedHashMap<>();
        stringDoubleMap.put("Alice", 85.5);
        stringDoubleMap.put("Bob", 92.0);
        stringDoubleMap.put("Charlie", null); // Null value allowed
        System.out.println("String-Double Map: " + stringDoubleMap); // {Alice=85.5, Bob=92.0, Charlie=null}

        // Character Keys, Boolean Values
        // Purpose: Store character keys with boolean values
        // Key Features:
        // - Minimal memory footprint, maintains insertion order
        // - Time Complexity: Same as LinkedHashMap
        // - Use Case: Map flags to status with order
        Map<Character, Boolean> charBoolMap = new LinkedHashMap<>();
        charBoolMap.put('A', true);
        charBoolMap.put('B', false);
        System.out.println("Character-Boolean Map: " + charBoolMap); // {A=true, B=false}

        // 2. LinkedHashMap with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // Person Keys, String Values
        // Purpose: Store custom objects as keys
        // Key Features:
        // - Requires proper hashCode/equals, maintains insertion order
        // - Time Complexity: Same as LinkedHashMap
        // - Use Case: Map user objects to data with order (e.g., profiles)
        Map<Person, String> personStringMap = new LinkedHashMap<>();
        personStringMap.put(new Person("Alice", 25), "Developer");
        personStringMap.put(new Person("Bob", 30), "Manager");
        personStringMap.put(new Person("Alice", 40), "Analyst"); // Duplicate name, updates value
        System.out.println("Person-String Map: " + personStringMap); // {Person{name='Alice', age=25}=Analyst, Person{name='Bob', age=30}=Manager}

        // String Keys, List<Integer> Values
        // Purpose: Store nested collections as values
        // Key Features:
        // - Supports complex data structures, maintains insertion order
        // - Time Complexity: Same as LinkedHashMap
        // - Use Case: Group data by key with order preservation
        Map<String, List<Integer>> stringListMap = new LinkedHashMap<>();
        stringListMap.put("Group1", Arrays.asList(1, 2, 3));
        stringListMap.put("Group2", Arrays.asList(4, 5, 6));
        System.out.println("String-List Map: " + stringListMap); // {Group1=[1, 2, 3], Group2=[4, 5, 6]}

        // 3. LinkedHashMap Methods Demonstration
        System.out.println("\n3. LinkedHashMap Methods Demonstration:");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Dog", 10);
        linkedHashMap.put("Cat", 15);
        linkedHashMap.put("Bird", 20);
        linkedHashMap.put(null, 25);
        linkedHashMap.put("Fish", null);

        // Map Interface Methods (Inherited via HashMap)
        System.out.println("\nMap Interface Methods (Inherited via HashMap):");
        // Purpose: Methods inherited from Map via HashMap, maintaining insertion order
        // Key Features:
        // - Provide core key-value operations
        // - Non-synchronized, requires Collections.synchronizedMap for thread safety
        // - Use Case: Ordered key-value mappings (e.g., LeetCode #146)
        System.out.println("Initial LinkedHashMap: " + linkedHashMap); // {Dog=12, Cat=15, Bird=20, null=25, Fish=null}

        // put(K, V): Associates value with key
        // Time Complexity: O(1) average
        // Key Features: Updates existing key, allows null key/value, maintains order
        // Use Case: Add or update mappings
        linkedHashMap.put("Horse", 30);
        linkedHashMap.put("Dog", 12); // Updates value
        System.out.println("After put(Horse, 30): " + linkedHashMap); // {Dog=12, Cat=15, Bird=20, null=25, Fish=null, Horse=30}

        // get(Object): Returns value for key
        // Time Complexity: O(1) average
        // Key Features: Returns null if key absent
        // Use Case: Fast lookups with order preservation
        System.out.println("get(Cat): " + linkedHashMap.get("Cat")); // 15
        System.out.println("get(null): " + linkedHashMap.get(null)); // 25

        // containsKey(Object): Checks if key exists
        // Time Complexity: O(1) average
        // Key Features: Fast key lookup
        // Use Case: Key existence checks
        System.out.println("containsKey(Bird): " + linkedHashMap.containsKey("Bird")); // true

        // containsValue(Object): Checks if value exists
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Value existence checks
        System.out.println("containsValue(20): " + linkedHashMap.containsValue(20)); // true

        // remove(Object): Removes mapping for key
        // Time Complexity: O(1) average
        // Key Features: Returns removed value or null, maintains order
        // Use Case: Delete mappings
        System.out.println("remove(Bird): " + linkedHashMap.remove("Bird")); // 20
        System.out.println("After remove(Bird): " + linkedHashMap); // {Dog=12, Cat=15, null=25, Fish=null, Horse=30}

        // putAll(Map): Copies mappings from another map
        // Time Complexity: O(n) average
        // Key Features: Merges maps, updates existing keys, maintains order
        // Use Case: Combine maps
        Map<String, Integer> otherMap = new LinkedHashMap<>();
        otherMap.put("Snake", 35);
        otherMap.put("Dog", 14);
        linkedHashMap.putAll(otherMap);
        System.out.println("After putAll: " + linkedHashMap); // {Dog=14, Cat=15, null=25, Fish=null, Horse=30, Snake=35}

        // clear(): Removes all mappings
        // Time Complexity: O(n)
        // Key Features: Empties the map, resets linked list
        // Use Case: Reset map
        linkedHashMap.clear();
        System.out.println("After clear: " + linkedHashMap); // {}

        // isEmpty(): Checks if map is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("isEmpty: " + linkedHashMap.isEmpty()); // true

        // Re-populate for further demos
        linkedHashMap.put("Dog", 10);
        linkedHashMap.put("Cat", 15);
        linkedHashMap.put("Bird", 20);

        // size(): Returns number of mappings
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine map size
        System.out.println("size: " + linkedHashMap.size()); // 3

        // keySet(): Returns set view of keys
        // Time Complexity: O(1)
        // Key Features: View backed by map, preserves insertion order
        // Use Case: Iterate over keys
        Set<String> keys = linkedHashMap.keySet();
        System.out.println("keySet: " + keys); // [Dog, Cat, Bird]

        // values(): Returns collection view of values
        // Time Complexity: O(1)
        // Key Features: View backed by map, preserves insertion order
        // Use Case: Iterate over values
        Collection<Integer> values = linkedHashMap.values();
        System.out.println("values: " + values); // [10, 15, 20]

        // entrySet(): Returns set view of entries
        // Time Complexity: O(1)
        // Key Features: View backed by map, preserves insertion order
        // Use Case: Iterate over key-value pairs
        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        System.out.println("entrySet: " + entries); // [Dog=10, Cat=15, Bird=20]

        // HashMap Methods (Inherited)
        System.out.println("\nHashMap Methods (Inherited):");
        // Purpose: Methods inherited from HashMap, maintaining insertion order
        // Key Features:
        // - Support modern Java features
        // - Use Case: Functional programming with order
        linkedHashMap = new LinkedHashMap<>(Map.of("Dog", 10, "Cat", 15, "Bird", 20));

        // getOrDefault(Object, V): Returns value or default
        // Time Complexity: O(1) average
        // Key Features: Java 8+, handles missing keys
        // Use Case: Safe retrieval (e.g., LeetCode #560)
        System.out.println("getOrDefault(Horse, 0): " + linkedHashMap.getOrDefault("Horse", 0)); // 0

        // putIfAbsent(K, V): Puts value if key absent
        // Time Complexity: O(1) average
        // Key Features: Java 8+, avoids overwriting, maintains order
        // Use Case: Conditional insertion
        linkedHashMap.putIfAbsent("Dog", 12);
        linkedHashMap.putIfAbsent("Horse", 30);
        System.out.println("After putIfAbsent(Horse, 30): " + linkedHashMap); // {Dog=10, Cat=15, Bird=20, Horse=30}

        // remove(Object, Object): Removes if key-value matches
        // Time Complexity: O(1) average
        // Key Features: Java 8+, conditional removal, maintains order
        // Use Case: Precise deletion
        System.out.println("remove(Cat, 15): " + linkedHashMap.remove("Cat", 15)); // true
        System.out.println("After remove(Cat, 15): " + linkedHashMap); // {Dog=10, Bird=20, Horse=30}

        // replace(K, V): Replaces value for key
        // Time Complexity: O(1) average
        // Key Features: Java 8+, updates if key exists, maintains order
        // Use Case: Update mappings
        System.out.println("replace(Dog, 12): " + linkedHashMap.replace("Dog", 12)); // 10
        System.out.println("After replace(Dog, 12): " + linkedHashMap); // {Dog=12, Bird=20, Horse=30}

        // replace(K, V, V): Replaces if key-value matches
        // Time Complexity: O(1) average
        // Key Features: Java 8+, conditional update, maintains order
        // Use Case: Precise updates
        System.out.println("replace(Bird, 20, 22): " + linkedHashMap.replace("Bird", 20, 22)); // true
        System.out.println("After replace(Bird, 20, 22): " + linkedHashMap); // {Dog=12, Bird=22, Horse=30}

        // compute(K, BiFunction): Computes new value for key
        // Time Complexity: O(1) average
        // Key Features: Java 8+, flexible value computation, maintains order
        // Use Case: Dynamic updates
        linkedHashMap.compute("Horse", (k, v) -> v + 5);
        System.out.println("After compute(Horse, +5): " + linkedHashMap); // {Dog=12, Bird=22, Horse=35}

        // computeIfAbsent(K, Function): Computes value if key absent
        // Time Complexity: O(1) average
        // Key Features: Java 8+, lazy initialization, maintains order
        // Use Case: Default values (e.g., LeetCode #146)
        linkedHashMap.computeIfAbsent("Snake", k -> 40);
        System.out.println("After computeIfAbsent(Snake, 40): " + linkedHashMap); // {Dog=12, Bird=22, Horse=35, Snake=40}

        // computeIfPresent(K, BiFunction): Computes new value if key exists
        // Time Complexity: O(1) average
        // Key Features: Java 8+, conditional update, maintains order
        // Use Case: Update existing mappings
        linkedHashMap.computeIfPresent("Dog", (k, v) -> v + 3);
        System.out.println("After computeIfPresent(Dog, +3): " + linkedHashMap); // {Dog=15, Bird=22, Horse=35, Snake=40}

        // merge(K, V, BiFunction): Merges value with existing
        // Time Complexity: O(1) average
        // Key Features: Java 8+, combines values, maintains order
        // Use Case: Aggregate values (e.g., LeetCode #560)
        linkedHashMap.merge("Bird", 2, Integer::sum);
        System.out.println("After merge(Bird, 2, sum): " + linkedHashMap); // {Dog=15, Bird=24, Horse=35, Snake=40}

        // forEach(BiConsumer): Performs action for each entry
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style, preserves order
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        linkedHashMap.forEach((k, v) -> System.out.println(k + ": " + v));

        // replaceAll(BiFunction): Replaces all values
        // Time Complexity: O(n)
        // Key Features: Java 8+, updates all values, maintains order
        // Use Case: Batch updates
        linkedHashMap.replaceAll((k, v) -> v + 1);
        System.out.println("After replaceAll(+1): " + linkedHashMap); // {Dog=16, Bird=25, Horse=36, Snake=41}

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies mappings, preserves order
        // Use Case: Create independent map copies
        Map<String, Integer> clone = (Map<String, Integer>) ((LinkedHashMap<String, Integer>) linkedHashMap).clone();
        System.out.println("Clone: " + clone); // {Dog=16, Bird=25, Horse=36, Snake=41}

        // LinkedHashMap-Specific: Access-Order Mode
        System.out.println("\nLinkedHashMap Access-Order Demonstration:");
        // Purpose: Show LinkedHashMap in access-order mode
        // Key Features:
        // - Orders entries by access (LRU behavior)
        // - Use Case: Implement LRU cache (e.g., LeetCode #146)
        Map<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("Dog", 10);
        accessOrderMap.put("Cat", 15);
        accessOrderMap.put("Bird", 20);
        System.out.println("Access-Order Map (initial): " + accessOrderMap); // {Dog=10, Cat=15, Bird=20}
        accessOrderMap.get("Dog"); // Access moves Dog to end
        System.out.println("After get(Dog): " + accessOrderMap); // {Cat=15, Bird=20, Dog=10}

        // LinkedHashMap-Specific: Custom Eviction (LRU Cache)
        System.out.println("\nLinkedHashMap LRU Cache Demonstration:");
        // Purpose: Show custom eviction for bounded cache
        // Key Features:
        // - Overrides removeEldestEntry for LRU behavior
        // - Time Complexity: O(1) for eviction check
        // - Use Case: Fixed-size cache (e.g., LeetCode #146)
        class LRUCache<K, V> extends LinkedHashMap<K, V> {
            private final int capacity;

            public LRUCache(int capacity) {
                super(capacity, 0.75f, true);
                this.capacity = capacity;
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                // Purpose: Remove eldest entry when size exceeds capacity
                // Key Features:
                // - Enables LRU eviction
                // - Time Complexity: O(1)
                // - Use Case: Bounded cache implementation
                return size() > capacity;
            }
        }

        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("Dog", 10);
        lruCache.put("Cat", 15);
        lruCache.put("Bird", 20);
        System.out.println("LRU Cache (size=3): " + lruCache); // {Dog=10, Cat=15, Bird=20}
        lruCache.put("Horse", 30); // Removes Dog (eldest)
        System.out.println("After put(Horse, 30): " + lruCache); // {Cat=15, Bird=20, Horse=30}
    }

    public static void main(String[] args) {
        demonstrate();
    }
}