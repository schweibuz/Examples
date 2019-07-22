package com.from4.interviewQuestions.java8.lambda;
/*
https://docs.oracle.com/javase/tutorial/collections/streams/index.html
 */

import java.util.List;

class Aggregate {
    public static void main(String[] args) {
        List<Pet> petList = Pet.createPetList();

        System.out.println("For each:");
        for (Pet p : petList) {
            System.out.println(p.getName());
        }

        System.out.println("Stream:");
        petList.stream()
                .forEach(x -> System.out.println(x.getName()));

        System.out.println("Stream male only:");
        petList.stream()
                .filter(pet -> pet.getSex() == Sex.MALE)
                .forEach(x -> System.out.println(x.getName()));

        System.out.println("For each male only:");
        for (Pet p : petList) {
            if (p.getSex() == Sex.MALE) {
                System.out.println(p.getName());
            }
        }

        System.out.println("Stream average age of all:");
        double average = petList.stream()
                .filter(pet -> pet.getSex() == Sex.MALE)
                .mapToInt(Pet::getAge)
                .average()
                .getAsDouble();
        System.out.println(average);



    }
}