package com.from4.interviewQuestions.core.relationship.modificators;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ProtectedChild extends ProtectedClass {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        ProtectedClass protectedClass = new ProtectedClass();
        Class cls = protectedClass.getClass();

        System.out.println("mark: " + protectedClass.getMark());

        Constructor constructor = cls.getConstructor();
        System.out.println(constructor.getName());

        Method method = cls.getDeclaredMethod("getMark");
        System.out.println("getMark method value: " + method.invoke(protectedClass));

        Field field = cls.getDeclaredField("mark");
        field.setAccessible(true);
        field.set(protectedClass, "Nissan");
        System.out.println("value after apply reflection: " + method.invoke(protectedClass));

        ProtectedInnerClass protectedInnerClass = ProtectedInnerClass.getProtectedInnerClass();
        Class cls2 = protectedInnerClass.getClass();
        Field field2 = cls2.getDeclaredField("s");
        field2.setAccessible(true);
        field2.set(protectedInnerClass, "private field of ProtectedInnerClass after change ");
        Method method2 = cls2.getDeclaredMethod("getProtectedInnerClass");
        System.out.println(method2.invoke(protectedInnerClass));
        Method method3 = cls2.getDeclaredMethod("getProtectedInnerClass");
        System.out.println(method3.invoke(protectedInnerClass));

        Method methodS1 = cls2.getDeclaredMethod("getS");
        methodS1.setAccessible(true);
        System.out.println(methodS1.invoke(protectedInnerClass).hashCode());
        Method methodS2 = cls2.getDeclaredMethod("getS");
        methodS2.setAccessible(true);
        System.out.println(methodS2.invoke(protectedInnerClass).hashCode());

        System.out.println(methodS1.invoke(protectedInnerClass));

    }

}
