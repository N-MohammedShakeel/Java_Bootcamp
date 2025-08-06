package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.Module_1;

/**
 * CaesarCipher.java
 * Implements the Caesar Cipher, a monoalphabetic substitution cipher that shifts letters by a fixed number.
 * Scenario: Encrypt and decrypt simple messages in a DSA context.
 * Features: Handles uppercase/lowercase letters, preserves non-alphabetic characters, uses modular arithmetic.
 * DSA Relevance: String manipulation, modular arithmetic.
 */
public class CaesarCipher {
    // Encrypts a string using Caesar Cipher with a given shift
    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        shift = shift % 26; // Normalize shift to 0-25
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shifted = (c - base + shift) % 26 + base;
                ciphertext.append((char) shifted);
            } else {
                ciphertext.append(c); // Preserve non-alphabetic characters
            }
        }
        return ciphertext.toString();
    }

    // Decrypts a string using Caesar Cipher with a given shift
    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - (shift % 26)); // Reverse shift
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int shift = 3;
        String encrypted = encrypt(plaintext, shift);
        String decrypted = decrypt(encrypted, shift);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}