package Java_Bootcamp.AdvancedJava.IOAndFile.FileHandling; /**
 * FileExample.java
 * Demonstrates basic file handling using the File class.
 * Scenario: Managing files/directories for a DSA application (e.g., storing algorithm inputs).
 * Features: Creating files/directories, checking properties, and deleting files.
 */
import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        // Create a File object
        File file = new File("data.txt");

        // Check if file exists
        if (!file.exists()) {
            try {
                // Create a new file
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        } else {
            System.out.println("File already exists: " + file.getName());
        }

        // Check file properties
        System.out.println("Is file? " + file.isFile());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Readable? " + file.canRead());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        // Create a directory
        File dir = new File("data_folder");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directory created: " + dir.getName());
            } else {
                System.err.println("Failed to create directory");
            }
        }

        // Delete the file
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        }
    }
}