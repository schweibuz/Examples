package com.from4.interviewQuestions.java8.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OptionalTest {

    public static void main(String[] args) {
        //ofNullable return Optional object, if haven't generic type return empty Optional-object
        Optional optional = Optional.ofNullable(roster.get(2));
        System.out.println(optional.toString());

        //return Optional-object
        Optional ofOptional = Optional.of(roster.get(0));   //may throw IndexOutOfBoundException
        System.out.println(ofOptional);

        //return empty Optional-object
        System.out.println(Optional.empty());

        roster.remove(2);
        //this method return boolean value
        if (optional.isPresent())
            print();

        //ifPresent() method allows carry out Consumer that returns no result
        Optional.of(roster.get(0)).ifPresent(System.out::println);

        String name = "Meal";
        Optional<String> optionalS = Optional.ofNullable(name);
        boolean isTrue = optionalS.isPresent();
        System.out.println("\nOptionals boolean:" + isTrue);
        System.out.println("Optionals:" + optionalS);
        optionalS.ifPresent(s -> System.out.println("Optionals.ifPresent:" + s));

        Optional<String> userOptional = Optional.ofNullable(findById(roster, 2));
        System.out.println("\n" + userOptional);
        System.out.println(userOptional.isPresent());
        userOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

        findUserAlfa();

        Optional<User> userOptional2 = Optional.of(findUser(roster, 2));
        System.out.println(userOptional2);

    }

    static List<User> roster = User.createRoster();
    private static User user;

    static Optional<User> findUserOptional(int id) {
        return Optional.ofNullable(findUser(roster, id));
    }

    static void findUserAlfa() {
        User foundUser = findUser(roster, 2);
        Optional<User> optionalUser = Optional.ofNullable(foundUser);
        //need wrap to .isPresent() construction because .get() return NPE(null)
        user = optionalUser.isPresent() ? optionalUser.get() : new User(3, "Will");
        System.out.println("\n" + user);
        System.out.println(roster);
    }

    static String findById(List<User> roster, int id) {
        Stream<String> stream = roster.stream()
                .filter(user -> user.getId() == id)
                .map(User::getName);
        String name = stream.collect(Collectors.joining());
        return name;
    }

    static User findUser(List<User> roster, int id) {
        List<User> user = roster.stream().filter(s -> s.getId() == id)
                .collect(Collectors.toList());
        if (user.size() != 1) {
            throw new IllegalArgumentException();
        }
        return user.get(0);
    }

    static void print() {
        System.out.println("Print because isPresent() == true");
    }
}
