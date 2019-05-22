package com.company.generics;

import java.util.ArrayList;

/**
 * Created by iMac on 08.06.17.
 */
class GenericsTypeParameter {
}

class Class1<T extends A & Interface> {

    private <M extends Number> void print(M e, T t) {
        System.out.println("key" + e + " equal" + t);
//        try {
//            M m = (M) new Object();
//        } catch (ClassCastException e1) {
//            e1.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        Class1<A> c = new Class1<>();
        c.print(2, new A());

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(0, new A());

        ArrayList<String> strings = new ArrayList<>();
        int i = 5;
        while (i >= 0) {
            strings.add("A");
            strings.add("B");
            strings.add("C");
            i--;
        }
        for (String str : strings) {
            System.out.println(str);
        }
    }
}

interface Interface {
}

class A implements Interface {
    @Override
    public String toString() {
        return " Class A ";
    }
}

class B extends A implements Interface {
}