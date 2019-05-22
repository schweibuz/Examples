package com.questions.work.oop;

/**
 * Created by iMac on 27/10/2017.
 */
class Polymorphic implements SomeInterface {
    @Override
    public void printMethod(Object string) {
        System.out.println("Your string is: " + string);
    }

    @Override
    public Object someMethod(Object item) {
        return item + " " + 10;
    }

    public static Polymorphic getPolymorphic() {
        return new Polymorphic();
    }

    public static void main(String[] args) {
        Polymorphic poly = Polymorphic.getPolymorphic();
        poly.printMethod("hello world");
        System.out.println(poly.someMethod(10));
        System.out.println(poly.someMethod("Hello"));

        Polymorphic2 poly2 = new Polymorphic2();
        poly2.printMethod("hello world");
        System.out.println(poly2.someMethod(10));
        System.out.println(poly2.someMethod("Hello"));
    }
}

class Polymorphic2 implements SomeInterface {

    @Override
    public Object someMethod(Object item) {
        return item + " 卍";
    }

    @Override
    public void printMethod(Object string) {
        System.out.println(string + " 卍");
    }
}