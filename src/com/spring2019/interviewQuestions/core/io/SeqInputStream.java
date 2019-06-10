package com.spring2019.interviewQuestions.core.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

class SeqInputStream {

    public static void main(String[] args) {
        printDecodedFile();
        printAllFiles();
    }

    static void printAllFiles() {
        try (InputStream inputStream = new FileInputStream(MyFile.getFileSuf());
             InputStream inputStream2 = new FileInputStream(MyFile.getFileOut1());
             SequenceInputStream sequenceInputStream = new SequenceInputStream(
                     inputStream, inputStream2)) {

            int i;
            while ((i = sequenceInputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printDecodedFile() {
        CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        decoder.onMalformedInput(CodingErrorAction.IGNORE);

        try (InputStream inputStream = new FileInputStream(MyFile.getFileSuf());
             InputStreamReader reader = new InputStreamReader(inputStream, decoder)) {
            int line = reader.read();
            StringBuilder builder = new StringBuilder();

            while (line != -1) {
                builder.append((char) line);
                line = reader.read();
            }
            System.out.print(builder.toString());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
