package Java_Bootcamp.Advanced_Java.JDBC.Module_5_MetaData_BestPractices; /**
 * JDBC_Metadata.java
 * Retrieves and prints column names and types of the 'employee' table.
 * Scenario: Demonstrate ResultSetMetaData usage.
 * Features: Uses try-with-resources, properties file, and dynamic column handling.
 * DSA Relevance: Metadata iteration, dynamic data processing.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JDBC_Metadata {
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
                String sql = "SELECT * FROM employee";
                try (PreparedStatement pstmt = con.prepareStatement(sql);
                     ResultSet rs = pstmt.executeQuery()) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    System.out.println("Employee Table Columns:");
                    for (int i = 1; i <= columnCount; i++) {
                        String name = rsmd.getColumnName(i);
                        String type = rsmd.getColumnTypeName(i);
                        System.out.printf("Column %d: %s (%s)%n", i, name, type);
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