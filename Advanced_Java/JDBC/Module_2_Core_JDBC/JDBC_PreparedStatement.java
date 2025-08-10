package Java_Bootcamp.Advanced_Java.JDBC.Module_2_Core_JDBC; /**
 * JDBC_PreparedStatement.java
 * Inserts a new employee into the 'employee' table using PreparedStatement.
 * Scenario: Demonstrate parameterized queries to prevent SQL injection.
 * Features: Uses try-with-resources, properties file, and input validation.
 * DSA Relevance: String manipulation, parameter binding.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_PreparedStatement {
    public static void main(String[] args) {
        Properties props = new Properties();
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";

        // Sample employee data (from variables, not hardcoded)
        String name = "David Brown";
        String job = "Designer";
        double salary = 70000.00;

        try (FileInputStream fis = new FileInputStream(propsFile)) {
            props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO employee (ename, job, salary) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    // Validate inputs
                    if (name == null || name.trim().isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be null or empty");
                    }

                    // Set parameters
                    pstmt.setString(1, name);
                    pstmt.setString(2, job);
                    pstmt.setDouble(3, salary);

                    // Execute insert
                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println("Inserted " + rowsAffected + " employee(s): " + name);
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Input error: " + e.getMessage());
        }
    }
}