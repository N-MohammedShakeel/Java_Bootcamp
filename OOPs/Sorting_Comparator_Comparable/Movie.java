package Java_Bootcamp.OOPs.Sorting_Comparator_Comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Movie demonstrates Comparable and Comparator for sorting Movie objects by year (natural ordering),
 * rating, name, and multi-field criteria. Includes null handling, lambda-based comparators, and edge
 * cases. Embeds professional practices, notes for mastery, and internal implementation details for
 * Phase 1 learners mastering Java sorting in the Java Bootcamp.
 */
public class Movie {
    // Movie class implementing Comparable for natural ordering by year
    static class MovieImpl implements Comparable<MovieImpl> {
        private final String name;
        private final int year;
        private final double rating;

        MovieImpl(String name, int year, double rating) {
            this.name = name;
            this.year = year;
            this.rating = rating;
        }

        // Natural ordering by year using Integer.compare
        @Override
        public int compareTo(MovieImpl m) {
            return Integer.compare(this.year, m.year);
        }

        // Getters for lambda-based sorting
        public String getName() { return name; }
        public int getYear() { return year; }
        public double getRating() { return rating; }

        @Override
        public String toString() {
            return "Movie{name='" + name + "', year=" + year + ", rating=" + rating + "}";
        }
    }

    public static void main(String[] args) {
        // Test data with null name and equal years
        MovieImpl[] movies = {
            new MovieImpl("Inception", 2010, 8.8),
            new MovieImpl("Avatar", 2009, 7.8),
            new MovieImpl("Tenet", 2020, 7.5),
            new MovieImpl("Inception", 2010, 8.7), // Equal year to Inception
            new MovieImpl(null, 2015, 8.0)         // Null name edge case
        };

        // Natural ordering: Sort by year (Comparable)
        System.out.println("Sorted by Year (Natural Ordering):");
        Arrays.sort(movies);
        System.out.println(Arrays.toString(movies));

        // Lambda: Sort by rating descending, then name
        System.out.println("\nSorted by Rating (Descending), then Name:");
        Arrays.sort(movies, Comparator.comparingDouble(MovieImpl::getRating)
                                     .reversed()
                                     .thenComparing(MovieImpl::getName, Comparator.nullsLast(String::compareTo)));
        System.out.println(Arrays.toString(movies));

        // Lambda: Sort by name length, nulls first
        System.out.println("\nSorted by Name Length (Nulls First):");
        Arrays.sort(movies, (m1, m2) -> {
            if (m1.name == null && m2.name == null) return 0;
            if (m1.name == null) return -1;
            if (m2.name == null) return 1;
            return Integer.compare(m1.name.length(), m2.name.length());
        });
        System.out.println(Arrays.toString(movies));
    }

    /**
     * Internal Implementation Details:
     * - Comparable (compareTo): Invoked by Arrays.sort() for year comparison. Uses Integer.compare() to return -1, 0,
     *   or 1, avoiding overflow. TimSort (O(n log n)) compares pairs iteratively.
     * - Comparator (lambdas): Defines custom ordering (rating, name length). Lambdas generate synthetic classes, reused
     *   during sort. NullsLast handles null names safely.
     * - Object Creation: Sorting reorders array references, no new MovieImpl objects created. Lambda comparators are
     *   compiled to synthetic classes at runtime.
     * - JVM Behavior: TimSort optimizes for partially sorted data, reducing comparisons. NullPointerException is avoided
     *   via nullsLast. compareTo() assumes non-null objects; null MovieImpls would throw an exception.
     * - Memory: TimSort uses O(n) auxiliary space for merging. No additional MovieImpl objects allocated.
     *
     * Professional Practices:
     * - Use generics (Comparable<MovieImpl>, Comparator<MovieImpl>) for type safety, eliminating casts.
     * - Ensure immutability with final fields to prevent sorting inconsistencies.
     * - Handle nulls with nullsLast or explicit checks to avoid NullPointerException.
     * - Use utility methods (Double.compare, Integer.compare) for precise, overflow-safe comparisons.
     * - Provide getters for method references in lambda-based sorting (e.g., MovieImpl::getRating).
     * - Format toString for debugging (e.g., Movie{name='Inception', ...}).
     * - Test edge cases like null names and equal years for robustness.
     *
     * Notes for Mastery:
     * - Comparable defines a single natural ordering (year), ideal for default sorting in collections like TreeSet.
     * - Comparator supports flexible sorting (rating, name length), enabling dynamic criteria.
     * - Multi-field sorting (rating then name) ensures deterministic results for ties.
     * - Null handling is critical for robust production code.
     * - Lambda comparators with Comparator.comparing provide concise, readable syntax.
     * - Avoid subtraction (e.g., this.year - m.year) to prevent overflow; use compare methods.
     * - Understand TimSort’s efficiency for real-world sorting performance.
     */
}