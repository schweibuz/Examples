package com.company.horstmannBP.generics.pair;

/**
 * Created by iMac on 23.06.17.
 */
class PairTest {
    public static void main(String[] args) {
        String[] words = {"mary", "sddd", "fucker", "mac", "dd"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

    }
}
class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
            if (a == null || a.length == 0)
                return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
            if (max.compareTo(a[i]) < 0)
                max = a[i];;
        }
        return new Pair<>(min, max);
    }
}
