package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.MessageDigests;// Java Fundamentals: Cryptography - Message Digests (MD5, SHA)
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Java Cryptography Architecture (JCA) Overview
-------------------------------------------
- JCA is a framework in Java for cryptographic operations, part of java.security and javax.crypto packages.
- Key Components:
  - MessageDigest: Generates fixed-length hash values (digests) for data integrity.
  - Cipher: Handles encryption and decryption.
  - KeyGenerator, KeyPairGenerator: Generate symmetric and asymmetric keys.
  - SecureRandom: Provides cryptographically strong random numbers.
- Providers: Implementations of cryptographic algorithms (e.g., SunJCE, BouncyCastle).
- Features:
  - Algorithm independence: Specify algorithms (e.g., "SHA-256") without implementation details.
  - Extensibility: Add custom providers for new algorithms.

Message Digests Overview
-----------------------
- A message digest is a fixed-length hash of input data, used for data integrity and verification.
- Common Algorithms:
  - MD5: 128-bit hash (fast but insecure for cryptographic purposes).
  - SHA-1: 160-bit hash (deprecated for security).
  - SHA-256, SHA-512: Part of SHA-2 family, more secure (256-bit and 512-bit hashes).
- Process:
  1. Create a MessageDigest instance for the desired algorithm.
  2. Update with input data (byte array or stream).
  3. Compute the digest using digest().
- Use Cases:
  - Verify file integrity (e.g., checksums).
  - Store password hashes (with salt for security).
- Notes:
  - Digests are one-way (non-reversible).
  - MD5 and SHA-1 are vulnerable to collisions; use SHA-256 or stronger for security.
*/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class MessageDigestDemo {
    public static void main(String[] args) {
        try {
            // Example 1: MD5 Digest
            System.out.println("Example 1: MD5 Digest");
            String input1 = "Hello, Cryptography!";
            String md5Hash = computeDigest(input1, "MD5");
            System.out.println("Input: " + input1);
            System.out.println("MD5 Hash: " + md5Hash);

            // Example 2: SHA-256 Digest
            System.out.println("\nExample 2: SHA-256 Digest");
            String input2 = "Secure Data";
            String sha256Hash = computeDigest(input2, "SHA-256");
            System.out.println("Input: " + input2);
            System.out.println("SHA-256 Hash: " + sha256Hash);

            // Example 3: SHA-512 Digest
            System.out.println("\nExample 3: SHA-512 Digest");
            String input3 = "Java Cryptography Architecture";
            String sha512Hash = computeDigest(input3, "SHA-512");
            System.out.println("Input: " + input3);
            System.out.println("SHA-512 Hash: " + sha512Hash);

            // Example 4: Verifying Data Integrity
            System.out.println("\nExample 4: Verifying Data Integrity");
            String original = "Test Data";
            String modified = "Test Data!";
            String originalHash = computeDigest(original, "SHA-256");
            String modifiedHash = computeDigest(modified, "SHA-256");
            System.out.println("Original Hash: " + originalHash);
            System.out.println("Modified Hash: " + modifiedHash);
            System.out.println("Data unchanged: " + originalHash.equals(modifiedHash));

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: Algorithm not supported - " + e.getMessage());
        }
    }

    // Helper method to compute a message digest
    private static String computeDigest(String input, String algorithm) throws NoSuchAlgorithmException {
        // Get MessageDigest instance
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        // Convert input string to bytes
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        // Compute digest
        byte[] hashBytes = digest.digest(inputBytes);
        // Convert to hexadecimal format
        return HexFormat.of().formatHex(hashBytes);
    }
}