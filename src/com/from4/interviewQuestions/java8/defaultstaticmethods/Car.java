package com.from4.interviewQuestions.java8.defaultstaticmethods;

class Car implements Vehicle {

    @Override
    public void print() {
        Vehicle.super.print();
    }

    public static void main(String[] args) {

        Vehicle audi = new Car();
        audi.print();

        Vehicle.blowHorn();

        Car car = new Car();
        car.print();
    }
}
