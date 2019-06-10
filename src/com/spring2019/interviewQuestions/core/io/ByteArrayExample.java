package com.spring2019.interviewQuestions.core.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

class ByteArrayExample {

    public static void main(String[] args) {

        try (FileOutputStream fout1 = new FileOutputStream(MyFile.getFileOut1(), true);
             FileOutputStream fout2 = new FileOutputStream(MyFile.getFileOut2(), true)) {

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout.write(65);
            bout.writeTo(fout1);
            bout.writeTo(fout2);

            System.out.println("Success...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] buf = {35, 36, 37, 38};
        ByteArrayInputStream byt = new ByteArrayInputStream(buf);
        int k = 0;
        while ((k = byt.read()) != -1) {
            char ch = (char) k;
            System.out.println("ASCII value of Character is:" + k + "; Special character is: " + ch);
        }
    }
}
