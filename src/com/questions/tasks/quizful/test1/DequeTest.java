package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 27/11/2017.
 */
class DequeTest {
    public static void main(String[] args) {
        DequeTest test = new DequeTest(9);
        test.pushBack(66);
        test.pushBack(77);
        test.pushBack(88);
        test.pushBack(99);
        test.pushBack(100);
        test.pushBack(111);
        test.print();

        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        System.out.println(test.popBack());
        test.print();

        test.pushFront(222);
        test.pushFront(333);
        test.print();
        System.out.println(test.popFront());
        System.out.println(test.popFront());
        System.out.println(test.popFront());
        test.print();
    }

    int size;
    int head;
    int tail;
    int[] mas;

    DequeTest(int value) {
        mas = new int[this.size = value];
    }

    void pushBack(int value) {
        if (++tail == size)
            tail = 0;
        mas[tail] = value;
    }

    int popBack() {
        if (tail < 0)
            tail = size - 1;
        int tmp = mas[tail];
        tail--;
        return tmp;
    }

    void pushFront(int value) {
        if (head < 0)
            head = size - 1;
        mas[head] = value;
        head--;
    }

    int popFront() {
        if (++head == size)
            head = 0;
        return mas[head];
    }

    void print() {
        for (int i : mas)
            System.out.print(i + " ");
        System.out.println();
    }
}
