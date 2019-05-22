package com.company.work.example;

/**
 * Created by iMac on 11/01/17.
 */
class Sort {
    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
        long time;

        time = System.currentTimeMillis();
//        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nBubbleSort execution: " + (System.currentTimeMillis() - time + "ms\n"));

        time = System.currentTimeMillis();
        insertedSort(array);
//        inserted(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\nInsertedSort execution: " + (System.currentTimeMillis() - time + "ms\n\n"));

        time = System.currentTimeMillis();
        System.out.println(chooseMax(array) + " \nMax value print out execution: " + (System.currentTimeMillis() - time + "ms\n"));

//        System.out.println(chooseMin(array) + "\nMin value");
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            min = Math.min(min, array[i]);
//        }
//        System.out.println(min);

        int a = 6;
        int b = 9;
        System.out.println("old a: " + a + " old b: " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("new a: "+ a + " new b: " + b + "\n");

        int[] mas = new int[10];
        for (int i = 2; i < mas.length; i++) {
            mas[i] = i;;
            for (int j = 1; j < mas.length; j++) {
                int m = mas[i] * j;
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }


    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];;
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void insertedSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];;
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void inserted(int [] mas) {
        int j, tmp;
        for (int i = 0; i < mas.length; i++) {
            tmp = mas[i];
            for (j = i - 1; j >= 0 && mas[j] > tmp; j--) {
                mas[j + 1] = mas[j];;
            }
            mas[j + 1] = tmp;
        }
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

    public static int chooseMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}

