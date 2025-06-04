package Java_Bootcamp.JavaBasics.TypeCasting;

public class PrimitiveTypecasting {
    public static void main(String[] args) {
        // Implicit Casting (Widening)
        // Purpose: Demonstrates automatic conversion from smaller to larger type
        int intVal = 100;
        double doubleVal = intVal; // int to double
        System.out.println("Implicit: int to double: " + doubleVal); // Output: 100.0

        // Explicit Casting (Narrowing)
        // Purpose: Shows manual conversion from larger to smaller type with cast operator
        double doubleVal2 = 123.456;
        int intVal2 = (int) doubleVal2; // double to int (truncates decimal)
        System.out.println("Explicit: double to int: " + intVal2); // Output: 123

        // Char to Numeric Casting
        // Purpose: Illustrates char to int (ASCII) and int to char conversion
        char charVal = 'A';
        int asciiVal = charVal; // char to int (ASCII value)
        System.out.println("Char to int: " + asciiVal); // Output: 65
        int num = 66;
        char charFromNum = (char) num; // int to char
        System.out.println("Int to char: " + charFromNum); // Output: B

        // Potential Overflow Example
        // Purpose: Shows data loss when casting to smaller type
        int largeVal = 130;
        byte byteVal = (byte) largeVal; // int to byte (overflow)
        System.out.println("Int to byte (overflow): " + byteVal); // Output: -126 (130 - 256)
    }
}