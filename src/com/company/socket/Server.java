package com.company.socket;

import java.io.*;
import java.net.*;

/**
 * Created by Roman Petrov
 */


class Server {

    public void start() throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket servers = null;
        Socket fromclient = null;


        try {
            servers = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 4444");
            return;
        }

        try {
            System.out.print("Waiting for a client...");
            fromclient = servers.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            return;
        }

        in = new BufferedReader(new
                InputStreamReader(fromclient.getInputStream()));
//        out = new PrintWriter("F:\\JAVA\\Staff\\iO\\restrictions\\Структура3.txt");
        out = new PrintWriter("/Volumes/ExFAT64/JAVA/Staff/iO/restrictions/Структура3.txt");
        String input, output;
//        out = new PrintWriter(fromclient.getOutputStream(), true);
//        String input, output;

        System.out.println("Wait for messages");
        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit")) break;
            else if (input.contains("exit")) break;
            out.println("S ::: " + input); //id:message
            System.out.println(input);
        }
        out.close();
        in.close();
        fromclient.close();
//        servers.close();

    }
}