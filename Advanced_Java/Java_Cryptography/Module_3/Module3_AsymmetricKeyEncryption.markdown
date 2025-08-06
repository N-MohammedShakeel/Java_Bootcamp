# Module 3: Asymmetric Key Encryption Using Java

## 1. Overview
Asymmetric key encryption uses a pair of keys: a public key for encryption and a private key for decryption. This enables secure key exchange and digital signatures. Java’s `java.security` and `javax.crypto` packages support asymmetric algorithms like RSA.

- **Purpose**: Implement secure data exchange using RSA for encryption/decryption.
- **DSA Relevance**: Involves modular arithmetic and key generation, common in DSA problems.

## 2. Public and Private Key Concepts
- **Public Key**: Shared openly, used to encrypt data.
- **Private Key**: Kept secret, used to decrypt data.
- **Pros**: Eliminates key distribution issues; supports digital signatures.
- **Cons**: Slower than symmetric encryption, limited to small data (e.g., keys).

## 3. Key Generation Using RSA
- **Algorithm**: RSA (Rivest-Shamir-Adleman), based on prime number factorization.
- **Process**:
  1. Generate a key pair using `KeyPairGenerator`.
  2. Use `PublicKey` for encryption, `PrivateKey` for decryption.

## 4. Encryption/Decryption Using RSA
- **Classes**: `KeyPair`, `KeyPairGenerator`, `KeyFactory`, `Cipher`.
- **Process**:
  1. Initialize `Cipher` with public key for encryption, private key for decryption.
  2. Encrypt/decrypt small data (e.g., strings, keys).
- **Use Case**: Secure key exchange, encrypting small messages.

## 5. Java Implementations
### 5.1 RSA Key Generation
- Generate 2048-bit key pairs for security.
- Use `KeyPairGenerator` with algorithm "RSA".

### 5.2 RSA Encryption/Decryption
- Encrypt with public key, decrypt with private key.
- Suitable for small data due to RSA’s size limitations.

## 6. Best Practices
- Use 2048-bit or higher keys for RSA.
- Combine with symmetric encryption (hybrid encryption) for large data.
- Store private keys securely (e.g., `KeyStore`).
- Handle exceptions (`InvalidKeyException`, `BadPaddingException`).

## 7. Common Pitfalls
- Encrypting large data with RSA (use hybrid encryption instead).
- Using weak key sizes (e.g., 512-bit RSA).
- Exposing private keys in code or storage.

## 8. Conclusion
Asymmetric encryption with RSA enables secure key exchange and authentication. Java’s `Cipher` and `KeyPairGenerator` simplify RSA implementation, making it suitable for secure communication and digital signatures.