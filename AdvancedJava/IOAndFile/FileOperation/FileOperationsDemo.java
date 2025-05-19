package Java_Bootcamp.AdvancedJava.IOAndFile.FileOperation;// Java Fundamentals: File Operations
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
File Operations Overview
-----------------------
- File operations in Java involve creating, reading, writing, and managing files and directories.
- Packages:
  - java.io: Provides File class for basic file/directory operations.
  - java.nio.file: Modern API (Java 7+) for file system operations, offering better performance and flexibility.
- Key Classes:
  - File: Represents a file or directory path (java.io).
  - Path: Represents a file system path (java.nio.file).
  - Files: Utility class for file operations (e.g., read, write, delete).
  - StandardOpenOption: Options for file operations (e.g., CREATE, APPEND).
- Use Cases:
  - Create and delete files/directories.
  - Read/write text or binary data.
  - Check file properties (e.g., exists, readable).
- Notes:
  - Use java.nio.file for new code; it’s more robust than java.io.File.
  - Handle IOException for file access errors (e.g., permission denied).
  - Use try-with-resources to ensure streams are closed.
*/

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileOperationsDemo {
    public static void main(String[] args) {
        // Example 1: Creating and Deleting a File (java.nio.file)
        System.out.println("Example 1: Creating and Deleting a File (Files)");
        Path filePath = Paths.get("sample.txt");
        try {
            Files.writeString(filePath, "Hello, File Operations!\n", StandardCharsets.UTF_8);
            System.out.println("File created: " + filePath.toAbsolutePath());
            Files.delete(filePath);
            System.out.println("File deleted: " + filePath);
        } catch (IOException e) {
            System.err.println("Error with file creation/deletion: " + e.getMessage());
        }

        // Example 2: Writing and Reading a File (java.nio.file)
        System.out.println("\nExample 2: Writing and Reading a File (Files)");
        Path dataFile = Paths.get("data.txt");
        try {
            List<String> lines = List.of("Line 1: Java", "Line 2: IO", "Line 3: NIO");
            Files.write(dataFile, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            System.out.println("Wrote to file: " + dataFile);
            List<String> readLines = Files.readAllLines(dataFile, StandardCharsets.UTF_8);
            System.out.println("Read from file:");
            readLines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error with file write/read: " + e.getMessage());
        }

        // Example 3: Creating and Listing Directories (java.nio.file)
        System.out.println("\nExample 3: Creating and Listing Directories (Files)");
        Path dirPath = Paths.get("testDir");
        try {
            Files.createDirectory(dirPath);
            System.out.println("Directory created: " + dirPath);
            Files.writeString(dirPath.resolve("file1.txt"), "File 1 content");
            Files.writeString(dirPath.resolve("file2.txt"), "File 2 content");
            System.out.println("Files in directory:");
            try (var stream = Files.list(dirPath)) {
                stream.forEach(path -> System.out.println("  " + path.getFileName()));
            }
        } catch (IOException e) {
            System.err.println("Error with directory operations: " + e.getMessage());
        }

        // Example 4: File Operations with java.io.File
        System.out.println("\nExample 4: File Operations with java.io.File");
        File file = new File("legacy.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            }
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Legacy file content");
            }
            System.out.println("Wrote to file: " + file.getName());
            System.out.println("File exists: " + file.exists());
            System.out.println("File size: " + file.length() + " bytes");
            if (file.delete()) {
                System.out.println("File deleted: " + file.getName());
            }
        } catch (IOException e) {
            System.err.println("Error with File operations: " + e.getMessage());
        }
    }
}