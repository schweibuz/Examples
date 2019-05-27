package com.spring2019.interviewQuestions.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LambdaL {
    public static void main(String[] args) {

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println(intList);

        Stream<Integer> intStream2 = Stream.of(1, 2, 3, 4, 5, 6);
        Integer[] integers = intStream2.toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));

        List<Integer> intList2 = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            intList2.add(i);
        intList2.stream()
                .filter(p -> p.intValue() % 2 == 0 || p.intValue() > 90)
                .forEach(p -> System.out.print(p + " "));

        System.out.println();
        Stream<String> names = Stream.of("AbS", "d", "eeeE");
        System.out.println(names.map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList()));

        intList2.stream()
                .filter(num -> num.intValue() % 3 == 0 && num.intValue() % 2 == 0)
                .forEach(item -> {
                    System.out.print(item.intValue());
                    System.out.print(" ");
                });
    }


}
