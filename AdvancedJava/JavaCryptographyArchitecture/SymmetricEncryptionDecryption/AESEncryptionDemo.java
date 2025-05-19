package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.SymmetricEncryptionDecryption;// Java Fundamentals: Cryptography - AES Encryption/Decryption
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
AES Encryption Overview
----------------------
- AES (Advanced Encryption Standard) is a symmetric encryption algorithm using the same key for encryption and decryption.
- Key Sizes: 128, 192, or 256 bits (128-bit is common).
- Modes: ECB, CBC, GCM (CBC used here with PKCS5Padding for secure block handling).
- JCA Components:
  - KeyGenerator: Generates a symmetric key.
  - Cipher: Performs encryption and decryption.
  - SecretKey: Represents the AES key.
- Process:
  1. Generate or use a secret key.
  2. Initialize Cipher in ENCRYPT_MODE or DECRYPT_MODE with key and IV (if needed).
  3. Encrypt/decrypt data using doFinal().
- Use Cases:
  - Secure data storage (e.g., files, databases).
  - Secure communication (e.g., HTTPS, VPN).
- Notes:
  - Store keys securely (e.g., in a KeyStore).
  - Use CBC or GCM modes with an IV for security; avoid ECB.
  - IV (Initialization Vector) ensures different ciphertexts for the same plaintext.
*/

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import java.security.InvalidAlgorithmParameterException;

public class AESEncryptionDemo {
    public static void main(String[] args) {
        try {
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // 128-bit key
            SecretKey secretKey = keyGen.generateKey();

            // Generate Initialization Vector (IV)
            byte[] ivBytes = new byte[16]; // AES block size is 16 bytes
            SecureRandom random = new SecureRandom();
            random.nextBytes(ivBytes);
            IvParameterSpec iv = new IvParameterSpec(ivBytes);

            // Example 1: Encrypting a Message
            System.out.println("Example 1: AES Encryption");
            String plaintext = "Secret Message";
            String encrypted = encrypt(plaintext, secretKey, iv);
            System.out.println("Plaintext: " + plaintext);
            System.out.println("Encrypted (Base64): " + encrypted);

            // Example 2: Decrypting the Message
            System.out.println("\nExample 2: AES Decryption");
            String decrypted = decrypt(encrypted, secretKey, iv);
            System.out.println("Encrypted (Base64): " + encrypted);
            System.out.println("Decrypted: " + decrypted);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Helper method to encrypt a string
    private static String encrypt(String plaintext, SecretKey key, IvParameterSpec iv)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Helper method to decrypt a string
    private static String decrypt(String encrypted, SecretKey key, IvParameterSpec iv)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}