package com.questions.tasks.proglib;

/**
 * Created by iMac on 27/11/2017.
 */
class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci(10);
        System.out.println();

        for (int i = 0; i < 30; i++) {
            System.out.print(fibonacci.fibonacciRec(i) + " ");
        }
    }

    void fibonacci(int value) {
        int n1 = 1;
        int n2 = 0;
        int fibonacci = 0;
        for (int i = 0; i < value; i++) {
            fibonacci = n1 + n2;
            n1 = n2;
            n2 = fibonacci;
            System.out.print(fibonacci + " ");
        }
    }

    int fibonacciRec(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }
}
