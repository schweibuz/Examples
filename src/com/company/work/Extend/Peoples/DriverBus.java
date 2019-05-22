package com.company.work.Extend.Peoples;

/**
 * Created by iMac on 09/01/17.
 */
class DriverBus implements Transport, Driver {

    private People people;
    private String category;
    private int speed = 60;

    @Override
    public void setCategory(String c) {
        this.category = c;
        people = new People("Bob", 45, null);
    }

    @Override
    public void go() {
        if (people != null){
            System.out.println("Go!!!");
        } else {
            System.out.println("Stoop!!!");
        }
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }
}
