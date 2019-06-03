package com.spring2019.interviewQuestions.core.polymorphism;

class Salary extends Employee {
    private double salary;

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        this.salary = salary;
    }

    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0)
        this.salary = newSalary;
    }

    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }

    @Override
    public void kiya() {
        System.out.println("kiya salary");
    }
}
