package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_4; /**
 * MD5Hashing.java
 * Demonstrates MD5 hashing for strings (insecure, for learning only).
 * Scenario: Generate hashes for data integrity in a DSA context.
 * Features: Uses MessageDigest, converts hash to hexadecimal.
 */
import java.security.MessageDigest;

public class MD5Hashing {
    // Generates MD5 hash for a string
    public static String hashString(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
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
        System.out.println("MD5 Hash: " + hash);
    }
}