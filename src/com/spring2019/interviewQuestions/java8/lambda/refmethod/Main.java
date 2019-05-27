package com.spring2019.interviewQuestions.java8.lambda.refmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class Main {
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

        Function<String, String> trim = String::trim;
        String str = trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");
        System.out.println(str);

        Consumer<Integer> consumer = (y) ->
        {
            System.out.println("y = " + y);
            System.out.println("y * y = " + y * y);
        };
        consumer.accept(6);
    }
}
