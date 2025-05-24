package Java_Bootcamp.Collections.RealWorldExample;

import java.util.*;
import java.util.stream.Collectors;

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
