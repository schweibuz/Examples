package com.from4.interviewQuestions.java8.optional;

import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private int id;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    static List<User> createRoster() {
        List<User> roster = new ArrayList<>();
        roster.add(
                new User(1, "Phil"));
        roster.add(
                new User(2, "Bill"));
        roster.add(
                new User(3, "Ill"));
        return roster;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}