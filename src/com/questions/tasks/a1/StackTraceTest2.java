package com.questions.tasks.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by iMac on 18/12/2017.
 */
class StackTraceTest2 {
    public static void main(String[] args) throws Throwable {

        StackTraceTest2 trace = new StackTraceTest2();
        Logger logger = Logger.getLogger("MyLOGY");
//        FileHandler handler = new FileHandler("~/Library/Mobile\\ Documents/com~apple~CloudDocs/Documents/JavaCode/LOG_FILES/MyLOG",true);
        FileHandler handler = new FileHandler("/Users/andmat/downloads/LogFiles/MyLOG",true);
        logger.addHandler(handler);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("to insert factorial: ");
            int n = Integer.parseInt(reader.readLine());
            System.out.println("factorial n: " + n);
            System.out.print(trace.factorial(n) + " ");

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            Throwable th = new NullPointerException("Argument nelegal");
            th.initCause(e);
            logger.log(Level.INFO, "LOGY", th.getMessage());
            throw th;
        }
        System.out.println(System.getProperty("java.util.logging.config.file"));
    }

    static int fac = 0;

    public int factorial(int n) {
        System.out.println();
        Throwable e = new Throwable();
        StackTraceElement[] element = e.getStackTrace();
        for (StackTraceElement f : element) {
            System.out.println(f.getFileName() + " " + f.getClassName() + " "
                    + f.getMethodName() + " " + f.getLineNumber());
            System.out.println(f);
        }
        if (n <= 1) {
            fac = 1;
        } else
            fac = factorial(n - 1) * n;
        System.out.println(n + " = " + fac);
        return fac;
    }
}

class Some {
    public static void main(String[] args) {
        StackTraceTest2 trace = new StackTraceTest2();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            trace.factorial(Integer.parseInt(reader.readLine()));

        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            System.err.println("Illegal");
//            Throwable se = e.getCause();
//            System.err.println(se.getMessage());
        }
        trace.factorial(11);
    }
}