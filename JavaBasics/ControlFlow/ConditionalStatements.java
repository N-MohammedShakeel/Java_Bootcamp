package Java_Bootcamp.JavaBasics.ControlFlow;// Java Fundamentals: Conditional Statements
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. if Statement
---------------
- Executes a block of code if a specified condition evaluates to true.
- Syntax:
  if (condition) {
      // Code to execute if condition is true
  }
- Notes:
  - Condition must be a boolean expression (true or false).
  - Braces are optional for single statements but recommended for clarity.
  - Example: if (age >= 18) System.out.println("Adult");
*/

/*
2. if-else Statement
--------------------
- Executes one block if the condition is true, another if false.
- Syntax:
  if (condition) {
      // Code if condition is true
  } else {
      // Code if condition is false
  }
- Notes:
  - Provides an alternative path when the condition is false.
  - Example: if (score >= 60) System.out.println("Pass"); else System.out.println("Fail");
*/

/*
3. Nested if Statement
----------------------
- An if or if-else statement inside another if or if-else statement.
- Syntax:
  if (condition1) {
      if (condition2) {
          // Code if both conditions are true
      } else {
          // Code if condition1 is true but condition2 is false
      }
  }
- Notes:
  - Useful for multiple levels of conditions.
  - Can become complex; consider readability or alternative approaches (e.g., logical operators).
  - Example: if (isStudent) { if (grade >= 90) System.out.println("Honor Roll"); }
*/

/*
4. switch Statement
-------------------
- Selects one of many code blocks to execute based on a variable's value.
- Syntax:
  switch (expression) {
      case value1:
          // Code for value1
          break;
      case value2:
          // Code for value2
          break;
      default:
          // Code if no case matches
  }
- Notes:
  - Expression must be of type byte, short, char, int, String, or enum (Java 7+).
  - 'break' prevents fall-through to the next case.
  - 'default' is optional and handles unmatched cases.
  - Java 14+ supports switch expressions (not covered here but similar).
  - Example: switch (day) { case 1: System.out.println("Monday"); break; }
*/

public class ConditionalStatements {
    public static void main(String[] args) {
        // Example 1: if Statement
        int age = 20;
        System.out.println("if Statement:");
        if (age >= 18) {
            System.out.println("You are an adult.");
        }

        // Example 2: if-else Statement
        int score = 55;
        System.out.println("\nif-else Statement:");
        if (score >= 60) {
            System.out.println("You passed the exam.");
        } else {
            System.out.println("You failed the exam.");
        }

        // Example 3: Nested if Statement
        boolean isStudent = true;
        int grade = 95;
        System.out.println("\nNested if Statement:");
        if (isStudent) {
            if (grade >= 90) {
                System.out.println("Student is on the Honor Roll.");
            } else {
                System.out.println("Student is not on the Honor Roll.");
            }
        } else {
            System.out.println("Not a student.");
        }

        // Example 4: switch Statement
        int day = 3;
        System.out.println("\nswitch Statement:");
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend or invalid day");
        }
    }
}