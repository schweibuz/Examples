package com.company.socket;

import java.io.*;
import java.net.*;

/**
 * Created by Roman Petrov
 */
class Client {

    public void start() throws IOException {

        Socket fromserver = null;

        fromserver = new Socket(InetAddress.getByName("127.0.0.1"), 4444);

        BufferedReader in = new
                BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new
                PrintWriter(fromserver.getOutputStream(), true);
        FileInputStream inu = new
//                FileInputStream("F:\\JAVA\\Staff\\iO\\restrictions\\Структура.txt");
                FileInputStream("/Volumes/ExFAT64/JAVA/Staff/iO/restrictions/Структура.txt");

        String fuser, fserver;
        byte[] mas = new byte[1000];
        while ((inu.read(mas)) != -1) {
            fromserver.getOutputStream().write(mas); //id:message
          // fserver = in.readLine();
           // System.out.println(fserver);
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();

    }

}
