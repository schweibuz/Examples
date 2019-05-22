package com.questions.tasks.proglib;

import java.util.Arrays;

/**
 * Created by iMac on 24/11/2017.
 */
class StringReverse {
    public static void main(String[] args) {
        String str = "Mother washed frame.";
        System.out.println("Original: " + str);
        StringBuilder builder = new StringBuilder(str);
        System.out.println("StringBuilder: " + builder.reverse());

        StringReverse strev = new StringReverse();
        System.out.println(strev.reverse(str));

        int[] mas = new int[20];
        for (int i = 0; i < mas.length; i++)
            mas[i] = (int) (Math.random() * 100);
        for (int i : mas)
            System.out.print(i + " ");
        System.out.println();

        StringReverse sort = new StringReverse();
        sort.bubbleSort(mas);


    }

    String reverse(String string) {
        String reverse = null;
        byte[] strtoByteArr = string.getBytes();
        byte[] result = new byte[strtoByteArr.length];
        for (int i = 0; i < strtoByteArr.length; i++)
            result[i] = strtoByteArr[strtoByteArr.length - i - 1];
        reverse = new String(result);
        return reverse;
    }

    void bubbleSort(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length - i; j++) {
                if (mas[j - 1] > mas[j]) {
                    int tmp = mas[j];
                    mas[j] = mas[j - 1];
                    mas[j - 1] = tmp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i + 1, Arrays.toString(mas));
        }
    }
}
