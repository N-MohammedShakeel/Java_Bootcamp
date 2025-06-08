package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// SearchFeature.java
// Searches for strings starting with a given character
// Time: O(n), Space: O(n)

public class SearchFeature {
    public static void main(String[] args) {
        // Test case
        System.out.println("Search Feature: ");
        searchFeature(new Scanner("3\napple\nbanana\ncherry\nb\n")); // banana
    }

    // Searches for strings starting with a given character
    // Time: O(n), Space: O(n)
    public static void searchFeature(Scanner sc) {
        int size = sc.nextInt();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }
        char ch = sc.next().toLowerCase().charAt(0);
        boolean isPresent = false;
        for (String s : arr) {
            if (s != null && s.toLowerCase().charAt(0) == ch) {
                System.out.println(s);
                isPresent = true;
            }
        }
        if (!isPresent) {
            System.out.println("No match");
        }
    }
}