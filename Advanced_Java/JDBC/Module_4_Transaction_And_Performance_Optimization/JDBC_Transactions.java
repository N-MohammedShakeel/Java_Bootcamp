package Java_Bootcamp.Advanced_Java.JDBC.Module_4_Transaction_And_Performance_Optimization; /**
 * JDBC_Transactions.java
 * Inserts two employees in a transaction, committing only if both succeed.
 * Scenario: Demonstrate transaction management with commit and rollback.
 * Features: Uses try-with-resources, properties file, and transaction handling.
 * DSA Relevance: State management, error recovery.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Transactions {
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
                con.setAutoCommit(false); // Start transaction
                try {
                    String sql = "INSERT INTO employee (ename, job, salary) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                        // First employee
                        pstmt.setString(1, "Eve Adams");
                        pstmt.setString(2, "Tester");
                        pstmt.setDouble(3, 60000);
                        int rows1 = pstmt.executeUpdate();

                        // Second employee
                        pstmt.setString(1, "Frank Wilson");
                        pstmt.setString(2, "Support");
                        pstmt.setDouble(3, 55000);
                        int rows2 = pstmt.executeUpdate();

                        System.out.println("Inserted " + (rows1 + rows2) + " employees.");
                        con.commit(); // Commit transaction
                    }
                } catch (SQLException e) {
                    System.err.println("Transaction failed: " + e.getMessage());
                    con.rollback(); // Rollback on error
                    System.err.println("Transaction rolled back.");
                } finally {
                    con.setAutoCommit(true); // Restore auto-commit
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