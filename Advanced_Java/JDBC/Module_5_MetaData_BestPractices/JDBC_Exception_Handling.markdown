# Exception Handling

## Overview

JDBC operations can throw a checked exception, **`SQLException`**, which is specifically designed to provide **detailed error information** about database-related issues. Proper exception handling is vital for creating robust applications by allowing developers to diagnose errors accurately and implement graceful recovery mechanisms.

* **Purpose**: Handle database errors to maintain application reliability, log diagnostic data, and provide meaningful user feedback.
* **Core Object**: **`java.sql.SQLException`**.
* **DSA Relevance**: Involves exception **chaining** (similar to linked lists or stack operations), error data processing, and logging.

-----

## `SQLException` Methods

The `SQLException` object contains structured information that helps diagnose and handle errors across different database vendors.

* **`getErrorCode()`**:
  * Returns an integer code that is **database-specific**.
  * *Usage*: Used to identify specific vendor errors for conditional handling (e.g., a specific code for connection refusal).
* **`getSQLState()`**:
  * Returns a **standard 5-character alphanumeric code** defined by the X/Open SQL standard.
  * *Usage*: Provides **cross-database identification** for common error classes (e.g., '42000' for syntax errors, '23000' for integrity constraint violations).
* **`getMessage()`**:
  * Returns a **human-readable error description** provided by the database driver.
  * *Usage*: Primary text for logging and providing contextual user feedback.
* **`getNextException()`**:
  * Retrieves a **chained `SQLException`** object, which may contain additional, detailed errors.
  * *Usage*: Essential for diagnosing errors in bulk operations (like **batch processing**) where multiple commands might fail.
* **Example**:
  ```java
  try {
      stmt.executeQuery("SELECT * FROM <nonexistent_table>");
  } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
      System.err.println("Code: " + e.getErrorCode());
      // Loop through chained exceptions
      while (e.getNextException() != null) {
          e = e.getNextException();
          System.err.println("Chained Error: " + e.getMessage());
      }
  }
  ```

-----

## Best Practices

* **Specificity**: Always catch **`SQLException`** specifically, avoiding the use of the general `catch (Exception e)`, which can mask important database errors.
* **Full Diagnostics**: Log the **`getErrorCode()`**, **`getSQLState()`**, and **`getMessage()`** together for comprehensive error tracking.
* **Chaining**: Use a loop or recursive call on **`getNextException()`** to ensure all linked error details are processed and logged.
* **Resource Management**: Use **`try-with-resources`** for all closable JDBC objects (`Connection`, `Statement`, `ResultSet`) to guarantee resource closure even when exceptions occur.
* **Error Recovery**: Use the `getSQLState()` or `getErrorCode()` to implement specific recovery logic (e.g., retrying an operation on a transient network failure, or stopping on a critical integrity violation).

-----

## Common Pitfalls

* **Oversimplified Catching**: Catching `Exception` instead of `SQLException`, which prevents targeted error handling.
* **Data Loss**: Ignoring `getErrorCode()` or `getSQLState()`, which makes identifying the root cause of an issue (e.g., a **deadlock** vs. a **syntax error**) extremely difficult.
* **Resource Leaks**: Failing to use `try-with-resources`, leading to resources not being closed when exceptions are thrown during early execution stages.
* **Silent Failure**: Using an empty catch block (`catch (SQLException e) {}`), which hides errors from both the user and the logs.

-----

## Practice Task

* **Task**: Execute a SQL query that will intentionally fail (e.g., querying a non-existent table) and properly log the detailed error information.
* **Solution Approach**:
  1.  Execute a DQL (`SELECT`) query against a database object that you know does not exist.
  2.  Catch the resulting **`SQLException`**.
  3.  Extract and print **`getErrorCode()`**, **`getSQLState()`**, and **`getMessage()`**.
  4.  Verify for and process any **chained exceptions**.