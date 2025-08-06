package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_5; /**
 * DigitalSignature.java
 * Demonstrates RSA-based digital signing and verification.
 * Scenario: Authenticate messages or software in a DSA context.
 * Features: Uses SHA256withRSA, KeyPair for signing/verification.
 */
import java.security.*;

public class DigitalSignature {
    // Generates RSA key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    // Signs data with private key
    public static byte[] signData(String data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        return signature.sign();
    }

    // Verifies data with public key
    public static boolean verifyData(String data, byte[] signatureBytes, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        return signature.verify(signatureBytes);
    }

    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPair keyPair = generateKeyPair();

        // Sign and verify data
        String data = "Important Message";
        byte[] signature = signData(data, keyPair.getPrivate());
        boolean isVerified = verifyData(data, signature, keyPair.getPublic());
        System.out.println("Data: " + data);
        System.out.println("Signature Valid: " + isVerified);

        // Test tampered data
        String tampered = "Tampered Message";
        isVerified = verifyData(tampered, signature, keyPair.getPublic());
        System.out.println("Tampered Data: " + tampered);
        System.out.println("Signature Valid (Tampered): " + isVerified);
    }
}