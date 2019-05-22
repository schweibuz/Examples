package com.company.work;

import java.util.Scanner;

class Arrays {
    public static void main(String[] args) {
        Arrays arr = new Arrays();
        arr.method1Arr();
//        arr.method2Arr();
        arr.arraySort();
        arr.lotteryHorstman();
    }

    void method1Arr() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        System.out.println(java.util.Arrays.toString(a));
        int[] copiedA = java.util.Arrays.copyOf(a, a.length + 10);
        System.out.println(java.util.Arrays.toString(copiedA));
    }

    void arraySort() {
        int n = 30;
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = (int) (Math.random() * n);
        }
        java.util.Arrays.sort(mas);
        System.out.println(java.util.Arrays.toString(mas));
    }

    void lotteryHorstman() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int n = in.nextInt();
        System.out.println("Введите число выводимых значений в заданном диапазоне " + n);
        int k = in.nextInt();
        int[] mas = new int[n];
        int[] mas2 = new int[k];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = i + 1;
        }
        for (int i = 0; i < mas2.length; i++) {
            int r = (int) (Math.random() * n);
            mas2[i] = r;    //mas[r]
//            mas[r] = mas[r - 2];
            n--;
        }
        System.out.println(java.util.Arrays.toString(mas));
        System.out.println(java.util.Arrays.toString(mas2));
    }

    void method2Arr() {
//        System.out.println("Enter the size of the array rows and columns");
//        Scanner scn = new Scanner(System.in);
//        int r = scn.nextInt();
//        int c = scn.nextInt();
        int r = 25;
        int c = 35;
        int[][] arrays = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arrays[i][j] + " ");
                System.out.print("");
            }
        }
    }
}
