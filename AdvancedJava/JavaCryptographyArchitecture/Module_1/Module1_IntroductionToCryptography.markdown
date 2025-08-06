# Module 1: Introduction to Cryptography

## 1. Overview
Cryptography secures data and communication by transforming readable data (plaintext) into an unreadable form (ciphertext) using mathematical algorithms. Java’s `java.security` and `javax.crypto` packages provide robust APIs for implementing cryptographic techniques, making Core Java a powerful tool for security applications.

- **Purpose**: Understand the evolution, need, types, and core concepts of cryptography, along with Java’s support for these techniques.
- **DSA Relevance**: Cryptographic algorithms involve bitwise operations, modular arithmetic, and data structures (e.g., byte arrays), aligning with DSA concepts.

## 2. Evolution and Need for Cryptography
- **Evolution**:
  - **Ancient Times**: Simple substitution ciphers (e.g., Caesar cipher).
  - **World War II**: Mechanical encryption (e.g., Enigma machine).
  - **Modern Era**: Advanced algorithms like AES, RSA, and SHA, driven by computational advancements.
- **Need**:
  - **Confidentiality**: Protect data from unauthorized access (e.g., encrypting files).
  - **Integrity**: Ensure data is not altered (e.g., hashing for verification).
  - **Authentication**: Verify identities or data sources (e.g., digital signatures).
  - **Non-Repudiation**: Prevent denial of actions (e.g., signed messages).
- **Use Cases**: Secure network communication (HTTPS), password storage, software signing, and data encryption.

## 3. Types of Cryptographic Techniques
### 3.1 Symmetric Key Encryption
- **Definition**: Uses a single key for both encryption and decryption.
- **Algorithms**: AES, DES, Triple DES.
- **Pros**: Fast, suitable for large data.
- **Cons**: Key distribution is challenging.
- **Use Case**: Encrypting files, secure communication channels.

### 3.2 Asymmetric Key Encryption
- **Definition**: Uses a public key for encryption and a private key for decryption.
- **Algorithms**: RSA, ECC.
- **Pros**: Secure key exchange, supports digital signatures.
- **Cons**: Slower than symmetric encryption.
- **Use Case**: Secure email, key exchange.

### 3.3 Hashing
- **Definition**: Maps data to a fixed-size value (hash) using a one-way function.
- **Algorithms**: MD5, SHA-1, SHA-256.
- **Pros**: Ensures data integrity, fast for verification.
- **Cons**: Not reversible, some algorithms (MD5) are insecure.
- **Use Case**: Password storage, file integrity checks.

## 4. Cryptographic Concepts
- **Plaintext**: Original, readable data (e.g., "Hello").
- **Ciphertext**: Encrypted, unreadable data (e.g., "Xjhlk").
- **Keys**: Secret values used to encrypt/decrypt data.
  - Symmetric: Single key (e.g., AES key).
  - Asymmetric: Public/private key pair (e.g., RSA keys).
- **Cipher Modes**:
  - **ECB (Electronic Codebook)**: Each block encrypted independently (insecure for patterns).
  - **CBC (Cipher Block Chaining)**: Each block depends on the previous, using an IV (more secure).
- **Digital Signatures**: Hash of data encrypted with a private key, verified with a public key.
- **DSA Relevance**: Concepts like keys and cipher modes involve bitwise operations and modular arithmetic, common in DSA.

## 5. Java Support for Cryptography
Java’s `java.security` and `javax.crypto` packages provide APIs for cryptographic operations:
- **Key Classes**:
  - `Cipher`: For encryption/decryption (symmetric/asymmetric).
  - `KeyPairGenerator`: For generating public/private key pairs.
  - `MessageDigest`: For hashing.
  - `Signature`: For digital signatures.
  - `SecureRandom`: For cryptographically secure random numbers.
- **Providers**: Java Cryptography Architecture (JCA) uses providers (e.g., SunJCE) for algorithm implementations.
- **Advantages**: Standardized, portable, and thread-safe APIs.

## 6. Best Practices
- Understand algorithm strengths and weaknesses (e.g., avoid MD5 for security).
- Use secure key sizes (e.g., 256-bit AES, 2048-bit RSA).
- Handle exceptions (`NoSuchAlgorithmException`, `InvalidKeyException`).
- Use `SecureRandom` for key and IV generation.

## 7. Common Pitfalls
- Using insecure algorithms (e.g., DES, MD5).
- Hardcoding keys in source code.
- Ignoring cipher mode vulnerabilities (e.g., ECB).
- Misusing APIs for modern requirements (e.g., using `Vector` for cryptographic data).

## 8. Conclusion
This module provides the foundation for understanding cryptography and its implementation in Core Java. Subsequent modules will dive into practical implementations of symmetric/asymmetric encryption, hashing, digital signatures, and secure random number generation, with a focus on DSA applications.