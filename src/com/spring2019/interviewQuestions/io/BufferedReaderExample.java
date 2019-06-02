package com.spring2019.interviewQuestions.io;

import java.io.*;

class BufferedReaderExample {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(MyFile.getFileOut2()));
        int i;
        while ((i = reader.read()) != -1) {
            System.out.print((char) i);
        }
        reader.close();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        while (!name.equals("stop")) {
            System.out.println("\nEnter data:");
            name = r.readLine();
            System.out.println("data is: " + name);
        }
        r.close();
    }
}
