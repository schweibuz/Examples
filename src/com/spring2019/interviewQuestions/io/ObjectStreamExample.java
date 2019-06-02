package com.spring2019.interviewQuestions.io;

import java.io.ObjectStreamClass;
import java.util.Calendar;

class ObjectStreamExample {
    public static void main(String[] args) {

        ObjectStreamClass osc = ObjectStreamClass.lookup(MyFile.class);

        System.out.println("" + osc.getField("sample"));

        ObjectStreamClass osc2 = ObjectStreamClass.lookup(String.class);

        System.out.println("" + osc2.getField("hash"));

        System.out.println("" + osc2.getField("value"));

        ObjectStreamClass osc3 = ObjectStreamClass.lookup(Calendar.class);

        System.out.println("" + osc3.getField("isTimeSet"));


    }
}