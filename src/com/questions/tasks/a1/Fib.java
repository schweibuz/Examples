package com.questions.tasks.a1;

/**
 * Created by iMac on 18/12/2017.
 */
class Fib {
    public static void main(String[] args) {
        System.out.print("fib: ");
        Fib.fibonacci(10);

        System.out.print("\nrec: ");
        for (int i = 0; i < 30; i++)
            System.out.print(Fib.recFibonacci(i) + " ");
    }

    static void fibonacci(int n) {
        int fibonacci = 0;
        int f1 = 1;
        int f2 = 0;
        for (int i = 0; i < n; i++) {
            fibonacci = f1 + f2;
            f1 = f2;
            f2 = fibonacci;
            System.out.print(fibonacci + " ");
        }
    }

    static int recFibonacci(int n) {
        if (n <= 1)
            return 1;
        return (recFibonacci(n - 1) + recFibonacci(n - 2));
    }
}
