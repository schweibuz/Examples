package com.company.dataStruct.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by iMac on 26/10/2017.
 */
class HashMapNote {
    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key", "one");
        hashMap.put("idx", "two");

        //new elements adds with at start
        for (int i = 0; i < 10; i++)
            hashMap.put("" + i, "three");

//        for (int i = 0; i < 150; i++)
//            hashMap.remove("" + i);

        for (Map.Entry<String, String> entry : hashMap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());

        for (String key : hashMap.keySet())
            System.out.println(hashMap.get(key));

        Iterator<Map.Entry<String, String>> itr = hashMap.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        //Стоит помнить, что если в ходе работы итератора HashMap был изменен (без использования
        // собственным методов итератора), то результат перебора элементов будет непредсказуемым.

        //instead of use trimToSize (in ArrayList)
        hashMap = new HashMap<>(hashMap);

        System.out.println(hashMap);
    }
}
