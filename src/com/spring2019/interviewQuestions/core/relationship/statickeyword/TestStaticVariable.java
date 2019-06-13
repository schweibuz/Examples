package com.spring2019.interviewQuestions.core.relationship.statickeyword;

class TestStaticVariable {

    static {
        System.out.println("Static block is invoked");
    }

    public static void main(String[] args) {

        System.out.println("Main run");

        Student s1 = new Student(11, "First");
        Student s2 = new Student(22, "Second");
        Student s3 = new Student(33, "Third");

        s1.display();
        s2.display();
        s3.display();

        Student.change();

        s1.display();
        s2.display();
        s3.display();

        StudentSuper student2 = new StudentSuper(s1.rollno, s1.name);
        student2.display();

    }
}
