package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(in.readLine());
            out.println(reader.readLine());

            System.out.println(in.readLine());
            out.println(reader.readLine());

            System.out.println(in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
