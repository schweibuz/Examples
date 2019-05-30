package com.spring2019.interviewQuestions.java8.functionalinterface;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Function<Long, Long> adder = new AddThree();
        Long result = adder.apply((long) 4);
        System.out.println(result);

        //can also implement the Function interface using lambda expression
        Function<Long, Long> adderLambda = (value) -> value + 3;
        Long resultLambda = adderLambda.apply((long) 4);
        System.out.println(resultLambda);

        IntPredicate intPredicate = a -> a > 5;
        System.out.println(intPredicate.test(4));

        IntBinaryOperator intBinaryOperator = (q, w) -> q * w;
        System.out.println(intBinaryOperator.applyAsInt(5, 10));

        IntConsumer intConsumer = e -> System.out.println(e);
        intConsumer.accept(21);

        BiConsumer biConsumer = (u, i) -> System.out.println(u + "–" + i);
        biConsumer.accept(3, 7);

        ToIntFunction toIntFunction = p -> p.hashCode();
        System.out.println(toIntFunction.applyAsInt(0.23f));

        UnaryOperator<String> unaryOperator = h -> h + " I'm here.";
        System.out.println(unaryOperator.apply("Hi there"));

        StringJoiner stringJoiner = new StringJoiner(".");
        stringJoiner.add("A").add("C");
        System.out.println(stringJoiner);

        Random random = new Random();
        random.ints().limit(10).forEach(i -> System.out.println(i));

        List<Integer> numbers = Arrays.asList(3, 2, 3, 2, 7, 4, 8, 12);
        List<Integer> squareList = numbers.stream().map(i -> i * i)
                .distinct().collect(Collectors.toList());
        System.out.println("SquareList:" + squareList);

        List<String> emptyStrings = Arrays.asList(" ", "Summer", "", "Winter", "");
        long n = emptyStrings.stream().filter(s -> s.isEmpty()).count();
        System.out.println(n);

        Stream<Integer> intLimit = squareList.stream().limit(3);
        List<Integer> intLimitList= intLimit.collect(Collectors.toList());
        System.out.println("Limit:" + intLimitList);

        squareList.stream().limit(10).sorted().forEach(s -> System.out.print(s + " "));

        long count = emptyStrings.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println("\nParallelSt count:" + count);

        List<Integer> num = squareList;
        IntSummaryStatistics stats = num.stream().mapToInt(v -> v).summaryStatistics();
        System.out.println("Highest number in list:" + stats.getMax());
        System.out.println("Lowest number in List:" + stats.getMin());
        System.out.println("Sum of all numbers:" + stats.getSum());
        System.out.println("Average of all numbers:" + stats.getAverage());



    }
}

class AddThree implements Function<Long, Long> {
    @Override
    public Long apply(Long aLong) {
        return aLong + 3;
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
