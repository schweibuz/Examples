package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 29/11/2017.
 */
class DequeTest2 {
    public static void main(String[] args) {
        DequeTest2 test = new DequeTest2(5);
        test.pushBack(55);
        test.pushBack(66);
        test.pushBack(77);
        test.pushFront(666);
//        test.pushBack(88);
//        test.pushBack(99);
//        test.pushBack(111);
        test.print();
        for (int i = 0; i < 10; i++)
            System.out.print(test.popBack() + " ");
        System.out.println();
        System.out.println(test.popFront());
        System.out.println(test.popFront());
        System.out.println(test.popFront());
        System.out.println(test.popFront());
        System.out.println(test.popFront());
        System.out.println(test.popFront());

        test.print();
    }

    int size;
    int head;
    int tail;
    int[] mas;

    DequeTest2(int size) {
        mas = new int[this.size = size];
    }

    void pushBack(int value) {
        mas[tail] = value;
        if (++tail >= size)
            tail = 0;

    }

    int popBack() {
        if (--tail < 0)
            tail = size - 1;
        int tmp = mas[tail];
        return tmp;
    }

    void pushFront(int value) {
        if (--head <= 0)
            head = size - 1;
        mas[head] = value;

    }

    int popFront() {
        if (++head >= size)
            head = 0;
        return mas[head];
    }

    void print() {
        for (int i : mas)
            System.out.print(i + " ");
        System.out.println();
    }
}
