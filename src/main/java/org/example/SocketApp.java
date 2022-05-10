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
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Write your name:");
            String name = in.readLine();

            out.println("Are you a child? (yes/no)");
            String respond = in.readLine();

            if (respond.equals("yes")) {
                out.printf("Welcome to the kids area, %s! Let's play!\n", name);
            } else if (respond.equals("no")) {
                out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!\n", name);
            } else {
                System.out.println("Incorrect answer");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
