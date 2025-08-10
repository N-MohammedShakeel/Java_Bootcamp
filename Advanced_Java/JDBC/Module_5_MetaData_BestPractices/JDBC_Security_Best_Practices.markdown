# Security & Best Practices (Continued)

## Why Always Use PreparedStatement for Inputs
- **Problem**: Using `Statement` for queries with user input can lead to SQL injection attacks. For example:
  ```java
  String input = "'; DROP TABLE employee; --";
  stmt.execute("SELECT * FROM employee WHERE ename = '" + input + "'");
  ```
  This results in a malicious query that deletes the `employee` table.
- **Solution**: `PreparedStatement` treats user input as data, not executable SQL, by using placeholders (`?`).
  ```java
  PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee WHERE ename = ?");
  pstmt.setString(1, input);
  ```
- **Benefits**:
  - Prevents SQL injection by escaping special characters.
  - Improves performance through query plan caching.
  - Enhances code readability with parameterized queries.
- **Rule**: Always use `PreparedStatement` for queries involving user input or dynamic data.

## Securely Storing Credentials
- **Problem**: Hardcoding credentials in source code (e.g., `DriverManager.getConnection(url, "postgres", "password")`) exposes sensitive information in version control or compiled binaries.
- **Solutions**:
  - **Properties File**: Store credentials in a `db.properties` file outside the codebase.
    ```properties
    db.url=jdbc:postgresql://localhost:5432/company
    db.user=postgres
    db.password=MSpostgres17
    ```
    Load using `Properties` and `FileInputStream`.
  - **Environment Variables**: Store credentials as environment variables (e.g., `System.getenv("DB_PASSWORD")`).
  - **Vault Solutions**: Use tools like HashiCorp Vault for enterprise-grade credential management.
- **Best Practice**:
  - Keep `db.properties` outside the project directory or restrict access (e.g., file permissions).
  - Exclude properties files from version control (e.g., add to `.gitignore`).
  - Use encryption for sensitive data in production.

## Input Validation
- **Purpose**: Validate user inputs before binding to `PreparedStatement` to prevent invalid data or errors.
- **Examples**:
  - Check for null or empty strings: `if (name == null || name.trim().isEmpty())`.
  - Validate numeric ranges: `if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative");`.
  - Sanitize inputs to match database constraints (e.g., string length, format).
- **Benefits**:
  - Prevents database errors (e.g., constraint violations).
  - Enhances application reliability.
  - Reduces unnecessary database calls.

## DAO Pattern
- **Definition**: The Data Access Object (DAO) pattern encapsulates database operations in a separate layer, promoting modularity and maintainability.
- **Components**:
  - **DAO Interface**: Defines methods for CRUD operations (e.g., `addEmployee`, `getEmployeeById`).
  - **DAO Implementation**: Contains JDBC code to interact with the database.
  - **Entity Class**: Represents a table row (e.g., `Employee` with `id`, `name`, `job`, `salary`).
- **Benefits**:
  - Separates business logic from database logic.
  - Simplifies testing with mock DAOs.
  - Enables switching databases with minimal code changes.
- **Example**:
  ```java
  public interface EmployeeDAO {
      void addEmployee(Employee emp);
      Employee getEmployeeById(int id);
  }
  ```

## Best Practices
- Always use `PreparedStatement` for dynamic queries.
- Store credentials securely in a properties file or environment variables.
- Validate all inputs before database operations.
- Implement the DAO pattern for large applications to improve modularity.
- Use `try-with-resources` for resource management.
- Log detailed `SQLException` information for debugging.
- Avoid concatenating user input in SQL queries, even for non-malicious cases.
- Regularly update JDBC drivers to address security vulnerabilities.

## Common Pitfalls
- Hardcoding credentials in source code, risking exposure.
- Using `Statement` for user inputs, enabling SQL injection.
- Skipping input validation, leading to database errors or vulnerabilities.
- Not using DAO pattern in complex applications, causing maintenance issues.
- Ignoring `SQLException` details, complicating error diagnosis.
- Not securing properties files, exposing credentials.

## Practice Task
- **Task**: Implement a DAO for the `employee` table with methods to add and retrieve employees.
- **Solution Approach**:
  - Create an `Employee` class with fields (`id`, `name`, `job`, `salary`).
  - Define an `EmployeeDAO` interface with `addEmployee` and `getEmployeeById`.
  - Implement the DAO using `PreparedStatement` and credentials from `db.properties`.
  - Validate inputs and handle exceptions.
  - Test the DAO by adding and retrieving an employee.