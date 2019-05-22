package com.company.multithreading.txt;

import java.io.*;

class Secret {
    public static void checkFile() throws IOException {
        File file = new File("C:\\Users\\petrov\\Documents\\text.txt");
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile().getName());
        System.out.println(file.getTotalSpace());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length());
        System.out.println(File.separator);
        //System.out.println(file.);

        System.out.println(file.getParentFile().list());
    }


    public static void readBytes() throws IOException {
        InputStream inputStream = new FileInputStream(new File("/home/rpetrov/temp/text"));

        int data = inputStream.read();
        char content;

        while (data != -1) {
            content = (char) data;
            System.out.print(content);
            data = inputStream.read();
        }


    }


    public static void writeBytes(byte[] bytes) throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("/home/rpetrov/temp/text_out");
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (Exception e){
                throw e;
            }
        }
    }

    public static void readBytesToArray() throws IOException {
        InputStream inputStream = new FileInputStream("/home/rpetrov/temp/text");

        int nRead;
        byte[] data = new byte[1024];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {

        }
    }

    public static void copy() throws IOException {
        InputStream inputStream = new FileInputStream("/home/rpetrov/temp/text");
        OutputStream outputStream = new FileOutputStream("/home/rpetrov/temp/text_out");


        int nRead;
        byte[] data = new byte[1024];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            outputStream.write(data, 0, nRead);
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }


    public static void readBuffer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/rpetrov/temp/text"));

        // or
        InputStream inputStream = new FileInputStream("/home/rpetrov/temp/text");
        br = new BufferedReader(new InputStreamReader(inputStream));

        int c;
        while ((c = br.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void newCopy() throws IOException {
        FileInputStream fstream = new FileInputStream("/home/rpetrov/temp/text");
        FileOutputStream fos = new FileOutputStream("/home/rpetrov/temp/text_out");

        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        String strLine;

        // bw.

        while ((strLine = br.readLine()) != null) {
            bw.write(strLine);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        checkFile();
//        readBytes();
//       // writeBytes(new byte[]{(byte) '!'});
//        copy();
//        readBuffer();
//        newCopy();
    }

}