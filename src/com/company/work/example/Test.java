package com.company.work.example;

import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите факториал: ");
        int a = s.nextInt();
        s.close();
        Factory factory = new Factory();
        long sum = factory.factorial(a);
        System.out.println("Факториал " + a + " = " + sum);

    }
}
class Factory {
    public long factorial(int i) {
        long sum;
        if (i == 0)
            return 1;
        sum = factorial(i - 1) * i;
        return sum;
    }
}