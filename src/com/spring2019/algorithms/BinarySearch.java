package com.spring2019.algorithms;

import java.util.Arrays;

class BinarySearch {
    public static void main(String[] args) {
        Array mas = new Array(666);
        System.out.println(mas.getSize());

        BinarySearch search = new BinarySearch();
        int[] array = new int[]{2, 3, 5, 7, 9, 12, 55, 63};
        System.out.println("Searched element: " + search.search(15, mas.getMas()));
        System.out.println(counter);

        System.out.println(Arrays.toString(mas.getMas()));

    }

    private static int counter = 0;
    private boolean search(int element, int[] mas) {
        int left = -1;
        int right = mas.length;
        while (left < right - 1) {
            ++counter;
            int mid = (right + left) / 2;
            if (element == mas[mid]) {
                return true;
            }
            if (element <= mas[mid]) {
                right = mid;
            } else if (element >= mas[mid]) {
                left = mid;
            }
        }
        return false;
    }
}
