package com.questions.tasks.proglib;

/**
 * Created by iMac on 26/11/2017.
 * Cyclic queue!
 */
class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.add(34);
        queue.add(55);
        queue.add(66);
        queue.add(123);
//        queue.pushBack(1231);
//        queue.pushBack(1231);
        queue.print();
        System.out.println("\n" + queue.poll());
        System.out.println(queue.head);
        System.out.println(queue.tail);
        System.out.println(queue.isEmpty());
    }

    int size;
    int head;
    int tail;
    int[] mas;

    Queue(int size) {
        mas = new int[this.size = size];
    }

    void add(int value) {
        if (++tail == size)
            tail = 0;
        mas[tail] = value;
    }

    int poll() {
        if (++head == size)
            head = 0;
        return mas[head];
    }

    boolean isEmpty() {
        return head == tail;
    }

    void print() {
        if (mas.length == 0)
            System.out.println("null");
        else
            for (int i : mas)
            System.out.print(i + " ");
    }
}
