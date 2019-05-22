package com.questions.work.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iMac on 29/10/2017.
 */
class EntrySetMap {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("First", "First");
        map.put("Second", "Second");
        System.out.println(map.entrySet());

    }
}
