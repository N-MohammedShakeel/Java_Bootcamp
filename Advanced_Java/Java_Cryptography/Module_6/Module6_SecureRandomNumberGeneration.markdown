# Module 6: Secure Random Number Generation

## 1. Overview
Secure random number generation is critical for cryptographic operations like key generation, IVs, and salts. Java’s `java.security.SecureRandom` class provides cryptographically strong random numbers, unlike `java.util.Random`.

- **Purpose**: Implement secure random number generation for tokens, passwords, and salts.
- **DSA Relevance**: Involves random data generation, relevant to randomized algorithms in DSA.

## 2. Importance of Randomness
- **Security**: Prevents predictable keys or salts, mitigating attacks (e.g., brute force).
- **Use Cases**: Generating keys, IVs, OTPs, API tokens, and password salts.

## 3. Random vs SecureRandom
- **Random**: Fast, predictable, unsuitable for cryptography.
- **SecureRandom**: Slower, cryptographically secure, uses system entropy.

## 4. Java Implementations
- **Classes**: `SecureRandom`.
- **Process**:
  1. Initialize `SecureRandom`.
  2. Generate random bytes for tokens, OTPs, or salts.
- **Use Cases**: Password salts, session tokens, OTP generation.

## 5. Best Practices
- Always use `SecureRandom` for cryptographic purposes.
- Avoid seeding `SecureRandom` manually (uses system entropy).
- Handle performance (slower than `Random` but secure).

## 6. Common Pitfalls
- Using `Random` for cryptographic operations.
- Reusing random values (e.g., same salt for multiple hashes).
- Blocking on low-entropy systems.

## 7. Conclusion
`SecureRandom` ensures secure randomness for cryptographic operations. It is essential for generating keys, IVs, and salts, enhancing the security of encryption and hashing.