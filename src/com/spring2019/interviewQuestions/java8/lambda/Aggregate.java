package com.spring2019.interviewQuestions.java8.lambda;

import java.util.List;

class Aggregate {
    public static void main(String[] args) {
        List<Pet> petList = Pet.createPetList();

        for (Pet p : petList) {
            System.out.println(p.getName());
        }

        petList.stream()
                .forEach(x -> System.out.println(x.getName()));


    }
}
