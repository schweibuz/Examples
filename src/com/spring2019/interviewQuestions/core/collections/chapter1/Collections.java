package com.spring2019.interviewQuestions.core.collections.chapter1;

import java.util.*;

class Collections {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("ABC");
        set.add("CBA");
        set.add("BCA");
        set.add("ACC");
        List<String> list = new LinkedList<>(set);
        Iterator iterator = list.iterator();
        System.out.println("Set: ");
        while (iterator.hasNext())
            System.out.println(iterator.next());

        Set<String> set1 = new HashSet<>();
        set1.add("ABC");
        set1.add("CBA");
        set1.add("ACB");
        List<String> list1 = new ArrayList<>(set1);
        Iterator iterator1 = list1.iterator();
        System.out.println("\nSet1: ");
        while (iterator1.hasNext())
            System.out.println(iterator1.next());

        System.out.println("\nDiffSet: ");
        Set<String> setDiff = symmetricDivision(set, set1);
        Iterator diffIterator = setDiff.iterator();
        while (diffIterator.hasNext())
            System.out.println(diffIterator.next());

        Map<String, String> map = new HashMap<>();
        map.put("abdc", "abc");
        map.put("cbda", "cba");
        map.put("abda", "2cba");
        Iterator iteratorMap = map.keySet().iterator();     //return set of keys
        Iterator iteratorMap1 = map.entrySet().iterator();      //return mapping of key-values
        Iterator iteratorMap2 = map.values().iterator();
        System.out.println("\nMap: ");
        while (iteratorMap2.hasNext())
            System.out.println(iteratorMap2.next());

        System.out.println("\nArray of Objects: ");
        Object[] objects = map.values().toArray();
        for (Object obj : objects)
            System.out.println(obj);
    }

    public static <T> Set<T> symmetricDivision(Set<? extends T> set, Set<? extends T> set1) {
        Set intersection = new HashSet(set);
        intersection.retainAll(set1);
        Set result = new HashSet(set);
        result.addAll(set1);
        result.removeAll(intersection);

        return result;
    }
}
