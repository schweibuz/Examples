package com.questions.work.io;

import java.io.*;

/**
 * Created by iMac on 01/11/2017.
 */
class TryResources {
    public static void main(String[] args) {
        TryResources tr = new TryResources();
//        String out = "/Users/iMac/Desktop/in";
//        String where = "/Users/iMac/Desktop/out";
        tr.bufferReader();
    }

    void bufferReader() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            System.out.println("enter: ");
            String s = reader.readLine();
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
