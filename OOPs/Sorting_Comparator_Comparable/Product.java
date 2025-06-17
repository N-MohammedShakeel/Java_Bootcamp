package Java_Bootcamp.OOPs.Sorting_Comparator_Comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Product demonstrates Comparator for sorting Product objects by price, rating, and multi-field criteria.
 * Includes null handling, lambda-based comparators, and edge cases. Embeds professional practices, notes
 * for mastery, and internal implementation details for Phase 1 learners mastering Java sorting in the
 * Java Bootcamp.
 */
public class Product {
    // Product class (no Comparable, relies on Comparators)
    static class ProductImpl {
        private final int id;
        private final String name;
        private final double price;
        private final double rating;

        ProductImpl(int id, String name, double price, double rating) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        // Getters for lambda-based sorting
        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public double getRating() { return rating; }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + ", rating=" + rating + "}";
        }
    }

    // Comparator for sorting by price, then rating
    static class ProductPriceComparator implements Comparator<ProductImpl> {
        @Override
        public int compare(ProductImpl p1, ProductImpl p2) {
            // Sort by price, then rating descending
            int priceCompare = Double.compare(p1.price, p2.price);
            return priceCompare != 0 ? priceCompare : new ProductRatingComparator().compare(p1, p2);
        }
    }

    // Comparator for sorting by rating descending
    static class ProductRatingComparator implements Comparator<ProductImpl> {
        @Override
        public int compare(ProductImpl p1, ProductImpl p2) {
            // Sort by rating descending
            return Double.compare(p2.rating, p1.rating);
        }
    }

    public static void main(String[] args) {
        // Test data with null name and equal prices
        ProductImpl[] products = {
            new ProductImpl(1, "Pen", 10, 4.2),
            new ProductImpl(2, "Notebook", 100, 4.4),
            new ProductImpl(3, "Book", 100, 4.8), // Equal price to Notebook
            new ProductImpl(4, "Bag", 300, 4.0),
            new ProductImpl(5, null, 50, 4.5)     // Null name edge case
        };

        // Custom ordering: Sort by price, then rating (ProductPriceComparator)
        System.out.println("Sorted by Price, then Rating:");
        Arrays.sort(products, new ProductPriceComparator());
        System.out.println(Arrays.toString(products));

        // Lambda: Sort by rating descending, then name
        System.out.println("\nSorted by Rating (Descending), then Name:");
        Arrays.sort(products, Comparator.comparingDouble(ProductImpl::getRating)
                                       .reversed()
                                       .thenComparing(ProductImpl::getName, Comparator.nullsLast(String::compareTo)));
        System.out.println(Arrays.toString(products));

        // Lambda: Sort by name length, nulls first
        System.out.println("\nSorted by Name Length (Nulls First):");
        Arrays.sort(products, (p1, p2) -> {
            if (p1.name == null && p2.name == null) return 0;
            if (p1.name == null) return -1;
            if (p2.name == null) return 1;
            return Integer.compare(p1.name.length(), p2.name.length());
        });
        System.out.println(Arrays.toString(products));
    }

    /**
     * Internal Implementation Details:
     * - Comparator (e.g., ProductPriceComparator): Invoked by Arrays.sort() to compare ProductImpl objects by price,
     *   then rating. Returns -1, 0, or 1 using Double.compare(). TimSort (O(n log n)) compares pairs efficiently.
     * - Chained Comparator: Price then rating logic evaluates sequentially. Lambda comparators (e.g., rating then name)
     *   use thenComparing for multi-field sorting.
     * - Object Creation: Sorting reorders array references, no new ProductImpl objects created. Comparator instances are
     *   lightweight, instantiated once. Lambdas generate synthetic classes.
     * - JVM Behavior: TimSort optimizes for partially sorted data. NullPointerException is handled via nullsLast or
     *   explicit checks. No Comparable implementation, so natural ordering is undefined.
     * - Memory: TimSort uses O(n) auxiliary space for merging. No new ProductImpl objects allocated.
     *
     * Professional Practices:
     * - Use generics (Comparator<ProductImpl>) for type safety, eliminating unsafe casts.
     * - Ensure immutability with final fields to prevent sorting inconsistencies.
     * - Handle nulls with nullsLast or explicit checks to avoid NullPointerException.
     * - Use utility methods (Double.compare) for precise, overflow-safe comparisons.
     * - Provide getters for method references in lambda-based sorting (e.g., ProductImpl::getRating).
     * - Format toString for debugging (e.g., Product{id=1, ...}).
     * - Test edge cases like null names and equal prices for robustness.
     *
     * Notes for Mastery:
     * - Product relies on Comparators for flexible sorting, no fixed natural order.
     * - Comparator supports multiple criteria (price, rating, name), ideal for runtime flexibility.
     * - Multi-field sorting (price then rating) ensures deterministic results for ties.
     * - Null handling is essential for robust production code.
     * - Lambda comparators with Comparator.comparing provide concise, readable syntax.
     * - Chained comparators (thenComparing) enhance sorting precision.
     * - Understand TimSort’s efficiency for real-world sorting performance.
     */
}