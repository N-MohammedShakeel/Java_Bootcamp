# Statement Interface

## Overview

The **`Statement`** interface in JDBC is the fundamental object used to execute static, **non-parameterized SQL queries**. It is suitable for simple, known commands but poses a significant security risk when used with dynamic, user-provided inputs.

* **Purpose**: Execute static SQL queries and retrieve results or update counts.
* **Limitation**: Lacks security features for dynamic inputs (vulnerable to **SQL Injection**).
* **DSA Relevance**: Involves string manipulation (SQL query construction), iteration (result set processing), and error handling.

-----

## Statement Interface Methods

The `Statement` object provides methods to execute SQL queries and handle the different types of results returned by the database.

* **`executeQuery(String sql)`**:
  * Executes a **Data Query Language (DQL)** command (`SELECT` queries).
  * **Returns**: A **`ResultSet`** object containing the query results.
* **`executeUpdate(String sql)`**:
  * Executes **Data Manipulation Language (DML)** commands (`INSERT`, `UPDATE`, `DELETE`) and **Data Definition Language (DDL)** commands (`CREATE`, `DROP`).
  * **Returns**: An `int` representing the number of rows affected (or 0 for most DDL commands).
* **`execute(String sql)`**:
  * Executes any SQL command when the return type is unknown.
  * **Returns**: A `boolean` (`true` if a `ResultSet` was returned, `false` otherwise).
* **Creation**: `Statement stmt = con.createStatement();`

-----

## executeQuery() for SELECT Operations

This method is used exclusively for retrieving data.

* **Purpose**: Execute a `SELECT` query and return data in a traversable format.
* **Usage**: Retrieve records from a `<table>`.
* **Processing the ResultSet**:
  ```java
  // Assuming 'rs' is the ResultSet from executeQuery()
  while (rs.next()) { // Advances cursor to the next row (returns false if no more rows)
      // Retrieve data by column name or 1-based index
      int id = rs.getInt("<id_column>");
      String value = rs.getString("<text_column>");
      // ... process data
  }
  ```
* **Note**: Always use **`rs.next()`** to iterate over the rows. Check **`rs.isBeforeFirst()`** (after `executeQuery()` but before the first `rs.next()`) to handle empty results gracefully.

-----

## executeUpdate() for DML and DDL

This method is used for commands that change the structure or content of the database.

* **Purpose**: Execute DML statements (`INSERT`, `UPDATE`, `DELETE`), returning the number of affected rows.
* **Usage**: Modify table data (e.g., insert new records, update values, delete old data).
* **Example (DML)**:
  ```java
  // INSERT operation (using hardcoded, static values)
  int rows = stmt.executeUpdate("INSERT INTO <table> (<column1>, <column2>) VALUES ('Static Value', 123)");
  System.out.println("Operation affected " + rows + " row(s).");
  ```
* **Note**: This method is also used for **DDL** statements (e.g., `CREATE TABLE`), typically returning 0 rows affected.

-----
## Best Practices and Pitfalls Table

| Category | Best Practice | Common Pitfall |
| :--- | :--- | :--- |
| **Security** | **Prefer `PreparedStatement`** for all dynamic queries. | Using **`Statement`** for user inputs, leading to **SQL Injection**.  |
| **Resource Mgmt.**| Use **`try-with-resources`** to automatically close `Connection`, `Statement`, and `ResultSet`. | Not closing resources, causing database **resource leaks** and connection exhaustion. |
| **Maintainability**| Use `Statement` only for **static, hardcoded DDL/DML** commands. | Hardcoding complex or dynamic queries, reducing readability and maintainability. |
| **Error Handling**| Log affected rows from `executeUpdate()` to verify success. Check `ResultSet.isBeforeFirst()` for empty results. | Ignoring return values of `executeUpdate()`. Not handling empty result sets. |
-----

## Practice Task

* **Task**: Implement a simple CRUD cycle using the `Statement` interface.
* **Solution Approach**:
  1.  Define a static SQL string for a `CREATE TABLE` command using generic columns (`<id_column> <ID_TYPE> PRIMARY KEY`, `<text_column>`, etc.).
  2.  Use `executeUpdate()` for the `CREATE TABLE` command.
  3.  Use `executeUpdate()` for two or three hardcoded `INSERT` statements.
  4.  Use `executeQuery()` to retrieve all rows (`SELECT * FROM <table>`).
  5.  Iterate and print the data using `rs.next()` and appropriate `rs.get...()` methods.