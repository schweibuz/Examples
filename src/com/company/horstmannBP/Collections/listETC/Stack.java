package com.company.horstmannBP.Collections.listETC;

/**
 * Created by user123 on 26.12.2016.
 */
class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(12);
        stack.push(2);
        stack.push(4);
        stack.push(34);
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    int size;
    int[] data;

    Stack(int capacity) {
        data = new int [capacity];
    }

    void push(int value) {
        data[size++] = value;
    }

    int pop() {
        return data[--size];
    }
}
