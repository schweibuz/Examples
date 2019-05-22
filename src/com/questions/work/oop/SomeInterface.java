package com.questions.work.oop;

/**
 * Created by iMac on 27/10/2017.
 */
public interface SomeInterface<E> {
    public <E> E someMethod(E item);
    public void printMethod(E string);
}
