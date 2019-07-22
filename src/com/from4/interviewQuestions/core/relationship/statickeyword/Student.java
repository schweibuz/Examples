package com.from4.interviewQuestions.core.relationship.statickeyword;

class Student {

    int rollno;
    String name;
    static String college = "ITS";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    static void change() {
        college = "BBDIT";
    }
}

