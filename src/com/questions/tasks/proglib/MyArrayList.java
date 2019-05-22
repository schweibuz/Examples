package com.questions.tasks.proglib;

/**
 * Created by iMac on 23/11/2017.
 */
class MyArrayList {
    static int size = 6;
    static int currentSize = 0;
    static int arr[] = new int[size];

    static void add(int index, int item) {
        int[] boof = new int[size];
        for (int i = index; i < arr.length; i++) {
            boof[i] = arr[i];
        }
        arr[index] = item;
        for (int i = index + 1; i < arr.length; i++)
            arr[i] = boof[i - 1];

        ensureCapacity();
    }

    static void add(int item){
        arr[currentSize] = item;
        ensureCapacity();
    }

    private static void ensureCapacity() {
        currentSize++;
        if (currentSize >= size) {
            int[] boof = new int[size];
            for (int i = 0; i < arr.length; i++) {
                boof[i] = arr[i];
            }
            size *= 2;

            arr = new int[size];
            for (int i = 0; i < boof.length; i++) {
                arr[i] = boof[i];
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            add(i);
            System.out.print(arr[i] + " ");
        }

        add(3, 99);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}