package com.company.work.algorithm;

class InsertionSort {
    public static void main(String[] args) {
        int length = 5;
        int[] mas = new int[length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        int start = (int) System.currentTimeMillis();
        insertionSort(mas);
//        insertion(mas);
        int finish = (int) (System.currentTimeMillis() - start);
        System.out.println("\n" + finish);
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    static void insertionSort(int[] mas) {
        int tmp, j;
        for (int i = 1; i < mas.length; i++) {
            tmp = mas[i];
            for (j = i - 1; j >= 0 && mas[j] > tmp; j--) {
                mas[j + 1] = mas[j];
            }
            mas[j + 1] = tmp;
        }
    }

    static void insertion(int[] mas) {
        int tmp, j;
        for (int i = 0; i < mas.length; i++) {
            tmp = mas[i];
            j = i;
            while (j > 0 && mas[j - 1] > tmp) {
                mas[j] = mas[j - 1];
                j = j - 1;
            }
            mas[j] = tmp;
        }
    }
}
