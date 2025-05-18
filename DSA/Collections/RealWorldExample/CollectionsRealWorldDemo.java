package Java_Bootcamp.DSA.Collections.RealWorldExample;

import java.util.*;
import java.util.stream.Collectors;

// Practical Applications and Real-World Use Cases
// Objective: Apply collections to solve common programming problems.

// Java collections are versatile tools for managing data in real-world applications.
// This section demonstrates practical uses of collections in various scenarios.

// Overview of Topics:
// 1. Storing and Retrieving Data: Using collections for student records and product inventory.
// 2. Implementing Data Structures: Using collections to implement stacks and queues.
// 3. Solving Algorithmic Problems: Finding duplicates and grouping data.
// 4. Using Map for Caching or Frequency Counting: Caching results and counting occurrences.
// 5. Real-World Examples: Handling database query results and parsing JSON-like data.

// This code organizes each application in a separate class for clarity.

// Class to represent a Student (for student records demo)
class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", gpa=" + gpa + "}";
    }
}

// Class to represent a Product (for inventory demo)
class Product {
    private String sku;
    private String name;
    private int quantity;

    public Product(String sku, String name, int quantity) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{sku=" + sku + ", name=" + name + ", quantity=" + quantity + "}";
    }
}

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

// Class to demonstrate implementing data structures
class DataStructuresDemo {
    // Real-World Use Case: Implementing stacks and queues using collections.
    // - Stack: LIFO (Last-In-First-Out) for undo functionality.
    // - Queue: FIFO (First-In-First-Out) for task scheduling.
    
    public static void demonstrate() {
        System.out.println("\n=== Data Structures Demonstration ===");
        
        // Stack (using ArrayDeque)
        Deque<String> stack = new ArrayDeque<>();
        // Simulate undo functionality (e.g., text editor actions)
        stack.push("Typed 'Hello'");
        stack.push("Typed 'World'");
        stack.push("Bolded text");
        
        System.out.println("Stack (Undo History):");
        stack.forEach(System.out::println);
        
        // Undo last action
        String lastAction = stack.pop();
        System.out.println("\nUndo: " + lastAction);
        System.out.println("Stack after undo: " + stack);
        
        // Queue (using ArrayDeque)
        Queue<String> queue = new ArrayDeque<>();
        // Simulate task scheduling (e.g., print jobs)
        queue.offer("Print Document1.pdf");
        queue.offer("Print Document2.pdf");
        queue.offer("Print Document3.pdf");
        
        System.out.println("\nQueue (Print Jobs):");
        queue.forEach(System.out::println);
        
        // Process next task
        String nextTask = queue.poll();
        System.out.println("\nProcessing: " + nextTask);
        System.out.println("Queue after processing: " + queue);
    }
}

// Class to demonstrate solving algorithmic problems
class AlgorithmicProblemsDemo {
    // Real-World Use Case: Finding duplicates and grouping data.
    // - Finding duplicates: Identify repeated elements in a dataset.
    // - Grouping data: Organize data by a key (e.g., categorize by type).
    
    public static void demonstrate() {
        System.out.println("\n=== Algorithmic Problems Demonstration ===");
        
        // Finding Duplicates (using Set)
        List<String> emails = Arrays.asList(
            "user1@example.com",
            "user2@example.com",
            "user1@example.com",
            "user3@example.com",
            "user2@example.com"
        );
        Set<String> uniqueEmails = new HashSet<>();
        Set<String> duplicates = emails.stream()
            .filter(email -> !uniqueEmails.add(email))
            .collect(Collectors.toSet());
        
        System.out.println("Email List: " + emails);
        System.out.println("Duplicate Emails: " + duplicates);
        
        // Grouping Data (using Map with Stream API)
        List<Product> products = Arrays.asList(
            new Product("P101", "Laptop", 50),
            new Product("P102", "Smartphone", 100),
            new Product("P103", "Laptop", 30),
            new Product("P104", "Smartphone", 70)
        );
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getName));
        
        System.out.println("\nProducts Grouped by Category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(p -> System.out.println("  " + p));
        });
    }
}

// Class to demonstrate using Map for caching or frequency counting
class MapCachingFrequencyDemo {
    // Real-World Use Case: Caching results and counting frequencies.
    // - Caching: Store computed results to avoid redundant calculations.
    // - Frequency Counting: Count occurrences of elements (e.g., word frequency).
    
    public static void demonstrate() {
        System.out.println("\n=== Map for Caching and Frequency Counting Demonstration ===");
        
        // Caching (using Map)
        Map<Integer, Long> factorialCache = new HashMap<>();
        // Function to compute factorial with caching
        class FactorialCalculator {
            long compute(int n) {
                return factorialCache.computeIfAbsent(n, k -> {
                    if (k <= 1) return 1L;
                    return k * compute(k - 1);
                });
            }
        }
        
        FactorialCalculator calculator = new FactorialCalculator();
        System.out.println("Factorial of 5: " + calculator.compute(5)); // Computes and caches
        System.out.println("Factorial of 5 (cached): " + calculator.compute(5)); // Uses cache
        System.out.println("Cache contents: " + factorialCache);
        
        // Frequency Counting (using Map)
        List<String> words = Arrays.asList(
            "apple", "banana", "apple", "orange", "banana", "apple"
        );
        Map<String, Long> wordFrequency = words.stream()
            .collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()
            ));
        
        System.out.println("\nWord List: " + words);
        System.out.println("Word Frequency: " + wordFrequency);
    }
}

// Class to demonstrate real-world examples
class RealWorldExamplesDemo {
    // Real-World Use Case: Handling database query results and JSON parsing.
    // - Database Query Results: Store and process query results (mocked as List).
    // - JSON Parsing: Parse JSON-like data into collections (simplified string parsing).
    
    public static void demonstrate() {
        System.out.println("\n=== Real-World Examples Demonstration ===");
        
        // Database Query Results (mocked as List of Maps)
        // Simulate a query result: SELECT name, age FROM users
        List<Map<String, Object>> queryResults = Arrays.asList(
            new HashMap<String, Object>() {{
                put("name", "Alice");
                put("age", 25);
            }},
            new HashMap<String, Object>() {{
                put("name", "Bob");
                put("age", 30);
            }},
            new HashMap<String, Object>() {{
                put("name", "Charlie");
                put("age", 35);
            }}
        );
        
        System.out.println("Database Query Results (Users):");
        queryResults.forEach(row -> System.out.println("Name: " + row.get("name") + ", Age: " + row.get("age")));
        
        // Filter users older than 28
        List<Map<String, Object>> filteredResults = queryResults.stream()
            .filter(row -> (Integer) row.get("age") > 28)
            .collect(Collectors.toList());
        System.out.println("\nFiltered Users (age > 28):");
        filteredResults.forEach(row -> System.out.println("Name: " + row.get("name") + ", Age: " + row.get("age")));
        
        // JSON Parsing (simplified string parsing)
        // Simulate JSON: [{"id": "P001", "name": "Laptop"}, {"id": "P002", "name": "Phone"}]
        String jsonData = "[{\"id\": \"P001\", \"name\": \"Laptop\"}, {\"id\": \"P002\", \"name\": \"Phone\"}]";
        List<Map<String, String>> parsedProducts = parseJson(jsonData);
        
        System.out.println("\nParsed JSON Products:");
        parsedProducts.forEach(product -> System.out.println("ID: " + product.get("id") + ", Name: " + product.get("name")));
    }
    
    // Simplified JSON parser (for demo purposes, assumes well-formed input)
    private static List<Map<String, String>> parseJson(String json) {
        List<Map<String, String>> result = new ArrayList<>();
        // Remove outer brackets
        String content = json.substring(1, json.length() - 1);
        // Split into individual objects
        String[] objects = content.split("},\\s*\\{");
        for (String obj : objects) {
            Map<String, String> map = new HashMap<>();
            // Clean up braces and split key-value pairs
            obj = obj.replace("{", "").replace("}", "");
            String[] pairs = obj.split(",\\s*");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":\\s*");
                String key = keyValue[0].replace("\"", "");
                String value = keyValue[1].replace("\"", "");
                map.put(key, value);
            }
            result.add(map);
        }
        return result;
    }
}

// Main class to run all real-world collections demonstrations
public class CollectionsRealWorldDemo {
    public static void main(String[] args) {
        // Run storing and retrieving data demonstration
        StoreRetrieveDataDemo.demonstrate();
        
        // Run data structures demonstration
        DataStructuresDemo.demonstrate();
        
        // Run algorithmic problems demonstration
        AlgorithmicProblemsDemo.demonstrate();
        
        // Run Map caching and frequency counting demonstration
        MapCachingFrequencyDemo.demonstrate();
        
        // Run real-world examples demonstration
        RealWorldExamplesDemo.demonstrate();
    }
}