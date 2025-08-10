# PreparedStatement Interface

## Overview
The `PreparedStatement` interface extends `Statement` to execute parameterized SQL queries, offering improved security and performance. It is the preferred choice for queries with dynamic inputs, preventing SQL injection and enabling query plan reuse.

- **Purpose**: Execute parameterized queries safely and efficiently.
- **DSA Relevance**: Involves string manipulation (SQL templates), parameter binding (similar to data structures), and iteration over results, aligning with DSA concepts.

## Parameterized Queries
- **Definition**: SQL queries with placeholders (`?`) for dynamic values.
- **Example**: `INSERT INTO employee (ename, job, salary) VALUES (?, ?, ?)`
- **Benefits**:
  - **Security**: Prevents SQL injection by separating SQL code from data.
  - **Performance**: Database caches the query plan, reducing compilation overhead.
  - **Readability**: Clear distinction between query structure and values.
- **Creation**: `PreparedStatement pstmt = con.prepareStatement(sql);`

## Setting Parameters with setXxx() Methods
- **Purpose**: Bind values to placeholders in the query.
- **Key Methods**:
  - `setString(int index, String value)`: Binds a string (e.g., `setString(1, "John Doe")`).
  - `setInt(int index, int value)`: Binds an integer.
  - `setDouble(int index, double value)`: Binds a double.
  - `setNull(int index, int sqlType)`: Sets a null value (e.g., `Types.VARCHAR`).
- **Indexing**: 1-based, corresponding to the order of `?` placeholders.
- **Example**:
  ```java
  PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee (ename, job) VALUES (?, ?)");
  pstmt.setString(1, "Jane Doe");
  pstmt.setString(2, "Analyst");
  ```

## Preventing SQL Injection
- **Problem**: `Statement` concatenates user input, allowing malicious SQL (e.g., `name = "'; DROP TABLE employee; --"`).
- **Solution**: `PreparedStatement` treats input as data, escaping special characters.
- **Example**:
  - Vulnerable: `stmt.executeQuery("SELECT * FROM employee WHERE ename = '" + input + "'")`.
  - Secure: `pstmt.setString(1, input); pstmt.executeQuery();`.

## Best Practices
- Always use `PreparedStatement` for queries with user inputs.
- Validate input data before binding (e.g., check for null or invalid formats).
- Use `try-with-resources` to close `PreparedStatement`.
- Reuse `PreparedStatement` objects for repeated queries to leverage caching.
- Specify column types for `setNull()` to avoid ambiguity.

## Common Pitfalls
- Using `Statement` for dynamic queries, risking SQL injection.
- Incorrect parameter indexing (1-based, not 0-based).
- Not closing `PreparedStatement`, causing resource leaks.
- Hardcoding values instead of using parameters.
- Not validating inputs, leading to database errors.

## Practice Task
- **Task**: Insert a new employee into the `employee` table using `PreparedStatement` with variable inputs.
- **Solution Approach**:
  - Create a parameterized `INSERT` query.
  - Use `setString` and `setDouble` to bind values from variables.
  - Execute with `executeUpdate()` and verify rows affected.
  - Handle `SQLException` for errors (e.g., duplicate keys, null constraints).