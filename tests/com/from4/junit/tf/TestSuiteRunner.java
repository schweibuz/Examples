package com.from4.junit.tf;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JUnitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            failure.getException().printStackTrace();
        }

        System.out.println(result.wasSuccessful());
    }
}
