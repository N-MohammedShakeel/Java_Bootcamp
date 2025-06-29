package Java_Bootcamp.Collections.Map_Interface;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

class TreeMapDemo {
    // TreeMap: Uses a red-black tree (balanced binary search tree) as the underlying data structure.
    // Key Features:
    // - Sorted: Keys are stored in natural order or by a custom Comparator.
    // - O(log n) for put, get, remove due to tree operations.
    // - Does not allow null keys (throws NullPointerException), but allows null values.
    // - Non-synchronized, not thread-safe by default.
    // - Keys must implement Comparable or be provided with a Comparator.
    // - Use Case: Ideal for maintaining a sorted map (e.g., LeetCode #220 Contains Duplicate III).
    public static void demonstrate() {
        System.out.println("=== TreeMap Demonstration with All Datatypes ===");

        // 1. TreeMap with Primitive Types (via Wrappers)
        System.out.println("\n1. Primitive Types (Wrapper Classes):");

        // Integer Keys, String Values
        // Purpose: Store integer keys with string values
        // Key Features:
        // - Keys sorted by natural order (ascending integers)
        // - Time Complexity: O(log n) for put/get/remove
        // - Use Case: Map IDs to names with sorted keys
        Map<Integer, String> intStringMap = new TreeMap<>();
        intStringMap.put(3, "Three");
        intStringMap.put(1, "One");
        intStringMap.put(2, "Two");
        intStringMap.put(1, "OneUpdated"); // Updates value
        // intStringMap.put(null, "NullKey"); // Would throw NullPointerException
        System.out.println("Integer-String Map: " + intStringMap); // {1=OneUpdated, 2=Two, 3=Three}

        // String Keys, Double Values
        // Purpose: Store string keys with double values
        // Key Features:
        // - Keys sorted alphabetically, allows null values
        // - Time Complexity: Same as TreeMap
        // - Use Case: Map names to scores with sorted keys
        Map<String, Double> stringDoubleMap = new TreeMap<>();
        stringDoubleMap.put("Zebra", 85.5);
        stringDoubleMap.put("Apple", 92.0);
        stringDoubleMap.put("Banana", null); // Null value allowed
        System.out.println("String-Double Map: " + stringDoubleMap); // {Apple=92.0, Banana=null, Zebra=85.5}

        // Character Keys, Boolean Values
        // Purpose: Store character keys with boolean values
        // Key Features:
        // - Keys sorted by natural order (ASCII/Unicode)
        // - Time Complexity: Same as TreeMap
        // - Use Case: Map flags to status with sorted keys
        Map<Character, Boolean> charBoolMap = new TreeMap<>();
        charBoolMap.put('C', true);
        charBoolMap.put('A', false);
        charBoolMap.put('B', true);
        System.out.println("Character-Boolean Map: " + charBoolMap); // {A=false, B=true, C=true}

        // 2. TreeMap with Non-Primitive Types
        System.out.println("\n2. Non-Primitive Types:");

        // Person Keys, String Values
        // Purpose: Store custom objects as keys
        // Key Features:
        // - Keys sorted by compareTo (name), requires Comparable
        // - Time Complexity: Same as TreeMap
        // - Use Case: Map user objects to data with sorted keys
        Map<Person, String> personStringMap = new TreeMap<>();
        personStringMap.put(new Person("Zebra", 25), "Developer");
        personStringMap.put(new Person("Apple", 30), "Manager");
        personStringMap.put(new Person("Apple", 40), "Analyst"); // Duplicate name, updates value
        System.out.println("Person-String Map: " + personStringMap); // {Person{name='Apple', age=30}=Analyst, Person{name='Zebra', age=25}=Developer}

        // String Keys, List<Integer> Values
        // Purpose: Store nested collections as values
        // Key Features:
        // - Keys sorted alphabetically, supports complex values
        // - Time Complexity: Same as TreeMap
        // - Use Case: Group data by sorted keys
        Map<String, List<Integer>> stringListMap = new TreeMap<>();
        stringListMap.put("Zebra", Arrays.asList(1, 2, 3));
        stringListMap.put("Apple", Arrays.asList(4, 5, 6));
        System.out.println("String-List Map: " + stringListMap); // {Apple=[4, 5, 6], Zebra=[1, 2, 3]}

        // 3. TreeMap with Custom Comparator
        System.out.println("\n3. TreeMap with Custom Comparator:");
        // Purpose: Demonstrate TreeMap with custom key ordering
        // Key Features:
        // - Uses Comparator for reverse alphabetical order
        // - Time Complexity: Same as TreeMap
        // - Use Case: Custom sorting (e.g., reverse order dictionary)
        Comparator<String> reverseOrder = (s1, s2) -> s2.compareTo(s1);
        Map<String, Integer> reverseTreeMap = new TreeMap<>(reverseOrder);
        reverseTreeMap.put("Zebra", 50);
        reverseTreeMap.put("Apple", 30);
        reverseTreeMap.put("Mango", 40);
        System.out.println("Reverse-Order TreeMap: " + reverseTreeMap); // {Zebra=50, Mango=40, Apple=30}

        // 4. TreeMap Methods Demonstration
        System.out.println("\n4. TreeMap Methods Demonstration:");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 50);
        treeMap.put("Apple", 30);
        treeMap.put("Mango", 40);
        treeMap.put("Banana", null);

        // Map Interface Methods (Inherited)
        System.out.println("\nMap Interface Methods (Inherited):");
        // Purpose: Methods inherited from Map interface
        // Key Features:
        // - Provide core key-value operations, sorted by key
        // - Non-synchronized, requires Collections.synchronizedMap for thread safety
        // - Use Case: Sorted key-value mappings (e.g., LeetCode #220)
        System.out.println("Initial TreeMap: " + treeMap); // {Apple=30, Banana=null, Mango=40, Zebra=50}

        // put(K, V): Associates value with key
        // Time Complexity: O(log n)
        // Key Features: Updates existing key, no null keys, maintains sorted order
        // Use Case: Add or update mappings
        treeMap.put("Cherry", 60);
        treeMap.put("Apple", 35); // Updates value
        System.out.println("After put(Cherry, 60): " + treeMap); // {Apple=35, Banana=null, Cherry=60, Mango=40, Zebra=50}

        // get(Object): Returns value for key
        // Time Complexity: O(log n)
        // Key Features: Returns null if key absent
        // Use Case: Fast lookups with sorted keys
        System.out.println("get(Mango): " + treeMap.get("Mango")); // 40

        // containsKey(Object): Checks if key exists
        // Time Complexity: O(log n)
        // Key Features: Fast key lookup
        // Use Case: Key existence checks
        System.out.println("containsKey(Apple): " + treeMap.containsKey("Apple")); // true

        // containsValue(Object): Checks if value exists
        // Time Complexity: O(n)
        // Key Features: Linear search
        // Use Case: Value existence checks
        System.out.println("containsValue(40): " + treeMap.containsValue(40)); // true

        // remove(Object): Removes mapping for key
        // Time Complexity: O(log n)
        // Key Features: Returns removed value or null, maintains sorted order
        // Use Case: Delete mappings
        System.out.println("remove(Zebra): " + treeMap.remove("Zebra")); // 50
        System.out.println("After remove(Zebra): " + treeMap); // {Apple=35, Banana=null, Cherry=60, Mango=40}

        // putAll(Map): Copies mappings from another map
        // Time Complexity: O(n log n)
        // Key Features: Merges maps, updates existing keys, maintains sorted order
        // Use Case: Combine maps
        Map<String, Integer> otherMap = new TreeMap<>();
        otherMap.put("Date", 70);
        otherMap.put("Apple", 45);
        treeMap.putAll(otherMap);
        System.out.println("After putAll: " + treeMap); // {Apple=45, Banana=null, Cherry=60, Date=70, Mango=40}

        // clear(): Removes all mappings
        // Time Complexity: O(n)
        // Key Features: Empties the map
        // Use Case: Reset map
        treeMap.clear();
        System.out.println("After clear: " + treeMap); // {}

        // isEmpty(): Checks if map is empty
        // Time Complexity: O(1)
        // Key Features: Fast check
        // Use Case: Pre-condition checks
        System.out.println("isEmpty: " + treeMap.isEmpty()); // true

        // Re-populate for further demos
        treeMap.put("Zebra", 50);
        treeMap.put("Apple", 30);
        treeMap.put("Mango", 40);
        treeMap.put("Banana", null);

        // size(): Returns number of mappings
        // Time Complexity: O(1)
        // Key Features: Fast access
        // Use Case: Determine map size
        System.out.println("size: " + treeMap.size()); // 4

        // keySet(): Returns set view of keys
        // Time Complexity: O(1)
        // Key Features: View backed by map, sorted by key
        // Use Case: Iterate over sorted keys
        Set<String> keys = treeMap.keySet();
        System.out.println("keySet: " + keys); // [Apple, Banana, Mango, Zebra]

        // values(): Returns collection view of values
        // Time Complexity: O(1)
        // Key Features: View backed by map
        // Use Case: Iterate over values
        Collection<Integer> values = treeMap.values();
        System.out.println("values: " + values); // [30, null, 40, 50]

        // entrySet(): Returns set view of entries
        // Time Complexity: O(1)
        // Key Features: View backed by map, sorted by key
        // Use Case: Iterate over sorted key-value pairs
        Set<Map.Entry<String, Integer>> entries = treeMap.entrySet();
        System.out.println("entrySet: " + entries); // [Apple=30, Banana=null, Mango=40, Zebra=50]

        // SortedMap Interface Methods (Inherited)
        System.out.println("\nSortedMap Interface Methods (Inherited):");
        // Purpose: Methods inherited from SortedMap interface
        // Key Features:
        // - Provide sorted map operations
        // - Use Case: Access sorted subsets or bounds
        treeMap = new TreeMap<>(Map.of("Zebra", 50, "Apple", 30, "Mango", 40, "Banana", null));

        // comparator(): Returns comparator or null
        // Time Complexity: O(1)
        // Key Features: Indicates natural ordering if null
        // Use Case: Check sorting mechanism
        System.out.println("comparator: " + ((TreeMap<String, Integer>) treeMap).comparator()); // null (natural ordering)

        // firstKey(): Returns lowest key
        // Time Complexity: O(log n)
        // Key Features: Accesses smallest key
        // Use Case: Get minimum key
        System.out.println("firstKey: " + ((TreeMap<String, Integer>) treeMap).firstKey()); // Apple

        // lastKey(): Returns highest key
        // Time Complexity: O(log n)
        // Key Features: Accesses largest key
        // Use Case: Get maximum key
        System.out.println("lastKey: " + ((TreeMap<String, Integer>) treeMap).lastKey()); // Zebra

        // headMap(K): Returns view of keys < toKey
        // Time Complexity: O(log n)
        // Key Features: Sorted submap
        // Use Case: Range queries (e.g., LeetCode #732)
        SortedMap<String, Integer> headMap = ((TreeMap<String, Integer>) treeMap).headMap("Mango");
        System.out.println("headMap(Mango): " + headMap); // {Apple=30, Banana=null}

        // subMap(K, K): Returns view of keys in range
        // Time Complexity: O(log n)
        // Key Features: Sorted submap
        // Use Case: Range queries
        SortedMap<String, Integer> subMap = ((TreeMap<String, Integer>) treeMap).subMap("Banana", "Zebra");
        System.out.println("subMap(Banana, Zebra): " + subMap); // {Banana=null, Mango=40}

        // tailMap(K): Returns view of keys >= fromKey
        // Time Complexity: O(log n)
        // Key Features: Sorted submap
        // Use Case: Range queries
        SortedMap<String, Integer> tailMap = ((TreeMap<String, Integer>) treeMap).tailMap("Mango");
        System.out.println("tailMap(Mango): " + tailMap); // {Mango=40, Zebra=50}

        // NavigableMap Interface Methods (Inherited)
        System.out.println("\nNavigableMap Interface Methods (Inherited):");
        // Purpose: Methods inherited from NavigableMap interface
        // Key Features:
        // - Provide navigation and range operations
        // - Use Case: Precise key navigation (e.g., LeetCode #220)
        treeMap = new TreeMap<>(Map.of("Zebra", 50, "Apple", 30, "Mango", 40, "Banana", null));

        // ceilingEntry(K): Returns entry with least key >= key
        // Time Complexity: O(log n)
        // Key Features: Navigates to next key
        // Use Case: Find next valid key
        System.out.println("ceilingEntry(Cherry): " + ((TreeMap<String, Integer>) treeMap).ceilingEntry("Cherry")); // Mango=40

        // ceilingKey(K): Returns least key >= key
        // Time Complexity: O(log n)
        // Key Features: Key-only navigation
        // Use Case: Find next key
        System.out.println("ceilingKey(Cherry): " + ((TreeMap<String, Integer>) treeMap).ceilingKey("Cherry")); // Mango

        // floorEntry(K): Returns entry with greatest key <= key
        // Time Complexity: O(log n)
        // Key Features: Navigates to previous key
        // Use Case: Find previous valid key
        System.out.println("floorEntry(Cherry): " + ((TreeMap<String, Integer>) treeMap).floorEntry("Cherry")); // Banana=null

        // floorKey(K): Returns greatest key <= key
        // Time Complexity: O(log n)
        // Key Features: Key-only navigation
        // Use Case: Find previous key
        System.out.println("floorKey(Cherry): " + ((TreeMap<String, Integer>) treeMap).floorKey("Cherry")); // Banana

        // higherEntry(K): Returns entry with least key > key
        // Time Complexity: O(log n)
        // Key Features: Strict navigation
        // Use Case: Find next key
        System.out.println("higherEntry(Banana): " + ((TreeMap<String, Integer>) treeMap).higherEntry("Banana")); // Mango=40

        // higherKey(K): Returns least key > key
        // Time Complexity: O(log n)
        // Key Features: Strict key-only navigation
        // Use Case: Find next key
        System.out.println("higherKey(Banana): " + ((TreeMap<String, Integer>) treeMap).higherKey("Banana")); // Mango

        // lowerEntry(K): Returns entry with greatest key < key
        // Time Complexity: O(log n)
        // Key Features: Strict navigation
        // Use Case: Find previous key
        System.out.println("lowerEntry(Mango): " + ((TreeMap<String, Integer>) treeMap).lowerEntry("Mango")); // Banana=null

        // lowerKey(K): Returns greatest key < key
        // Time Complexity: O(log n)
        // Key Features: Strict key-only navigation
        // Use Case: Find previous key
        System.out.println("lowerKey(Mango): " + ((TreeMap<String, Integer>) treeMap).lowerKey("Mango")); // Banana

        // firstEntry(): Returns first entry
        // Time Complexity: O(log n)
        // Key Features: Accesses smallest entry
        // Use Case: Get minimum entry
        System.out.println("firstEntry: " + ((TreeMap<String, Integer>) treeMap).firstEntry()); // Apple=30

        // lastEntry(): Returns last entry
        // Time Complexity: O(log n)
        // Key Features: Accesses largest entry
        // Use Case: Get maximum entry
        System.out.println("lastEntry: " + ((TreeMap<String, Integer>) treeMap).lastEntry()); // Zebra=50

        // pollFirstEntry(): Removes and returns first entry
        // Time Complexity: O(log n)
        // Key Features: Modifies map
        // Use Case: Process and remove minimum entry
        System.out.println("pollFirstEntry: " + ((TreeMap<String, Integer>) treeMap).pollFirstEntry()); // Apple=30
        System.out.println("After pollFirstEntry: " + treeMap); // {Banana=null, Mango=40, Zebra=50}

        // pollLastEntry(): Removes and returns last entry
        // Time Complexity: O(log n)
        // Key Features: Modifies map
        // Use Case: Process and remove maximum entry
        System.out.println("pollLastEntry: " + ((TreeMap<String, Integer>) treeMap).pollLastEntry()); // Zebra=50
        System.out.println("After pollLastEntry: " + treeMap); // {Banana=null, Mango=40}

        // navigableKeySet(): Returns navigable set of keys
        // Time Complexity: O(1)
        // Key Features: Sorted, navigable key set
        // Use Case: Iterate or navigate keys
        NavigableSet<String> navigableKeys = ((TreeMap<String, Integer>) treeMap).navigableKeySet();
        System.out.println("navigableKeySet: " + navigableKeys); // [Banana, Mango]

        // descendingKeySet(): Returns reverse-order key set
        // Time Complexity: O(1)
        // Key Features: Reverse sorted view
        // Use Case: Reverse iteration
        System.out.println("descendingKeySet: " + ((TreeMap<String, Integer>) treeMap).descendingKeySet()); // [Mango, Banana]

        // descendingMap(): Returns reverse-order map view
        // Time Complexity: O(1)
        // Key Features: Reverse sorted view
        // Use Case: Reverse-order operations
        System.out.println("descendingMap: " + ((TreeMap<String, Integer>) treeMap).descendingMap()); // {Mango=40, Banana=null}

        // subMap(K, boolean, K, boolean): Returns range view
        // Time Complexity: O(log n)
        // Key Features: Inclusive/exclusive bounds
        // Use Case: Flexible range queries
        treeMap.put("Apple", 30);
        treeMap.put("Zebra", 50);
        NavigableMap<String, Integer> rangeMap = ((TreeMap<String, Integer>) treeMap).subMap("Banana", true, "Zebra", false);
        System.out.println("subMap(Banana, true, Zebra, false): " + rangeMap); // {Banana=null, Mango=40}

        // headMap(K, boolean): Returns view of keys <= toKey
        // Time Complexity: O(log n)
        // Key Features: Inclusive/exclusive bound
        // Use Case: Range queries
        System.out.println("headMap(Mango, true): " + ((TreeMap<String, Integer>) treeMap).headMap("Mango", true)); // {Apple=30, Banana=null, Mango=40}

        // tailMap(K, boolean): Returns view of keys >= fromKey
        // Time Complexity: O(log n)
        // Key Features: Inclusive/exclusive bound
        // Use Case: Range queries
        System.out.println("tailMap(Banana, true): " + ((TreeMap<String, Integer>) treeMap).tailMap("Banana", true)); // {Banana=null, Mango=40, Zebra=50}

        // AbstractMap Methods (Inherited)
        System.out.println("\nAbstractMap Methods (Inherited):");
        // Purpose: Methods inherited from AbstractMap, Java 8+
        // Key Features:
        // - Support modern Java features
        // - Use Case: Functional programming with sorted keys
        treeMap = new TreeMap<>(Map.of("Zebra", 50, "Apple", 30, "Mango", 40));

        // getOrDefault(Object, V): Returns value or default
        // Time Complexity: O(log n)
        // Key Features: Java 8+, handles missing keys
        // Use Case: Safe retrieval
        System.out.println("getOrDefault(Cherry, 0): " + treeMap.getOrDefault("Cherry", 0)); // 0

        // putIfAbsent(K, V): Puts value if key absent
        // Time Complexity: O(log n)
        // Key Features: Java 8+, avoids overwriting, maintains sorted order
        // Use Case: Conditional insertion
        treeMap.putIfAbsent("Apple", 35);
        treeMap.putIfAbsent("Cherry", 60);
        System.out.println("After putIfAbsent(Cherry, 60): " + treeMap); // {Apple=30, Cherry=60, Mango=40, Zebra=50}

        // remove(Object, Object): Removes if key-value matches
        // Time Complexity: O(log n)
        // Key Features: Java 8+, conditional removal
        // Use Case: Precise deletion
        System.out.println("remove(Mango, 40): " + treeMap.remove("Mango", 40)); // true
        System.out.println("After remove(Mango, 40): " + treeMap); // {Apple=30, Cherry=60, Zebra=50}

        // replace(K, V): Replaces value for key
        // Time Complexity: O(log n)
        // Key Features: Java 8+, updates if key exists
        // Use Case: Update mappings
        System.out.println("replace(Apple, 35): " + treeMap.replace("Apple", 35)); // 30
        System.out.println("After replace(Apple, 35): " + treeMap); // {Apple=35, Cherry=60, Zebra=50}

        // replace(K, V, V): Replaces if key-value matches
        // Time Complexity: O(log n)
        // Key Features: Java 8+, conditional update
        // Use Case: Precise updates
        System.out.println("replace(Zebra, 50, 55): " + treeMap.replace("Zebra", 50, 55)); // true
        System.out.println("After replace(Zebra, 50, 55): " + treeMap); // {Apple=35, Cherry=60, Zebra=55}

        // compute(K, BiFunction): Computes new value for key
        // Time Complexity: O(log n)
        // Key Features: Java 8+, flexible value computation
        // Use Case: Dynamic updates
        treeMap.compute("Cherry", (k, v) -> v + 10);
        System.out.println("After compute(Cherry, +10): " + treeMap); // {Apple=35, Cherry=70, Zebra=55}

        // computeIfAbsent(K, Function): Computes value if key absent
        // Time Complexity: O(log n)
        // Key Features: Java 8+, lazy initialization
        // Use Case: Default values
        treeMap.computeIfAbsent("Date", k -> 80);
        System.out.println("After computeIfAbsent(Date, 80): " + treeMap); // {Apple=35, Cherry=70, Date=80, Zebra=55}

        // computeIfPresent(K, BiFunction): Computes new value if key exists
        // Time Complexity: O(log n)
        // Key Features: Java 8+, conditional update
        // Use Case: Update existing mappings
        treeMap.computeIfPresent("Apple", (k, v) -> v + 5);
        System.out.println("After computeIfPresent(Apple, +5): " + treeMap); // {Apple=40, Cherry=70, Date=80, Zebra=55}

        // merge(K, V, BiFunction): Merges value with existing
        // Time Complexity: O(log n)
        // Key Features: Java 8+, combines values
        // Use Case: Aggregate values (e.g., LeetCode #347)
        treeMap.merge("Zebra", 5, Integer::sum);
        System.out.println("After merge(Zebra, 5, sum): " + treeMap); // {Apple=40, Cherry=70, Date=80, Zebra=60}

        // forEach(BiConsumer): Performs action for each entry
        // Time Complexity: O(n)
        // Key Features: Java 8+, functional style, sorted iteration
        // Use Case: Simplified iteration
        System.out.println("forEach:");
        treeMap.forEach((k, v) -> System.out.println(k + ": " + v));

        // replaceAll(BiFunction): Replaces all values
        // Time Complexity: O(n)
        // Key Features: Java 8+, updates all values
        // Use Case: Batch updates
        treeMap.replaceAll((k, v) -> v + 1);
        System.out.println("After replaceAll(+1): " + treeMap); // {Apple=41, Cherry=71, Date=81, Zebra=61}

        // TreeMap-Specific Methods
        System.out.println("\nTreeMap-Specific Methods:");
        // Purpose: Methods unique to TreeMap implementation
        // Key Features:
        // - Support cloning with sorted order
        // - Use Case: Create copies of sorted maps
        treeMap = new TreeMap<>(Map.of("Zebra", 50, "Apple", 30, "Mango", 40));

        // clone(): Returns shallow copy
        // Time Complexity: O(n)
        // Key Features: Copies mappings, preserves sorted order
        // Use Case: Create independent map copies
        Map<String, Integer> clone = (Map<String, Integer>) ((TreeMap<String, Integer>) treeMap).clone();
        System.out.println("Clone: " + clone); // {Apple=30, Mango=40, Zebra=50}
    }

    public static void main(String[] args) {
        demonstrate();
    }
}