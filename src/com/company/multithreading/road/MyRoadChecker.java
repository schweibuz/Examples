package com.company.multithreading.road;

import java.io.*;
import java.util.Date;

class MyRoadChecker implements RoadChecker {

    @Override
    public int getRestrictedRoads(String fileName, Date date) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("H:\\JAVA\\Staff\\iO\\restrictions\\data.csv"));

            while (true) {
                String line = br.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getRestrictedRoads2(String fileName){
        try{
            BufferedReader tr = new BufferedReader(new FileReader("H:\\JAVA\\Staff\\iO\\restrictions\\data.csv"));

            String line = tr.readLine();
            for(String retval : line.split(",")) {
                System.out.println(retval);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}