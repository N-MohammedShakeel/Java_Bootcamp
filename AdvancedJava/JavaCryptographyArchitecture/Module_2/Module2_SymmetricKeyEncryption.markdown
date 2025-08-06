# Module 2: Symmetric Key Encryption Using Java

## 1. Overview
Symmetric key encryption uses a single key for both encryption and decryption, making it fast and efficient for large data. Java’s `javax.crypto` package provides APIs for symmetric encryption algorithms like AES, DES, and Triple DES, using the `Cipher` class and various cipher modes.

- **Purpose**: Learn to implement symmetric encryption for securing data, with a focus on AES (modern) and DES/Triple DES (legacy).
- **DSA Relevance**: Involves byte array manipulation, bitwise operations, and key management, aligning with DSA concepts.

## 2. Concept of Symmetric Encryption
- **Definition**: A single key encrypts and decrypts data.
- **Key Algorithms**:
  - **AES (Advanced Encryption Standard)**: Modern, secure, supports 128/192/256-bit keys.
  - **DES (Data Encryption Standard)**: Legacy, 56-bit key, insecure today.
  - **Triple DES (3DES)**: Applies DES three times, more secure but slower than AES.
- **Pros**: Fast, suitable for bulk data encryption.
- **Cons**: Key distribution is challenging; both parties need the same key securely.

## 3. Cipher Modes
- **ECB (Electronic Codebook)**: Each block encrypted independently (insecure for repeating patterns).
- **CBC (Cipher Block Chaining)**: Each block XORed with the previous ciphertext block, requires an Initialization Vector (IV).
- **Others**: CFB, OFB, CTR (not covered here for brevity).
- **Recommendation**: Use CBC for better security; avoid ECB in production.

## 4. Padding Schemes
- **PKCS5Padding**: Adds padding to ensure data length is a multiple of the block size (e.g., 16 bytes for AES).
- **NoPadding**: Requires manual padding; risky if not handled correctly.
- **Recommendation**: Use PKCS5Padding for simplicity and security.

## 5. Java Implementations
Java provides the `Cipher` class for encryption/decryption, `SecretKeySpec` for key specification, and `IvParameterSpec` for CBC mode.

### 5.1 AES Encryption/Decryption
- **Classes**: `Cipher`, `SecretKeySpec`, `IvParameterSpec`.
- **Process**:
  1. Generate or specify a key (128/192/256 bits).
  2. Initialize `Cipher` in ENCRYPT_MODE or DECRYPT_MODE with key and IV (for CBC).
  3. Encrypt/decrypt data (strings or files).
- **Use Case**: Secure file storage, network communication.

### 5.2 DES / Triple DES
- **Classes**: Similar to AES, but uses DES or DESede algorithms.
- **Process**: Same as AES, but with 56-bit (DES) or 168-bit (Triple DES) keys.
- **Use Case**: Legacy systems compatibility (avoid for new applications).

### 5.3 Encrypting/Decrypting Strings and Files
- Strings: Convert to bytes, encrypt, and encode (e.g., Base64) for storage.
- Files: Read/write bytes using `FileInputStream`/`FileOutputStream`.

## 6. Best Practices
- Use AES with 256-bit keys for modern applications.
- Use CBC mode with a random IV for better security.
- Store IV with ciphertext for decryption.
- Handle exceptions (`InvalidKeyException`, `BadPaddingException`).
- Use `SecureRandom` for key and IV generation.

## 7. Common Pitfalls
- Using ECB mode (vulnerable to pattern attacks).
- Hardcoding keys or IVs.
- Using DES (insecure due to small key size).
- Ignoring padding requirements.

## 8. Conclusion
Symmetric encryption is ideal for fast, secure data processing. Java’s `Cipher` class simplifies AES and DES implementations, with CBC and PKCS5Padding recommended for security. The following source files demonstrate AES, DES, and Triple DES for strings and files.