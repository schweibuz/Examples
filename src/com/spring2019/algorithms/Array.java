package com.spring2019.algorithms;

class Array {
    private int size;
    private int[] mas;

    Array(int size) {
        this.size = size;
        mas = new int[size];
        randomFillMas(mas);
//        fillMas(mas);
        print(mas);
        bubbleSort(mas);
        print(mas);
    }

    private void randomFillMas(int[] mas) {
        for (int i = 0; i < size; i++) {
            mas[i] = (int) (Math.random() * 1000);
        }
    }

    private void fillMas(int[] mas) {
        for (int i = 0; i < size; i++) {
            mas[i] = i + 1;
        }
    }

    private void bubbleSort(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length; j++) {
                if (mas[j] < mas[j - 1]) {
                    int tmp = mas[j - 1];
                    mas[j - 1] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
    }

    private void print(int[] mas) {
        for (int i = 0; i < size; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getMas() {
        return mas;
    }

    public void setMas(int[] mas) {
        this.mas = mas;
    }
}
