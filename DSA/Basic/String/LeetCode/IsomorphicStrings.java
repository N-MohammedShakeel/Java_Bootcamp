package Java_Bootcamp.DSA.Basic.String.LeetCode;

// Problem Link: https://leetcode.com/problems/isomorphic-strings/

// --- Problem Statement ---
// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if characters in s can be replaced to get t,
// preserving the order, with a one-to-one mapping between characters.
// No two characters in s can map to the same character in t unless they are the same character.

// --- Examples ---
// Input: s = "egg", t = "add"  -> Output: true
// Explanation: 'e' -> 'a', 'g' -> 'd'

// Input: s = "foo", t = "bar"  -> Output: false
// Explanation: 'o' cannot map to two different characters ('a' and 'r')

// Input: s = "paper", t = "title" -> Output: true

// --- Approach (Two HashMaps) ---
// 1. Use two HashMaps to store character mappings from s->t and t->s.
// 2. Iterate through characters of s and t in parallel.
// 3. For each character pair:
//    - Check if mapping already exists in both maps and is consistent.
//    - If inconsistent mapping found, return false.
//    - Else, add the mapping.
// 4. If all pairs are consistent, return true.

// --- Time Complexity ---
// O(n), where n is the length of the strings (single pass)

// --- Space Complexity ---
// O(1) because the hashmap keys are limited by character set size (usually 256 ASCII).

// --- Optimal Alternative Approach (One HashMap + HashSet) ---
// 1. Use one HashMap to map s->t characters.
// 2. Use a HashSet to keep track of already mapped characters in t to avoid duplicates.
// 3. Similar logic but slightly less memory for second map.

// --- Code Implementation ---

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    // Method using two hashmaps for bi-directional mapping
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) return false;
            } else {
                map2.put(c2, c1);
            }
        }

        return true;
    }

    // Example test cases
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
    }
}
