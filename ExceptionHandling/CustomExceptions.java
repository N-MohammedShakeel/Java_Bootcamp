package Java_Bootcamp.ExceptionHandling;/*
Custom Exceptions Overview
-------------------------
- Custom exceptions are user-defined exceptions created to handle specific error conditions in an application.
- Extend either Exception (for checked exceptions) or RuntimeException (for unchecked exceptions).
- Purpose: Provide meaningful, application-specific error handling with clear error messages and context.
- Example: class InvalidAgeException extends Exception { ... }

1. Creating User-Defined Exceptions
----------------------------------
- Steps:
  a. Create a class extending Exception or RuntimeException.
  b. Provide constructors to initialize the exception (typically with a message and/or cause).
  c. Optionally, add custom fields or methods for additional context.
- Syntax:
  class CustomException extends Exception {
      public CustomException(String message) {
          super(message);
      }
      public CustomException(String message, Throwable cause) {
          super(message, cause);
      }
  }
- Checked vs. Unchecked:
  - Extend Exception for checked exceptions (must be declared or handled).
  - Extend RuntimeException for unchecked exceptions (optional to declare or handle).
- Example: class InsufficientBalanceException extends RuntimeException { ... }
- Notes:
  - Use descriptive names (e.g., InvalidInputException) for clarity.
  - Include constructors matching Exception's (message, cause, etc.) for flexibility.
  - Custom exceptions can store additional data (e.g., error codes, invalid values).

2. Best Practices for Exception Handling
---------------------------------------
- a. Use Specific Exceptions:
  - Throw and catch specific exceptions (e.g., IOException instead of Exception) for precise handling.
  - Example: catch (FileNotFoundException e) instead of catch (Exception e).
- b. Provide Meaningful Messages:
  - Include clear, contextual error messages in exceptions.
  - Example: throw new InvalidAgeException("Age cannot be negative: " + age);
- c. Avoid Overusing Exceptions:
  - Use exceptions for exceptional conditions, not regular control flow.
  - Example: Don’t use exceptions to check if a list is empty; use isEmpty().
- d. Handle or Declare Checked Exceptions:
  - Either catch checked exceptions or declare them with throws in the method signature.
  - Example: void readFile() throws IOException { ... }
- e. Use try-with-resources for Resources:
  - Ensure resources (e.g., files, connections) are closed automatically.
  - Example: try (BufferedReader br = new BufferedReader(...)) { ... }
- f. Log Exceptions Appropriately:
  - Log exceptions with relevant details (e.g., stack trace) but avoid exposing sensitive information.
  - Example: logger.error("Error processing data", e);
- g. Preserve Stack Trace:
  - When wrapping exceptions, include the original cause.
  - Example: throw new CustomException("Failed operation", e);
- h. Avoid Empty Catch Blocks:
  - Always handle or log exceptions in catch blocks; empty catch blocks hide errors.
  - Example: catch (IOException e) { logger.error("IO error", e); }
- i. Use Custom Exceptions for Domain Logic:
  - Create custom exceptions for specific business rules or application logic.
  - Example: InsufficientBalanceException for banking applications.
- Notes:
  - Balance between granularity (specific exceptions) and simplicity (avoid excessive custom exceptions).
  - Follow naming conventions: End exception names with "Exception" (e.g., DataValidationException).
*/

// Custom checked exception
class InvalidAgeException extends Exception {
    private final int invalidAge;

    public InvalidAgeException(String message, int invalidAge) {
        super(message);
        this.invalidAge = invalidAge;
    }

    public InvalidAgeException(String message, int invalidAge, Throwable cause) {
        super(message, cause);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}

// Custom unchecked exception
class InsufficientBalanceException extends RuntimeException {
    private final double balance;
    private final double amount;

    public InsufficientBalanceException(String message, double balance, double amount) {
        super(message);
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }
}

public class CustomExceptions {
    public static void main(String[] args) {
        // Example 1: Using checked custom exception (InvalidAgeException)
        System.out.println("Example 1: Checked Custom Exception");
        try {
            setAge(-5); // Throws InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage() + ", Invalid Age: " + e.getInvalidAge());
        }

        // Example 2: Using unchecked custom exception (InsufficientBalanceException)
        System.out.println("\nExample 2: Unchecked Custom Exception");
        try {
            withdraw(1000.0, 500.0); // Throws InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("Balance: " + e.getBalance() + ", Attempted Withdrawal: " + e.getAmount());
        }

        // Example 3: Wrapping an exception with custom exception
        System.out.println("\nExample 3: Wrapping Exception");
        try {
            processInput("invalid"); // Throws InvalidAgeException wrapping NumberFormatException
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getClass().getSimpleName());
        }

        // Example 4: try-with-resources with custom exception
        System.out.println("\nExample 4: try-with-resources");
        try (CustomResource resource = new CustomResource()) {
            resource.process(-10); // Throws InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    // Method throwing checked custom exception
    private static void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative", age);
        }
        System.out.println("Age set to: " + age);
    }

    // Method throwing unchecked custom exception
    private static void withdraw(double balance, double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal", balance, amount);
        }
        System.out.println("Withdrawn: " + amount + ", New Balance: " + (balance - amount));
    }

    // Method wrapping an exception
    private static void processInput(String input) throws InvalidAgeException {
        try {
            int age = Integer.parseInt(input);
            setAge(age);
        } catch (NumberFormatException e) {
            throw new InvalidAgeException("Invalid age format: " + input, -1, e);
        }
    }
}

// Class implementing AutoCloseable for try-with-resources
class CustomResource implements AutoCloseable {
    public void process(int value) throws InvalidAgeException {
        if (value < 0) {
            throw new InvalidAgeException("Negative value not allowed", value);
        }
        System.out.println("Processed value: " + value);
    }

    @Override
    public void close() {
        System.out.println("CustomResource closed");
    }
}