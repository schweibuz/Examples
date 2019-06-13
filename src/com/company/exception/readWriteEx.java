package com.company.exception;

import java.io.*;

/**
 * Created by iMac on 04/12/2017.
 */
class readWriteEx {

    private static final String path = "/Users/andmat/desktop/IO/new.txt";

    public static void main(String[] args) throws IOException {
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