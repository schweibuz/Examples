package com.spring2019.interviewQuestions.io;

import java.io.*;

class DataStream {
    public static void main(String[] args) {

        MyFile file = new MyFile();

        try (InputStream fin = new FileInputStream(file.getFileOut1());
             BufferedInputStream bin = new BufferedInputStream(fin)) {
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }

            int j;
            while ((j = bin.read()) != -1) {
                System.out.print((char) j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
