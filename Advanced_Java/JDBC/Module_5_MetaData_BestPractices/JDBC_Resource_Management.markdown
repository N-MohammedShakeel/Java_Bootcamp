# Resource Management

## Overview
Proper resource management in JDBC ensures that database resources (`Connection`, `Statement`, `ResultSet`) are closed to prevent memory leaks and connection exhaustion. The `try-with-resources` construct simplifies this process.

- **Purpose**: Safely manage JDBC resources to maintain application performance and reliability.
- **DSA Relevance**: Involves resource allocation/deallocation (like memory management) and exception handling, aligning with DSA concepts.

## Closing ResultSet, Statement, Connection
- **Resources**:
  - **Connection**: Represents a database session.
  - **Statement**/`PreparedStatement`/`CallableStatement`: Executes queries.
  - **ResultSet**: Holds query results.
- **Closing**:
  - Call `close()` on each resource in the reverse order of creation.
  - Example: `rs.close(); stmt.close(); con.close();`.
- **Problem**: Manual closing is error-prone, especially in exception scenarios.

## Using try-with-resources
- **Purpose**: Automatically closes resources when exiting a `try` block, even on exceptions.
- **Syntax**:
  ```java
  try (Connection con = DriverManager.getConnection(url);
       PreparedStatement pstmt = con.prepareStatement(sql);
       ResultSet rs = pstmt.executeQuery()) {
      // Use resources
  }
  ```
- **Benefits**:
  - Ensures `close()` is called automatically.
  - Simplifies code by eliminating `finally` blocks.
  - Handles exceptions gracefully.

## Best Practices
- Always use `try-with-resources` for JDBC resources.
- Close resources in the correct order (ResultSet, Statement, Connection).
- Handle `SQLException` to log errors without disrupting resource closure.
- Avoid reusing closed resources, which causes `SQLException`.
- Monitor connection pool usage in production environments.

## Common Pitfalls
- Manual resource closing without `try-with-resources`, risking leaks.
- Closing resources in the wrong order, causing errors.
- Ignoring exceptions during resource closure.
- Reusing closed `ResultSet` or `Statement`, leading to `SQLException`.
- Not handling connection limits, causing database overload.

## Practice Task
- **Task**: Modify a connection program to use `try-with-resources` for all JDBC objects.
- **Solution Approach**:
  - Use `PreparedStatement` to query the `employee` table.
  - Wrap `Connection`, `PreparedStatement`, and `ResultSet` in `try-with-resources`.
  - Handle empty results and exceptions.