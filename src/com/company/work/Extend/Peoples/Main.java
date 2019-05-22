package com.company.work.Extend.Peoples;

/**
 * Created by iMac on 08/01/17.
 */
class Main {
    public static void main(String[] args) {

        People[] people = new People[3];
        people[0] = new People("Oliver Twist", 45, "man");
//        people[0].
        people[0].say();

        Sportsmen sportsmen = new Sportsmen();
        sportsmen.say();


        Politican politican = new Politican("Misha Ruchkin", 51, "man");
        politican.Corruption();
        politican.say();

        String s = people[0].toString();
        System.out.println(s + "\nMan: " + people[0].forSex("woman"));

        DriverBus t = new DriverBus();
        System.out.println(t.getSpeed());
//        t.setCategory("B");
        t.go();

        MethodExam methodExam = new MethodExam();
        String s1 = methodExam.get();
        String s2 = methodExam.get(10);
        String s3 = methodExam.get("G");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
