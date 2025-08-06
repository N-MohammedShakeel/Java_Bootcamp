package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_1;

/**
 * VigenereCipher.java
 * Implements the Vigenère Cipher, a polyalphabetic substitution cipher using a keyword.
 * Scenario: Encrypt and decrypt messages with multiple Caesar shifts in a DSA context.
 * Features: Uses keyword-based shifts, handles alphabetic text.
 * DSA Relevance: String manipulation, modular arithmetic.
 */
public class VigenereCipher {
    // Encrypts a string using Vigenère Cipher with a keyword
    public static String encrypt(String plaintext, String key) {
        plaintext = plaintext.toLowerCase().replaceAll("[^a-z]", "");
        key = key.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char k = key.charAt(i % key.length());
            int shifted = (p - 'a' + (k - 'a')) % 26 + 'a';
            ciphertext.append((char) shifted);
        }
        return ciphertext.toString();
    }

    // Decrypts a string using Vigenère Cipher with a keyword
    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toLowerCase().replaceAll("[^a-z]", "");
        key = key.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char k = key.charAt(i % key.length());
            int shifted = (c - 'a' - (k - 'a') + 26) % 26 + 'a';
            plaintext.append((char) shifted);
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "geeksforgeeks";
        String key = "ayush";
        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Key: " + key);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}