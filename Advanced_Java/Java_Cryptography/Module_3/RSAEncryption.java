package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_3; /**
 * RSAEncryption.java
 * Demonstrates RSA key generation and encryption/decryption for strings.
 * Scenario: Securely encrypt small messages (e.g., API keys) in a DSA context.
 * Features: Uses 2048-bit RSA keys, Base64 encoding for ciphertext.
 */
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class RSAEncryption {
    // Generates RSA key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Secure key size
        return keyGen.generateKeyPair();
    }

    // Encrypts a string using RSA public key
    public static String encryptString(String input, java.security.PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypts a string using RSA private key
    public static String decryptString(String encrypted, java.security.PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decrypted);
    }

    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPair keyPair = generateKeyPair();

        // String encryption/decryption
        String original = "Secret Message";
        String encrypted = encryptString(original, keyPair.getPublic());
        String decrypted = decryptString(encrypted, keyPair.getPrivate());
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}