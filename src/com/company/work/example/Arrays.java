package com.company.work.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user123 on 24.12.2016.
 */
class Arrays {
    public static void main(String[] args) {

        Arrays arrays = new Arrays();
        arrays.toArray();

        List<String> list = new ArrayList<String>();
        for(int i = 0; i < 16; i++) {
            list.add(String.valueOf(i + 1));
        }
        String str = "Ja";
        System.out.println(list.size());
        System.out.println(list.get(7));
        list.set(7, str);
        System.out.println(list.get(7));
        System.out.println(list.contains(str));
        list.remove(str);
        System.out.println(list.size());
        System.out.println(list.contains(str));
        for (String st : list)
            System.out.print(st + " ");
        System.out.println();

        List<Integer> list3 = new ArrayList<>();
        for(int i = 0; i < 16; i++)
            list3.add(i);

        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < 16; i++)
            list2.add(i);
        System.out.println(list2);
        for (Integer integer : list2)
            if (integer % 2 == 0)
                list2.set(integer, null);
        list2.addAll(4, list3);

        System.out.println(list2);


    }

    public void toArray() {
        final int NMAX = 10;
        int[][] odds = new int[NMAX][];
        for (int n = 0; n < NMAX; n++) {
            odds[n] = new int[n + 1];
        }
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                    odds[n][k] = lotteryOdds;
                }
            }
        }
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
        System.out.println(java.util.Arrays.deepToString(odds));
    }
}
