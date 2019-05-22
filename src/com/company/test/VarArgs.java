package com.company.test;

/**
 * Created by iMac on 20.07.17.
 */
class VarArgs {
    static void vargs(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Введите число!");
        System.out.println("Длина массива: " + args.length + "\nЭлементы массива: ");
        for (int arg : args)
            System.out.print(arg + " ");
    }

    static void vargsMin(int first, int... args) {
        int min = first;
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
        }
        System.out.println("\nMIN: "+min);
    }


    public static void main(String[] args) {
        int [] a = new int[] {12, 23, 343, 2, 4, 45, 12, 34};
        vargs(12, 23, 343, 2, 4, 45, 12, 34);
        vargsMin(31, a);
    }
}
