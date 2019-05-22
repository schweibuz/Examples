package com.company.work.testProject;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by iMac on 23.08.17.
 */
class Stack {
    int counter;
    int[] stack;

    public Stack() {
        this(10);
    }

    private Stack(int capacity) {
        stack = new int[capacity];
    }

    public void ensureCapacity(int counter) {
        if (counter - stack.length > 0) {
            stack = java.util.Arrays.copyOf(stack, stack.length * 2);
        }
    }
    public void push(int val) {
        ensureCapacity(counter + 1);
        stack[counter++] = val;
    }

    public int pop() {
        if (counter < 0)
            throw new EmptyStackException();
        int tmp = stack[counter];
        stack[counter] = 0;
        counter--;
        return tmp;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "counter=" + counter +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    public int getCounter() {
        return counter;
    }
}
