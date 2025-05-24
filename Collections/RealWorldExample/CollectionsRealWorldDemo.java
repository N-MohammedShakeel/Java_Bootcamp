package Java_Bootcamp.Collections.RealWorldExample;

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