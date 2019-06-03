package com.spring2019.interviewQuestions.core.relationship.chapter2;

import java.util.Scanner;

class OverrideDemo extends Over {
    public static void main(String[] args) {
        OverrideDemo demo = new OverrideDemo();
        Scanner scanner = new Scanner(System.in);
        String a, b;
        a = scanner.nextLine();
        b = scanner.nextLine();
        Integer c, d;
        c = demo.method(a, b);
        d = demo.method(a);
        System.out.println(c);
        System.out.println(d);

        Object obj = new Object();

        Over over = new Over();
        System.out.println(over.s + " " + over.x);
        demo.methodX(over);
        System.out.println(over.s + " " + over.x);

        int one = 1, two = 2;
        System.out.println(one + " " + two);
        demo.methodY(one, two);
        System.out.println(one + " " + two);


    }

    void methodX(Over over) {
        over.s += "X";
        over.x += 9;
    }

    void methodY(int one, int two) {
        one++;
        two++;
    }

    @Override
    public Integer method(String a, String b) { //make public, make type Downcast (Object -> Number -> Integer)
        try {
            return (Integer) super.method(a, b);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    public Integer method(String abc) {      //Overloading
        return (Integer) super.method(abc, String.valueOf(4));
    }

}

class Over {
    protected Number method(String a, String b) throws NumberFormatException {
        Number c = null;
        try {
            c = Integer.parseInt(a) * Integer.parseInt(b);
        } catch (NumberFormatException e) {
            System.err.println("Exception: " + e.getCause());
        }
        return c;
    }

    String s = "Object";
    int x = 10;
}
