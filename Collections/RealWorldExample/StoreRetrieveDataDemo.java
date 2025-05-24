package Java_Bootcamp.Collections.RealWorldExample;

import java.util.HashMap;
import java.util.Map;

// Class to demonstrate storing and retrieving data
class StoreRetrieveDataDemo {
    // Real-World Use Case: Managing student records and product inventory.
    // - Student records: Store and retrieve student data using a Map for quick lookup by ID.
    // - Product inventory: Track products using a Map for inventory management.

    public static void demonstrate() {
        System.out.println("=== Storing and Retrieving Data Demonstration ===");

        // Student Records (Map for fast lookup by ID)
        Map<String, Student> studentRecords = new HashMap<>();
        studentRecords.put("S001", new Student("S001", "Alice Smith", 3.8));
        studentRecords.put("S002", new Student("S002", "Bob Johnson", 3.5));
        studentRecords.put("S003", new Student("S003", "Charlie Brown", 4.0));

        System.out.println("Student Records:");
        studentRecords.values().forEach(System.out::println);

        // Retrieve a student by ID
        String studentId = "S002";
        Student student = studentRecords.get(studentId);
        System.out.println("\nRetrieved student (ID=" + studentId + "): " + student);

        // Product Inventory (Map for inventory management)
        Map<String, Product> inventory = new HashMap<>();
        inventory.put("P101", new Product("P101", "Laptop", 50));
        inventory.put("P102", new Product("P102", "Smartphone", 100));
        inventory.put("P103", new Product("P103", "Headphones", 200));

        System.out.println("\nProduct Inventory:");
        inventory.values().forEach(System.out::println);

        // Update inventory (e.g., restock)
        String productSku = "P101";
        Product product = inventory.get(productSku);
        product.setQuantity(product.getQuantity() + 10);
        System.out.println("\nUpdated product (SKU=" + productSku + "): " + product);
    }
}
