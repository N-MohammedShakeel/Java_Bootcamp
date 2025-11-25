# Metadata

## Overview

JDBC provides two key interfaces, **`DatabaseMetaData`** and **`ResultSetMetaData`**, to retrieve information about the database itself and the structure of query results. Accessing this **metadata** is crucial for building dynamic, flexible, and database-agnostic applications.

* **Purpose**: Inspect database structure (schema, tables, types) and query result structure (columns, names, types) for dynamic processing.
* **DSA Relevance**: Involves traversal of metadata collections (similar to iterating over lists or maps), data validation, and dynamic processing logic.

-----

## DatabaseMetaData

The **`DatabaseMetaData`** interface provides comprehensive information about the **capabilities, configuration, and structure** of the connected database system.

* **Purpose**: Obtain system-level information about the entire database server.
* **Acquisition**: Acquired from the `Connection` object: `DatabaseMetaData meta = con.getMetaData();`
* **Key Methods**:
  * `getDatabaseProductName()`: Returns the vendor name (e.g., "Oracle", "MySQL").
  * `getDatabaseProductVersion()`: Returns the specific version (e.g., "16.3").
  * `getTables(catalog, schemaPattern, tableNamePattern, types)`: Lists available tables matching patterns.
  * `getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)`: Lists detailed column information for a table.
* **Usage**: Used to discover database structure, validate schema existence, or check compatibility for specific SQL features.

-----

## ResultSetMetaData

The **`ResultSetMetaData`** interface provides detailed information about the columns contained within a specific **`ResultSet`** object. This is essential for writing generic functions that process query results without knowing the table structure in advance.

* **Purpose**: Obtain structure details (names, types, sizes) of the columns resulting from a query.
* **Acquisition**: Acquired from the `ResultSet` object: `ResultSetMetaData rsmd = rs.getMetaData();`
* **Key Methods**:
  * `getColumnCount()`: Returns the total number of columns in the result set.
  * `getColumnName(int index)`: Returns the column's original name in the database (1-based index).
  * `getColumnLabel(int index)`: Returns the column's alias or label as specified in the `SELECT` statement (preferred for display).
  * `getColumnTypeName(int index)`: Returns the database-specific data type (e.g., "VARCHAR", "INT4").
* **Example**:
  ```java
  ResultSetMetaData rsmd = rs.getMetaData();
  for (int i = 1; i <= rsmd.getColumnCount(); i++) {
      System.out.println(rsmd.getColumnLabel(i) + " is of type: " + rsmd.getColumnTypeName(i));
  }
  ```
* **Usage**: Critical for building generic data processors, reporting tools, or dynamically populating UI elements.

-----

## Best Practices and Pitfalls

| Category | Best Practice | Common Pitfall |
| :--- | :--- | :--- |
| **Genericity** | Use **`ResultSetMetaData`** to handle columns dynamically in generic data loaders. | Hardcoding column names and types, breaking code when the query changes. |
| **Retrieval** | Use **`getColumnLabel()`** for display/runtime lookup, as it respects SQL aliases (`AS name`). | Using `getColumnName()` when an alias was specified, leading to incorrect lookups. |
| **Performance** | Cache metadata (especially `DatabaseMetaData`) if accessed repeatedly, as retrieval can be slow. | Repeatedly calling metadata methods inside a loop (e.g., within `rs.next()`). |
| **Cleanup** | Ensure **`ResultSet`** objects returned by metadata queries (e.g., `getTables()`) are properly closed. | Not closing metadata-related result sets, causing resource leaks. |

-----

## Practice Task

* **Task**: Write a dynamic method to execute a query (`SELECT * FROM <table>`) and print the column structure of the results using `ResultSetMetaData`.
* **Solution Approach**:
  1.  Execute the generic query using a `PreparedStatement`.
  2.  Get `ResultSetMetaData` using `rs.getMetaData()`.
  3.  Iterate from `i = 1` to `rsmd.getColumnCount()`.
  4.  Print the column index, label (`getColumnLabel()`), and database type (`getColumnTypeName()`).