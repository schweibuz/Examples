package com.company.work.algorithm;

/**
 * Created by user123 on 21.12.2016.
 */
class Fib {
    public static void main(String[] args) {
        int n = 20;
        Fib algorithm = new Fib();
        System.out.println("Fibonacci "+algorithm.fibonacci(n));
        System.out.println("Fibonacci without recursion "+algorithm.fibonacciNoRecursion(n));
    }
    public int fibonacci(int n){
        if (n<=1){
            return n;
        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
    public int fibonacciNoRecursion(int fib){
        int n1 = 1;
        int n2 = 0;
        int fibonacci = 0;
        for (int i = 0; i<fib; i++){
            fibonacci = n1 + n2;
            n1 = n2;
            n2 = fibonacci;
        }
        return fibonacci;
    }
}
