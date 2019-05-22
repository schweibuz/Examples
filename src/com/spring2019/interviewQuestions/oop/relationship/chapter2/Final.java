package com.spring2019.interviewQuestions.oop.relationship.chapter2;

class Final {
    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        System.out.println(finalClass.str);
//        finalClass.str = "sdfsdf";
        finalClass.some();
    }

}

final class FinalClass {    //Don't inherit final class
     final String str;

    FinalClass() {
        str = "FinalClass";
    }

    public final void some() {  //Don't override methods of final class
        System.out.println(str);
    }
}
