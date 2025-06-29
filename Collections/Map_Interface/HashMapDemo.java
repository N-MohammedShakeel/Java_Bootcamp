package Java_Bootcamp.Collections.Map_Interface;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HashMapDemo {
    // HashMap: Uses a hash table as the underlying data structure.
    // Key Features:
    // - Unordered: Key-value pairs are not stored in any specific order.
    // - Uses hashing: Fast average-case performance (O(1) for put, get, remove).
    // - Allows one null key and multiple null values.
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity and load factor can be specified (default: 16, 0.75).
    // - Use Case: Ideal for fast key-value lookups (e.g., caching user data).
    public static void demonstrate() {
        System.out.println("=== HashMap Demonstration with All Datatypes ===");

        // 1. HashMap with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Integer Keys, String Values
        // Purpose: Store integer keys with string values
        // Key Features:
        // - Common key-value pair type
        // - Time Complexity: O(1) average for put/get/remove
        // - Use Case: Map IDs to names
        Map<Integer, String> intStringMap = new HashMap<>();
        intStringMap.put(1, "One");
        intStringMap.put(2, "Two");
        intStringMap.put(1, "OneUpdated"); // Updates value
        intStringMap.put(null, "NullKey"); // Null key allowed
        System.out.println("Integer-String Map: " + intStringMap); // {null=NullKey, 1=OneUpdated, 2=Two}

        // String Keys, Double Values
        // Purpose: Store string keys with double values
        // Key Features:
        // - Supports decimal values
        // - Time Complexity: Same as HashMap
        // - Use Case: Map names to scores
        Map<String, Double> stringDoubleMap = new HashMap<>();
        stringDoubleMap.put("Alice", 85.5);
        stringDoubleMap.put("Bob", 92.0);
        stringDoubleMap.put("Charlie", null); // Null value allowed
        System.out.println("String-Double Map: " + stringDoubleMap); // {Alice=85.5, Bob=92.0, Charlie=null}

        // Character Keys, Boolean Values
        // Purpose: Store character keys with boolean values
        // Key Features:
        // - Minimal memory footprint
        // - Time Complexity: Same as HashMap
        // - Use Case: Map flags to status
        Map<Character, Boolean> charBoolMap = new HashMap<>();
        charBoolMap.put('A', true);
        charBoolMap.put('B', false);
        System.out.println("Character-Boolean Map: " + charBoolMap); // {A=true, B=false}

        // 2. HashMap with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // Person Keys, String Values
        // Purpose: Store custom objects as keys
        // Key Features:
        // - Requires proper hashCode/equals
        // - Time Complexity: Same as HashMap
        // - Use Case: Map user objects to data (e.g., profiles)
        Map<Person, String> personStringMap = new HashMap<>();
        personStringMap.put(new Person("Alice", 25), "Developer");
        personStringMap.put(new Person("Bob", 30), "Manager");
        personStringMap.put(new Person("Alice", 40), "Analyst"); // Duplicate name, updates value
        System.out.println("Person-String Map: " + personStringMap); // {Person{name='Alice', age=25}=Analyst, Person{name='Bob', age=30}=Manager}

        // String Keys, List<Integer> Values
        // Purpose: Store nested collections as values
        // Key Features:
        // - Supports complex data structures
        // - Time Complexity: Same as HashMap
        // - Use Case: Group data by key
        Map<String, List<Integer>> stringListMap = new HashMap<>();
        stringListMap.put("Group1", Arrays.asList(1, 2, 3));
        stringListMap.put("Group2", Arrays.asList(4, 5, 6));
        System.out.println("String-List Map: " + stringListMap); // {Group1=[1, 2, 3], Group2=[4, 5, 6]}

        // 3. HashMap Methods Demonstration
        System.out.println("\n3. HashMap Methods Demonstration:");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 85);
        hashMap.put("Bob", 92);
        hashMap.put("Charlie", 88);
        hashMap.put(null, 100);
        hashMap.put("David", null);

        // Map Interface Methods (Overridden)
        System.out.println("\nMap Interface Methods (Overridden):");
        // Purpose: Methods inherited from Map interface, overridden in HashMap
        // Key Features:
        // - Provide core key-value operations
        // - Non-synchronized, requires Collections.synchronizedMap for thread safety
        // - Use Case: General-purpose key-value mappings
        System.out.println("Initial HashMap: " + hashMap); // {null=100, Alice=85, Bob=92, Charlie=88, David=null}

        // put(K, V): Associates value with key
        // Time Complexity: O(1) average
        // Key Features: Updates existing key, allows null key/value
        // Use Case: Add or update mappings (e.g., LeetCode #1)
        hashMap.put("Eve", 95);
        hashMap.put("Alice", 90); // Updates value
        System.out.println("After put(Eve, 95): " + hashMap); // {null=100, Alice=90, Bob=92, Charlie=88, David=null, Eve=95}

        // get(Object): Returns value for key
        // Time Complexity: O(1) average
        // Key Features: Returns null if key absent
        // Use Case: Fast lookups
        System.out.println("get(Bob): " + hashMap.get("Bob")); // 92
        System.out.println("get(null): " + hashMap.get(null)); // 100

        // containsKey(Object): Checks if key exists
        // Time Complexity: O(1) average
        // Key Features: Fast key lookup
        // Use Case: Key existence checks
        System.out.println("containsKey(Charlie): " + hashMap.containsKey("Charlie")); // true

        // containsValue(Object): Checks if value exists
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Value existence checks
        System.out.println("containsValue(88): " + hashMap.containsValue(88)); // true

        // remove(Object): Removes mapping for key
        // Time Complexity: O(1) average
        // Key Features: Returns removed value or null
        // Use Case: Delete mappings
        System.out.println("remove(Charlie): " + hashMap.remove("Charlie")); // 88
        System.out.println("After remove(Charlie): " + hashMap); // {null=100, Alice=90, Bob=92, David=null, Eve=95}

        // putAll(Map): Copies mappings from another map
        // Time Complexity: O(n) average
        // Key Features: Merges maps, updates existing keys
        // Use Case: Combine maps
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("Frank", 75);
        otherMap.put("Alice", 80);
        hashMap.putAll(otherMap);
        System.out.println("After putAll: " + hashMap); // {null=100, Alice=80, Bob=92, David=null, Eve=95, Frank=75}

        // clear(): Removes all mappings
        // Time Complexity: O(n)
        // Key Features: Empties the map
        // Use Case: Reset map
        hashMap.clear();
        System.out.println("After clear: " + hashMap); // {}

        // isEmpty(): Checks if map is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("isEmpty: " + hashMap.isEmpty()); // true

        // Re-populate for further demos
        hashMap.put("Alice", 85);
        hashMap.put("Bob", 92);
        hashMap.put("Charlie", 88);

        // size(): Returns number of mappings
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine map size
        System.out.println("size: " + hashMap.size()); // 3

        // keySet(): Returns set view of keys
        // Time Complexity: O(1)
        // Key Features: View backed by map
        // Use Case: Iterate over keys
        Set<String> keys = hashMap.keySet();
        System.out.println("keySet: " + keys); // [Alice, Bob, Charlie]

        // values(): Returns collection view of values
        // Time Complexity: O(1)
        // Key Features: View backed by map
        // Use Case: Iterate over values
        Collection<Integer> values = hashMap.values();
        System.out.println("values: " + values); // [85, 92, 88]

        // entrySet(): Returns set view of entries
        // Time Complexity: O(1)
        // Key Features: View backed by map
        // Use Case: Iterate over key-value pairs
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        System.out.println("entrySet: " + entries); // [Alice=85, Bob=92, Charlie=88]

        // HashMap-Specific Methods
        System.out.println("\nHashMap-Specific Methods:");
        // Purpose: Methods unique to HashMap implementation
        // Key Features:
        // - Support modern Java features and advanced operations
        // - Use Case: Functional programming and conditional updates
        hashMap = new HashMap<>(Map.of("Alice", 85, "Bob", 92, "Charlie", 88));

        // getOrDefault(Object, V): Returns value or default
        // Time Complexity: O(1) average
        // Key Features: Java 8+, handles missing keys
        // Use Case: Safe retrieval (e.g., LeetCode #560)
        System.out.println("getOrDefault(Eve, 0): " + hashMap.getOrDefault("Eve", 0)); // 0

        // putIfAbsent(K, V): Puts value if key absent
        // Time Complexity: O(1) average
        // Key Features: Java 8+, avoids overwriting
        // Use Case: Conditional insertion
        hashMap.putIfAbsent("Alice", 100);
        hashMap.putIfAbsent("Eve", 95);
        System.out.println("After putIfAbsent(Eve, 95): " + hashMap); // {Alice=85, Bob=92, Charlie=88, Eve=95}

        // remove(Object, Object): Removes if key-value matches
        // Time Complexity: O(1) average
        // Key Features: Java 8+, conditional removal
        // Use Case: Precise deletion
        System.out.println("remove(Bob, 92): " + hashMap.remove("Bob", 92)); // true
        System.out.println("After remove(Bob, 92): " + hashMap); // {Alice=85, Charlie=88, Eve=95}

        // replace(K, V): Replaces value for key
        // Time Complexity: O(1) average
        // Key Features: Java 8+, updates if key exists
        // Use Case: Update mappings
        System.out.println("replace(Alice, 90): " + hashMap.replace("Alice", 90)); // 85
        System.out.println("After replace(Alice, 90): " + hashMap); // {Alice=90, Charlie=88, Eve=95}

        // replace(K, V, V): Replaces if key-value matches
        // Time Complexity: O(1) average
        // Key Features: Java 8+, conditional update
        // Use Case: Precise updates
        System.out.println("replace(Charlie, 88, 89): " + hashMap.replace("Charlie", 88, 89)); // true
        System.out.println("After replace(Charlie, 88, 89): " + hashMap); // {Alice=90, Charlie=89, Eve=95}

        // compute(K, BiFunction): Computes new value for key
        // Time Complexity: O(1) average
        // Key Features: Java 8+, flexible value computation
        // Use Case: Dynamic updates
        hashMap.compute("Eve", (k, v) -> v == null ? 0 : v + 5);
        System.out.println("After compute(Eve, +5): " + hashMap); // {Alice=90, Charlie=89, Eve=100}

        // computeIfAbsent(K, Function): Computes value if key absent
        // Time Complexity: O(1) average
        // Key Features: Java 8+, lazy initialization
        // Use Case: Default values (e.g., LeetCode #146)
        hashMap.computeIfAbsent("Frank", k -> 75);
        System.out.println("After computeIfAbsent(Frank, 75): " + hashMap); // {Alice=90, Charlie=89, Eve=100, Frank=75}

        // computeIfPresent(K, BiFunction): Computes new value if key exists
        // Time Complexity: O(1) average
        // Key Features: Java 8+, conditional update
        // Use Case: Update existing mappings
        hashMap.computeIfPresent("Alice", (k, v) -> v + 10);
        System.out.println("After computeIfPresent(Alice, +10): " + hashMap); // {Alice=100, Charlie=89, Eve=100, Frank=75}

        // merge(K, V, BiFunction): Merges value with existing
        // Time Complexity: O(1) average
        // Key Features: Java 8+, combines values
        // Use Case: Aggregate values (e.g., LeetCode #560)
        hashMap.merge("Charlie", 1, Integer::sum);
        System.out.println("After merge(Charlie, 1, sum): " + hashMap); // {Alice=100, Charlie=90, Eve=100, Frank=75}

        // forEach(BiConsumer): Performs action for each entry
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        hashMap.forEach((k, v) -> System.out.println(k + ": " + v));

        // replaceAll(BiFunction): Replaces all values
        // Time Complexity: O(n)
        // Key Features: Java 8+, updates all values
        // Use Case: Batch updates
        hashMap.replaceAll((k, v) -> v + 1);
        System.out.println("After replaceAll(+1): " + hashMap); // {Alice=101, Charlie=91, Eve=101, Frank=76}

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies mappings
        // Use Case: Create independent map copies
        Map<String, Integer> clone = (Map<String, Integer>) ((HashMap<String, Integer>) hashMap).clone();
        System.out.println("Clone: " + clone); // {Alice=101, Charlie=91, Eve=101, Frank=76}
    }

    public static void main(String[] args) {
        demonstrate();
    }
}