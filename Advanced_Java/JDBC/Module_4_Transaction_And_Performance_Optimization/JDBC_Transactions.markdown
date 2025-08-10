# Transactions

## Overview
JDBC transactions ensure that multiple database operations are executed as a single, atomic unit, maintaining data integrity through ACID properties (Atomicity, Consistency, Isolation, Durability). Transactions are critical for operations that require multiple steps to succeed or fail together.

- **Purpose**: Group SQL statements to ensure all or none are applied, preventing partial updates.
- **DSA Relevance**: Involves state management (commit/rollback), similar to undo operations in stacks or transaction logs, and resource management.

## Auto-Commit Mode
- **Default**: `Connection` has auto-commit enabled (`con.getAutoCommit() == true`).
- **Behavior**: Each SQL statement is committed immediately after execution.
- **Disable**: `con.setAutoCommit(false)` to start a transaction, allowing manual control.
- **Example**:
  ```java
  con.setAutoCommit(false);
  stmt.executeUpdate("INSERT INTO employee ...");
  con.commit();
  ```

## commit() and rollback()
- **commit()**:
  - Saves all changes in the transaction to the database.
  - Example: `con.commit();`.
- **rollback()**:
  - Reverts all changes since the transaction began.
  - Example: `con.rollback();`.
- **Usage**:
  - Call `commit()` after all statements succeed.
  - Call `rollback()` if any statement fails to maintain consistency.

## Savepoints
- **Purpose**: Mark intermediate points in a transaction for partial rollback.
- **Methods**:
  - `setSavepoint()`: Creates a savepoint (e.g., `Savepoint sp = con.setSavepoint();`).
  - `rollback(Savepoint sp)`: Rolls back to the specified savepoint.
  - `releaseSavepoint(Savepoint sp)`: Removes a savepoint.
- **Example**:
  ```java
  Savepoint sp = con.setSavepoint();
  stmt.executeUpdate("INSERT INTO employee ...");
  con.rollback(sp); // Revert to savepoint
  ```

## Best Practices
- Disable auto-commit for transactions (`setAutoCommit(false)`).
- Call `commit()` or `rollback()` in a `finally` block or use `try-with-resources`.
- Use savepoints for complex transactions with partial rollback needs.
- Handle `SQLException` to detect and recover from failures.
- Restore auto-commit mode after transaction completion.

## Common Pitfalls
- Forgetting to disable auto-commit, causing partial commits.
- Not calling `rollback()` on failure, leading to inconsistent data.
- Overusing savepoints, complicating transaction logic.
- Not closing connections after transactions, causing resource leaks.
- Ignoring transaction isolation levels, leading to concurrency issues.

## Practice Task
- **Task**: Insert two employees in a transaction, committing only if both succeed, otherwise rollback.
- **Solution Approach**:
  - Disable auto-commit with `setAutoCommit(false)`.
  - Use `PreparedStatement` for two `INSERT` statements.
  - Commit if both succeed; rollback on any failure.
  - Restore auto-commit in `finally`.