package com.from4.interviewQuestions.core.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class BufferedWriterExample {
    public static void main(String[] args) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(MyFile.getFileOut2(), true));
        writer.write("Soul in needle, needle in duck, etc.");
        writer.close();
        System.out.println("Success");
    }
}
