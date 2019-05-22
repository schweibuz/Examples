package com.company.dataStruct.stack.test;

import java.util.Arrays;
import java.util.EmptyStackException;

class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 45; i++)
            stack.pushItem(i);
        System.out.println("Capacity: " + stack.size);
        int i = stack.popItem();
        System.out.println(i);
        System.out.println("\nCapacity after remove: " + stack.size);
        System.out.println(stack);

        for (int j = 0; j < 43; j++)
            stack.popItem();
        System.out.println("\nCapacity after remove: " + stack.size);
        System.out.println(stack);
        stack.pushItem(55);
        System.out.println(stack);
        stack.getItem();
        System.out.println(stack.popItem());
        System.out.println("Stack length: " + stack.stack.length);
    }
}

class Stack {
    int size = 0;
    int[] stack;

    public Stack() {
        this(5);
    }

    private Stack(int capacity) {
        stack = new int[capacity];
    }

    public void ensureCapacity(int curSize) {
        if (curSize - stack.length > 0)
            stack = Arrays.copyOf(stack, (stack.length * 2 / 3) * 2);
    }

    public void pushItem(int item) {
        ensureCapacity(size + 1);
        stack[size++] = item;
    }

    public void getItem() {
        if (isEmpty())
            System.out.println("Stack is empty.");
        else
            System.out.println("Item: " + stack[size - 1]);
    }

    public int popItem() {
        int t;
        if (size == 0) {
            throw new EmptyStackException();
        }
        t = stack[size - 1];
        size--;
        stack[size] = 0;
        return t;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "size=" + size +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
}