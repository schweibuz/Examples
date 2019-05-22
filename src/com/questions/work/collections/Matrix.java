package com.questions.work.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iMac on 29/10/2017.
 */
class Matrix {
    public static void main(String[] args) {
        int SIZE = 10;
        int[][] mas = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mas[i][j] = i;
            }
            mas[i][5] += 99;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(mas[i][j]);
            }
            System.out.println("f");
        }

        Matrix matrix = new Matrix();
        int max = matrix.maxForMatrix(mas, SIZE);
        System.out.println("\nmax: " + max);

        System.out.println("factorial: " + matrix.factorial(10));

        int[] mas2 = new int[100];
        for (int i = 0; i < mas2.length; i++) {
            int rnd = (int) (Math.random() * 99);
            mas2[i] += rnd;
        }
        int f = Array.getInt(mas2, 3);  //class Array - for working with reflection
        System.out.println(f);
        String s = Arrays.toString(mas2);
        System.out.println("String: " + s);
        List list = new ArrayList();
        list.add("sd");
        list.add("fds");
        List list2 = new ArrayList();
        list2 = Arrays.asList(list);
        System.out.println(list2);
    }

    public int maxForMatrix(int[][] mas, int SIZE) {
        int max = mas[0][0];
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                    System.out.println("max in " + i + " line: " + max + " ");
                    sum += mas[i][j];
                }
            }
        }
        System.out.println("sum: " + sum);
        return max;
    }

    public static int chooseMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public int factorial(int fac) {
        int n = 0;
        if (fac > 1)
            n = fac * factorial(fac - 1);
        else
            n = 1;
        return n;
    }
}
