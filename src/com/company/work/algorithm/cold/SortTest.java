package com.company.work.algorithm.cold;

class SortTest {
    protected int[] mas;
    private static int counter = 0;
    protected int counterNum;

    public SortTest() {
    }

    private SortTest(int length) {
        this.mas = new int[length];
        counter++;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 100);
        }
        counterNum = counter;
    }

    private static void print(SortTest array, int counter) {
        System.out.print("№" + counter + ": ");
        for (int i = 0; i < array.mas.length; i++) {
            System.out.print(array.mas[i] + " ");
        }
        System.out.println();
    }

    private int getCounterNum() {
        return counterNum;
    }

    public static void main(String[] args) {
        int length = 9;
        SortTest test = new SortTest(length);
        SortTest test1 = new SortTest(length);
        SortTest test2 = new SortTest(length);
        SortTest test3 = new SortTest(length);
        SortTest test4 = new SortTest(length);

        print(test, test.getCounterNum());
        print(test1, test1.getCounterNum());
        print(test2, test2.getCounterNum());
        print(test3, test3.getCounterNum());
        print(test4, test4.getCounterNum());

        System.out.println("Bubble:");
        bubbleSort(test);
        print(test, test.getCounterNum());

        System.out.println("Insertion:");
        insertionSort(test1);
        print(test1, test1.getCounterNum());

        System.out.println("Insertion While:");
        insertionWhile(test2);
        print(test2, test2.getCounterNum());

        System.out.println("Quick:");
        quickSort(test3);
        print(test3, test3.getCounterNum());

        System.out.println("Merge:");
        mergeSort(test4);
        print(test4, test4.getCounterNum());

    }

    private static void bubbleSort(SortTest test) {
        bubble(test.mas);
    }

    private static void bubble(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length - i; j++) {
                if (mas[j - 1] > mas[j]) {
                    int tmp = mas[j - 1];
                    mas[j - 1] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
    }

    private static void insertionSort(SortTest test) {
        insertionSortMain(test.mas);
    }

    private static void insertionSortMain(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            int tmp = mas[i];
            int j;
            for (j = i - 1; j >= 0 && mas[j] > tmp; ) {
                mas[j + 1] = mas[j];
                j--;
            }
            mas[j + 1] = tmp;
        }
    }

    private static void insertionWhile(SortTest test) {
        insertionWhileM(test.mas);
    }

    private static void insertionWhileM(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            int tmp = mas[i];
            int j = i - 1;
            while (j >= 0 && mas[j] > tmp) {
                mas[j + 1] = mas[j];
                j--;
            }
            mas[j + 1] = tmp;
        }
    }

    private static void quickSort(SortTest test) {
        quick(test.mas, 0, test.mas.length - 1);
    }

    private static void quick(int[] mas, int left, int right) {
        if (left >= right) return;
        int pivot = partition(mas, left, right);
        quick(mas, left, pivot);
        quick(mas, pivot + 1, right);
    }

    private static int partition(int[] mas, int left, int right) {
        int tmp;
        int i = left;
        int j = right;
        int pivot = (i + j) / 2;
        while (i < j) {
            while (i < pivot && mas[i] <= mas[pivot]) i++;
            while (j > pivot && mas[j] >= mas[pivot]) j--;
            if (i < j) {
                tmp = mas[i];
                mas[i] = mas[j];
                mas[j] = tmp;
                if (i == pivot) pivot = j;
                else if (j == pivot) pivot = i;
            }
        }
        return pivot;
    }

    private static void mergeSort(SortTest test) {
        mergeSortMain(test.mas, test.mas.length);
    }

    protected static void mergeSortMain(int[] mas, int length) {
        if (length < 2) return;
        int mid = length / 2;
        int[] l = new int[mid];
        int[] r = new int[length - mid];
        for (int i = 0; i < mid; i++)
            l[i] = mas[i];
        for (int i = mid; i < length; i++)
            r[i - mid] = mas[i];
        mergeSortMain(l, mid);
        mergeSortMain(r, length - mid);
        merge(mas, l, r, mid, length - mid);
    }

    private static void merge(int[] mas, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] < r[j])
                mas[k++] = l[i++];
            else
                mas[k++] = r[j++];
        }
        while (i < left)
            mas[k++] = l[i++];
        while (j < right)
            mas[k++] = r[j++];
    }
}