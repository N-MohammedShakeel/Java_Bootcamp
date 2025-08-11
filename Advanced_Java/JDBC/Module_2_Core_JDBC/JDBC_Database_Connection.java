package Java_Bootcamp.Advanced_Java.JDBC.Module_2_Core_JDBC; /**
 * JDBC_Database_Connection.java
 * Connects to the PostgreSQL 'company' database and retrieves the database product name.
 * Scenario: Demonstrate connection setup and metadata retrieval using DatabaseMetaData.
 * Features: Uses try-with-resources, properties file, and edge case handling.
 * DSA Relevance: File I/O, metadata processing, exception handling.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Database_Connection {
    public static void main(String[] args) {
        Properties props = new Properties();
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";

        try (FileInputStream fis = new FileInputStream(propsFile)) {
            props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                DatabaseMetaData metaData = con.getMetaData();

                // Example usage
                System.out.println("Connected to: "
                        + metaData.getDatabaseProductName() + " "  // e.g., PostgreSQL
                        + metaData.getDatabaseProductVersion());   // e.g., 16.3 (Ubuntu 16.3-1.pgdg22.04+1)

                System.out.println("MetaData : " + metaData); // Prints the DatabaseMetaData object reference

                /*
                 * =======================
                 * Common DatabaseMetaData Methods & Example Outputs
                 * =======================
                 * 1. getDatabaseProductName()          → "PostgreSQL"
                 * 2. getDatabaseProductVersion()       → "17.5"
                 * 3. getDriverName()                   → "PostgreSQL JDBC Driver"
                 * 4. getDriverVersion()                → "42.7.2"
                 * 5. getURL()                          → "jdbc:postgresql://localhost:5432/mydb"
                 * 6. getUserName()                     → "postgres"
                 * 7. getMaxConnections()               → 100  (depends on DB config)
                 * 8. getSQLKeywords()                  → "LIMIT,OFFSET,..."
                 * 9. supportsTransactions()            → true
                 * 10. supportsBatchUpdates()           → true
                 * 11. getDefaultTransactionIsolation() → 2 (TRANSACTION_READ_COMMITTED)
                 * 12. getSchemas()                     → ResultSet of available schemas (e.g., "public")
                 * 13. getTables(null, null, "%", null) → ResultSet of all table names in the DB
                 * 14. getPrimaryKeys(null, null, "tableName") → ResultSet with primary key info
                 * 15. getImportedKeys(null, null, "tableName") → Foreign key details for a table
                 *
                 * Note:
                 * - All methods can throw SQLException, so handle them or declare throws.
                 * - ResultSets returned by metadata queries (like getSchemas, getTables) must be iterated and closed.
                 */

            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
            }

        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }
}