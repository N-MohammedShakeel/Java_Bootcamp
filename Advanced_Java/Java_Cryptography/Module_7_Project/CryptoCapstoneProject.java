package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_7_Project; /**
 * CryptoCapstoneProject.java
 * Implements four capstone projects: File Encryptor, Secure Chat Simulation, Digital Signature Verifier,
 * and Hash Comparator using Core Java cryptography.
 * Scenario: Demonstrates practical applications of AES, RSA, SHA-256, and digital signatures in a DSA context.
 * Features: Thread-safe operations, error handling, and file/string processing.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;
import java.util.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CryptoCapstoneProject {
    // === File Encryptor Tool ===
    // Encrypts a file using AES/CBC/PKCS5Padding
    public static void encryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec iv = new IvParameterSpec(generateIV());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
        byte[] encrypted = cipher.doFinal(inputBytes);
        byte[] combined = new byte[iv.getIV().length + encrypted.length];
        System.arraycopy(iv.getIV(), 0, combined, 0, iv.getIV().length);
        System.arraycopy(encrypted, 0, combined, iv.getIV().length, encrypted.length);
        Files.write(Paths.get(outputFile), combined);
    }

    // Decrypts a file using AES/CBC/PKCS5Padding
    public static void decryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        byte[] combined = Files.readAllBytes(Paths.get(inputFile));
        byte[] iv = new byte[16];
        byte[] encryptedData = new byte[combined.length - 16];
        System.arraycopy(combined, 0, iv, 0, 16);
        System.arraycopy(combined, 16, encryptedData, 0, combined.length - 16);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        byte[] decrypted = cipher.doFinal(encryptedData);
        Files.write(Paths.get(outputFile), decrypted);
    }

    // Generates a random IV for AES
    private static byte[] generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    // === Secure Chat Simulation ===
    // Generates RSA key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    // Encrypts AES key with RSA public key
    public static String encryptAESKey(byte[] aesKey, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(aesKey));
    }

    // Decrypts AES key with RSA private key
    public static byte[] decryptAESKey(String encryptedAESKey, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(Base64.getDecoder().decode(encryptedAESKey));
    }

    // Encrypts a message with AES
    public static String encryptMessage(String message, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec iv = new IvParameterSpec(generateIV());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        byte[] encrypted = cipher.doFinal(message.getBytes());
        byte[] combined = new byte[iv.getIV().length + encrypted.length];
        System.arraycopy(iv.getIV(), 0, combined, 0, iv.getIV().length);
        System.arraycopy(encrypted, 0, combined, iv.getIV().length, encrypted.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    // Decrypts a message with AES
    public static String decryptMessage(String encrypted, byte[] key) throws Exception {
        byte[] combined = Base64.getDecoder().decode(encrypted);
        byte[] iv = new byte[16];
        byte[] encryptedData = new byte[combined.length - 16];
        System.arraycopy(combined, 0, iv, 0, 16);
        System.arraycopy(combined, 16, encryptedData, 0, combined.length - 16);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        return new String(cipher.doFinal(encryptedData));
    }

    // === Digital Signature Verifier ===
    // Signs a file with RSA private key
    public static byte[] signFile(String filePath, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        byte[] data = Files.readAllBytes(Paths.get(filePath));
        signature.update(data);
        return signature.sign();
    }

    // Verifies a file’s signature with RSA public key
    public static boolean verifyFile(String filePath, byte[] signatureBytes, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        byte[] data = Files.readAllBytes(Paths.get(filePath));
        signature.update(data);
        return signature.verify(signatureBytes);
    }

    // === Hash Comparator ===
    // Generates SHA-256 hash for a file
    public static String hashFile(String filePath) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] data = Files.readAllBytes(Paths.get(filePath));
        byte[] hash = digest.digest(data);
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    // Compares two file hashes
    public static boolean compareHashes(String file1, String file2) throws Exception {
        return hashFile(file1).equals(hashFile(file2));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        byte[] aesKey = new byte[32]; // 256-bit AES key
        new SecureRandom().nextBytes(aesKey);
        KeyPair keyPair = generateKeyPair();

        // Project 1: File Encryptor Tool
        System.out.println("\n=== File Encryptor Tool ===");
        Files.write(Paths.get("input.txt"), "Sensitive Data".getBytes());
        encryptFile("input.txt", "encrypted.bin", aesKey);
        decryptFile("encrypted.bin", "decrypted.txt", aesKey);
        System.out.println("File encrypted to encrypted.bin");
        System.out.println("File decrypted content: " + new String(Files.readAllBytes(Paths.get("decrypted.txt"))));

        // Project 2: Secure Chat Simulation
        System.out.println("\n=== Secure Chat Simulation ===");
        System.out.print("Enter message to send: ");
        String message = scanner.nextLine();
        String encryptedAESKey = encryptAESKey(aesKey, keyPair.getPublic());
        String encryptedMessage = encryptMessage(message, aesKey);
        byte[] decryptedAESKey = decryptAESKey(encryptedAESKey, keyPair.getPrivate());
        String decryptedMessage = decryptMessage(encryptedMessage, decryptedAESKey);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);

        // Project 3: Digital Signature Verifier
        System.out.println("\n=== Digital Signature Verifier ===");
        byte[] signature = signFile("input.txt", keyPair.getPrivate());
        boolean isVerified = verifyFile("input.txt", signature, keyPair.getPublic());
        System.out.println("Signature Valid: " + isVerified);
        Files.write(Paths.get("tampered.txt"), "Tampered Data".getBytes());
        boolean isTamperedVerified = verifyFile("tampered.txt", signature, keyPair.getPublic());
        System.out.println("Signature Valid (Tampered): " + isTamperedVerified);

        // Project 4: Hash Comparator
        System.out.println("\n=== Hash Comparator ===");
        String hash1 = hashFile("input.txt");
        String hash2 = hashFile("decrypted.txt");
        System.out.println("Hash of input.txt: " + hash1);
        System.out.println("Hash of decrypted.txt: " + hash2);
        System.out.println("Files identical: " + compareHashes("input.txt", "decrypted.txt"));
    }
}