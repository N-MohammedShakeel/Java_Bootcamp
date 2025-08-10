# CallableStatement Interface

## Overview
The `CallableStatement` interface extends `PreparedStatement` to execute stored procedures and functions in a database. It is designed for invoking complex database logic defined in SQL, supporting input, output, and bidirectional parameters.

- **Purpose**: Call database stored procedures/functions, retrieving results or modifying data.
- **DSA Relevance**: Involves parameter binding (like data structures for input/output), string manipulation (SQL call syntax), and error handling, aligning with DSA concepts.

## Calling Stored Procedures and Functions in PostgreSQL
- **Stored Procedure/Function**: Precompiled SQL routines stored in the database, encapsulating business logic.
- **Stored Procedure**:
  - Executes a sequence of SQL statements (e.g., update multiple tables).
  - Syntax: `CALL procedure_name(?, ?, ?);`
- **Function**:
  - Returns a value or table, often used for computations.
  - Syntax: `{ ? = call function_name(?, ?) }` for scalar results.
- **Usage**:
  - Execute complex operations (e.g., calculate employee bonuses).
  - Retrieve computed values (e.g., employee salary by ID).

## IN, OUT, and INOUT Parameters
- **IN Parameters**:
  - Input values passed to the procedure/function.
  - Set using `setXxx(index, value)` (e.g., `setInt(1, 123)`).
- **OUT Parameters**:
  - Output values returned by the procedure/function.
  - Register with `registerOutParameter(index, sqlType)` (e.g., `Types.DOUBLE`).
  - Retrieve with `getXxx(index)` (e.g., `getDouble(1)`).
- **INOUT Parameters**:
  - Serve as both input and output.
  - Set input with `setXxx()` and register output with `registerOutParameter()`.
- **Example**:
  ```java
  CallableStatement cstmt = con.prepareCall("{ ? = call get_employee_salary(?) }");
  cstmt.registerOutParameter(1, Types.DOUBLE);
  cstmt.setInt(2, 1);
  cstmt.execute();
  double salary = cstmt.getDouble(1);
  ```

## Best Practices
- Use `CallableStatement` for all stored procedure/function calls.
- Register OUT parameters before execution.
- Validate input parameters to prevent errors.
- Use `try-with-resources` to close `CallableStatement`.
- Test procedures/functions in `psql` before Java integration.
- Handle `SQLException` with detailed logging.

## Common Pitfalls
- Incorrect parameter indexing or types, causing runtime errors.
- Forgetting to register OUT parameters, leading to `SQLException`.
- Hardcoding procedure/function names or parameters.
- Not handling null results from functions.
- Not closing `CallableStatement`, causing resource leaks.

## Practice Task
- **Task**: Create a PostgreSQL function to return an employee’s salary by ID and call it using `CallableStatement`.
- **Solution Approach**:
  - Create function in PostgreSQL: `get_employee_salary(emp_id INTEGER) RETURNS DOUBLE PRECISION`.
  - Use `CallableStatement` with `{ ? = call get_employee_salary(?) }`.
  - Register OUT parameter and set IN parameter.
  - Execute and retrieve the salary.