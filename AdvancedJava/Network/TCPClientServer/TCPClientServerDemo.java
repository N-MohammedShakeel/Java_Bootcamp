package Java_Bootcamp.AdvancedJava.Network.TCPClientServer;// Java Fundamentals: Networking - TCP Client-Server Communication
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Networking Overview
------------------
- Java provides robust networking support through the java.net package (sockets, URLs) and java.nio for non-blocking I/O.
- Key Concepts:
  - TCP: Reliable, connection-oriented protocol (e.g., HTTP, FTP).
  - Sockets: Endpoints for communication (ServerSocket, Socket for TCP).
- TCP Client-Server Model:
  - Server: Listens for connections using ServerSocket.
  - Client: Connects to the server using Socket.
  - Data is exchanged via InputStream/OutputStream.
- Use Cases:
  - Chat applications, file transfers, web servers.
- Notes:
  - TCP ensures reliable delivery but is slower than UDP.
  - Handle exceptions for network failures (e.g., IOException).
  - Use try-with-resources to ensure proper resource closure.

This Example
-----------
- Implements a simple TCP server and client.
- Server: Listens on port 12345, echoes client messages in uppercase.
- Client: Sends a message to the server and prints the response.
- Main method: Prompts user to run either server or client.
*/

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClientServerDemo {
    // Server implementation
    static void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    String input = in.readLine();
                    if (input != null) {
                        System.out.println("Received: " + input);
                        out.println(input.toUpperCase()); // Echo in uppercase
                    }
                } catch (IOException e) {
                    System.err.println("Server error with client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    // Client implementation
    static void runClient() {
        String host = "localhost";
        int port = 12345;
        String message = "Hello, Server!";
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Connected to server: " + host + ":" + port);
            out.println(message);
            System.out.println("Sent: " + message);
            String response = in.readLine();
            System.out.println("Received: " + response);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }

    // Main method to choose server or client
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose mode: (1) Server, (2) Client");
        System.out.print("Enter choice (1 or 2): ");
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            System.out.println("Starting TCP Server...");
            runServer();
        } else if (choice.equals("2")) {
            System.out.println("Starting TCP Client...");
            runClient();
        } else {
            System.out.println("Invalid choice. Please run again and enter 1 or 2.");
        }
        
        scanner.close();
    }
}