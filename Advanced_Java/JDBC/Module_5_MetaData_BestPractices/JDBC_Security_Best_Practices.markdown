# Security & Best Practices

## Why Always Use PreparedStatement for Inputs

Using the **`PreparedStatement`** interface is the single most important security measure in JDBC.

* **Problem (SQL Injection)**: The base `Statement` interface concatenates user input directly into the SQL string. This allows an attacker to inject malicious SQL commands (e.g., `'; DROP TABLE <table>; --`), leading to SQL injection.
* **Solution**: **`PreparedStatement`** treats user input as **data**, not executable SQL code, by using **placeholders** (`?`). The database driver handles the necessary escaping and validation.
* **Rule**: Always use **`PreparedStatement`** for any query involving user input or dynamic data.
* **Benefits**:
  * **Security**: Prevents **SQL injection**.
  * **Performance**: Enables database **query plan caching**.

---

## Securely Storing Credentials

**Never** hardcode sensitive credentials (username, password) directly into your Java source code.

* **Problem**: Hardcoding credentials exposes sensitive data in source code repositories or compiled binaries.
* **Preferred Solutions**:
  1.  **Properties File**: Store configuration in an external file (`db.properties`). Load it using the `Properties` class.
    * **Best Practice**: Exclude the file from version control (`.gitignore`) and secure its location outside the application's deployment.
  2.  **Environment Variables**: Inject credentials during application runtime using the operating system's environment variables (`System.getenv()`).
  3.  **Vault Solutions**: Use dedicated, enterprise-grade tools (e.g., HashiCorp Vault) for secure secret management.

---

## Input Validation

Validation should be performed in the Java application layer *before* the database is involved.

* **Purpose**: Validate inputs to ensure they are **semantically correct** and adhere to **database constraints** before binding them to the `PreparedStatement`.
* **Examples**:
  * Check for null or empty strings: `if (value == null || value.trim().isEmpty())`.
  * Validate numeric ranges: `if (value < 0) throw new IllegalArgumentException("Cannot be negative");`.
* **Benefits**: Prevents database constraint violations, reduces unnecessary SQL execution, and enhances application reliability.

---

## Data Access Object (DAO) Pattern

The **DAO pattern** is a structural design pattern used to encapsulate and abstract all database interaction logic.

* **Definition**: The DAO layer acts as an intermediary, separating **business logic** (what the application does) from **persistence logic** (how data is stored and retrieved).
* **Components**:
  1.  **Entity Class**: The model representing a table row (e.g., `Record`).
  2.  **DAO Interface**: Defines abstract CRUD methods (e.g., `addRecord`, `getRecordById`).
  3.  **DAO Implementation**: Contains the concrete JDBC code (`Connection`, `PreparedStatement`, `try-with-resources`).
* **Benefits**: Promotes **modularity**, simplifies **testing** (using mock DAOs), and enables easier switching of **database vendors**.

---

## General Best Practices Summary

| Category | Best Practice | Common Pitfall |
| :--- | :--- | :--- |
| **Security** | Use **`PreparedStatement`** for all dynamic queries. | Using **`Statement`** with concatenated input, enabling SQL injection. |
| **Credentials** | Store configuration in **external properties** or environment variables. | Hardcoding credentials in source code. |
| **Validation** | Validate all inputs before database operations. | Skipping input validation, leading to database errors or vulnerabilities. |
| **Resource Mgmt.** | Use **`try-with-resources`** for `Connection`, `PreparedStatement`, and `ResultSet`. | Not closing resources, causing connection/memory leaks. |
| **Design** | Implement the **DAO Pattern** for modularity in complex systems. | Mixing business logic and raw JDBC code in the same class. |

---

## Practice Task
* **Task**: Implement a DAO for a generic table with methods to add and retrieve records.
* **Solution Approach**:
  1.  Create an **`Entity`** class (e.g., `Record`).
  2.  Define a **`RecordDAO`** interface.
  3.  Implement the DAO using **`PreparedStatement`** and credentials loaded from an external source.
  4.  Implement **input validation** and handle all potential exceptions.