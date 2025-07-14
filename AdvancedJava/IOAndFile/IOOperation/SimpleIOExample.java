package Java_Bootcamp.AdvancedJava.IOAndFile.IOOperation; /**
 * SimpleIOExample.java
 * Demonstrates basic file I/O operations in Java using File, FileReader, FileWriter,
 * FileInputStream, and FileOutputStream with buffering.
 * Scenario: Reading numbers from a text file, sorting them (DSA example), and writing
 * the sorted result to a text file and a binary file.
 * Features: File creation, text reading/writing, binary reading/writing, and proper
 * resource management.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SimpleIOExample {
    public static void main(String[] args) {
        // Step 1: Create a sample input text file using File and FileWriter
        File textFile = new File("input.txt");
        try {
            if (!textFile.exists()) {
                if (textFile.createNewFile()) {
                    System.out.println("Created file: " + textFile.getName());
                }
            }
            // Write sample numbers to text file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
                writer.write("5\n3\n8\n1");
                System.out.println("Wrote numbers to " + textFile.getName());
            } catch (IOException e) {
                System.err.println("Error writing to text file: " + e.getMessage());
                return;
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return;
        }

        // Step 2: Read numbers from text file using FileReader and BufferedReader
        ArrayList<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number: " + line);
                }
            }
            System.out.println("Read numbers: " + numbers);
        } catch (IOException e) {
            System.err.println("Error reading text file: " + e.getMessage());
            return;
        }

        // Step 3: Sort numbers (DSA example)
        Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);

        // Step 4: Write sorted numbers to a new text file
        File outputTextFile = new File("output_text.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputTextFile))) {
            for (Integer num : numbers) {
                writer.write(num + "\n");
            }
            System.out.println("Wrote sorted numbers to " + outputTextFile.getName());
        } catch (IOException e) {
            System.err.println("Error writing to output text file: " + e.getMessage());
            return;
        }

        // Step 5: Write sorted numbers to a binary file using FileOutputStream
        File binaryFile = new File("output.bin");
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(binaryFile))) {
            for (Integer num : numbers) {
                // Convert integer to bytes (simple 4-byte representation)
                bos.write((num >> 24) & 0xFF);
                bos.write((num >> 16) & 0xFF);
                bos.write((num >> 8) & 0xFF);
                bos.write(num & 0xFF);
            }
            System.out.println("Wrote sorted numbers to " + binaryFile.getName());
        } catch (IOException e) {
            System.err.println("Error writing to binary file: " + e.getMessage());
            return;
        }

        // Step 6: Read from binary file using FileInputStream
        ArrayList<Integer> binaryNumbers = new ArrayList<>();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(binaryFile))) {
            int byteRead;
            int count = 0;
            int num = 0;
            while ((byteRead = bis.read()) != -1) {
                num = (num << 8) | (byteRead & 0xFF);
                count++;
                if (count == 4) { // Read 4 bytes to form an integer
                    binaryNumbers.add(num);
                    count = 0;
                    num = 0;
                }
            }
            System.out.println("Read from binary file: " + binaryNumbers);
        } catch (IOException e) {
            System.err.println("Error reading binary file: " + e.getMessage());
        }
    }
}