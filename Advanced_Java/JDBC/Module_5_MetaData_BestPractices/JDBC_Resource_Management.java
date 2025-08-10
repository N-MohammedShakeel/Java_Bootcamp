package Java_Bootcamp.Advanced_Java.JDBC.Module_5_MetaData_BestPractices; /**
 * JDBC_Resource_Management.java
 * Connects to the 'company' database using try-with-resources for all JDBC objects.
 * Scenario: Demonstrate proper resource management.
 * Features: Uses try-with-resources, properties file, and robust error handling.
 * DSA Relevance: Resource allocation, exception handling.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Resource_Management {
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

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee");
                 ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Connected to PostgreSQL successfully!");
                System.out.println("Employee Table Data:");
                if (!rs.isBeforeFirst()) {
                    System.out.println("No employees found.");
                } else {
                    while (rs.next()) {
                        int id = rs.getInt("emp_id");
                        String name = rs.getString("ename");
                        String job = rs.getString("job");
                        double salary = rs.getDouble("salary");
                        System.out.printf("%d | %s | %s | %.2f%n", id, name, job, salary);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }
}