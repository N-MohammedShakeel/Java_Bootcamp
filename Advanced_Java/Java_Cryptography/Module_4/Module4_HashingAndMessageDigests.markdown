# Module 4: Hashing and Message Digests

## 1. Overview
Hashing generates a fixed-size value (hash) from variable-size input using a one-way function, ensuring data integrity. Java’s `java.security.MessageDigest` class supports hashing algorithms like MD5, SHA-1, and SHA-256.

- **Purpose**: Implement hashing for data integrity and password verification.
- **DSA Relevance**: Involves byte array manipulation and bitwise operations, common in DSA.

## 2. Importance of Hashing
- **One-Way Function**: Cannot be reversed to obtain original data.
- **Data Integrity**: Detect changes in data (e.g., file tampering).
- **Password Verification**: Store hashed passwords instead of plaintext.
- **Use Cases**: File checksums, password storage, digital signatures.

## 3. Hashing vs Encryption
- **Hashing**: One-way, produces fixed-size output, no decryption.
- **Encryption**: Reversible, variable-size output, requires keys.

## 4. Java Implementations
### 4.1 MD5 (Insecure, for Learning)
- **Description**: 128-bit hash, fast but vulnerable to collisions.
- **Use Case**: Legacy systems, learning purposes.

### 4.2 SHA-1, SHA-256
- **Description**: SHA-1 (160-bit, deprecated), SHA-256 (256-bit, secure).
- **Use Case**: File integrity, password hashing.

### 4.3 File and String Hashing
- Hash strings or files using `MessageDigest`.
- Convert hash to hexadecimal for readability.

### 4.4 SecureRandom for Salt
- Add random salts to hashes to prevent precomputed attacks (e.g., rainbow tables).

## 5. Best Practices
- Use SHA-256 or stronger for security.
- Add salts for password hashing.
- Use `SecureRandom` for salt generation.
- Handle `NoSuchAlgorithmException`.

## 6. Common Pitfalls
- Using MD5 or SHA-1 for secure applications (vulnerable to collisions).
- Not salting passwords, enabling rainbow table attacks.
- Incorrectly handling byte-to-hex conversion.

## 7. Conclusion
Hashing ensures data integrity and secure password storage. Java’s `MessageDigest` class simplifies implementation, with SHA-256 recommended for modern applications. Salts enhance security for password hashing.