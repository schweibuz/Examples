package com.questions.tasks.proglib;

/**
 * Created by iMac on 22/11/2017.
 */
class DuplicateElement {
    public static void main(String[] args) {
        final int SIZE = 100;
        int[] mas = new int[SIZE];
        for (int i = 0; i < SIZE; i++)
            mas[i] += i + 1;
        mas[23] = 12345;
        mas[43] = 23422;
        mas[66] = 645645;
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i] + " ");

        System.out.println();

        int[] newMas = new int[SIZE];
        for (int i = 0; i < newMas.length; i++)
            newMas[i] += i + 1;
        for (int i = 0; i < newMas.length; i++)
            System.out.print(newMas[i] + " ");

        System.out.println();

        int[] k = new int[10];
        int num = 0;
        for (int i = 0; i < SIZE; i++) {
            int j = mas[i];
            if (j != newMas[i]) {
                k[num] = j;
                num++;
            }
        }
        for (int i = 0; i < k.length; i++)
            System.out.print(k[i] + " ");

        System.out.println();

        DuplicateElement dupl = new DuplicateElement();
        int[] sumMas = dupl.concat(mas, newMas);
        for (int i = 0; i < sumMas.length; i++)
            System.out.print(sumMas[i] + " ");
    }

    public int[] concat(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int[] c = new int[aLength + bLength];
        System.arraycopy(a, 0, c, 0, aLength);
        System.arraycopy(b, 0, c, aLength, bLength);
        return c;
    }
}

class DuplicateElemntSimple {

    int[] offset(int[] mas, int shift) {
        if (mas == null || mas.length == 0 || shift <= 0) throw new IllegalArgumentException();
        while (shift > 0) {
            int lastVar = mas[mas.length - 1];
            for (int counter = 0; counter < mas.length; counter++) {
                int curVal = mas[counter];
                mas[counter] = lastVar;
                lastVar = curVal;
            }
            shift--;
        }
        return mas;
    }

    int[] arrayList(int[] src, int position, int element) {
        int[] dst = new int[src.length ];
        System.arraycopy(src,0,dst,0,position);
        dst[position-1] = element;
        System.arraycopy(src,position,dst,position,src.length-position);

        return dst;
    }

    public static void main(String[] args) {
        DuplicateElemntSimple dupls = new DuplicateElemntSimple();
        final int SIZE = 100;
        int[] mas = new int[SIZE];

        for (int i = 0; i < SIZE; i++)
            mas[i] += i + 1;

        for (int i = 0; i < SIZE; i++)
            System.out.print(mas[i] + " ");

        System.out.println();
        int masSum = 0;
        for (int i = 0; i < SIZE; i++)
            masSum += mas[i];
        System.out.println(masSum);

        int[] neo = dupls.arrayList(mas, 15, 23332);
        for (int i : neo)
            System.out.print(i + " ");


    }
}