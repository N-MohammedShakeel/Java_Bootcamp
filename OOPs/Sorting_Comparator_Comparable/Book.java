package Java_Bootcamp.OOPs.Sorting_Comparator_Comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Book demonstrates Comparable and Comparator for sorting Book objects by price (natural ordering),
 * year, and title. Includes null handling, multi-field sorting, and lambda-based comparators. Embeds
 * professional practices, notes for mastery, and internal implementation details for Phase 1 learners
 * mastering Java sorting in the Java Bootcamp.
 */
public class Book {
    // Book class implementing Comparable for natural ordering by price
    static class BookImpl implements Comparable<BookImpl> {
        private final String title; // Immutable field
        private final double price;
        private final int year;

        BookImpl(String title, double price, int year) {
            this.title = title;
            this.price = price;
            this.year = year;
        }

        // Natural ordering by price using Double.compare for precision
        @Override
        public int compareTo(BookImpl b) {
            return Double.compare(this.price, b.price);
        }

        // Getters for lambda-based sorting
        public String getTitle() { return title; }
        public double getPrice() { return price; }
        public int getYear() { return year; }

        @Override
        public String toString() {
            return "Book{title='" + title + "', price=" + price + ", year=" + year + "}";
        }
    }

    // Comparator for sorting by year
    static class YearComparator implements Comparator<BookImpl> {
        @Override
        public int compare(BookImpl b1, BookImpl b2) {
            // Sort by year ascending
            return Integer.compare(b1.year, b2.year);
        }
    }

    public static void main(String[] args) {
        // Test data with null title and equal prices
        BookImpl[] books = {
            new BookImpl("Java", 232, 2020),
            new BookImpl("Python", 23, 2019),
            new BookImpl("C++", 232, 2021), // Equal price to Java
            new BookImpl(null, 150, 2022)   // Null title edge case
        };

        // Natural ordering: Sort by price (Comparable)
        System.out.println("Sorted by Price (Natural Ordering):");
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));

        // Custom ordering: Sort by year (YearComparator)
        System.out.println("\nSorted by Year:");
        Arrays.sort(books, new YearComparator());
        System.out.println(Arrays.toString(books));

        // Lambda: Sort by title lexicographically, nulls last
        System.out.println("\nSorted by Title (Lexicographical, Nulls Last):");
        Arrays.sort(books, Comparator.comparing(BookImpl::getTitle, Comparator.nullsLast(String::compareTo)));
        System.out.println(Arrays.toString(books));

        // Lambda: Sort by price descending, then year ascending
        System.out.println("\nSorted by Price (Descending), then Year:");
        Arrays.sort(books, Comparator.comparingDouble(BookImpl::getPrice)
                                    .reversed()
                                    .thenComparingInt(BookImpl::getYear));
        System.out.println(Arrays.toString(books));
    }

    /**
     * Internal Implementation Details:
     * - Comparable (compareTo): Invoked by Arrays.sort() to compare BookImpl objects pairwise. Returns -1, 0, or 1 based
     *   on price comparison using Double.compare(), handling floating-point precision (e.g., NaN). JVM uses TimSort,
     *   a hybrid of merge sort and insertion sort, with O(n log n) complexity.
     * - Comparator (compare): YearComparator and lambdas define custom ordering. Comparator objects are instantiated once
     *   per sort call and reused. Chained comparisons (e.g., price then year) are evaluated sequentially.
     * - Object Creation: Sorting reorders array references in-place, creating no new BookImpl objects. Comparator instances
     *   (e.g., new YearComparator()) are lightweight, allocated once. Lambda comparators are compiled to synthetic classes.
     * - JVM Behavior: TimSort minimizes comparisons by exploiting partially sorted data. NullPointerException is prevented
     *   by nullsLast in lambdas. compareTo() assumes non-null objects; null BookImpls would throw an exception.
     * - Memory: Sorting uses O(n) auxiliary space for merging in TimSort. No additional BookImpl objects are instantiated.
     *
     * Professional Practices:
     * - Use generics (Comparable<BookImpl>, Comparator<BookImpl>) for type safety, eliminating ClassCastException risks.
     * - Ensure immutability with final fields to prevent sorting inconsistencies.
     * - Handle nulls with Comparator.nullsLast to avoid NullPointerException.
     * - Use utility methods (Double.compare, Integer.compare) for precise, overflow-safe comparisons.
     * - Provide getters for method references in lambda-based sorting (e.g., BookImpl::getYear).
     * - Format toString clearly for debugging (e.g., Book{title='Java', ...}).
     * - Test edge cases like null titles and equal prices for robustness.
     *
     * Notes for Mastery:
     * - Comparable defines a single natural ordering (price), ideal for default sorting in collections like TreeSet.
     * - Comparator enables flexible sorting (year, title), supporting dynamic requirements.
     * - Multi-field sorting (price then year) resolves ties, ensuring deterministic results.
     * - Null handling is critical for production code to prevent runtime errors.
     * - Lambda comparators (Comparator.comparing) offer concise, modern syntax.
     * - Avoid subtraction (e.g., year - b.year) to prevent integer overflow; use compare methods.
     * - Understand TimSort’s efficiency for real-world sorting performance.
     */
}
