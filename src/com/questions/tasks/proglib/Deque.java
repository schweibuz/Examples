package com.questions.tasks.proglib;

class Deque {
    public static void main(String[] args) {
        Deque deque = new Deque(7);
        for (int i = 10; i < 14; i++)
            deque.pushBack(i);
        deque.print();
        System.out.println("head " + deque.head);
        System.out.println("tail " + deque.tail);
        System.out.println();

        deque.pushFront(55);
        deque.pushBack(66);
        deque.pushBack(66);
        System.out.println("after pushFront and pushBack");
        System.out.println("head " + deque.head);
        System.out.println("tail " + deque.tail);
        deque.print();
        System.out.println();

        System.out.println("after popFront " + deque.popFront());
        deque.print();
        System.out.println("head " + deque.head);
        System.out.println("tail " + deque.tail);
        System.out.println();

        for (int i = 0; i < 10; i++)
            System.out.println("popBack " + deque.popBack());
        deque.print();
        System.out.println("tail " + deque.tail);
        System.out.println("head " + deque.head);
        System.out.println();

        System.out.println("after pushFront");
        deque.pushFront(111);
        deque.pushFront(222);
        deque.print();
        System.out.println("tail " + deque.tail);
        System.out.println("head " + deque.head);
        System.out.println();

        System.out.println("after frontPop");
        System.out.println("popFront " + deque.popFront());
        System.out.println("popFront " + deque.popFront());
        System.out.println("popFront " + deque.popFront());
        System.out.println("popFront " + deque.popFront());
        deque.print();
        System.out.println("tail " + deque.tail);
        System.out.println("head " + deque.head);
    }

    int size;
    int head;
    int tail;
    int[] mas;

    Deque(int size) {
        mas = new int[this.size = size];
    }

    void pushBack(int value) {
        if (++tail == size)
            tail = 0;
        mas[tail] = value;
    }

    int popBack() {
        int elem = mas[tail];
        if (--tail < 0)
            tail = size - 1;
        return elem;
    }

    void pushFront(int value) {
        mas[head] = value;
        if (--head < 0)
            head = size - 1;
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
