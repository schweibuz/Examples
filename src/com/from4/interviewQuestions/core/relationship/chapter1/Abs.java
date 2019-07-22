package com.from4.interviewQuestions.core.relationship.chapter1;

public class Abs extends Abs2 {

//    public abstract void method();
    public void methoda() {
        System.out.println("Methoda");
    }

    @Override
    public void methodd() {
        System.out.println("methodd");
    }
}

class Abs2 implements Abse {

    @Override
    public void methodd() {
        System.out.println("Abs2 method");
    }

}

interface Abse {
    void methodd();
    static void methodStatic() {
        System.out.println("Static in");
    }
    default void show() {
        System.out.println("Default method");
    }

    class InInterface {
        public void methodInnerClassInterface() {
            System.out.println("methodInnerClassInterface");
        }
    }
}
