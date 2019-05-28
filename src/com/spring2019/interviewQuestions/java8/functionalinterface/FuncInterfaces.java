package com.spring2019.interviewQuestions.java8.functionalinterface;

import java.util.function.*;

class FuncInterfaces {
    public static void main(String[] args) {

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

        Consumer<Integer> consumer1 = System.out::println;
        consumer1.accept(5);

        BiConsumer<Integer, Integer> consumer2 = (x, y) -> System.out.println(x + y);
        consumer2.accept(3, 5);

        BiFunction<Integer, Integer, Integer> function = Operation::operate;
        System.out.println("modulo: " + function.apply(100, 7));

        BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;
        System.out.println(binaryOperator.apply(100, 55));

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;
        System.out.println("biPredicate: " + biPredicate.test(5, 10));

        //supplier of boolean-valued results
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());
        int x = 0, y = 1;
        booleanSupplier = () -> x > y;
        System.out.println(booleanSupplier.getAsBoolean());

        MyFunctionalInterface functionalInterface = z -> System.out.println(z);
        functionalInterface.add(99);
    }
}

@FunctionalInterface
interface MyFunctionalInterface {
    void add(int x);
}

class Operation {
    static int operate(int a, int b) {
        return a % b;
    }
}
