# Module 7: Hands-on Projects Using Only Core Java

## 1. Overview
This module presents capstone projects to apply cryptographic concepts using Core Java, integrating symmetric/asymmetric encryption, hashing, digital signatures, and secure random number generation. The projects are designed to be practical, DSA-relevant, and implementable without external libraries.

- **Purpose**: Demonstrate real-world applications of cryptography in secure file handling, communication, and verification.
- **Projects**:
  - File Encryptor Tool (AES).
  - Secure Chat Simulation (RSA + AES hybrid).
  - Digital Signature Verifier.
  - Hash Comparator.

## 2. Project Descriptions
### 2.1 File Encryptor Tool
- **Description**: Encrypts and decrypts files using AES with CBC mode and PKCS5Padding.
- **Components**: `Cipher`, `SecretKeySpec`, `IvParameterSpec`, file I/O.
- **Use Case**: Secure file storage in a DSA context (e.g., protecting sensitive data).
- **DSA Relevance**: Involves byte array manipulation and file processing.

### 2.2 Secure Chat Simulation
- **Description**: Simulates text-based secure chat using RSA for key exchange and AES for message encryption (hybrid encryption).
- **Components**: `KeyPairGenerator`, `Cipher` (RSA and AES), `SecureRandom`.
- **Use Case**: Secure messaging in networked applications.
- **DSA Relevance**: Combines multiple algorithms, similar to protocol design in DSA.

### 2.3 Digital Signature Verifier
- **Description**: Signs a file with a private key and verifies it with a public key using SHA256withRSA.
- **Components**: `Signature`, `KeyPair`, file I/O.
- **Use Case**: Software distribution, ensuring file authenticity.
- **DSA Relevance**: Involves hashing and verification, common in security algorithms.

### 2.4 Hash Comparator
- **Description**: Generates and compares SHA-256 hashes of files or strings to verify integrity.
- **Components**: `MessageDigest`, file I/O.
- **Use Case**: File integrity checks, password verification.
- **DSA Relevance**: Uses hashing, a key concept in DSA for data integrity.

## 3. Best Practices
- Use strong algorithms (AES, SHA-256, RSA 2048-bit).
- Securely manage keys and IVs (e.g., store in `KeyStore`).
- Handle all exceptions for robustness.
- Use `SecureRandom` for randomness.
- Test with edge cases (e.g., empty files, large inputs).

## 4. Common Pitfalls
- Hardcoding keys or IVs.
- Using weak algorithms (e.g., MD5, DES).
- Ignoring file I/O errors.
- Not verifying signatures before processing.

## 5. Conclusion
These projects integrate cryptographic concepts into practical applications, reinforcing skills in encryption, hashing, and digital signatures. The combined implementation is provided in a single source file for ease of use.