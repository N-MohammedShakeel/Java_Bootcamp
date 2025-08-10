package Java_Bootcamp.Advanced_Java.JDBC.Module_5_MetaData_BestPractices; /**
 * EmployeeDAO.java
 * Implements DAO pattern for CRUD operations on the employee table.
 * Scenario: Encapsulate database logic with secure JDBC practices.
 * Features: Uses PreparedStatement, properties file, input validation, and try-with-resources.
 * DSA Relevance: Encapsulation, data validation, exception handling.
 */
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class EmployeeDAO {
    private final String url;
    private final String user;
    private final String password;

    // Constructor loads database credentials from db.properties
    public EmployeeDAO() throws IOException {
        Properties props = new Properties();
        String propsFile = "D:\\IdeaProjects\\java-master\\src\\Java_Bootcamp\\Advanced_Java\\JDBC\\db.properties";
        try (FileInputStream fis = new FileInputStream(propsFile)) {
            props.load(fis);
            this.url = props.getProperty("db.url");
            this.user = props.getProperty("db.user");
            this.password = props.getProperty("db.password");
            if (url == null || user == null || password == null) {
                throw new IOException("Missing required properties in db.properties");
            }
        }
    }

    // Add a new employee with input validation
    public void addEmployee(Employee emp) throws SQLException {
        if (emp == null || emp.getName() == null || emp.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        if (emp.getSalary() < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        String sql = "INSERT INTO employee (ename, job, salary) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getJob());
            pstmt.setDouble(3, emp.getSalary());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Added employee: " + emp.getName());
            } else {
                throw new SQLException("Failed to add employee: " + emp.getName());
            }
        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            throw e;
        }
    }

    // Retrieve an employee by ID
    public Employee getEmployeeById(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID: " + id);
        }

        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getDouble("salary")
                    );
                } else {
                    return null; // Employee not found
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving employee ID " + id + ": " + e.getMessage());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            throw e;
        }
    }

    // Test the DAO
    public static void main(String[] args) {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            // Add employee
            Employee emp = new Employee(0, "George Miller", "Engineer", 72000);
            dao.addEmployee(emp);
            // Retrieve and print employee
            Employee retrieved = dao.getEmployeeById(1);
            if (retrieved != null) {
                System.out.println("Retrieved: " + retrieved.getName() + ", " + retrieved.getJob() + ", " + retrieved.getSalary());
            } else {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.err.println("Error loading properties: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}

// Employee class to represent table row
class Employee {
    private int id;
    private String name;
    private String job;
    private double salary;

    public Employee(int id, String name, String job, double salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getJob() { return job; }
    public double getSalary() { return salary; }
}