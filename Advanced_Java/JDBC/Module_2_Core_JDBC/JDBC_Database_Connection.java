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
                System.out.println("Connected to: " + metaData.getDatabaseProductName() + " "
                        + metaData.getDatabaseProductVersion());
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