package com.company.test;

import java.util.LinkedList;
import java.util.List;

class Hate {
    static List<Character> abc;
    static {
        abc = new LinkedList<Character>();
        for (char i = 'A'; i <= 'Z'; ++i)
            abc.add(i);
    }

    public static void main(String[] args) {
        System.out.println(abc);
    }
}
