package com.spring2019.interviewQuestions.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class WriterExample {
    public static void main(String[] args) {
        try {
            Writer w = new FileWriter(MyFile.getFileOut2(), true);
            String content = "I love my country";
            w.write(content);
            w.close();
            System.out.println("Success...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
