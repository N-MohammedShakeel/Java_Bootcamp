package Java_Bootcamp.Advanced_Java.JDBC.Module_3_Advanced_Query_Handling; /**
 * JDBC_CallableStatement.java
 * Calls a PostgreSQL function to retrieve an employee's salary by ID.
 * Scenario: Demonstrate stored function execution with CallableStatement.
 * Features: Uses try-with-resources, properties file, and parameter handling.
 * DSA Relevance: Parameter binding, data retrieval.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_CallableStatement {
    public static void main(String[] args) {
        Properties props = new Properties();
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";
        int empId = 1; // Example employee ID

        try (FileInputStream fis = new FileInputStream(propsFile)) {
            props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                // Prerequisite: Create function in psql
                // CREATE OR REPLACE FUNCTION get_employee_salary(emp_id INTEGER)
                // RETURNS DOUBLE PRECISION AS $$
                // BEGIN
                //     RETURN (SELECT salary FROM employee WHERE emp_id = $1);
                // END;
                // $$ LANGUAGE plpgsql;

                String sql = "{ ? = call get_employee_salary(?) }";
                try (CallableStatement cstmt = con.prepareCall(sql)) {
                    cstmt.registerOutParameter(1, Types.DOUBLE);
                    cstmt.setInt(2, empId);
                    boolean hasResult = cstmt.execute();
                    if (!hasResult) {
                        double salary = cstmt.getDouble(1);
                        if (cstmt.wasNull()) {
                            System.out.println("No salary found for employee ID " + empId);
                        } else {
                            System.out.println("Salary for employee ID " + empId + ": " + salary);
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