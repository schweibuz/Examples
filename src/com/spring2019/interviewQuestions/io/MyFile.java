package com.spring2019.interviewQuestions.io;

import java.io.*;

public class MyFile implements Serializable {

    public static void main(String[] args) {

        MyFile file = new MyFile();
        file.writeToInTxt();
        file.writeToOutTxt();

    }

    private static final File fileIn = new File("/users/andmat/desktop/in.txt");
    private static final File fileOut1 = new File("/users/andmat/desktop/out.txt");
    private static final File fileOut2 = new File("/users/andmat/desktop/ou2.txt");
    private static final File fileSuf = new File("/users/andmat/desktop/suffix.txt");
    private final int sample = 1917;

    public void writeToInTxt() {
        try (InputStream tmpStream = new FileInputStream("/users/andmat/documents/javacode/examples/" +
                "src/com/spring2019/interviewQuestions/io/myfile.java");
             OutputStream outputStreamIn = new FileOutputStream(fileIn, true);
             BufferedReader bufReadTmp = new BufferedReader(new InputStreamReader(tmpStream))) {

            if (fileIn.createNewFile()) {
                System.out.println("New file is created");
            } else {
                System.out.println("File already exists");
            }

            String line = bufReadTmp.readLine();
            StringBuilder builder = new StringBuilder();

            while (line != null) {
                builder.append(line).append("\n");
                line = bufReadTmp.readLine();
            }
            outputStreamIn.write(builder.toString().getBytes());

            String s2 = "String of bytes\n".toUpperCase();
            byte[] b = s2.getBytes();
            outputStreamIn.write(b);
            outputStreamIn.write(59);
            System.out.println("Success write to In.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToOutTxt() {
        try (InputStream inputStreamIn = new FileInputStream(fileIn);
             OutputStream outputStreamOut = new FileOutputStream(fileOut1, true);
             BufferedReader bufReadIn = new BufferedReader(new InputStreamReader(inputStreamIn))) {

            String line2 = bufReadIn.readLine();
            StringBuilder builder2 = new StringBuilder();
            while (line2 != null) {
                builder2.append(line2).append("\n");
                line2 = bufReadIn.readLine();
            }
            outputStreamOut.write(builder2.toString().getBytes());
            System.out.println("Success write to Out.txt");

            fileIn.delete();
            System.out.println("In.txt was deleted");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getFileOut2() {
        return fileOut2;
    }

    public static File getFileOut1() {
        return fileOut1;
    }

    public static File getFileSuf() {
        return fileSuf;
    }
}
