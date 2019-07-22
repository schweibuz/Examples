package com.from4.interviewQuestions.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LambdaSort {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Stone");
        list.add("Scissor");
        list.add("Paper");
        System.out.println(list);

        sortUsingJava8(list);
        System.out.println(list);

    }

    private static void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

}
