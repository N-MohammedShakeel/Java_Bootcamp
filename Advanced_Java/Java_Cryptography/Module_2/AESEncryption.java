package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_2; /**
 * AESEncryption.java
 * Demonstrates AES encryption/decryption for strings and files using CBC mode and PKCS5Padding.
 * Scenario: Securely encrypt and decrypt sensitive data (e.g., user messages, files) in a DSA context.
 * Features: Uses SecureRandom for IV, Base64 for string encoding, and file I/O for file encryption.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.security.SecureRandom;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AESEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    // Encrypts a string using AES
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

    // Decrypts a string using AES
    public static String decryptString(String encrypted, byte[] key) throws Exception {
        // Decode Base64 and extract IV
        byte[] combined = Base64.getDecoder().decode(encrypted);
        byte[] iv = new byte[16];
        byte[] encryptedData = new byte[combined.length - 16];
        System.arraycopy(combined, 0, iv, 0, 16);
        System.arraycopy(combined, 16, encryptedData, 0, combined.length - 16);

        // Initialize cipher for decryption
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // Decrypt and return
        return new String(cipher.doFinal(encryptedData));
    }

    // Encrypts a file using AES
    public static void encryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(generateIV());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
        byte[] encrypted = cipher.doFinal(inputBytes);
        byte[] combined = new byte[iv.getIV().length + encrypted.length];
        System.arraycopy(iv.getIV(), 0, combined, 0, iv.getIV().length);
        System.arraycopy(encrypted, 0, combined, iv.getIV().length, encrypted.length);
        Files.write(Paths.get(outputFile), combined);
    }

    // Decrypts a file using AES
    public static void decryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        byte[] combined = Files.readAllBytes(Paths.get(inputFile));
        byte[] iv = new byte[16];
        byte[] encryptedData = new byte[combined.length - 16];
        System.arraycopy(combined, 0, iv, 0, 16);
        System.arraycopy(combined, 16, encryptedData, 0, combined.length - 16);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        byte[] decrypted = cipher.doFinal(encryptedData);
        Files.write(Paths.get(outputFile), decrypted);
    }

    // Generates a random IV using SecureRandom
    private static byte[] generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    public static void main(String[] args) throws Exception {
        // 256-bit key (32 bytes)
        byte[] key = new byte[32];
        new SecureRandom().nextBytes(key);

        // String encryption/decryption
        String original = "Hello, World!";
        String encrypted = encryptString(original, key);
        String decrypted = decryptString(encrypted, key);
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        // File encryption/decryption (create input.txt first)
        Files.write(Paths.get("input.txt"), original.getBytes());
        encryptFile("input.txt", "encrypted.bin", key);
        decryptFile("encrypted.bin", "decrypted.txt", key);
        System.out.println("File decrypted content: " + new String(Files.readAllBytes(Paths.get("decrypted.txt"))));
    }
}