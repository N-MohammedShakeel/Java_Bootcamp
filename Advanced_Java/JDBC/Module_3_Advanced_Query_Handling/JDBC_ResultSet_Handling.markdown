# ResultSet Handling

## Overview

The **`ResultSet`** interface represents the tabular result of a executed database query (`SELECT`), providing a means to navigate through the rows and access the column data. It supports various navigation and concurrency modes, enabling flexible data processing.

* **Purpose**: Retrieve and manipulate query results efficiently.
* **Core Function**: Acts as a cursor pointing to the current row of data retrieved from the database.
* **DSA Relevance**: Involves iteration (like list traversal), cursor management, and data access (by index or name).

-----

## Navigating Rows

The primary function of the `ResultSet` is to move the cursor to access different rows of the retrieved data.

* **Sequential Movement (Default)**:
  * `next()`: Moves cursor to the next row. Returns `false` if no more rows exist. (Default and required for `TYPE_FORWARD_ONLY`).
* **Scrollable Movement (Advanced)**:
  * `previous()`: Moves to the previous row (requires a scrollable `ResultSet` type).
  * `first()`, `last()`: Moves the cursor directly to the first or last row.
  * `absolute(int row)`: Moves to a specific 1-based row number.
  * `relative(int rows)`: Moves the cursor relative to the current position (e.g., `relative(-2)` moves back two rows).
* **Example of Forward Iteration**:
  ```java
  while (rs.next()) {
      // Process the current row data
  }
  ```

-----

## Accessing Column Data: Index vs. Name

Data from the current row is retrieved using type-specific getter methods (`getInt`, `getString`, `getDouble`, etc.).

### Index-Based Access

* **Methods**: `getXxx(int index)` (e.g., `rs.getString(2)` for the second column).
* **Pros**: **Faster** performance as it avoids an internal name lookup.
* **Cons**: **Fragile** if the column order in the SQL `SELECT` query ever changes.
* **Indexing**: **1-based** (The first column is index 1).

### Name-Based Access

* **Methods**: `getXxx(String name)` (e.g., `rs.getString("<column_name>")`).
* **Pros**: **Highly Readable** and **Robust** to changes in column order in the `SELECT` query.
* **Cons**: Marginally slower due to the column name lookup.
* **Recommendation**: Use column names for general application development due to superior maintainability and robustness.

-----

## ResultSet Types & Concurrency Modes

To enable advanced navigation or updates, the `Statement` object must be created with specific type and concurrency parameters.

### ResultSet Types (Navigation Capability)

| Type Constant | Description | Navigation Support |
| :--- | :--- | :--- |
| **`TYPE_FORWARD_ONLY`** | **Default**. Supports `next()` only. Fastest and least resource-intensive. | Forward only |
| **`TYPE_SCROLL_INSENSITIVE`** | Supports backward and forward movement. **Insensitive** to changes made by others while the `ResultSet` is open. | Scrollable |
| **`TYPE_SCROLL_SENSITIVE`** | Supports backward and forward movement. **Reflects** changes made to the database while the `ResultSet` is open (database-dependent and rarely used). | Scrollable |

### Concurrency Modes (Update Capability)

| Concurrency Constant | Description | Database Interaction |
| :--- | :--- | :--- |
| **`CONCUR_READ_ONLY`** | **Default**. Data can only be read. | Cannot update rows via Java |
| **`CONCUR_UPDATABLE`** | Allows updating the underlying table data using `updateXxx()` and `updateRow()` methods on the `ResultSet` itself. | Can update rows via Java |

### Creation Example

```java
// Creates a Statement that supports full scrolling but prevents updates via the ResultSet
Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
```

-----

## Best Practices

* **Robust Access**: Use column **names** for retrieving data to ensure stability.
* **Resource Cleanup**: Always use **`try-with-resources`** to guarantee the `ResultSet` (and the `Statement` and `Connection`) is closed, preventing **resource leaks**.
* **Null Handling**: For nullable database columns, check the value immediately after retrieval using **`rs.wasNull()`** to distinguish between a `NULL` value and a default/zero value (e.g., distinguishing between a null salary and a zero salary).
* **Empty Check**: Validate the `ResultSet` state using **`rs.isBeforeFirst()`** after execution to handle cases where the query returns zero rows.
* **Matching Types**: Ensure the `rs.get...()` method matches the SQL column type to avoid data conversion errors.

-----

## Common Pitfalls

* **Misusing Cursor**: Attempting to call `previous()` or `absolute()` on a default (`TYPE_FORWARD_ONLY`) `ResultSet`, which results in a **`SQLException`**.
* **Index Errors**: Accessing columns using incorrect 1-based indices, which is a common source of runtime errors after simple query modifications.
* **Resource Leaks**: Neglecting to close the `ResultSet` object, which ties up database server cursors.
* **Ignoring Nulls**: Retrieving a numeric column that is `NULL` in the database, where Java might return 0, leading to incorrect business logic if `wasNull()` is not checked.

-----

## Practice Task

* **Task**: Retrieve all records from a generic `<table>` and print them in reverse order, demonstrating scrollable navigation.
* **Solution Approach**:
  1.  Create a `Statement` with **`TYPE_SCROLL_INSENSITIVE`** and **`CONCUR_READ_ONLY`**.
  2.  Execute `SELECT * FROM <table>`.
  3.  Check for empty results using `isBeforeFirst()`.
  4.  Move the cursor to the last row with **`rs.last()`**.
  5.  Iterate backward using a `do-while` loop with **`rs.previous()`** in the condition.