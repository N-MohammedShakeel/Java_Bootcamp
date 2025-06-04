package Java_Bootcamp.JavaBasics.TypesAndOperators;// Java Fundamentals: Operators
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Arithmetic Operators
----------------------
- Used for basic mathematical operations on numeric types (int, double, etc.).
- Operators:
  - + : Addition (e.g., 5 + 3 = 8)
  - - : Subtraction (e.g., 5 - 3 = 2)
  - * : Multiplication (e.g., 5 * 3 = 15)
  - / : Division (e.g., 15 / 3 = 5; note: integer division truncates decimals)
  - % : Modulus (remainder, e.g., 7 % 3 = 1)
- Notes:
  - Division by zero throws ArithmeticException for integers.
  - Modulus with floating-point numbers is valid (e.g., 7.5 % 2.0 = 1.5).
*/

/*
2. Relational Operators
----------------------
- Compare two values and return a boolean (true/false).
- Operators:
  - == : Equal to (e.g., 5 == 5 is true)
  - != : Not equal to (e.g., 5 != 3 is true)
  - > : Greater than (e.g., 5 > 3 is true)
  - < : Less than (e.g., 3 < 5 is true)
  - >= : Greater than or equal to (e.g., 5 >= 5 is true)
  - <= : Less than or equal to (e.g., 3 <= 5 is true)
- Notes:
  - Used in conditionals (if, while).
  - == for objects compares references, not content (use .equals() for content).
*/

/*
3. Logical Operators
-------------------
- Combine boolean expressions.
- Operators:
  - && : Logical AND (true if both operands are true, e.g., true && false is false)
  - || : Logical OR (true if at least one operand is true, e.g., true || false is true)
  - ! : Logical NOT (negates, e.g., !true is false)
- Notes:
  - Short-circuit evaluation: && stops if left is false; || stops if left is true.
  - Used for complex conditions in control flow.
*/

/*
4. Bitwise and Shift Operators
-----------------------------
- Operate on individual bits of integer types (int, long).
- Bitwise Operators:
  - & : Bitwise AND (e.g., 5 & 3 = 1; 0101 & 0011 = 0001)
  - | : Bitwise OR (e.g., 5 | 3 = 7; 0101 | 0011 = 0111)
  - ^ : Bitwise XOR (e.g., 5 ^ 3 = 6; 0101 ^ 0011 = 0110)
- Shift Operators:
  - << : Left shift (e.g., 5 << 1 = 10; 0101 becomes 1010)
  - >> : Signed right shift (e.g., 10 >> 1 = 5; 1010 becomes 0101)
  - >>> : Unsigned right shift (e.g., -10 >>> 1; fills with zeros)
- Notes:
  - Useful for low-level programming, optimization, or bit manipulation.
  - Shift operators effectively multiply/divide by powers of 2.
*/

/*
5. Assignment and Compound Assignment Operators
----------------------------------------------
- Assignment Operator:
  - = : Assigns value to a variable (e.g., x = 5)
- Compound Assignment Operators:
  - +=, -=, *=, /=, %= : Combine operation and assignment (e.g., x += 3 is x = x + 3)
  - &=, |=, ^=, <<=, >>=, >>>= : Bitwise compound assignments
- Notes:
  - Compound operators are concise and may involve implicit casting.
  - Example: int x = 5; x *= 2; // x becomes 10
*/

/*
6. Operator Precedence
---------------------
- Determines the order of evaluation in expressions.
- Precedence (high to low, partial list):
  1. Parentheses ()
  2. Unary: !, ++, --
  3. Arithmetic: *, /, %, +, -
  4. Shift: <<, >>, >>>
  5. Relational: <, >, <=, >=, ==, !=
  6. Bitwise: &, ^, |
  7. Logical: &&, ||
  8. Assignment: =, +=, -=, etc.
- Notes:
  - Use parentheses to override precedence for clarity.
  - Example: 3 + 5 * 2 = 13 (multiplication first), but (3 + 5) * 2 = 16.
*/

public class Operators {
    public static void main(String[] args) {
        // Arithmetic Operators
        int a = 10, b = 3;
        System.out.println("Arithmetic:");
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3 (integer division)
        System.out.println("a % b = " + (a % b)); // 1

        // Relational Operators
        System.out.println("\nRelational:");
        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a != b: " + (a != b)); // true
        System.out.println("a > b: " + (a > b)); // true
        System.out.println("a < b: " + (a < b)); // false
        System.out.println("a >= b: " + (a >= b)); // true
        System.out.println("a <= b: " + (a <= b)); // false

        // Logical Operators
        boolean x = true, y = false;
        System.out.println("\nLogical:");
        System.out.println("x && y: " + (x && y)); // false
        System.out.println("x || y: " + (x || y)); // true
        System.out.println("!x: " + (!x)); // false

        // Bitwise and Shift Operators
        int c = 5, d = 3; // 5 = 0101, 3 = 0011
        System.out.println("\nBitwise:");
        System.out.println("c & d: " + (c & d)); // 1 (0001)
        System.out.println("c | d: " + (c | d)); // 7 (0111)
        System.out.println("c ^ d: " + (c ^ d)); // 6 (0110)
        System.out.println("c << 1: " + (c << 1)); // 10 (1010)
        System.out.println("c >> 1: " + (c >> 1)); // 2 (0010)
        System.out.println("c >>> 1: " + (c >>> 1)); // 2 (0010)

        // Assignment and Compound Assignment
        int e = 10;
        System.out.println("\nAssignment:");
        e += 5; // e = e + 5
        System.out.println("e += 5: " + e); // 15
        e *= 2; // e = e * 2
        System.out.println("e *= 2: " + e); // 30
        e &= 7; // e = e & 7 (7 = 0111, 30 = 11110, result = 0110 = 6)
        System.out.println("e &= 7: " + e); // 6

        // Operator Precedence
        System.out.println("\nPrecedence:");
        int result = 3 + 5 * 2; // Multiplication first
        System.out.println("3 + 5 * 2 = " + result); // 13
        result = (3 + 5) * 2; // Parentheses override
        System.out.println("(3 + 5) * 2 = " + result); // 16
    }
}