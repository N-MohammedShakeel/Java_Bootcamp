package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// GroupAnagrams.java
// Groups strings that are anagrams together
// Time: O(n*k*log(k)), Space: O(n*k)

public class GroupAnagrams {
    public static void main(String[] args) {
        // Test case
        System.out.println("Group Anagrams: " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})); // [[eat,tea,ate],[tan,nat],[bat]]
    }

    // Groups strings that are anagrams together
    // Time: O(n*k*log(k)), Space: O(n*k)
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}