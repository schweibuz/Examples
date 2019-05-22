package com.company.horstmannBP.Collections.listETC;

import java.util.*;
import java.util.List;

class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Natasha");
        a.add("Julia");
        a.add("Julia");

        List<String> b = new LinkedList<>();
        b.add("Alena");
        b.add("Anya");
        b.add("Anastasia");
        b.add("Arina");
        b.add("Julia");

        System.out.println(a);
        System.out.println(b);
        System.out.println();

        ListIterator<String> aListIter = a.listIterator();
        Iterator<String> bIterator = b.iterator();

        while (bIterator.hasNext()) {
            if (aListIter.hasNext()) {
                aListIter.next();
            }
            aListIter.add(bIterator.next());
        }
        System.out.println(a);

        bIterator = b.iterator();
        while (bIterator.hasNext()) {
            bIterator.next();
            if (bIterator.hasNext()) {
                bIterator.next();
                bIterator.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);

        while (bIterator.hasNext()) {
            System.out.println(bIterator.next());
        }
    }
}