package com.from4.interviewQuestions.java8.lambda;
/*
https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class CheckPetListLambda {
    public static void main(String[] args) {

        List<Pet> petList = Pet.createPetList();
        System.out.println("With class who implements functional interface:");
        printPet(petList, new CheckPetClassForPet());

        System.out.println("\nAnonymous class:");
        printPet(petList, new CheckPet() {
            @Override
            public boolean check(Pet pet) {
                return pet.getWeight() <= 5 && pet.getSex() == Sex.FEMALE;
            }
        });

        System.out.println("\nLambda expression:");
        printPet(petList, (Pet pet) -> pet.getWeight() <= 6 && pet.getSex() == Sex.MALE);

        System.out.println("\nLambda expression with Predicate Functional Interface:");
        printPetWithPredicate(petList, (Pet pet) -> pet.getWeight() <= 6 && pet.getSex() == Sex.MALE);

        System.out.println("\nLambda expression with Predicate and Consumer:");
        processPet(petList, (Pet pet) -> pet.getWeight() >= 1 && pet.getSex() == Sex.FEMALE,
                pet -> pet.print());    //Pet::print

        SayMyName sayMyName = new CheckPetListLambda()::Heroid;
        sayMyName.say();

        Function<Integer, Double> function = x -> x / 2.0;
        function = function.andThen(x -> 3 * x);    //.compose() are equal
        System.out.println("function - andThen, apply " + function.apply(10));

        System.out.println("\nLambda expression with Predicate, Function and Consumer:");
        processPetWithFunction(petList, (Pet pet) -> pet.getWeight() <= 6 && pet.getSex() == Sex.MALE,
                pet -> String.valueOf(pet.getSex()), sex -> System.out.println(sex));

        System.out.println("\nLambda expression with generic types, Iterator and etc:");
        processElements(petList, pet -> pet.getAge() >= 4 && pet.getSex() == Sex.FEMALE,
                pet -> pet.getName(), s -> System.out.println(s));

        System.out.println("\nLambda expression with stream():");
        petList.stream()
                .filter(pet -> pet.getWeight() > 5 && pet.getAge() > 5)
                .map(pet -> pet.getName())
                .forEach(s -> System.out.println(s));


    }

    void Heroid() {     //example for reference method in main
        System.out.println("\nmethod reference HEr");
    }

    static void printPet(List<Pet> pet, CheckPet checkPet) {
        for (Pet p : pet) {
            if (checkPet.check(p)) {
                p.print();
            }
        }
    }

    static void printPetWithPredicate(List<Pet> pet, Predicate<Pet> tester) {
        for (Pet p : pet) {
            if (tester.test(p)) {   //instead CheckPet .check() method
                p.print();
            }
        }
    }

    static void processPet(List<Pet> pet, Predicate<Pet> tester, Consumer<Pet> block) {
        for (Pet p : pet) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    static void processPetWithFunction(
            List<Pet> pet,
            Predicate<Pet> tester,
            Function<Pet,String> mapper,
            Consumer<String> block) {
        for (Pet p : pet) {
            if (tester.test(p)){
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}

@FunctionalInterface
interface SayMyName {
    void say();
}

@FunctionalInterface
interface CheckPet {
    boolean check(Pet pet);
}

class CheckPetClassForPet implements CheckPet {
    @Override
    public boolean check(Pet pet) {
        return pet.getWeight() >= 5 && pet.getSex() == Sex.MALE;
    }
}