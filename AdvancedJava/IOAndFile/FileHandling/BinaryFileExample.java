package Java_Bootcamp.AdvancedJava.IOAndFile.FileHandling; /**
 * BinaryFileExample.java
 * Demonstrates reading and writing binary data using FileInputStream and FileOutputStream with buffering.
 * Scenario: Storing and retrieving raw bytes (e.g., image data) for a DSA application.
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileExample {
    public static void main(String[] args) {
        // Write binary data to a file
        byte[] data = "Sample binary data".getBytes();
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data.bin"))) {
            bos.write(data);
            System.out.println("Binary data written to data.bin");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        // Read binary data from the file
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.bin"))) {
            byte[] buffer = new byte[1024];
            int bytesRead = bis.read(buffer);
            if (bytesRead != -1) {
                String content = new String(buffer, 0, bytesRead);
                System.out.println("Read from data.bin: " + content);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}