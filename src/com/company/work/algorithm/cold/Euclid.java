package com.company.work.algorithm.cold;

public class Euclid {
    public static void main(String[] args) {
        int a = 525;
        int b = 45;
        System.out.println(a % b);
        System.out.println("Nod: ");
        euclid(a, b);
        System.out.println("Nod while: ");
        System.out.println(euclidWhile(a, b));
        nok(a, b);

    }

    private static void nok(int a, int b) {
        int tmp = a * b;

        System.out.println("Nok:" + tmp / euclidWhile(a, b));
    }

    private static int euclidWhile(int a, int b) {
        int nod = 0;
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
                nod = a + b;
            } else {
                b = b % a;
                nod = a + b;
            }
        }
        return nod;
    }

    private static void euclid(int a, int b) {
        if (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
                euclid(a, b);
            } else {
                b = b % a;
                euclid(b, a);
            }
        } else {
            System.out.println(a + b);
        }
    }
}
