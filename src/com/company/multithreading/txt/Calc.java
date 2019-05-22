package com.company.multithreading.txt;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Calc {
    public static void main(String[] args) {
        Calc calc = new Calc();

        System.out.println(calcText());
    }
    public static Set<String> calcText() {
        HashMap<String, Integer> countWords = new HashMap<>();

        BufferedReader br = null;

        try {

//            FileInputStream fstream = new FileInputStream("C:\\Users\\user123\\Desktop\\new.txt");
            FileInputStream fstream = new FileInputStream("/Users/iMac/Desktop/Stopi/stupni");

            br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            // bw.

            while ((strLine = br.readLine()) != null) {
                String words[] = strLine.replace(",", "").replace(".", "").replace("!", "").split(" ");
                for (String word : words) {
                    Integer count = countWords.get(word.toLowerCase());
                    if (count == null) {
                        count = 1;
                    } else {
                        count = count + 1;
                    }
                    countWords.put(word.toLowerCase(), count);
                }
            }

            ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>(countWords.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return -o1.getValue().compareTo(o2.getValue());
                }
            });

            //  Collections.

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptySet();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return countWords.keySet();
    }
}
