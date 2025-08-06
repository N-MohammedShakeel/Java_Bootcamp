# Module 5: Digital Signatures and Verification

## 1. Overview
Digital signatures authenticate data and ensure integrity by signing with a private key and verifying with a public key. Java’s `java.security.Signature` class supports digital signatures with algorithms like RSA.

- **Purpose**: Implement signing and verification for secure messaging and software authentication.
- **DSA Relevance**: Involves hashing and asymmetric encryption, aligning with DSA concepts.

## 2. Concept of Digital Signatures
- **Process**:
  1. Hash the data (e.g., using SHA-256).
  2. Sign the hash with a private key.
  3. Verify the signature with the public key.
- **Properties**: Authentication, integrity, non-repudiation.
- **Use Cases**: Software distribution, secure email, blockchain transactions.

## 3. Java Implementations
- **Classes**: `Signature`, `KeyPair`, `PublicKey`, `PrivateKey`.
- **Process**:
  1. Generate RSA key pair.
  2. Sign data with `Signature` and private key.
  3. Verify with `Signature` and public key.

## 4. Best Practices
- Use SHA256withRSA for modern applications.
- Ensure 2048-bit or higher RSA keys.
- Handle exceptions (`InvalidKeyException`, `SignatureException`).
- Use secure key storage.

## 5. Common Pitfalls
- Using weak hash algorithms (e.g., SHA-1).
- Exposing private keys.
- Not verifying signatures before processing data.

## 6. Conclusion
Digital signatures ensure authenticity and integrity. Java’s `Signature` class simplifies RSA-based signing and verification, suitable for secure messaging and software authentication.