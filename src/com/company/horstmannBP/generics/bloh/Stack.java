package com.company.horstmannBP.generics.bloh;

import java.util.Arrays;
import java.util.EmptyStackException;

class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAUL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAUL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 32; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        for (int i = 0; i < 9; i++) {
            stack.pop();
        }
        System.out.println(stack);
    }

}
