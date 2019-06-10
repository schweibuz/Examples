package com.spring2019.interviewQuestions.core.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class PrintStreamExample {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream pout = new PrintStream(new FileOutputStream(MyFile.getFileOut2(), true));
        pout.println(2019);
        pout.println("Welcome to Java");
        pout.close();
        System.out.println("Success");
    }
}
