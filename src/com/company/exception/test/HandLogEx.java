package com.company.exception.test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by iMac on 08/12/2017.
 */
class HandLogEx {
    public static void main(String[] args) {
        HandLogEx handLogEx = new HandLogEx();
        formatter = new SimpleFormatter();
        try {
            int result = handLogEx.divideByZero(a, b);
            fileHandler = new FileHandler("/Users/andmat/Desktop/logging_file", true);
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
            LOGGER.log(Level.SEVERE, "My first log. ");
            LOGGER.log(Level.INFO, "{0} / {1} = {2}", new Object[] {a, b, result});


        } catch (ArithmeticException | IOException e) {

        }
    }
    static int a = 100;
    static int b = 5;

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static SimpleFormatter formatter;
    private static FileHandler fileHandler;

    int divideByZero(int a, int b) {
        return a / b;
    }
}
