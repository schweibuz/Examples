package com.company.horstmannBP.generics.bloh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iMac on 02.07.17.
 */
class Article25 {
    static <E> E trulya(List<E> list, Function<E> f, E intVal) {
        List<E> snap;
        synchronized (list) {
            snap = new ArrayList<E>(list);
        }
        E result = intVal;
        for (E e : snap) {
            result = f.operation(e, result);
        }
        return result;
    }


    private static final Function<Integer> SUM = new Function<Integer>() {
        @Override
        public Integer operation(Integer t1, Integer t2) {
            return t1 + t2;
        }
    };
    private static final Function<Integer> MULTIPLY = new Function<Integer>() {
        @Override
        public Integer operation(Integer t1, Integer t2) {
            return t1 * t2;
        }
    };

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 7, 2, 1, 4, 9, 5);
        System.out.println(trulya(list, SUM, 0));
        System.out.println(trulya(list, MULTIPLY, 1));
    }
}

interface Function<T> {
    T operation(T t1, T t2);
}
