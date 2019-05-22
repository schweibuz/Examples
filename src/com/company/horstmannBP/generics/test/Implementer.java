package com.company.horstmannBP.generics.test;

import java.util.*;

class Implementer {
    public static void main(String[] args) {
        Methods<Integer> ss = Algorithm.getElemen(13);
        Methods<String> string = new Methods<>("JOPA");
        System.out.println(ss);
        System.out.println(string);
        Methods<Integer> gg = Algorithm.compareContare(222, 22332);
        System.out.println(gg.getElement() + " " + gg.getElement2());

        List<String> list = new LinkedList<String>();
        list.add("First");
        list.add("Second");
        List list1 = list;
        for (Iterator<String> iterator = list1.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(22);
        list2.add(44);
        list2.add(66);
        System.out.println("Before handling " + list2);
        Algorithm.fillList(list2, 69);
        System.out.println("Hello, I'm change your ListTest " + list2);

        List<String> list3 = new ArrayList<String>();
        list3.add("Simple");
        list3.add("String");
        System.out.println("\nBefore handling " + list3);
        Algorithm.fillList(list3, "CHANGE");
        System.out.println("Hello, I'm change your ListTest " + list3);

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(12);
        list4.add(122);
        list4.add(212);
        Algorithm.printList(list4);
    }
}
class Algorithm {
    public static <T> Methods<T> getElemen(T t) {
        if (t == null)
            return null;
        return new Methods<T>(t);
    }

    public static <T extends Comparable> Methods<T> compareContare(T t, T p) {
        T min = t;
        T max = t;
        String str = "Numbers are equal";
        if (t.compareTo(p) == 0) {
            return new Methods<T>((T) str);
        } else if (t.compareTo(p) > 0) {
            max = t;
            min = p;
        } else {
            min = t;
            max = p;
        }
        return new Methods<T>(min, max);
    }

    public static <T> void fillList(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, val);
        }
    }

    public static void printList(List<? extends Number> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
