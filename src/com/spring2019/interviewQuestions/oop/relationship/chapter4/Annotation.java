package com.spring2019.interviewQuestions.oop.relationship.chapter4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MMal(sound = "Check")
class Annotation {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Annotation annotation = new Annotation();

        Method m = annotation.getClass().getDeclaredMethod("say");
        MMal mMal = m.getAnnotation(MMal.class);
        System.out.println("method values is " + mMal.sound());
        System.out.println("method int values is " + mMal.value());

        Field f = annotation.getClass().getDeclaredField("str");
        MMal fMal = f.getAnnotation(MMal.class);
        System.out.println("field values is " + fMal.sound());
        System.out.println("field int values is " + fMal.value());

    }

    @MMal(sound = "Check to crack", value = 10)
    public void say() {
        System.out.println("hi it's me");
    }

    @MMal(sound = str)
    final String str = "Something worth";

}


@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})     //elements who can uses this annotation
@Retention(RetentionPolicy.RUNTIME)     //access to annotation on runtime
@interface MMal {
    String sound() default "crack";

    int value() default 0;
}