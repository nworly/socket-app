package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {
    public static void main(String[] args) {
        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted");

            String resp = reader.readLine();

            writer.printf("Hi %s, your port is %d", resp, clientSocket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
