package com.company.work.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by iMac on 24.08.17.
 */
class StarTriangle {
    public static void main(String[] args) throws IOException {
        StarTriangle star = new StarTriangle();

        System.out.print("Please enter height: ");
        int height = star.getHeight();
        System.out.print("Please enter width: ");
        int width = star.getWidth();
        star.getReader().close();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    System.out.print("*");
                } else {
                    if (j == 0 || j == width - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int getWidth() throws IOException {
        int val = Integer.parseInt(reader.readLine());
        return val;
    }

    public int getHeight() throws IOException {
        int val = Integer.parseInt(reader.readLine());
        return val;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
