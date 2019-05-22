package com.company.horstmannBP.Collections.listETC;

import java.io.*;
import java.util.*;

class SetTest {
    public static void main(String[] args) throws IOException {
        Set<String> words = new HashSet<>();

        long totalTime = 0;
        BufferedReader br = new BufferedReader(new FileReader("/Volumes/ExFAT64/JAVA/Staff/book.txt"));

        while (true) {
            String word = br.readLine();
            if (word == null) break;
//            System.out.println(line);
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;

        }
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//            String word = in.next();
//            long callTime = System.currentTimeMillis();
//            words.add(word);
//            callTime = System.currentTimeMillis() - callTime;
//            totalTime += callTime;
//        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
