/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to the server using Socket
            Socket socket = new Socket("localhost", 1234);

            // Step 2: Create streams to send and receive messages
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to server. Type your messages:");

            // Step 3: Continuously send messages to the server
            String userMessage;
            while ((userMessage = consoleInput.readLine()) != null) {
                output.println(userMessage);  // Send to server

                // Receive the response from the server
                String serverResponse = input.readLine();
                System.out.println("Server: " + serverResponse);
            }

            // Step 4: Close the connections
            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

