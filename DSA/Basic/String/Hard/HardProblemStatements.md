Hard String Problems - Problem Statements

1. Regular Expression Matching
   Implements regex matching with support for '.' and '*'.
   Input: A string and a pattern (e.g., "aab", "c*a*b")
   Output: True if the string matches the pattern, false otherwise (e.g., true)
   Time: O(m*n), Space: O(m*n)

2. Wildcard Matching
   Implements wildcard matching with support for '?' and '*'.
   Input: A string and a pattern (e.g., "adceb", "*a*b")
   Output: True if the string matches the pattern, false otherwise (e.g., true)
   Time: O(m*n), Space: O(m*n)

3. Longest Valid Parentheses
   Finds the length of the longest valid parentheses substring.
   Input: A string of parentheses (e.g., "(())")
   Output: Length of the longest valid substring (e.g., 4)
   Time: O(n), Space: O(n)

4. Word Break
   Checks if a string can be segmented into words from a dictionary.
   Input: A string and a list of words (e.g., "leetcode", ["leet", "code"])
   Output: True if the string can be segmented, false otherwise (e.g., true)
   Time: O(n^2), Space: O(n)

5. Minimum Window Substring
   Finds the smallest substring containing all characters of t.
   Input: Two strings (e.g., "ADOBECODEBANC", "ABC")
   Output: The smallest substring or empty string if none exists (e.g., "BANC")
   Time: O(n), Space: O(m) where m is charset size

6. Edit Distance
   Computes the minimum operations to transform one string to another.
   Input: Two strings (e.g., "horse", "ros")
   Output: Minimum number of operations (e.g., 3)
   Time: O(m*n), Space: O(m*n)

7. Text Justification
   Justifies text by distributing spaces to meet max width.
   Input: An array of words and max width (e.g., ["This", "is", "an", "example", "of", "text", "justification."], 16)
   Output: List of justified lines (e.g., ["This    is    an", "example  of text", "justification.  "])
   Time: O(n^2), Space: O(n)

8. Longest Substring with At Most K Distinct Characters
   Finds the longest substring with at most k distinct characters.
   Input: A string and integer k (e.g., "eceba", 2)
   Output: Length of the longest substring (e.g., 3)
   Time: O(n), Space: O(k)

9. KMP Pattern Search
   Implements Knuth-Morris-Pratt algorithm for pattern searching.
   Input: A text and pattern (e.g., "ABABDABACDABABCABAB", "ABABCABAB")
   Output: Starting index of the pattern or -1 if not found (e.g., 10)
   Time: O(n+m), Space: O(m)

10. Distinct Subsequences
    Counts the number of distinct subsequences of t in s.
    Input: Two strings (e.g., "rabbbit", "rabbit")
    Output: Number of distinct subsequences (e.g., 3)
    Time: O(m*n), Space: O(m*n)

11. Maximum Sum Subarray and Subset
    Finds the subarray with the maximum sum and prints it.
    Input: An integer array (e.g., [-2, 1, -3, 4, -1, 2, 1, -5, 4])
    Output: The subarray with the maximum sum (e.g., "4 -1 2 1")
    Time: O(n^3), Space: O(n^2)

12. Check Balanced Asterisks and Hashes
    Checks if asterisks and hashes are balanced, suggests additions if not.
    Input: A string of asterisks and hashes (e.g., "*#*")
    Output: "Balanced" or suggestion to add characters (e.g., "Balanced")
    Time: O(n), Space: O(1)