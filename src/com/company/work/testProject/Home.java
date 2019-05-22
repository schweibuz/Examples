package com.company.work.testProject;

/**
 * Created by iMac on 23.08.17.
 */
class Home implements Action {
    Employee homeow = new Employee.Builder().firstName("Sasha").lastName("Sushka").age(50).salary(40000).build();
    @Override
    public void coffee() {
        System.out.println("I'm no drunk coffee after 18 o'clock.");
    }

    @Override
    public void speak() {
        System.out.println("I need to sleep.");
    }

    @Override
    public void walk() {
        System.out.println("I'm in home.");
    }
}
