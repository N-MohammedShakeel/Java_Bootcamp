# Metadata

## Overview
JDBC provides `DatabaseMetaData` and `ResultSetMetaData` interfaces to retrieve information about the database and query results, enabling dynamic and flexible applications.

- **Purpose**: Inspect database structure and query results for dynamic processing.
- **DSA Relevance**: Involves traversal of metadata collections (like lists or maps), data validation, and dynamic processing, aligning with DSA concepts.

## DatabaseMetaData
- **Purpose**: Provides information about the database (e.g., product name, version, schema).
- **Key Methods**:
  - `getDatabaseProductName()`: Returns database name (e.g., "PostgreSQL").
  - `getDatabaseProductVersion()`: Returns version (e.g., "15.3").
  - `getTables(null, schema, null, null)`: Lists tables in a schema.
  - `getColumns(null, schema, table, null)`: Lists columns for a table.
- **Usage**: Discover database structure, validate schema, or generate dynamic queries.
- **Example**:
  ```java
  DatabaseMetaData meta = con.getMetaData();
  System.out.println(meta.getDatabaseProductName());
  ```

## ResultSetMetaData
- **Purpose**: Provides information about a `ResultSet`’s columns (e.g., names, types).
- **Key Methods**:
  - `getColumnCount()`: Number of columns.
  - `getColumnName(int index)`: Column name (1-based).
  - `getColumnTypeName(int index)`: SQL data type (e.g., "VARCHAR").
  - `getColumnLabel(int index)`: Column alias if specified.
- **Usage**: Build dynamic result processing without hardcoding column names.
- **Example**:
  ```java
  ResultSetMetaData rsmd = rs.getMetaData();
  for (int i = 1; i <= rsmd.getColumnCount(); i++) {
      System.out.println(rsmd.getColumnName(i) + ": " + rsmd.getColumnTypeName(i));
  }
  ```

## Best Practices
- Use `DatabaseMetaData` to verify database compatibility or schema.
- Use `ResultSetMetaData` for dynamic column handling in generic applications.
- Cache metadata for performance in repeated queries.
- Handle `SQLException` for metadata retrieval failures.
- Use column labels for queries with aliases to avoid confusion.

## Common Pitfalls
- Assuming column names/types without checking metadata.
- Not handling large result sets from `getTables()` or `getColumns()`.
- Ignoring database-specific metadata quirks (e.g., PostgreSQL schema handling).
- Not closing metadata-related result sets, causing leaks.
- Hardcoding column names instead of using `ResultSetMetaData`.

## Practice Task
- **Task**: Print all column names and types of the `employee` table using `ResultSetMetaData`.
- **Solution Approach**:
  - Execute `SELECT * FROM employee` with `PreparedStatement`.
  - Get `ResultSetMetaData` with `rs.getMetaData()`.
  - Iterate over columns to print names and types.
  - Handle empty result sets and exceptions.