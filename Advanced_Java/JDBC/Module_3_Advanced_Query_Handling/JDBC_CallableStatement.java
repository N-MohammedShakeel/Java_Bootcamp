package Java_Bootcamp.Advanced_Java.JDBC.Module_3_Advanced_Query_Handling;

/**
 * JDBC_CallableStatement.java
 * Calls a PostgreSQL function to retrieve an employee's salary by ID.
 * Scenario: Demonstrate stored function execution with CallableStatement.
 * Features: Uses try-with-resources, properties file, and parameter handling.
 * DSA Relevance: Parameter binding, data retrieval.
 */

import java.sql.*;
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

                /*
                Prerequisites:

                CREATE OR REPLACE FUNCTION get_employee_salary(emp_id INTEGER)
                RETURNS DOUBLE PRECISION AS $$
                BEGIN
                    RETURN (SELECT salary FROM employee WHERE employee.emp_id = $1);
                END;
                $$ LANGUAGE plpgsql;

                PostgreSQL Function: get_employee_salary

                Explanation:
                CREATE OR REPLACE FUNCTION → Creates a new function or updates it if it already exists.
                emp_id INTEGER             → Parameter passed to the function.
                $1                         → Placeholder for the first function parameter.
                RETURNS DOUBLE PRECISION   → Matches your 'salary' column type (floating-point).
                LANGUAGE plpgsql           → Tells PostgreSQL to use its procedural language.
                */

                // ===================
                // Method 1: Using CallableStatement with JDBC escape syntax `{ ? = call function(?) }`
                // This calls the stored function directly and retrieves the return value as an OUT parameter.
                // -------------------
                // Advantages:
                // - Direct access to the function's return value via registered OUT parameter.
                // - Clear separation between input parameters and output result.
                // - Standard JDBC syntax for calling stored procedures/functions.
                // -------------------
                String callableSql = "{ ? = call get_employee_salary(?) }";
                try (CallableStatement cstmt = con.prepareCall(callableSql)) {
                    cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);  // Register the output parameter (return value)
                    cstmt.setInt(2, empId);                                // Set the input parameter (emp_id)

                    cstmt.execute();                                       // Execute the function call

                    double salary = cstmt.getDouble(1);                    // Retrieve the output parameter (salary)
                    if (cstmt.wasNull()) {
                        System.out.println("No salary found for employee ID " + empId);
                    } else {
                        System.out.println("Salary for employee ID " + empId + ": " + salary);
                    }
                }

                // ===================
                // Method 2: Using PreparedStatement with SELECT query
                // This executes a SELECT statement that calls the function, returning a ResultSet.
                // -------------------
                // Advantages:
                // - Simple to write, just like any other SQL query.
                // - Can handle more complex queries easily.
                // -------------------
                String selectSql = "SELECT get_employee_salary(?)";
                try (PreparedStatement pstmt = con.prepareStatement(selectSql)) {
                    pstmt.setInt(1, empId);                                // Set the input parameter (emp_id)

                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            double salary = rs.getDouble(1);                // Get the first column of the result
                            if (rs.wasNull()) {
                                System.out.println("No salary found for employee ID " + empId);
                            } else {
                                System.out.println("Salary for employee ID " + empId + ": " + salary);
                            }
                        } else {
                            System.out.println("No results returned.");
                        }
                    }
                }

                /*
                Explanation of syntax difference:

                - `{ ? = call function(?) }`
                    - JDBC escape syntax for calling stored functions.
                    - The `? =` means the first parameter is an OUT parameter holding the function’s return value.
                    - Used with CallableStatement and output parameters.

                - `SELECT function(?)`
                    - A normal SQL query that calls the function.
                    - Returns a ResultSet containing the result(s).
                    - Used with PreparedStatement and ResultSet.

                Both approaches are valid, but:

                - Use CallableStatement when you want to clearly call a stored function or procedure and handle OUT parameters.
                - Use PreparedStatement when you treat the function like any other SQL query and work with ResultSets.
                */
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
