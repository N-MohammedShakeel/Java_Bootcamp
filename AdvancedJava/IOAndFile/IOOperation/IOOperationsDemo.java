package Java_Bootcamp.AdvancedJava.IOAndFile.IOOperation;// Java Fundamentals: IO Operations
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
IO Operations Overview
---------------------
- Input/Output (IO) operations in Java handle data transfer between a program and external sources (e.g., console, files, memory).
- Package: java.io provides classes for byte and character streams.
- Key Concepts:
  - Streams: Sequences of data, either bytes (binary) or characters (text).
  - Byte Streams: Handle raw binary data (e.g., images, files) using InputStream/OutputStream.
  - Character Streams: Handle text data using Reader/Writer, with encoding support (e.g., UTF-8).
  - Buffered Streams: Use buffers to reduce direct access to underlying resources, improving efficiency.
- Main Classes:
  - InputStream/OutputStream: Abstract classes for byte streams (e.g., System.in, FileInputStream).
  - Reader/Writer: Abstract classes for character streams (e.g., BufferedReader, FileWriter).
  - BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter: Buffered versions for efficiency.
- Use Cases:
  - Reading user input from the console.
  - Writing data to memory or output devices.
  - Processing text or binary data streams.
- Notes:
  - Always close streams using try-with-resources to prevent resource leaks.
  - Handle IOException for potential errors (e.g., device unavailable).
  - Character streams automatically handle encoding; byte streams do not.
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOOperationsDemo {
    public static void main(String[] args) {
        // Example 1: Reading from Console (Character Stream)
        System.out.println("Example 1: Reading from Console (BufferedReader)");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.println("Hello, " + name + "!");
        } catch (IOException e) {
            System.err.println("Error reading console input: " + e.getMessage());
        }

        // Example 2: Writing to Console (Character Stream)
        System.out.println("\nExample 2: Writing to Console (PrintWriter)");
        try (PrintWriter writer = new PrintWriter(System.out, true)) {
            writer.println("This is a message written to the console.");
            writer.printf("Formatted output: %s, %d years old%n", "Alice", 25);
        } catch (Exception e) {
            System.err.println("Error writing to console: " + e.getMessage());
        }

        // Example 3: Byte Stream (Reading/Writing to Memory)
        System.out.println("\nExample 3: Byte Stream (ByteArrayInputStream/ByteArrayOutputStream)");
        String data = "This is sample data";
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        try (ByteArrayInputStream input = new ByteArrayInputStream(bytes);
             ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            int byteRead;
            while ((byteRead = input.read()) != -1) {
                output.write(byteRead); // Copy byte to output
            }
            String result = output.toString(StandardCharsets.UTF_8);
            System.out.println("Read and written data: " + result);
        } catch (IOException e) {
            System.err.println("Error with byte stream: " + e.getMessage());
        }

        // Example 4: Buffered Character Stream (Reading/Writing to Memory)
        System.out.println("\nExample 4: Buffered Character Stream (StringReader/StringWriter)");
        String text = "Sample text for character stream";
        try (StringReader reader = new StringReader(text);
             StringWriter writer = new StringWriter()) {
            int charRead;
            while ((charRead = reader.read()) != -1) {
                writer.write(charRead); // Copy character to writer
            }
            System.out.println("Read and written text: " + writer.toString());
        } catch (IOException e) {
            System.err.println("Error with character stream: " + e.getMessage());
        }
    }
}