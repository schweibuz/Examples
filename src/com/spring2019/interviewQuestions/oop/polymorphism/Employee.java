package com.spring2019.interviewQuestions.oop.polymorphism;

class Employee implements Special {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck() {
        System.out.printf("Mailinтg a check to %s %s", this.name, this.address);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number;
    }

     String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

     int getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("SDf", "sdf", 3);
        employee.toString();
        employee.mailCheck();
    }

    @Override
    public void kiya() {
        System.out.println("kiya");
    }
}
