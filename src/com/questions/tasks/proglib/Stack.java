package com.questions.tasks.proglib;

import java.util.EmptyStackException;

/**
 * Created by iMac on 25/11/2017.
 */
class Stack<E> {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("Hello");
        stack.push(12313);
        stack.push("World");
        stack.push(9875987);
        stack.push("Kaa");
        stack.push("Load");
        stack.push(34525);
        System.out.println("curr: " + stack.curr);

        System.out.println("LIFO: " + stack.pop());


        for (Object item : stack.stack)
            System.out.print(item + "->");
        System.out.println();
        System.out.println("size: " + stack.size);
        System.out.println("curr: " + stack.curr);
    }

    private int curr = 0;
    private int size = 5;
    Object[] stack;

    Stack() {
        this(5);
    }

    private Stack(int capacity) {
        stack = new Object[capacity];
    }

    void push(E item) {
        stack[curr] = item;
        ensureCapacity();
    }

    E pop() {
        if (curr == 0) {
            throw new EmptyStackException();
        }
        curr--;
        E copy = (E) stack[curr];
        stack[curr] = null;
        return copy;
    }

    void ensureCapacity() {
        curr++;
        if (curr == size) {
            Object[] copy = new Object[size];
            for (int i = 0; i < stack.length; i++)
                copy[i] = stack[i];
            size += 1;
            stack = new Object[size];
            for (int i = 0; i < copy.length; i++)
                stack[i] = copy[i];
        }
    }
}
