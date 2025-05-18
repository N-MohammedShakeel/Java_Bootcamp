package Java_Bootcamp.JavaBasics.ControlFlow;// Java Fundamentals: Loops
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. for Loop
-----------
- Used for iterating a fixed number of times or over a range.
- Syntax:
  for (initialization; condition; update) {
      // Code to execute
  }
- Components:
  - Initialization: Executes once before the loop starts (e.g., int i = 0).
  - Condition: Checked before each iteration (e.g., i < 5).
  - Update: Executes after each iteration (e.g., i++).
- Notes:
  - Ideal for known iteration counts.
  - Can omit components, but semicolons are required (e.g., for(;;) is infinite).
  - Example: for (int i = 1; i <= 5; i++) System.out.println(i);
*/

/*
2. while Loop
-------------
- Executes as long as a condition is true.
- Syntax:
  while (condition) {
      // Code to execute
  }
- Notes:
  - Condition is checked before each iteration.
  - Suitable when the number of iterations is unknown.
  - Risk of infinite loops if condition never becomes false.
  - Example: int i = 1; while (i <= 5) { System.out.println(i); i++; }
*/

/*
3. do-while Loop
----------------
- Executes at least once, then continues as long as the condition is true.
- Syntax:
  do {
      // Code to execute
  } while (condition);
- Notes:
  - Condition is checked after each iteration.
  - Guaranteed to run at least once.
  - Useful for scenarios requiring initial execution (e.g., menu-driven programs).
  - Example: int i = 1; do { System.out.println(i); i++; } while (i <= 5);
*/

/*
4. Enhanced for Loop (for-each)
------------------------------
- Simplifies iteration over arrays or collections (e.g., List, Set).
- Syntax:
  for (Type variable : collection) {
      // Code to execute
  }
- Notes:
  - No explicit counter; directly accesses elements.
  - Cannot modify the collection during iteration (e.g., no index-based updates).
  - Ideal for read-only iteration.
  - Example: for (int num : numbers) System.out.println(num);
*/

public class LoopingStatements {
    public static void main(String[] args) {
        // Example 1: for Loop
        System.out.println("for Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
        }

        // Example 2: while Loop
        System.out.println("\nwhile Loop:");
        int j = 1;
        while (j <= 5) {
            System.out.println("Iteration " + j);
            j++;
        }

        // Example 3: do-while Loop
        System.out.println("\ndo-while Loop:");
        int k = 1;
        do {
            System.out.println("Iteration " + k);
            k++;
        } while (k <= 5);

        // Example 4: Enhanced for Loop
        System.out.println("\nEnhanced for Loop:");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
    }
}