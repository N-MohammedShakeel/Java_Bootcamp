package Java_Bootcamp.DSA.Collections.RealWorldExample;

import java.util.*;
import java.util.stream.Collectors;

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
