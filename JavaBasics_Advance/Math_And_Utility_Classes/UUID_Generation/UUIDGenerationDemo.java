package Java_Bootcamp.JavaBasics_Advance.Math_And_Utility_Classes.UUID_Generation; /**
 * UUIDGenerationDemo.java
 * Demonstrates UUID class for generating unique identifiers.
 * Scenario: Generate 5 random UUIDs and validate a UUID string.
 * Features: Uses UUID.randomUUID(), fromString(), and error handling.
 * DSA Relevance: Unique key generation, string parsing.
 */
import java.util.UUID;

public class UUIDGenerationDemo {
    public static void main(String[] args) {
        System.out.println("=== UUID Generation Demo ===");
        // Generate 5 random UUIDs
        System.out.println("Random UUIDs:");
        for (int i = 0; i < 5; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println("UUID " + (i + 1) + ": " + uuid);
        }

        // Practice Task: Validate a UUID string
        System.out.println("\n=== Practice Task: Validate UUID ===");
        String uuidString = "123e4567-e89b-12d3-a456-426614174000";
        try {
            UUID parsedUUID = UUID.fromString(uuidString);
            System.out.println("Valid UUID: " + parsedUUID);
            // Test invalid UUID
            UUID.fromString("invalid-uuid"); // Will throw exception
        } catch (IllegalArgumentException e) {
            System.err.println("Error parsing UUID: " + e.getMessage());
        }
    }
}