package Java_Bootcamp.Advanced_Java.Java_Cryptography.Module_1;

/**
 * HillCipher.java
 * Implements the Hill Cipher, a polygraphic substitution cipher using matrix multiplication.
 * Scenario: Encrypt and decrypt messages using linear algebra in a DSA context.
 * Features: Uses 2x2 key matrix, modular arithmetic, and matrix inversion.
 * DSA Relevance: Matrix operations, modular arithmetic, linear algebra.
 */
public class HillCipher {
    // Encrypts a string using Hill Cipher with a 2x2 key matrix
    public static String encrypt(String plaintext, int[][] key) {
        plaintext = plaintext.toLowerCase().replaceAll("[^a-z]", "");
        if (plaintext.length() % 2 != 0) {
            plaintext += "x"; // Pad with 'x' if odd length
        }
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            int[] pair = new int[]{plaintext.charAt(i) - 'a', plaintext.charAt(i + 1) - 'a'};
            int[] result = new int[2];
            // Matrix multiplication: result = key * pair (mod 26)
            result[0] = (key[0][0] * pair[0] + key[0][1] * pair[1]) % 26;
            result[1] = (key[1][0] * pair[0] + key[1][1] * pair[1]) % 26;
            ciphertext.append((char) (result[0] + 'a')).append((char) (result[1] + 'a'));
        }
        return ciphertext.toString();
    }

    // Computes modular inverse of a number
    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("No modular inverse exists");
    }

    // Computes inverse of a 2x2 matrix mod 26
    private static int[][] inverseMatrix(int[][] key) {
        int det = (key[0][0] * key[1][1] - key[0][1] * key[1][0]) % 26;
        if (det < 0) det += 26;
        int detInv = modInverse(det, 26);
        int[][] inverse = new int[2][2];
        inverse[0][0] = (key[1][1] * detInv) % 26;
        inverse[0][1] = ((-key[0][1] + 26) * detInv) % 26;
        inverse[1][0] = ((-key[1][0] + 26) * detInv) % 26;
        inverse[1][1] = (key[0][0] * detInv) % 26;
        return inverse;
    }

    // Decrypts a string using Hill Cipher
    public static String decrypt(String ciphertext, int[][] key) {
        int[][] inverseKey = inverseMatrix(key);
        return encrypt(ciphertext, inverseKey); // Decryption uses inverse matrix
    }

    public static void main(String[] args) {
        String plaintext = "meetme";
        int[][] key = {{9, 4}, {5, 7}}; // Example 2x2 key matrix (must be invertible mod 26)
        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}