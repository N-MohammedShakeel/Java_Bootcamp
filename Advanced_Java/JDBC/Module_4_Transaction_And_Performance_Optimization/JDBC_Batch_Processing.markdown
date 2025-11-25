# Batch Processing

## Overview
**Batch processing** in JDBC allows executing multiple SQL Data Manipulation Language (DML) statements (like `INSERT` or `UPDATE`) as a single unit, significantly improving performance for bulk operations. This technique minimizes **network overhead** by grouping commands into one single database call (round-trip).

* **Purpose**: Efficiently execute a large volume of DML statements.
* **Core Benefit**: Reduces network latency and allows the database server to optimize bulk operations.
* **DSA Relevance**: Involves bulk data processing (similar to efficient array/list operations), loop optimization, and transaction management for **atomicity**.

---

## addBatch() and executeBatch()

These two methods on the `PreparedStatement` interface are central to batch processing.

* **`addBatch()`**:
  * **Action**: Queues the currently prepared SQL command and its bound parameters into a batch container.
  * **Usage**: Used with a **`PreparedStatement`** after all parameters for a single command have been set.
  * **Example**: `pstmt.setXxx(1, "Data"); pstmt.addBatch();`
* **`executeBatch()`**:
  * **Action**: Sends all queued commands to the database for execution as a single block.
  * **Returns**: An array of integers (`int[]`), where each element represents the number of rows affected by the corresponding command in the batch queue.
  * **Example**: `int[] results = pstmt.executeBatch();`
* **Usage**: Ideal for inserting or updating large datasets (e.g., 100 records into a `<table>`).

---

## Performance Optimization

Batch processing is a crucial performance optimization technique in JDBC.

* **Problem**: Executing many individual `executeUpdate()` calls requires a separate **network round-trip** (request and response) for *each* statement, incurring high latency.
* **Solution**: Batch processing groups the statements, leading to only **one network call** for potentially hundreds or thousands of DML commands.
* **Performance Gains**:
  1.  **Reduced Network Overhead**: Fewer total request/response cycles.
  2.  **Database Optimization**: The database server can process the entire batch more efficiently than individual commands (e.g., locking resources once).

---

## Transactional Best Practices

To ensure data integrity, batch execution should always be wrapped in a manual transaction.

* **Disable Auto-Commit**:
  * **Action**: `con.setAutoCommit(false);`
  * **Why**: This prevents each individual command in the batch from committing immediately. If one command fails, the entire batch can be rolled back.
* **Commit/Rollback Handling**:
  * **Success**: Call `con.commit();` after a successful `executeBatch()`.
  * **Failure**: Call `con.rollback();` inside the `catch` block if a `SQLException` occurs during batch execution, ensuring the entire operation is atomic.
* **Result Inspection**: Always iterate through the `int[]` returned by `executeBatch()` to verify that all commands succeeded and to count the total rows affected.

---

## Common Pitfalls
* **Ignoring Auto-Commit**: Not disabling auto-commit, causing records to be partially committed before a failure, compromising **atomicity**.
* **Unclosed Resources**: Not closing the `PreparedStatement`, leading to resource leaks.
* **Batch Size**: Adding an excessively high number of statements (e.g., tens of thousands) to a single batch, which can exceed the memory or configuration limits of the JDBC driver or database server.
* **Validation**: Ignoring input validation *before* adding the command to the batch, leading to a batch failure later on.

---

## Practice Task
* **Task**: Insert a large number of fake records into a generic `<table>` using performance-optimized batch processing.
* **Solution Approach**:
  1.  Use **`PreparedStatement`** with a parameterized `INSERT` query.
  2.  Disable auto-commit using `con.setAutoCommit(false)`.
  3.  Loop through the data, setting parameters and calling **`pstmt.addBatch()`** for each command.
  4.  Execute the batch with **`pstmt.executeBatch()`**.
  5.  Wrap the batch process in a `try-catch` block to ensure `con.commit()` on success and `con.rollback()` on failure.