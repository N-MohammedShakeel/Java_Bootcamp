# ResultSet Handling

## Overview
The `ResultSet` interface represents the result of a database query, providing methods to navigate rows and access column data. It supports various navigation and concurrency modes, enabling flexible data processing.

- **Purpose**: Retrieve and manipulate query results efficiently.
- **DSA Relevance**: Involves iteration (like list traversal), cursor management, and data access (by index or name), aligning with DSA concepts.

## Navigating Rows
- **Key Methods**:
  - `next()`: Moves cursor to the next row (default for forward-only `ResultSet`).
  - `previous()`: Moves to the previous row (scrollable `ResultSet`).
  - `absolute(int row)`: Moves to a specific row (1-based).
  - `first()`, `last()`: Moves to the first or last row.
  - `relative(int rows)`: Moves relative to the current position.
- **Usage**: Iterate over rows to process data (e.g., print employee details).
- **Example**:
  ```java
  while (rs.next()) {
      System.out.println(rs.getString("ename"));
  }
  ```

## Accessing by Column Index vs Column Name
- **Index-Based**:
  - Methods: `getInt(int index)`, `getString(int index)`, etc.
  - Pros: Faster, no name lookup.
  - Cons: Fragile if column order changes in the query.
  - Example: `rs.getString(2)` for the second column.
- **Name-Based**:
  - Methods: `getInt(String name)`, `getString(String name)`, etc.
  - Pros: Readable, robust to column order changes.
  - Cons: Slightly slower due to lookup.
  - Example: `rs.getString("ename")`.
- **Recommendation**: Use column names for maintainability unless performance is critical.

## ResultSet Types & Concurrency Modes
- **Types**:
  - `TYPE_FORWARD_ONLY`: Default, supports only `next()`.
  - `TYPE_SCROLL_INSENSITIVE`: Supports forward/backward navigation, insensitive to database changes.
  - `TYPE_SCROLL_SENSITIVE`: Supports navigation, reflects database changes (rarely used).
- **Concurrency Modes**:
  - `CONCUR_READ_ONLY`: Default, read-only access.
  - `CONCUR_UPDATABLE`: Allows updating rows via `updateXxx()` methods.
- **Creation**:
  - `Statement stmt = con.createStatement(type, concurrency);`
  - Example: `con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)`.
- **Usage**: Specify type for navigation needs (e.g., scrollable for reverse iteration).

## Best Practices
- Use column names for readability and robustness.
- Specify appropriate `ResultSet` type for navigation requirements.
- Use `try-with-resources` to close `ResultSet`.
- Check `next()` return value to avoid `SQLException`.
- Use `wasNull()` for nullable columns to avoid misinterpretation.
- Validate `ResultSet` state (e.g., `isBeforeFirst()`) for empty results.

## Common Pitfalls
- Using forward-only `ResultSet` for backward navigation, causing `SQLException`.
- Accessing columns with incorrect indices or names.
- Not closing `ResultSet`, leading to resource leaks.
- Ignoring `wasNull()` for nullable columns, causing incorrect data handling.
- Not checking for empty result sets, leading to errors.

## Practice Task
- **Task**: Retrieve all employees and print them in reverse order using a scrollable `ResultSet`.
- **Solution Approach**:
  - Create a `Statement` with `TYPE_SCROLL_INSENSITIVE` and `CONCUR_READ_ONLY`.
  - Execute `SELECT * FROM employee`.
  - Move to the last row with `last()`, then iterate backward with `previous()`.
  - Handle empty results with `isBeforeFirst()`.