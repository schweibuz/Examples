package com.spring2019.interviewQuestions.oop.relationship.chapter1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class StaticDemo extends Hz2 {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        StaticDemo hz = new StaticDemo();
        StaticDemo hz1 = new StaticDemo();
        hz.staticMethod();

        Class classic = Class.forName("com.spring2019.interviewQuestions.oop.relationship.chapter1.Hz2");
        Method method =  classic.getDeclaredMethod("staticMethod");
        method.invoke(classic);

        Hz2 hz2 = new StaticDemo();
        System.out.println(hz2.getClass());

        StaticClass staticClass = new StaticClass();
        staticClass.someHzMethod();

    }

    static {
        System.out.println("Static");
    }

    StaticDemo() {
        System.out.println("Constructor");
    }

     static class StaticClass {
        public void someHzMethod() {
            System.out.println("Static class method");
            StaticDemo hz = new StaticDemo();
            System.out.println(hz.str);
        }

    }

    private String str = "Private string";

    class InnerClass extends Hz2{
        public void print() {
            System.out.println(StaticDemo.this.str);
        }
    }

}

class Hz3 {
    public static void main(String[] args) {
        StaticDemo.StaticClass hz = new StaticDemo.StaticClass();
        hz.someHzMethod();
    }
}

class Hz2 {
    public static void staticMethod() {
        System.out.println("Statitc method");
    }

    public void nonStaticMethod() {
        System.out.println("Non static method");
    }
}


