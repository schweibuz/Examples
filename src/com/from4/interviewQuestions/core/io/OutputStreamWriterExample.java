package com.from4.interviewQuestions.core.io;

import java.io.*;

class OutputStreamWriterExample {
    public static void main(String[] args) {

        try {
            //OutputStreamWriter is a class which is used to convert character stream to byte stream
            Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(
                    MyFile.getFileOut2(), true));
            outputStreamWriter.write("OutputStreamWriter");
            outputStreamWriter.close();

            Reader inputStreamReader = new InputStreamReader(new FileInputStream(
                    MyFile.getFileOut2()));
            int i;
            while ((i = inputStreamReader.read()) != -1) {
                System.out.print((char) i);
            }
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
