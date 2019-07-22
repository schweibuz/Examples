package com.from4.interviewQuestions.java8;

import java.util.function.BiFunction;

class MethodReference {
    public static void main(String[] args) {

//        predefined functional interface Runnable to refer static method
        Thread t = new Thread(MethodReference::methodReference);
        t.start();

//        referring a static method to it's functional method say()
        Sayable sayable = MethodReference::methodReference;
        sayable.say();

//        BiFunctional interface
        BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;     //must be static method
        BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float> adder3 = Arithmetic::add;
        int result1 = adder1.apply(10,20);
        float result2 = adder2.apply(10, 20.1f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        InstanceMethodReference methodReference = new InstanceMethodReference(); //Creating object
//        Referring non-static method using reference
        Sayable sayable2 = methodReference::saySomething;
        sayable2.say();
//        Referring non-static method using anonymous object
        Sayable sayable3 = new InstanceMethodReference()::saySomething;
        sayable3.say();

        Thread t2 = new Thread(new InstanceMethodReference2()::printMsg);
        t2.start();

        BiFunction<Integer, Integer, Integer> adder4 = new Arithmetic2()::add;   //non static method
        int result = adder4.apply(10, 20);
        System.out.println(result);

//        can refer a constructor by using the new keyword
        Messageable messageable = Message::new;
        messageable.getMessage("Hello");
    }

    public static void methodReference() {
        System.out.println("static method reference");
    }
}

interface Sayable {     //functional interface
    void say();
}

class Arithmetic {
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(int a, float b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }
}

class InstanceMethodReference {
    public void saySomething() {
        System.out.println("This is non-static method.");
    }
}

class InstanceMethodReference2 {
    public void printMsg() {
        System.out.println("This is instance method.");
    }
}

class Arithmetic2 {
    public int add(int a, int b) {
        return a + b;
    }
}

interface Messageable {
    Message getMessage(String msg);
}

class Message {
    Message(String msg) {
        System.out.println(msg);
    }
}