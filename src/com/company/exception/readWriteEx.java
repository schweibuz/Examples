package com.company.exception;

import java.io.*;

/**
 * Created by iMac on 04/12/2017.
 */
class readWriteEx {
    public static void main(String[] args) throws IOException {
        final String path = "/Users/iMac/Desktop/stopi/new.txt";
        final String path2 = "/Users/iMac/Desktop/main/cards";
        final String test = "/Users/iMac/Desktop/stopi/new2";
        readWriteEx.bufferReader(path);
        readWriteEx.fileReader(path);
    }

    static void bufferReader(String path) {

        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter(path, true) ) {

            System.out.println("Write text: ");
            String str = reader.readLine() + "\n";
            if (str.equals("" + "\n") || str.equals(" " + "\n"))
                throw new FileFormatException("This is my IOException");

            writer.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileReader(String path) {
        try (FileReader fileReader = new FileReader(path)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class FileFormatException extends IOException {
    public FileFormatException() {
    }

    public FileFormatException(String gripe) {
        super(gripe);
    }
}