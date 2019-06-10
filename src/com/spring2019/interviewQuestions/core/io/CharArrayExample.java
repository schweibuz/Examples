package com.spring2019.interviewQuestions.core.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

class CharArrayExample {
    public static void main(String[] args) throws IOException {

        char[] ary = {'n', 'e', 'e', 'd', 'l', 'e', ' ', 'i', 'n', ' ', 'd', 'u', 'c', 'k', '.'};
        CharArrayReader reader = new CharArrayReader(ary);
        CharArrayWriter out = new CharArrayWriter();
        int k = 0;
        while ((k = reader.read()) != -1) {
            char ch = (char) k;
            System.out.print(ch + " : ");
            System.out.println(k);
            out.write(ch + " : " + k + "\n");
        }
        FileWriter f1 = new FileWriter(MyFile.getFileOut1(), true);
        FileWriter f2 = new FileWriter(MyFile.getFileOut2(), true);
        out.writeTo(f1);
        out.writeTo(f2);
        f1.close();
        f2.close();
        System.out.println("Success...");
    }
}
