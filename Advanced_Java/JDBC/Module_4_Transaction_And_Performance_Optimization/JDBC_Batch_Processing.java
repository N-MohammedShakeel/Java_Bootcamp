package Java_Bootcamp.Advanced_Java.JDBC.Module_4_Transaction_And_Performance_Optimization; /**
 * JDBC_Batch_Processing.java
 * Inserts 100 fake employee records using batch processing.
 * Scenario: Demonstrate efficient bulk inserts.
 * Features: Uses try-with-resources, properties file, and batch execution.
 * DSA Relevance: Bulk data processing, array iteration.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Batch_Processing {
    public static void main(String[] args) {
        Properties props = new Properties();
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";

        // Fake employee data
        String[] names = {"John", "Jane", "Mike", "Sarah"};
        String[] jobs = {"Developer", "Analyst", "Manager", "Tester"};
        double[] salaries = {60000, 65000, 70000, 75000};

        try (FileInputStream fis = new FileInputStream(propsFile)) {
            props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                con.setAutoCommit(false); // Disable auto-commit for batch
                try {
                    String sql = "INSERT INTO employee (ename, job, salary) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                        // Add 100 records to batch
                        for (int i = 0; i < 100; i++) {
                            String name = names[i % names.length] + " " + (i + 1);
                            if (name.trim().isEmpty()) {
                                throw new IllegalArgumentException("Name cannot be empty");
                            }
                            pstmt.setString(1, name);
                            pstmt.setString(2, jobs[i % jobs.length]);
                            pstmt.setDouble(3, salaries[i % salaries.length] + (i * 100));
                            pstmt.addBatch();
                        }

                        // Execute batch
                        int[] results = pstmt.executeBatch();
                        int totalRows = 0;
                        for (int rows : results) {
                            totalRows += rows;
                        }
                        System.out.println("Inserted " + totalRows + " employees via batch.");
                        con.commit();
                    }
                } catch (SQLException e) {
                    System.err.println("Batch failed: " + e.getMessage());
                    con.rollback();
                    System.err.println("Batch rolled back.");
                } finally {
                    con.setAutoCommit(true);
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