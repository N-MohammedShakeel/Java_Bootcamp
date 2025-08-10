# Batch Processing

## Overview
Batch processing in JDBC allows executing multiple SQL statements as a single unit, improving performance for bulk operations like inserts or updates. It reduces network overhead by sending multiple statements in one database call.

- **Purpose**: Efficiently execute multiple DML statements (e.g., bulk inserts).
- **DSA Relevance**: Involves bulk data processing (like array/list operations), loop optimization, and transaction management, aligning with DSA concepts.

## addBatch() and executeBatch()
- **addBatch()**:
  - Adds a parameterized query to the batch.
  - Used with `PreparedStatement` after setting parameters.
  - Example: `pstmt.setString(1, "John"); pstmt.addBatch();`
- **executeBatch()**:
  - Executes all batched statements, returning an array of update counts.
  - Example: `int[] results = pstmt.executeBatch();`
- **Usage**: Ideal for inserting/updating large datasets (e.g., 100 employee records).

## Batch Inserts/Updates for Performance
- **Problem**: Individual `executeUpdate()` calls incur network overhead for each statement.
- **Solution**: Batch processing groups statements, reducing round-trips to the database.
- **Performance Gains**:
  - Fewer network calls.
  - Database optimizes execution of batched statements.
- **Example**:
  ```java
  pstmt.setString(1, "John"); pstmt.addBatch();
  pstmt.setString(1, "Jane"); pstmt.addBatch();
  int[] results = pstmt.executeBatch();
  ```

## Best Practices
- Use `PreparedStatement` for batch operations to leverage parameterization.
- Disable auto-commit (`setAutoCommit(false)`) for batch transactions.
- Commit after successful batch execution; rollback on failure.
- Validate input data before adding to batch.
- Check batch results to detect partial failures.

## Common Pitfalls
- Not disabling auto-commit, causing partial commits.
- Adding too many statements to a batch, exceeding database limits.
- Not handling batch failures (e.g., checking `executeBatch()` results).
- Ignoring input validation, causing batch errors.
- Not closing `PreparedStatement`, leading to resource leaks.

## Practice Task
- **Task**: Insert 100 fake employee records into the `employee` table using batch processing.
- **Solution Approach**:
  - Use `PreparedStatement` with a parameterized `INSERT` query.
  - Generate fake data (e.g., names, jobs, salaries).
  - Add to batch with `addBatch()` and execute with `executeBatch()`.
  - Use transaction to commit or rollback.