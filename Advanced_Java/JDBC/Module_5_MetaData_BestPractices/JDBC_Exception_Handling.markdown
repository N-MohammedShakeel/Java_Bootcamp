# Exception Handling

## Overview
JDBC operations can throw `SQLException`, which provides detailed error information about database issues. Proper exception handling ensures robust applications by diagnosing errors and recovering gracefully.

- **Purpose**: Handle database errors to maintain application reliability and provide meaningful feedback.
- **DSA Relevance**: Involves exception chaining (like stack operations), error data processing, and logging, aligning with DSA concepts.

## SQLException Methods
- **getErrorCode()**:
  - Returns a database-specific error code.
  - Example: PostgreSQL error 42P01 (undefined table).
  - Usage: Identify specific errors for conditional handling.
- **getSQLState()**:
  - Returns a standard 5-character SQL state code.
  - Example: "42P01" for undefined table.
  - Usage: Cross-database error identification.
- **getMessage()**:
  - Returns a human-readable error message.
  - Example: "ERROR: relation 'nonexistent' does not exist".
  - Usage: Display user-friendly error messages.
- **getNextException()**:
  - Retrieves chained exceptions for additional error details.
  - Example: Multiple errors during a batch operation.
- **Example**:
  ```java
  try {
      stmt.executeQuery("SELECT * FROM nonexistent");
  } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
      System.err.println("Code: " + e.getErrorCode());
      System.err.println("State: " + e.getSQLState());
  }
  ```

## Best Practices
- Catch `SQLException` specifically, not general `Exception`.
- Log `getErrorCode()`, `getSQLState()`, and `getMessage()` for diagnostics.
- Check for chained exceptions with `getNextException()`.
- Use `try-with-resources` to ensure resource closure during errors.
- Provide user-friendly error messages based on `SQLException` details.
- Handle specific error codes for database-specific recovery (e.g., retry on deadlock).

## Common Pitfalls
- Catching `Exception` instead of `SQLException`, masking specific errors.
- Ignoring `getErrorCode()` or `getSQLState()`, complicating debugging.
- Not handling chained exceptions, missing critical details.
- Not closing resources in error scenarios, causing leaks.
- Silent error handling (e.g., empty catch blocks), hiding issues.

## Practice Task
- **Task**: Query a non-existent table and print the error code, SQL state, and message.
- **Solution Approach**:
  - Execute a `SELECT` query on a non-existent table (e.g., `nonexistent`).
  - Catch `SQLException` and extract `getErrorCode()`, `getSQLState()`, and `getMessage()`.
  - Log details using `System.err` for visibility.