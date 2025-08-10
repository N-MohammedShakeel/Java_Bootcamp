# Statement Interface

## Overview
The `Statement` interface in JDBC is used to execute static SQL queries, including `SELECT`, `INSERT`, `UPDATE`, and `DELETE`. It is suitable for simple, non-parameterized queries but lacks security for dynamic inputs.

- **Purpose**: Execute static SQL queries and retrieve results or update counts.
- **DSA Relevance**: Involves string manipulation (SQL query construction), iteration (result set processing), and error handling, aligning with DSA concepts like strings and lists.

## Statement Interface
- **Purpose**: Provides methods to execute SQL queries and return results.
- **Key Methods**:
  - `executeQuery(String sql)`: Executes a `SELECT` query, returning a `ResultSet`.
  - `executeUpdate(String sql)`: Executes `INSERT`, `UPDATE`, or `DELETE`, returning the number of affected rows.
  - `execute(String sql)`: Executes any SQL, returning `true` for result sets, `false` for updates.
- **Creation**: `Statement stmt = con.createStatement();`
- **Example**:
  ```java
  Statement stmt = con.createStatement();
  ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
  ```

## executeQuery() for SELECT
- **Purpose**: Executes a `SELECT` query and returns a `ResultSet`.
- **Usage**: Retrieve data from tables.
- **Example**:
  ```java
  ResultSet rs = stmt.executeQuery("SELECT emp_id, ename FROM employee");
  while (rs.next()) {
      System.out.println(rs.getInt("emp_id") + ": " + rs.getString("ename"));
  }
  ```
- **Note**: Use `next()` to iterate, check `isBeforeFirst()` for empty results.

## executeUpdate() for INSERT/UPDATE/DELETE
- **Purpose**: Executes DML (Data Manipulation Language) statements, returning the number of affected rows.
- **Usage**: Modify table data (e.g., insert new employees, update salaries).
- **Example**:
  ```java
  int rows = stmt.executeUpdate("INSERT INTO employee (ename, job) VALUES ('John Doe', 'Developer')");
  System.out.println("Inserted " + rows + " row(s).");
  ```
- **Note**: Also used for DDL (e.g., `CREATE TABLE`), returning 0.

## Best Practices
- Use `Statement` only for static, hardcoded queries.
- Prefer `PreparedStatement` for dynamic queries to prevent SQL injection.
- Use `try-with-resources` to close `Statement` and `ResultSet`.
- Check `ResultSet.isBeforeFirst()` to handle empty results.
- Log affected rows for `executeUpdate()` to verify success.

## Common Pitfalls
- Using `Statement` for user inputs, risking SQL injection.
- Not closing `Statement` or `ResultSet`, causing resource leaks.
- Ignoring return values of `executeUpdate()`.
- Hardcoding SQL queries, reducing maintainability.
- Not handling empty result sets, leading to `SQLException`.

## Practice Task
- **Task**: Create an `employee` table, insert 3 records using `Statement`, and retrieve all rows.
- **Solution Approach**:
  - Create table with `SERIAL` primary key, `VARCHAR`, and `DOUBLE PRECISION` columns.
  - Use `executeUpdate()` for `CREATE TABLE` and `INSERT` statements.
  - Use `executeQuery()` to retrieve and print all rows.
  - Handle empty results and SQL exceptions.