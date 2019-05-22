package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 23/11/2017.
 */
class ArrayListTest {
    public static void main(String[] args) {
        ArrayListTest test = new ArrayListTest();
        test.add(666);
        for (int i = 1; i < 22; i++)
            test.add(i);
        test.add(4, 444);
        test.add(7, 777);
        System.out.println("size: " + test.size);
        System.out.println("curr: " + test.curr);
        for (int i : test.array)
            System.out.print(i + " ");
        System.out.println("\nAfter removing");


        for (int i = 0; i <= 6; i++)
            test.remove();
        test.add(234);
//        test.add(33, 2342);
//        test.add(36, 12313);
        for (int i = 22; i < 32; i++)
            test.add(i);
        for (int i : test.array)
            System.out.print(i + " ");
        System.out.println("\nsize: " + test.size);
        System.out.println("curr: " + test.curr);


        int item = 777;
        for (int i = 0; i < 7; i++)
            test.add(3423);
        System.out.println("Index: " + test.indexOf(item));
        System.out.println("Contains: " + test.contains(item));
        for (int i : test.array)
            System.out.print(i + " ");

        System.out.println();
        for (int i = 0; i < 100; i++)
            test.add(i);
        test.add(13,14);

        ArrayListTest test2 = new ArrayListTest();
        System.out.println("Test2 --->");
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        System.out.println(sum);


        for (int i = 0; i < 100; i++)
            test2.add(i);
        test2.add(12, 13);
        int sumArray = 0;
        for (int i = 0; i < test2.array.length; i++)
            sumArray += test2.array[i];
        System.out.println(sumArray);

        for (int i : test2.array)
            System.out.print(i + " ");
        System.out.println();
        System.out.println("Duplicate element: " + (sumArray - sum));


    }

     int size = 6;
     int curr = 0;
     int[] array = new int[size];
     int remCur;

    void add(int element) {
        array[curr] = element;
        ensureCapacity();
    }

    void add(int index, int item) {
        if (index > getCurr()) {
            System.err.println("Index out of bounds array.");
            return;
        }
        int[] copy = new int[size];
        for (int i = 0; i < array.length; i++)
            copy[i] = array[i];
        array[index] = item;
        for (int i = index + 1; i < array.length; i++)
            array[i] = copy[i - 1];
        ensureCapacity();
    }

    int getCurr() {
        return curr;
    }

    void remove() {
        remCur = getCurr() - 1;
        try {
            array[remCur] = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        curr--;
    }

    Object indexOf(int item) {
        int find = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                find = i;
            }
        }
        return find;
    }

    boolean contains(int item) {
        int find = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

    void ensureCapacity() {
        curr++;
        if (curr >= size) {
            int[] copy = new int[size];
            for (int i = 0; i < array.length; i++)
                copy[i] = array[i];
            size *= 2;
            array = new int[size];
            for (int i = 0; i < copy.length; i++)
                array[i] = copy[i];
        }
    }
}
