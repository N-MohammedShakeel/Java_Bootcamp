Medium String Problems - Problem Statements

1. Longest Substring Without Repeating Characters
   Finds the length of the longest substring without repeating characters.
   Input: A string (e.g., "abcabcbb")
   Output: Length of the longest substring without repeating characters (e.g., 3)
   Time: O(n), Space: O(min(m,n)) where m is charset size

2. Group Anagrams
   Groups strings that are anagrams together.
   Input: An array of strings (e.g., ["eat", "tea", "tan", "ate", "nat", "bat"])
   Output: List of grouped anagrams (e.g., [[eat,tea,ate],[tan,nat],[bat]])
   Time: O(n*k*log(k)), Space: O(n*k)

3. Longest Palindromic Substring
   Finds the longest substring that is a palindrome.
   Input: A string (e.g., "babad")
   Output: The longest palindromic substring (e.g., "bab" or "aba")
   Time: O(n^2), Space: O(1)

4. String to Integer (atoi)
   Converts a string to an integer, handling signs and overflow.
   Input: A string (e.g., "42")
   Output: The converted integer (e.g., 42)
   Time: O(n), Space: O(1)

5. Reverse Words in a String
   Reverses the order of words in a string.
   Input: A string (e.g., "  hello world  ")
   Output: The string with words reversed (e.g., "world hello")
   Time: O(n), Space: O(n)

6. Valid Parentheses
   Checks if parentheses are valid using a stack.
   Input: A string (e.g., "()[]{}")
   Output: True if valid, false otherwise
   Time: O(n), Space: O(n)

7. Longest Common Prefix
   Finds the longest common prefix among an array of strings.
   Input: An array of strings (e.g., ["flower", "flow", "flight"])
   Output: The longest common prefix (e.g., "fl")
   Time: O(n*m), Space: O(1)

8. Find First Occurrence in String
   Finds the first occurrence of a substring.
   Input: Two strings (e.g., "hello", "ll")
   Output: Index of first occurrence or -1 (e.g., 2)
   Time: O(n*m), Space: O(1)

9. Remove Duplicates from Sorted String
   Removes adjacent duplicate characters.
   Input: A string (e.g., "abbaca")
   Output: The string with adjacent duplicates removed (e.g., "abca")
   Time: O(n), Space: O(n)

10. Check if Strings are Rotations (Method 1)
    Checks if one string is a rotation of another using concatenation.
    Input: Two strings (e.g., "waterbottle", "erbottlewat")
    Output: True if rotation, false otherwise
    Time: O(n), Space: O(n)

11. Check if Strings are Rotations (Method 2)
    Checks rotation by manually rotating characters.
    Input: Two strings (e.g., "waterbottle", "erbottlewat")
    Output: True if rotation, false otherwise
    Time: O(n^2), Space: O(n)

12. String Clockwise Rotation
    Rotates a string clockwise by k positions.
    Input: A string and rotation count (e.g., "hello", 2)
    Output: The rotated string (e.g., "lohel")
    Time: O(n*k), Space: O(n)

13. Check Banned Words
    Checks if a string contains any banned words.
    Input: A string (e.g., "I hate this")
    Output: True if banned word found, false otherwise
    Time: O(n), Space: O(1)

14. Order Groups of Same Length
    Groups and prints strings of the same length after sorting.
    Input: Input via Scanner (e.g., "3\ncat\ndog\nrat\n")
    Output: Prints grouped strings by length (e.g., "cat rat dog")
    Time: O(n^2 + n*log(n)), Space: O(n)

15. Search Feature
    Searches for strings starting with a given character.
    Input: Input via Scanner (e.g., "3\napple\nbanana\ncherry\nb\n")
    Output: Prints matching strings or "No match" (e.g., "banana")
    Time: O(n), Space: O(n)

16. Generate All Subarrays
    Generates all possible subarrays from an array.
    Input: An integer array (e.g., [1, 2, 3, 4, 5])
    Output: List of subarrays as strings (e.g., [1, 1 2, 1 2 3, 1 2 3 4, 1 2 3 4 5, 2, 2 3, 2 3 4, 2 3 4 5, 3, 3 4, 3 4 5, 4, 4 5, 5])
    Time: O(n^3), Space: O(n^2)

17. Sum of All Subarrays
    Computes the sum of all possible subarrays.
    Input: An integer array (e.g., [-2, 1, -3, 4, -1, 2, 1, -5, 4])
    Output: List of unique subarray sums (e.g., [-2, 1, -3, 4, -1, 2, 1, -5, 4, -1, -2, 2, -4, 5, 0, 6, 1, -1, 5, -5, 1, 2, -2, 6, 1, -3, 3, 4])
    Time: O(n^3), Space: O(n^2)