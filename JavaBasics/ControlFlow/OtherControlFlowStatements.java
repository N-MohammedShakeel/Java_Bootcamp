package Java_Bootcamp.JavaBasics.ControlFlow;// Java Fundamentals: Break, Continue, and Labeled Statements
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. break Statement
-----------------
- Terminates the nearest enclosing loop (for, while, do-while) or switch statement.
- Syntax:
  break;
- Notes:
  - Transfers control to the statement immediately following the loop or switch.
  - Commonly used to exit a loop early when a condition is met.
  - In switch statements, prevents fall-through to subsequent cases.
  - Example: for (int i = 1; i <= 5; i++) { if (i == 3) break; System.out.println(i); }
    // Prints 1, 2, then exits loop.
*/

/*
2. continue Statement
--------------------
- Skips the current iteration of a loop and proceeds to the next iteration.
- Syntax:
  continue;
- Notes:
  - Only affects the innermost loop it is contained within.
  - For for loops, control goes to the update statement; for while/do-while, to the condition check.
  - Useful for skipping specific iterations based on a condition.
  - Example: for (int i = 1; i <= 5; i++) { if (i == 3) continue; System.out.println(i); }
    // Prints 1, 2, 4, 5, skipping 3.
*/

/*
3. Labeled Statements
---------------------
- Allows break or continue to target a specific loop in nested loops by assigning a label.
- Syntax:
  labelName: loop {
      // Code with break labelName; or continue labelName;
  }
- Notes:
  - A label is an identifier followed by a colon (e.g., outer:).
  - break labelName; exits the labeled loop, not just the innermost one.
  - continue labelName; skips to the next iteration of the labeled loop.
  - Improves control in complex nested loops but should be used sparingly for readability.
  - Example:
    outer: for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            if (i == 2 && j == 2) break outer;
        }
    }
    // Exits both loops when i=2, j=2.
*/

public class OtherControlFlowStatements {
    public static void main(String[] args) {
        // Example 1: break Statement
        System.out.println("break Statement:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break; // Exits loop when i is 3
            }
            System.out.println("Iteration " + i);
        }
        // Output: Iteration 1, Iteration 2

        // Example 2: continue Statement
        System.out.println("\ncontinue Statement:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Skips iteration when i is 3
            }
            System.out.println("Iteration " + i);
        }
        // Output: Iteration 1, Iteration 2, Iteration 4, Iteration 5

        // Example 3: Labeled break Statement
        System.out.println("\nLabeled break Statement:");
        outer: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outer; // Exits both loops
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        // Output: i=1, j=1; i=1, j=2; i=1, j=3; i=2, j=1

        // Example 4: Labeled continue Statement
        System.out.println("\nLabeled continue Statement:");
        outerLoop: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    continue outerLoop; // Skips to next iteration of outer loop
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        // Output: i=1, j=1; i=1, j=2; i=1, j=3; i=2, j=1; i=3, j=1; i=3, j=2; i=3, j=3
    }
}