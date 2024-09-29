/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket on a specific port
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                // Step 2: Accept incoming client connections
                Socket clientSocket = serverSocket.accept();

                // Step 3: Display the client's IP address using InetAddress
                InetAddress clientAddress = clientSocket.getInetAddress();
                System.out.println("Client connected from IP: " + clientAddress.getHostAddress());

                // Step 4: Create streams to read and write data
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                // Step 5: Start listening to client messages
                String clientMessage;
                while ((clientMessage = input.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);

                    // Send a response to the client
                    output.println("Message received: " + clientMessage);
                }

                // Close connections
                input.close();
                output.close();
                clientSocket.close();
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

