package com.company.horstmannBP.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by iMac on 07.02.17.
 */
class SocketTest {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            s.setSoTimeout(1000);
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (InterruptedIOException exception) {
            System.err.println("Error");
        }
    }
}