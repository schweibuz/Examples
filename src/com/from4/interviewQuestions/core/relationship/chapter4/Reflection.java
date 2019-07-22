package com.from4.interviewQuestions.core.relationship.chapter4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, NoSuchFieldException {

        Test obj = new Test();
        Class cls = obj.getClass();
        System.out.printf("The name of class is %s\n", cls.getName());

        Constructor constructor = cls.getConstructor();
        System.out.printf("The name of constructor is %s\n", constructor.getName());

        System.out.println("The public methods of class are : ");
        Method[] methods = cls.getMethods();
        for (Method method : methods)
            System.out.println(method.getName());

        Method methodCall1 = cls.getDeclaredMethod("method2", int.class);
        methodCall1.invoke(obj, 19);

        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);

        field.set(obj, "JAVA");

        Method methodcall2 = cls.getDeclaredMethod("method1");
        methodcall2.invoke(obj);


        Method methodcall3 = cls.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);

    }
}

class Test {

    private String s;

    public Test() {
        s = "GeeksforGeeks";
    }

    // Creating a public method with no arguments
    public void method1()  {
        System.out.println("The string is " + s);
    }

    // Creating a public method with int as argument
    public void method2(int n)  {
        System.out.println("The number is " + n);
    }

    // creating a private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}
