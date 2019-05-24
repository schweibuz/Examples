package com.spring2019.interviewQuestions.java8.lambda;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

class Pet {
    private String name;
    private int weight;
    private Sex sex;
    private LocalDate localDate;

    Pet(String name, int weight, Sex sex, LocalDate localDate) {
        this.name = name;
        this.weight = weight;
        this.sex = sex;
        this.localDate = localDate;
    }

    public int getAge() {
        return localDate
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public static List<Pet> createPetList() {
        List<Pet> petList = new ArrayList<>();
        petList.add(
                new Pet("Finik", 2, Sex.FEMALE,
                        IsoChronology.INSTANCE.date(2015, 5, 9))
        );
        petList.add(
                new Pet("Vasik", 6, Sex.MALE,
                        IsoChronology.INSTANCE.date(2012, 12, 7))
        );
        petList.add(
                new Pet("Met", 7, Sex.FEMALE,
                        IsoChronology.INSTANCE.date(2008, 9, 14))
        );
        return petList;
    }

    public void print() {
        System.out.println("name:" + name + ", weight:" + weight + ", sex:" + sex + ", years old:"
                + getAge());
    }
}