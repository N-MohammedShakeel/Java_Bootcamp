package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_2; /**
 * DESEncryption.java
 * Demonstrates DES encryption/decryption for strings using CBC mode and PKCS5Padding.
 * Scenario: Legacy system compatibility (DES is insecure; use for learning only).
 * Features: Uses SecureRandom for IV, Base64 for encoding, and simple string encryption.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.security.SecureRandom;

public class DESEncryption {
    private static final String ALGORITHM = "DES";
    private static final String TRANSFORMATION = "DES/CBC/PKCS5Padding";

    // Encrypts a string using DES
    public static String encryptString(String input, byte[] key) throws Exception {
        // Initialize cipher for encryption
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(generateIV());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        // Encrypt and encode to Base64
        byte[] encrypted = cipher.doFinal(input.getBytes());
        byte[] combined = new byte[iv.getIV().length + encrypted.length];
        System.arraycopy(iv.getIV(), 0, combined, 0, iv.getIV().length);
        System.arraycopy(encrypted, 0, combined, iv.getIV().length, encrypted.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    // Decrypts a string using DES
    public static String decryptString(String encrypted, byte[] key) throws Exception {
        // Decode Base64 and extract IV
        byte[] combined = Base64.getDecoder().decode(encrypted);
        byte[] iv = new byte[8];
        byte[] encryptedData = new byte[combined.length - 8];
        System.arraycopy(combined, 0, iv, 0, 8);
        System.arraycopy(combined, 8, encryptedData, 0, combined.length - 8);

        // Initialize cipher for decryption
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // Decrypt and return
        return new String(cipher.doFinal(encryptedData));
    }

    // Generates a random IV (8 bytes for DES)
    private static byte[] generateIV() {
        byte[] iv = new byte[8];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    public static void main(String[] args) throws Exception {
        // 56-bit key (8 bytes)
        byte[] key = new byte[8];
        new SecureRandom().nextBytes(key);

        // String encryption/decryption
        String original = "Hello, DES!";
        String encrypted = encryptString(original, key);
        String decrypted = decryptString(encrypted, key);
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}