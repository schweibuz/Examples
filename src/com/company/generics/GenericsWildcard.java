package com.company.generics;

import java.util.ArrayList;
import java.util.List;

class GenericsWildcard {
}
/*
PECS (Producer(read (out)) extends, Consumer(write (in)) super)
очень гибкое апи не привязаны ни к чему
 */
class Generics2<T> {

    public void copy(List<? extends T> src, List<? super T> dst) {
//        src.get(0);
//        dst.add(new F());
        dst.addAll(src);
    }

    public static void main(String[] args) {
        Generics2<Number> g = new Generics2<>();

        List<Integer> src = new ArrayList<>();
//        src.add(new F());
//        src.add(new F());
//        src.add(new Generics01());
        src.add(1);
        src.add(2);

        List<Number> dst = new ArrayList<>();
        g.copy(src, dst);

        System.out.println(dst.size());
    }
}

class Generics01 {}

class F extends Generics01 {}