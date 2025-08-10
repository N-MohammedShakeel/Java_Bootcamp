package Java_Bootcamp.Advanced_Java.JDBC.Module_2_Core_JDBC; /**
 * JDBC_Statement_Interface.java
 * Uses Statement to create an employee table, insert records, and retrieve data.
 * Scenario: Perform basic CRUD operations on the 'company' database.
 * Features: Handles table creation, inserts, selects, and edge cases with try-with-resources.
 * DSA Relevance: String manipulation (SQL queries), iteration over result sets.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Statement_Interface {
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
                try (Statement stmt = con.createStatement()) {
                    // Create table if not exists
                    String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                            + "emp_id SERIAL PRIMARY KEY, "
                            + "ename VARCHAR(50) NOT NULL, "
                            + "job VARCHAR(50), "
                            + "salary DOUBLE PRECISION)";
                    stmt.executeUpdate(createTableSQL);
                    System.out.println("Employee table created or already exists.");

                    // Insert 3 records
                    String[] inserts = {
                            "INSERT INTO employee (ename, job, salary) VALUES ('Alice Smith', 'Developer', 75000)",
                            "INSERT INTO employee (ename, job, salary) VALUES ('Bob Johnson', 'Manager', 85000)",
                            "INSERT INTO employee (ename, job, salary) VALUES ('Carol Williams', 'Analyst', 65000)"
                    };
                    for (String sql : inserts) {
                        int rowsAffected = stmt.executeUpdate(sql);
                        System.out.println("Inserted " + rowsAffected + " row(s).");
                    }

                    // Retrieve and print all rows
                    String selectSQL = "SELECT * FROM employee";
                    try (ResultSet rs = stmt.executeQuery(selectSQL)) {
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