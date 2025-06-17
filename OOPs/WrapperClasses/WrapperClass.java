package Java_Bootcamp.OOPs.WrapperClasses;

import java.util.ArrayList;

/**
 * MasteringWrapperClasses demonstrates all Java wrapper classes (Byte, Short, Integer, Long, Float, Double, Character, Boolean)
 * with internal implementation details, focusing on object creation, caching, and all relevant cases: autoboxing, unboxing,
 * collections, parsing, null handling, comparisons, utility methods, and edge cases. Designed for Phase 1 learners mastering
 * OOP in the Java Bootcamp, this program includes professional practices and comprehensive examples to understand JVM behavior.
 */

public class WrapperClass {
    public static void main(String[] args) {
        // 1. Byte Wrapper Class
        // Object Creation: Autoboxing uses Byte.valueOf(), leveraging ByteCache for -128 to 127
        byte primitiveByte = 42;
        Byte wrapperByte = primitiveByte; // Autoboxing: Byte.valueOf(42)
        System.out.println("Byte Autoboxing: " + wrapperByte); // Output: 42

        // Caching: Same object for values in -128 to 127
        Byte byte1 = 127;
        Byte byte2 = 127;
        System.out.println("Byte byte1 == byte2 (cached): " + (byte1 == byte2)); // Output: true

        // Unboxing: Converts wrapper to primitive via byteValue()
        Byte wrapperByte2 = 100;
        byte primitiveByte2 = wrapperByte2; // Unboxing: wrapperByte2.byteValue()
        System.out.println("Byte Unboxing: " + primitiveByte2); // Output: 100

        // Parsing: Byte.parseByte() converts String to primitive
        String byteStr = "127";
        byte parsedByte = Byte.parseByte(byteStr);
        System.out.println("Byte Parsed: " + parsedByte); // Output: 127

        // 2. Short Wrapper Class
        // Object Creation: Short.valueOf() caches -128 to 127
        short primitiveShort = 1000;
        Short wrapperShort = primitiveShort; // Autoboxing: Short.valueOf(1000)
        System.out.println("Short Autoboxing: " + wrapperShort); // Output: 1000

        // Caching: Shared objects for -128 to 127
        Short short1 = 127;
        Short short2 = 127;
        System.out.println("Short short1 == short2 (cached): " + (short1 == short2)); // Output: true
        Short short3 = 128;
        Short short4 = 128;
        System.out.println("Short short3 == short4 (not cached): " + (short3 == short4)); // Output: false

        // Collection: Wrappers required for generics
        ArrayList<Short> shortList = new ArrayList<>();
        shortList.add((short) 200); // Autoboxing
        short sumShort = (short) (shortList.get(0) + 300); // Unboxing
        System.out.println("Short Sum: " + sumShort); // Output: 500

        // 3. Integer Wrapper Class
        // Object Creation: Integer.valueOf() uses IntegerCache (-128 to 127 by default)
        int primitiveInt = 42;
        Integer wrapperInt = primitiveInt; // Autoboxing: Integer.valueOf(42)
        System.out.println("Integer Autoboxing: " + wrapperInt); // Output: 42

        // Unboxing: intValue() retrieves primitive
        Integer wrapperInt2 = 100;
        int primitiveInt2 = wrapperInt2; // Unboxing: wrapperInt2.intValue()
        System.out.println("Integer Unboxing: " + primitiveInt2); // Output: 100

        // Collection
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10); // Autoboxing
        intList.add(20);
        int sum = intList.get(0) + intList.get(1); // Unboxing
        System.out.println("Integer Sum from List: " + sum); // Output: 30

        // Parsing and ValueOf
        String intStr = "123";
        int parsedInt = Integer.parseInt(intStr);
        System.out.println("Integer Parsed: " + parsedInt); // Output: 123
        Integer cachedInt = Integer.valueOf(100);
        System.out.println("Integer Cached: " + cachedInt); // Output: 100

        // Null Handling
        Integer nullInt = null;
        try {
            int unboxedNull = nullInt; // Unboxing null throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Integer Null Error: " + e.getMessage()); // Output: null
        }

        // Caching Comparison
        Integer a = 127;
        Integer b = 127;
        System.out.println("Integer a == b (cached): " + (a == b)); // Output: true
        Integer c = 128;
        Integer d = 128;
        System.out.println("Integer c == d (not cached): " + (c == d)); // Output: false
        System.out.println("Integer c.equals(d): " + c.equals(d)); // Output: true

        // Fixed Reference Comparison (corrected from original code)
        Integer a1 = 10;
        Integer b1 = a1; // Same object reference
        System.out.println("Integer a1 == b1 (same object): " + (a1 == b1)); // Output: true
        a1 = 20; // New object via autoboxing (Integer.valueOf(20))
        System.out.println("Integer a1 == b1 (new object): " + (a1 == b1)); // Output: false

        // 4. Long Wrapper Class
        // Object Creation: Long.valueOf() caches -128 to 127
        long primitiveLong = 123456789L;
        Long wrapperLong = primitiveLong; // Autoboxing: Long.valueOf(123456789L)
        System.out.println("Long Autoboxing: " + wrapperLong); // Output: 123456789

        // Caching
        Long long1 = 127L;
        Long long2 = 127L;
        System.out.println("Long long1 == long2 (cached): " + (long1 == long2)); // Output: true

        // Parsing
        String longStr = "987654321";
        long parsedLong = Long.parseLong(longStr);
        System.out.println("Long Parsed: " + parsedLong); // Output: 987654321

        // 5. Float Wrapper Class
        // Object Creation: Float.valueOf() creates new objects (no caching)
        float primitiveFloat = 3.14f;
        Float wrapperFloat = primitiveFloat; // Autoboxing: Float.valueOf(3.14f)
        System.out.println("Float Autoboxing: " + wrapperFloat); // Output: 3.14

        // Comparison Edge Case: No caching, floating-point precision
        Float f1 = 0.1f;
        Float f2 = 0.1f;
        System.out.println("Float f1 == f2 (no cache): " + (f1 == f2)); // Output: false
        System.out.println("Float f1.equals(f2): " + f1.equals(f2)); // Output: true

        // 6. Double Wrapper Class
        // Object Creation: Double.valueOf() creates new objects (no caching)
        double primitiveDouble = 2.71828;
        Double wrapperDouble = primitiveDouble; // Autoboxing: Double.valueOf(2.71828)
        System.out.println("Double Autoboxing: " + wrapperDouble); // Output: 2.71828

        // Utility Method: Handling NaN
        Double nanCheck = Double.isNaN(Double.parseDouble("NaN")) ? Double.NaN : 0.0;
        System.out.println("Double NaN Check: " + nanCheck); // Output: NaN

        // 7. Character Wrapper Class
        // Object Creation: Character.valueOf() caches 0 to 127 (ASCII)
        char primitiveChar = 'A';
        Character wrapperChar = primitiveChar; // Autoboxing: Character.valueOf('A')
        System.out.println("Character Autoboxing: " + wrapperChar); // Output: A

        // Caching
        Character char1 = 'A';
        Character char2 = 'A';
        System.out.println("Character char1 == char2 (cached): " + (char1 == char2)); // Output: true

        // Utility Method
        boolean isLetter = Character.isLetter('B');
        System.out.println("Character isLetter('B'): " + isLetter); // Output: true

        // 8. Boolean Wrapper Class
        // Object Creation: Boolean.valueOf() uses static instances (TRUE/FALSE)
        boolean primitiveBoolean = true;
        Boolean wrapperBoolean = primitiveBoolean; // Autoboxing: Boolean.valueOf(true)
        System.out.println("Boolean Autoboxing: " + wrapperBoolean); // Output: true

        // Caching: Only two objects (Boolean.TRUE, Boolean.FALSE)
        Boolean bool1 = true;
        Boolean bool2 = true;
        System.out.println("Boolean bool1 == bool2 (cached): " + (bool1 == bool2)); // Output: true

        // Parsing
        String boolStr = "true";
        boolean parsedBool = Boolean.parseBoolean(boolStr);
        System.out.println("Boolean Parsed: " + parsedBool); // Output: true

        // Additional Case: Explicit Object Creation with 'new'
        Integer newInt = new Integer(42); // Deprecated, creates new object
        Integer valueOfInt = Integer.valueOf(42); // Uses cache
        System.out.println("new Integer == valueOf (no cache): " + (newInt == valueOfInt)); // Output: false

        // Additional Case: Large Value Edge Case
        Long maxLong = Long.valueOf("9223372036854775807"); // Long.MAX_VALUE
        System.out.println("Large Long: " + maxLong); // Output: 9223372036854775807

        // Additional Case: Mixed Wrapper Collection
        ArrayList<Number> numberList = new ArrayList<>();
        numberList.add(42); // Integer
        numberList.add(3.14); // Double
        System.out.println("Mixed Number List: " + numberList); // Output: [42, 3.14]

        // Additional Case: Utility Methods
        System.out.println("Integer to Hex: " + Integer.toHexString(42)); // Output: 2a
        System.out.println("Double to String: " + Double.toString(3.14)); // Output: 3.14
    }
}

/**
 * Internal Implementation Notes:
 * - Object Creation:
 *   - Autoboxing (e.g., Integer i = 42) invokes valueOf(), which uses caching for efficiency.
 *   - Explicit 'new' (e.g., new Integer(42)) creates a new object, bypassing cache (deprecated).
 *   - valueOf() methods prioritize object reuse via JVM caches.
 * - Caching (Object Sharing):
 *   - Byte, Short, Integer, Long: Cache -128 to 127 (JVM-defined, Integer configurable via -XX:AutoBoxCacheMax).
 *   - Character: Caches 0 to 127 (ASCII range).
 *   - Boolean: Only two objects (TRUE, FALSE).
 *   - Float, Double: No caching; new objects created each time due to floating-point complexity.
 *   - Shared objects mean '==' returns true for cached values (e.g., Integer a = 127; Integer b = 127; a == b is true).
 * - JVM Behavior:
 *   - IntegerCache, ByteCache, etc., are static inner classes in wrapper classes, initialized at class loading.
 *   - Caching reduces memory usage and improves performance for small, frequent values.
 *   - Unboxing null wrappers (e.g., Integer i = null; int j = i;) throws NullPointerException due to method invocation on null.
 * - Professional Practices:
 *   - Use valueOf() over 'new' for efficiency.
 *   - Always use equals() for value comparisons, not '=='.
 *   - Handle null wrappers with checks to avoid exceptions.
 *   - Validate parsed strings to prevent NumberFormatException.
 */

//        **Professional Practices**:
//        - **Code Structure**: Organized by wrapper class, with clear sections for each case (autoboxing, caching, etc.).
//        - **Comments**: Detailed, explaining JVM-level behavior (e.g., `IntegerCache`) and purpose of each example.
//        - **Error Handling**: Try-catch for null unboxing demonstrates robust coding.
//        - **Efficiency**: Emphasizes `valueOf()` and caching awareness for optimized code.
//        - **Clarity**: Console outputs confirm expected behavior, aiding debugging.
//
//        **Notes for Mastery**:
//        - **Object Creation**: Autoboxing uses `valueOf()`, which leverages JVM caches for small values, reducing object creation overhead. Explicit `new` (deprecated) always creates new objects.
//        - **Caching**: `Byte`, `Short`, `Integer`, `Long`, `Character`, and `Boolean` cache specific ranges, ensuring object sharing (e.g., `Integer a = 127; Integer b = 127; a == b` is `true`). `Float` and `Double` don’t cache due to floating-point variability.
//        - **Comparisons**: Use `equals()` for value equality, `==` for object identity. Caching affects `==` results for small values.
//        - **Null Handling**: Always check for `null` before unboxing to avoid `NullPointerException`.
//        - **Parsing**: Validate input strings to prevent `NumberFormatException`.
//        - **Edge Cases**: Handle large values (e.g., `Long.MAX_VALUE`), `NaN`, and floating-point precision issues.


