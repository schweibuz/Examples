package com.spring2019.interviewQuestions.oop.collections.chapter3;

import java.util.*;

class Maps<K, V> {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 0; i < 10; i++) {
            map.put(i, i * i);
        }
        System.out.println(map.toString());

        HashMap blankMap = new HashMap(3, 1);

        IdentityHashMap identityHashMap = new IdentityHashMap();
        identityHashMap.putAll(map);
        System.out.println(identityHashMap.toString());

        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.putAll(map);
        System.out.println(weakHashMap.toString());

        Set hashSet = new HashSet<>(map.keySet());
        System.out.println(hashSet.toString());

        Maps maps = new Maps();
        maps.hashSetToHashMap(map);


    }

    void hashSetToHashMap(Map map) {
        Set<Map.Entry<K, V>> set = map.entrySet();

        Map<K,V> hashMap = new HashMap<>();
        for (Map.Entry<K, V> entry : set)
            hashMap.put(entry.getKey(), entry.getValue());

        System.out.println("\n" + hashMap.toString());
    }
}
