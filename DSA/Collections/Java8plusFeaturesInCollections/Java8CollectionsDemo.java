package Java_Bootcamp.DSA.Collections.Java8plusFeaturesInCollections;

// Java 8+ Features in Collections
// Objective: Leverage modern Java features for collections.

// Java 8 introduced significant enhancements to the Collections Framework, enabling functional programming
// and more concise, expressive code. These features include the Stream API, lambda expressions, and default methods.

// Overview of Topics:
// 1. Stream API:
//    - filter(): Selects elements based on a predicate.
//    - map(): Transforms elements using a function.
//    - reduce(): Aggregates elements into a single result.
//    - collect(): Collects stream results into a collection.
//    - Parallel streams: Leverages multi-core processors for performance.
// 2. Lambda Expressions:
//    - forEach(): Performs an action for each element.
//    - removeIf(): Removes elements matching a predicate.
// 3. Default Methods in Collection Interfaces:
//    - Map.compute(): Computes a new value for a key.
//    - List.replaceAll(): Replaces each element with the result of an operator.

// This code demonstrates these features on List, Set, and Map collections.

// Main class to run all Java 8+ collections feature demonstrations
public class Java8CollectionsDemo {
    public static void main(String[] args) {
        // Run Stream API demonstration
        StreamAPIDemo.demonstrate();
        
        // Run lambda expressions demonstration
        LambdaExpressionsDemo.demonstrate();
        
        // Run default methods demonstration
        DefaultMethodsDemo.demonstrate();
    }
}