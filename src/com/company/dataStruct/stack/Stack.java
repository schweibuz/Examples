package com.company.dataStruct.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

class A {
}
//---------------------------------------------------------------------------
class B extends A {
}
//---------------------------------------------------------------------------
class C extends B {
}
//---------------------------------------------------------------------------
class D extends C {
}
//---------------------------------------------------------------------------
class Stack<T> {
    private T[] dataAggregate;
    private int elementCount = 0;

    private void ensureCapacity(int capacity) {
        if (capacity - dataAggregate.length > 0)
            dataAggregate = Arrays.copyOf(dataAggregate, dataAggregate.length * 2);
    }

    public Stack() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    private Stack(int capacity) {
        dataAggregate = (T[]) new Object[capacity];
    }

    private T push(T element) {
        ensureCapacity(elementCount + 1);
        dataAggregate[elementCount++] = element;
        return element;
    }

    private T pop() {
        T item;
        if (elementCount == 0)
            throw new EmptyStackException();
        item = dataAggregate[elementCount - 1];
        elementCount--;
        dataAggregate[elementCount] = null;
        return item;
    }

    //производные типы от Т
    //ковариант
    public void pushAll(Collection<? extends T> c) {
        for (T element : c)
            push(element);
    }

    //супертипы для Т
    //контравариант
    public void popAll(Collection<? super T> c) {
        while (elementCount > 0)
            c.add(pop());
    }

    @Override
    public String toString() {
        return "Stack " + Arrays.toString(dataAggregate) + "\nelementCount=" + elementCount;
    }

    public static void main(String[] args) {
        //ковариантность
        Stack<A> aStack = new Stack<>();
        ArrayList<B> bList = new ArrayList<>();
        aStack.pushAll(bList);
        System.out.println(aStack);

        //контравариантность
        Stack<C> cStack = new Stack<>();
        ArrayList<A> aList = new ArrayList<>();
        cStack.popAll(aList);
    }
}
//---------------------------------------------------------------------------
//Ковариантность/контравариантность также свойственна для иерархии наследования.
//Ковариантность:
class Super {
    A getSomething() {
        return null;
    }
}
//---------------------------------------------------------------------------
class Sub extends Super {
    B getSomething() {
        return null;
    }
}
//---------------------------------------------------------------------------
//Контрвариантность:
class Super1 {
    void doSomething(B parameter) {

    }
}
//---------------------------------------------------------------------------
class Sub1 extends Super1 {
    void doSomething(A parameter) {

    }
}
//ковариантность свойственна выходным параметрам, а контравариантность - входным.


//---------------------------------------------------------------------------
class Main {
    public static void main(String[] args) {
        ArrayList<Integer> intL = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            intL.add(i);
        ArrayList<Integer> strL = new ArrayList<>();

        Stack stack = new Stack();
        stack.pushAll(intL);
        System.out.println(stack);

        stack.popAll(strL);
        System.out.println(stack);
        System.out.println(strL);
    }
}
