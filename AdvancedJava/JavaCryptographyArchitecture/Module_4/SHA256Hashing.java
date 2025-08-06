package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.Module_4; /**
 * SHA256Hashing.java
 * Demonstrates SHA-256 hashing with salt for strings.
 * Scenario: Secure password hashing or file integrity in a DSA context.
 * Features: Uses SecureRandom for salt, MessageDigest for hashing.
 */
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SHA256Hashing {
    // Generates SHA-256 hash with salt for a string
    public static String hashString(String input, byte[] salt) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt); // Add salt
        byte[] hash = digest.digest(input.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    // Generates a random salt
    public static byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws Exception {
        String input = "Password123";
        byte[] salt = generateSalt();
        String hash = hashString(input, salt);
        System.out.println("Input: " + input);
        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
        System.out.println("SHA-256 Hash: " + hash);
    }
}