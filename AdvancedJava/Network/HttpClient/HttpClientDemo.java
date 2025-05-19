package Java_Bootcamp.AdvancedJava.Network.HttpClient;// Java Fundamentals: Networking - HTTP Client Requests
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
HTTP Client Overview
-------------------
- The HttpClient API, introduced in Java 11 (java.net.http), provides a modern way to make HTTP requests.
- Key Classes:
  - HttpClient: Configurable client for sending requests.
  - HttpRequest: Defines the request (URL, method, headers, body).
  - HttpResponse: Contains the response (status, headers, body).
- Features:
  - Supports HTTP/1.1 and HTTP/2.
  - Asynchronous and synchronous requests.
  - Flexible body handling (String, byte[], InputStream).
- Use Cases:
  - Consuming REST APIs, fetching web resources, posting data.
- Notes:
  - Replaces older URLConnection for HTTP tasks.
  - Handle timeouts and connection errors explicitly.
  - Use try-with-resources for body handlers if needed.

This Example
-----------
- Demonstrates synchronous and asynchronous GET requests to a public API.
- Uses JSONPlaceholder API (https://jsonplaceholder.typicode.com) for sample data.
- Shows how to handle response status and body.
*/

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientDemo {
    public static void main(String[] args) {
        System.out.println("HTTP Client Demonstration");
        // Create HttpClient instance
        HttpClient client = HttpClient.newBuilder()
                                     .connectTimeout(Duration.ofSeconds(10))
                                     .build();

        // Example 1: Synchronous GET Request
        System.out.println("\nExample 1: Synchronous GET Request");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                                            .GET()
                                            .timeout(Duration.ofSeconds(5))
                                            .build();
            HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body().substring(0, 100) + "...");
        } catch (Exception e) {
            System.err.println("Synchronous request error: " + e.getMessage());
        }

        // Example 2: Asynchronous GET Request
        System.out.println("\nExample 2: Asynchronous GET Request");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                                            .GET()
                                            .timeout(Duration.ofSeconds(5))
                                            .build();
            CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(
                request, HttpResponse.BodyHandlers.ofString());
            futureResponse.thenAccept(response -> {
                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Response Body: " + response.body().substring(0, 100) + "...");
            }).join(); // Wait for completion
        } catch (Exception e) {
            System.err.println("Asynchronous request error: " + e.getMessage());
        }
    }
}