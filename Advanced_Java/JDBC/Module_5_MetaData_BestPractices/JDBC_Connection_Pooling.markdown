# Connection Pooling

## Overview
Connection pooling in JDBC improves performance by reusing database connections instead of creating new ones for each request. It is essential for scalable applications, particularly in multi-threaded or web environments.

- **Purpose**: Optimize connection management for high-performance applications.
- **DSA Relevance**: Involves resource pooling (similar to object pooling in DSA), queue management for connections, and thread safety, aligning with concurrent data structures.

## Why Connection Pooling?
- **Problem**: Creating a new `Connection` via `DriverManager.getConnection()` is expensive due to:
  - Network overhead (establishing TCP connections).
  - Authentication and session setup.
  - Resource allocation on the database server.
- **Solution**: A connection pool maintains a set of pre-established connections, reusing them for multiple requests.
- **Benefits**:
  - Reduces connection creation overhead.
  - Improves response time for database operations.
  - Manages connection limits to prevent database overload.
- **Use Cases**: Web applications, microservices, or any system with frequent database access.

## DataSource Interface
- **Purpose**: Provides a standard interface for obtaining connections, typically from a connection pool.
- **Key Methods**:
  - `getConnection()`: Returns a pooled `Connection`.
  - `getConnection(String user, String password)`: Returns a connection with specific credentials.
- **Creation**: Use a connection pooling library like HikariCP, Apache DBCP, or Tomcat JDBC.
- **Example (HikariCP)**:
  ```java
  HikariDataSource ds = new HikariDataSource();
  ds.setJdbcUrl("jdbc:postgresql://localhost:5432/company");
  ds.setUsername("postgres");
  ds.setPassword("MSpostgres17");
  Connection con = ds.getConnection();
  ```

## Connection Pooling Libraries
- **HikariCP**:
  - Lightweight, high-performance, widely used.
  - Configuration: Set `maximumPoolSize`, `minimumIdle`, `connectionTimeout`.
  - Example: Add `com.zaxxer:HikariCP:5.1.0` to Maven.
- **Apache DBCP**:
  - Feature-rich, part of Apache Commons.
  - Configuration: Set `maxTotal`, `maxIdle`, `minIdle`.
- **Tomcat JDBC**:
  - Optimized for Apache Tomcat, suitable for web applications.
- **Recommendation**: Use HikariCP for modern applications due to its performance and simplicity.

## Best Practices
- Configure pool size (`maximumPoolSize`) based on application load and database capacity.
- Set reasonable timeouts (`connectionTimeout`, `idleTimeout`) to avoid hanging.
- Use `DataSource` instead of `DriverManager` for pooled connections.
- Monitor pool metrics (e.g., active connections, idle connections) in production.
- Ensure proper resource closure with `try-with-resources`.
- Secure credentials in pool configuration (e.g., use properties or vault).

## Common Pitfalls
- Setting an overly large pool size, overwhelming the database.
- Not closing connections, leading to pool exhaustion.
- Ignoring timeout configurations, causing application hangs.
- Hardcoding pool configurations instead of using properties.
- Not monitoring pool usage, leading to performance bottlenecks.

## Practice Task
- **Task**: Use HikariCP to connect to the `company` database and query the `employee` table.
- **Solution Approach**:
  - Add HikariCP dependency to the project.
  - Configure `HikariDataSource` with credentials from `db.properties`.
  - Use `DataSource.getConnection()` to query the `employee` table.
  - Handle exceptions and close resources properly.