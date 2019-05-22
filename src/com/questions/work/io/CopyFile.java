package com.questions.work.io;

import java.io.*;

/**
 * Created by iMac on 01/11/2017.
 */
class CopyFile {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
//        InputStreamReader in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("/Users/andmat/Desktop/in");
//            in = new InputStreamReader(new BufferedInputStream(System.in));
            out = new FileOutputStream("/users/andmat/desktop/out");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        FileReader reader = new FileReader("/users/andmat/desktop/out");
        String str = String.valueOf(reader.read());
        System.out.println(str);
    }
}
