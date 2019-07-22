package com.from4.interviewQuestions.core.relationship.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SimpleReflection {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException {

        Class clas = Class.forName(
                "com.from4.interviewQuestions.core.relationship.reflection.Simple");
        Simple simple = (Simple) clas.newInstance();
        System.out.println(simple);

        Field field = clas.getDeclaredField("string");
        field.setAccessible(true);
        System.out.println(field.get(simple));
        field.set(simple, "2st private field");
        System.out.println(field.get(simple));

        Method method = clas.getDeclaredMethod("someMethod");
        method.setAccessible(true);
        method.invoke(simple);

    }
}



class Simple {
    private String string = "1st private Field";

    private void someMethod() {
        System.out.println("Do work");
    }

}
