package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.Module_3; /**
 * DiffieHellman.java
 * Implements the Diffie-Hellman Key Exchange algorithm for secure key sharing.
 * Scenario: Establish a shared secret key over an insecure channel in a DSA context.
 * Features: Uses modular exponentiation, supports secure key exchange.
 * DSA Relevance: Modular arithmetic, number theory.
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {
    // Generates a public key from a private key, prime (p), and generator (g)
    public static BigInteger generatePublicKey(BigInteger p, BigInteger g, BigInteger privateKey) {
        return g.modPow(privateKey, p);
    }

    // Generates a shared secret from own private key, other's public key, and prime (p)
    public static BigInteger generateSharedSecret(BigInteger p, BigInteger privateKey, BigInteger otherPublicKey) {
        return otherPublicKey.modPow(privateKey, p);
    }

    public static void main(String[] args) {
        // Example prime (p) and generator (g)
        BigInteger p = new BigInteger("23"); // Small prime for demo
        BigInteger g = new BigInteger("5");  // Generator
        SecureRandom random = new SecureRandom();

        // Alice's private and public keys
        BigInteger alicePrivate = new BigInteger(6, random); // Small random for demo
        BigInteger alicePublic = generatePublicKey(p, g, alicePrivate);

        // Bob's private and public keys
        BigInteger bobPrivate = new BigInteger(6, random); // Small random for demo
        BigInteger bobPublic = generatePublicKey(p, g, bobPrivate);

        // Shared secrets
        BigInteger aliceShared = generateSharedSecret(p, alicePrivate, bobPublic);
        BigInteger bobShared = generateSharedSecret(p, bobPrivate, alicePublic);

        System.out.println("Prime (p): " + p);
        System.out.println("Generator (g): " + g);
        System.out.println("Alice's Public Key: " + alicePublic);
        System.out.println("Bob's Public Key: " + bobPublic);
        System.out.println("Alice's Shared Secret: " + aliceShared);
        System.out.println("Bob's Shared Secret: " + bobShared);
        System.out.println("Shared Secrets Match: " + aliceShared.equals(bobShared));
    }
}