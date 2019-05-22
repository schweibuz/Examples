package com.questions.work.collections;

import java.util.*;

/**
 * Created by iMac on 29/10/2017.
 */
class Collection<T> {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        System.out.println(list);

        String[] strArray = list.toArray(new String[list.size()]);  //copy to array
        System.out.println(strArray[0]);
        Object[] objArray = list.toArray();
        System.out.println(objArray[0]);

        List<String> a = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> b = new ArrayList<>(Arrays.asList("3", "4", "5", "6", "7"));
        List<String> c = symmetricDifference(a, b);
        System.out.println("Collection a: " + Arrays.toString(a.toArray()));
        System.out.println("Collection b: " + Arrays.toString(b.toArray()));
        System.out.println("Collection c: " + Arrays.toString(c.toArray()));

        ListIterator iter = a.listIterator();
        System.out.println(iter.next());
        iter.next();
        iter.remove();
        iter.previous();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        List<String> d = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        List<String> e = d.subList(2, d.size() - 2);
        System.out.println("\nsubList: " + e);

        Set<Object> keySet = new HashSet<>();
        keySet.add("String");
        keySet.add("Integer");
        Map<Object, Object> map = new HashMap<>();
        for (Object entry : keySet)
            map.put(entry, entry);
        System.out.println(map);

        Map<String, List<String>> map2 = new HashMap<>();
        map2.put("Kotovods", Arrays.asList("Archi", "Borya", "Barsik"));
        System.out.println(map2);

//        Listest set = Arrays.asList("1", "2", "3");  //UnsupportedOperationException
//        Iterator<String> iter2 = set.iterator();
//        while (iter2.hasNext()) {
//            String cur = iter2.next();
//            if ("2".equals(cur)) {
//                iter2.remove();
//            }
//        }
    }

    //Symmetric difference of two collections
    public static <T> List<T> symmetricDifference(List<T> a, List<T> b) {
        List<T> intersection = new ArrayList<T>(a);
        intersection.retainAll(b);
        List<T> result = new ArrayList<T>(b);
        result.addAll(a);
        result.removeAll(intersection);
        return result;
    }
}
