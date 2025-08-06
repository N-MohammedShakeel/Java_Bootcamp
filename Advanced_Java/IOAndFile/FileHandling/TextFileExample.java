package Java_Bootcamp.Advanced_Java.IOAndFile.FileHandling; /**
 * TextFileExample.java
 * Demonstrates reading and writing text files using FileReader and FileWriter with buffering.
 * Scenario: Reading numbers from a text file and writing sorted numbers for a DSA application.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TextFileExample {
    public static void main(String[] args) {
        // Write sample data to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt"))) {
            writer.write("5\n3\n8\n1");
            System.out.println("Numbers written to numbers.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        // Read and sort numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
            return;
        }

        // Sort numbers (DSA example)
        Collections.sort(numbers);

        // Write sorted numbers to a new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_numbers.txt"))) {
            for (Integer num : numbers) {
                writer.write(num + "\n");
            }
            System.out.println("Sorted numbers written to sorted_numbers.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}