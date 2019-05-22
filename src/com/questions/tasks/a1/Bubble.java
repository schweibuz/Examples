package com.questions.tasks.a1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Bubble {

    public static void main(String[] args) {
        int length = 50;
        int[] mas = new int[length];
        String path = "/Users/andmat/Desktop/file.txt";

        try (FileWriter writer = new FileWriter(path, true)) {
            for (int i = 0; i < mas.length; i++) {
                mas[i] = (int) (Math.random() * 100);
            }
            for (int i = 0; i < mas.length; i++) {
                System.out.print(mas[i] + " ");
            }
            System.out.println();
            bubbleSort(mas);

            writer.write("Bubble sort: ");
            for (int i = 0; i < mas.length; i++) {
                System.out.print(mas[i] + " ");
                writer.write(mas[i] + " ");
            }
            writer.write("\n");

            System.out.println();
            int[] array = new int[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            System.out.println("Max: " + chooseMax(array));
            writer.write("Max: " + chooseMax(array));
            System.out.println("Min: " + chooseMin(array));
            writer.write("\nMin: " + chooseMin(array) + "\n");

            insertedSort(array);
            writer.write("Inserted sort: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
                writer.write(array[i] + " ");
            }
            writer.write("\n");
            writer.write(String.valueOf(new Date()));
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void bubbleSort(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length - i; j++) {
                if (mas[j] < mas[j - 1]) {
                    int tmp = mas[j - 1];
                    mas[j - 1] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
    }

    private static void insertedSort(int[] mas) {
        int tmp, j;
        for (int i = 0; i < mas.length; i++) {
            tmp = mas[i];
            for (j = i - 1; j >= 0 && mas[j] > tmp; j--)
                mas[j + 1] = mas[j];
            mas[j + 1] = tmp;
        }
    }

    private static int chooseMax(int[] mas) {
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] > max)
                max = mas[i];
        }
        return max;
    }

    private static int chooseMin(int[] mas) {
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min)
                min = mas[i];
        }
        return min;
    }
}
