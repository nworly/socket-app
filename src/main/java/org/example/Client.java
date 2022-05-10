package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 */
public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8089;

        try (Socket socket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.println("example.org");

            System.out.println(reader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
