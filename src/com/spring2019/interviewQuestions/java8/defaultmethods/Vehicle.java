package com.spring2019.interviewQuestions.java8.defaultmethods;

interface Vehicle {
    default void print() {
        System.out.println("I am a vehicle!");
    }

    /* static method in an interface are the same what static methods in abstract class.
    Will a part of the interface */
    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}
