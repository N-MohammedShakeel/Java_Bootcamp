package Java_Bootcamp.Advanced_Java.JDBC.Module_1_Fundamentals; /**
 * JDBC_Connection_Setup.java
 * Establishes a connection to a PostgreSQL database using credentials from a properties file.
 * Scenario: Verify JDBC setup by connecting to the 'company' database and printing "Connected".
 * Features: Uses try-with-resources, properties file, and robust error handling.
 * DSA Relevance: File I/O (loading properties), exception handling.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Connection_Setup {
    public static void main(String[] args) {

        Properties props = new Properties(); // Creates an empty key-value store
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";

        try (FileInputStream fis = new FileInputStream(propsFile)) {
            // Load the properties from the file into the Properties object
            props.load(fis);

            // Retrieve values by their keys
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Validate properties
            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }

            // try-with-resources automatically closes this resource at the end of the block
            try (Connection con = DriverManager.getConnection(url, user, password)){
                System.out.println("Connected to PostgreSQL successfully!");
            } catch (SQLException e) {
                // If an exception occurs, close() is still called before entering here
                System.err.println("Connection failed: " + e.getMessage());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
            }

            /*
             * Explanation:
             * 1. This is a try-with-resources block — introduced in Java 7.
             * 2. The Connection object implements AutoCloseable.
             * 3. When the try block exits (whether normally or via an exception),
             *    Java automatically calls con.close().
             * 4. With plain DriverManager, close() actually closes the DB connection.
             * 5. With a connection pool (e.g., HikariCP), close() returns the connection to the pool instead of closing it.
             */

        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }
}