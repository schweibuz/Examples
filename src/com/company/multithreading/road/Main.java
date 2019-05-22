package com.company.multithreading.road;

import java.io.IOException;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        System.out.println(calendar.getTime());
        RoadChecker roadChecker = new MyRoadChecker();
        int count = roadChecker.getRestrictedRoads("H:\\JAVA\\Staff\\iO\\restrictions\\data.csv", calendar.getTime());
        int count2 = roadChecker.getRestrictedRoads2("H:\\JAVA\\Staff\\iO\\restrictions\\data.csv");
        System.out.println(count);
        System.out.println(count2);
    }
}
