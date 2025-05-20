package Java_Bootcamp.OOPs.Enums;// Java Fundamentals: Enums
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Enums Overview
-------------
- Enums (Enumerations) are special classes in Java used to define a fixed set of constants.
- Introduced in Java 5, enums provide type-safe, compile-time checked constants.
- Declared using the 'enum' keyword, typically in PascalCase.
- Syntax:
  enum EnumName {
      CONSTANT1, CONSTANT2, CONSTANT3;
  }
- Key Features:
  - Enums are implicitly final subclasses of java.lang.Enum.
  - Enum constants are implicitly public, static, and final.
  - Enums can have fields, constructors, and methods.
  - Enums support switch statements, iteration, and comparison.
- Example: enum Day { MONDAY, TUESDAY, WEDNESDAY }

1. Declaring and Using Enums
---------------------------
- Declaration:
  - Define enum constants as a comma-separated list.
  - Example: enum Color { RED, GREEN, BLUE }
- Usage:
  - Access constants using EnumName.CONSTANT (e.g., Color.RED).
  - Assign to variables: EnumName var = EnumName.CONSTANT;
  - Use in switch statements, loops, or comparisons.
- Methods Provided by Enum:
  - values(): Returns an array of all enum constants.
  - valueOf(String): Returns the enum constant with the specified name.
  - name(): Returns the name of the enum constant.
  - ordinal(): Returns the zero-based position of the constant in the declaration.
- Example: for (Day day : Day.values()) { System.out.println(day); }

2. Constructors, Fields, and Methods in Enums
--------------------------------------------
- Constructors:
  - Enums can have private or package-private constructors (implicitly private if not specified).
  - Called automatically for each constant during enum initialization.
  - Example: enum Size { SMALL("S"); private Size(String label) { this.label = label; } }
- Fields:
  - Enums can have instance fields to store additional data for each constant.
  - Example: private String label;
- Methods:
  - Enums can define instance methods and static methods.
  - Can include abstract methods, requiring each constant to provide an implementation.
  - Example: public String getLabel() { return label; }
- Notes:
  - Constructors are not called directly; they initialize constants during enum creation.
  - Fields and methods allow enums to behave like full-fledged classes.

3. Common Use Cases
-------------------
- Represent fixed sets of values (e.g., days, statuses, directions).
- Enhance type safety compared to integer or string constants.
- Use in switch statements for readable control flow.
- Implement strategies or behaviors via methods or abstract methods.
- Example: enum Operation { ADD { double apply(double x, double y) { return x + y; } } }

Notes
-----
- Enums cannot be extended (implicitly final).
- Enums cannot be instantiated with 'new' (constants are predefined).
- Enums are thread-safe and serializable by default.
- Use enums instead of public static final int/String for constants to prevent invalid values.
*/

public class Enums {
    public static void main(String[] args) {
        // Example 1: Using Simple Enum
        System.out.println("Simple Enum (Day):");
        Day today = Day.FRIDAY;
        System.out.println("Today is: " + today); // Today is: FRIDAY
        System.out.println("Ordinal: " + today.ordinal()); // Ordinal: 4
        System.out.println("Name: " + today.name()); // Name: FRIDAY
        System.out.print("All days: ");
        for (Day day : Day.values()) {
            System.out.print(day + " ");
        }
        System.out.println(); // All days: MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY SUNDAY

        // Example 2: Enum in Switch Statement
        System.out.println("\nEnum in Switch Statement:");
        switch (today) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                System.out.println(today + " is a weekday");
                break;
            case FRIDAY:
                System.out.println(today + " is almost the weekend!");
                break;
            default:
                System.out.println(today + " is the weekend!");
        } // FRIDAY is almost the weekend!

        // Example 3: Enum with Fields and Methods
        System.out.println("\nEnum with Fields and Methods (Size):");
        Size size = Size.MEDIUM;
        System.out.println("Size: " + size); // Size: MEDIUM
        System.out.println("Label: " + size.getLabel()); // Label: M
        System.out.println("Level: " + size.getLevel()); // Level: 2
        System.out.println("Is Large? " + size.isLarge()); // Is Large? false
        System.out.println("Is Large (LARGE)? " + Size.LARGE.isLarge()); // Is Large (LARGE)? true

        // Example 4: Enum with Abstract Method
        System.out.println("\nEnum with Abstract Method (Operation):");
        double x = 10.0, y = 5.0;
        for (Operation op : Operation.values()) {
            System.out.printf("%s: %.2f %s %.2f = %.2f%n", 
                              op, x, op.name(), y, op.apply(x, y));
        }
        // ADD: 10.00 ADD 5.00 = 15.00
        // SUBTRACT: 10.00 SUBTRACT 5.00 = 5.00
        // MULTIPLY: 10.00 MULTIPLY 5.00 = 50.00
    }
}