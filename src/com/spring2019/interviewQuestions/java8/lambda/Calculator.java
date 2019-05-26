package com.spring2019.interviewQuestions.java8.lambda;

import java.util.concurrent.Callable;

class Calculator {

    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    static void invoke(Runnable run) {
        run.run();
    }

    static <T> T invoke(Callable cal) throws Exception {
        return (T) cal.call();
    }


    public static void main(String[] args) throws Exception {

        String s = invoke(() -> "done");
        System.out.println(s);

        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
                myApp.operateBinary(40, 2, addition));
        System.out.println("40 - 2 = " +
                myApp.operateBinary(40, 2, subtraction));
    }
}
