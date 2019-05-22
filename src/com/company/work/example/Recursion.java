package com.company.work.example;
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your favorite number: ");
        int a = scn.nextInt();

        Fibonacci recurs = new Fibonacci();
        int sum = recurs.fibonacci(a);
        int sum2 = recurs.f(a);
        int sum3 = recurs.fib(a);
        System.out.println("Fibonacci: " + sum + " " + sum2 + " " + sum3);

        Factorial fact = new Factorial();
        int sum4 = fact.factorial(a);
        System.out.println("Factorial: " + sum4);

        ArrayRecursion arrayRecursion = new ArrayRecursion(a);
        for (int i = 1; i < a; i++)
            arrayRecursion.aValues[i] = i;
        System.out.println(arrayRecursion.printArray(a));
    }
}

class ArrayRecursion {
    int aValues[];
    StringBuilder sb = new StringBuilder();

    ArrayRecursion(int a) {
        aValues = new int[a];
    }

    String printArray(int a) {
        if (a == 0)
            return "";
        else
            printArray(a - 1);

        String output = "[" + (a - 1) + "]" + aValues[a - 1] + "\n";
        sb.append(output);
        return sb.toString();
    }
}

class Factorial {
    int factorial(int a) {
        int result;
        if (a == 1)
            return 1;
        result = factorial(a - 1) * a;
        return result;
    }
}

class Fibonacci {
    int fibonacci(int i) {
        if (i == 1) return 1;
        if (i == 2) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    int f(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
            return f(index - 1) + f(index - 2);
        }
    }

    int fib(int g) {
        int fib1 = 1;
        int fib2 = 0;
        int fibonacci = 0;
        for (int i = 0; i < g; i++) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }
}

