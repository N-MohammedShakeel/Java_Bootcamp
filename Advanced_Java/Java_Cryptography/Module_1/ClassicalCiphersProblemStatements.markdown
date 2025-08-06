# Problem Statements and Approaches for Classical Ciphers in Core Java

## Overview
This document outlines problem statements and solution approaches for implementing four classical cryptographic ciphers—Caesar Cipher, Playfair Cipher, Hill Cipher, and Vigenère Cipher—using Core Java. These ciphers are foundational to understanding cryptography and align with **Module 1: Introduction to Cryptography** from the `CryptographyInJavaGuide.md`. Each section includes a problem statement, a detailed approach to solving it, and its relevance to Data Structures and Algorithms (DSA) concepts such as string manipulation, matrix operations, and modular arithmetic. The implementations focus on simplicity, clarity, and educational value, using only Core Java without external libraries.

---

## Module 1: Introduction to Cryptography
The following ciphers fit within **Module 1: Introduction to Cryptography**, as they represent historical encryption techniques that introduce key cryptographic concepts like substitution (monoalphabetic and polyalphabetic) and matrix-based encryption. These ciphers are vulnerable to attacks like frequency analysis but are excellent for learning the evolution of cryptography and applying DSA concepts.

---

### 1. Caesar Cipher

#### Problem Statement
Design a Java program to implement the Caesar Cipher, a monoalphabetic substitution cipher that encrypts a message by shifting each letter in the plaintext by a fixed number of positions in the alphabet. The program should:
- Accept a plaintext string and a shift value (integer) as input.
- Encrypt the plaintext by shifting each letter by the given value, preserving case and non-alphabetic characters.
- Decrypt the ciphertext by reversing the shift to retrieve the original plaintext.
- Handle edge cases such as empty strings, invalid shifts, and non-alphabetic characters.
- Example: For plaintext "Hello, World!" and shift 3, the ciphertext is "Khoor, Zruog!".

#### Approach
1. **Input Processing**:
   - Accept a plaintext string and an integer shift value.
   - Normalize the shift value using modulo 26 to handle large or negative shifts.
2. **Encryption**:
   - Iterate through each character in the plaintext.
   - For alphabetic characters, determine the base ('A' for uppercase, 'a' for lowercase).
   - Apply the shift: `(char - base + shift) % 26 + base` to get the new character.
   - Preserve non-alphabetic characters (e.g., spaces, punctuation) without modification.
   - Build the ciphertext using a `StringBuilder` for efficiency.
3. **Decryption**:
   - Use the same encryption logic with a reverse shift: `26 - (shift % 26)`.
   - This reverses the encryption process to retrieve the plaintext.
4. **Edge Cases**:
   - Handle empty strings by returning an empty string.
   - Normalize negative or large shifts using modulo 26.
   - Preserve case and non-alphabetic characters to maintain input integrity.
5. **Implementation Details**:
   - Use `Character.isLetter()` and `Character.isUpperCase()` for case handling.
   - Use `StringBuilder` to optimize string concatenation (O(n) vs O(n²) for string addition).
   - Test with sample inputs like "Hello, World!" (shift 3) and edge cases (empty string, shift 0).

#### DSA Relevance
- **String Manipulation**: Iterating and transforming characters in a string.
- **Modular Arithmetic**: Using modulo 26 to wrap around the alphabet, a common DSA technique in cyclic operations.
- **Efficiency**: Using `StringBuilder` to avoid quadratic time complexity in string concatenation.

#### Module Fit
The Caesar Cipher fits **Module 1** as it introduces monoalphabetic substitution, a foundational cryptographic concept. Its simplicity makes it ideal for understanding encryption basics and vulnerabilities (e.g., frequency analysis).

---

### 2. Playfair Cipher

#### Problem Statement
Develop a Java program to implement the Playfair Cipher, a digraph substitution cipher that encrypts pairs of letters using a 5x5 key matrix derived from a keyword. The program should:
- Accept a plaintext string and a keyword as input.
- Generate a 5x5 matrix by combining unique letters from the keyword and the remaining alphabet (excluding 'J', merging 'I'/'J').
- Preprocess the plaintext into digraphs, inserting 'X' between identical letters and at the end if needed.
- Encrypt digraphs based on their positions in the matrix (same row, same column, or rectangle rules).
- Decrypt the ciphertext to retrieve the original plaintext.
- Display the key matrix for verification.
- Example: For plaintext "instruments" and key "Monarchy", the ciphertext is "gatlmzclrqoh".

#### Approach
1. **Key Matrix Generation**:
   - Convert the keyword to uppercase, remove non-alphabetic characters, and replace 'J' with 'I'.
   - Use a `LinkedHashSet` to store unique letters from the keyword, followed by the remaining alphabet (A-Z, excluding 'J').
   - Populate a 5x5 `char` matrix using the iterator of the set.
2. **Text Preprocessing**:
   - Convert plaintext to uppercase, remove non-alphabetic characters, and replace 'J' with 'I'.
   - Form digraphs (pairs of letters):
     - If two letters are the same, insert 'X' between them.
     - If the length is odd, append 'X' to the last digraph.
   - Store digraphs in a `List<String>` for processing.
3. **Encryption**:
   - For each digraph, find the positions of both letters in the matrix.
   - Apply Playfair rules:
     - **Same Row**: Replace each letter with the letter to its right (mod 5).
     - **Same Column**: Replace each letter with the letter below it (mod 5).
     - **Rectangle**: Swap the column indices of the two letters.
   - Build the ciphertext using a `StringBuilder`.
4. **Decryption**:
   - Use the same matrix and digraph preprocessing.
   - Reverse the encryption rules:
     - **Same Row**: Shift left (mod 5, equivalent to +4).
     - **Same Column**: Shift up (mod 5, equivalent to +4).
     - **Rectangle**: Same as encryption (swap column indices).
5. **Matrix Display**:
   - Print the 5x5 matrix for debugging and verification.
6. **Edge Cases**:
   - Handle empty plaintext or key by returning an empty string or throwing an exception.
   - Ensure the keyword generates a valid matrix (at least one letter).
   - Handle single-letter inputs by padding with 'X'.
7. **Implementation Details**:
   - Use `LinkedHashSet` to maintain insertion order and uniqueness (O(1) lookup).
   - Use `List<String>` for digraphs to simplify processing.
   - Test with inputs like "instruments" (key "Monarchy") and edge cases (empty string, single letter).

#### DSA Relevance
- **Matrix Operations**: Constructing and accessing a 5x5 matrix for encryption/decryption.
- **Set Data Structure**: Using `LinkedHashSet` for unique letters, demonstrating set operations.
- **String Manipulation**: Preprocessing text into digraphs, handling edge cases.
- **Modular Arithmetic**: Using modulo 5 for row/column shifts, aligning with cyclic operations.

#### Module Fit
The Playfair Cipher fits **Module 1** as it introduces polygraphic substitution, building on the Caesar Cipher. Its matrix-based approach and historical significance make it ideal for understanding early cryptographic techniques and their DSA applications.

---

### 3. Hill Cipher

#### Problem Statement
Create a Java program to implement the Hill Cipher, a polygraphic substitution cipher that encrypts blocks of letters using matrix multiplication and modular arithmetic. The program should:
- Accept a plaintext string and a 2x2 key matrix (with integers) as input.
- Encrypt the plaintext by converting letter pairs into vectors, multiplying by the key matrix, and applying modulo 26.
- Decrypt the ciphertext by computing the inverse of the key matrix and applying the reverse transformation.
- Handle edge cases such as non-invertible matrices, odd-length plaintext, and non-alphabetic characters.
- Example: For plaintext "meetme" and key matrix [[9, 4], [5, 7]], the ciphertext is "pswxpn".

#### Approach
1. **Input Processing**:
   - Convert plaintext to lowercase and remove non-alphabetic characters.
   - If the plaintext length is odd, append 'x' to make it even.
   - Accept a 2x2 key matrix as a 2D integer array, ensuring it is invertible modulo 26 (determinant must have a modular inverse).
2. **Encryption**:
   - Divide the plaintext into pairs of letters.
   - Convert each pair to a vector (e.g., 'ab' → [0, 1], where 'a'=0, 'b'=1).
   - Multiply the vector by the key matrix: `[x', y'] = key * [x, y]`.
   - Apply modulo 26 to each result and convert back to letters (0='a', 1='b', etc.).
   - Build the ciphertext using a `StringBuilder`.
3. **Decryption**:
   - Compute the modular inverse of the key matrix:
     - Calculate the determinant: `det = (key[0][0] * key[1][1] - key[0][1] * key[1][0]) % 26`.
     - Find the modular inverse of the determinant modulo 26 using the extended Euclidean algorithm.
     - Compute the inverse matrix: `inverse = (1/det) * adjugate matrix (mod 26)`.
   - Encrypt the ciphertext with the inverse matrix to retrieve the plaintext.
4. **Edge Cases**:
   - Check if the key matrix is invertible (determinant must have a modular inverse modulo 26).
   - Handle empty plaintext by returning an empty string.
   - Pad odd-length plaintext with 'x'.
   - Throw an exception for non-invertible matrices.
5. **Implementation Details**:
   - Use a 2D `int` array for the key matrix.
   - Implement a `modInverse` function to find the modular inverse of the determinant.
   - Use `StringBuilder` for efficient string building.
   - Test with inputs like "meetme" (key [[9, 4], [5, 7]]) and edge cases (non-invertible matrix, empty string).

#### DSA Relevance
- **Matrix Operations**: Matrix multiplication and inversion for encryption/decryption.
- **Modular Arithmetic**: Applying modulo 26 for vector transformations and matrix inversion.
- **Linear Algebra**: Using matrix concepts like determinants and adjugates, common in DSA.
- **String Manipulation**: Preprocessing text into letter pairs.

#### Module Fit
The Hill Cipher fits **Module 1** as it introduces polygraphic substitution using linear algebra, extending simpler ciphers like Caesar and Playfair. Its matrix-based approach highlights mathematical foundations of cryptography and DSA relevance.

---

### 4. Vigenère Cipher

#### Problem Statement
Implement a Java program for the Vigenère Cipher, a polyalphabetic substitution cipher that uses a keyword to apply multiple Caesar shifts to the plaintext. The program should:
- Accept a plaintext string and a keyword as input.
- Encrypt the plaintext by shifting each letter based on the corresponding letter in the repeated keyword.
- Decrypt the ciphertext by reversing the shifts to retrieve the original plaintext.
- Handle edge cases such as empty strings, non-alphabetic characters, and invalid keywords.
- Example: For plaintext "geeksforgeeks" and key "ayush", the ciphertext is "gcyczfmlyleim".

#### Approach
1. **Input Processing**:
   - Convert plaintext and keyword to lowercase, removing non-alphabetic characters.
   - Validate the keyword (must contain at least one letter).
2. **Encryption**:
   - Repeat the keyword to match the length of the plaintext.
   - For each plaintext letter, compute the shift based on the corresponding keyword letter (e.g., 'a'=0, 'b'=1, etc.).
   - Apply a Caesar shift: `(plaintext[i] - 'a' + key[i] - 'a') % 26 + 'a'`.
   - Build the ciphertext using a `StringBuilder`.
3. **Decryption**:
   - Use the same keyword repetition.
   - Reverse the shift: `(ciphertext[i] - 'a' - (key[i] - 'a') + 26) % 26 + 'a'`.
   - Build the plaintext using a `StringBuilder`.
4. **Edge Cases**:
   - Handle empty plaintext or keyword by returning an empty string or throwing an exception.
   - Remove non-alphabetic characters from inputs.
   - Ensure keyword is non-empty to avoid division-by-zero-like errors in repetition.
5. **Implementation Details**:
   - Use `String.replaceAll("[^a-z]", "")` to clean inputs.
   - Use `StringBuilder` for efficient string building.
   - Test with inputs like "geeksforgeeks" (key "ayush") and edge cases (empty string, non-alphabetic keyword).

#### DSA Relevance
- **String Manipulation**: Processing and transforming strings, handling keyword repetition.
- **Modular Arithmetic**: Using modulo 26 for cyclic shifts, similar to Caesar Cipher but with variable shifts.
- **Loop Optimization**: Efficiently repeating the keyword to match plaintext length.

#### Module Fit
The Vigenère Cipher fits **Module 1** as it introduces polyalphabetic substitution, extending the Caesar Cipher with multiple shifts. Its historical significance and use of modular arithmetic make it ideal for learning cryptographic evolution and DSA concepts.

---

## Best Practices
- **Input Validation**: Check for empty strings, invalid keywords, and non-invertible matrices (Hill Cipher).
- **Efficiency**: Use `StringBuilder` for string concatenation and appropriate data structures (e.g., `LinkedHashSet` for Playfair).
- **Error Handling**: Throw meaningful exceptions for invalid inputs (e.g., non-invertible matrix, empty keyword).
- **Modularity**: Structure code with reusable methods for encryption, decryption, and helper functions.
- **Testing**: Test with standard inputs (e.g., "Hello, World!", "instruments") and edge cases (empty strings, single letters).

## Common Pitfalls
- **Ignoring Case Sensitivity**: Failing to handle uppercase/lowercase consistently (e.g., Caesar, Vigenère).
- **Incorrect Matrix Handling**: Not ensuring matrix invertibility (Hill) or unique letters (Playfair).
- **Non-Alphabetic Characters**: Not properly filtering or preserving non-alphabetic characters.
- **Hardcoding Values**: Using fixed keys or matrices without user input flexibility.
- **Inefficient String Operations**: Using string concatenation instead of `StringBuilder`.

## Conclusion
These classical ciphers provide a foundation for understanding cryptographic principles and their implementation in Core Java. The Caesar, Playfair, Hill, and Vigenère Ciphers align with **Module 1: Introduction to Cryptography**, introducing substitution techniques and their historical context. Their implementation involves DSA concepts like string manipulation, matrix operations, and modular arithmetic, making them valuable for educational purposes. The provided approaches ensure robust, efficient, and clear solutions suitable for learning and experimentation.