package com.spring2019.interviewQuestions.core.collections.chapter3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentEx<E> {
    public static void main(String[] args) {

        ConcurrentEx mode = new ConcurrentEx();
        mode.apply();
    }

    void apply() {
//        Set<Integer> hashSet = new HashSet();     //throw ConcurrentModificationException
        Set<Integer> hashSet = Collections.newSetFromMap(new ConcurrentHashMap<>());    //don't throw ConcurrentModificationException(elements order may change)
        for (int i = 0; i < 11; i++) {
            hashSet.add(i * i);
        }
        for (Integer e : hashSet) {
            if (e % 2 == 0) {
                hashSet.remove(e);
            }
        }

        Iterator iterator = hashSet.iterator();     //to avoid exception
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if ((int) element %2 == 0)
                iterator.remove();
        }
    }
}