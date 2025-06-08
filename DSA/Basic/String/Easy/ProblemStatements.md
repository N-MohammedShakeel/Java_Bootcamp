Easy String Problems - Problem Statements

1. Reverse String
   Reverses the input string using StringBuilder for efficiency.
   Input: A string (e.g., "hello")
   Output: The reversed string (e.g., "olleh")
   Time: O(n), Space: O(n)

2. Check Palindrome (Method 1)
   Checks if a string is a palindrome by comparing characters from both ends, ignoring non-alphanumeric characters.
   Input: A string (e.g., "radar")
   Output: True if palindrome, false otherwise
   Time: O(n), Space: O(1)

3. Check Palindrome (Method 2)
   Filters alphanumeric characters, then checks if the string is a palindrome.
   Input: A string (e.g., "A man, a plan, a canal: Panama")
   Output: True if palindrome, false otherwise
   Time: O(n), Space: O(n)

4. Count Vowels (Method 1)
   Counts vowels in a string by checking each character.
   Input: A string (e.g., "apple")
   Output: Number of vowels (e.g., 2)
   Time: O(n), Space: O(1)

5. Count Vowels (Method 2)
   Counts vowels using an ArrayList to track vowels.
   Input: A string (e.g., "apple")
   Output: Number of vowels (e.g., 2)
   Time: O(n), Space: O(1)

6. To Upper Case
   Converts a string to uppercase using the built-in method.
   Input: A string (e.g., "hello")
   Output: The uppercase string (e.g., "HELLO")
   Time: O(n), Space: O(n)

7. To Lower Case
   Converts a string to lowercase using the built-in method.
   Input: A string (e.g., "HELLO")
   Output: The lowercase string (e.g., "hello")
   Time: O(n), Space: O(n)

8. Check Anagram
   Checks if two strings are anagrams using character frequency.
   Input: Two strings (e.g., "listen", "silent")
   Output: True if anagrams, false otherwise
   Time: O(n), Space: O(1)

9. First Non-Repeating Character
   Finds the first character that appears only once in a string.
   Input: A string (e.g., "aabbc")
   Output: The first non-repeating character (e.g., 'c') or '#' if none
   Time: O(n), Space: O(1)

10. Remove Spaces
    Removes all spaces from a string using regex.
    Input: A string (e.g., "  hello  world  ")
    Output: The string without spaces (e.g., "helloworld")
    Time: O(n), Space: O(n)

11. Count Occurrences
    Counts occurrences of a specific character in a string.
    Input: A string and a character (e.g., "hello", 'l')
    Output: Number of occurrences (e.g., 2)
    Time: O(n), Space: O(1)

12. Is Substring
    Checks if a given string is a substring of another string.
    Input: Two strings (e.g., "hello world", "world")
    Output: True if substring, false otherwise
    Time: O(n+m), Space: O(1)

13. Valid OTP (Method 1)
    Checks if a string is a valid OTP (digits only) using regex.
    Input: A string (e.g., "1234")
    Output: True if valid OTP, false otherwise
    Time: O(n), Space: O(1)

14. Valid OTP (Method 2)
    Checks if a string is a valid OTP by verifying each character is a digit.
    Input: A string (e.g., "1234")
    Output: True if valid OTP, false otherwise
    Time: O(n), Space: O(1)

15. Reverse (Manual)
    Reverses a string manually by building a new string.
    Input: A string (e.g., "hello")
    Output: The reversed string (e.g., "olleh") or error message if empty
    Time: O(n), Space: O(n)

16. Print String Characters
    Prints each character of a string in multiple ways.
    Input: None (uses hardcoded string "Hello")
    Output: Prints each character individually and as array
    Time: O(n), Space: O(1)

17. String Split
    Splits a string based on a delimiter and prints the result.
    Input: None (uses hardcoded string "Hello world")
    Output: Array of substrings (e.g., [He, , o wor, d])
    Time: O(n), Space: O(n)

18. Binary Conversion
    Converts a decimal number to a binary string.
    Input: A positive integer (e.g., 13)
    Output: The binary representation (e.g., "1101")
    Time: O(log n), Space: O(log n)