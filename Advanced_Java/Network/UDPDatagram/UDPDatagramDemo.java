package Java_Bootcamp.Advanced_Java.Network.UDPDatagram;// Java Fundamentals: Networking - UDP Datagram Communication
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
UDP Networking Overview
----------------------
- UDP (User Datagram Protocol) is a connectionless, lightweight protocol for sending datagrams.
- Key Classes:
  - DatagramSocket: Sends and receives UDP packets.
  - DatagramPacket: Encapsulates data, destination address, and port.
- Characteristics:
  - No guaranteed delivery or order (unlike TCP).
  - Faster and suitable for applications tolerating packet loss (e.g., streaming, DNS).
- Use Cases:
  - Real-time applications, broadcasting, small data transfers.
- Notes:
  - Handle packet loss manually if needed.
  - Use fixed-size buffers for receiving datagrams.
  - UDP is less reliable but has lower overhead than TCP.

This Example
-----------
- Implements a simple UDP server and client.
- Server: Listens on port 54321, echoes received messages with a prefix.
- Client: Sends a message to the server and prints the response.
- Main method: Prompts user to run either server or client.
*/

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPDatagramDemo {
    // Server implementation
    static void runServer() {
        try (DatagramSocket socket = new DatagramSocket(54321)) {
            System.out.println("UDP Server started on port 54321");
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
                String response = "Echo: " + received;
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                    responseBytes, responseBytes.length,
                    packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    // Client implementation
    static void runClient() {
        String host = "localhost";
        int port = 54321;
        String message = "Hello, UDP!";
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(host);
            byte[] messageBytes = message.getBytes();
            DatagramPacket packet = new DatagramPacket(
                messageBytes, messageBytes.length, address, port);
            socket.send(packet);
            System.out.println("Sent: " + message);
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
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
            System.out.println("Starting UDP Server...");
            runServer();
        } else if (choice.equals("2")) {
            System.out.println("Starting UDP Client...");
            runClient();
        } else {
            System.out.println("Invalid choice. Please run again and enter 1 or 2.");
        }
        
        scanner.close();
    }
}