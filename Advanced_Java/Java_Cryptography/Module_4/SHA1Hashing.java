package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_4; /**
 * SHA1Hashing.java
 * Demonstrates SHA-1 hashing for strings (deprecated for security, for learning).
 * Scenario: Generate hashes for data integrity in a DSA context.
 * Features: Uses MessageDigest, converts hash to hexadecimal.
 */
import java.security.MessageDigest;

public class SHA1Hashing {
    // Generates SHA-1 hash for a string
    public static String hashString(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] hash = digest.digest(input.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    public static void main(String[] args) throws Exception {
        String input = "Hello, World!";
        String hash = hashString(input);
        System.out.println("Input: " + input);
        System.out.println("SHA-1 Hash: " + hash);
    }
}