package com.spring2019.interviewQuestions.java8.defaultmethods;

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
