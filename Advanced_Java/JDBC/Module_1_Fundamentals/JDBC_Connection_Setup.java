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
        Properties props = new Properties();
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";

        try (FileInputStream fis = new FileInputStream(propsFile)) {
            // Load database credentials
            props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Validate properties
            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }

            // Connect with try-with-resources
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to PostgreSQL successfully!");
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