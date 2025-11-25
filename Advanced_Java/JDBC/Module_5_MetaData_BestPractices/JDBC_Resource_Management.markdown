# Resource Management

## Overview

Proper **resource management** in JDBC is critical for application reliability. It ensures that finite database resources, specifically the **`Connection`**, **`Statement`**, and **`ResultSet`** objects, are released immediately after use to prevent application memory leaks and database connection exhaustion.

* **Purpose**: Safely manage JDBC resources to maintain application performance and reliability.
* **Core Principle**: Guarantee the **deallocation** of resources regardless of normal execution or exception failure.
* **DSA Relevance**: Involves resource allocation/deallocation (like memory management) and guaranteed exception handling.

-----

## The Need for Guaranteed Closure

JDBC resources consume both client-side memory and server-side assets (like database sessions and cursors). Failure to close them causes **resource leaks**.

* **Resources to Close**:
  * **`ResultSet`**: Holds query results; must be closed first.
  * **`Statement`** (`Statement`/`PreparedStatement`/`CallableStatement`): Executes queries.
  * **`Connection`**: Represents the database session; must be closed last.
* **Traditional Problem (Manual Closing)**: Manual closing requires wrapping every operation in a `try-catch-finally` block, which is verbose and prone to errors, especially when exceptions occur during the closure process itself.

-----

## Using try-with-resources (TWR)

The `try-with-resources` construct (introduced in Java 7) is the **mandatory best practice** for JDBC resource management.

* **Purpose**: Automatically and reliably closes resources that implement the `java.lang.AutoCloseable` interface when the `try` block terminates, even if exceptions are thrown.
* **Syntax**:
  ```java
  try (Connection con = DriverManager.getConnection(url);
       PreparedStatement pstmt = con.prepareStatement(sql);
       ResultSet rs = pstmt.executeQuery()) {
      // Application code to use the resources
  } // Resources are automatically closed here in reverse order (rs, pstmt, con)
  ```
* **Benefits**:
  1.  **Guaranteed Closure**: `close()` is called automatically, preventing resource leaks.
  2.  **Cleaner Code**: Eliminates boilerplate `finally` blocks and explicit `null` checks.
  3.  **Exception Handling**: Suppresses exceptions thrown during closure if a primary exception occurred in the `try` block, simplifying primary error diagnosis.

-----

## Best Practices and Pitfalls

| Category | Best Practice | Common Pitfall |
| :--- | :--- | :--- |
| **Guaranteed Closure** | **Always use `try-with-resources`** for all `Connection`, `Statement`, and `ResultSet` objects. | Manual resource closing without TWR, risking severe **resource leaks** and connection exhaustion. |
| **Exception Handling** | Handle and log **`SQLException`** without disrupting the TWR block (i.e., let TWR handle the closure). | Ignoring exceptions during resource closure or using an empty catch block. |
| **Usage** | Use pooled connections (`DataSource`) in production and monitor the pool's health. | Not handling connection limits, causing database overload or **deadlocks**. |
| **Logic** | Avoid reusing resources once they are closed (returned to the pool). | Attempting to reuse a closed `ResultSet` or `Statement`, leading to a runtime `SQLException`. |

-----

## Practice Task

* **Task**: Write a program to execute a query, ensuring all JDBC resources are managed using `try-with-resources`.
* **Solution Approach**:
  1.  Wrap the `Connection` acquisition and all subsequent `Statement`/`ResultSet` objects in a single, nested `try-with-resources` block.
  2.  Execute a query (e.g., `SELECT * FROM <table>`).
  3.  Handle any resulting `SQLException` separately to log error details.