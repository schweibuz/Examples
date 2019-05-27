package com.spring2019.interviewQuestions.java8.lambda.refmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Bicycle{

    private String brand;
    private int weight;
    private Integer cost;

    Bicycle(String brand, int weight, int cost) {
        this.brand = brand;
        this.weight = weight;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    static List<Bicycle> createBicycles() {
        List<Bicycle> bicycles = new ArrayList<>();
        bicycles.add(new Bicycle("Giant", 3, 25000));
        bicycles.add(new Bicycle("Cannondale", 5, 35000));
        bicycles.add(new Bicycle("Stells", 7, 15000));
        return bicycles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return weight == bicycle.weight &&
                Objects.equals(brand, bicycle.brand) &&
                Objects.equals(cost, bicycle.cost);
    }

    @Override
    public int hashCode() {
        int hashcode;
        hashcode = brand != null ? brand.hashCode() : 0;
        hashcode += (cost * 31 + weight);
        return hashcode;
    }

    @Override
    public String toString() {
        return "Bicycle[" + brand +
                ", weight:" + weight +
                ", cost:" + cost +
                "] ";
    }
}
