package com.questions.tasks.quizful.questions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by iMac on 03/12/2017.
 */
class Formatter {
    public String format(String value) {
        return "["+value+"]";
    }
}

class TestNPE {
    public static String handle(Formatter f, String s) {
        if ("".equals(s)) {
            return "(none)";
        }

        try {
            File file = new File("path");
            FileInputStream fis = new FileInputStream(file);
            String s2 = "inside";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            System.out.println(s2);
        }
        return f.format(s.trim());
    }
}

class MainFormatter {
    public static void main(String[] args) {
        TestNPE testNPE = new TestNPE();
        Formatter formatter = new Formatter();
        System.out.println(testNPE.handle(formatter, null));
    }
}
