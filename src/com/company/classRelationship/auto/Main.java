package com.company.classRelationship.auto;

import java.util.Arrays;

import static java.util.Arrays.sort;

class Main {
    public static void main(String[] args) {

        Automobile auto = new Jeep(new GasolineEngine(240, 4),
                "Land Rover", "Black", 40000, true);
        Automobile auto2 = new Sedan(new ElectricEngine(362, 5),
                "Tesla", "Red", 350000, false);
        System.out.println(auto.toString() + " Tax: " + auto.calcTax(240)
                + "\n" + auto2.toString() + " Tax: " + auto2.calcTax(362));
        Automobile auto3 = new Sedan(new GasolineEngine(201, 4),
                "Honda", "Red", 10000, false);
        try {
            System.out.println(auto3.toString() + " Налог: " + auto3.calcTax(201));
            System.out.println("------------------------------");
        } catch (Exception e){
            System.err.println("ERROR code: " + e);
        }
        final Automobile[] automobiles = new Automobile[] {auto, auto2, auto3};
        Arrays.sort(automobiles);
//        System.out.println(Arrays.asList(automobiles));   //список
        for (Automobile v : automobiles)    //руками
            System.out.println(v);
        System.out.println();
        System.out.println(auto.equals(auto2));
        System.out.println(auto.toString());
        System.out.println(auto.hashCode());
    }
}