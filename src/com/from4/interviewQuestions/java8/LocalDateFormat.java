package com.from4.interviewQuestions.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LocalDateFormat {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        String date = "16-Aug-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);  //default, print ISO_LOCAL_DATE

        System.out.println(formatter.format(localDate));

    }
}
