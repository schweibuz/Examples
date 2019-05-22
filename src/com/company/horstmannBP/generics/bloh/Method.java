package com.company.horstmannBP.generics.bloh;

import java.util.*;

class SimpleMethod<T> {
    public static void main(String[] args) {
        Set<String> list = new HashSet<>(Arrays.asList("Jerry", "Tom", "Pavlovich"));
        Set<String> list2 = new HashSet<>(Arrays.asList("Larry", "Barry", "Marry"));
        Set<Integer> list4 = new HashSet<>(Arrays.asList(3, 4, 5, 23, 65));
        Set<Integer> list5 = new HashSet<>(Arrays.asList(3, 4, 5, 23, 65, 33));
//        Set<Object> ls= union(list, list4);
        Set<Number> ls = SimpleMethod.<Number> union(list4, list5);
        System.out.println(ls);

        List<String> list3 = new LinkedList<>(Arrays.asList("Hello", "World"));
        HashMap<String, List<String>> argMap = newHashMap();
        argMap.put("1", list3);
        System.out.println(argMap);

        List<String> as = Arrays.asList("Hello", "World", "Bitches");
        swap(as, 1, as.size() -1);
        System.out.println(as);
    }

    //ограничением этого метода является то, что все параметры,
    // как входные так и возвращаемые должны быть одного типа
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static <K, V>HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }
    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}

