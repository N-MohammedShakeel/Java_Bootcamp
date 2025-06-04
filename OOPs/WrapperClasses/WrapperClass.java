package Java_Bootcamp.OOPs.WrapperClasses;

import java.util.ArrayList;

public class WrapperClass {
    public static void main(String[] args) {
        // Autoboxing
        // Purpose: Automatically convert primitive to wrapper object
        int primitiveInt = 42;
        Integer wrapperInt = primitiveInt; // int to Integer
        System.out.println("Autoboxing: " + wrapperInt); // Output: 42

        // Unboxing
        // Purpose: Automatically convert wrapper to primitive
        Integer wrapperInt2 = 100;
        int primitiveInt2 = wrapperInt2; // Integer to int
        System.out.println("Unboxing: " + primitiveInt2); // Output: 100

        // Using Wrappers in Collections
        // Purpose: Store primitives in ArrayList using wrappers
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // Autoboxing: int to Integer
        list.add(20);
        int sum = list.get(0) + list.get(1); // Unboxing: Integer to int
        System.out.println("Sum from list: " + sum); // Output: 30

        // Wrapper Methods
        // Purpose: Demonstrate parsing and conversion
        String str = "123";
        int parsedInt = Integer.parseInt(str); // String to int
        System.out.println("Parsed int: " + parsedInt); // Output: 123
        Integer cachedInt = Integer.valueOf(100); // Cached wrapper
        System.out.println("Cached Integer: " + cachedInt); // Output: 100

        // Null Handling
        // Purpose: Show NullPointerException risk
        Integer nullInt = null;
        try {
            int unboxedNull = nullInt; // Unboxing null throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: null
        }

        // Cached Range Comparison
        // Purpose: Demonstrate Integer caching for -128 to 127
        Integer a = 127;
        Integer b = 127;
        System.out.println("a == b (cached): " + (a == b)); // Output: true
        Integer c = 128;
        Integer d = 128;
        System.out.println("c == d (not cached): " + (c == d)); // Output: false
        System.out.println("c.equals(d): " + c.equals(d)); // Output: true
    }
}