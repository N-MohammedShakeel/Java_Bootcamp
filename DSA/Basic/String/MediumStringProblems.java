package Java_Bootcamp.DSA.Basic.String;

import java.util.*;

public class MediumStringProblems {
    public static void main(String[] args) {
        // Test cases for medium string problems
        System.out.println("1. Longest Substring Without Repeating: " + lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println("2. Group Anagrams: " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})); // [[eat,tea,ate],[tan,nat],[bat]]
        System.out.println("3. Longest Palindromic Substring: " + longestPalindromicSubstring("babad")); // bab or aba
        System.out.println("4. String to Integer (atoi): " + myAtoi("42")); // 42
        System.out.println("5. Reverse Words in a String: " + reverseWords("  hello world  ")); // world hello
        System.out.println("6. Valid Parentheses: " + isValidParentheses("()[]{}")); // true
        System.out.println("7. Longest Common Prefix: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println("8. Find First Occurrence: " + strStr("hello", "ll")); // 2
        System.out.println("9. Remove Duplicates from Sorted String: " + removeDuplicates("abbaca")); // abca
        System.out.println("10. Check if Strings are Rotations: " + areRotations("waterbottle", "erbottlewat")); // true
    }

    // 1. Longest Substring Without Repeating Characters
    // Time: O(n), Space: O(min(m,n)) where m is charset size
    // LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            } else {
                maxLen = Math.max(maxLen, i - start + 1);
            }
            map.put(c, i);
        }
        return maxLen;
    }

    // 2. Group Anagrams
    // Time: O(n*k*log(k)) where n is number of strings, k is max string length
    // Space: O(n*k)
    // LeetCode: https://leetcode.com/problems/group-anagrams/
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

    // 3. Longest Palindromic Substring
    // Time: O(n^2), Space: O(1)
    // LeetCode: https://leetcode.com/problems/longest-palindromic-substring/
    public static String longestPalindromicSubstring(String s) {
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // odd length
            int len2 = expandAroundCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // 4. String to Integer (atoi)
    // Time: O(n), Space: O(1)
    // LeetCode: https://leetcode.com/problems/string-to-integer-atoi/
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1, i = 0;
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') i++;
        long result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (result * sign);
    }

    // 5. Reverse Words in a String
    // Time: O(n), Space: O(n)
    // LeetCode: https://leetcode.com/problems/reverse-words-in-a-string/
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    // 6. Valid Parentheses
    // Time: O(n), Space: O(n)
    // LeetCode: https://leetcode.com/problems/valid-parentheses/
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.isEmpty() || !matches(stack.pop(), c)) return false;
        }
        return stack.isEmpty();
    }
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }

    // 7. Longest Common Prefix
    // Time: O(n*m) where n is number of strings, m is min string length
    // Space: O(1)
    // LeetCode: https://leetcode.com/problems/longest-common-prefix/
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 8. Find First Occurrence in String
    // Time: O(n*m), Space: O(1)
    // LeetCode: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // 9. Remove Duplicates from Sorted String
    // Time: O(n), Space: O(n)
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 10. Check if Strings are Rotations
    // Time: O(n), Space: O(n)
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }
}