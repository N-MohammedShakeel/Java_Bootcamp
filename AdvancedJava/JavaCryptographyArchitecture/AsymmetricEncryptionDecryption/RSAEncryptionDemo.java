package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.AsymmetricEncryptionDecryption;// Java Fundamentals: Cryptography - RSA Encryption/Decryption
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
RSA Encryption Overview
----------------------
- RSA is an asymmetric encryption algorithm using a public key for encryption and a private key for decryption.
- Key Sizes: Typically 2048 or 4096 bits (2048 used here).
- JCA Components:
  - KeyPairGenerator: Generates public/private key pairs.
  - Cipher: Performs encryption and decryption.
  - PublicKey, PrivateKey: Represent RSA keys.
- Process:
  1. Generate a public/private key pair.
  2. Encrypt with the public key; decrypt with the private key.
  3. Use Cipher with RSA/ECB/PKCS1Padding for secure padding.
- Use Cases:
  - Secure key exchange (e.g., SSL/TLS).
  - Digital signatures for authentication.
  - Encrypting small data (e.g., symmetric keys).
- Notes:
  - RSA is slower than AES; use for small data or key exchange.
  - Store private keys securely; public keys can be shared.
  - Use secure padding (e.g., PKCS1Padding) to prevent attacks.
*/

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;

public class RSAEncryptionDemo {
    public static void main(String[] args) {
        try {
            // Generate RSA key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048); // 2048-bit key
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Example 1: Encrypting a Message
            System.out.println("Example 1: RSA Encryption");
            String plaintext = "Confidential Data";
            String encrypted = encrypt(plaintext, publicKey);
            System.out.println("Plaintext: " + plaintext);
            System.out.println("Encrypted (Base64): " + encrypted);

            // Example 2: Decrypting the Message
            System.out.println("\nExample 2: RSA Decryption");
            String decrypted = decrypt(encrypted, privateKey);
            System.out.println("Encrypted (Base64): " + encrypted);
            System.out.println("Decrypted: " + decrypted);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Helper method to encrypt a string
    private static String encrypt(String plaintext, PublicKey key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Helper method to decrypt a string
    private static String decrypt(String encrypted, PrivateKey key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}