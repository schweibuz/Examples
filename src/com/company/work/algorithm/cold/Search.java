package com.company.work.algorithm.cold;

class Search {
//    private static void fill(int[] mas) {
//        for (int i = 0; i < mas.length; i++) {
//            mas[i] = (int) (Math.random() * 100);
//        }
//    }

    private static void print(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    private static boolean ifalse(int tmp) {
        if (tmp != -1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
//        final int SIZE = 9;
        int[] mas = new int[]{2, 5, 7, 9, 12, 22, 45, 79, 105, 199};
        print(mas);
        searchElement(mas, 7);
        binary(mas, 0, mas.length - 1, 9);
    }


    private static void searchElement(int[] mas, int element) {
        int tmp = -1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == element)
                tmp = mas[i];
            else
                tmp = -1;
        }
        System.out.println(ifalse(tmp));
    }

    private static boolean binary(int[] mas, int left, int right, int element) {
//        if (mas.length < 2) return false;
        boolean state = false;
        if (element == binarySearch(mas, left, right, element)) {
            state = true;
        }
        return state;
    }

    private static int binarySearch(int[] mas, int left, int right, int element) {

        int tmp = -1;
        int i = left;
        int j = right;
        int mid = (i + j) / 2;

        if (element < mas[mid]) {
            binarySearch(mas, left, mid, element);

        } else if (element > mas[mid]) {
            binarySearch(mas, mid, right, element);

        }

        return tmp;
    }

    private static void binaryS(int[] mas, int length, int target) {

    }
}
