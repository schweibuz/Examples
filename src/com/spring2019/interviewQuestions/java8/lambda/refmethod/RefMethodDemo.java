package com.spring2019.interviewQuestions.java8.lambda.refmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class RefMethodDemo {
    public static void main(String[] args) {

        List<Bicycle> bicycles = Bicycle.createBicycles();
        bicycles.stream().sorted((a, b) -> Integer.compare(2, 3));

        List<Integer> nums = Arrays.asList(1, 44, 2, 65, 76, 33);
//        nums.stream().sorted().forEach(n -> System.out.print(n + " "));
        nums.stream().sorted(Integer::compare).forEach(a -> System.out.print(a + " "));

        System.out.println();
        bicycles.sort(Comparator.comparing(Bicycle::getCost));
//        bicycles.forEach(System.out::println);
        bicycles.forEach(s -> System.out.print(s));

        System.out.println("\n");
        //if this just calls one method, we can use a method reference
        bicycles.forEach(System.out::println);

    }
}
