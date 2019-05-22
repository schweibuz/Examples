package com.company.dataStruct.stack.newstack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by iMac on 21/10/2017.
 */
class Stack2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack);
        for (int i = 0; i < 25; i++)
            stack.push("Hello");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        for (int i = 0; i < 15; i++)
            stack.pop();

        System.out.println(stack);
        stack.push("WOrld");
        System.out.println(stack.pop());
    }
}

class Stack<T> {
    private int counter = 0;
    private T[] stack;

    public Stack() {
        this(5);
    }

    private Stack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    public void push(T item) {
        ensureCapacity(counter);
        stack[counter++] = item;
    }

    public T pop() {
        if (counter == 0)
            throw new EmptyStackException();
        T item = stack[--counter];
        stack[counter] = null;
        return item;
    }

    public void ensureCapacity(int count) {
        if (count - counter == 0)
            stack = Arrays.copyOf(stack, counter + 2);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "counter=" + counter +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
}