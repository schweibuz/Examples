package com.spring2019.interviewQuestions.io;

import java.io.FileReader;
import java.io.Reader;

class ReaderExample {
    public static void main(String[] args) {
        try {
            Reader r = new FileReader(MyFile.getFileOut2());
            int ch;
            while ((ch = r.read()) != -1) {
                System.out.print((char) ch);
            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
