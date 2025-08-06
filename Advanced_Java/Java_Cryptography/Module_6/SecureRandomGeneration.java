package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_6; /**
 * SecureRandomGeneration.java
 * Demonstrates secure random number generation for tokens, passwords, and salts.
 * Scenario: Generate secure OTPs and salts in a DSA context.
 * Features: Uses SecureRandom for cryptographically strong randomness.
 */
import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomGeneration {
    // Generates a secure token (e.g., API key)
    public static String generateToken(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    // Generates a secure OTP (6-digit)
    public static String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = random.nextInt(900000) + 100000; // 6-digit number
        return String.valueOf(otp);
    }

    // Generates a salt for hashing
    public static byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) {
        // Generate token
        String token = generateToken(32);
        System.out.println("Secure Token: " + token);

        // Generate OTP
        String otp = generateOTP();
        System.out.println("Secure OTP: " + otp);

        // Generate salt
        byte[] salt = generateSalt();
        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
    }
}