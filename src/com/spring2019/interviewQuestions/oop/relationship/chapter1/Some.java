package com.spring2019.interviewQuestions.oop.relationship.chapter1;

class Some extends Some2 {

    public static void main(String[] args) {

        Some some = new Some();
        some.someMethod();
        Abs abs = new Abs();
        System.out.println("Abs:");
        abs.methodd();
        abs.methoda();

        System.out.println("Abs2:");
        Abs2 abs2 = new Abs2();
        abs2.methodd();
        abs2.show();

        Abse.methodStatic();

        Abse.InInterface abse = new Abse.InInterface();
        abse.methodInnerClassInterface();


    }
}
