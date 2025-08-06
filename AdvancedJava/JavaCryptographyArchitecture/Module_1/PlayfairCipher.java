package Java_Bootcamp.AdvancedJava.JavaCryptographyArchitecture.Module_1; /**
 * PlayfairCipher.java
 * Implements the Playfair Cipher, a digraph substitution cipher using a 5x5 key square.
 * Scenario: Encrypt and decrypt messages with paired letters in a DSA context.
 * Features: Uses LinkedHashSet for unique key matrix, processes digraphs, supports encryption/decryption.
 * DSA Relevance: Matrix operations, string manipulation, set data structure.
 */
import java.util.*;

public class PlayfairCipher {
    private char[][] matrix = new char[5][5];

    // Create the 5x5 key matrix
    public void generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char ch : key.toCharArray()) {
            set.add(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch != 'J') set.add(ch);
        }

        Iterator<Character> it = set.iterator();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (it.hasNext())
                    matrix[i][j] = it.next();
    }

    // Find position of a character in matrix
    private int[] findChar(char ch) {
        if (ch == 'J') ch = 'I';
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == ch)
                    return new int[]{i, j};
        return null;
    }

    // Preprocess text into digraphs
    private List<String> preprocessText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        List<String> pairs = new ArrayList<>();

        int i = 0;
        while (i < text.length()) {
            char first = text.charAt(i);
            char second = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X';

            if (first == second) {
                pairs.add("" + first + 'X');
                i++;
            } else {
                pairs.add("" + first + second);
                i += 2;
            }
        }

        if (pairs.get(pairs.size() - 1).length() == 1)
            pairs.set(pairs.size() - 1, pairs.get(pairs.size() - 1) + 'X');

        return pairs;
    }

    // Encrypt a pair
    private String encryptPair(char a, char b) {
        int[] pos1 = findChar(a);
        int[] pos2 = findChar(b);

        if (pos1[0] == pos2[0]) { // same row
            return "" + matrix[pos1[0]][(pos1[1] + 1) % 5] +
                         matrix[pos2[0]][(pos2[1] + 1) % 5];
        } else if (pos1[1] == pos2[1]) { // same column
            return "" + matrix[(pos1[0] + 1) % 5][pos1[1]] +
                         matrix[(pos2[0] + 1) % 5][pos2[1]];
        } else { // rectangle
            return "" + matrix[pos1[0]][pos2[1]] +
                         matrix[pos2[0]][pos1[1]];
        }
    }

    // Decrypt a pair
    private String decryptPair(char a, char b) {
        int[] pos1 = findChar(a);
        int[] pos2 = findChar(b);

        if (pos1[0] == pos2[0]) { // same row
            return "" + matrix[pos1[0]][(pos1[1] + 4) % 5] +
                         matrix[pos2[0]][(pos2[1] + 4) % 5];
        } else if (pos1[1] == pos2[1]) { // same column
            return "" + matrix[(pos1[0] + 4) % 5][pos1[1]] +
                         matrix[(pos2[0] + 4) % 5][pos2[1]];
        } else { // rectangle
            return "" + matrix[pos1[0]][pos2[1]] +
                         matrix[pos2[0]][pos1[1]];
        }
    }

    public String encrypt(String plaintext, String key) {
        generateMatrix(key);
        List<String> digraphs = preprocessText(plaintext);
        StringBuilder ciphertext = new StringBuilder();
        for (String pair : digraphs) {
            ciphertext.append(encryptPair(pair.charAt(0), pair.charAt(1)));
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext, String key) {
        generateMatrix(key);
        List<String> digraphs = preprocessText(ciphertext);
        StringBuilder plaintext = new StringBuilder();
        for (String pair : digraphs) {
            plaintext.append(decryptPair(pair.charAt(0), pair.charAt(1)));
        }
        return plaintext.toString();
    }

    public void displayMatrix() {
        System.out.println("5x5 Key Matrix:");
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayfairCipher cipher = new PlayfairCipher();

        System.out.print("Enter Key: ");
        String key = sc.nextLine();

        System.out.print("Enter Plaintext: ");
        String plaintext = sc.nextLine();

        String encrypted = cipher.encrypt(plaintext, key);
        System.out.println("\nEncrypted Text: " + encrypted);

        String decrypted = cipher.decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);

        cipher.displayMatrix();
    }
}